package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsAvailabilityBlockRequest {

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

        @JsonProperty("ServiceId")
        private String serviceId;

        @JsonProperty("RateId")
        private String rateId;

        @JsonProperty("VoucherCode")
        private String voucherCode;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("FirstTimeUnitStartUtc")
        private String firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private String lastTimeUnitStartUtc;

        @JsonProperty("ReleasedUtc")
        private String releasedUtc;

        @JsonProperty("ExternalIdentifier")
        private String externalIdentifier;

        @JsonProperty("Budget")
        private Budget budget;

        @JsonProperty("ReservationPurpose")
        private String reservationPurpose;

        @JsonProperty("Notes")
        private String notes;

        @JsonProperty("State")
        private String state;

        @JsonProperty("BookerId")
        private String bookerId;

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

        public String getVoucherCode() {
            return voucherCode;
        }

        public void setVoucherCode(String voucherCode) {
            this.voucherCode = voucherCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getReleasedUtc() {
            return releasedUtc;
        }

        public void setReleasedUtc(String releasedUtc) {
            this.releasedUtc = releasedUtc;
        }

        public String getExternalIdentifier() {
            return externalIdentifier;
        }

        public void setExternalIdentifier(String externalIdentifier) {
            this.externalIdentifier = externalIdentifier;
        }

        public Budget getBudget() {
            return budget;
        }

        public void setBudget(Budget budget) {
            this.budget = budget;
        }

        public String getReservationPurpose() {
            return reservationPurpose;
        }

        public void setReservationPurpose(String reservationPurpose) {
            this.reservationPurpose = reservationPurpose;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getBookerId() {
            return bookerId;
        }

        public void setBookerId(String bookerId) {
            this.bookerId = bookerId;
        }

        public static class Budget {

            @JsonProperty("Value")
            private int value;

            @JsonProperty("Currency")
            private String currency;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }
        }
    }
}
