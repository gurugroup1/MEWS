package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PSMAccountRequest {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("CurrencyIsoCode")
    private String currencyIsoCode;
        @JsonProperty("thn__Account_Receivable_Number__c")
    private String accountReceivableNumber;

    @JsonProperty("thn__Account__c")
    private String account;

    @JsonProperty("thn__BillingCity__c")
    private String billingCity;

    @JsonProperty("thn__BillingCountryCode__c")
    private String billingCountryCode;

    @JsonProperty("thn__BillingCountry__c")
    private String billingCountry;

    @JsonProperty("thn__BillingPostalCode__c")
    private String billingPostalCode;

    @JsonProperty("thn__BillingStateCode__c")
    private String billingStateCode;

    @JsonProperty("thn__BillingState__c")
    private String billingState;

    @JsonProperty("thn__BillingStreetLine2__c")
    private String billingStreetLine2;

    @JsonProperty("thn__BillingStreetLine3__c")
    private String billingStreetLine3;

    @JsonProperty("thn__BillingStreetLine4__c")
    private String billingStreetLine4;

    @JsonProperty("thn__BillingStreet__c")
    private String billingStreet;

    @JsonProperty("thn__Corporate_Id__c")
    private String corporateId;

    @JsonProperty("thn__CreateAccount__c")
    private boolean createAccount;

    @JsonProperty("thn__Email__c")
    private String email;

    @JsonProperty("thn__Fax__c")
    private String fax;

    @JsonProperty("thn__HapiId__c")
    private String hapiId;

    @JsonProperty("thn__IATANumber__c")
    private String iataNumber;

    @JsonProperty("thn__PMSId__c")
    private String pmsId;

    @JsonProperty("thn__PMSSystemId__c")
    private String pmsSystemId;

    @JsonProperty("thn__PMSSystemType__c")
    private String pmsSystemType;

    @JsonProperty("thn__PMS_Address_Type__c")
    private String pmsAddressType;

    @JsonProperty("thn__Phone__c")
    private String phone;

    @JsonProperty("thn__PrimaryCity__c")
    private String primaryCity;

    @JsonProperty("thn__PrimaryCountryCode__c")
    private String primaryCountryCode;

    @JsonProperty("thn__PrimaryCountry__c")
    private String primaryCountry;

    @JsonProperty("thn__PrimaryPostalCode__c")
    private String primaryPostalCode;

    @JsonProperty("thn__PrimaryStateCode__c")
    private String primaryStateCode;

    @JsonProperty("thn__PrimaryState__c")
    private String primaryState;

    @JsonProperty("thn__PrimaryStreetLine2__c")
    private String primaryStreetLine2;

    @JsonProperty("thn__PrimaryStreetLine3__c")
    private String primaryStreetLine3;

    @JsonProperty("thn__PrimaryStreetLine4__c")
    private String primaryStreetLine4;

    @JsonProperty("thn__PrimaryStreet__c")
    private String primaryStreet;

    @JsonProperty("thn__PropertyDetailsChainCode__c")
    private String propertyDetailsChainCode;

    @JsonProperty("thn__PropertyDetailsCode__c")
    private String propertyDetailsCode;

    @JsonProperty("thn__Secondary_name__c")
    private String secondaryName;

    @JsonProperty("thn__SendToPmsStatus__c")
    private String sendToPmsStatus;

    @JsonProperty("thn__SendToPms__c")
    private boolean sendToPms;

    @JsonProperty("thn__ShippingCity__c")
    private String shippingCity;

    @JsonProperty("thn__ShippingCountryCode__c")
    private String shippingCountryCode;

    @JsonProperty("thn__ShippingCountry__c")
    private String shippingCountry;

    @JsonProperty("thn__ShippingPostalCode__c")
    private String shippingPostalCode;

    @JsonProperty("thn__ShippingStateCode__c")
    private String shippingStateCode;

    @JsonProperty("thn__ShippingState__c")
    private String shippingState;

    @JsonProperty("thn__ShippingStreetLine2__c")
    private String shippingStreetLine2;

    @JsonProperty("thn__ShippingStreetLine3__c")
    private String shippingStreetLine3;

    @JsonProperty("thn__ShippingStreetLine4__c")
    private String shippingStreetLine4;

    @JsonProperty("thn__ShippingStreet__c")
    private String shippingStreet;

    @JsonProperty("thn__SicCode__c")
    private String sicCode;

    @JsonProperty("thn__SicDescription__c")
    private String sicDescription;

    @JsonProperty("thn__Status__c")
    private String status;

    @JsonProperty("thn__SyncAccount__c")
    private boolean syncAccount;

    @JsonProperty("thn__Tax_Id__c")
    private String taxId;

    @JsonProperty("thn__Territory__c")
    private String territory;

    @JsonProperty("thn__Tertiary_name__c")
    private String tertiaryName;

    @JsonProperty("thn__Type__c")
    private String type;

    @JsonProperty("thn__UniquePMSKey__c")
    private String uniquePMSKey;

    @JsonProperty("thn__Website__c")
    private String website;

    @JsonProperty("thn__Full_Name__c")
    private String fullName;


    @JsonProperty("thn__PMS_DB__c")
    private String pmsDB;

    @JsonProperty("thn__Business_Phone__c")
    private String businessPhone;

    @JsonProperty("thn__Email_Address_Type__c")
    private String emailAddressType;

    @JsonProperty("thn__Mobile_Phone__c")
    private String mobilePhone;

    @JsonProperty("thn__VIP_Status__c")
    private String vipStatus;

    @JsonProperty("thn__AdditionalTaxIdentifier__c")
    private String additionalTaxIdentifier;

    @JsonProperty("thn__ElectronicInvoiceIdentifier__c")
    private String electronicInvoiceIdentifier;
    @JsonProperty("thn__MYCE_Quote__c")
    private String myceQuote;

    @JsonProperty("thn__Notes__c")
    private String notes;

    @JsonProperty("thn__Number__c")
    private String number;

    @JsonProperty("thn__Property__c")
    private String property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getAccountReceivableNumber() {
        return accountReceivableNumber;
    }

    public void setAccountReceivableNumber(String accountReceivableNumber) {
        this.accountReceivableNumber = accountReceivableNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingCountryCode() {
        return billingCountryCode;
    }

    public void setBillingCountryCode(String billingCountryCode) {
        this.billingCountryCode = billingCountryCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingStateCode() {
        return billingStateCode;
    }

    public void setBillingStateCode(String billingStateCode) {
        this.billingStateCode = billingStateCode;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingStreetLine2() {
        return billingStreetLine2;
    }

    public void setBillingStreetLine2(String billingStreetLine2) {
        this.billingStreetLine2 = billingStreetLine2;
    }

    public String getBillingStreetLine3() {
        return billingStreetLine3;
    }

    public void setBillingStreetLine3(String billingStreetLine3) {
        this.billingStreetLine3 = billingStreetLine3;
    }

    public String getBillingStreetLine4() {
        return billingStreetLine4;
    }

    public void setBillingStreetLine4(String billingStreetLine4) {
        this.billingStreetLine4 = billingStreetLine4;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public boolean isCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(boolean createAccount) {
        this.createAccount = createAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHapiId() {
        return hapiId;
    }

    public void setHapiId(String hapiId) {
        this.hapiId = hapiId;
    }

    public String getIataNumber() {
        return iataNumber;
    }

    public void setIataNumber(String iataNumber) {
        this.iataNumber = iataNumber;
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

    public String getPmsAddressType() {
        return pmsAddressType;
    }

    public void setPmsAddressType(String pmsAddressType) {
        this.pmsAddressType = pmsAddressType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }

    public String getPrimaryCountryCode() {
        return primaryCountryCode;
    }

    public void setPrimaryCountryCode(String primaryCountryCode) {
        this.primaryCountryCode = primaryCountryCode;
    }

    public String getPrimaryCountry() {
        return primaryCountry;
    }

    public void setPrimaryCountry(String primaryCountry) {
        this.primaryCountry = primaryCountry;
    }

    public String getPrimaryPostalCode() {
        return primaryPostalCode;
    }

    public void setPrimaryPostalCode(String primaryPostalCode) {
        this.primaryPostalCode = primaryPostalCode;
    }

    public String getPrimaryStateCode() {
        return primaryStateCode;
    }

    public void setPrimaryStateCode(String primaryStateCode) {
        this.primaryStateCode = primaryStateCode;
    }

    public String getPrimaryState() {
        return primaryState;
    }

    public void setPrimaryState(String primaryState) {
        this.primaryState = primaryState;
    }

    public String getPrimaryStreetLine2() {
        return primaryStreetLine2;
    }

    public void setPrimaryStreetLine2(String primaryStreetLine2) {
        this.primaryStreetLine2 = primaryStreetLine2;
    }

    public String getPrimaryStreetLine3() {
        return primaryStreetLine3;
    }

    public void setPrimaryStreetLine3(String primaryStreetLine3) {
        this.primaryStreetLine3 = primaryStreetLine3;
    }

    public String getPrimaryStreetLine4() {
        return primaryStreetLine4;
    }

    public void setPrimaryStreetLine4(String primaryStreetLine4) {
        this.primaryStreetLine4 = primaryStreetLine4;
    }

    public String getPrimaryStreet() {
        return primaryStreet;
    }

    public void setPrimaryStreet(String primaryStreet) {
        this.primaryStreet = primaryStreet;
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

    public String getSecondaryName() {
        return secondaryName;
    }

    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    public String getSendToPmsStatus() {
        return sendToPmsStatus;
    }

    public void setSendToPmsStatus(String sendToPmsStatus) {
        this.sendToPmsStatus = sendToPmsStatus;
    }

    public boolean isSendToPms() {
        return sendToPms;
    }

    public void setSendToPms(boolean sendToPms) {
        this.sendToPms = sendToPms;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingCountryCode() {
        return shippingCountryCode;
    }

    public void setShippingCountryCode(String shippingCountryCode) {
        this.shippingCountryCode = shippingCountryCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingStateCode() {
        return shippingStateCode;
    }

    public void setShippingStateCode(String shippingStateCode) {
        this.shippingStateCode = shippingStateCode;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingStreetLine2() {
        return shippingStreetLine2;
    }

    public void setShippingStreetLine2(String shippingStreetLine2) {
        this.shippingStreetLine2 = shippingStreetLine2;
    }

    public String getShippingStreetLine3() {
        return shippingStreetLine3;
    }

    public void setShippingStreetLine3(String shippingStreetLine3) {
        this.shippingStreetLine3 = shippingStreetLine3;
    }

    public String getShippingStreetLine4() {
        return shippingStreetLine4;
    }

    public void setShippingStreetLine4(String shippingStreetLine4) {
        this.shippingStreetLine4 = shippingStreetLine4;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public String getSicDescription() {
        return sicDescription;
    }

    public void setSicDescription(String sicDescription) {
        this.sicDescription = sicDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSyncAccount() {
        return syncAccount;
    }

    public void setSyncAccount(boolean syncAccount) {
        this.syncAccount = syncAccount;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getTertiaryName() {
        return tertiaryName;
    }

    public void setTertiaryName(String tertiaryName) {
        this.tertiaryName = tertiaryName;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPmsDB() {
        return pmsDB;
    }

    public void setPmsDB(String pmsDB) {
        this.pmsDB = pmsDB;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getEmailAddressType() {
        return emailAddressType;
    }

    public void setEmailAddressType(String emailAddressType) {
        this.emailAddressType = emailAddressType;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public String getAdditionalTaxIdentifier() {
        return additionalTaxIdentifier;
    }

    public void setAdditionalTaxIdentifier(String additionalTaxIdentifier) {
        this.additionalTaxIdentifier = additionalTaxIdentifier;
    }

    public String getElectronicInvoiceIdentifier() {
        return electronicInvoiceIdentifier;
    }

    public void setElectronicInvoiceIdentifier(String electronicInvoiceIdentifier) {
        this.electronicInvoiceIdentifier = electronicInvoiceIdentifier;
    }
    public String getMyceQuote() {
        return myceQuote;
    }

    public void setMyceQuote(String myceQuote) {
        this.myceQuote = myceQuote;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}