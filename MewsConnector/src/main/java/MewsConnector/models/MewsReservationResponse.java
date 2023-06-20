package MewsConnector.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MewsReservationResponse {

    @JsonProperty("Reservations")
    private List<ReservationWrapper> reservations;

    public List<ReservationWrapper> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationWrapper> reservations) {
        this.reservations = reservations;
    }

    public static class ReservationWrapper {

        @JsonProperty("Identifier")
        private String identifier;

        @JsonProperty("Reservation")
        private Reservation reservation;

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public Reservation getReservation() {
            return reservation;
        }

        public void setReservation(Reservation reservation) {
            this.reservation = reservation;
        }

        public static class Reservation {

            @JsonProperty("Id")
            private String id;
            @JsonProperty("ServiceId")
            private String serviceId;
            @JsonProperty("GroupId")
            private String groupId;
            @JsonProperty("Number")
            private String number;
            @JsonProperty("State")
            private String state;
            @JsonProperty("StartUtc")
            private String startUtc;
            @JsonProperty("EndUtc")
            private String endUtc;
            @JsonProperty("AdultCount")
            private Integer adultCount;
            @JsonProperty("ChildCount")
            private Integer childCount;
            @JsonProperty("PersonCounts")
            private List<PersonCount> personCounts;

            // Getters and setters
            public String getId() { return id; }
            public void setId(String id) { this.id = id; }
            public String getServiceId() { return serviceId; }
            public void setServiceId(String serviceId) { this.serviceId = serviceId; }
            public String getGroupId() { return groupId; }
            public void setGroupId(String groupId) { this.groupId = groupId; }
            public String getNumber() { return number; }
            public void setNumber(String number) { this.number = number; }
            public String getState() { return state; }
            public void setState(String state) { this.state = state; }
            public String getStartUtc() { return startUtc; }
            public void setStartUtc(String startUtc) { this.startUtc = startUtc; }
            public String getEndUtc() { return endUtc; }
            public void setEndUtc(String endUtc) { this.endUtc = endUtc; }
            public Integer getAdultCount() { return adultCount; }
            public void setAdultCount(Integer adultCount) { this.adultCount = adultCount; }
            public Integer getChildCount() { return childCount; }
            public void setChildCount(Integer childCount) { this.childCount = childCount; }
            public List<PersonCount> getPersonCounts() { return personCounts; }
            public void setPersonCounts(List<PersonCount> personCounts) { this.personCounts = personCounts; }

            public static class PersonCount {

                @JsonProperty("AgeCategoryId")
                private String ageCategoryId;

                @JsonProperty("Count")
                private Integer count;

                public String getAgeCategoryId() { return ageCategoryId; }
                public void setAgeCategoryId(String ageCategoryId) { this.ageCategoryId = ageCategoryId; }
                public Integer getCount() { return count; }
                public void setCount(Integer count) { this.count = count; }
            }
        }
    }
}
