package middleware.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MewsUpdateRateRequest {
    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Client")
    private String client;

    @JsonProperty("RateId")
    private String rateId;

    @JsonProperty("PriceUpdates")
    private List<PriceUpdate> priceUpdates;

    public MewsUpdateRateRequest() {
        priceUpdates = new ArrayList<>();
    }
    // Getters and setters for MyModel
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

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public List<PriceUpdate> getPriceUpdates() {
        return priceUpdates;
    }

    public void setPriceUpdates(List<PriceUpdate> priceUpdates) {
        this.priceUpdates = priceUpdates;
    }

    public static class PriceUpdate {
        @JsonProperty("CategoryId")
        private String categoryId;

        @JsonProperty("FirstTimeUnitStartUtc")
        private String firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private String lastTimeUnitStartUtc;

        @JsonProperty("Value")
        private int value;

        // Getters and setters for PriceUpdate
        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getFirstTimeUnitStartUtc() {
            return firstTimeUnitStartUtc;
        }

        public void setFirstTimeUnitStartUtc(String firstTimeUnitStartUtc) {
            this.firstTimeUnitStartUtc = firstTimeUnitStartUtc;
        }

        public String getLastTimeUnitStartUtc() {
            return lastTimeUnitStartUtc;
        }

        public void setLastTimeUnitStartUtc(String lastTimeUnitStartUtc) {
            this.lastTimeUnitStartUtc = lastTimeUnitStartUtc;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
