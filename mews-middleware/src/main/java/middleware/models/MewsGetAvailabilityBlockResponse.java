package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MewsGetAvailabilityBlockResponse {
    @JsonProperty("AvailabilityBlocks")
    private AvailabilityBlock[] availabilityBlocks;

    @JsonProperty("ServiceOrders")
    private Object serviceOrders;

    @JsonProperty("Adjustments")
    private Adjustment[] adjustments;

    @JsonProperty("Rates")
    private Object rates;

    @JsonProperty("Cursor")
    private String cursor;

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
        private Object budget;

        @JsonProperty("State")
        private String state;

        @JsonProperty("ReservationPurpose")
        private Object reservationPurpose;

        @JsonProperty("CreatedUtc")
        private String createdUtc;

        @JsonProperty("UpdatedUtc")
        private String updatedUtc;

        @JsonProperty("ActivityState")
        private String activityState;

        @JsonProperty("StartUtc")
        private String startUtc;

        @JsonProperty("EndUtc")
        private String endUtc;

        @JsonProperty("FirstTimeUnitStartUtc")
        private String firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private String lastTimeUnitStartUtc;

        @JsonProperty("ReleasedUtc")
        private String releasedUtc;

        @JsonProperty("ExternalIdentifier")
        private String externalIdentifier;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("Notes")
        private Object notes;

        // Getters and setters for AvailabilityBlock fields

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

        public Object getBudget() {
            return budget;
        }

        public void setBudget(Object budget) {
            this.budget = budget;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getReservationPurpose() {
            return reservationPurpose;
        }

        public void setReservationPurpose(Object reservationPurpose) {
            this.reservationPurpose = reservationPurpose;
        }

        public String getCreatedUtc() {
            return createdUtc;
        }

        public void setCreatedUtc(String createdUtc) {
            this.createdUtc = createdUtc;
        }

        public String getUpdatedUtc() {
            return updatedUtc;
        }

        public void setUpdatedUtc(String updatedUtc) {
            this.updatedUtc = updatedUtc;
        }

        public String getActivityState() {
            return activityState;
        }

        public void setActivityState(String activityState) {
            this.activityState = activityState;
        }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getNotes() {
            return notes;
        }

        public void setNotes(Object notes) {
            this.notes = notes;
        }
    }

    public static class Adjustment {
        @JsonProperty("Id")
        private String id;

        @JsonProperty("AvailabilityBlockId")
        private String availabilityBlockId;

        @JsonProperty("ResourceCategoryId")
        private String resourceCategoryId;

        @JsonProperty("StartUtc")
        private String startUtc;

        @JsonProperty("EndUtc")
        private String endUtc;

        @JsonProperty("FirstTimeUnitStartUtc")
        private String firstTimeUnitStartUtc;

        @JsonProperty("LastTimeUnitStartUtc")
        private String lastTimeUnitStartUtc;

        @JsonProperty("UnitCount")
        private int unitCount;

        @JsonProperty("ActivityState")
        private String activityState;

        // Getters and setters for Adjustment fields

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public int getUnitCount() {
            return unitCount;
        }

        public void setUnitCount(int unitCount) {
            this.unitCount = unitCount;
        }

        public String getActivityState() {
            return activityState;
        }

        public void setActivityState(String activityState) {
            this.activityState = activityState;
        }
    }

    // Getters and setters for the response fields

    public AvailabilityBlock[] getAvailabilityBlocks() {
        return availabilityBlocks;
    }

    public void setAvailabilityBlocks(AvailabilityBlock[] availabilityBlocks) {
        this.availabilityBlocks = availabilityBlocks;
    }

    public Object getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(Object serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    public Adjustment[] getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(Adjustment[] adjustments) {
        this.adjustments = adjustments;
    }

    public Object getRates() {
        return rates;
    }

    public void setRates(Object rates) {
        this.rates = rates;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
