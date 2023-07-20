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
                if(booking != null){
                    SalesforceQueryResponse guestRoom = getGuestDetails(salesforceToken, bookingId, apiResponse, responseData);
                    if(guestRoom != null){
                        SalesforceAccountResponse account = getAccountDetails(salesforceToken, booking, apiResponse, responseData);
                        if(account != null){
                            SalesforceContactResponse contact = getContactDetails(salesforceToken, booking, apiResponse, responseData);
//                            if(contact != null){
//                                SalesforceContactResponse contact = getContactDetails(salesforceToken, booking, apiResponse, responseData);
//                            }
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
        Optional<SalesforceQueryResponse> response = this.responseParser.retrieveAndParseQueryResponse(salesforceToken, bookingId, SalesforceQueryResponse.class);
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
        Optional<SalesforceAccountResponse> response = this.responseParser.retrieveAndParseResponse(salesforceToken,booking.getThn__Company__c(), SalesforceAccountResponse.class, applicationConfiguration.getSalesforceAccountObject());
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
        Optional<SalesforceContactResponse> response = this.responseParser.retrieveAndParseResponse(salesforceToken,booking.getThn__Company_Contact__c(), SalesforceContactResponse.class, applicationConfiguration.getSalesforceCompanyContactObject());
        if (response.isPresent()) {
            responseData.put("Salesforce_Get_Contact", response.get());
            SalesforceContactResponse result = response.get();
            return result;
        } else {
            setFailedStatus(apiResponse, "Request body does not contain Contact Id");
            return null;
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
