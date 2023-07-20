package middleware.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import middleware.configurations.ApplicationConfiguration;
import middleware.controllers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.enums.ResponseStatus;
import middleware.models.*;
import middleware.services.MewsConnectorService;
import middleware.services.SalesforceConnectorService;
import middleware.util.JsonUtils;
import middleware.controllers.ResponseParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
                                                Optional<MewsGetCompanyResponse> companyMews = isCompanyExistInMews(booking, account, contact, pmsAccount, apiResponse, responseData);
                                                if (!companyMews.isPresent()) {
                                                    Optional<MewsCompanyResponse> createdCompany = createCompanyInMews(booking, account, contact, pmsAccount, apiResponse, responseData);
                                                } else {
                                                    Optional<MewsUpdateCompanyResponse> createdCompany = updateCompanyInMews(booking, account, contact, pmsAccount,companyMews.get(), apiResponse, responseData);
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

    private Optional<MewsGetCompanyResponse> isCompanyExistInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSAccountResponse pmsAccount, ApiResponse apiResponse, Map<String, Object> responseData) throws Exception {
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

    private Optional<MewsCompanyResponse> createCompanyInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSAccountResponse pmsAccount, ApiResponse apiResponse, Map<String, Object> responseData) throws Exception {
        Optional<MewsCompanyResponse> createCompany;
        MewsCompanyRequest mewsCompanyRequest = mewsController.createCompanyPayload(booking, account, contact);
        createCompany = this.responseParser.addCompanyInMews(mewsCompanyRequest);
        if (createCompany.isPresent()) {
            responseData.put("Mews_Create_Company", createCompany.get());
        }
        return createCompany;
    }

    private Optional<MewsUpdateCompanyResponse> updateCompanyInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSAccountResponse pmsAccount,MewsGetCompanyResponse companyMews ,ApiResponse apiResponse, Map<String, Object> responseData) throws Exception {
        Optional<MewsUpdateCompanyResponse> updateCompany;
        MewsUpdateCompanyRequest mewsCompanyRequest = mewsController.createUpdateCompanyPayload(account, booking, contact, companyMews);
        updateCompany = this.responseParser.updateCompanyInMews(mewsCompanyRequest);
        if (updateCompany.isPresent()) {
            responseData.put("Mews_Update_Company", updateCompany.get());
        }
        return updateCompany;
    }


//    private void isCompanyExistInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSAccountResponse pmsAccount, ApiResponse apiResponse, Map<String, Object> responseData) throws Exception {
//
//        Optional<MewsUpdateCompanyResponse> updateCompany = Optional.empty();
//        Optional<MewsCompanyResponse> createCompany = Optional.empty();
//
//        if (pmsAccount.getTotalSize() > 0) {
//            MewsGetCompanyRequest request = mewsController.createGetCompanyPayload(account);
//            Optional<MewsGetCompanyResponse> response = this.responseParser.getCompanyFromMews(request);
//            if (response.isPresent()) {
//                MewsGetCompanyResponse result = response.get();
//                responseData.put("Mews_Get_Company", response.get());
//                List<MewsGetCompanyResponse.Company> companies = result.getCompanies();
//                if (!companies.isEmpty()) {
//                    MewsUpdateCompanyRequest mewsCompanyRequest = mewsController.createUpdateCompanyPayload(account, booking, contact, response.get());
//                    updateCompany = this.responseParser.updateCompanyInMews(mewsCompanyRequest);
//                }
//            }
//        } else {
//            MewsCompanyRequest mewsCompanyRequest = mewsController.createCompanyPayload(booking, account, contact);
//            createCompany = this.responseParser.addCompanyInMews(mewsCompanyRequest);
//        }
//
//        if (updateCompany.isPresent()) {
//            responseData.put("Mews_Update_Company", updateCompany.get());
//        }
//        if (createCompany.isPresent()) {
//            responseData.put("Mews_Create_Company", createCompany.get());
//        }
//    }

    private void isBookerExistInMews(SalesforceBookingResponse booking, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceGetPMSAccountResponse pmsAccount, ApiResponse apiResponse, Map<String, Object> responseData) throws Exception {

        Optional<MewsUpdateBookerResponse> updateBooker = Optional.empty();
        Optional<MewsBookerResponse> createBooker = Optional.empty();
        if (pmsAccount.getTotalSize() > 0) {
            MewsGetBookerRequest mewsGetBookerRequest = mewsController.createGetBookerPayload(account, contact);
            Optional<MewsGetBookerResponse> response = this.responseParser.getBookerFromMews(mewsGetBookerRequest);
            if (response.isPresent()) {
                MewsGetBookerResponse result = response.get();
                responseData.put("Mews_Get_Booker", response.get());
                if (result.getCustomers().length > 0) {
                    MewsUpdateBookerRequest mewsBookerRequest = mewsController.createUpdateBookerPayload(booking, account, contact, response.get());
                    updateBooker = this.responseParser.updateBookerInMews(mewsBookerRequest);
                }
            }
        } else {
            MewsBookerRequest mewsBookerRequest = this.mewsController.createBookerPayload(booking, account, contact);
            createBooker = this.responseParser.addBookerInMews(mewsBookerRequest);
        }

        if (updateBooker.isPresent()) {
            responseData.put("Mews_Update_Booker", updateBooker.get());
        }
        if (createBooker.isPresent()) {
            responseData.put("Mews_Create_Booker", createBooker.get());
        }
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
