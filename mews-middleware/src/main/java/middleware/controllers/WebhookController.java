package middleware.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.configurations.ApplicationConfiguration;
import middleware.entity.Log;
import middleware.enums.Status;
import middleware.models.*;
import middleware.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Component
@RestController
@RequestMapping("/mews")
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);
    private SalesforceController salesforceController;
    private ApplicationConfiguration applicationConfiguration;
    private MewsController mewsController;
    private AuthController authController;
    private SecretKeyManagerController secretKeyManagerController;
    private SalesforceConnectorService salesforceConnectorService;
    private MewsConnectorService MewsConnectorService;

    private CacheService cacheService;
    private final ApplicationContext context;

    private Status status;
    @Autowired
    public void CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public WebhookController(ApplicationContext context) {
        this.salesforceConnectorService = new SalesforceConnectorService(applicationConfiguration);
        this.MewsConnectorService = new MewsConnectorService();
        this.mewsController = new MewsController(this.MewsConnectorService);
        this.secretKeyManagerController = new SecretKeyManagerController();
        this.salesforceController = new SalesforceController(this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(applicationConfiguration, this.secretKeyManagerController,this.salesforceConnectorService);
        this.context = context;
    }

    @GetMapping("/logs/")
    public List<Log> getAllLogs() {
        List<Log> logs = cacheService.getAllLogs();
        return logs;
    }
    @GetMapping("/booking/")
    public List<Log> executeProcess() {
        List<Log> logs = cacheService.getAllLogs();
        return logs;
    }

    public MewsCompanyResponse addCompanyInMews(MewsCompanyRequest payload) throws Exception {
        String response = mewsController.addCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        logger.info("Mews Company Response: " + response);

        return parseResponse(response, MewsCompanyResponse.class);
    }

    public MewsBookerResponse addBookerInMews(MewsBookerRequest payload) throws Exception {
        String response = mewsController.addBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Booker response from Mews.");
        }

        logger.info("Mews Booker Response: " + response);

        return parseResponse(response, MewsBookerResponse.class);
    }

    public MewsAvailabilityBlockResponse addAvailabilityBlockInMews(MewsAvailabilityBlockRequest payload) throws Exception {
        String response = mewsController.addAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Availability Block response from Mews.");
        }

        logger.info("Mews Availability Block Response: " + response);

        return parseResponse(response, MewsAvailabilityBlockResponse.class);
    }

    //MEWS response parser
    private <T> T parseResponse(String response, Class<T> responseType) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode responseJson = objectMapper.readTree(response);

        if (responseJson.has("error")) {
            String errorMessage = responseJson.get("error").asText();
            throw new Exception("Error in " + responseType.getSimpleName() + " response from Mews: " + errorMessage);
        }

        try {
            return objectMapper.readValue(response, responseType);
        } catch (IOException e) {
            throw new Exception("Unable to parse " + responseType.getSimpleName() + " Response", e);
        }
    }

    private <T> T retrieveAndParseResponse(String parameter, Class<T> responseClass, String object) throws Exception {
        SalesforceTokenResponse salesforceToken = retrieveSalesforceToken();
        CacheService cacheService = context.getBean(CacheService.class);
        String response = salesforceController.getRecordFromSalesforce(
                object,
                salesforceToken.getAccess_token(),
                parameter
        );

        System.out.println(responseClass.getSimpleName() + " response: " + response);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Salesforce " + responseClass.getSimpleName() + " response.");
        }

        checkForErrorResponse(response); // Check for API errors

        logger.info("Salesforce " + responseClass.getSimpleName() + " Response: " + response);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Log log = new Log();
            log.setObject("Booking");
            T parsedResponse = objectMapper.readValue(response, responseClass);
            String payload = objectMapper.writeValueAsString(parsedResponse);
            log.setPayload(payload);

            log.setError("");
            log.setStatus(String.valueOf(status.SUCCESS));
            log.setStatus_code("200");
            cacheService.addLog(log);
            // Parse the response
            return objectMapper.readValue(response, responseClass);
        } catch (IOException e) {
            throw new Exception("Unable to parse Salesforce " + responseClass.getSimpleName() + " Response", e);
        }
    }

    // Getting Salesforce Token
    private SalesforceTokenResponse retrieveSalesforceToken() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }
        return salesforceToken;
    }

    // Check Salesforce Response for error
    private void checkForErrorResponse(String response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response);
        if (jsonResponse.has("error")) {
            String errorMessage = jsonResponse.get("error").asText();
            String message = jsonResponse.get("message").asText();
            throw new Exception("Salesforce API error: " + errorMessage + " - " + message);
        }
    }
}
