package MewsConnector.controllers;


import MewsConnector.models.SalesforceTokenResponse;
import MewsConnector.services.SalesforceConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private ThynkMessageController thynkMessageController;
    private SalesforceController salesforceController;
    private AuthController authController;
    private SecretKeyManagerController secretKeyManagerController;
    private SalesforceConnectorService salesforceConnectorService;

    public WebhookController() {
        this.salesforceConnectorService = new SalesforceConnectorService();

        this.thynkMessageController = new ThynkMessageController();
        this.secretKeyManagerController = new SecretKeyManagerController();
        this.salesforceController = new SalesforceController(this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(this.secretKeyManagerController,this.salesforceConnectorService);
    }

    public String processEvent() throws Exception {

        logger.info("Received SQS Event");
        String reservation = processReservation();
        return reservation;
    }

    private String processReservation() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        String response = salesforceController.getReservationsFromSalesforce(
                salesforceToken.getAccess_token()
        );
        return response;
    }
}
