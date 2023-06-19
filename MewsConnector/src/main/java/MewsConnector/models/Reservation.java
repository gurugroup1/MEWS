package MewsConnector.models;

import java.util.List;

public class Reservation {

    private int id;
    private int hotel_id;
    private String confirmation_number;
    private String currency_code;
    private String status;
    private String arrival_date;
    private String arrival_time;
    private String departure_date;
    private String departure_time;
    private String booking_origin_code;
    private String created_time;
    private double deposit_amount;
    private String market_segment_code;
    private String promotion_code;
    private String segment_code;
    private boolean tax_exempt;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getConfirmation_number() {
        return confirmation_number;
    }

    public void setConfirmation_number(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getBooking_origin_code() {
        return booking_origin_code;
    }

    public void setBooking_origin_code(String booking_origin_code) {
        this.booking_origin_code = booking_origin_code;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public String getMarket_segment_code() {
        return market_segment_code;
    }

    public void setMarket_segment_code(String market_segment_code) {
        this.market_segment_code = market_segment_code;
    }

    public String getPromotion_code() {
        return promotion_code;
    }

    public void setPromotion_code(String promotion_code) {
        this.promotion_code = promotion_code;
    }

    public String getSegment_code() {
        return segment_code;
    }

    public void setSegment_code(String segment_code) {
        this.segment_code = segment_code;
    }

    public boolean isTax_exempt() {
        return tax_exempt;
    }

    public void setTax_exempt(boolean tax_exempt) {
        this.tax_exempt = tax_exempt;
    }

}