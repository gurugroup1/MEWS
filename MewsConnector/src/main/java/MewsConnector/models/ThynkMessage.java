package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonProperty;




public class ThynkMessage {

    @JsonProperty("thn__ExternalId__c")
    private String externalId;

    @JsonProperty("thn__API_Source__c")
    private String apiSource;

    @JsonProperty("thn__StartProcessingTime__c")
    private String startProcessingTime;

    @JsonProperty("thn__EndProcessingTime__c")
    private String endProcessingTime;

    @JsonProperty("thn__Sync_status__c")
    private String syncStatus;

    @JsonProperty("thn__Synced_record__c")
    private String syncedRecord;

    @JsonProperty("thn__TargetMethod__c")
    private String targetMethod;

    @JsonProperty("thn__TargetEndpoint__c")
    private String targetEndpoint;

    @JsonProperty("thn__Property_Code__c")
    private Integer propertyCode;

    @JsonProperty("thn__JSON__c")
    private String payload;

    @JsonProperty("thn__Type__c")
    private String type;

    @JsonProperty("thn__Object_type__c")
    private String objectType;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getApiSource() {
        return apiSource;
    }

    public void setApiSource(String apiSource) {
        this.apiSource = apiSource;
    }

    public String getStartProcessingTime() {
        return startProcessingTime;
    }

    public void setStartProcessingTime(String startProcessingTime) {
        this.startProcessingTime = startProcessingTime;
    }

    public String getEndProcessingTime() {
        return endProcessingTime;
    }

    public void setEndProcessingTime(String endProcessingTime) {
        this.endProcessingTime = endProcessingTime;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getSyncedRecord() {
        return syncedRecord;
    }

    public void setSyncedRecord(String syncedRecord) {
        this.syncedRecord = syncedRecord;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public String getTargetEndpoint() {
        return targetEndpoint;
    }

    public void setTargetEndpoint(String targetEndpoint) {
        this.targetEndpoint = targetEndpoint;
    }

    public Integer getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(Integer propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }


    // Only work to generate logs on Cloud Watch
    @Override
    public String toString() {
        return "ThynkMessage{" +
                "externalId='" + externalId + '\'' +
                ", apiSource='" + apiSource + '\'' +
                ", startProcessingTime='" + startProcessingTime + '\'' +
                ", endProcessingTime='" + endProcessingTime + '\'' +
                ", syncStatus='" + syncStatus + '\'' +
                ", syncedRecord='" + syncedRecord + '\'' +
                ", targetMethod='" + targetMethod + '\'' +
                ", targetEndpoint='" + targetEndpoint + '\'' +
                ", propertyCode='" + propertyCode + '\'' +
                ", payload='" + payload + '\'' +
                ", type='" + type + '\'' +
                ", objectType='" + objectType + '\'' +
                '}';
    }

}