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
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = {"${cross.origin}"}) //It's better to configure this in the application properties
@RestController
@RequestMapping("/mews")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final ApplicationContext context;
    private final ApplicationConfiguration applicationConfiguration;
    private final SalesforceConnectorService salesforceConnectorService;
    private final MewsConnectorService mewsConnectorService;
    private final MewsController mewsController;
    private final SecretKeyManagerController secretKeyManagerController;
    private final SalesforceController salesforceController;
    private final AuthController authController;
    private final ObjectMapper objectMapper;

    private Status status;

    @Autowired
    public WebhookController(ApplicationContext context, SalesforceConnectorService salesforceConnectorService,
                             MewsConnectorService mewsConnectorService, SecretKeyManagerController secretKeyManagerController,
                             ApplicationConfiguration applicationConfiguration, ObjectMapper objectMapper) {
        this.context = context;
        this.salesforceConnectorService = salesforceConnectorService;
        this.mewsConnectorService = mewsConnectorService;
        this.secretKeyManagerController = secretKeyManagerController;
        this.applicationConfiguration = applicationConfiguration;
        this.objectMapper = objectMapper;
        this.mewsController = new MewsController(this.mewsConnectorService);
        this.salesforceController = new SalesforceController(applicationConfiguration,this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(applicationConfiguration, this.secretKeyManagerController,this.salesforceConnectorService);
    }
    @PostMapping("/booking/")
    public String executeProcess(@RequestBody String requestBody) {
        try {
            JsonNode jsonNode = objectMapper.readTree(requestBody);

            String bookingId = jsonNode.has("bookingId") ? jsonNode.get("bookingId").asText() : null;
            if (bookingId != null) {
                logger.info("Booking Id: " + bookingId);

                SalesforceBookingResponse booking = retrieveAndParseResponse(bookingId, SalesforceBookingResponse.class, applicationConfiguration.getSalesforceBookingObject());

                SalesforceAccountResponse account = retrieveAndParseResponse(booking.getThn__Company__c(), SalesforceAccountResponse.class, applicationConfiguration.getSalesforceAccountObject());

                SalesforceContactResponse contact = retrieveAndParseResponse(booking.getThn__Company_Contact__c(), SalesforceContactResponse.class, applicationConfiguration.getSalesforceCompanyContactObject());

                SalesforceRateResponse rate = retrieveAndParseResponse(booking.getThn__Block_Rate__c(), SalesforceRateResponse.class, applicationConfiguration.getSalesforceRateObject());

                SalesforcePropertyResponse property = retrieveAndParseResponse(rate.getHotel(), SalesforcePropertyResponse.class, applicationConfiguration.getSalesforcePropertyObject());

                MewsCompanyRequest mewsCompanyRequest = this.mewsController.createCompanyPayload(booking,account,contact);

                MewsCompanyResponse mewsCompanyResponse = this.addCompanyInMews(mewsCompanyRequest);

                MewsBookerRequest mewsBookerRequest = this.mewsController.createBookerPayload(booking,account,contact);

                MewsBookerResponse  booker = this.addBookerInMews(mewsBookerRequest);

                MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = this.mewsController.createAvailabilityBlockPayload(booking,rate,property,booker);

                MewsAvailabilityBlockResponse availabilityBlock = this.addAvailabilityBlockInMews(mewsAvailabilityBlockRequest);

                MewsUpdateAvailabilityRequest mewsUpdateAvailabilityRequest = this.mewsController.createUpdateAvailabilityPayload(booking,rate,property,booker);

                this.mewsController.updateAvailability(mewsUpdateAvailabilityRequest);

                MewsUpdateRateRequest mewsUpdateRateRequest = this.mewsController.createUpdateRatePayload(booking,rate,property,booker);

                this.mewsController.updateRate(mewsUpdateRateRequest);

            } else {
                logger.info("Request body does not contain booking Id");
                return "Failed"; // return a failure response if bookingId is not provided
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return "Success";
    }

    public MewsCompanyResponse addCompanyInMews(MewsCompanyRequest payload) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CacheService cacheService = context.getBean(CacheService.class);

        Log log = new Log();
        log.setObject("Company Request");

        String payloadJson = objectMapper.writeValueAsString(payload);
        log.setPayload(payloadJson);

        log.setError("");
        log.setStatus(String.valueOf(status.SUCCESS));
        log.setStatus_code("200");
        cacheService.addLog(log);

        String response = mewsController.addCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        logger.info("Mews Company Response: " + response);

        return parseResponse(response, MewsCompanyResponse.class,"Company Response");
    }

    public MewsBookerResponse addBookerInMews(MewsBookerRequest payload) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        CacheService cacheService = context.getBean(CacheService.class);
        Log log = new Log();
        log.setObject("Booker Request");

        String payloadJson = objectMapper.writeValueAsString(payload);
        log.setPayload(payloadJson);

        log.setError("");
        log.setStatus(String.valueOf(status.SUCCESS));
        log.setStatus_code("200");
        cacheService.addLog(log);
        String response = mewsController.addBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Booker response from Mews.");
        }

        logger.info("Mews Booker Response: " + response);

        return parseResponse(response, MewsBookerResponse.class,"Booker Response");
    }

    public MewsAvailabilityBlockResponse addAvailabilityBlockInMews(MewsAvailabilityBlockRequest payload) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        CacheService cacheService = context.getBean(CacheService.class);
        Log log = new Log();
        log.setObject("Availability Block Request");

        String payloadJson = objectMapper.writeValueAsString(payload);
        log.setPayload(payloadJson);

        log.setError("");
        log.setStatus(String.valueOf(status.SUCCESS));
        log.setStatus_code("200");
        cacheService.addLog(log);

        String response = mewsController.addAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Availability Block response from Mews.");
        }

        logger.info("Mews Availability Block Response: " + response);

        return parseResponse(response, MewsAvailabilityBlockResponse.class,"Availability Block Response");
    }

    //MEWS response parser
    private <T> T parseResponse(String response, Class<T> responseType,String Object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CacheService cacheService = context.getBean(CacheService.class);
        JsonNode responseJson = objectMapper.readTree(response);
        Log log = new Log();
        if (responseJson.has("error")) {
            String errorMessage = responseJson.get("error").asText();

            log.setObject(Object);
            T parsedResponse = objectMapper.readValue(response, responseType);
            String payload = objectMapper.writeValueAsString(parsedResponse);
            log.setPayload(payload);
            log.setError(errorMessage);
            log.setStatus(String.valueOf(status.FAILED));
            log.setStatus_code("400");
            cacheService.addLog(log);
            throw new Exception("Error in " + responseType.getSimpleName() + " response from Mews: " + errorMessage);

        }

        try {

            log.setObject(Object);
            T parsedResponse = objectMapper.readValue(response, responseType);
            String payload = objectMapper.writeValueAsString(parsedResponse);
            log.setPayload(payload);
            log.setError("");
            log.setStatus(String.valueOf(status.SUCCESS));
            log.setStatus_code("200");
            cacheService.addLog(log);

            return objectMapper.readValue(response, responseType);
        } catch (IOException e) {
            throw new Exception("Unable to parse " + responseType.getSimpleName() + " Response", e);
        }
    }

    private <T> T retrieveAndParseResponse(String parameter, Class<T> responseClass, String object) throws Exception {
        SalesforceTokenResponse salesforceToken = retrieveSalesforceToken();

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
