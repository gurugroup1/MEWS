package MewsConnector;


import MewsConnector.models.MewsReservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MewsConnector.controllers.WebhookController;
@Component
public class Handler {

    @Autowired
    public Void handleRequest() {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("************** Start Processing WebHook **************");
        try {
            WebhookController webhookController = new WebhookController();
            String salesforceResponse = webhookController.getSalesforceRecord();
            MewsReservation mewsResponse = webhookController.processMewsData(salesforceResponse);
            System.out.println(mewsResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}