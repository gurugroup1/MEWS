package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MewsUpdateBookerResponse {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("ChainId")
    private String chainId;

    @JsonProperty("Number")
    private String number;

    @JsonProperty("Title")
    private Object title;

    @JsonProperty("Sex")
    private Object sex;

    @JsonProperty("Gender")
    private Object gender;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("SecondLastName")
    private String secondLastName;

    @JsonProperty("NationalityCode")
    private Object nationalityCode;

    @JsonProperty("LanguageCode")
    private Object languageCode;

    @JsonProperty("BirthDate")
    private String birthDate;

    @JsonProperty("BirthPlace")
    private String birthPlace;

    @JsonProperty("CitizenNumber")
    private Object citizenNumber;

    @JsonProperty("MotherName")
    private Object motherName;

    @JsonProperty("FatherName")
    private Object fatherName;

    @JsonProperty("Occupation")
    private Object occupation;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Phone")
    private String phone;

    @JsonProperty("TaxIdentificationNumber")
    private Object taxIdentificationNumber;

    @JsonProperty("LoyaltyCode")
    private String loyaltyCode;

    @JsonProperty("AccountingCode")
    private Object accountingCode;

    @JsonProperty("BillingCode")
    private Object billingCode;

    @JsonProperty("Notes")
    private Object notes;

    @JsonProperty("CarRegistrationNumber")
    private Object carRegistrationNumber;

    @JsonProperty("CreatedUtc")
    private String createdUtc;

    @JsonProperty("UpdatedUtc")
    private String updatedUtc;

    @JsonProperty("Passport")
    private Object passport;

    @JsonProperty("IdentityCard")
    private Object identityCard;

    @JsonProperty("Visa")
    private Object visa;

    @JsonProperty("DriversLicense")
    private Object driversLicense;

    @JsonProperty("Address")
    private Address address;

    @JsonProperty("AddressId")
    private String addressId;

    @JsonProperty("Classifications")
    private List<Object> classifications;

    @JsonProperty("Options")
    private List<String> options;

    @JsonProperty("CategoryId")
    private Object categoryId;

    @JsonProperty("BirthDateUtc")
    private String birthDateUtc;

    @JsonProperty("ItalianDestinationCode")
    private Object italianDestinationCode;

    @JsonProperty("ItalianFiscalCode")
    private Object italianFiscalCode;

    @JsonProperty("CompanyId")
    private Object companyId;

    @JsonProperty("MergeTargetId")
    private Object mergeTargetId;

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

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
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

    public Object getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(Object nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public Object getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(Object languageCode) {
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

    public Object getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(Object citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public Object getMotherName() {
        return motherName;
    }

    public void setMotherName(Object motherName) {
        this.motherName = motherName;
    }

    public Object getFatherName() {
        return fatherName;
    }

    public void setFatherName(Object fatherName) {
        this.fatherName = fatherName;
    }

    public Object getOccupation() {
        return occupation;
    }

    public void setOccupation(Object occupation) {
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

    public Object getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(Object taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getLoyaltyCode() {
        return loyaltyCode;
    }

    public void setLoyaltyCode(String loyaltyCode) {
        this.loyaltyCode = loyaltyCode;
    }

    public Object getAccountingCode() {
        return accountingCode;
    }

    public void setAccountingCode(Object accountingCode) {
        this.accountingCode = accountingCode;
    }

    public Object getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(Object billingCode) {
        this.billingCode = billingCode;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(Object carRegistrationNumber) {
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

    public Object getPassport() {
        return passport;
    }

    public void setPassport(Object passport) {
        this.passport = passport;
    }

    public Object getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(Object identityCard) {
        this.identityCard = identityCard;
    }

    public Object getVisa() {
        return visa;
    }

    public void setVisa(Object visa) {
        this.visa = visa;
    }

    public Object getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(Object driversLicense) {
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

    public List<Object> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Object> classifications) {
        this.classifications = classifications;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    public String getBirthDateUtc() {
        return birthDateUtc;
    }

    public void setBirthDateUtc(String birthDateUtc) {
        this.birthDateUtc = birthDateUtc;
    }

    public Object getItalianDestinationCode() {
        return italianDestinationCode;
    }

    public void setItalianDestinationCode(Object italianDestinationCode) {
        this.italianDestinationCode = italianDestinationCode;
    }

    public Object getItalianFiscalCode() {
        return italianFiscalCode;
    }

    public void setItalianFiscalCode(Object italianFiscalCode) {
        this.italianFiscalCode = italianFiscalCode;
    }

    public Object getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    public Object getMergeTargetId() {
        return mergeTargetId;
    }

    public void setMergeTargetId(Object mergeTargetId) {
        this.mergeTargetId = mergeTargetId;
    }

    public String getActivityState() {
        return activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

    //Getters and Setters
    //...
}

class Address {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("Line1")
    private Object line1;

    @JsonProperty("Line2")
    private Object line2;

    @JsonProperty("City")
    private Object city;

    @JsonProperty("PostalCode")
    private Object postalCode;

    @JsonProperty("CountryCode")
    private Object countryCode;

    @JsonProperty("CountrySubdivisionCode")
    private Object countrySubdivisionCode;

    @JsonProperty("Latitude")
    private Object latitude;

    @JsonProperty("Longitude")
    private Object longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getLine1() {
        return line1;
    }

    public void setLine1(Object line1) {
        this.line1 = line1;
    }

    public Object getLine2() {
        return line2;
    }

    public void setLine2(Object line2) {
        this.line2 = line2;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode;
    }

    public Object getCountrySubdivisionCode() {
        return countrySubdivisionCode;
    }

    public void setCountrySubdivisionCode(Object countrySubdivisionCode) {
        this.countrySubdivisionCode = countrySubdivisionCode;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    //Getters and Setters
    //...
}
