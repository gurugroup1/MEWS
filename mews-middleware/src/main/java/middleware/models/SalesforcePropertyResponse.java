package middleware.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforcePropertyResponse {


    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("thn__PMS_DB__c")
    private String pmsDb;

    @JsonProperty("thn__Email__c")
    private String businessEmail;
    @JsonProperty("Check_in_time__c")
    private String checkIn;
    @JsonProperty("Extra_Adult__c")
    private String additionalAdult;
    @JsonProperty("Extra_Child__c")
    private String additionalChild;

    @JsonProperty("thn__Mews_Reservation_Service_Id__c")
    private String thn__Mews_Reservation_Service_Id__c;
    @JsonProperty("Check_out_time__c")
    private String checkOut;
    @JsonProperty("thn__Mews_Default_Service_Id__c")
    private String thn__Mews_Default_Service_Id__c;

    @JsonProperty("thn__Mews_Id__c")
    private String thn__Mews_Id__c;

    @JsonProperty("thn__Booking_Internal_Notes_Template__c")
    private String bookingInternalNotes;

    @JsonProperty("Max_hotel_rooms__c")
    private Double hotelRoomsAmount;

    @JsonProperty("thn__Resort__c")
    private String resort;
    @JsonProperty("Logo_URL__c")
    private String logoURL;
    @JsonProperty("thn__Comm_Beverage__c")
    private String commBeverage;
    @JsonProperty("thn__Comm_Food__c")
    private String commFood;
    @JsonProperty("thn__Comm_Hotel_Rooms__c")
    private String commHotelRooms;

    @JsonProperty("thn__Comm_Meeting_Rooms__c")
    private String commMeetingRooms;

    @JsonProperty("thn__Comm_Other__c")
    private String commOther;

    @JsonProperty("thn__Comm_Package__c")
    private String commPackage;

    public String getCommOther() {
        return commOther;
    }

    public void setCommOther(String commOther) {
        this.commOther = commOther;
    }

    public String getCommPackage() {
        return commPackage;
    }

    public void setCommPackage(String commPackage) {
        this.commPackage = commPackage;
    }

    public String getCommHotelRooms() {
        return commHotelRooms;
    }

    public void setCommHotelRooms(String commHotelRooms) {
        this.commHotelRooms = commHotelRooms;
    }

    public String getCommMeetingRooms() {
        return commMeetingRooms;
    }

    public void setCommMeetingRooms(String commMeetingRooms) {
        this.commMeetingRooms = commMeetingRooms;
    }

    public String getCommFood() {
        return commFood;
    }

    public void setCommFood(String commFood) {
        this.commFood = commFood;
    }

    public String getCommBeverage() {
        return commBeverage;
    }

    public void setCommBeverage(String commBeverage) {
        this.commBeverage = commBeverage;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Double getHotelRoomsAmount() {
        return hotelRoomsAmount;
    }

    public void setHotelRoomsAmount(Double hotelRoomsAmount) {
        this.hotelRoomsAmount = hotelRoomsAmount;
    }

    public String getBookingInternalNotes() {
        return bookingInternalNotes;
    }

    public void setBookingInternalNotes(String bookingInternalNotes) {
        this.bookingInternalNotes = bookingInternalNotes;
    }

    public String getAdditionalAdult() {
        return additionalAdult;
    }

    public void setAdditionalAdult(String additionalAdult) {
        this.additionalAdult = additionalAdult;
    }

    public String getAdditionalChild() {
        return additionalChild;
    }

    public void setAdditionalChild(String additionalChild) {
        this.additionalChild = additionalChild;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getPmsDb() {
        return pmsDb;
    }

    public void setPmsDb(String pmsDb) {
        this.pmsDb = pmsDb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThn__Mews_Id__c() {
        return thn__Mews_Id__c;
    }

    public void setThn__Mews_Id__c(String thn__Mews_Id__c) {
        this.thn__Mews_Id__c = thn__Mews_Id__c;
    }

    public String getThn__Mews_Reservation_Service_Id__c() {
        return thn__Mews_Reservation_Service_Id__c;
    }

    public void setThn__Mews_Reservation_Service_Id__c(String thn__Mews_Reservation_Service_Id__c) {
        this.thn__Mews_Reservation_Service_Id__c = thn__Mews_Reservation_Service_Id__c;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThn__Mews_Default_Service_Id__c() {
        return thn__Mews_Default_Service_Id__c;
    }

    public void setThn__Mews_Default_Service_Id__c(String thn__Mews_Default_Service_Id__c) {
        this.thn__Mews_Default_Service_Id__c = thn__Mews_Default_Service_Id__c;
    }
}

