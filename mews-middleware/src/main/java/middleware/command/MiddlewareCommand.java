package middleware.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.configurations.ApplicationConfiguration;
import middleware.controllers.*;
import middleware.enums.ResponseStatus;
import middleware.models.*;
import middleware.services.MewsConnectorService;
import middleware.services.SalesforceConnectorService;
import middleware.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MiddlewareCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(MiddlewareCommand.class);
    private final ApplicationConfiguration applicationConfiguration;
    private final SalesforceConnectorService salesforceConnectorService;
    private final MewsConnectorService mewsConnectorService;
    private final MewsController mewsController;
    private final SalesforceController salesforceController;
    private final AuthController authController;
    private final ObjectMapper objectMapper;

    String bookerId = "";

    @Autowired
    private final ResponseParser responseParser;

    public MiddlewareCommand(Logger logger, ApplicationConfiguration applicationConfiguration, SalesforceConnectorService salesforceConnectorService, MewsConnectorService mewsConnectorService, MewsController mewsController, SecretKeyManagerController secretKeyManagerController, SalesforceController salesforceController, AuthController authController, ObjectMapper objectMapper, ResponseParser responseParser) {
        this.applicationConfiguration = applicationConfiguration;
        this.salesforceConnectorService = salesforceConnectorService;
        this.mewsConnectorService = mewsConnectorService;
        this.mewsController = mewsController;
        this.salesforceController = salesforceController;
        this.authController = authController;
        this.objectMapper = objectMapper;
        this.responseParser = responseParser;
    }

    @Override
    public ApiResponse execute(String requestBody) {
        ApiResponse apiResponse = new ApiResponse();
        Map<String, Object> responseData = new HashMap<>();
        apiResponse.setData(responseData);
        try {
            String bookingId = JsonUtils.getBookingIdFromRequestBody(requestBody);
            if (bookingId != null) {
                generateLog("**** Mews Middleware Start ****");
                apiResponse.setBookingId(bookingId);
                SalesforceTokenResponse salesforceToken = this.responseParser.retrieveSalesforceToken();
                SalesforceBookingResponse booking = getBookingDetails(salesforceToken, bookingId, apiResponse, responseData);
                if (booking != null) {
                    SalesforceQueryResponse guestRoom = getGuestDetails(salesforceToken, bookingId, apiResponse, responseData);
                    if (guestRoom != null) {
                        SalesforceAccountResponse account = getAccountDetails(salesforceToken, booking, apiResponse, responseData);
                        if (account != null) {
                            SalesforceContactResponse contact = getContactDetails(salesforceToken, booking, apiResponse, responseData);
                            if (contact != null) {
                                SalesforceRateResponse rate = getRateDetails(salesforceToken, booking, apiResponse, responseData);
                                if (rate != null) {
                                    SalesforcePropertyResponse property = getPropertyDetails(salesforceToken, rate, apiResponse, responseData);
                                    if (property != null) {
                                        SalesforceGetPMSBlockResponse pmsBlock = getPSMBlockDetails(salesforceToken, bookingId, apiResponse, responseData);
                                        if (pmsBlock != null) {
                                            SalesforceGetPMSAccountResponse pmsAccount = getPSMAccountDetails(salesforceToken, bookingId, apiResponse, responseData);
                                            if (pmsAccount != null) {
                                                Optional<MewsGetCompanyResponse> companyMews = isCompanyExistInMews(account, pmsAccount, responseData);
                                                if (companyMews.isPresent()) {
                                                    Optional<MewsUpdateCompanyResponse> updatedCompany = updateCompanyInMews(booking, account, contact, companyMews.get(), responseData);
                                                } else {
                                                    Optional<MewsCompanyResponse> createdCompany = createCompanyInMews(booking, account, contact, responseData);
                                                }
                                                Optional<MewsGetBookerResponse> BookerMews = isBookerExistInMews(account, contact, pmsAccount, responseData);
                                                List<MewsGetBookerResponse.Customer> customers = BookerMews.get().getCustomers();
                                                MewsGetBookerResponse.Customer firstCustomer = customers.get(0);
                                                bookerId = firstCustomer.getId();
                                                if (BookerMews.isPresent()) {
                                                    Optional<MewsUpdateBookerResponse> updatedBooker = updateBookerInMews(booking, account, contact, BookerMews.get(), responseData);

                                                } else {
                                                    Optional<MewsBookerResponse> createdBooker = createBookerInMews(booking, account, contact, responseData);
                                                    bookerId = createdBooker.get().getId();
                                                }
                                                Optional<MewsGetAvailabilityBlockResponse> availabilityBlockMews = isAvailabilityBlockExistInMews(account, contact, pmsBlock, responseData);
                                                Optional<MewsAvailabilityBlockResponse> createdAvailabilityBlock = Optional.empty();
                                                if (availabilityBlockMews.isPresent()) {
                                                    String updateAvailabilityInMews = updateAvailabilityInMewsByGet(booking, rate, property, availabilityBlockMews, guestRoom, responseData);
                                                    String updateRatePriceInMewsByGet = updateRatePriceInMewsByGet(booking, availabilityBlockMews, responseData);
                                                } else {
                                                    createdAvailabilityBlock = createAvailabilityBlockInMews(booking, contact, rate, property, bookerId, responseData);
                                                    String updateAvailabilityInMews = updateAvailabilityInMewsByCreated(booking, rate, property, createdAvailabilityBlock, guestRoom, responseData);
                                                    String updateRatePriceInMewsByCreate = updateRatePriceInMewsByCreated(booking, createdAvailabilityBlock, responseData);
                                                }
                                                String createdPMSAccount = createPMSAccountForCompanyInSalesforce(booking, account, contact, rate, property, salesforceToken, responseData);
                                                JsonNode createdPMSAccountNode = objectMapper.readTree(createdPMSAccount);
                                                String pmsAccountResponseId = createdPMSAccountNode.get("id").asText();
                                                if (createdPMSAccountNode.get("success").asBoolean() == true) {
                                                    String createdGuestForBooker = createGuestForBookerInSalesforce(booking, account, contact, rate, property, salesforceToken, responseData);
                                                    JsonNode createdGuestForBookerNode = objectMapper.readTree(createdGuestForBooker);
                                                    String createdPMSBlockInSalesforce = "";
                                                    if (createdGuestForBookerNode.get("success").asBoolean() == true) {
                                                        if (availabilityBlockMews.isPresent()) {
                                                            createdPMSBlockInSalesforce = createPMSBlockInSalesforceByGet(booking, account, contact, rate, property, salesforceToken, availabilityBlockMews, pmsAccountResponseId, responseData);
                                                        } else {
                                                            createdPMSBlockInSalesforce = createPMSBlockInSalesforceByCreated(booking, account, contact, rate, property, salesforceToken, createdAvailabilityBlock, pmsAccountResponseId, responseData);
                                                        }
                                                        JsonNode pmsBlockNode = objectMapper.readTree(createdPMSBlockInSalesforce);
                                                        String pmsBlockId = pmsBlockNode.get("id").asText();
                                                        if (pmsBlockNode.get("success").asBoolean() == true) {
                                                            String createdMewsBlockInventoriesInSalesforce = createMewsBlockInventoriesInSalesforce(booking, account, contact, rate, property, salesforceToken, pmsBlockId, guestRoom, responseData);
                                                            JsonNode createdMewsBlockInventoriesNode = objectMapper.readTree(createdMewsBlockInventoriesInSalesforce);
                                                            if (createdMewsBlockInventoriesNode.get("success").asBoolean() == true) {
                                                                String createdPMSBlockRates = createPMSBlockRatesInSalesforce(booking, account, contact, rate, property, salesforceToken, pmsBlockId, guestRoom, responseData);
                                                                JsonNode createdPMSBlockRatesNode = objectMapper.readTree(createdPMSBlockRates);
                                                                if (createdPMSBlockRatesNode.get("success").asBoolean() == true) {
//                                                                    apiResponse.setStatus(ResponseStatus.SUCCESS);
//                                                                    apiResponse.setMessage("Process has been completed.");
                                                                    String updatedGuestRoomWithPmsBlock = updateGuestRoomWithPmsBlockInSalesforce(booking,account,contact,rate,property,salesforceToken,pmsBlockId,guestRoom,pmsBlockId,responseData);
                                                                    JsonNode updatedGuestRoomWithPmsBlockNode = objectMapper.readTree(updatedGuestRoomWithPmsBlock);
                                                                        if (updatedGuestRoomWithPmsBlockNode.get("success").asBoolean() == true) {
                                                                            apiResponse.setStatus(ResponseStatus.SUCCESS);
                                                                            apiResponse.setMessage("Process has been completed.");
                                                                        }
                                                                }
                                                            }

                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                setFailedStatus(apiResponse, "No booking Id provided in the request body");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            setFailedStatus(apiResponse, "An error occurred: " + e.getMessage());
            generateLog("Response: " + apiResponse);
            generateLog("**** Mews Middleware Stopped With Exception ****");
            return apiResponse;
        }
        generateLog("Response: " + apiResponse);
        generateLog("**** Mews Middleware Stopped ****");
        return apiResponse;
    }

    private SalesforceBookingResponse getBookingDetails(SalesforceTokenResponse salesforceToken, String bookingId, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceBookingResponse> booking = this.responseParser.retrieveAndParseResponse(salesforceToken, bookingId, SalesforceBookingResponse.class, applicationConfiguration.getSalesforceBookingObject());
        if (booking.isPresent()) {
            responseData.put("Salesforce_Get_Booking", booking.get());
            SalesforceBookingResponse bookingResponse = booking.get();
            return bookingResponse;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain booking Id");
            return null;
        }
    }

    private SalesforceQueryResponse getGuestDetails(SalesforceTokenResponse salesforceToken, String bookingId, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceQueryResponse> response = this.responseParser.retrieveAndParseQueryResponse(salesforceToken, bookingId, SalesforceQueryResponse.class, "Guest");
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_Guest_Rooms", response.get());
            SalesforceQueryResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain Guest Id");
            return null;
        }
    }

    private SalesforceAccountResponse getAccountDetails(SalesforceTokenResponse salesforceToken, SalesforceBookingResponse booking, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceAccountResponse> response = this.responseParser.retrieveAndParseResponse(salesforceToken, booking.getThn__Company__c(), SalesforceAccountResponse.class, applicationConfiguration.getSalesforceAccountObject());
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_Account", response.get());
            SalesforceAccountResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain Account Id");
            return null;
        }
    }

    private SalesforceContactResponse getContactDetails(SalesforceTokenResponse salesforceToken, SalesforceBookingResponse booking, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceContactResponse> response = this.responseParser.retrieveAndParseResponse(salesforceToken, booking.getThn__Company_Contact__c(), SalesforceContactResponse.class, applicationConfiguration.getSalesforceCompanyContactObject());
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_Contact", response.get());
            SalesforceContactResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain Contact Id");
            return null;
        }
    }

    private SalesforceRateResponse getRateDetails(SalesforceTokenResponse salesforceToken, SalesforceBookingResponse booking, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceRateResponse> response = this.responseParser.retrieveAndParseResponse(salesforceToken, booking.getThn__Block_Rate__c(), SalesforceRateResponse.class, applicationConfiguration.getSalesforceRateObject());
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_Rate", response.get());
            SalesforceRateResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain rate Id");
            return null;
        }
    }

    private SalesforcePropertyResponse getPropertyDetails(SalesforceTokenResponse salesforceToken, SalesforceRateResponse rate, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforcePropertyResponse> response = this.responseParser.retrieveAndParseResponse(salesforceToken, rate.getHotel(), SalesforcePropertyResponse.class, applicationConfiguration.getSalesforcePropertyObject());
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_Property", response.get());
            SalesforcePropertyResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain Property Id");
            return null;
        }
    }

    private SalesforceGetPMSAccountResponse getPSMAccountDetails(SalesforceTokenResponse salesforceToken, String bookingId, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceGetPMSAccountResponse> response = this.responseParser.retrieveAndParseQueryResponse(salesforceToken, bookingId, SalesforceGetPMSAccountResponse.class, "PSM_Account");
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_PMS_Account", response.get());
            SalesforceGetPMSAccountResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain PMS Account Id");
            return null;
        }
    }

    private SalesforceGetPMSBlockResponse getPSMBlockDetails(SalesforceTokenResponse salesforceToken, String bookingId, ApiResponse apiResponse, Map<String, Object> responseData) {
        Optional<SalesforceGetPMSBlockResponse> response = this.responseParser.retrieveAndParseQueryResponse(salesforceToken, bookingId, SalesforceGetPMSBlockResponse.class, "PSM_Block");
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_PMS_Block", response.get());
            SalesforceGetPMSBlockResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain PMS Block Id");
            return null;
        }
    }

    private Optional<MewsGetCompanyResponse> isCompanyExistInMews(SalesforceAccountResponse account, SalesforceGetPMSAccountResponse pmsAccount, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetCompanyResponse> response = Optional.empty();
        if (pmsAccount.getTotalSize() > 0) {
            MewsGetCompanyRequest request = mewsController.createGetCompanyPayload(account);
            response = this.responseParser.getCompanyFromMews(request);
            if (response.isPresent()) {
                MewsGetCompanyResponse result = response.get();
                responseData.put("Mews_Get_Company", response.get());
            } else {
                responseData.put("Mews_Get_Company", "No Company found.");
            }
        }
        return response;
    }

    private Optional<MewsCompanyResponse> createCompanyInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, Map<String, Object> responseData) throws Exception {
        Optional<MewsCompanyResponse> createCompany;
        MewsCompanyRequest mewsCompanyRequest = mewsController.createCompanyPayload(booking, account, contact);
        createCompany = this.responseParser.addCompanyInMews(mewsCompanyRequest);
        if (createCompany.isPresent()) {
            responseData.put("Mews_Create_Company", createCompany.get());
        }
        return createCompany;
    }

    private Optional<MewsUpdateCompanyResponse> updateCompanyInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, MewsGetCompanyResponse companyMews, Map<String, Object> responseData) throws Exception {
        Optional<MewsUpdateCompanyResponse> updateCompany;
        MewsUpdateCompanyRequest request = mewsController.createUpdateCompanyPayload(account, booking, contact, companyMews);
        updateCompany = this.responseParser.updateCompanyInMews(request);
        if (updateCompany.isPresent()) {
            responseData.put("Mews_Update_Company", updateCompany.get());
        }
        return updateCompany;
    }

    private Optional<MewsGetBookerResponse> isBookerExistInMews(SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSAccountResponse pmsAccount, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetBookerResponse> response = Optional.empty();
        if (pmsAccount.getTotalSize() > 0) {
            MewsGetBookerRequest request = mewsController.createGetBookerPayload(account, contact);
            response = this.responseParser.getBookerFromMews(request);
            if (response.isPresent()) {
                MewsGetBookerResponse result = response.get();
                responseData.put("Mews_Get_Booker", response.get());
            } else {
                responseData.put("Mews_Get_Booker", "No Booker found.");
            }
        }
        return response;
    }

    private Optional<MewsBookerResponse> createBookerInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, Map<String, Object> responseData) throws Exception {
        Optional<MewsBookerResponse> createBooker;
        MewsBookerRequest request = mewsController.createBookerPayload(booking, account, contact);
        createBooker = this.responseParser.addBookerInMews(request);
        if (createBooker.isPresent()) {
            responseData.put("Mews_Create_Booker", createBooker.get());
        }
        return createBooker;
    }

    private Optional<MewsUpdateBookerResponse> updateBookerInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, MewsGetBookerResponse fetchedBooker, Map<String, Object> responseData) throws Exception {
        Optional<MewsUpdateBookerResponse> updateBooker;
        MewsUpdateBookerRequest request = mewsController.createUpdateBookerPayload(booking, account, contact, fetchedBooker);
        updateBooker = this.responseParser.updateBookerInMews(request);
        if (updateBooker.isPresent()) {
            responseData.put("Mews_Update_Booker", updateBooker.get());
        }
        return updateBooker;
    }

    private Optional<MewsGetAvailabilityBlockResponse> isAvailabilityBlockExistInMews(SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSBlockResponse pmsBlock, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetAvailabilityBlockResponse> response = Optional.empty();
        if (pmsBlock.getTotalSize() > 0) {
            MewsGetAvailabilityBlockRequest request = mewsController.createGetAvailabilityBlockPayload(account, contact);
            response = this.responseParser.getAvailabilityBlockFromMews(request);
            if (response.isPresent()) {
                MewsGetAvailabilityBlockResponse result = response.get();
                responseData.put("Mews_Get_Availability_Block", response.get());
            } else {
                responseData.put("Mews_Get_Availability_Block", "No Availability Block found.");
            }
        }
        return response;
    }

    private Optional<MewsAvailabilityBlockResponse> createAvailabilityBlockInMews(SalesforceBookingResponse booking, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, String bookerId, Map<String, Object> responseData) throws Exception {
        Optional<MewsAvailabilityBlockResponse> createAvailabilityBlock;
        MewsAvailabilityBlockRequest request = mewsController.createAvailabilityBlockPayload(booking, rate, contact, property, bookerId);
        createAvailabilityBlock = this.responseParser.addAvailabilityBlockInMews(request);
        if (createAvailabilityBlock.isPresent()) {
            responseData.put("Mews_Create_Availability_Block", createAvailabilityBlock.get());
        }
        return createAvailabilityBlock;
    }

    private String updateAvailabilityInMewsByCreated(SalesforceBookingResponse booking, SalesforceRateResponse rate, SalesforcePropertyResponse property,  Optional<MewsAvailabilityBlockResponse> availabilityBlock, SalesforceQueryResponse guest, Map<String, Object> responseData) throws Exception {
        MewsUpdateAvailabilityRequest request = mewsController.createUpdateAvailabilityPayload(booking, rate, property, availabilityBlock.get(), guest);
        String response = mewsController.updateAvailability(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Availability", response);
        }
        return response;
    }

    private String updateAvailabilityInMewsByGet(SalesforceBookingResponse booking, SalesforceRateResponse rate, SalesforcePropertyResponse property, Optional<MewsGetAvailabilityBlockResponse> availabilityBlock, SalesforceQueryResponse guest, Map<String, Object> responseData) throws Exception {
        MewsUpdateAvailabilityRequest request = mewsController.createUpdateAvailabilityPayloadByGet(booking, rate, property, availabilityBlock.get(), guest);
        String response = mewsController.updateAvailability(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Availability", response);
        }
        return response;
    }

    private String updateRatePriceInMewsByCreated(SalesforceBookingResponse booking, Optional<MewsAvailabilityBlockResponse> availabilityBlock, Map<String, Object> responseData) throws Exception {
        MewsUpdateRateRequest request = this.mewsController.createUpdateRatePricePayloadByCreated(booking, availabilityBlock.get());
        String response = this.mewsController.updateRate(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Rate_Price", response);
        }
        return response;
    }

    private String updateRatePriceInMewsByGet(SalesforceBookingResponse booking, Optional<MewsGetAvailabilityBlockResponse> availabilityBlock, Map<String, Object> responseData) throws Exception {
        MewsUpdateRateRequest request = this.mewsController.createUpdateRatePricePayloadByGet(booking, availabilityBlock.get());
        String response = this.mewsController.updateRate(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Rate_Price", response);
        }
        return response;
    }

    private String createPMSAccountForCompanyInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, Map<String, Object> responseData) throws Exception {
        PSMAccountRequest request = this.salesforceController.createPSMAccountPayload(booking, account, contact, rate, property);
        String pmsAccountRequestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSAccount(), salesforceToken.getAccess_token(), pmsAccountRequestString);

        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_PMS_Account", response);
            }
        }
        return response;
    }

    private String createGuestForBookerInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, Map<String, Object> responseData) throws Exception {
        SalesforceGuestRequest request = this.salesforceController.createGuestBookerPayload(booking, account, contact, rate, property);
        String pmsAccountRequestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforceGuest(), salesforceToken.getAccess_token(), pmsAccountRequestString);
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_Guest_For_Booker", response);
            }
        }
        return response;
    }

    private String createPMSBlockInSalesforceByGet(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, Optional<MewsGetAvailabilityBlockResponse>  availabiltyBlock, String pmsAccountResponseId, Map<String, Object> responseData) throws Exception {
        SalesforcePSMBlockRequest request = this.salesforceController.createPMSBlockPayloadByGet(booking, account, contact, rate, property, availabiltyBlock.get(), pmsAccountResponseId);
        String requestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlock(), salesforceToken.getAccess_token(), requestString);
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_PMS_Block", response);
            }
        }
        return response;
    }

    private String createPMSBlockInSalesforceByCreated(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, Optional<MewsAvailabilityBlockResponse> availabiltyBlock, String pmsAccountResponseId, Map<String, Object> responseData) throws Exception {
        SalesforcePSMBlockRequest request = this.salesforceController.createPMSBlockPayloadByCreated(booking, account, contact, rate, property, availabiltyBlock.get(), pmsAccountResponseId);
        String requestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlock(), salesforceToken.getAccess_token(), requestString);
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_PMS_Block", response);
            }
        }
        return response;
    }

    private String createMewsBlockInventoriesInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, String pmsBlockId, SalesforceQueryResponse guestRooms, Map<String, Object> responseData) throws Exception {
        SalesforcePMSBlockInventory request = this.salesforceController.createMewsBlockInventoryPayload(booking, account, contact, rate, property, pmsBlockId, guestRooms);
        String requestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforceMewsBlockinventory(), salesforceToken.getAccess_token(), requestString);
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_Mews_Block_Inventories", response);
            }
        }
        return response;
    }

    private String createPMSBlockRatesInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, String pmsBlockId, SalesforceQueryResponse guestRooms, Map<String, Object> responseData) throws Exception {
        SalesforcePMSBlockRate request = this.salesforceController.createPMSBlockRatesPayload(booking, account, contact, rate, property, pmsBlockId, guestRooms);
        String requestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlockRates(), salesforceToken.getAccess_token(), requestString);
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_PMS_Block_Rates", response);
            }
        }
        return response;
    }
    private String updateGuestRoomWithPmsBlockInSalesforce(SalesforceBookingResponse booking,SalesforceAccountResponse account,SalesforceContactResponse contact,SalesforceRateResponse rate,SalesforcePropertyResponse property,SalesforceTokenResponse salesforceToken,String pmsBlockId,SalesforceQueryResponse guestRooms,String pmsBlockRequestResponse, Map<String, Object> responseData) throws Exception {
        SalesforceUpdateGuestRoomWithPmsBlock request = this.salesforceController.createUpdateGuestRoomWithPmsBlock(booking,account,contact,rate,property,pmsBlockRequestResponse);
        String requestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.updateRecordInSalesforce(applicationConfiguration.getSalesforcePMSBlock(), salesforceToken.getAccess_token(), requestString,pmsBlockId);
        String result = "Failed";
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>(){});

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_PMS_Block_Rates", response);
                result = "Success";
            }
        }
        return result;
    }

    private String updateBookingInSalesforce(SalesforceBookingResponse booking,SalesforceAccountResponse account,SalesforceContactResponse contact,SalesforceRateResponse rate,SalesforcePropertyResponse property,SalesforceTokenResponse salesforceToken,String pmsBlockId,SalesforceQueryResponse guestRooms,SalesforcePSMBlockRequest block, Map<String, Object> responseData) throws Exception {
        SalesforceBookingRequest request = this.salesforceController.createBookingPayload(booking,account,contact,rate,property,block);
        String requestString = objectMapper.writeValueAsString(request);
        String response = this.salesforceController.addRecordInSalesforce(applicationConfiguration.getSalesforcePMSAccount(), salesforceToken.getAccess_token(), requestString);
        String result = "Failed";
        if (response != null && !response.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,Object> responseMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>(){});

            Boolean success = (Boolean) responseMap.get("success");
            String id = (String) responseMap.get("id");

            if (success != null && success && id != null && !id.isEmpty()) {
                responseData.put("Salesforce_Post_PMS_Block_Rates", response);
                result = "Success";
            }
        }
        return result;
    }


    private void setSuccessStatus(ApiResponse apiResponse, String message) {
        apiResponse.setStatus(ResponseStatus.FAILED);
        apiResponse.setMessage(message);
    }

    private void setFailedStatus(ApiResponse apiResponse, String message) {
        apiResponse.setStatus(ResponseStatus.FAILED);
        apiResponse.setMessage(message);
    }

    private void generateLog(String text) {
        logger.info(text);
    }
}
