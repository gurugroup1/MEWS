package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MewsUpdateCompanyRequest {
    @JsonProperty("client")
    private String client;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("clientToken")
    private String clientToken;

    @JsonProperty("CompanyId")
    private String companyId;

    // Getters and setters for the fields

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
