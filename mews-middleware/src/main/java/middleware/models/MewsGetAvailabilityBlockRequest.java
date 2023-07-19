package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsGetAvailabilityBlockRequest {
    @JsonProperty("client")
    private String client;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("clientToken")
    private String clientToken;
    @JsonProperty("AvailabilityBlockIds")
    private List<String> availabilityBlockIds;

    @JsonProperty("CreatedUtc")
    private CreatedUtc createdUtc;

    @JsonProperty("Extent")
    private Extent extent;

    @JsonProperty("Limitation")
    private Limitation limitation;

    public List<String> getAvailabilityBlockIds() {
        return availabilityBlockIds;
    }

    public void setAvailabilityBlockIds(List<String> availabilityBlockIds) {
        this.availabilityBlockIds = availabilityBlockIds;
    }

    public static class CreatedUtc {
        @JsonProperty("StartUtc")
        private String startUtc;

        @JsonProperty("EndUtc")
        private String endUtc;

        // Getters and setters for CreatedUtc fields

        public String getStartUtc() {
            return startUtc;
        }

        public void setStartUtc(String startUtc) {
            this.startUtc = startUtc;
        }

        public String getEndUtc() {
            return endUtc;
        }

        public void setEndUtc(String endUtc) {
            this.endUtc = endUtc;
        }
    }
    @JsonProperty("ExternalIdentifiers")
    private List<String> externalIdentifiers;

    public List<String> getExternalIdentifiers() {
        return externalIdentifiers;
    }

    public void setExternalIdentifiers(List<String> externalIdentifiers) {
        this.externalIdentifiers = externalIdentifiers;
    }

    public static class Extent {
        @JsonProperty("AvailabilityBlocks")
        private boolean availabilityBlocks;

        @JsonProperty("Adjustments")
        private boolean adjustments;

        @JsonProperty("ServiceOrders")
        private boolean serviceOrders;

        @JsonProperty("Rates")
        private boolean rates;

        // Getters and setters for Extent fields

        public boolean isAvailabilityBlocks() {
            return availabilityBlocks;
        }

        public void setAvailabilityBlocks(boolean availabilityBlocks) {
            this.availabilityBlocks = availabilityBlocks;
        }

        public boolean isAdjustments() {
            return adjustments;
        }

        public void setAdjustments(boolean adjustments) {
            this.adjustments = adjustments;
        }

        public boolean isServiceOrders() {
            return serviceOrders;
        }

        public void setServiceOrders(boolean serviceOrders) {
            this.serviceOrders = serviceOrders;
        }

        public boolean isRates() {
            return rates;
        }

        public void setRates(boolean rates) {
            this.rates = rates;
        }
    }

    public static class Limitation {
        @JsonProperty("Count")
        private int count;

        // Getters and setters for Limitation fields

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

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

    public CreatedUtc getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(CreatedUtc createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Extent getExtent() {
        return extent;
    }

    public void setExtent(Extent extent) {
        this.extent = extent;
    }

    public Limitation getLimitation() {
        return limitation;
    }

    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;
    }
}
