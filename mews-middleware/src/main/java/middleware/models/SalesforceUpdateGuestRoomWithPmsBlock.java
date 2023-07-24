package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceUpdateGuestRoomWithPmsBlock {
    @JsonProperty("Id")
    private String Id;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("thn__Pax__c")
    private double thn__Pax__c;

    @JsonProperty("thn__ReleasedDate__c")
    private String thn__ReleasedDate__c;

    private String thn__PMS_Block__c;

    public String getThn__PMS_Block__c() {
        return thn__PMS_Block__c;
    }

    public void setThn__PMS_Block__c(String thn__PMS_Block__c) {
        this.thn__PMS_Block__c = thn__PMS_Block__c;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public void setThn__Pax__c(double thn__Pax__c) {
        this.thn__Pax__c = thn__Pax__c;
    }


    public void setThn__ReleasedDate__c(String thn__ReleasedDate__c) {
        this.thn__ReleasedDate__c = thn__ReleasedDate__c;
    }

}
