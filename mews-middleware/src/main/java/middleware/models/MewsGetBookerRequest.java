package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsGetBookerRequest {

    private String client;


    private String accessToken;


    private String clientToken;


    private List<String> email;


    private Limitation limitation;

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

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public Limitation getLimitation() {
        return limitation;
    }

    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;
    }

    public static class Limitation {
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
