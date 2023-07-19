package middleware.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforcePropertyResponse {


    @JsonProperty("Id")
    private String id;

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

