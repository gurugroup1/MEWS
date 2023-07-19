package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MewsDeleteAvailabilityBlockRequest {
    @JsonProperty("client")
    private String client;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("clientToken")
    private String clientToken;

    @JsonProperty("AvailabilityBlockIds")
    private List<String> availabilityBlockIds;

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

    public List<String> getAvailabilityBlockIds() {
        return availabilityBlockIds;
    }

    public void setAvailabilityBlockIds(List<String> availabilityBlockIds) {
        this.availabilityBlockIds = availabilityBlockIds;
    }

    // Getters and setters

    // ...
}
