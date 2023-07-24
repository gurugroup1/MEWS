package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MewsBookerRequest {

    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Client")
    private String client;

    @JsonProperty("OverwriteExisting")
    private Boolean overwriteExisting;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

//    @JsonProperty("SecondLastName")
//    private String secondLastName;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Sex")
    private String sex;

    @JsonProperty("NationalityCode")
    private String nationalityCode;

    @JsonProperty("BirthDate")
    private String birthDate;

    @JsonProperty("BirthPlace")
    private String birthPlace;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Phone")
    private String phone;

    @JsonProperty("LoyaltyCode")
    private String loyaltyCode;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("IdentityCard")
    private IdentityCard identityCard;

    @JsonProperty("Passport")
    private String passport;

    @JsonProperty("Visa")
    private String visa;

    @JsonProperty("DriversLicense")
    private String driversLicense;

    @JsonProperty("Address")
    private Address address;

    @JsonProperty("ItalianDestinationCode")
    private String italianDestinationCode;

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

    public Boolean getOverwriteExisting() {
        return overwriteExisting;
    }

    public void setOverwriteExisting(Boolean overwriteExisting) {
        this.overwriteExisting = overwriteExisting;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getSecondLastName() {
//        return secondLastName;
//    }
//
//    public void setSecondLastName(String secondLastName) {
//        this.secondLastName = secondLastName;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoyaltyCode() {
        return loyaltyCode;
    }

    public void setLoyaltyCode(String loyaltyCode) {
        this.loyaltyCode = loyaltyCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getItalianDestinationCode() {
        return italianDestinationCode;
    }

    public void setItalianDestinationCode(String italianDestinationCode) {
        this.italianDestinationCode = italianDestinationCode;
    }

    public static class IdentityCard {
        @JsonProperty("Number")
        private String number;

        @JsonProperty("Expiration")
        private String expiration;

        @JsonProperty("Issuance")
        private String issuance;

        @JsonProperty("IssuingCountryCode")
        private String issuingCountryCode;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        public String getIssuance() {
            return issuance;
        }

        public void setIssuance(String issuance) {
            this.issuance = issuance;
        }

        public String getIssuingCountryCode() {
            return issuingCountryCode;
        }

        public void setIssuingCountryCode(String issuingCountryCode) {
            this.issuingCountryCode = issuingCountryCode;
        }

        // Add getters and setters here
    }

    public static class Address {
        @JsonProperty("Line1")
        private String line1;

        @JsonProperty("Line2")
        private String line2;

        @JsonProperty("City")
        private String city;

        @JsonProperty("PostalCode")
        private String postalCode;

        @JsonProperty("CountryCode")
        private String countryCode;

        @JsonProperty("CountrySubdivisionCode")
        private String countrySubdivisionCode;

        public String getLine1() {
            return line1;
        }

        public void setLine1(String line1) {
            this.line1 = line1;
        }

        public String getLine2() {
            return line2;
        }

        public void setLine2(String line2) {
            this.line2 = line2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountrySubdivisionCode() {
            return countrySubdivisionCode;
        }

        public void setCountrySubdivisionCode(String countrySubdivisionCode) {
            this.countrySubdivisionCode = countrySubdivisionCode;
        }

        // Add getters and setters here
    }
    // Add getters and setters here
}




