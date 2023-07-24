package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MewsBookerResponse {

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

//    @JsonProperty("SecondLastName")
//    private String secondLastName;

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

    @JsonProperty("CreatedUtc")
    private String createdUtc;

    @JsonProperty("UpdatedUtc")
    private String updatedUtc;

    @JsonProperty("Passport")
    private String passport;

    @JsonProperty("IdentityCard")
    private IdentityCard identityCard;

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

//    public String getSecondLastName() {
//        return secondLastName;
//    }
//
//    public void setSecondLastName(String secondLastName) {
//        this.secondLastName = secondLastName;
//    }

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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
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

    // Getters and Setters...


public static class IdentityCard {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("CustomerId")
    private String customerId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Number")
    private String number;

    @JsonProperty("Expiration")
    private String expiration;

    @JsonProperty("Issuance")
    private String issuance;

    @JsonProperty("IssuingCountryCode")
    private String issuingCountryCode;

    @JsonProperty("IssuingCity")
    private String issuingCity;

    @JsonProperty("ExpirationUtc")
    private String expirationUtc;

    @JsonProperty("IssuanceUtc")
    private String issuanceUtc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getIssuingCity() {
        return issuingCity;
    }

    public void setIssuingCity(String issuingCity) {
        this.issuingCity = issuingCity;
    }

    public String getExpirationUtc() {
        return expirationUtc;
    }

    public void setExpirationUtc(String expirationUtc) {
        this.expirationUtc = expirationUtc;
    }

    public String getIssuanceUtc() {
        return issuanceUtc;
    }

    public void setIssuanceUtc(String issuanceUtc) {
        this.issuanceUtc = issuanceUtc;
    }
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

    // Getters and Setters...
}
}