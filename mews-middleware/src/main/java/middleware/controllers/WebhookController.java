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
import java.util.Objects;
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

    @Autowired
    public WebhookController(ApplicationContext context, SalesforceConnectorService salesforceConnectorService,
                             MewsConnectorService mewsConnectorService, SecretKeyManagerController secretKeyManagerController,
                             ApplicationConfiguration applicationConfiguration, ObjectMapper objectMapper, CacheService cacheService) {
        this.context = context;
        this.salesforceConnectorService = salesforceConnectorService;
        this.mewsConnectorService = mewsConnectorService;
        this.secretKeyManagerController = secretKeyManagerController;
        this.applicationConfiguration = applicationConfiguration;
        this.objectMapper = objectMapper;
        this.mewsController = new MewsController(this.mewsConnectorService);
        this.salesforceController = new SalesforceController(applicationConfiguration, this.secretKeyManagerController, this.salesforceConnectorService);
        this.authController = new AuthController(applicationConfiguration, this.secretKeyManagerController, this.salesforceConnectorService);
        this.cacheService = cacheService;
    }

    @PostMapping("/booking/")
    public String executeProcess(@RequestBody String requestBody) {
        try {
            APIResponse apiResponse = new APIResponse();
            JsonNode jsonNode = objectMapper.readTree(requestBody);
            String bookingId = jsonNode.has("bookingId") ? jsonNode.get("bookingId").asText() : null;
            if (bookingId != null) {
                logger.info("Booking Id: " + bookingId);

                Optional<SalesforceBookingResponse> booking = retrieveAndParseResponse(bookingId, SalesforceBookingResponse.class, applicationConfiguration.getSalesforceBookingObject());
                if (booking.isPresent()) {
                    setResponseAPI("Booking", bookingId, requestBody, booking.get(), "Salesforce", "Success", "None", apiResponse);
                    Optional<SalesforceAccountResponse> account = retrieveAndParseResponse(booking.get().getThn__Company__c(), SalesforceAccountResponse.class, applicationConfiguration.getSalesforceAccountObject());
                    if (account.isPresent()) {
                        setResponseAPI("Account", bookingId, booking.get().getThn__Company_Contact__c(), account.get(), "Salesforce", "Success", "None", apiResponse);
                        Optional<SalesforceContactResponse> contact = retrieveAndParseResponse(booking.get().getThn__Company_Contact__c(), SalesforceContactResponse.class, applicationConfiguration.getSalesforceCompanyContactObject());
                        if (contact.isPresent()) {
                            setResponseAPI("Contact", bookingId, booking.get().getThn__Company_Contact__c(), contact.get(), "Salesforce", "Success", "None", apiResponse);
                            Optional<SalesforceRateResponse> rate = retrieveAndParseResponse(booking.get().getThn__Block_Rate__c(), SalesforceRateResponse.class, applicationConfiguration.getSalesforceRateObject());
                            if (rate.isPresent()) {
                                setResponseAPI("Rate", bookingId, booking.get().getThn__Block_Rate__c(), rate.get(), "Salesforce", "Success", "None", apiResponse);
                                Optional<SalesforcePropertyResponse> property = retrieveAndParseResponse(rate.get().getHotel(), SalesforcePropertyResponse.class, applicationConfiguration.getSalesforcePropertyObject());

                                if (property.isPresent()) {
                                    setResponseAPI("Property", bookingId, rate.get().getHotel(), property.get(), "Salesforce", "Success", "None", apiResponse);
                                } else {
                                    setResponseAPI("Property", bookingId, rate.get().getHotel(), null, "Salesforce", "Failed", "Error retrieving or parsing Salesforce Property Response", apiResponse);
                                    logger.error("Error retrieving or parsing Salesforce Property Response");
                                }
                            } else {
                                setResponseAPI("Rate", bookingId, booking.get().getThn__Block_Rate__c(), null, "Salesforce", "Failed", "Error retrieving or parsing Salesforce Rate Response", apiResponse);
                                logger.error("Error retrieving or parsing Salesforce Rate Response");
                            }
                        } else {
                            setResponseAPI("Contact", bookingId, booking.get().getThn__Company_Contact__c(), null, "Salesforce", "Failed", "Error retrieving or parsing Salesforce Contact Response", apiResponse);
                            logger.error("Error retrieving or parsing Salesforce Contact Response");
                        }
                    } else {
                        setResponseAPI("Account", bookingId,  booking.get().getThn__Company_Contact__c(), null, "Salesforce", "Failed", "Error retrieving or parsing Salesforce Account Response", apiResponse);
                        logger.error("Error retrieving or parsing Salesforce Account Response");
                    }
                } else {
                    setResponseAPI("Booking", bookingId, requestBody, null, "Salesforce", "Failed", "Error retrieving or parsing Salesforce Booking Response", apiResponse);
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

    private <T> void setResponseAPI(String objectType, String objectId, String request, T response, String source, String status, String error, APIResponse apiResponse) {
        if (Objects.equals(objectType, "Booking")) {
            APIResponse.BookingDetails bookingDetails = new APIResponse.BookingDetails();
            bookingDetails.setRequest(request);
            bookingDetails.setResponse((SalesforceBookingResponse) response);
            bookingDetails.setSource(source);
            bookingDetails.setStatus(status);
            bookingDetails.setError(error);

            apiResponse.setBookingDetails(bookingDetails);
        }
        if (Objects.equals(objectType, "Account")) {
            APIResponse.AccountDetails accountDetails = new APIResponse.AccountDetails();
            accountDetails.setRequest(request);
            accountDetails.setResponse((SalesforceAccountResponse) response);
            accountDetails.setSource(source);
            accountDetails.setStatus(status);
            accountDetails.setError(error);

            apiResponse.setAccountDetails(accountDetails);
        }

        if (Objects.equals(objectType, "Contact")) {
            APIResponse.ContactDetails contactDetails = new APIResponse.ContactDetails();
            contactDetails.setRequest(request);
            contactDetails.setResponse((SalesforceContactResponse) response);
            contactDetails.setSource(source);
            contactDetails.setStatus(status);
            contactDetails.setError(error);

            apiResponse.setContactDetails(contactDetails);
        }

        if (Objects.equals(objectType, "Rate")) {
            APIResponse.RateDetails rateDetails = new APIResponse.RateDetails();
            rateDetails.setRequest(request);
            rateDetails.setResponse((SalesforceRateResponse) response);
            rateDetails.setSource(source);
            rateDetails.setStatus(status);
            rateDetails.setError(error);

            apiResponse.setRateDetails(rateDetails);
        }

        if (Objects.equals(objectType, "Property")) {
            APIResponse.PropertyDetails propertyDetails = new APIResponse.PropertyDetails();
            propertyDetails.setRequest(request);
            propertyDetails.setResponse((SalesforcePropertyResponse) response);
            propertyDetails.setSource(source);
            propertyDetails.setStatus(status);
            propertyDetails.setError(error);

            apiResponse.setPropertyDetails(propertyDetails);
        }

        apiResponse.setBookingId(objectId);
        apiResponse.setStatus(status);
        apiResponse.setCreatedDate(getTimeNow());

        try {
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
    }

    public String getTimeNow() {
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
