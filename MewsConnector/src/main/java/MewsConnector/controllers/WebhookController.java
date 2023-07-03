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
        SalesforceBookingResponse booking = this.getSalesforceBookingRecord(bookingId);

        SalesforceAccountResponse account =  this.getSalesforceAccountRecord(booking);

        SalesforceContactResponse contact =  this.getSalesforceContactRecord(booking);

        MewsCompanyRequest mewsCompanyRequest = this.mewsController.createCompanyPayload(booking,account,contact);

        MewsCompanyResponse  mewsCompanyResponse =this.addCompanyInMews(mewsCompanyRequest);
        logger.info("MEWS Company Response: " + mewsCompanyResponse.getCursor());

        MewsBookerRequest mewsBookerRequest = this.mewsController.createBookerPayload(booking,account,contact);

        MewsBookerResponse  booker = this.addBookerInMews(mewsBookerRequest);
        logger.info("MEWS Booker Response: " + booker.getAccountingCode());

        SalesforceRateResponse rate =  this.getSalesforceRateRecord(booking);
        SalesforcePropertyResponse property = this.getSalesforceHotelRecord(rate);

        MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = this.mewsController.createAvailabilityBlockPayload(booking,rate,property,booker);

        MewsAvailabilityBlockResponse availabilityBlock = this.addAvailabilityBlockInMews(mewsAvailabilityBlockRequest);
        return  null;
    }

    public SalesforceBookingResponse getSalesforceBookingRecord(String bookingId) throws CustomException, JsonProcessingException {

        String bookingResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceBookingObject(),
                "00DFg0000002xSD!AQEAQGABI.Gv1MIOC_NgDmcGSC18rFYo.hQF4MiMit88sW7_s2T6iM8T_GeDx8nj5GNFSHcah8e87nBvb_iNv56CreIdJDzh",
                bookingId
        );

        if (bookingResponse == null || bookingResponse.isEmpty()) {
            logger.error("Received empty Salesforce booking response.");
        }

        logger.info("Salesforce Booking Response: " + bookingResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceBookingResponse bookingObject;
        try {
            bookingObject = objectMapper.readValue(bookingResponse, SalesforceBookingResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Salesforce Booking Response", e);
        }
        return bookingObject;
    }

    public SalesforceAccountResponse getSalesforceAccountRecord(SalesforceBookingResponse bookingObject) throws CustomException, JsonProcessingException {
        String accountResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceAccountObject(),
                "00DFg0000002xSD!AQEAQGABI.Gv1MIOC_NgDmcGSC18rFYo.hQF4MiMit88sW7_s2T6iM8T_GeDx8nj5GNFSHcah8e87nBvb_iNv56CreIdJDzh",
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

        return accountObject;
    }

    public SalesforceContactResponse getSalesforceContactRecord(SalesforceBookingResponse bookingObject) throws CustomException, JsonProcessingException {
        String contactResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceCompanyContactObject(),
                "00DFg0000002xSD!AQEAQGABI.Gv1MIOC_NgDmcGSC18rFYo.hQF4MiMit88sW7_s2T6iM8T_GeDx8nj5GNFSHcah8e87nBvb_iNv56CreIdJDzh",
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

    public SalesforceRateResponse getSalesforceRateRecord(SalesforceBookingResponse bookingObject) throws CustomException, JsonProcessingException {
        String rateResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforceRateObject(),
                "00DFg0000002xSD!AQEAQGABI.Gv1MIOC_NgDmcGSC18rFYo.hQF4MiMit88sW7_s2T6iM8T_GeDx8nj5GNFSHcah8e87nBvb_iNv56CreIdJDzh",
                bookingObject.getThn__Block_Rate__c()
        );

        logger.info("Salesforce Rate Response: " + rateResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceRateResponse rateObject;
        try {
            rateObject = objectMapper.readValue(rateResponse, SalesforceRateResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Salesforce Contact Response", e);
        }

        return rateObject;
    }

    public SalesforcePropertyResponse getSalesforceHotelRecord(SalesforceRateResponse rateObject) throws CustomException, JsonProcessingException {
        String propertyResponse = salesforceController.getRecordFromSalesforce(
                applicationConfiguration.getSalesforcePropertyObject(),
                "00DFg0000002xSD!AQEAQGABI.Gv1MIOC_NgDmcGSC18rFYo.hQF4MiMit88sW7_s2T6iM8T_GeDx8nj5GNFSHcah8e87nBvb_iNv56CreIdJDzh",
                rateObject.getHotel()
        );

        logger.info("Salesforce Property Response: " + propertyResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforcePropertyResponse propertyObject;
        try {
            propertyObject = objectMapper.readValue(propertyResponse, SalesforcePropertyResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Salesforce Contact Response", e);
        }

        return propertyObject;
    }

    public MewsCompanyResponse addCompanyInMews(MewsCompanyRequest mewsCompanyRequest) throws CustomException, JsonProcessingException {
        String companyResponse = mewsController.addCompany(mewsCompanyRequest);

        logger.info("Mews Company Response: " + companyResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        MewsCompanyResponse companyResponseObject;
        try {
            companyResponseObject = objectMapper.readValue(companyResponse, MewsCompanyResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Company Response", e);
        }

        return companyResponseObject;
    }

    public MewsBookerResponse addBookerInMews(MewsBookerRequest mewsBookerRequest) throws CustomException, JsonProcessingException {
        String bookerResponse = mewsController.addBooker(mewsBookerRequest);

        logger.info("Mews Booker Response: " + bookerResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        MewsBookerResponse bookerResponseObject;
        try {
            bookerResponseObject = objectMapper.readValue(bookerResponse, MewsBookerResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Company Response", e);
        }

        return bookerResponseObject;
    }

    public MewsAvailabilityBlockResponse addAvailabilityBlockInMews(MewsAvailabilityBlockRequest Request) throws CustomException, JsonProcessingException {
        String bookerResponse = mewsController.addAvailabilityBlock(Request);

        logger.info("Mews Availability Response: " + bookerResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        MewsAvailabilityBlockResponse bookerResponseObject;
        try {
            bookerResponseObject = objectMapper.readValue(bookerResponse, MewsAvailabilityBlockResponse.class);
        } catch (IOException e) {
            throw new CustomException("Unable to parse Company Response", e);
        }

        return bookerResponseObject;
    }
}
