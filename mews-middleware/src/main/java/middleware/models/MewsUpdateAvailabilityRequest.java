package middleware.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MewsUpdateAvailabilityRequest {
    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Client")
    private String client;

    @JsonProperty("ServiceId")
    private String serviceId;

    @JsonProperty("AvailabilityUpdates")
    private List<AvailabilityUpdate> availabilityUpdates;

    public MewsUpdateAvailabilityRequest() {
        availabilityUpdates = new ArrayList<>();
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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public List<AvailabilityUpdate> getAvailabilityUpdates() {
        return availabilityUpdates;
    }

    public void setAvailabilityUpdates(List<AvailabilityUpdate> availabilityUpdates) {
        this.availabilityUpdates = availabilityUpdates;
    }

    public static class AvailabilityUpdate {
        @JsonProperty("FirstTimeUnitStartUtc")
        private String firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private String lastTimeUnitStartUtc;

        @JsonProperty("AvailabilityBlockId")
        private String availabilityBlockId;

        @JsonProperty("ResourceCategoryId")
        private String resourceCategoryId;

        @JsonProperty("UnitCountAdjustment")
        private UnitCountAdjustment unitCountAdjustment;

        // Getters and setters for AvailabilityUpdate
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

        public String getAvailabilityBlockId() {
            return availabilityBlockId;
        }

        public void setAvailabilityBlockId(String availabilityBlockId) {
            this.availabilityBlockId = availabilityBlockId;
        }

        public String getResourceCategoryId() {
            return resourceCategoryId;
        }

        public void setResourceCategoryId(String resourceCategoryId) {
            this.resourceCategoryId = resourceCategoryId;
        }

        public UnitCountAdjustment getUnitCountAdjustment() {
            return unitCountAdjustment;
        }

        public void setUnitCountAdjustment(UnitCountAdjustment unitCountAdjustment) {
            this.unitCountAdjustment = unitCountAdjustment;
        }
    }

    public static class UnitCountAdjustment {
        @JsonProperty("Value")
        private int value;

        // Getters and setters for UnitCountAdjustment
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
