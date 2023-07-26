package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;


import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceGuestRoomResponse {
    @JsonProperty("attributes")
    private Attributes attributes;

    @JsonProperty("CreatedById")
    private String createdById;

    @JsonProperty("CreatedDate")
    private String createdDate;

    @JsonProperty("CurrencyIsoCode")
    private String currencyIsoCode;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("IsDeleted")
    private boolean isDeleted;

    @JsonProperty("LastModifiedById")
    private String lastModifiedById;

    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;

    @JsonProperty("LastReferencedDate")
    private String lastReferencedDate;

    @JsonProperty("LastViewedDate")
    private String lastViewedDate;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("OwnerId")
    private String ownerId;

    @JsonProperty("SystemModstamp")
    private String systemModstamp;

    @JsonProperty("thn__Booker__c")
    private String booker;

    @JsonProperty("thn__CurrencyCode__c")
    private String currencyCode;

    @JsonProperty("thn__EndShoulderDate__c")
    private String endShoulderDate;

    @JsonProperty("thn__End__c")
    private String end;

    @JsonProperty("thn__First_Name__c")
    private String firstName;

    @JsonProperty("thn__InventoryBlockType__c")
    private String inventoryBlockType;

    @JsonProperty("thn__Last_Name__c")
    private String lastName;

    @JsonProperty("thn__MYCE_Quote__c")
    private String myceQuote;

    @JsonProperty("thn__PMSAccountCompany__c")
    private String pmsAccountCompany;

    @JsonProperty("thn__PMSAccountGroup__c")
    private String pmsAccountGroup;

    @JsonProperty("thn__PMSAccountSource__c")
    private String pmsAccountSource;

    @JsonProperty("thn__PMSAccountTravelAgent__c")
    private String pmsAccountTravelAgent;

    @JsonProperty("thn__PMSId__c")
    private String pmsId;

    @JsonProperty("thn__PMS_Block_End_Time__c")
    private String pmsBlockEndTime;

    @JsonProperty("thn__PMS_Block_Start_Time__c")
    private String pmsBlockStartTime;

    @JsonProperty("thn__PMS_Release_Date_Time__c")
    private String pmsReleaseDateTime;

    @JsonProperty("thn__PMS_Status__c")
    private String pmsStatus;

    @JsonProperty("thn__Property__c")
    private String property;

    @JsonProperty("thn__Rate__c")
    private String rate;

    @JsonProperty("thn__SendToPms__c")
    private boolean sendToPms;

    @JsonProperty("thn__Send_Failed_PMS_Block__c")
    private boolean sendFailedPmsBlock;

    @JsonProperty("thn__StartShoulderDate__c")
    private String startShoulderDate;

    @JsonProperty("thn__Start__c")
    private String start;

    @JsonProperty("thn__Sync_Status__c")
    private String syncStatus;

    // Getters and Setters for all properties
    // ...

    public static class Attributes {
        @JsonProperty("type")
        private String type;

        @JsonProperty("url")
        private String url;

        // Getters and Setters for "type" and "url"
        // ...

        // Note: You may also add other attributes if needed.
    }
}
