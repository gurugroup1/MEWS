package MewsConnector.controllers;

import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.*;
import MewsConnector.services.*;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);
    private SalesforceController salesforceController;
    private ApplicationConfiguration applicationConfiguration;
    private MewsController mewsController;
    private AuthController authController;
    private SecretKeyManagerController secretKeyManagerController;
    private SalesforceConnectorService salesforceConnectorService;
    private MewsConnectorService MewsConnectorService;


    public WebhookController() {
        this.salesforceConnectorService = new SalesforceConnectorService();
        this.MewsConnectorService = new MewsConnectorService();
        this.mewsController = new MewsController(this.MewsConnectorService);
        this.secretKeyManagerController = new SecretKeyManagerController();
        this.salesforceController = new SalesforceController(this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(this.secretKeyManagerController,this.salesforceConnectorService);
    }

    public String extractEventData(SQSEvent event) {
        if (event.getRecords().isEmpty()) {
            logger.info("No records found in SQS event");
            return null;
        }

        SQSEvent.SQSMessage sqsMessage = event.getRecords().get(0);
        String bookingId;
        try {
            JsonNode bodyNode = new ObjectMapper().readTree(sqsMessage.getBody());
            bookingId = bodyNode.get("BookingId").asText();
            logger.info("Booking Id: " + bookingId);
        } catch (IOException e) {
            logger.error("Error occurred while extracting booking ID from SQS message body", e);
            throw new CustomException("Error extracting booking ID", e);
        }

        return bookingId;
    }

    public String startSalesforceProcess(String bookingId) throws Exception {
        SalesforceBookingResponse booking = this.getSalesforceBookingRecord(bookingId);

        SalesforceAccountResponse account =  this.getSalesforceAccountRecord(booking);

        SalesforceContactResponse contact =  this.getSalesforceContactRecord(booking);

        MewsCompanyRequest mewsCompanyRequest = this.mewsController.createCompanyPayload(booking,account,contact);

        MewsCompanyResponse mewsCompanyResponse = this.addCompanyInMews(mewsCompanyRequest);

//        MewsBookerRequest mewsBookerRequest = this.mewsController.createBookerPayload(booking,account,contact);
//
//        MewsBookerResponse  booker = this.addBookerInMews(mewsBookerRequest);
//
//        SalesforceRateResponse rate =  this.getSalesforceRateRecord(booking);
//        SalesforcePropertyResponse property = this.getSalesforceHotelRecord(rate);
//
//        MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = this.mewsController.createAvailabilityBlockPayload(booking,rate,property,booker);
//
//        MewsAvailabilityBlockResponse availabilityBlock = this.addAvailabilityBlockInMews(mewsAvailabilityBlockRequest);
        return  null;
    }

    public SalesforceBookingResponse getSalesforceBookingRecord(String bookingId) throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();

        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }

        String bookingResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceBookingObject(),
                salesforceToken.getAccess_token(),
                bookingId
        );

        if (bookingResponse == null || bookingResponse.isEmpty()) {
            throw new Exception("Empty Salesforce booking response.");
        }
        logger.info("Salesforce Booking Response: " + bookingResponse);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(bookingResponse, SalesforceBookingResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Salesforce Booking Response", e);
        }
    }


    public SalesforceAccountResponse getSalesforceAccountRecord(SalesforceBookingResponse bookingObject) throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();

        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }

        String accountResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceAccountObject(),
                salesforceToken.getAccess_token(),
                bookingObject.getThn__Company__c()
        );

        if (accountResponse == null || accountResponse.isEmpty()) {
            throw new Exception("Empty Salesforce account response.");
        }

        logger.info("Salesforce Account Response: " + accountResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(accountResponse, SalesforceAccountResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Salesforce Account Response", e);
        }
    }


    public SalesforceContactResponse getSalesforceContactRecord(SalesforceBookingResponse bookingObject) throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();

        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }

        String contactResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceCompanyContactObject(),
                salesforceToken.getAccess_token(),
                bookingObject.getThn__Company_Contact__c()
        );

        if (contactResponse == null || contactResponse.isEmpty()) {
            throw new Exception("Empty Salesforce contact response.");
        }

        logger.info("Salesforce Contact Response: " + contactResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(contactResponse, SalesforceContactResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Salesforce Contact Response", e);
        }
    }


    public SalesforceRateResponse getSalesforceRateRecord(SalesforceBookingResponse bookingObject) throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();

        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }

        String rateResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceRateObject(),
                salesforceToken.getAccess_token(),
                bookingObject.getThn__Block_Rate__c()
        );

        if (rateResponse == null || rateResponse.isEmpty()) {
            throw new Exception("Empty Salesforce rate response.");
        }

        logger.info("Salesforce Rate Response: " + rateResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(rateResponse, SalesforceRateResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Salesforce Rate Response", e);
        }
    }


    public SalesforcePropertyResponse getSalesforceHotelRecord(SalesforceRateResponse rateObject) throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();

        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }

        String propertyResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforcePropertyObject(),
                salesforceToken.getAccess_token(),
                rateObject.getHotel()
        );

        if (propertyResponse == null || propertyResponse.isEmpty()) {
            throw new Exception("Empty Salesforce property response.");
        }

        logger.info("Salesforce Property Response: " + propertyResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(propertyResponse, SalesforcePropertyResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Salesforce Property Response", e);
        }
    }


    public MewsCompanyResponse addCompanyInMews(MewsCompanyRequest mewsCompanyRequest) throws Exception {
        String companyResponse = mewsController.addCompany(mewsCompanyRequest);

        if (companyResponse == null || companyResponse.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        logger.info("Mews Company Response: " + companyResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode responseJson = objectMapper.readTree(companyResponse);

            if (responseJson.has("error")) {
                String errorMessage = responseJson.get("error").asText();
                throw new Exception("Error in Company response from Mews: " + errorMessage);
            }

            return objectMapper.readValue(companyResponse, MewsCompanyResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Company Response", e);
        }
    }


    public MewsBookerResponse addBookerInMews(MewsBookerRequest mewsBookerRequest) throws Exception {
        String bookerResponse = mewsController.addBooker(mewsBookerRequest);

        if (bookerResponse == null || bookerResponse.isEmpty()) {
            throw new Exception("Empty booker response from Mews.");
        }

        logger.info("Mews Booker Response: " + bookerResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode responseJson = objectMapper.readTree(bookerResponse);

            if (responseJson.has("error")) {
                String errorMessage = responseJson.get("error").asText();
                throw new Exception("Error in booker response from Mews: " + errorMessage);
            }

            return objectMapper.readValue(bookerResponse, MewsBookerResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Booker Response", e);
        }
    }



    public MewsAvailabilityBlockResponse addAvailabilityBlockInMews(MewsAvailabilityBlockRequest request) throws Exception {
        String availabilityResponse = mewsController.addAvailabilityBlock(request);

        if (availabilityResponse == null || availabilityResponse.isEmpty()) {
            throw new Exception("Empty availability block response from Mews.");
        }

        logger.info("Mews Availability Response: " + availabilityResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            JsonNode responseJson = objectMapper.readTree(availabilityResponse);

            if (responseJson.has("error")) {
                String errorMessage = responseJson.get("error").asText();
                throw new Exception("Error in Company response from Mews: " + errorMessage);
            }

            return objectMapper.readValue(availabilityResponse, MewsAvailabilityBlockResponse.class);
        } catch (IOException e) {
            throw new Exception("Unable to parse Availability Block Response", e);
        }
    }

}
