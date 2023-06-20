package MewsConnector.controllers;

import MewsConnector.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

public class MewsController {


    public MewsReservationRequest processMewsRecord(SalesforceReservationResponse record) throws JsonProcessingException {

        MewsReservationRequest reservationRequest = new MewsReservationRequest();
        MewsReservationRequest.Reservation reservation = new MewsReservationRequest.Reservation();
        MewsReservationRequest.PersonCount personCount = new MewsReservationRequest.PersonCount();
        personCount.setCount(1);
        personCount.setAgeCategoryId("d0ea43d2-4c76-485c-97e4-ade30117ad9c");

        reservation.setStartUtc("2023-08-22T00:00:00Z");
        reservation.setEndUtc("2023-08-25T00:00:00Z");
        reservation.setCustomerId("359a6cd6-f3d0-46e6-b14e-b01f007f8c85");
        reservation.setRequestedCategoryId("d33a088a-b479-4b9c-ab51-abd100d7ede4");
        reservation.setRateId("bd870c5b-25c6-44c6-9959-acc200fbbd7c");
        reservation.setNotes("Test reservation");
        reservation.setPersonCounts(Arrays.asList(personCount)); // Java 8 and later

        reservationRequest.setClient("Thynk 0.1");
        reservationRequest.setAccessToken("0F5E505064BC49F1A209AEA0008C938A-24DFA25272C784034F9AD7E3685F4E4");
        reservationRequest.setClientToken("B0602874D5B945C0B12FADEC01068C88-C5ABFC221B4C8AF57C9192C5015A8CD");
        reservationRequest.setServiceId("2c65e490-8618-432e-b254-abd100d7ed6e");
        reservationRequest.setReservations(Arrays.asList(reservation)); // Java 8 and late

        return reservationRequest;
    }
}