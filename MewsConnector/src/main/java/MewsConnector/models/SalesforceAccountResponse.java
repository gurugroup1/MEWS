package MewsConnector.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceAccountResponse {
    Attributes AttributesObject;
    private String Id;
    private boolean IsDeleted;
    private String MasterRecordId = null;
    private String Name;
    private String Type = null;
    private String RecordTypeId;
    private String ParentId = null;
    private String BillingStreet = null;
    private String BillingCity = null;
    private String BillingState = null;
    private String BillingPostalCode = null;
    private String BillingCountry = null;
    private String BillingStateCode = null;
    private String BillingCountryCode = null;
    private String BillingLatitude = null;
    private String BillingLongitude = null;
    private String BillingGeocodeAccuracy = null;
    private String BillingAddress = null;
    private String ShippingStreet = null;
    private String ShippingCity = null;
    private String ShippingState = null;
    private String ShippingPostalCode = null;
    private String ShippingCountry = null;
    private String ShippingStateCode = null;
    private String ShippingCountryCode = null;
    private String ShippingLatitude = null;
    private String ShippingLongitude = null;
    private String ShippingGeocodeAccuracy = null;
    private String ShippingAddress = null;
    private String Phone = null;
    private String Fax = null;
    private String AccountNumber = null;
    private String Website = null;
    private String PhotoUrl;
    private String Sic = null;
    private String Industry = null;
    private String AnnualRevenue = null;
    private String NumberOfEmployees = null;
    private String Ownership = null;
    private String TickerSymbol = null;
    private String Description = null;
    private String Rating = null;
    private String Site = null;
    private String CurrencyIsoCode;
    private String OwnerId;
    private String CreatedDate;
    private String CreatedById;
    private String LastModifiedDate;
    private String LastModifiedById;
    private String SystemModstamp;
    private String LastActivityDate = null;
    private String LastViewedDate;
    private String LastReferencedDate;
    private String Jigsaw = null;
    private String JigsawCompanyId = null;
    private String AccountSource = null;
    private String SicDesc = null;
    private String thn__AR_Number__c = null;
    private String thn__Accounting_Code__c = null;
    private String thn__Additional_Tax_Identifier__c = null;
    private String thn__BillingCode__c = null;
    private String thn__Billing_name__c = null;
    private String thn__CustomerPriority__c = null;
    private String thn__Electronic_Invoice_Identifier__c = null;
    private String thn__Hotel__c;
    private String thn__Identifier__c = null;
    private boolean thn__Is_Active__c;
    private boolean thn__Is_Parent__c;
    private String thn__Mews_Error_Message__c = null;
    private String thn__Mews_Id__c;
    private String thn__Number__c;
    private String thn__NumberofLocations__c = null;
    private boolean thn__Send_to_Mews__c;
    private String thn__Status__c;
    private String thn__Subtype__c = null;
    private String thn__TaxIdentifier__c = null;
    private String thn__Type__c;
    private String thn__IATA__c = null;
    private String thn__Notes__c = null;
    private String thn__Beverage__c = null;
    private String thn__Food__c = null;
    private String thn__Meeting_Room__c = null;
    private String thn__Other__c = null;
    private String thn__Room__c = null;
    private String thn__Account_ID__c;
    private String Account_Number__c;
    private String Stage__c = null;
    private String Tier__c = null;
    private boolean AR_nummer_aanvragen__c;
    private float Payment_term__c;
    private String Company_VAT_Number__c = null;
    private String thn__Comm_Activity__c = null;
    private String Company_industry__c = null;
    private String Quote_info__c = null;
    private String Sales_Area__c;
    private String Account_Status__c = null;
    private String thn__Comm_Equipment__c = null;
    private String thn__Comm_Packages__c = null;
    private boolean thn__Markup__c;
    private boolean thn__UpdateFields__c;
    private String thn__Sync_Status__c;
    private String Origin__c;
    private String type_other__c = null;
    private boolean thn__Copy_Billing_address__c;
    private String thn__Corporate_Id__c = null;
    private String thn__Email__c = null;
    private String thn__PrimaryCity__c = null;
    private String thn__PrimaryCountryCode__c = null;
    private String thn__PrimaryCountry__c = null;
    private String thn__PrimaryPostalCode__c = null;
    private String thn__PrimaryState__c = null;
    private String thn__PrimaryStreet__c = null;
    private boolean thn__Send_To_Pms__c;


    // Getter Methods

    public Attributes getAttributes() {
        return AttributesObject;
    }

    public String getId() {
        return Id;
    }

    public boolean getIsDeleted() {
        return IsDeleted;
    }

    public String getMasterRecordId() {
        return MasterRecordId;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public String getParentId() {
        return ParentId;
    }

    public String getBillingStreet() {
        return BillingStreet;
    }

    public String getBillingCity() {
        return BillingCity;
    }

    public String getBillingState() {
        return BillingState;
    }

    public String getBillingPostalCode() {
        return BillingPostalCode;
    }

    public String getBillingCountry() {
        return BillingCountry;
    }

    public String getBillingStateCode() {
        return BillingStateCode;
    }

    public String getBillingCountryCode() {
        return BillingCountryCode;
    }

    public String getBillingLatitude() {
        return BillingLatitude;
    }

    public String getBillingLongitude() {
        return BillingLongitude;
    }

    public String getBillingGeocodeAccuracy() {
        return BillingGeocodeAccuracy;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public String getShippingStreet() {
        return ShippingStreet;
    }

    public String getShippingCity() {
        return ShippingCity;
    }

    public String getShippingState() {
        return ShippingState;
    }

    public String getShippingPostalCode() {
        return ShippingPostalCode;
    }

    public String getShippingCountry() {
        return ShippingCountry;
    }

    public String getShippingStateCode() {
        return ShippingStateCode;
    }

    public String getShippingCountryCode() {
        return ShippingCountryCode;
    }

    public String getShippingLatitude() {
        return ShippingLatitude;
    }

    public String getShippingLongitude() {
        return ShippingLongitude;
    }

    public String getShippingGeocodeAccuracy() {
        return ShippingGeocodeAccuracy;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public String getPhone() {
        return Phone;
    }

    public String getFax() {
        return Fax;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getWebsite() {
        return Website;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public String getSic() {
        return Sic;
    }

    public String getIndustry() {
        return Industry;
    }

    public String getAnnualRevenue() {
        return AnnualRevenue;
    }

    public String getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public String getOwnership() {
        return Ownership;
    }

    public String getTickerSymbol() {
        return TickerSymbol;
    }

    public String getDescription() {
        return Description;
    }

    public String getRating() {
        return Rating;
    }

    public String getSite() {
        return Site;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public String getCreatedById() {
        return CreatedById;
    }

    public String getLastModifiedDate() {
        return LastModifiedDate;
    }

    public String getLastModifiedById() {
        return LastModifiedById;
    }

    public String getSystemModstamp() {
        return SystemModstamp;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public String getLastViewedDate() {
        return LastViewedDate;
    }

    public String getLastReferencedDate() {
        return LastReferencedDate;
    }

    public String getJigsaw() {
        return Jigsaw;
    }

    public String getJigsawCompanyId() {
        return JigsawCompanyId;
    }

    public String getAccountSource() {
        return AccountSource;
    }

    public String getSicDesc() {
        return SicDesc;
    }

    public String getThn__AR_Number__c() {
        return thn__AR_Number__c;
    }

    public String getThn__Accounting_Code__c() {
        return thn__Accounting_Code__c;
    }

    public String getThn__Additional_Tax_Identifier__c() {
        return thn__Additional_Tax_Identifier__c;
    }

    public String getThn__BillingCode__c() {
        return thn__BillingCode__c;
    }

    public String getThn__Billing_name__c() {
        return thn__Billing_name__c;
    }

    public String getThn__CustomerPriority__c() {
        return thn__CustomerPriority__c;
    }

    public String getThn__Electronic_Invoice_Identifier__c() {
        return thn__Electronic_Invoice_Identifier__c;
    }

    public String getThn__Hotel__c() {
        return thn__Hotel__c;
    }

    public String getThn__Identifier__c() {
        return thn__Identifier__c;
    }

    public boolean getThn__Is_Active__c() {
        return thn__Is_Active__c;
    }

    public boolean getThn__Is_Parent__c() {
        return thn__Is_Parent__c;
    }

    public String getThn__Mews_Error_Message__c() {
        return thn__Mews_Error_Message__c;
    }

    public String getThn__Mews_Id__c() {
        return thn__Mews_Id__c;
    }

    public String getThn__Number__c() {
        return thn__Number__c;
    }

    public String getThn__NumberofLocations__c() {
        return thn__NumberofLocations__c;
    }

    public boolean getThn__Send_to_Mews__c() {
        return thn__Send_to_Mews__c;
    }

    public String getThn__Status__c() {
        return thn__Status__c;
    }

    public String getThn__Subtype__c() {
        return thn__Subtype__c;
    }

    public String getThn__TaxIdentifier__c() {
        return thn__TaxIdentifier__c;
    }

    public String getThn__Type__c() {
        return thn__Type__c;
    }

    public String getThn__IATA__c() {
        return thn__IATA__c;
    }

    public String getThn__Notes__c() {
        return thn__Notes__c;
    }

    public String getThn__Beverage__c() {
        return thn__Beverage__c;
    }

    public String getThn__Food__c() {
        return thn__Food__c;
    }

    public String getThn__Meeting_Room__c() {
        return thn__Meeting_Room__c;
    }

    public String getThn__Other__c() {
        return thn__Other__c;
    }

    public String getThn__Room__c() {
        return thn__Room__c;
    }

    public String getThn__Account_ID__c() {
        return thn__Account_ID__c;
    }

    public String getAccount_Number__c() {
        return Account_Number__c;
    }

    public String getStage__c() {
        return Stage__c;
    }

    public String getTier__c() {
        return Tier__c;
    }

    public boolean getAR_nummer_aanvragen__c() {
        return AR_nummer_aanvragen__c;
    }

    public float getPayment_term__c() {
        return Payment_term__c;
    }

    public String getCompany_VAT_Number__c() {
        return Company_VAT_Number__c;
    }

    public String getThn__Comm_Activity__c() {
        return thn__Comm_Activity__c;
    }

    public String getCompany_industry__c() {
        return Company_industry__c;
    }

    public String getQuote_info__c() {
        return Quote_info__c;
    }

    public String getSales_Area__c() {
        return Sales_Area__c;
    }

    public String getAccount_Status__c() {
        return Account_Status__c;
    }

    public String getThn__Comm_Equipment__c() {
        return thn__Comm_Equipment__c;
    }

    public String getThn__Comm_Packages__c() {
        return thn__Comm_Packages__c;
    }

    public boolean getThn__Markup__c() {
        return thn__Markup__c;
    }

    public boolean getThn__UpdateFields__c() {
        return thn__UpdateFields__c;
    }

    public String getThn__Sync_Status__c() {
        return thn__Sync_Status__c;
    }

    public String getOrigin__c() {
        return Origin__c;
    }

    public String getType_other__c() {
        return type_other__c;
    }

    public boolean getThn__Copy_Billing_address__c() {
        return thn__Copy_Billing_address__c;
    }

    public String getThn__Corporate_Id__c() {
        return thn__Corporate_Id__c;
    }

    public String getThn__Email__c() {
        return thn__Email__c;
    }

    public String getThn__PrimaryCity__c() {
        return thn__PrimaryCity__c;
    }

    public String getThn__PrimaryCountryCode__c() {
        return thn__PrimaryCountryCode__c;
    }

    public String getThn__PrimaryCountry__c() {
        return thn__PrimaryCountry__c;
    }

    public String getThn__PrimaryPostalCode__c() {
        return thn__PrimaryPostalCode__c;
    }

    public String getThn__PrimaryState__c() {
        return thn__PrimaryState__c;
    }

    public String getThn__PrimaryStreet__c() {
        return thn__PrimaryStreet__c;
    }

    public boolean getThn__Send_To_Pms__c() {
        return thn__Send_To_Pms__c;
    }

    // Setter Methods

    public void setAttributes(Attributes attributesObject) {
        this.AttributesObject = attributesObject;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setIsDeleted(boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    public void setMasterRecordId(String MasterRecordId) {
        this.MasterRecordId = MasterRecordId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setRecordTypeId(String RecordTypeId) {
        this.RecordTypeId = RecordTypeId;
    }

    public void setParentId(String ParentId) {
        this.ParentId = ParentId;
    }

    public void setBillingStreet(String BillingStreet) {
        this.BillingStreet = BillingStreet;
    }

    public void setBillingCity(String BillingCity) {
        this.BillingCity = BillingCity;
    }

    public void setBillingState(String BillingState) {
        this.BillingState = BillingState;
    }

    public void setBillingPostalCode(String BillingPostalCode) {
        this.BillingPostalCode = BillingPostalCode;
    }

    public void setBillingCountry(String BillingCountry) {
        this.BillingCountry = BillingCountry;
    }

    public void setBillingStateCode(String BillingStateCode) {
        this.BillingStateCode = BillingStateCode;
    }

    public void setBillingCountryCode(String BillingCountryCode) {
        this.BillingCountryCode = BillingCountryCode;
    }

    public void setBillingLatitude(String BillingLatitude) {
        this.BillingLatitude = BillingLatitude;
    }

    public void setBillingLongitude(String BillingLongitude) {
        this.BillingLongitude = BillingLongitude;
    }

    public void setBillingGeocodeAccuracy(String BillingGeocodeAccuracy) {
        this.BillingGeocodeAccuracy = BillingGeocodeAccuracy;
    }

    public void setBillingAddress(String BillingAddress) {
        this.BillingAddress = BillingAddress;
    }

    public void setShippingStreet(String ShippingStreet) {
        this.ShippingStreet = ShippingStreet;
    }

    public void setShippingCity(String ShippingCity) {
        this.ShippingCity = ShippingCity;
    }

    public void setShippingState(String ShippingState) {
        this.ShippingState = ShippingState;
    }

    public void setShippingPostalCode(String ShippingPostalCode) {
        this.ShippingPostalCode = ShippingPostalCode;
    }

    public void setShippingCountry(String ShippingCountry) {
        this.ShippingCountry = ShippingCountry;
    }

    public void setShippingStateCode(String ShippingStateCode) {
        this.ShippingStateCode = ShippingStateCode;
    }

    public void setShippingCountryCode(String ShippingCountryCode) {
        this.ShippingCountryCode = ShippingCountryCode;
    }

    public void setShippingLatitude(String ShippingLatitude) {
        this.ShippingLatitude = ShippingLatitude;
    }

    public void setShippingLongitude(String ShippingLongitude) {
        this.ShippingLongitude = ShippingLongitude;
    }

    public void setShippingGeocodeAccuracy(String ShippingGeocodeAccuracy) {
        this.ShippingGeocodeAccuracy = ShippingGeocodeAccuracy;
    }

    public void setShippingAddress(String ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public void setPhotoUrl(String PhotoUrl) {
        this.PhotoUrl = PhotoUrl;
    }

    public void setSic(String Sic) {
        this.Sic = Sic;
    }

    public void setIndustry(String Industry) {
        this.Industry = Industry;
    }

    public void setAnnualRevenue(String AnnualRevenue) {
        this.AnnualRevenue = AnnualRevenue;
    }

    public void setNumberOfEmployees(String NumberOfEmployees) {
        this.NumberOfEmployees = NumberOfEmployees;
    }

    public void setOwnership(String Ownership) {
        this.Ownership = Ownership;
    }

    public void setTickerSymbol(String TickerSymbol) {
        this.TickerSymbol = TickerSymbol;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public void setSite(String Site) {
        this.Site = Site;
    }

    public void setCurrencyIsoCode(String CurrencyIsoCode) {
        this.CurrencyIsoCode = CurrencyIsoCode;
    }

    public void setOwnerId(String OwnerId) {
        this.OwnerId = OwnerId;
    }

    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public void setCreatedById(String CreatedById) {
        this.CreatedById = CreatedById;
    }

    public void setLastModifiedDate(String LastModifiedDate) {
        this.LastModifiedDate = LastModifiedDate;
    }

    public void setLastModifiedById(String LastModifiedById) {
        this.LastModifiedById = LastModifiedById;
    }

    public void setSystemModstamp(String SystemModstamp) {
        this.SystemModstamp = SystemModstamp;
    }

    public void setLastActivityDate(String LastActivityDate) {
        this.LastActivityDate = LastActivityDate;
    }

    public void setLastViewedDate(String LastViewedDate) {
        this.LastViewedDate = LastViewedDate;
    }

    public void setLastReferencedDate(String LastReferencedDate) {
        this.LastReferencedDate = LastReferencedDate;
    }

    public void setJigsaw(String Jigsaw) {
        this.Jigsaw = Jigsaw;
    }

    public void setJigsawCompanyId(String JigsawCompanyId) {
        this.JigsawCompanyId = JigsawCompanyId;
    }

    public void setAccountSource(String AccountSource) {
        this.AccountSource = AccountSource;
    }

    public void setSicDesc(String SicDesc) {
        this.SicDesc = SicDesc;
    }

    public void setThn__AR_Number__c(String thn__AR_Number__c) {
        this.thn__AR_Number__c = thn__AR_Number__c;
    }

    public void setThn__Accounting_Code__c(String thn__Accounting_Code__c) {
        this.thn__Accounting_Code__c = thn__Accounting_Code__c;
    }

    public void setThn__Additional_Tax_Identifier__c(String thn__Additional_Tax_Identifier__c) {
        this.thn__Additional_Tax_Identifier__c = thn__Additional_Tax_Identifier__c;
    }

    public void setThn__BillingCode__c(String thn__BillingCode__c) {
        this.thn__BillingCode__c = thn__BillingCode__c;
    }

    public void setThn__Billing_name__c(String thn__Billing_name__c) {
        this.thn__Billing_name__c = thn__Billing_name__c;
    }

    public void setThn__CustomerPriority__c(String thn__CustomerPriority__c) {
        this.thn__CustomerPriority__c = thn__CustomerPriority__c;
    }

    public void setThn__Electronic_Invoice_Identifier__c(String thn__Electronic_Invoice_Identifier__c) {
        this.thn__Electronic_Invoice_Identifier__c = thn__Electronic_Invoice_Identifier__c;
    }

    public void setThn__Hotel__c(String thn__Hotel__c) {
        this.thn__Hotel__c = thn__Hotel__c;
    }

    public void setThn__Identifier__c(String thn__Identifier__c) {
        this.thn__Identifier__c = thn__Identifier__c;
    }

    public void setThn__Is_Active__c(boolean thn__Is_Active__c) {
        this.thn__Is_Active__c = thn__Is_Active__c;
    }

    public void setThn__Is_Parent__c(boolean thn__Is_Parent__c) {
        this.thn__Is_Parent__c = thn__Is_Parent__c;
    }

    public void setThn__Mews_Error_Message__c(String thn__Mews_Error_Message__c) {
        this.thn__Mews_Error_Message__c = thn__Mews_Error_Message__c;
    }

    public void setThn__Mews_Id__c(String thn__Mews_Id__c) {
        this.thn__Mews_Id__c = thn__Mews_Id__c;
    }

    public void setThn__Number__c(String thn__Number__c) {
        this.thn__Number__c = thn__Number__c;
    }

    public void setThn__NumberofLocations__c(String thn__NumberofLocations__c) {
        this.thn__NumberofLocations__c = thn__NumberofLocations__c;
    }

    public void setThn__Send_to_Mews__c(boolean thn__Send_to_Mews__c) {
        this.thn__Send_to_Mews__c = thn__Send_to_Mews__c;
    }

    public void setThn__Status__c(String thn__Status__c) {
        this.thn__Status__c = thn__Status__c;
    }

    public void setThn__Subtype__c(String thn__Subtype__c) {
        this.thn__Subtype__c = thn__Subtype__c;
    }

    public void setThn__TaxIdentifier__c(String thn__TaxIdentifier__c) {
        this.thn__TaxIdentifier__c = thn__TaxIdentifier__c;
    }

    public void setThn__Type__c(String thn__Type__c) {
        this.thn__Type__c = thn__Type__c;
    }

    public void setThn__IATA__c(String thn__IATA__c) {
        this.thn__IATA__c = thn__IATA__c;
    }

    public void setThn__Notes__c(String thn__Notes__c) {
        this.thn__Notes__c = thn__Notes__c;
    }

    public void setThn__Beverage__c(String thn__Beverage__c) {
        this.thn__Beverage__c = thn__Beverage__c;
    }

    public void setThn__Food__c(String thn__Food__c) {
        this.thn__Food__c = thn__Food__c;
    }

    public void setThn__Meeting_Room__c(String thn__Meeting_Room__c) {
        this.thn__Meeting_Room__c = thn__Meeting_Room__c;
    }

    public void setThn__Other__c(String thn__Other__c) {
        this.thn__Other__c = thn__Other__c;
    }

    public void setThn__Room__c(String thn__Room__c) {
        this.thn__Room__c = thn__Room__c;
    }

    public void setThn__Account_ID__c(String thn__Account_ID__c) {
        this.thn__Account_ID__c = thn__Account_ID__c;
    }

    public void setAccount_Number__c(String Account_Number__c) {
        this.Account_Number__c = Account_Number__c;
    }

    public void setStage__c(String Stage__c) {
        this.Stage__c = Stage__c;
    }

    public void setTier__c(String Tier__c) {
        this.Tier__c = Tier__c;
    }

    public void setAR_nummer_aanvragen__c(boolean AR_nummer_aanvragen__c) {
        this.AR_nummer_aanvragen__c = AR_nummer_aanvragen__c;
    }

    public void setPayment_term__c(float Payment_term__c) {
        this.Payment_term__c = Payment_term__c;
    }

    public void setCompany_VAT_Number__c(String Company_VAT_Number__c) {
        this.Company_VAT_Number__c = Company_VAT_Number__c;
    }

    public void setThn__Comm_Activity__c(String thn__Comm_Activity__c) {
        this.thn__Comm_Activity__c = thn__Comm_Activity__c;
    }

    public void setCompany_industry__c(String Company_industry__c) {
        this.Company_industry__c = Company_industry__c;
    }

    public void setQuote_info__c(String Quote_info__c) {
        this.Quote_info__c = Quote_info__c;
    }

    public void setSales_Area__c(String Sales_Area__c) {
        this.Sales_Area__c = Sales_Area__c;
    }

    public void setAccount_Status__c(String Account_Status__c) {
        this.Account_Status__c = Account_Status__c;
    }

    public void setThn__Comm_Equipment__c(String thn__Comm_Equipment__c) {
        this.thn__Comm_Equipment__c = thn__Comm_Equipment__c;
    }

    public void setThn__Comm_Packages__c(String thn__Comm_Packages__c) {
        this.thn__Comm_Packages__c = thn__Comm_Packages__c;
    }

    public void setThn__Markup__c(boolean thn__Markup__c) {
        this.thn__Markup__c = thn__Markup__c;
    }

    public void setThn__UpdateFields__c(boolean thn__UpdateFields__c) {
        this.thn__UpdateFields__c = thn__UpdateFields__c;
    }

    public void setThn__Sync_Status__c(String thn__Sync_Status__c) {
        this.thn__Sync_Status__c = thn__Sync_Status__c;
    }

    public void setOrigin__c(String Origin__c) {
        this.Origin__c = Origin__c;
    }

    public void setType_other__c(String type_other__c) {
        this.type_other__c = type_other__c;
    }

    public void setThn__Copy_Billing_address__c(boolean thn__Copy_Billing_address__c) {
        this.thn__Copy_Billing_address__c = thn__Copy_Billing_address__c;
    }

    public void setThn__Corporate_Id__c(String thn__Corporate_Id__c) {
        this.thn__Corporate_Id__c = thn__Corporate_Id__c;
    }

    public void setThn__Email__c(String thn__Email__c) {
        this.thn__Email__c = thn__Email__c;
    }

    public void setThn__PrimaryCity__c(String thn__PrimaryCity__c) {
        this.thn__PrimaryCity__c = thn__PrimaryCity__c;
    }

    public void setThn__PrimaryCountryCode__c(String thn__PrimaryCountryCode__c) {
        this.thn__PrimaryCountryCode__c = thn__PrimaryCountryCode__c;
    }

    public void setThn__PrimaryCountry__c(String thn__PrimaryCountry__c) {
        this.thn__PrimaryCountry__c = thn__PrimaryCountry__c;
    }

    public void setThn__PrimaryPostalCode__c(String thn__PrimaryPostalCode__c) {
        this.thn__PrimaryPostalCode__c = thn__PrimaryPostalCode__c;
    }

    public void setThn__PrimaryState__c(String thn__PrimaryState__c) {
        this.thn__PrimaryState__c = thn__PrimaryState__c;
    }

    public void setThn__PrimaryStreet__c(String thn__PrimaryStreet__c) {
        this.thn__PrimaryStreet__c = thn__PrimaryStreet__c;
    }

    public void setThn__Send_To_Pms__c(boolean thn__Send_To_Pms__c) {
        this.thn__Send_To_Pms__c = thn__Send_To_Pms__c;
    }
    public class Attributes {
        private String type;
        private String url;


        // Getter Methods

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        // Setter Methods

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
