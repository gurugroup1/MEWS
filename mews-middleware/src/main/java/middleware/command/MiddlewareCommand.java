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
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
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
    @Autowired
    private final ResponseParser responseParser;
    String bookerId = "";

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

    public SalesforceRestControllerResponse processRestRequest(SalesforceController salesforceController, String bookingId, SalesforceTokenResponse salesforceToken) {
        try {
            SalesforceRestControllerRequest request = salesforceController.createRestControllerPayload(bookingId);
            String restRequest = objectMapper.writeValueAsString(request);
            String restResponse = salesforceController.restControllerSalesforce(salesforceToken.getAccess_token(), restRequest);
            return objectMapper.readValue(restResponse, SalesforceRestControllerResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

                // Get Complete Data from salesforce using rest controller
                SalesforceRestControllerResponse restResponses = processRestRequest(salesforceController , bookingId, salesforceToken);
                System.out.println(restResponses);
                if(Objects.equals(restResponses.getStatus(), "Success")){
                    responseData.put("Salesforce_Data",restResponses);
                    setSuccessStatus(apiResponse,"Process has been completed.");
                }
                else{
                    setFailedStatus(apiResponse, "Error in getting initial data from salesforce.");
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

        // Step 1: Verify pmsAccount.getTotalSize()
        if (pmsAccount.getTotalSize() > 0) {
            MewsGetBookerRequest request = mewsController.createGetBookerPayload(account, contact);

            try {
                // Step 2: Check getBookerFromMews method
                response = this.responseParser.getBookerFromMews(request);

                if (response.isPresent()) {
                    MewsGetBookerResponse result = response.get();
                    responseData.put("Mews_Get_Booker", response.get());
                } else {
                    responseData.put("Mews_Get_Booker", "No Booker found.");
                }
            } catch (Exception e) {
                // Step 5: Exception handling
                responseData.put("Mews_Get_Booker_Error", e.getMessage());
                // You may also print the exception stack trace for further debugging.
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
            MewsGetAvailabilityBlockRequest request = mewsController.createGetAvailabilityBlockPayload(account, contact,pmsBlock);
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

    private String updateAvailabilityInMewsByCreated(SalesforceBookingResponse booking, SalesforceRateResponse rate, SalesforcePropertyResponse property, Optional<MewsAvailabilityBlockResponse> availabilityBlock, SalesforceQueryResponse guest, Map<String, Object> responseData) throws Exception {
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

    private String createPMSAccountForCompanyInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken,SalesforceQueryResponse guestRooms,Optional<MewsCompanyResponse> createdcompanyId, Map<String, Object> responseData) throws Exception {
        PSMAccountRequest request = this.salesforceController.createPSMAccountPayload(booking, account, contact, rate, property,createdcompanyId);
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

    private String createPMSBlockInSalesforceByGet(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken ,Optional<MewsAvailabilityBlockResponse> availabiltyBlock, String pmsAccountResponseId,String contactId,SalesforceQueryResponse guestRooms, Map<String, Object> responseData) throws Exception {
        SalesforcePSMBlockRequest request = this.salesforceController.createPMSBlockPayloadByGet(booking, account, contact, rate, property, availabiltyBlock.get(), pmsAccountResponseId,contactId,guestRooms);
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

    private String createPMSBlockInSalesforceByCreated(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, Optional<MewsAvailabilityBlockResponse> availabiltyBlock, String pmsAccountResponseId,String contactId,SalesforceQueryResponse guestRooms, Map<String, Object> responseData) throws Exception {
        SalesforcePSMBlockRequest request = this.salesforceController.createPMSBlockPayloadByCreated(booking, account, contact, rate, property, availabiltyBlock.get(), pmsAccountResponseId,contactId,guestRooms);
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

    private String updateGuestRoomWithPmsBlockInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, SalesforceQueryResponse guestRoom, String pmsBlockId, Map<String, Object> responseData) throws Exception {
        SalesforceUpdateGuestRoomWithPmsBlock request = this.salesforceController.createUpdateGuestRoomWithPmsBlock(booking, account, contact, rate, property, guestRoom, pmsBlockId);
        String requestString = objectMapper.writeValueAsString(request);
        String guestRoomId = guestRoom.getRecords().get(0).getId();
        System.out.println("guestRoomId" + guestRoomId);
        String response = this.salesforceController.updateRecordInSalesforce(applicationConfiguration.getSalesforceGuestRooms(), salesforceToken.getAccess_token(), requestString, guestRoomId);

        if (response.isEmpty()) {
            responseData.put("Salesforce_Update_Guest_Room_With_PMS_Block", response);
        }
        return response;
    }

    private String updateBookingInSalesforce(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, SalesforceTokenResponse salesforceToken, Map<String, Object> responseData, String pmsAccountResponseId) throws Exception {
        SalesforceBookingRequest request = this.salesforceController.createBookingPayload(booking, account, contact, rate, property, pmsAccountResponseId);
        String requestString = objectMapper.writeValueAsString(request);
        String bookingId = booking.getId();
        System.out.println("bookingId" + bookingId);
        String response = this.salesforceController.updateRecordInSalesforce(applicationConfiguration.getSalesforceBookingObject(), salesforceToken.getAccess_token(), requestString, bookingId);
        System.out.println("response" + response);
        if (response.isEmpty()) {
            responseData.put("Salesforce_Update_Booking", response);
        }
        return response;
    }


    private void setSuccessStatus(ApiResponse apiResponse, String message) {
        apiResponse.setStatus(ResponseStatus.SUCCESS);
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
