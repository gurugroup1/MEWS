package MewsConnector.controllers;


import MewsConnector.models.MewsReservation;
import MewsConnector.models.SalesforceTokenResponse;
import MewsConnector.services.SalesforceConnectorService;
import MewsConnector.services.MewsConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebhookController {
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private ThynkMessageController thynkMessageController;
    private SalesforceController salesforceController;

    private MewsController mewsController;
    private AuthController authController;
    private SecretKeyManagerController secretKeyManagerController;
    private SalesforceConnectorService salesforceConnectorService;

    private MewsConnectorService MewsConnectorService;

    public WebhookController() {
        this.salesforceConnectorService = new SalesforceConnectorService();
        this.mewsController = new MewsController();
        this.secretKeyManagerController = new SecretKeyManagerController();
        this.salesforceController = new SalesforceController(this.secretKeyManagerController,this.salesforceConnectorService);
        this.authController = new AuthController(this.secretKeyManagerController,this.salesforceConnectorService);
    }

    public String getSalesforceRecord() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        String response = salesforceController.getReservationsFromSalesforce(
                salesforceToken.getAccess_token()
        );
        return response;
    }

    public MewsReservation processMewsData(String SalesforceRecord) throws Exception {
        MewsReservation response = this.mewsController.processMewsRecord(SalesforceRecord);
        MewsConnectorService.pushReservationsToMews(response);
        return response;
    }
}
