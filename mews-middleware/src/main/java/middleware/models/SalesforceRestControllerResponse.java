package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class SalesforceRestControllerResponse {

    @JsonProperty("Status")
    private String status;

    @JsonProperty("guestRooms")
    private List<SalesforceGuestRoomResponse> guestRooms;

    @JsonProperty("booking")
    private SalesforceBookingResponse booking;

    @JsonProperty("rate")
    private SalesforceRateResponse rate;

    @JsonProperty("contact")
    private SalesforceContactResponse contact;

    @JsonProperty("property")
    private SalesforcePropertyResponse property;

    @JsonProperty("pmsBlock")
    private List<SalesforceGetPMSBlockResponse> pmsBlock;

    @JsonProperty("account")
    private SalesforceAccountResponse account;

    @JsonProperty("pmsAccount")
    private SalesforceGetPMSAccountResponse pmsAccount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SalesforceGuestRoomResponse> getGuestRooms() {
        return guestRooms;
    }

    public void setGuestRooms(List<SalesforceGuestRoomResponse> guestRooms) {
        this.guestRooms = guestRooms;
    }

    public SalesforceBookingResponse getBooking() {
        return booking;
    }

    public void setBooking(SalesforceBookingResponse booking) {
        this.booking = booking;
    }

    public SalesforceRateResponse getRate() {
        return rate;
    }

    public void setRate(SalesforceRateResponse rate) {
        this.rate = rate;
    }

    public SalesforceContactResponse getContact() {
        return contact;
    }

    public void setContact(SalesforceContactResponse contact) {
        this.contact = contact;
    }

    public SalesforcePropertyResponse getProperty() {
        return property;
    }

    public void setProperty(SalesforcePropertyResponse property) {
        this.property = property;
    }

    public List<SalesforceGetPMSBlockResponse> getPmsBlock() {
        return pmsBlock;
    }

    public void setPmsBlock(List<SalesforceGetPMSBlockResponse> pmsBlock) {
        this.pmsBlock = pmsBlock;
    }

    public SalesforceAccountResponse getAccount() {
        return account;
    }

    public void setAccount(SalesforceAccountResponse account) {
        this.account = account;
    }

    public SalesforceGetPMSAccountResponse getPmsAccount() {
        return pmsAccount;
    }

    public void setPmsAccount(SalesforceGetPMSAccountResponse pmsAccount) {
        this.pmsAccount = pmsAccount;
    }


    public static class Attributes {
        @JsonProperty("type")
        private String type;

        @JsonProperty("url")
        private String url;

    }

    public static class GuestRoom {
        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;


        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Booking {
        @JsonProperty("thn__Company__c")
        private String companyC;

        @JsonProperty("thn__Block_Rate__c")
        private String blockRateC;

        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;

        @JsonProperty("thn__Company_Contact__c")
        private String companyContactC;

        public String getCompanyC() {
            return companyC;
        }

        public void setCompanyC(String companyC) {
            this.companyC = companyC;
        }

        public String getBlockRateC() {
            return blockRateC;
        }

        public void setBlockRateC(String blockRateC) {
            this.blockRateC = blockRateC;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCompanyContactC() {
            return companyContactC;
        }

        public void setCompanyContactC(String companyContactC) {
            this.companyContactC = companyContactC;
        }
    }

    public static class Rate {
        @JsonProperty("thn__Hotel__c")
        private String hotelC;

        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;

        public String getHotelC() {
            return hotelC;
        }

        public void setHotelC(String hotelC) {
            this.hotelC = hotelC;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Contact {
        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Property {
        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class PMSBlock {
        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;


        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Account {
        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class PMSAccount {
        @JsonProperty("attributes")
        private Attributes attributes;

        @JsonProperty("Id")
        private String id;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
