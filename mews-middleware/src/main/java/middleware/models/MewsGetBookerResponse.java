package middleware.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class MewsGetBookerResponse {
    @JsonProperty("Customers")
    private List<Customer> customers;

    @JsonProperty("Documents")
    private List<Object> documents;

    @JsonProperty("Cursor")
    private String cursor;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Object> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Object> documents) {
        this.documents = documents;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

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
        private String birthDate;

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

//        @JsonProperty("CreatedUtc")
//        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
//        private LocalDateTime createdUtc;

//        @JsonProperty("UpdatedUtc")
//        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
//        private LocalDateTime updatedUtc;

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
        private List<String> classifications;

        @JsonProperty("Options")
        private List<String> options;

        @JsonProperty("CategoryId")
        private String categoryId;

        @JsonProperty("BirthDateUtc")
        private String birthDateUtc;

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

//        public LocalDateTime getCreatedUtc() {
//            return createdUtc;
//        }
//
//        public void setCreatedUtc(LocalDateTime createdUtc) {
//            this.createdUtc = createdUtc;
//        }
//
//        public LocalDateTime getUpdatedUtc() {
//            return updatedUtc;
//        }
//
//        public void setUpdatedUtc(LocalDateTime updatedUtc) {
//            this.updatedUtc = updatedUtc;
//        }

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

        public List<String> getClassifications() {
            return classifications;
        }

        public void setClassifications(List<String> classifications) {
            this.classifications = classifications;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getBirthDateUtc() {
            return birthDateUtc;
        }

        public void setBirthDateUtc(String birthDateUtc) {
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

        // Getters and Setters for all the fields...
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
        private String latitude;

        @JsonProperty("Longitude")
        private String longitude;

        // Getters and Setters for all the fields...
    }
}
