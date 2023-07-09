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
import java.util.Optional;

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
        this.mewsController = new MewsController(this.mewsConnectorService,applicationConfiguration);
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

                SalesforceTokenResponse salesforceToken = retrieveSalesforceToken();

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
                                    MewsCompanyRequest mewsCompanyRequest = this.mewsController.createCompanyPayload(booking.get(),account.get(),contact.get());
                                    Optional<MewsCompanyResponse> mewsCompanyResponse = this.addCompanyInMews(mewsCompanyRequest);
                                    String mewsCompanyRequestString = objectMapper.writeValueAsString(mewsCompanyRequest);
                                    if (mewsCompanyResponse.isPresent()) {
                                        setResponseAPI("MewsCompany", bookingId, mewsCompanyRequestString, mewsCompanyResponse.get(), "Mews", "Success", "None", apiResponse);
                                        MewsBookerRequest mewsBookerRequest = this.mewsController.createBookerPayload(booking.get(),account.get(),contact.get());
                                        String mewsBookerRequestString = objectMapper.writeValueAsString(mewsBookerRequest);
                                        Optional<MewsBookerResponse> bookerResponse = this.addBookerInMews(mewsBookerRequest);
                                        if (bookerResponse.isPresent()) {
                                            setResponseAPI("MewsBooker", bookingId, mewsBookerRequestString, bookerResponse.get(), "Mews", "Success", "None", apiResponse);
                                            MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = this.mewsController.createAvailabilityBlockPayload(booking.get(),rate.get(),property.get(),bookerResponse.get());
                                            String mewsAvailabilityBlockRequestString = objectMapper.writeValueAsString(mewsAvailabilityBlockRequest);
                                            Optional<MewsAvailabilityBlockResponse> availabilityBlockResponse = this.addAvailabilityBlockInMews(mewsAvailabilityBlockRequest);
                                            if (availabilityBlockResponse.isPresent()) {
                                                setResponseAPI("MewsAvailabilityBlock", bookingId, mewsAvailabilityBlockRequestString, availabilityBlockResponse.get(), "Mews", "Success", "None", apiResponse);
                                                MewsUpdateAvailabilityRequest mewsUpdateAvailabilityRequest = this.mewsController.createUpdateAvailabilityPayload(booking.get(),rate.get(),property.get(),bookerResponse.get());
                                                String mewsUpdateAvailabilityRequestString = objectMapper.writeValueAsString(mewsUpdateAvailabilityRequest);
                                                String updateAvailabilityResponse = this.mewsController.updateAvailability(mewsUpdateAvailabilityRequest);
                                                if (updateAvailabilityResponse.equals("{}")) {
                                                    setResponseAPI("MewsUpdateAvailability", bookingId, mewsUpdateAvailabilityRequestString, null, "Mews", "Success", "None", apiResponse);
                                                    MewsUpdateRateRequest mewsUpdateRateRequest = this.mewsController.createUpdateRatePayload(booking.get(),rate.get(),property.get(),bookerResponse.get());
                                                    String mewsUpdateRateRequestString = objectMapper.writeValueAsString(mewsUpdateRateRequest);
                                                    String mewsUpdateRateResponse = this.mewsController.updateAvailability(mewsUpdateAvailabilityRequest);
                                                    if (mewsUpdateRateResponse.equals("{}")) {
                                                        setResponseAPI("MewsUpdateRate", bookingId, mewsUpdateRateRequestString, null, "Mews", "Success", "None", apiResponse);
                                                        // New block of code starts here
                                                        PSMAccountRequest pmsAccountRequest = this.salesforceController.createPSMAccountPayload();
                                                        String pmsAccountRequestString = objectMapper.writeValueAsString(pmsAccountRequest);
                                                        this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSAccount(),salesforceToken.getAccess_token(), pmsAccountRequestString);

                                                        SalesforceGuestRequest guestRequest = this.salesforceController.createGuestBookerPayload();
                                                        String guestRequestString = objectMapper.writeValueAsString(guestRequest);
                                                        this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforceGuest(),salesforceToken.getAccess_token(), guestRequestString);

                                                        SalesforcePSMBlockRequest pmsBlockRequest = this.salesforceController.createPMSBlockPayload();
                                                        String pmsBlockRequestString = objectMapper.writeValueAsString(pmsBlockRequest);
                                                        this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlock(),salesforceToken.getAccess_token(), pmsBlockRequestString);

                                                        SalesforcePMSBlockInventory mewsBlockInventoryRequest = this.salesforceController.createMewsBlockInventoryPayload();
                                                        String mewsBlockInventoryRequestString = objectMapper.writeValueAsString(mewsBlockInventoryRequest);
                                                        this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforceMewsBlockinventory(),salesforceToken.getAccess_token(), mewsBlockInventoryRequestString);

                                                        SalesforcePMSBlockRate salesforcePMSBlockRateRequest = this.salesforceController.createPMSBlockRatesPayload();
                                                        String salesforcePMSBlockRateRequestString = objectMapper.writeValueAsString(salesforcePMSBlockRateRequest);
                                                        this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlockRates(),salesforceToken.getAccess_token(), salesforcePMSBlockRateRequestString);

                                                        SalesforceBookingRequest salesforceBookingRequest = this.salesforceController.createBookingPayload();
                                                        String salesforceBookingRequestString = objectMapper.writeValueAsString(salesforceBookingRequest);
                                                        this.salesforceController.updateRecordInSalesforce(applicationConfiguration.getSalesforceBookingObject(),salesforceToken.getAccess_token(), salesforceBookingRequestString,bookingId);
                                                        // New block of code ends here
                                                    } else {
                                                        setResponseAPI("MewsUpdateRate", bookingId, mewsAvailabilityBlockRequestString, null, "Mews", "Failed", "Error retrieving or parsing Mews Update Rate ", apiResponse);
                                                        logger.error("Error retrieving or parsing Mews Update Rate Response");
                                                    }
                                                } else {
                                                    setResponseAPI("MewsUpdateAvailability", bookingId, mewsAvailabilityBlockRequestString, null, "Mews", "Failed", "Error retrieving or parsing Mews Update Availability ", apiResponse);
                                                    logger.error("Error retrieving or parsing Mews Update Availability Response");
                                                }
                                            } else {
                                                setResponseAPI("MewsAvailabilityBlock", bookingId, mewsAvailabilityBlockRequestString, null, "Mews", "Failed", "Error retrieving or parsing Mews Availability Block Response", apiResponse);
                                                logger.error("Error retrieving or parsing Mews Availability Block Response");
                                            }
                                        } else {
                                            setResponseAPI("MewsBooker", bookingId, rate.get().getHotel(), null, "Mews", "Failed", "Error retrieving or parsing Mews Booker Response", apiResponse);
                                            logger.error("Error retrieving or parsing Mews Booker Response");
                                        }
                                    } else {
                                        setResponseAPI("MewsCompany", bookingId, rate.get().getHotel(), null, "Mews", "Failed", "Error retrieving or parsing Mews Company Response", apiResponse);
                                        logger.error("Error retrieving or parsing Mews Company Response");
                                    }
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

        if (Objects.equals(objectType, "MewsCompany")) {
            APIResponse.MewsCompanyDetails companyDetails = new APIResponse.MewsCompanyDetails();
            companyDetails.setRequest(request);
            companyDetails.setResponse((MewsCompanyResponse) response);
            companyDetails.setSource(source);
            companyDetails.setStatus(status);
            companyDetails.setError(error);
            apiResponse.setMewsCompanyDetails(companyDetails);
        }
        if (Objects.equals(objectType, "MewsBooker")) {
            APIResponse.MewsBookerDetails bookerDetails = new APIResponse.MewsBookerDetails();
            bookerDetails.setRequest(request);
            bookerDetails.setResponse((MewsBookerResponse) response);
            bookerDetails.setSource(source);
            bookerDetails.setStatus(status);
            bookerDetails.setError(error);
            apiResponse.setMewsBookerDetails(bookerDetails);
        }
        if (Objects.equals(objectType, "MewsAvailabilityBlock")) {
            APIResponse.MewsAvailabilityBlockDetails details = new APIResponse.MewsAvailabilityBlockDetails();
            details.setRequest(request);
            details.setResponse((MewsAvailabilityBlockResponse) response);
            details.setSource(source);
            details.setStatus(status);
            details.setError(error);
            apiResponse.setMewsAvailabilityBlockDetails(details);
        }
        if (Objects.equals(objectType, "MewsUpdateAvailability")) {
            APIResponse.MewsUpdateAvailabilityDetails details = new APIResponse.MewsUpdateAvailabilityDetails();
            details.setRequest(request);
            details.setResponse(null);
            details.setSource(source);
            details.setStatus(status);
            details.setError(error);
            apiResponse.setMewsUpdateAvailabilityDetails(details);
        }
        if (Objects.equals(objectType, "MewsUpdateRate")) {
            APIResponse.MewsUpdateRateDetails details = new APIResponse.MewsUpdateRateDetails();
            details.setRequest(request);
            details.setResponse(null);
            details.setSource(source);
            details.setStatus(status);
            details.setError(error);
            apiResponse.setMewsUpdateRateDetails(details);
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

    public Optional<MewsCompanyResponse> addCompanyInMews(MewsCompanyRequest payload) throws Exception {
        String response = mewsController.addCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        logger.info("Mews Company Response: " + response);

        return Optional.ofNullable(parseResponse(response, MewsCompanyResponse.class, "Company Response"));
    }
    public Optional<MewsBookerResponse> addBookerInMews(MewsBookerRequest payload) throws Exception {
        String response = mewsController.addBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        logger.info("Mews Company Response: " + response);

        return Optional.ofNullable(parseResponse(response, MewsBookerResponse.class, "Booker Response"));
    }

    public Optional<MewsAvailabilityBlockResponse> addAvailabilityBlockInMews(MewsAvailabilityBlockRequest payload) throws Exception {
        String response = mewsController.addAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Availability Block response from Mews.");
        }

        logger.info("Mews Company Response: " + response);

        return Optional.ofNullable(parseResponse(response, MewsAvailabilityBlockResponse.class, "Availability Block Response"));
    }

    private <T> T parseResponse(String response, Class<T> responseType, String object) throws Exception {
        try {
            JsonNode responseJson = objectMapper.readTree(response);

            if (responseJson.has("error")) {
                String errorMessage = responseJson.get("error").asText();
                throw new Exception("Error in " + responseType.getSimpleName() + " response from Mews: " + errorMessage);
            }

            logger.info(responseType.getSimpleName() + " Response: " + response);

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseType);
            return parsedResponse;
        } catch (IOException e) {
            throw new Exception("Unable to parse " + responseType.getSimpleName() + " Response", e);
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
