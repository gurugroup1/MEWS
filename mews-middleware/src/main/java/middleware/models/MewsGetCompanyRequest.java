package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MewsGetCompanyRequest {

    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Client")
    private String client;

    @JsonProperty("Names")
    private String names;

    @JsonProperty("Limitation")
    private Limitation limitation;

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Limitation getLimitation() {
        return limitation;
    }

    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;
    }
    public static class Limitation {

        @JsonProperty("Count")
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }


    }


}

