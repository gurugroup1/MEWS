package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceGetPMSBlockResponse {
    @JsonProperty("attributes")
    private SalesforceGetPMSBlockResponse.Attributes attributes;

    @JsonProperty("Id")
    private String id;

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