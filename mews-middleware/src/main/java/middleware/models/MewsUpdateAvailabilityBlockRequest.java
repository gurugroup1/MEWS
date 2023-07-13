package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsUpdateAvailabilityBlockRequest {
    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Client")
    private String client;

    @JsonProperty("AvailabilityBlocks")
    private List<AvailabilityBlock> availabilityBlocks;

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

    public List<AvailabilityBlock> getAvailabilityBlocks() {
        return availabilityBlocks;
    }

    public void setAvailabilityBlocks(List<AvailabilityBlock> availabilityBlocks) {
        this.availabilityBlocks = availabilityBlocks;
    }

    public static class AvailabilityBlock {
        @JsonProperty("AvailabilityBlockId")
        private String availabilityBlockId;

        public String getAvailabilityBlockId() {
            return availabilityBlockId;
        }

        public void setAvailabilityBlockId(String availabilityBlockId) {
            this.availabilityBlockId = availabilityBlockId;
        }
    }
}
