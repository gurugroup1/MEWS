package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceGetPMSBlockResponse {
    @JsonProperty("attributes")
    private SalesforceGetPMSBlockResponse.Attributes attributes;

    @JsonProperty("Id")
    private String id;

    public String getThn__PMSId__c() {
        return thn__PMSId__c;
    }

    public void setThn__PMSId__c(String thn__PMSId__c) {
        this.thn__PMSId__c = thn__PMSId__c;
    }

    @JsonProperty("thn__PMSId__c")
    private String thn__PMSId__c;

    public SalesforceGetPMSBlockResponse.Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(SalesforceGetPMSBlockResponse.Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Attributes {
        @JsonProperty("type")
        private String type;

        @JsonProperty("url")
        private String url;

    }

}