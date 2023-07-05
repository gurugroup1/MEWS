package middleware.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceContactResponse {
    @JsonProperty("Attributes")
    private Attributes AttributesObject;

    @JsonProperty("Id")
    private String Id;

    @JsonProperty("IsDeleted")
    private boolean IsDeleted;

    @JsonProperty("MasterRecordId")
    private String MasterRecordId = null;

    @JsonProperty("AccountId")
    private String AccountId;

    @JsonProperty("LastName")
    private String LastName;

    @JsonProperty("FirstName")
    private String FirstName = null;

    @JsonProperty("Salutation")
    private String Salutation = null;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("OtherStreet")
    private String OtherStreet = null;

    @JsonProperty("OtherCity")
    private String OtherCity = null;

    @JsonProperty("OtherState")
    private String OtherState = null;

    @JsonProperty("OtherPostalCode")
    private String OtherPostalCode = null;

    @JsonProperty("OtherCountry")
    private String OtherCountry = null;

    @JsonProperty("OtherStateCode")
    private String OtherStateCode = null;

    @JsonProperty("OtherCountryCode")
    private String OtherCountryCode = null;

    @JsonProperty("OtherLatitude")
    private String OtherLatitude = null;

    @JsonProperty("OtherLongitude")
    private String OtherLongitude = null;

    @JsonProperty("OtherGeocodeAccuracy")
    private String OtherGeocodeAccuracy = null;

    @JsonProperty("OtherAddress")
    private String OtherAddress = null;

    @JsonProperty("MailingStreet")
    private String MailingStreet = null;

    @JsonProperty("MailingCity")
    private String MailingCity = null;

    @JsonProperty("MailingState")
    private String MailingState = null;

    @JsonProperty("MailingPostalCode")
    private String MailingPostalCode = null;

    @JsonProperty("MailingCountry")
    private String MailingCountry = null;

    @JsonProperty("MailingStateCode")
    private String MailingStateCode = null;

    @JsonProperty("MailingCountryCode")
    private String MailingCountryCode = null;

    @JsonProperty("MailingLatitude")
    private String MailingLatitude = null;

    @JsonProperty("MailingLongitude")
    private String MailingLongitude = null;

    @JsonProperty("MailingGeocodeAccuracy")
    private String MailingGeocodeAccuracy = null;

    @JsonProperty("MailingAddress")
    private String MailingAddress = null;

    @JsonProperty("Phone")
    private String Phone = null;

    @JsonProperty("Fax")
    private String Fax = null;

    @JsonProperty("MobilePhone")
    private String MobilePhone = null;

    @JsonProperty("HomePhone")
    private String HomePhone = null;

    @JsonProperty("OtherPhone")
    private String OtherPhone = null;

    @JsonProperty("AssistantPhone")
    private String AssistantPhone = null;

    @JsonProperty("ReportsToId")
    private String ReportsToId = null;

    @JsonProperty("Email")
    private String Email;

    @JsonProperty("Title")
    private String Title = null;

    @JsonProperty("Department")
    private String Department = null;

    @JsonProperty("AssistantName")
    private String AssistantName = null;

    @JsonProperty("LeadSource")
    private String LeadSource = null;

    @JsonProperty("Birthdate")
    private String Birthdate = null;

    @JsonProperty("Description")
    private String Description = null;

    @JsonProperty("CurrencyIsoCode")
    private String CurrencyIsoCode;

    @JsonProperty("OwnerId")
    private String OwnerId;

    @JsonProperty("CreatedDate")
    private String CreatedDate;

    @JsonProperty("CreatedById")
    private String CreatedById;

    @JsonProperty("LastModifiedDate")
    private String LastModifiedDate;

    @JsonProperty("LastModifiedById")
    private String LastModifiedById;

    @JsonProperty("SystemModstamp")
    private String SystemModstamp;

    @JsonProperty("LastActivityDate")
    private String LastActivityDate = null;

    @JsonProperty("LastCURequestDate")
    private String LastCURequestDate = null;

    @JsonProperty("LastCUUpdateDate")
    private String LastCUUpdateDate = null;

    @JsonProperty("LastViewedDate")
    private String LastViewedDate;

    @JsonProperty("LastReferencedDate")
    private String LastReferencedDate;

    @JsonProperty("EmailBouncedReason")
    private String EmailBouncedReason = null;

    @JsonProperty("EmailBouncedDate")
    private String EmailBouncedDate = null;

    @JsonProperty("IsEmailBounced")
    private boolean IsEmailBounced;

    @JsonProperty("PhotoUrl")
    private String PhotoUrl;

    @JsonProperty("Jigsaw")
    private String Jigsaw = null;

    @JsonProperty("JigsawContactId")
    private String JigsawContactId = null;

    @JsonProperty("IndividualId")
    private String IndividualId = null;

    @JsonProperty("thn__Create_Guest__c")
    private boolean thn__Create_Guest__c;

    @JsonProperty("thn__Guest__c")
    private String thn__Guest__c;

    @JsonProperty("thn__Hotel__c")
    private String thn__Hotel__c;

    @JsonProperty("thn__Contact_ID__c")
    private String thn__Contact_ID__c;

    @JsonProperty("Contact_Number__c")
    private String Contact_Number__c;

    @JsonProperty("Invite_to_client_event__c")
    private boolean Invite_to_client_event__c;

    @JsonProperty("Type__c")
    private String Type__c;

    @JsonProperty("Loyalty__c")
    private String Loyalty__c = null;

    @JsonProperty("LinkedIn__c")
    private String LinkedIn__c = null;

    @JsonProperty("thn__Language__c")
    private String thn__Language__c = null;

    @JsonProperty("thn__Nationality__c")
    private String thn__Nationality__c = null;

    @JsonProperty("thn__UpdateFromGuest__c")
    private boolean thn__UpdateFromGuest__c;

    @JsonProperty("thn__Is_Active__c")
    private boolean thn__Is_Active__c;

    @JsonProperty("thn__Inactive_Reason__c")
    private String thn__Inactive_Reason__c = null;

    @JsonProperty("thn__Send_To_Pms__c")
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

    public String getAccountId() {
        return AccountId;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSalutation() {
        return Salutation;
    }

    public String getName() {
        return Name;
    }

    public String getOtherStreet() {
        return OtherStreet;
    }

    public String getOtherCity() {
        return OtherCity;
    }

    public String getOtherState() {
        return OtherState;
    }

    public String getOtherPostalCode() {
        return OtherPostalCode;
    }

    public String getOtherCountry() {
        return OtherCountry;
    }

    public String getOtherStateCode() {
        return OtherStateCode;
    }

    public String getOtherCountryCode() {
        return OtherCountryCode;
    }

    public String getOtherLatitude() {
        return OtherLatitude;
    }

    public String getOtherLongitude() {
        return OtherLongitude;
    }

    public String getOtherGeocodeAccuracy() {
        return OtherGeocodeAccuracy;
    }

    public String getOtherAddress() {
        return OtherAddress;
    }

    public String getMailingStreet() {
        return MailingStreet;
    }

    public String getMailingCity() {
        return MailingCity;
    }

    public String getMailingState() {
        return MailingState;
    }

    public String getMailingPostalCode() {
        return MailingPostalCode;
    }

    public String getMailingCountry() {
        return MailingCountry;
    }

    public String getMailingStateCode() {
        return MailingStateCode;
    }

    public String getMailingCountryCode() {
        return MailingCountryCode;
    }

    public String getMailingLatitude() {
        return MailingLatitude;
    }

    public String getMailingLongitude() {
        return MailingLongitude;
    }

    public String getMailingGeocodeAccuracy() {
        return MailingGeocodeAccuracy;
    }

    public String getMailingAddress() {
        return MailingAddress;
    }

    public String getPhone() {
        return Phone;
    }

    public String getFax() {
        return Fax;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public String getOtherPhone() {
        return OtherPhone;
    }

    public String getAssistantPhone() {
        return AssistantPhone;
    }

    public String getReportsToId() {
        return ReportsToId;
    }

    public String getEmail() {
        return Email;
    }

    public String getTitle() {
        return Title;
    }

    public String getDepartment() {
        return Department;
    }

    public String getAssistantName() {
        return AssistantName;
    }

    public String getLeadSource() {
        return LeadSource;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public String getDescription() {
        return Description;
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

    public String getLastCURequestDate() {
        return LastCURequestDate;
    }

    public String getLastCUUpdateDate() {
        return LastCUUpdateDate;
    }

    public String getLastViewedDate() {
        return LastViewedDate;
    }

    public String getLastReferencedDate() {
        return LastReferencedDate;
    }

    public String getEmailBouncedReason() {
        return EmailBouncedReason;
    }

    public String getEmailBouncedDate() {
        return EmailBouncedDate;
    }

    public boolean getIsEmailBounced() {
        return IsEmailBounced;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public String getJigsaw() {
        return Jigsaw;
    }

    public String getJigsawContactId() {
        return JigsawContactId;
    }

    public String getIndividualId() {
        return IndividualId;
    }

    public boolean getThn__Create_Guest__c() {
        return thn__Create_Guest__c;
    }

    public String getThn__Guest__c() {
        return thn__Guest__c;
    }

    public String getThn__Hotel__c() {
        return thn__Hotel__c;
    }

    public String getThn__Contact_ID__c() {
        return thn__Contact_ID__c;
    }

    public String getContact_Number__c() {
        return Contact_Number__c;
    }

    public boolean getInvite_to_client_event__c() {
        return Invite_to_client_event__c;
    }

    public String getType__c() {
        return Type__c;
    }

    public String getLoyalty__c() {
        return Loyalty__c;
    }

    public String getLinkedIn__c() {
        return LinkedIn__c;
    }

    public String getThn__Language__c() {
        return thn__Language__c;
    }

    public String getThn__Nationality__c() {
        return thn__Nationality__c;
    }

    public boolean getThn__UpdateFromGuest__c() {
        return thn__UpdateFromGuest__c;
    }

    public boolean getThn__Is_Active__c() {
        return thn__Is_Active__c;
    }

    public String getThn__Inactive_Reason__c() {
        return thn__Inactive_Reason__c;
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

    public void setAccountId(String AccountId) {
        this.AccountId = AccountId;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setSalutation(String Salutation) {
        this.Salutation = Salutation;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setOtherStreet(String OtherStreet) {
        this.OtherStreet = OtherStreet;
    }

    public void setOtherCity(String OtherCity) {
        this.OtherCity = OtherCity;
    }

    public void setOtherState(String OtherState) {
        this.OtherState = OtherState;
    }

    public void setOtherPostalCode(String OtherPostalCode) {
        this.OtherPostalCode = OtherPostalCode;
    }

    public void setOtherCountry(String OtherCountry) {
        this.OtherCountry = OtherCountry;
    }

    public void setOtherStateCode(String OtherStateCode) {
        this.OtherStateCode = OtherStateCode;
    }

    public void setOtherCountryCode(String OtherCountryCode) {
        this.OtherCountryCode = OtherCountryCode;
    }

    public void setOtherLatitude(String OtherLatitude) {
        this.OtherLatitude = OtherLatitude;
    }

    public void setOtherLongitude(String OtherLongitude) {
        this.OtherLongitude = OtherLongitude;
    }

    public void setOtherGeocodeAccuracy(String OtherGeocodeAccuracy) {
        this.OtherGeocodeAccuracy = OtherGeocodeAccuracy;
    }

    public void setOtherAddress(String OtherAddress) {
        this.OtherAddress = OtherAddress;
    }

    public void setMailingStreet(String MailingStreet) {
        this.MailingStreet = MailingStreet;
    }

    public void setMailingCity(String MailingCity) {
        this.MailingCity = MailingCity;
    }

    public void setMailingState(String MailingState) {
        this.MailingState = MailingState;
    }

    public void setMailingPostalCode(String MailingPostalCode) {
        this.MailingPostalCode = MailingPostalCode;
    }

    public void setMailingCountry(String MailingCountry) {
        this.MailingCountry = MailingCountry;
    }

    public void setMailingStateCode(String MailingStateCode) {
        this.MailingStateCode = MailingStateCode;
    }

    public void setMailingCountryCode(String MailingCountryCode) {
        this.MailingCountryCode = MailingCountryCode;
    }

    public void setMailingLatitude(String MailingLatitude) {
        this.MailingLatitude = MailingLatitude;
    }

    public void setMailingLongitude(String MailingLongitude) {
        this.MailingLongitude = MailingLongitude;
    }

    public void setMailingGeocodeAccuracy(String MailingGeocodeAccuracy) {
        this.MailingGeocodeAccuracy = MailingGeocodeAccuracy;
    }

    public void setMailingAddress(String MailingAddress) {
        this.MailingAddress = MailingAddress;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public void setMobilePhone(String MobilePhone) {
        this.MobilePhone = MobilePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public void setOtherPhone(String OtherPhone) {
        this.OtherPhone = OtherPhone;
    }

    public void setAssistantPhone(String AssistantPhone) {
        this.AssistantPhone = AssistantPhone;
    }

    public void setReportsToId(String ReportsToId) {
        this.ReportsToId = ReportsToId;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setAssistantName(String AssistantName) {
        this.AssistantName = AssistantName;
    }

    public void setLeadSource(String LeadSource) {
        this.LeadSource = LeadSource;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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

    public void setLastCURequestDate(String LastCURequestDate) {
        this.LastCURequestDate = LastCURequestDate;
    }

    public void setLastCUUpdateDate(String LastCUUpdateDate) {
        this.LastCUUpdateDate = LastCUUpdateDate;
    }

    public void setLastViewedDate(String LastViewedDate) {
        this.LastViewedDate = LastViewedDate;
    }

    public void setLastReferencedDate(String LastReferencedDate) {
        this.LastReferencedDate = LastReferencedDate;
    }

    public void setEmailBouncedReason(String EmailBouncedReason) {
        this.EmailBouncedReason = EmailBouncedReason;
    }

    public void setEmailBouncedDate(String EmailBouncedDate) {
        this.EmailBouncedDate = EmailBouncedDate;
    }

    public void setIsEmailBounced(boolean IsEmailBounced) {
        this.IsEmailBounced = IsEmailBounced;
    }

    public void setPhotoUrl(String PhotoUrl) {
        this.PhotoUrl = PhotoUrl;
    }

    public void setJigsaw(String Jigsaw) {
        this.Jigsaw = Jigsaw;
    }

    public void setJigsawContactId(String JigsawContactId) {
        this.JigsawContactId = JigsawContactId;
    }

    public void setIndividualId(String IndividualId) {
        this.IndividualId = IndividualId;
    }

    public void setThn__Create_Guest__c(boolean thn__Create_Guest__c) {
        this.thn__Create_Guest__c = thn__Create_Guest__c;
    }

    public void setThn__Guest__c(String thn__Guest__c) {
        this.thn__Guest__c = thn__Guest__c;
    }

    public void setThn__Hotel__c(String thn__Hotel__c) {
        this.thn__Hotel__c = thn__Hotel__c;
    }

    public void setThn__Contact_ID__c(String thn__Contact_ID__c) {
        this.thn__Contact_ID__c = thn__Contact_ID__c;
    }

    public void setContact_Number__c(String Contact_Number__c) {
        this.Contact_Number__c = Contact_Number__c;
    }

    public void setInvite_to_client_event__c(boolean Invite_to_client_event__c) {
        this.Invite_to_client_event__c = Invite_to_client_event__c;
    }

    public void setType__c(String Type__c) {
        this.Type__c = Type__c;
    }

    public void setLoyalty__c(String Loyalty__c) {
        this.Loyalty__c = Loyalty__c;
    }

    public void setLinkedIn__c(String LinkedIn__c) {
        this.LinkedIn__c = LinkedIn__c;
    }

    public void setThn__Language__c(String thn__Language__c) {
        this.thn__Language__c = thn__Language__c;
    }

    public void setThn__Nationality__c(String thn__Nationality__c) {
        this.thn__Nationality__c = thn__Nationality__c;
    }

    public void setThn__UpdateFromGuest__c(boolean thn__UpdateFromGuest__c) {
        this.thn__UpdateFromGuest__c = thn__UpdateFromGuest__c;
    }

    public void setThn__Is_Active__c(boolean thn__Is_Active__c) {
        this.thn__Is_Active__c = thn__Is_Active__c;
    }

    public void setThn__Inactive_Reason__c(String thn__Inactive_Reason__c) {
        this.thn__Inactive_Reason__c = thn__Inactive_Reason__c;
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
