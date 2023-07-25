package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class SalesforceRestControllerResponse {

    @JsonProperty("Status")
    private String status;

    @JsonProperty("guestRooms")
    private List<GuestRoom> guestRooms;

    @JsonProperty("booking")
    private Booking booking;

    @JsonProperty("rate")
    private Rate rate;

    @JsonProperty("contact")
    private Contact contact;

    @JsonProperty("property")
    private Property property;

    @JsonProperty("pmsBlock")
    private List<PMSBlock> pmsBlock;

    @JsonProperty("account")
    private Account account;

    @JsonProperty("pmsAccount")
    private PMSAccount pmsAccount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GuestRoom> getGuestRooms() {
        return guestRooms;
    }

    public void setGuestRooms(List<GuestRoom> guestRooms) {
        this.guestRooms = guestRooms;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<PMSBlock> getPmsBlock() {
        return pmsBlock;
    }

    public void setPmsBlock(List<PMSBlock> pmsBlock) {
        this.pmsBlock = pmsBlock;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PMSAccount getPmsAccount() {
        return pmsAccount;
    }

    public void setPmsAccount(PMSAccount pmsAccount) {
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
