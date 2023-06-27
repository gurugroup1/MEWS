package MewsConnector;

import MewsConnector.models.SalesforceBookingResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import MewsConnector.controllers.WebhookController;
@Component
public class Handler implements RequestHandler<SQSEvent, Void> {

    @Autowired
    public Void handleRequest(SQSEvent event, Context context) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("************** Start Processing WebHook **************");
        try {
            WebhookController webhookController = new WebhookController();
            String bookingId = webhookController.extractEventData(event);
            String salesforceResponse = webhookController.startSalesforceProcess(bookingId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}