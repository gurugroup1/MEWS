package MewsConnector.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MewsCompanyRequest {
    private String Client;
    private String AccessToken;
    private String ClientToken;
    private String Name;
    Options OptionsObject;
    private String MotherCompanyId = null;
    private String Identifier = null;
    private String TaxIdentifier = null;
    private String AdditionalTaxIdentifier = null;
    private String BillingCode = null;
    private String AccountingCode = null;
    private String Address = null;
    private String InvoiceDueInterval;
    private String Telephone;
    private String ContacPerson;
    private String Contact;
    private String Notes;
    private String Iata;
    private String Department;
    private String DunsNumber;
    CreditRating CreditRatingObject;
    private String ExternalIdentifier;
    private String ReferenceIdentifier;
    private String WebsiteUrl;


    // Getter Methods

    public String getClient() {
        return Client;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public String getClientToken() {
        return ClientToken;
    }

    public String getName() {
        return Name;
    }

    public Options getOptions() {
        return OptionsObject;
    }

    public String getMotherCompanyId() {
        return MotherCompanyId;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public String getTaxIdentifier() {
        return TaxIdentifier;
    }

    public String getAdditionalTaxIdentifier() {
        return AdditionalTaxIdentifier;
    }

    public String getBillingCode() {
        return BillingCode;
    }

    public String getAccountingCode() {
        return AccountingCode;
    }

    public String getAddress() {
        return Address;
    }

    public String getInvoiceDueInterval() {
        return InvoiceDueInterval;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getContacPerson() {
        return ContacPerson;
    }

    public String getContact() {
        return Contact;
    }

    public String getNotes() {
        return Notes;
    }

    public String getIata() {
        return Iata;
    }

    public String getDepartment() {
        return Department;
    }

    public String getDunsNumber() {
        return DunsNumber;
    }

    public CreditRating getCreditRating() {
        return CreditRatingObject;
    }

    public String getExternalIdentifier() {
        return ExternalIdentifier;
    }

    public String getReferenceIdentifier() {
        return ReferenceIdentifier;
    }

    public String getWebsiteUrl() {
        return WebsiteUrl;
    }

    // Setter Methods

    public void setClient(String Client) {
        this.Client = Client;
    }

    public void setAccessToken(String AccessToken) {
        this.AccessToken = AccessToken;
    }

    public void setClientToken(String ClientToken) {
        this.ClientToken = ClientToken;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setOptions(Options OptionsObject) {
        this.OptionsObject = OptionsObject;
    }

    public void setMotherCompanyId(String MotherCompanyId) {
        this.MotherCompanyId = MotherCompanyId;
    }

    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public void setTaxIdentifier(String TaxIdentifier) {
        this.TaxIdentifier = TaxIdentifier;
    }

    public void setAdditionalTaxIdentifier(String AdditionalTaxIdentifier) {
        this.AdditionalTaxIdentifier = AdditionalTaxIdentifier;
    }

    public void setBillingCode(String BillingCode) {
        this.BillingCode = BillingCode;
    }

    public void setAccountingCode(String AccountingCode) {
        this.AccountingCode = AccountingCode;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setInvoiceDueInterval(String InvoiceDueInterval) {
        this.InvoiceDueInterval = InvoiceDueInterval;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public void setContacPerson(String ContacPerson) {
        this.ContacPerson = ContacPerson;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public void setIata(String Iata) {
        this.Iata = Iata;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setDunsNumber(String DunsNumber) {
        this.DunsNumber = DunsNumber;
    }

    public void setCreditRating(CreditRating CreditRatingObject) {
        this.CreditRatingObject = CreditRatingObject;
    }

    public void setExternalIdentifier(String ExternalIdentifier) {
        this.ExternalIdentifier = ExternalIdentifier;
    }

    public void setReferenceIdentifier(String ReferenceIdentifier) {
        this.ReferenceIdentifier = ReferenceIdentifier;
    }

    public void setWebsiteUrl(String WebsiteUrl) {
        this.WebsiteUrl = WebsiteUrl;
    }
    public class CreditRating {
        private String Basic;


        // Getter Methods

        public String getBasic() {
            return Basic;
        }

        // Setter Methods

        public void setBasic(String Basic) {
            this.Basic = Basic;
        }
    }
    public static class Options {
        private boolean Invoiceable;
        private boolean AddFeesToInvoices;


        // Getter Methods

        public boolean getInvoiceable() {
            return Invoiceable;
        }

        public boolean getAddFeesToInvoices() {
            return AddFeesToInvoices;
        }

        // Setter Methods

        public void setInvoiceable(boolean Invoiceable) {
            this.Invoiceable = Invoiceable;
        }

        public void setAddFeesToInvoices(boolean AddFeesToInvoices) {
            this.AddFeesToInvoices = AddFeesToInvoices;
        }
    }
}
