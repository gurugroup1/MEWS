package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceTokenResponse {
    private String access_token;
    private String instance_url;
    private String id;
    private String token_type;
    private String issued_at;
    private String signature;

    private long expires_in;
    private long created_at;

    @JsonProperty("access_token")
    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    @JsonProperty("instance_url")
    public String getInstance_url() {
        return instance_url;
    }

    public void setInstance_url(String instance_url) {
        this.instance_url = instance_url;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("token_type")
    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
    @JsonProperty("issued_at")
    public String getIssued_at() {
        return issued_at;
    }

    public void setIssued_at(String issued_at) {
        this.issued_at = issued_at;
    }
    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

}

