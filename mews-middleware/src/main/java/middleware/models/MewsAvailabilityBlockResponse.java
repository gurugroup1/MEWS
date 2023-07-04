package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class MewsAvailabilityBlockResponse {
    {

        List<AvailabilityBlock> availabilityBlocks;

        // Getters and Setters
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class AvailabilityBlock {

        @JsonProperty("Id")
        private String id;

        @JsonProperty("ServiceId")
        private String serviceId;

        @JsonProperty("RateId")
        private String rateId;

        @JsonProperty("FirstTimeUnitStartUtc")
        private ZonedDateTime firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private ZonedDateTime lastTimeUnitStartUtc;

        @JsonProperty("ReleasedUtc")
        private ZonedDateTime releasedUtc;

        @JsonProperty("ExternalIdentifier")
        private String externalIdentifier;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getRateId() {
            return rateId;
        }

        public void setRateId(String rateId) {
            this.rateId = rateId;
        }

        public ZonedDateTime getFirstTimeUnitStartUtc() {
            return firstTimeUnitStartUtc;
        }

        public void setFirstTimeUnitStartUtc(ZonedDateTime firstTimeUnitStartUtc) {
            this.firstTimeUnitStartUtc = firstTimeUnitStartUtc;
        }

        public ZonedDateTime getLastTimeUnitStartUtc() {
            return lastTimeUnitStartUtc;
        }

        public void setLastTimeUnitStartUtc(ZonedDateTime lastTimeUnitStartUtc) {
            this.lastTimeUnitStartUtc = lastTimeUnitStartUtc;
        }

        public ZonedDateTime getReleasedUtc() {
            return releasedUtc;
        }

        public void setReleasedUtc(ZonedDateTime releasedUtc) {
            this.releasedUtc = releasedUtc;
        }

        public String getExternalIdentifier() {
            return externalIdentifier;
        }

        public void setExternalIdentifier(String externalIdentifier) {
            this.externalIdentifier = externalIdentifier;
        }

        // Getters and Setters
    }
}
