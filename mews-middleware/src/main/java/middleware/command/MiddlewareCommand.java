package middleware.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
    private String bookingId;

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
                StateController state = new StateController();
                generateLog("**** Mews Middleware Start ****");
                apiResponse.setBookingId(bookingId);
                SalesforceTokenResponse salesforceToken = this.responseParser.retrieveSalesforceToken();
                state.setBookingId(bookingId);

                // Get Complete Data from salesforce using rest controller
                SalesforceRestControllerResponse restResponses = processRestRequest(salesforceController, bookingId, salesforceToken, state);
                processCompany(state, responseData);
                processBooker(state, responseData);
                processAvailabilityBlock(state, responseData);
                processUpdateInMews(state, responseData);

                if (Objects.equals(restResponses.getStatus(), "Success")) {
                    responseData.put("Salesforce_Data", restResponses);
                    setSuccessStatus(apiResponse, "Process has been completed.");
                } else {
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

    public SalesforceRestControllerResponse processRestRequest(SalesforceController salesforceController, String bookingId, SalesforceTokenResponse salesforceToken, StateController state) {
        try {
            SalesforceRestControllerRequest request = salesforceController.createRestControllerPayload(bookingId);
            String restRequest = objectMapper.writeValueAsString(request);
            String restResponse = salesforceController.restControllerSalesforce(salesforceToken.getAccess_token(), restRequest);
            SalesforceRestControllerResponse restResponses = objectMapper.readValue(restResponse, SalesforceRestControllerResponse.class);

            SalesforceBookingResponse booking = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getBooking()), SalesforceBookingResponse.class);
            state.setBookingData(booking);

            SalesforceAccountResponse account = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getAccount()), SalesforceAccountResponse.class);
            state.setAccountData(account);

            SalesforceContactResponse contact = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getContact()), SalesforceContactResponse.class);
            state.setContactData(contact);

            SalesforceRateResponse rate = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getRate()), SalesforceRateResponse.class);
            state.setRateData(rate);

            SalesforcePropertyResponse property = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getProperty()), SalesforcePropertyResponse.class);
            state.setPropertyData(property);

            SalesforceGetPMSAccountResponse pmsAccount = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getPmsAccount()), SalesforceGetPMSAccountResponse.class);
            state.setPmsAccountData(pmsAccount);

            List<SalesforceGetPMSBlockResponse> pmsBlock = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getPmsBlock()), new TypeReference<List<SalesforceGetPMSBlockResponse>>() {
            });
            state.setPmsBlockData(pmsBlock);

            List<SalesforceGuestRoomResponse> guestRoom = objectMapper.readValue(objectMapper.writeValueAsString(restResponses.getGuestRooms()), new TypeReference<List<SalesforceGuestRoomResponse>>() {
            });
            state.setGuestRoomData(guestRoom);
            System.out.println(account);
            System.out.println(state.getAccountData().getName());
            state.setPmsAccountSize(restResponses.getPmsAccount() == null ? 0 : 1);
            state.setPmsBlockSize(restResponses.getPmsBlock().isEmpty() ? 0 : 1);
            return objectMapper.readValue(restResponse, SalesforceRestControllerResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<MewsGetCompanyResponse> processCompany(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetCompanyResponse> response = Optional.empty();
        System.out.println(state.getPmsAccountSize());
        if (state.getPmsAccountSize() > 1) {
            MewsGetCompanyRequest request = mewsController.createGetCompanyPayload(state.getAccountData());
            response = this.responseParser.getCompanyFromMews(request);
            if (response.isPresent()) {
                state.setHasCompany(true);
                state.setMewsCompany(response.get());
                updateCompanyInMews(state, responseData);
            }
        } else {
            state.setHasCompany(false);
            createCompanyInMews(state, responseData);
        }
        return response;
    }

    private Optional<MewsCompanyResponse> createCompanyInMews(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsCompanyResponse> createCompany;
        MewsCompanyRequest mewsCompanyRequest = mewsController.createCompanyPayload(state.getBookingData(), state.getAccountData(), state.getContactData());
        createCompany = this.responseParser.addCompanyInMews(mewsCompanyRequest);
        if (createCompany.isPresent()) {
            state.setMewsCompanyCreated(createCompany.get());
            responseData.put("Mews_Create_Company", createCompany.get());
        }
        return createCompany;
    }

    private Optional<MewsUpdateCompanyResponse> updateCompanyInMews(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsUpdateCompanyResponse> updateCompany;
        MewsUpdateCompanyRequest request = mewsController.createUpdateCompanyPayload(state.getAccountData(), state.getBookingData(), state.getContactData(), state.getMewsCompany());
        updateCompany = this.responseParser.updateCompanyInMews(request);
        if (updateCompany.isPresent()) {
            responseData.put("Mews_Update_Company", updateCompany.get());
        }
        return updateCompany;
    }

    private Optional<MewsGetBookerResponse> processBooker(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetBookerResponse> response = Optional.empty();
        if (state.getPmsAccountSize() > 1) {
            MewsGetBookerRequest request = mewsController.createGetBookerPayload(state.getAccountData(), state.getContactData());
            response = this.responseParser.getBookerFromMews(request);
            if (response.isPresent()) {
                state.setMewsBooker(response.get());
                updateBookerInMews(state, responseData);
            }
        } else {
            createBookerInMews(state, responseData);
        }
        return response;
    }

    private Optional<MewsBookerResponse> createBookerInMews(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsBookerResponse> createBooker;
        MewsBookerRequest request = mewsController.createBookerPayload(state.getBookingData(), state.getAccountData(), state.getContactData());
        createBooker = this.responseParser.addBookerInMews(request);
        if (createBooker.isPresent()) {
            state.setMewsBookerCreated(createBooker.get());
            responseData.put("Mews_Create_Booker", createBooker.get());
        }
        return createBooker;
    }

    private Optional<MewsUpdateBookerResponse> updateBookerInMews(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsUpdateBookerResponse> updateBooker;
        MewsUpdateBookerRequest request = mewsController.createUpdateBookerPayload(state.getBookingData(), state.getAccountData(), state.getContactData(), state.getMewsBooker());
        updateBooker = this.responseParser.updateBookerInMews(request);
        if (updateBooker.isPresent()) {
            responseData.put("Mews_Update_Booker", updateBooker.get());
        }
        return updateBooker;
    }

    private Optional<MewsGetAvailabilityBlockResponse> processAvailabilityBlock(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetAvailabilityBlockResponse> response = Optional.empty();
        if (state.getPmsBlockSize() > 1) {
            MewsGetAvailabilityBlockRequest request = mewsController.createGetAvailabilityBlockPayload(state.getAccountData(), state.getContactData(), state.getPmsBlockData().get(0));
            response = this.responseParser.getAvailabilityBlockFromMews(request);
            if (response.isPresent()) {
                state.setMewsAvailabilityBlock(response.get());
                state.setHasAvailabilityBlock(true);
            }
        } else {
            state.setHasAvailabilityBlock(false);
            createAvailabilityBlockInMews(state, responseData);
        }
        return response;
    }

    private Optional<MewsAvailabilityBlockResponse> createAvailabilityBlockInMews(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsAvailabilityBlockResponse> createAvailabilityBlock;
        MewsAvailabilityBlockRequest request = mewsController.createAvailabilityBlockPayload(state.getBookingData(), state.getRateData(), state.getContactData(), state.getPropertyData(), state.getPmsAccountSize() > 0 ? state.getMewsBooker().getCustomers().get(0).getId() : state.getMewsBookerCreated().getId());
        createAvailabilityBlock = this.responseParser.addAvailabilityBlockInMews(request);
        if (createAvailabilityBlock.isPresent()) {
            state.setMewsAvailabilityBlockCreated(createAvailabilityBlock.get());
            responseData.put("Mews_Create_Availability_Block", createAvailabilityBlock.get());
        }
        return createAvailabilityBlock;
    }

    private String processUpdateInMews(StateController state, Map<String, Object> responseData) throws Exception {
        Optional<MewsGetBookerResponse> response = Optional.empty();
        if (state.getHasAvailabilityBlock()) {
            updateRatePriceInMewsByGet(state, responseData);
        } else {
            updateRatePriceInMewsByCreated(state, responseData);
        }
        return "response";
    }

    private String updateRatePriceInMewsByGet(StateController state, Map<String, Object> responseData) throws Exception {
        MewsUpdateRateRequest request = this.mewsController.createUpdateRatePricePayloadByGet(state.getBookingData(), state.getMewsAvailabilityBlock());
        String response = this.mewsController.updateRate(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Rate_Price", response);
        }
        return response;
    }

    private String updateRatePriceInMewsByCreated(StateController state, Map<String, Object> responseData) throws Exception {
        MewsUpdateRateRequest request = this.mewsController.createUpdateRatePricePayloadByCreated(state.getBookingData(), state.getMewsAvailabilityBlockCreated());
        String response = this.mewsController.updateRate(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Rate_Price", response);
        }
        return response;
    }

    private String updateAvailabilityInMewsByGet(StateController state, Map<String, Object> responseData) throws Exception {
        MewsUpdateAvailabilityRequest request = mewsController.createUpdateAvailabilityPayloadByGet(state.getBookingData(), state.getRateData(), state.getPropertyData(), state.getMewsAvailabilityBlock(), state.getGuestRoomData());
        String response = mewsController.updateAvailability(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Availability", response);
        }
        return response;
    }

    private String updateAvailabilityInMewsByCreated(StateController state, Map<String, Object> responseData) throws Exception {
        MewsUpdateAvailabilityRequest request = mewsController.createUpdateAvailabilityPayload(state.getBookingData(), state.getRateData(), state.getPropertyData(), state.getMewsAvailabilityBlockCreated(), state.getGuestRoomData());
        String response = mewsController.updateAvailability(request);
        if (response.equals("{}")) {
            responseData.put("Mews_Update_Availability", response);
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
