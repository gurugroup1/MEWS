package middleware.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import middleware.configurations.ApplicationConfiguration;
import middleware.controllers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.enums.ResponseStatus;
import middleware.models.*;
import middleware.services.MewsConnectorService;
import middleware.services.SalesforceConnectorService;
import middleware.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookingCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(BookingCommand.class);
    private final ApplicationConfiguration applicationConfiguration;
    private final SalesforceConnectorService salesforceConnectorService;
    private final MewsConnectorService mewsConnectorService;
    private final MewsController mewsController;
    private final SalesforceController salesforceController;
    private final AuthController authController;
    private final ObjectMapper objectMapper;

    public BookingCommand(Logger logger, ApplicationConfiguration applicationConfiguration, SalesforceConnectorService salesforceConnectorService, MewsConnectorService mewsConnectorService, MewsController mewsController, SecretKeyManagerController secretKeyManagerController, SalesforceController salesforceController, AuthController authController, ObjectMapper objectMapper) {
        this.applicationConfiguration = applicationConfiguration;
        this.salesforceConnectorService = salesforceConnectorService;
        this.mewsConnectorService = mewsConnectorService;
        this.mewsController = mewsController;
        this.salesforceController = salesforceController;
        this.authController = authController;
        this.objectMapper = objectMapper;
    }

    @Override
    public ApiResponse execute(String requestBody) {
        ApiResponse apiResponse = new ApiResponse();
        Map<String, Object> responseData = new HashMap<>();
        apiResponse.setData(responseData);
        String bookerId = "";
        try {
            String bookingId = JsonUtils.getBookingIdFromRequestBody(requestBody);
            if (bookingId != null) {
                logger.info("****Mews Middleware Started****");
                logger.info("Booking Id: " + bookingId);
                SalesforceTokenResponse salesforceToken = retrieveSalesforceToken();
                Optional<SalesforceBookingResponse> booking = retrieveAndParseResponse(bookingId, SalesforceBookingResponse.class, applicationConfiguration.getSalesforceBookingObject());
                if (booking.isPresent()) {
                    responseData.put("Salesforce_Get_Booking", booking.get());

                    Optional<SalesforceAccountResponse> account = retrieveAndParseResponse(booking.get().getThn__Company__c(), SalesforceAccountResponse.class, applicationConfiguration.getSalesforceAccountObject());
                    if (account.isPresent()) {
                        responseData.put("Salesforce_Get_Account", account.get());

                        Optional<SalesforceContactResponse> contact = retrieveAndParseResponse(booking.get().getThn__Company_Contact__c(), SalesforceContactResponse.class, applicationConfiguration.getSalesforceCompanyContactObject());
                        if (contact.isPresent()) {
                            responseData.put("Salesforce_Get_Contact", contact.get());
                            apiResponse.setStatus(ResponseStatus.SUCCESS);
                            Optional<SalesforceRateResponse> rate = retrieveAndParseResponse(booking.get().getThn__Block_Rate__c(), SalesforceRateResponse.class, applicationConfiguration.getSalesforceRateObject());
                            if (rate.isPresent()) {
                                responseData.put("Salesforce_Get_Rate", rate.get());
                                apiResponse.setStatus(ResponseStatus.SUCCESS);
                                Optional<SalesforcePropertyResponse> property = retrieveAndParseResponse(rate.get().getHotel(), SalesforcePropertyResponse.class, applicationConfiguration.getSalesforcePropertyObject());
                                if (property.isPresent()) {
                                    responseData.put("Salesforce_Get_Property", property.get());
                                    apiResponse.setStatus(ResponseStatus.SUCCESS);
                                    MewsGetCompanyRequest mewsGetCompanyRequest = mewsController.createGetCompanyPayload(account.get());
                                    Optional<MewsGetCompanyResponse> getCompany = this.getCompanyFromMews(mewsGetCompanyRequest);
//                                    responseData.put("Mews_Get_Company", getCompany.get());
                                    Optional<MewsUpdateCompanyResponse> mewsUpdateCompanyResponse = null;
                                    Optional<MewsCompanyResponse> mewsCompanyResponse = null;
                                    if (getCompany.get().getCompanies().length > 0) {
                                        MewsUpdateCompanyRequest mewsCompanyRequest = mewsController.createUpdateCompanyPayload(account.get(), booking.get(), contact.get(), getCompany.get() );
                                        mewsUpdateCompanyResponse = updateCompanyInMews(mewsCompanyRequest);
                                        responseData.put("Mews_Update_Company", mewsUpdateCompanyResponse.get());
                                    } else {
                                        MewsCompanyRequest mewsCompanyRequest = mewsController.createCompanyPayload(booking.get(), account.get(), contact.get());
                                        mewsCompanyResponse = addCompanyInMews(mewsCompanyRequest);
                                        responseData.put("Mews_Create_Company", mewsCompanyResponse.get());
                                    }
                                    if ((mewsCompanyResponse != null && mewsCompanyResponse.isPresent()) || (mewsUpdateCompanyResponse != null && mewsUpdateCompanyResponse.isPresent())) {
                                        if (mewsCompanyResponse != null) {
                                            responseData.put("mewsCompanyResponse", mewsCompanyResponse.get());
                                        }
                                        apiResponse.setStatus(ResponseStatus.SUCCESS);
                                        MewsGetBookerRequest mewsGetBookerRequest = mewsController.createGetBookerPayload(account.get(), contact.get());
                                        Optional<MewsGetBookerResponse> getBooker = this.getBookerFromMews(mewsGetBookerRequest);

                                        Optional<MewsUpdateBookerResponse>  mewsUpdateBookerResponse = null;
                                        Optional<MewsBookerResponse> bookerResponse = null;
                                        if (getBooker.get().getCustomers().length > 0) {
                                            MewsUpdateBookerRequest mewsBookerRequest = mewsController.createUpdateBookerPayload(booking.get(), account.get(), contact.get(), getBooker.get());
                                            mewsUpdateBookerResponse = this.updateBookerInMews(mewsBookerRequest);
                                            bookerId = mewsUpdateBookerResponse.get().getId();
                                            responseData.put("Mews_Update_Customer", mewsUpdateBookerResponse.get());
                                        } else {
                                            MewsBookerRequest mewsBookerRequest = this.mewsController.createBookerPayload(booking.get(), account.get(), contact.get());
                                            bookerResponse = this.addBookerInMews(mewsBookerRequest);
                                            bookerId = bookerResponse.get().getId();
                                            responseData.put("Mews_Create_Customer", bookerResponse.get());
                                        }
                                        if ((bookerResponse != null && bookerResponse.isPresent()) || (mewsUpdateBookerResponse != null && mewsUpdateBookerResponse.isPresent())) {

                                            if (bookerResponse != null && bookerResponse.isPresent()) {
                                                responseData.put("Mews_Get_Booker", bookerResponse.get());
                                            }
                                            apiResponse.setStatus(ResponseStatus.SUCCESS);
                                            MewsGetAvailabilityBlockRequest mewsGetAvailabilityBlockRequest = mewsController.createGetAvailabilityBlockPayload(account.get(), contact.get());
                                            Optional<MewsGetAvailabilityBlockResponse> getMewsAvailabilityBlock = this.getAvailabilityBlockFromMews(mewsGetAvailabilityBlockRequest);

                                            Optional<MewsAvailabilityBlockResponse> availabilityBlockResponse = null;
                                            String mewsUpdateAvailabilityBlockResponse = null;
                                            if (getMewsAvailabilityBlock.get().getAvailabilityBlocks().length > 0) {
                                                MewsUpdateAvailabilityBlockRequest mewsUpdateAvailabilityBlockRequest = mewsController.createUpdateAvailabilityBlockPayload(account.get(),booking.get(), contact.get(), property.get(), getMewsAvailabilityBlock.get());
                                                mewsUpdateAvailabilityBlockResponse = mewsController.updateAvailabilityBlock(mewsUpdateAvailabilityBlockRequest);
                                            } else {
                                                MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = this.mewsController.createAvailabilityBlockPayload(booking.get(), rate.get(), property.get(), bookerId);
                                                availabilityBlockResponse = this.addAvailabilityBlockInMews(mewsAvailabilityBlockRequest);
                                            }

                                            if ((availabilityBlockResponse != null && availabilityBlockResponse.isPresent()) || (mewsUpdateAvailabilityBlockResponse != null && mewsUpdateAvailabilityBlockResponse.equals("{}"))) {
                                                if (availabilityBlockResponse != null) {
                                                    responseData.put("mewsAvailabilityBlockResponse", availabilityBlockResponse.get());
                                                } else {
                                                    responseData.put("Mews_Update_Availability_Block", "{}");
                                                }

                                                apiResponse.setStatus(ResponseStatus.SUCCESS);

                                                //                                                MewsUpdateAvailabilityRequest mewsUpdateAvailabilityRequest = this.mewsController.createUpdateAvailabilityPayload(booking.get(),rate.get(),property.get(),bookerResponse.get());
                                                String mewsUpdateAvailabilityResponse = "{}";//this.mewsController.updateAvailability(mewsUpdateAvailabilityRequest);
                                                if (mewsUpdateAvailabilityResponse.equals("{}")) {
//                                                    responseData.put("mewsUpdateAvailabilityResponse", bookerResponse.get());
//                                                    apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                    MewsUpdateRateRequest mewsUpdateRateRequest = this.mewsController.createUpdateRatePayload(booking.get(), rate.get(), property.get());
                                                    String mewsUpdateRateResponse = this.mewsController.updateRate(mewsUpdateRateRequest);
                                                    if (mewsUpdateRateResponse.equals("{}")) {
                                                        responseData.put("Mews_Update_Rate_Price", mewsUpdateRateResponse);
                                                        apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                        PSMAccountRequest pmsAccountRequest = this.salesforceController.createPSMAccountPayload();
                                                        String pmsAccountRequestString = objectMapper.writeValueAsString(pmsAccountRequest);
                                                        String pmsAccountResponse = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSAccount(), salesforceToken.getAccess_token(), pmsAccountRequestString);
                                                        if (pmsAccountResponse != null && !pmsAccountResponse.isEmpty()) {
                                                            responseData.put("Salesforce_Post_PMS_Account", pmsAccountResponse);
                                                            apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                            SalesforceGuestRequest guestRequest = this.salesforceController.createGuestBookerPayload();
                                                            String guestRequestString = objectMapper.writeValueAsString(guestRequest);
                                                            String guestRequestResponse = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforceGuest(), salesforceToken.getAccess_token(), guestRequestString);
                                                            if (guestRequestResponse != null && !guestRequestResponse.isEmpty()) {
                                                                responseData.put("Salesforce_Post_Guest", guestRequestResponse);
                                                                apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                                SalesforcePSMBlockRequest pmsBlockRequest = this.salesforceController.createPMSBlockPayload();
                                                                String pmsBlockRequestString = objectMapper.writeValueAsString(pmsBlockRequest);
                                                                String pmsBlockRequestResponse = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlock(), salesforceToken.getAccess_token(), pmsBlockRequestString);
                                                                if (pmsBlockRequestResponse != null && !pmsBlockRequestResponse.isEmpty()) {
                                                                    responseData.put("Salesforce_Post_PMS_Block", pmsBlockRequestResponse);
                                                                    apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                                    SalesforcePMSBlockInventory mewsBlockInventoryRequest = this.salesforceController.createMewsBlockInventoryPayload();
                                                                    String mewsBlockInventoryRequestString = objectMapper.writeValueAsString(mewsBlockInventoryRequest);
                                                                    String mewsBlockInventoryResponse = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforceMewsBlockinventory(), salesforceToken.getAccess_token(), mewsBlockInventoryRequestString);
                                                                    if (mewsBlockInventoryResponse != null && !mewsBlockInventoryResponse.isEmpty()) {
                                                                        responseData.put("Salesforce_Post_Mews_Block_inventories", mewsBlockInventoryResponse);
                                                                        apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                                        SalesforcePMSBlockRate salesforcePMSBlockRateRequest = this.salesforceController.createPMSBlockRatesPayload();
                                                                        String salesforcePMSBlockRateRequestString = objectMapper.writeValueAsString(salesforcePMSBlockRateRequest);
                                                                        String salesforcePMSBlockRateResponse = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlockRates(), salesforceToken.getAccess_token(), salesforcePMSBlockRateRequestString);
                                                                        if (salesforcePMSBlockRateResponse != null && !salesforcePMSBlockRateResponse.isEmpty()) {
                                                                            responseData.put("Salesforce_Post_PMS_Block_Rates", salesforcePMSBlockRateResponse);
                                                                            apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                                            SalesforceBookingRequest salesforceBookingRequest = this.salesforceController.createBookingPayload(booking.get().getName());
                                                                            String salesforceBookingRequestString = objectMapper.writeValueAsString(salesforceBookingRequest);
                                                                            String salesforceBookingResponse = this.salesforceController.updateRecordInSalesforce(applicationConfiguration.getSalesforceBookingObject(), salesforceToken.getAccess_token(), salesforceBookingRequestString, bookingId);
                                                                            if (salesforceBookingResponse.isEmpty()) {
                                                                                responseData.put("Salesforce_Update_Booking", salesforceBookingResponse);
                                                                                apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                                                apiResponse.setMessage("Booking, account, contact, rate, property ,created company in Mews , created booker in Mews, created Availability in Mews, update availability block in Mews, update rate block in Mews, created PMS account in salesforce,created Guest in salesforce, created PMS Block in salesforce, created Mews block inventory in salesforce, created PMS block rate in salesforce, update booking in salesforce and data processed successfully");
                                                                            } else {
                                                                                logger.info("Failed to update booking in salesforce");
                                                                                apiResponse.setStatus(ResponseStatus.FAILED);
                                                                                apiResponse.setMessage("Failed to update booking in salesforce");
                                                                            }
                                                                        } else {
                                                                            logger.info("Failed to create PMS block rate in salesforce");
                                                                            apiResponse.setStatus(ResponseStatus.FAILED);
                                                                            apiResponse.setMessage("Failed to PMS block rate in salesforce");
                                                                        }
                                                                    } else {
                                                                        logger.info("Failed to create Mews block inventory in salesforce");
                                                                        apiResponse.setStatus(ResponseStatus.FAILED);
                                                                        apiResponse.setMessage("Failed to Mews block inventory in salesforce");
                                                                    }
                                                                } else {
                                                                    logger.info("Failed to create PMS block in salesforce");
                                                                    apiResponse.setStatus(ResponseStatus.FAILED);
                                                                    apiResponse.setMessage("Failed to create PMS Block in salesforce");
                                                                }
                                                            } else {
                                                                logger.info("Failed to create guest in salesforce");
                                                                apiResponse.setStatus(ResponseStatus.FAILED);
                                                                apiResponse.setMessage("Failed to create guest in salesforce");
                                                            }
                                                        } else {
                                                            logger.info("Failed to create PMS account in salesforce");
                                                            apiResponse.setStatus(ResponseStatus.FAILED);
                                                            apiResponse.setMessage("Failed to create PMS account in salesforce");
                                                        }
                                                    } else {
                                                        logger.info("Failed to update rate block in Mews");
                                                        apiResponse.setStatus(ResponseStatus.FAILED);
                                                        apiResponse.setMessage("Failed to update rate block in Mews");
                                                    }
                                                } else {
                                                    logger.info("Failed to update availability in Mews");
                                                    apiResponse.setStatus(ResponseStatus.FAILED);
                                                    apiResponse.setMessage("Failed to update availability in Mews");
                                                }
                                            } else {
                                                logger.info("Failed to add availability block in Mews");
                                                apiResponse.setStatus(ResponseStatus.FAILED);
                                                apiResponse.setMessage("Failed to add availability block in Mews");
                                            }

                                        }
                                        else {
                                            logger.info("Failed to add booker in Mews");
                                            apiResponse.setStatus(ResponseStatus.FAILED);
                                            apiResponse.setMessage("Failed to add booker in Mews");
                                        }
                                    } else {
                                        logger.info("Failed to add company in Mews");
                                        apiResponse.setStatus(ResponseStatus.FAILED);
                                        apiResponse.setMessage("Failed to add company in Mews");
                                    }
                                } else {
                                    logger.info("No Property found for the rate hotel ID");
                                    apiResponse.setStatus(ResponseStatus.FAILED);
                                    apiResponse.setMessage("No Property found for the rate hotel ID");
                                }
                            } else {
                                logger.info("No Rate found for the booking block rate ID");
                                apiResponse.setStatus(ResponseStatus.FAILED);
                                apiResponse.setMessage("No Rate found for the booking block rate ID");
                            }
                        } else {
                            logger.info("No contact found for the company contact ID");
                            apiResponse.setStatus(ResponseStatus.FAILED);
                            apiResponse.setMessage("No contact found for the company contact ID");
                        }
                    } else {
                        logger.info("No account found for the company ID");
                        apiResponse.setStatus(ResponseStatus.FAILED);
                        apiResponse.setMessage("No account found for the company ID");
                    }
                } else {
                    logger.info("Request body does not contain booking Id");
                    apiResponse.setStatus(ResponseStatus.FAILED);
                    apiResponse.setMessage("Request body does not contain booking Id");
                }
            } else {
                apiResponse.setStatus(ResponseStatus.FAILED);
                apiResponse.setMessage("No booking ID provided in the request body");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            apiResponse.setStatus(ResponseStatus.FAILED);
            apiResponse.setMessage("An error occurred: " + e.getMessage());
            logger.info("Response: " + apiResponse);
            logger.info("****Mews Middleware Stopped****");

            return apiResponse;
        }
        logger.info("Response: " + apiResponse);
        logger.info("****Mews Middleware Stopped****");

        return apiResponse;
    }
    private <T> Optional<T> retrieveAndParseResponse(String parameter, Class<T> responseClass, String object) {
        try {
            SalesforceTokenResponse salesforceToken = retrieveSalesforceToken();

            String response = salesforceController.getRecordFromSalesforce(
                    object,
                    salesforceToken.getAccess_token(),
                    parameter
            );

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

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseClass);
            return Optional.ofNullable(parsedResponse);
        } catch (Exception e) {
            logger.error("Error retrieving and parsing response", e);
            return Optional.empty();
        }
    }
    private <T> T parseResponse(String response, Class<T> responseType, String object) throws Exception {
        try {
            JsonNode responseJson = objectMapper.readTree(response);

            if (responseJson.has("error")) {
                String errorMessage = responseJson.get("error").asText();
                throw new Exception("Error in " + responseType.getSimpleName() + " response from Mews: " + errorMessage);
            }

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseType);
            return parsedResponse;
        } catch (IOException e) {
            throw new Exception("Unable to parse " + responseType.getSimpleName() + " Response", e);
        }
    }
    public Optional<MewsCompanyResponse> addCompanyInMews(MewsCompanyRequest payload) throws Exception {
        String response = mewsController.addCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        return Optional.ofNullable(parseResponse(response, MewsCompanyResponse.class, "Company Response"));
    }
    public Optional<MewsBookerResponse> addBookerInMews(MewsBookerRequest payload) throws Exception {
        String response = mewsController.addBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsBookerResponse.class, "Booker Response"));
    }
    public Optional<MewsAvailabilityBlockResponse> addAvailabilityBlockInMews(MewsAvailabilityBlockRequest payload) throws Exception {
        String response = mewsController.addAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Availability Block response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsAvailabilityBlockResponse.class, "Availability Block Response"));
    }
    public Optional<MewsUpdateCompanyResponse> updateCompanyInMews(MewsUpdateCompanyRequest payload) throws Exception {
        String response = mewsController.updateCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception(" empty update company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsUpdateCompanyResponse.class, "Update Company Response"));
    }

    public Optional<MewsUpdateBookerResponse> updateBookerInMews(MewsUpdateBookerRequest payload) throws Exception {
        String response = mewsController.updateBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty update booker response from Mews.");
        }

        return Optional.ofNullable(parseResponse(response, MewsUpdateBookerResponse.class, "Update Booker Response"));
    }
    public Optional<MewsGetCompanyResponse> getCompanyFromMews(MewsGetCompanyRequest payload) throws Exception {
        String response = mewsController.getCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsGetCompanyResponse.class, "Company Response"));
    }

    public Optional<MewsGetBookerResponse> getBookerFromMews(MewsGetBookerRequest payload) throws Exception {
        String response = mewsController.getBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsGetBookerResponse.class, "Get Booker Response"));
    }
    public Optional<MewsGetAvailabilityBlockResponse> getAvailabilityBlockFromMews(MewsGetAvailabilityBlockRequest payload) throws Exception {
        String response = mewsController.getMewsAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsGetAvailabilityBlockResponse.class, "Get Availability Block Response"));
    }
    private SalesforceTokenResponse retrieveSalesforceToken() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }
        return salesforceToken;
    }
}
