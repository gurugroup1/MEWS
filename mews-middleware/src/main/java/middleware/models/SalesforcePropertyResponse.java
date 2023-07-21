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

    @JsonProperty("Check_out_time__c")
    private String checkOut;

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

    @JsonProperty("thn__Mews_Default_Service_Id__c")
    private String thn__Mews_Default_Service_Id__c;

    @JsonProperty("thn__Mews_Id__c")
    private String thn__Mews_Id__c;

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

    @JsonProperty("thn__Mews_Reservation_Service_Id__c")
    private String thn__Mews_Reservation_Service_Id__c;


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

