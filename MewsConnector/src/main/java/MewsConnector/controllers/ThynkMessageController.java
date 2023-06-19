package MewsConnector.controllers;


import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.ThynkMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/reservations")
public class ThynkMessageController {

    private ApplicationConfiguration applicationConfiguration;

    public ThynkMessage createThynkMessagePayload(String body, String eventID, String startTime, String endTime, Integer hotelId, String eventObject) throws IOException {
        ThynkMessage thynkMessage = new ThynkMessage();

        thynkMessage.setPayload(body);
        thynkMessage.setApiSource(applicationConfiguration.getThynkMessageApiSource());
        thynkMessage.setExternalId(eventID); // Event ID
        thynkMessage.setStartProcessingTime(startTime); // SQS Start Time
        thynkMessage.setEndProcessingTime(endTime); // SQS End Time
        thynkMessage.setSyncStatus(applicationConfiguration.getThynkMessageSyncStatus());
        thynkMessage.setSyncedRecord(applicationConfiguration.getThynkMessageSetSyncRecord());
        thynkMessage.setTargetMethod(applicationConfiguration.getThynkMessageSetTargetMethod());
        thynkMessage.setPropertyCode(hotelId); // Hotel ID reflects Property code
        thynkMessage.setType(applicationConfiguration.getThynkMessageSetType());

        return thynkMessage;
    }
}
