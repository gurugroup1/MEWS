package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsGetCompanyRequest {
    private String client;
    private String accessToken;
    private String clientToken;
    private List<String> names;
    private Limitation limitation;

    // Getters and Setters

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

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Limitation getLimitation() {
        return limitation;
    }

    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;
    }

    // Limitation class

    public static class Limitation {
        private int count;

        // Getter and Setter

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}


