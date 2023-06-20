package MewsConnector.controllers;

import MewsConnector.models.MewsReservationRequest;
import MewsConnector.models.SalesforceReservationResponse;
import MewsConnector.models.SalesforceTokenResponse;
import MewsConnector.services.SalesforceConnectorService;
import MewsConnector.services.MewsConnectorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);
    private SalesforceController salesforceController;
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

    public SalesforceReservationResponse getSalesforceRecord() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        String response = salesforceController.getReservationsFromSalesforce(
                "00DFg0000002xSD!AQEAQL0hGtZjS.zmo3kwhVyIMBMxfyGoK7uRCetbuT5lRStzkajCdlbO_aYb6C5DFtEt77JHsK_nibhnCxuyw0X7rS7YD9Xg"
        );
        ObjectMapper objectMapper = new ObjectMapper();
        SalesforceReservationResponse reservationObject = objectMapper.readValue(response, SalesforceReservationResponse.class);
        return reservationObject;
    }

    public MewsReservationRequest processMewsData(SalesforceReservationResponse SalesforceRecord) throws Exception {
        MewsReservationRequest response = this.mewsController.processMewsRecord(SalesforceRecord);
        MewsConnectorService.pushReservationsToMews(response);
        return response;
    }
}
