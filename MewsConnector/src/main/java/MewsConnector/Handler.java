package MewsConnector;


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
        logger.info("************** Start Processing WebHook **************");
        try {
            WebhookController webhookController = new WebhookController();
            String result = webhookController.processEvent();
            System.out.println("Salesforce Response" + result);
//            if (result != null) {
//                ObjectMapper objectMapper = new ObjectMapper();
//                SalesforceRequestResponse salesforceRequestResponse = objectMapper.readValue(result, SalesforceRequestResponse.class);
//
//                if (salesforceRequestResponse.isSuccess()) {
//                    String id = salesforceRequestResponse.getId();
//                    logger.info("Salesforce - Thynk Message Queue Record Id : " + id);
//                    logger.info("************** Webhook Successfully Processed **************");
//                } else {
//                    logger.info("Error occurred: " + salesforceRequestResponse.getErrors());
//                    logger.info("************** Webhook Processing Failed **************");
//                }
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}