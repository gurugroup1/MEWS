package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceGuestRequest {
    @JsonProperty("CurrencyIsoCode")
    private String currencyIsoCode;

    @JsonProperty("thn__Account__c")
    private String account;

    @JsonProperty("thn__AccountingCode__c")
    private String accountingCode;

    @JsonProperty("thn__BillingCode__c")
    private String billingCode;

    @JsonProperty("thn__BirthDate__c")
    private String birthDate;

    @JsonProperty("thn__BirthPlace__c")
    private String birthPlace;

    @JsonProperty("thn__CarRegistrationNumber__c")
    private String carRegistrationNumber;

    @JsonProperty("thn__CategoryId__c")
    private String categoryId;

    @JsonProperty("thn__CitizenNumber__c")
    private String citizenNumber;

    @JsonProperty("thn__Classifications__c")
    private String classifications;

    @JsonProperty("thn__Contact__c")
    private String contact;

    @JsonProperty("thn__CreatedUtc__c")
    private String createdUtc;

    @JsonProperty("thn__Email__c")
    private String email;

    @JsonProperty("thn__FatherName__c")
    private String fatherName;

    @JsonProperty("thn__FirstName__c")
    private String firstName;

    @JsonProperty("thn__Gender__c")
    private String gender;



    @JsonProperty("thn__Hotel__c")
    private String hotel;

    @JsonProperty("thn__Invoiceable__c")
    private boolean invoiceable;

    @JsonProperty("thn__LanguageCode__c")
    private String languageCode;

    @JsonProperty("thn__LastName__c")
    private String lastName;

    @JsonProperty("thn__LoyaltyCode__c")
    private String loyaltyCode;

    @JsonProperty("thn__MailingCity__c")
    private String mailingCity;

    @JsonProperty("thn__MailingCountryCode__c")
    private String mailingCountryCode;

    @JsonProperty("thn__MailingPostalCode__c")
    private String mailingPostalCode;

    @JsonProperty("thn__MailingStreet__c")
    private String mailingStreet;

    @JsonProperty("thn__Mews_Error_Message__c")
    private String mewsErrorMessage;

    @JsonProperty("thn__Mews_Id__c")
    private String mewsId;

    @JsonProperty("thn__Mews_Number__c")
    private String mewsNumber;

    @JsonProperty("thn__MotherName__c")
    private String motherName;

    @JsonProperty("thn__NationalityCode__c")
    private String nationalityCode;

    @JsonProperty("thn__Notes__c")
    private String notes;

    @JsonProperty("thn__Occupation__c")
    private String occupation;

    @JsonProperty("thn__Phone__c")
    private String phone;

    @JsonProperty("thn__SendMarketingEmails__c")
    private boolean sendMarketingEmails;

    @JsonProperty("thn__Send_to_Mews__c")
    private boolean sendToMews;

    @JsonProperty("thn__TaxIdentificationNumber__c")
    private String taxIdentificationNumber;

    @JsonProperty("thn__Title__c")
    private String title;

    @JsonProperty("thn__UpdatedUtc__c")
    private String updatedUtc;

    @JsonProperty("thn__MobilePhone__c")
    private String mobilePhone;

    @JsonProperty("thn__Salutation__c")
    private String salutation;

    @JsonProperty("MYCE_Quote__c")
    private String myceQuote;

    @JsonProperty("thn__Company__c")
    private String company;

    @JsonProperty("thn__Department__c")
    private String department;

    @JsonProperty("thn__DoNotCall__c")
    private boolean doNotCall;

    @JsonProperty("thn__EmailOptOut__c")
    private boolean emailOptOut;

    @JsonProperty("thn__Fax__c")
    private String fax;

    @JsonProperty("thn__HomePhone__c")
    private String homePhone;

    @JsonProperty("thn__MailingCountry__c")
    private String mailingCountry;

    @JsonProperty("thn__MailingStateCode__c")
    private String mailingStateCode;

    @JsonProperty("thn__MailingState__c")
    private String mailingState;

    @JsonProperty("thn__MailingStreetLine2__c")
    private String mailingStreetLine2;

    @JsonProperty("thn__MailingStreetLine3__c")
    private String mailingStreetLine3;

    @JsonProperty("thn__MailingStreetLine4__c")
    private String mailingStreetLine4;

    @JsonProperty("thn__OtherCity__c")
    private String otherCity;

    @JsonProperty("thn__OtherCountryCode__c")
    private String otherCountryCode;

    @JsonProperty("thn__OtherCountry__c")
    private String otherCountry;

    @JsonProperty("thn__OtherPhone__c")
    private String otherPhone;

    @JsonProperty("thn__OtherPostalCode__c")
    private String otherPostalCode;

    @JsonProperty("thn__OtherStateCode__c")
    private String otherStateCode;

    @JsonProperty("thn__OtherState__c")
    private String otherState;

    @JsonProperty("thn__OtherStreetLine2__c")
    private String otherStreetLine2;

    @JsonProperty("thn__OtherStreetLine3__c")
    private String otherStreetLine3;

    @JsonProperty("thn__OtherStreetLine4__c")
    private String otherStreetLine4;

    @JsonProperty("thn__OtherStreet__c")
    private String otherStreet;

    @JsonProperty("thn__PMSId__c")
    private String pmsId;

    @JsonProperty("thn__PMSSystemId__c")
    private String pmsSystemId;

    @JsonProperty("thn__PMSSystemType__c")
    private String pmsSystemType;

    @JsonProperty("thn__POS_Company_Id__c")
    private String posCompanyId;

    @JsonProperty("thn__POS_Credits__c")
    private String posCredits;

    @JsonProperty("thn__POS_Delivery_City__c")
    private String posDeliveryCity;

    @JsonProperty("thn__POS_Delivery_Country__c")
    private String posDeliveryCountry;

    @JsonProperty("thn__POS_Delivery_Street_Number__c")
    private String posDeliveryStreetNumber;

    @JsonProperty("thn__POS_Delivery_Street__c")
    private String posDeliveryStreet;

    @JsonProperty("thn__POS_Delivery_Zip__c")
    private String posDeliveryZip;

    @JsonProperty("thn__POS_Error_Message__c")
    private String posErrorMessage;

    @JsonProperty("thn__POS_Id__c")
    private String posId;

    @JsonProperty("thn__POS_Language__c")
    private String posLanguage;

    @JsonProperty("thn__POS_Street_Number__c")
    private String posStreetNumber;

    @JsonProperty("thn__POS_UUID__c")
    private String posUuid;

    @JsonProperty("thn__POS_Vat_Number__c")
    private String posVatNumber;

    @JsonProperty("thn__POS_Visible__c")
    private boolean posVisible;

    @JsonProperty("thn__PropertyDetailsChainCode__c")
    private String propertyDetailsChainCode;

    @JsonProperty("thn__PropertyDetailsCode__c")
    private String propertyDetailsCode;

    @JsonProperty("thn__SendToPms__c")
    private boolean sendToPms;

    @JsonProperty("thn__Send_to_POS__c")
    private boolean sendToPos;

    @JsonProperty("thn__Source__c")
    private String source;

    @JsonProperty("thn__Type__c")
    private String type;

    @JsonProperty("thn__UniquePMSKey__c")
    private String uniquePMSKey;

    @JsonProperty("thn__HapiId__c")
    private String hapiId;

    @JsonProperty("thn__CreateContact__c")
    private boolean createContact;

    @JsonProperty("thn__Language__c")
    private String language;

    @JsonProperty("thn__Nationality__c")
    private String nationality;

    @JsonProperty("thn__Business_email__c")
    private String businessEmail;

    @JsonProperty("thn__MiddleName__c")
    private String middleName;

    @JsonProperty("thn__PMS_Account__c")
    private String pmsAccount;

    @JsonProperty("thn__PMS_Address_Type__c")
    private String pmsAddressType;

    @JsonProperty("thn__Passport__c")
    private String passport;

    @JsonProperty("thn__VIP__c")
    private String vip;

    @JsonProperty("thn__Sync_Status__c")
    private String syncStatus;

    @JsonProperty("thn__Email_Address_Type__c")
    private String emailAddressType;

    @JsonProperty("thn__Composite_Key_1__c")
    private String compositeKey1;

    @JsonProperty("thn__Composite_Key_2__c")
    private String compositeKey2;

    @JsonProperty("thn__Is_VIP__c")
    private boolean isVip;

    @JsonProperty("thn__Job_Title__c")
    private String jobTitle;

    @JsonProperty("thn__Opted_Promotional_Emails__c")
    private boolean optedPromotionalEmails;

    @JsonProperty("thn__Works_At__c")
    private String worksAt;

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getClassifications() {
        return classifications;
    }

    public void setClassifications(String classifications) {
        this.classifications = classifications;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(String createdUtc) {
        this.createdUtc = createdUtc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public boolean isInvoiceable() {
        return invoiceable;
    }

    public void setInvoiceable(boolean invoiceable) {
        this.invoiceable = invoiceable;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoyaltyCode() {
        return loyaltyCode;
    }

    public void setLoyaltyCode(String loyaltyCode) {
        this.loyaltyCode = loyaltyCode;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingCountryCode() {
        return mailingCountryCode;
    }

    public void setMailingCountryCode(String mailingCountryCode) {
        this.mailingCountryCode = mailingCountryCode;
    }

    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    public void setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMewsErrorMessage() {
        return mewsErrorMessage;
    }

    public void setMewsErrorMessage(String mewsErrorMessage) {
        this.mewsErrorMessage = mewsErrorMessage;
    }

    public String getMewsId() {
        return mewsId;
    }

    public void setMewsId(String mewsId) {
        this.mewsId = mewsId;
    }

    public String getMewsNumber() {
        return mewsNumber;
    }

    public void setMewsNumber(String mewsNumber) {
        this.mewsNumber = mewsNumber;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSendMarketingEmails() {
        return sendMarketingEmails;
    }

    public void setSendMarketingEmails(boolean sendMarketingEmails) {
        this.sendMarketingEmails = sendMarketingEmails;
    }

    public boolean isSendToMews() {
        return sendToMews;
    }

    public void setSendToMews(boolean sendToMews) {
        this.sendToMews = sendToMews;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedUtc() {
        return updatedUtc;
    }

    public void setUpdatedUtc(String updatedUtc) {
        this.updatedUtc = updatedUtc;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getMyceQuote() {
        return myceQuote;
    }

    public void setMyceQuote(String myceQuote) {
        this.myceQuote = myceQuote;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isDoNotCall() {
        return doNotCall;
    }

    public void setDoNotCall(boolean doNotCall) {
        this.doNotCall = doNotCall;
    }

    public boolean isEmailOptOut() {
        return emailOptOut;
    }

    public void setEmailOptOut(boolean emailOptOut) {
        this.emailOptOut = emailOptOut;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public String getMailingStateCode() {
        return mailingStateCode;
    }

    public void setMailingStateCode(String mailingStateCode) {
        this.mailingStateCode = mailingStateCode;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingStreetLine2() {
        return mailingStreetLine2;
    }

    public void setMailingStreetLine2(String mailingStreetLine2) {
        this.mailingStreetLine2 = mailingStreetLine2;
    }

    public String getMailingStreetLine3() {
        return mailingStreetLine3;
    }

    public void setMailingStreetLine3(String mailingStreetLine3) {
        this.mailingStreetLine3 = mailingStreetLine3;
    }

    public String getMailingStreetLine4() {
        return mailingStreetLine4;
    }

    public void setMailingStreetLine4(String mailingStreetLine4) {
        this.mailingStreetLine4 = mailingStreetLine4;
    }

    public String getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(String otherCity) {
        this.otherCity = otherCity;
    }

    public String getOtherCountryCode() {
        return otherCountryCode;
    }

    public void setOtherCountryCode(String otherCountryCode) {
        this.otherCountryCode = otherCountryCode;
    }

    public String getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getOtherPostalCode() {
        return otherPostalCode;
    }

    public void setOtherPostalCode(String otherPostalCode) {
        this.otherPostalCode = otherPostalCode;
    }

    public String getOtherStateCode() {
        return otherStateCode;
    }

    public void setOtherStateCode(String otherStateCode) {
        this.otherStateCode = otherStateCode;
    }

    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    public String getOtherStreetLine2() {
        return otherStreetLine2;
    }

    public void setOtherStreetLine2(String otherStreetLine2) {
        this.otherStreetLine2 = otherStreetLine2;
    }

    public String getOtherStreetLine3() {
        return otherStreetLine3;
    }

    public void setOtherStreetLine3(String otherStreetLine3) {
        this.otherStreetLine3 = otherStreetLine3;
    }

    public String getOtherStreetLine4() {
        return otherStreetLine4;
    }

    public void setOtherStreetLine4(String otherStreetLine4) {
        this.otherStreetLine4 = otherStreetLine4;
    }

    public String getOtherStreet() {
        return otherStreet;
    }

    public void setOtherStreet(String otherStreet) {
        this.otherStreet = otherStreet;
    }

    public String getPmsId() {
        return pmsId;
    }

    public void setPmsId(String pmsId) {
        this.pmsId = pmsId;
    }

    public String getPmsSystemId() {
        return pmsSystemId;
    }

    public void setPmsSystemId(String pmsSystemId) {
        this.pmsSystemId = pmsSystemId;
    }

    public String getPmsSystemType() {
        return pmsSystemType;
    }

    public void setPmsSystemType(String pmsSystemType) {
        this.pmsSystemType = pmsSystemType;
    }

    public String getPosCompanyId() {
        return posCompanyId;
    }

    public void setPosCompanyId(String posCompanyId) {
        this.posCompanyId = posCompanyId;
    }

    public String getPosCredits() {
        return posCredits;
    }

    public void setPosCredits(String posCredits) {
        this.posCredits = posCredits;
    }

    public String getPosDeliveryCity() {
        return posDeliveryCity;
    }

    public void setPosDeliveryCity(String posDeliveryCity) {
        this.posDeliveryCity = posDeliveryCity;
    }

    public String getPosDeliveryCountry() {
        return posDeliveryCountry;
    }

    public void setPosDeliveryCountry(String posDeliveryCountry) {
        this.posDeliveryCountry = posDeliveryCountry;
    }

    public String getPosDeliveryStreetNumber() {
        return posDeliveryStreetNumber;
    }

    public void setPosDeliveryStreetNumber(String posDeliveryStreetNumber) {
        this.posDeliveryStreetNumber = posDeliveryStreetNumber;
    }

    public String getPosDeliveryStreet() {
        return posDeliveryStreet;
    }

    public void setPosDeliveryStreet(String posDeliveryStreet) {
        this.posDeliveryStreet = posDeliveryStreet;
    }

    public String getPosDeliveryZip() {
        return posDeliveryZip;
    }

    public void setPosDeliveryZip(String posDeliveryZip) {
        this.posDeliveryZip = posDeliveryZip;
    }

    public String getPosErrorMessage() {
        return posErrorMessage;
    }

    public void setPosErrorMessage(String posErrorMessage) {
        this.posErrorMessage = posErrorMessage;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getPosLanguage() {
        return posLanguage;
    }

    public void setPosLanguage(String posLanguage) {
        this.posLanguage = posLanguage;
    }

    public String getPosStreetNumber() {
        return posStreetNumber;
    }

    public void setPosStreetNumber(String posStreetNumber) {
        this.posStreetNumber = posStreetNumber;
    }

    public String getPosUuid() {
        return posUuid;
    }

    public void setPosUuid(String posUuid) {
        this.posUuid = posUuid;
    }

    public String getPosVatNumber() {
        return posVatNumber;
    }

    public void setPosVatNumber(String posVatNumber) {
        this.posVatNumber = posVatNumber;
    }

    public boolean isPosVisible() {
        return posVisible;
    }

    public void setPosVisible(boolean posVisible) {
        this.posVisible = posVisible;
    }

    public String getPropertyDetailsChainCode() {
        return propertyDetailsChainCode;
    }

    public void setPropertyDetailsChainCode(String propertyDetailsChainCode) {
        this.propertyDetailsChainCode = propertyDetailsChainCode;
    }

    public String getPropertyDetailsCode() {
        return propertyDetailsCode;
    }

    public void setPropertyDetailsCode(String propertyDetailsCode) {
        this.propertyDetailsCode = propertyDetailsCode;
    }

    public boolean isSendToPms() {
        return sendToPms;
    }

    public void setSendToPms(boolean sendToPms) {
        this.sendToPms = sendToPms;
    }

    public boolean isSendToPos() {
        return sendToPos;
    }

    public void setSendToPos(boolean sendToPos) {
        this.sendToPos = sendToPos;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniquePMSKey() {
        return uniquePMSKey;
    }

    public void setUniquePMSKey(String uniquePMSKey) {
        this.uniquePMSKey = uniquePMSKey;
    }

    public String getHapiId() {
        return hapiId;
    }

    public void setHapiId(String hapiId) {
        this.hapiId = hapiId;
    }

    public boolean isCreateContact() {
        return createContact;
    }

    public void setCreateContact(boolean createContact) {
        this.createContact = createContact;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPmsAccount() {
        return pmsAccount;
    }

    public void setPmsAccount(String pmsAccount) {
        this.pmsAccount = pmsAccount;
    }

    public String getPmsAddressType() {
        return pmsAddressType;
    }

    public void setPmsAddressType(String pmsAddressType) {
        this.pmsAddressType = pmsAddressType;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getEmailAddressType() {
        return emailAddressType;
    }

    public void setEmailAddressType(String emailAddressType) {
        this.emailAddressType = emailAddressType;
    }

    public String getCompositeKey1() {
        return compositeKey1;
    }

    public void setCompositeKey1(String compositeKey1) {
        this.compositeKey1 = compositeKey1;
    }

    public String getCompositeKey2() {
        return compositeKey2;
    }

    public void setCompositeKey2(String compositeKey2) {
        this.compositeKey2 = compositeKey2;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isOptedPromotionalEmails() {
        return optedPromotionalEmails;
    }

    public void setOptedPromotionalEmails(boolean optedPromotionalEmails) {
        this.optedPromotionalEmails = optedPromotionalEmails;
    }

    public String getWorksAt() {
        return worksAt;
    }

    public void setWorksAt(String worksAt) {
        this.worksAt = worksAt;
    }
}

