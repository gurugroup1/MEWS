package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class MewsGetBookerResponse {
    @JsonProperty("Customers")
    private Customer[] customers;

    @JsonProperty("Documents")
    private Document[] documents;

    @JsonProperty("Cursor")
    private String cursor;

    public static class Customer {
        @JsonProperty("Id")
        private String id;

        @JsonProperty("ChainId")
        private String chainId;

        @JsonProperty("Number")
        private String number;

        @JsonProperty("Title")
        private String title;

        @JsonProperty("Sex")
        private String sex;

        @JsonProperty("Gender")
        private String gender;

        @JsonProperty("FirstName")
        private String firstName;

        @JsonProperty("LastName")
        private String lastName;

        @JsonProperty("SecondLastName")
        private String secondLastName;

        @JsonProperty("NationalityCode")
        private String nationalityCode;

        @JsonProperty("LanguageCode")
        private String languageCode;

        @JsonProperty("BirthDate")
        private LocalDateTime birthDate;

        @JsonProperty("BirthPlace")
        private String birthPlace;

        @JsonProperty("CitizenNumber")
        private String citizenNumber;

        @JsonProperty("MotherName")
        private String motherName;

        @JsonProperty("FatherName")
        private String fatherName;

        @JsonProperty("Occupation")
        private String occupation;

        @JsonProperty("Email")
        private String email;

        @JsonProperty("Phone")
        private String phone;

        @JsonProperty("TaxIdentificationNumber")
        private String taxIdentificationNumber;

        @JsonProperty("LoyaltyCode")
        private String loyaltyCode;

        @JsonProperty("AccountingCode")
        private String accountingCode;

        @JsonProperty("BillingCode")
        private String billingCode;

        @JsonProperty("Notes")
        private String notes;

        @JsonProperty("CarRegistrationNumber")
        private String carRegistrationNumber;

        @JsonProperty("CreatedUtc")
        private LocalDateTime createdUtc;

        @JsonProperty("UpdatedUtc")
        private LocalDateTime updatedUtc;

        @JsonProperty("Passport")
        private String passport;

        @JsonProperty("IdentityCard")
        private String identityCard;

        @JsonProperty("Visa")
        private String visa;

        @JsonProperty("DriversLicense")
        private String driversLicense;

        @JsonProperty("Address")
        private Address address;

        @JsonProperty("AddressId")
        private String addressId;

        @JsonProperty("Classifications")
        private String[] classifications;

        @JsonProperty("Options")
        private String[] options;

        @JsonProperty("CategoryId")
        private String categoryId;

        @JsonProperty("BirthDateUtc")
        private LocalDateTime birthDateUtc;

        @JsonProperty("ItalianDestinationCode")
        private String italianDestinationCode;

        @JsonProperty("ItalianFiscalCode")
        private String italianFiscalCode;

        @JsonProperty("CompanyId")
        private String companyId;

        @JsonProperty("MergeTargetId")
        private String mergeTargetId;

        @JsonProperty("ActivityState")
        private String activityState;

        // Getters and setters for the fields

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getChainId() {
            return chainId;
        }

        public void setChainId(String chainId) {
            this.chainId = chainId;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
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

        public String getSecondLastName() {
            return secondLastName;
        }

        public void setSecondLastName(String secondLastName) {
            this.secondLastName = secondLastName;
        }

        public String getNationalityCode() {
            return nationalityCode;
        }

        public void setNationalityCode(String nationalityCode) {
            this.nationalityCode = nationalityCode;
        }

        public String getLanguageCode() {
            return languageCode;
        }

        public void setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
        }

        public LocalDateTime getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDateTime birthDate) {
            this.birthDate = birthDate;
        }

        public String getBirthPlace() {
            return birthPlace;
        }

        public void setBirthPlace(String birthPlace) {
            this.birthPlace = birthPlace;
        }

        public String getCitizenNumber() {
            return citizenNumber;
        }

        public void setCitizenNumber(String citizenNumber) {
            this.citizenNumber = citizenNumber;
        }

        public String getMotherName() {
            return motherName;
        }

        public void setMotherName(String motherName) {
            this.motherName = motherName;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
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

        public String getTaxIdentificationNumber() {
            return taxIdentificationNumber;
        }

        public void setTaxIdentificationNumber(String taxIdentificationNumber) {
            this.taxIdentificationNumber = taxIdentificationNumber;
        }

        public String getLoyaltyCode() {
            return loyaltyCode;
        }

        public void setLoyaltyCode(String loyaltyCode) {
            this.loyaltyCode = loyaltyCode;
        }

        public String getAccountingCode() {
            return accountingCode;
        }

        public void setAccountingCode(String accountingCode) {
            this.accountingCode = accountingCode;
        }

        public String getBillingCode() {
            return billingCode;
        }

        public void setBillingCode(String billingCode) {
            this.billingCode = billingCode;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getCarRegistrationNumber() {
            return carRegistrationNumber;
        }

        public void setCarRegistrationNumber(String carRegistrationNumber) {
            this.carRegistrationNumber = carRegistrationNumber;
        }

        public LocalDateTime getCreatedUtc() {
            return createdUtc;
        }

        public void setCreatedUtc(LocalDateTime createdUtc) {
            this.createdUtc = createdUtc;
        }

        public LocalDateTime getUpdatedUtc() {
            return updatedUtc;
        }

        public void setUpdatedUtc(LocalDateTime updatedUtc) {
            this.updatedUtc = updatedUtc;
        }

        public String getPassport() {
            return passport;
        }

        public void setPassport(String passport) {
            this.passport = passport;
        }

        public String getIdentityCard() {
            return identityCard;
        }

        public void setIdentityCard(String identityCard) {
            this.identityCard = identityCard;
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

        public String getAddressId() {
            return addressId;
        }

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }

        public String[] getClassifications() {
            return classifications;
        }

        public void setClassifications(String[] classifications) {
            this.classifications = classifications;
        }

        public String[] getOptions() {
            return options;
        }

        public void setOptions(String[] options) {
            this.options = options;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public LocalDateTime getBirthDateUtc() {
            return birthDateUtc;
        }

        public void setBirthDateUtc(LocalDateTime birthDateUtc) {
            this.birthDateUtc = birthDateUtc;
        }

        public String getItalianDestinationCode() {
            return italianDestinationCode;
        }

        public void setItalianDestinationCode(String italianDestinationCode) {
            this.italianDestinationCode = italianDestinationCode;
        }

        public String getItalianFiscalCode() {
            return italianFiscalCode;
        }

        public void setItalianFiscalCode(String italianFiscalCode) {
            this.italianFiscalCode = italianFiscalCode;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getMergeTargetId() {
            return mergeTargetId;
        }

        public void setMergeTargetId(String mergeTargetId) {
            this.mergeTargetId = mergeTargetId;
        }

        public String getActivityState() {
            return activityState;
        }

        public void setActivityState(String activityState) {
            this.activityState = activityState;
        }
    }

    public static class Document {
        // Define the fields for Document here (if any)
    }

    public static class Address {
        @JsonProperty("Id")
        private String id;

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

        @JsonProperty("Latitude")
        private Double latitude;

        @JsonProperty("Longitude")
        private Double longitude;

        // Getters and setters for Address fields

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
    }

    // Getters and setters for the fields

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public void setDocuments(Document[] documents) {
        this.documents = documents;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
