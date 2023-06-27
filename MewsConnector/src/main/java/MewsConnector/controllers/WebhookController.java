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

    public String startSalesforceProcess(String bookingId) throws CustomException, JsonProcessingException {
        SalesforceBookingResponse booking =  this.getSalesforceRecord(bookingId);
        logger.info(booking.getId());

//        SalesforceAccountResponse account =  this.getSalesforceAccountRecord(booking);
//        logger.info(account.getName());
//        SalesforceContactResponse contact =  this.getSalesforceContactRecord(booking);

//        MewsCompanyRequest mewsCompanyRequest = this.mewsController.createCompanyPayload(booking.getQuote_Notes__c(),account.getName(),account,contact);
//        logger.info("MEWS Company Request: " + mewsCompanyRequest);
//
//        this.addCompanyInMews(mewsCompanyRequest);
        return  null;
    }

    public SalesforceBookingResponse getSalesforceRecord(String bookingId) throws CustomException, JsonProcessingException {
//        SalesforceTokenResponse salesforceToken;
//        try {
//            salesforceToken = authController.retrieveSalesforceTokenFromAWS();
//        } catch (Exception e) {
//            throw new CustomException("Unable to retrieve Salesforce token", e);
//        }

        String bookingResponse = salesforceController.getBookingFromSalesforce(
                applicationConfiguration.getSalesforceBookingObject(),
                "00DFg0000002xSD!AQEAQKC5t05UVHKVky7USL9JBg7KiKqwHN5GrmWga3js92o8.jYe1aX71k6RTM38c_WyfzQrtrJ0Es0WTDPcITzCCmhGOF9o",
                bookingId
        );

        logger.info("Salesforce Booking Response: " + bookingResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceBookingResponse bookingObject;
        try {
            bookingObject = objectMapper.readValue(bookingResponse, SalesforceBookingResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Salesforce Booking Response", e);
        }
        logger.info("Salesforce Booking Response: " + bookingObject.getId());
        return bookingObject;
    }

    public SalesforceAccountResponse getSalesforceAccountRecord(SalesforceBookingResponse bookingObject) throws CustomException, JsonProcessingException {
        String accountResponse = salesforceController.getBookingFromSalesforce(
                applicationConfiguration.getSalesforceAccountObject(),
                "00DFg0000002xSD!AQEAQKC5t05UVHKVky7USL9JBg7KiKqwHN5GrmWga3js92o8.jYe1aX71k6RTM38c_WyfzQrtrJ0Es0WTDPcITzCCmhGOF9o",
                bookingObject.getThn__Company__c()
        );

        logger.info("Salesforce Account Response: " + accountResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceAccountResponse accountObject;
        try {
            accountObject = objectMapper.readValue(accountResponse, SalesforceAccountResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Salesforce Account Response", e);
        }
        logger.info(accountObject.getName());
        return accountObject;
    }

    public SalesforceContactResponse getSalesforceContactRecord(SalesforceBookingResponse bookingObject) throws CustomException, JsonProcessingException {
        String contactResponse = salesforceController.getBookingFromSalesforce(
                applicationConfiguration.getSalesforceCompanyContactObject(),
                "00DFg0000002xSD!AQEAQKC5t05UVHKVky7USL9JBg7KiKqwHN5GrmWga3js92o8.jYe1aX71k6RTM38c_WyfzQrtrJ0Es0WTDPcITzCCmhGOF9o",
                bookingObject.getThn__Company_Contact__c()
        );

        logger.info("Salesforce Contact Response: " + contactResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceContactResponse contactObject;
        try {
            contactObject = objectMapper.readValue(contactResponse, SalesforceContactResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Salesforce Contact Response", e);
        }

        return contactObject;
    }

    public String addCompanyInMews(MewsCompanyRequest mewsCompanyRequest) throws CustomException, JsonProcessingException {
        String companyResponse = mewsController.addCompany(mewsCompanyRequest);

        logger.info("Mews Company Response: " + companyResponse);

//        ObjectMapper objectMapper = new ObjectMapper();
//        SalesforceContactResponse contactObject;
//        try {
//            contactObject = objectMapper.readValue(contactResponse, SalesforceContactResponse.class);
//        } catch (IOException e) {
//            throw new CustomException("Unable to parse Salesforce Contact Response", e);
//        }

        return "companyResponse";
    }

}
