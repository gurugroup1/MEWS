package middleware.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

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

    private final CacheService cacheService;
    private Status status;

    @Autowired
    public WebhookController(ApplicationContext context, SalesforceConnectorService salesforceConnectorService,
                             MewsConnectorService mewsConnectorService, SecretKeyManagerController secretKeyManagerController,
                             ApplicationConfiguration applicationConfiguration, ObjectMapper objectMapper,CacheService cacheService) {
        this.context = context;
        this.salesforceConnectorService = salesforceConnectorService;
        this.mewsConnectorService = mewsConnectorService;
        this.secretKeyManagerController = secretKeyManagerController;
        this.applicationConfiguration = applicationConfiguration;
        this.objectMapper = objectMapper;
        this.mewsController = new MewsController(this.mewsConnectorService);
        this.salesforceController = new SalesforceController(applicationConfiguration,this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(applicationConfiguration, this.secretKeyManagerController,this.salesforceConnectorService);
        this.cacheService = cacheService;

    }
    @PostMapping("/booking/")
    public String executeProcess(@RequestBody String requestBody) {
        try {
            JsonNode jsonNode = objectMapper.readTree(requestBody);
            String bookingId = jsonNode.has("bookingId") ? jsonNode.get("bookingId").asText() : null;
            if (bookingId != null) {
                logger.info("Booking Id: " + bookingId);

                Optional<SalesforceBookingResponse> booking = retrieveAndParseResponse(bookingId, SalesforceBookingResponse.class, applicationConfiguration.getSalesforceBookingObject());
                if(booking.isPresent()) {
                    setResponseAPI("Booking",bookingId,requestBody, booking.get(),"Salesforce","Success","None");
                } else {
                    setResponseAPI("Booking",bookingId,requestBody, null,"Salesforce","Failed","Error retrieving or parsing Salesforce Booking Response");
                    logger.error("Error retrieving or parsing Salesforce Booking Response");
                }
            } else {
                logger.info("Request body does not contain booking Id");
                return "Failed"; // return a failure response if bookingId is not provided
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return "Success";
    }



    public String setResponseAPI(String object, String bookingId, String request, SalesforceBookingResponse response, String source, String status, String error) {
        APIResponse apiResponse = new APIResponse();
        APIResponse.BookingDetails bookingDetails = new APIResponse.BookingDetails();
        bookingDetails.setRequest(request);
        bookingDetails.setResponse(response);
        bookingDetails.setSource(source);
        bookingDetails.setStatus(status);
        bookingDetails.setError(error);

        apiResponse.setBookingDetails(bookingDetails);
        apiResponse.setBookingId(bookingId);
        apiResponse.setStatus(status);

        apiResponse.setCreatedDate(getTimeNow());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(apiResponse);
            System.out.println("API Response:");
            System.out.println(jsonResponse);

            // Create new Log and save it to the repository
            Log newLog = new Log();
            newLog.setApiResponse(jsonResponse); // Set API response
            // Set other fields of the Log...
            cacheService.addLog(newLog); // Assume cacheService is injected
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "null";
    }

    public String getTimeNow(){
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ISO_DATE);
        return formattedDate;
    }

    private <T> Optional<T> retrieveAndParseResponse(String parameter, Class<T> responseClass, String object) {
        try {
            SalesforceTokenResponse salesforceToken = retrieveSalesforceToken();

            String response = salesforceController.getRecordFromSalesforce(
                    object,
                    salesforceToken.getAccess_token(),
                    parameter
            );

            System.out.println(responseClass.getSimpleName() + " response: " + response);

            if (response == null || response.isEmpty()) {
                logger.error("Empty Salesforce " + responseClass.getSimpleName() + " response.");
                return Optional.empty();
            }

            // Check for API errors
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response);
            if (jsonResponse.has("error")) {
                String errorMessage = jsonResponse.get("error").asText();
                String message = jsonResponse.get("message").asText();
                logger.error("Salesforce API error: " + errorMessage + " - " + message);
                return Optional.empty();
            }

            logger.info("Salesforce " + responseClass.getSimpleName() + " Response: " + response);

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseClass);
            return Optional.ofNullable(parsedResponse);
        } catch (Exception e) {
            logger.error("Error retrieving and parsing response", e);
            return Optional.empty();
        }
    }


    private void checkForErrorResponse(String response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response);
        if (jsonResponse.has("error")) {
            String errorMessage = jsonResponse.get("error").asText();
            String message = jsonResponse.get("message").asText();
            throw new Exception("Salesforce API error: " + errorMessage + " - " + message);
        }
    }

    private SalesforceTokenResponse retrieveSalesforceToken() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }
        return salesforceToken;
    }

}
