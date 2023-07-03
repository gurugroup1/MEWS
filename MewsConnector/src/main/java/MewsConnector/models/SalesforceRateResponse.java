package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceRateResponse {

    @JsonProperty("attributes")
    private Attributes attributes;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("IsDeleted")
    private boolean isDeleted;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("CurrencyIsoCode")
    private String currencyIsoCode;

    @JsonProperty("CreatedDate")
    private String createdDate;

    @JsonProperty("CreatedById")
    private String createdById;

    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;

    @JsonProperty("LastModifiedById")
    private String lastModifiedById;

    @JsonProperty("SystemModstamp")
    private String systemModstamp;

    @JsonProperty("LastViewedDate")
    private String lastViewedDate;

    @JsonProperty("LastReferencedDate")
    private String lastReferencedDate;

    @JsonProperty("thn__Hotel__c")
    private String hotel;

    @JsonProperty("thn__BaseRate__c")
    private String baseRate;

    @JsonProperty("thn__GroupRate__c")
    private String groupRate;

    public String getThn__Mews_Id__c() {
        return thn__Mews_Id__c;
    }

    public void setThn__Mews_Id__c(String thn__Mews_Id__c) {
        this.thn__Mews_Id__c = thn__Mews_Id__c;
    }

    @JsonProperty("thn__Mews_Id__c")
    private String thn__Mews_Id__c;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(String baseRate) {
        this.baseRate = baseRate;
    }

    public String getGroupRate() {
        return groupRate;
    }

    public void setGroupRate(String groupRate) {
        this.groupRate = groupRate;
    }

    // Add the rest of the fields here...

    // Getters and Setters...

    public static class Attributes {
        @JsonProperty("type")
        private String type;

        @JsonProperty("url")
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        // Getters and Setters...
    }
}
