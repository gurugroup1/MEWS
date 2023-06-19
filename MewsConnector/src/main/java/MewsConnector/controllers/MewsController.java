package MewsConnector.controllers;

import MewsConnector.models.MewsReservation;
import MewsConnector.services.MewsConnectorService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Objects;

public class MewsController {


    public MewsReservation processMewsRecord(String record) throws JsonProcessingException {
        MewsReservation mewsReservation = new MewsReservation();
        mewsReservation.setCustomerId(record);
        mewsReservation.getMewsPersonCounts(record);
        mewsReservation.setCustomerId(record);
        mewsReservation.setCustomerId(record);
        mewsReservation.setCustomerId(record);
        return mewsReservation;
    }
}
