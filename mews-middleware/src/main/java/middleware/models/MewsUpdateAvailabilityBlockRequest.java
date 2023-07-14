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

        @JsonProperty("Name")
        private Name name;

        @JsonProperty("FirstTimeUnitStartUtc")
        private FirstTimeUnitStartUtc firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private LastTimeUnitStartUtc lastTimeUnitStartUtc;

        @JsonProperty("ReleasedUtc")
        private ReleasedUtc releasedUtc;

        @JsonProperty("ExternalIdentifier")
        private ExternalIdentifier externalIdentifier;

        public String getAvailabilityBlockId() {
            return availabilityBlockId;
        }

        public void setAvailabilityBlockId(String availabilityBlockId) {
            this.availabilityBlockId = availabilityBlockId;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public FirstTimeUnitStartUtc getFirstTimeUnitStartUtc() {
            return firstTimeUnitStartUtc;
        }

        public void setFirstTimeUnitStartUtc(FirstTimeUnitStartUtc firstTimeUnitStartUtc) {
            this.firstTimeUnitStartUtc = firstTimeUnitStartUtc;
        }

        public LastTimeUnitStartUtc getLastTimeUnitStartUtc() {
            return lastTimeUnitStartUtc;
        }

        public void setLastTimeUnitStartUtc(LastTimeUnitStartUtc lastTimeUnitStartUtc) {
            this.lastTimeUnitStartUtc = lastTimeUnitStartUtc;
        }

        public ReleasedUtc getReleasedUtc() {
            return releasedUtc;
        }

        public void setReleasedUtc(ReleasedUtc releasedUtc) {
            this.releasedUtc = releasedUtc;
        }

        public ExternalIdentifier getExternalIdentifier() {
            return externalIdentifier;
        }

        public void setExternalIdentifier(ExternalIdentifier externalIdentifier) {
            this.externalIdentifier = externalIdentifier;
        }

        public static class Name {
            @JsonProperty("Value")
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class FirstTimeUnitStartUtc {
            @JsonProperty("Value")
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class LastTimeUnitStartUtc {
            @JsonProperty("Value")
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class ReleasedUtc {
            @JsonProperty("Value")
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class ExternalIdentifier {
            @JsonProperty("Value")
            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
