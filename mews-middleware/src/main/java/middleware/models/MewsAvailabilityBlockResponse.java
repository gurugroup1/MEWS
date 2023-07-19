package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import java.util.List;

public class  MewsAvailabilityBlockResponse {

    @JsonProperty("AvailabilityBlocks")
    private List<AvailabilityBlock> availabilityBlocks;

    public List<AvailabilityBlock> getAvailabilityBlocks() {
        return availabilityBlocks;
    }

    public void setAvailabilityBlocks(List<AvailabilityBlock> availabilityBlocks) {
        this.availabilityBlocks = availabilityBlocks;
    }

    public static class AvailabilityBlock {
        @JsonProperty("Id")
        private String id;

        @JsonProperty("EnterpriseId")
        private String enterpriseId;

        @JsonProperty("ServiceId")
        private String serviceId;

        @JsonProperty("RateId")
        private String rateId;

        @JsonProperty("VoucherId")
        private String voucherId;

        @JsonProperty("BookerId")
        private String bookerId;

        @JsonProperty("CompanyId")
        private String companyId;

        @JsonProperty("TravelAgencyId")
        private String travelAgencyId;

        @JsonProperty("Budget")
        private Budget budget;

        @JsonProperty("State")
        private String state;

        @JsonProperty("ReservationPurpose")
        private String reservationPurpose;

        @JsonProperty("CreatedUtc")
        private ZonedDateTime createdUtc;

        @JsonProperty("UpdatedUtc")
        private ZonedDateTime updatedUtc;

        @JsonProperty("ActivityState")
        private String activityState;

        @JsonProperty("StartUtc")
        private ZonedDateTime startUtc;

        @JsonProperty("EndUtc")
        private ZonedDateTime endUtc;

        @JsonProperty("FirstTimeUnitStartUtc")
        private ZonedDateTime firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private ZonedDateTime lastTimeUnitStartUtc;

        @JsonProperty("ReleasedUtc")
        private ZonedDateTime releasedUtc;

        @JsonProperty("ExternalIdentifier")
        private String externalIdentifier;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("Notes")
        private String notes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
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

        public String getVoucherId() {
            return voucherId;
        }

        public void setVoucherId(String voucherId) {
            this.voucherId = voucherId;
        }

        public String getBookerId() {
            return bookerId;
        }

        public void setBookerId(String bookerId) {
            this.bookerId = bookerId;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getTravelAgencyId() {
            return travelAgencyId;
        }

        public void setTravelAgencyId(String travelAgencyId) {
            this.travelAgencyId = travelAgencyId;
        }

        public Budget getBudget() {
            return budget;
        }

        public void setBudget(Budget budget) {
            this.budget = budget;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getReservationPurpose() {
            return reservationPurpose;
        }

        public void setReservationPurpose(String reservationPurpose) {
            this.reservationPurpose = reservationPurpose;
        }

        public ZonedDateTime getCreatedUtc() {
            return createdUtc;
        }

        public void setCreatedUtc(ZonedDateTime createdUtc) {
            this.createdUtc = createdUtc;
        }

        public ZonedDateTime getUpdatedUtc() {
            return updatedUtc;
        }

        public void setUpdatedUtc(ZonedDateTime updatedUtc) {
            this.updatedUtc = updatedUtc;
        }

        public String getActivityState() {
            return activityState;
        }

        public void setActivityState(String activityState) {
            this.activityState = activityState;
        }

        public ZonedDateTime getStartUtc() {
            return startUtc;
        }

        public void setStartUtc(ZonedDateTime startUtc) {
            this.startUtc = startUtc;
        }

        public ZonedDateTime getEndUtc() {
            return endUtc;
        }

        public void setEndUtc(ZonedDateTime endUtc) {
            this.endUtc = endUtc;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        // Getters and Setters

        // ...
    }

    public static class Budget {
        @JsonProperty("Currency")
        private String currency;

        @JsonProperty("Value")
        private double value;

        @JsonProperty("Net")
        private Double net;

        @JsonProperty("Tax")
        private Double tax;

        @JsonProperty("TaxRate")
        private Double taxRate;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public Double getNet() {
            return net;
        }

        public void setNet(Double net) {
            this.net = net;
        }

        public Double getTax() {
            return tax;
        }

        public void setTax(Double tax) {
            this.tax = tax;
        }

        public Double getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(Double taxRate) {
            this.taxRate = taxRate;
        }

        // Getters and Setters

        // ...
    }
}

