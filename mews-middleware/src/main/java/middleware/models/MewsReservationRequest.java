package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MewsReservationRequest {
    @JsonProperty("Client") private String client;
    @JsonProperty("AccessToken") private String accessToken;
    @JsonProperty("ClientToken") private String clientToken;
    @JsonProperty("ServiceId") private String serviceId;
    @JsonProperty("Reservations") private List<Reservation> reservations;

    // getters and setters
    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }
    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
    public String getClientToken() { return clientToken; }
    public void setClientToken(String clientToken) { this.clientToken = clientToken; }
    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }
    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

   public static class Reservation {
        @JsonProperty("StartUtc") private String startUtc;
        @JsonProperty("EndUtc") private String endUtc;
        @JsonProperty("CustomerId") private String customerId;
        @JsonProperty("RequestedCategoryId") private String requestedCategoryId;
        @JsonProperty("RateId") private String rateId;
        @JsonProperty("Notes") private String notes;
        @JsonProperty("PersonCounts") private List<PersonCount> personCounts;

        // getters and setters
        public String getStartUtc() { return startUtc; }
        public void setStartUtc(String startUtc) { this.startUtc = startUtc; }
        public String getEndUtc() { return endUtc; }
        public void setEndUtc(String endUtc) { this.endUtc = endUtc; }
        public String getCustomerId() { return customerId; }
        public void setCustomerId(String customerId) { this.customerId = customerId; }
        public String getRequestedCategoryId() { return requestedCategoryId; }
        public void setRequestedCategoryId(String requestedCategoryId) { this.requestedCategoryId = requestedCategoryId; }
        public String getRateId() { return rateId; }
        public void setRateId(String rateId) { this.rateId = rateId; }
        public String getNotes() { return notes; }
        public void setNotes(String notes) { this.notes = notes; }
        public List<PersonCount> getPersonCounts() { return personCounts; }
        public void setPersonCounts(List<PersonCount> personCounts) { this.personCounts = personCounts; }
    }

    public static class PersonCount {
        @JsonProperty("AgeCategoryId") private String ageCategoryId;
        @JsonProperty("Count") private int count;

        // getters and setters
        public String getAgeCategoryId() { return ageCategoryId; }
        public void setAgeCategoryId(String ageCategoryId) { this.ageCategoryId = ageCategoryId; }
        public int getCount() { return count; }
        public void setCount(int count) { this.count = count; }
    }
}
