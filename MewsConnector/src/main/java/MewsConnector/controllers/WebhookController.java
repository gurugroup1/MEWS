package MewsConnector.controllers;

import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.*;
import MewsConnector.models.SalesforceBookingResponse;
import MewsConnector.models.SalesforceTokenResponse;
import MewsConnector.services.SalesforceConnectorService;
import MewsConnector.services.MewsConnectorService;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

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
        this.mewsController = new MewsController();
        this.secretKeyManagerController = new SecretKeyManagerController();
        this.salesforceController = new SalesforceController(this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(this.secretKeyManagerController,this.salesforceConnectorService);
    }

    public String extractEventData(SQSEvent event) {
        try {
            if (!event.getRecords().isEmpty()) {
                SQSEvent.SQSMessage sqsMessage = event.getRecords().get(0);
                String bookingId = null;
                try {
                    JsonNode bodyNode = new ObjectMapper().readTree(sqsMessage.getBody());
                    bookingId = bodyNode.get("BookingId").asText();
                } catch (IOException e) {
                    logger.error("Error occurred while extracting booking ID from SQS message body", e);
                }
                logger.info("Booking Id: " + bookingId);
                return bookingId;
            } else {
                logger.info("No records found in SQS event");
                return null;
            }
        } catch (Exception e) {
            logger.error("Error occurred during event processing", e);
            return null;
        }
    }

    private static class EventData {
        private String bookingId;

        public String getBookingId() {
            return bookingId;
        }

        public void setBookingId(String bookingId) {
            this.bookingId = bookingId;
        }
    }


    public SalesforceBookingResponse getSalesforceRecord(String bookingId) throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        String bookingResponse = salesforceController.getBookingFromSalesforce(applicationConfiguration.getSalesforceBookingObject(),
                "00DFg0000002xSD!AQEAQKC5t05UVHKVky7USL9JBg7KiKqwHN5GrmWga3js92o8.jYe1aX71k6RTM38c_WyfzQrtrJ0Es0WTDPcITzCCmhGOF9o",bookingId
        );
        System.out.println("salesforce Booking Response : " + bookingResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceBookingResponse bookingObject = objectMapper.readValue(bookingResponse, SalesforceBookingResponse.class);

        String accountResponse = salesforceController.getBookingFromSalesforce(applicationConfiguration.getSalesforceAccountObject(),
                "00DFg0000002xSD!AQEAQKC5t05UVHKVky7USL9JBg7KiKqwHN5GrmWga3js92o8.jYe1aX71k6RTM38c_WyfzQrtrJ0Es0WTDPcITzCCmhGOF9o",bookingObject.getThn__Company__c()
        );

        SalesforceAccountResponse accountObject = objectMapper.readValue(accountResponse, SalesforceAccountResponse.class);
        System.out.println("salesforce Account Response : " + accountResponse);
        System.out.println("Account Response : " + accountObject.getRecordTypeId());

        String contactResponse = salesforceController.getBookingFromSalesforce(applicationConfiguration.getSalesforceCompanyContactObject(),
                "00DFg0000002xSD!AQEAQKC5t05UVHKVky7USL9JBg7KiKqwHN5GrmWga3js92o8.jYe1aX71k6RTM38c_WyfzQrtrJ0Es0WTDPcITzCCmhGOF9o",bookingObject.getThn__Company_Contact__c()
        );

        SalesforceContactResponse contactObject = objectMapper.readValue(contactResponse, SalesforceContactResponse.class);
        System.out.println("salesforce Contact Response : " + contactResponse);


        return bookingObject;
    }



//    public MewsReservationRequest processMewsData(SalesforceReservationResponse SalesforceRecord) throws Exception {
//        MewsReservationRequest response = this.mewsController.processMewsRecord(SalesforceRecord);
//        MewsConnectorService.pushReservationsToMews(response);
//        return response;
//    }
}
