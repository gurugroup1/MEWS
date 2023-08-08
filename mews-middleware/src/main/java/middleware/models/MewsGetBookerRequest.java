package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsGetBookerRequest {
    @JsonProperty("client")
    private String client;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("clientToken")
    private String clientToken;

    @JsonProperty("limitation")
    private Limitation limitation;

    @JsonProperty("Emails")
    private List<String> emails;

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

    public Limitation getLimitation() {
        return limitation;
    }

    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public static class Limitation {
        @JsonProperty("count")
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
