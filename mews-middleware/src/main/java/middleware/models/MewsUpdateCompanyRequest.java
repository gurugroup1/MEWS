package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MewsUpdateCompanyRequest {
    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Client")
    private String client;

    @JsonProperty("ChainId")
    private String chainId;

    @JsonProperty("CompanyId")
    private String companyId;

    @JsonProperty("Name")
    private NameModel name;

    @JsonProperty("Options")
    private OptionsModel options;

    @JsonProperty("MotherCompanyId")
    private MotherCompanyIdModel motherCompanyId;

    @JsonProperty("Identifier")
    private String identifier;

    @JsonProperty("TaxIdentifier")
    private String taxIdentifier;

    @JsonProperty("AdditionalTaxIdentifier")
    private String additionalTaxIdentifier;

    @JsonProperty("BillingCode")
    private String billingCode;

    @JsonProperty("AccountingCode")
    private String accountingCode;

    @JsonProperty("InvoiceDueInterval")
    private InvoiceDueIntervalModel invoiceDueInterval;

    @JsonProperty("ContactPerson")
    private ContactPersonModel contactPerson;

    @JsonProperty("Contact")
    private ContactModel contact;

    @JsonProperty("Notes")
    private NotesModel notes;

    @JsonProperty("Iata")
    private IataModel iata;

    @JsonProperty("Department")
    private DepartmentModel department;

    @JsonProperty("DunsNumber")
    private DunsNumberModel dunsNumber;

    @JsonProperty("CreditRating")
    private CreditRatingModel creditRating;

    @JsonProperty("ExternalIdentifier")
    private ExternalIdentifierModel externalIdentifier;

    @JsonProperty("ReferenceIdentifier")
    private ReferenceIdentifierModel referenceIdentifier;

    @JsonProperty("WebsiteUrl")
    private WebsiteUrlModel websiteUrl;

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

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public NameModel getName() {
        return name;
    }

    public void setName(NameModel name) {
        this.name = name;
    }

    public OptionsModel getOptions() {
        return options;
    }

    public void setOptions(OptionsModel options) {
        this.options = options;
    }

    public MotherCompanyIdModel getMotherCompanyId() {
        return motherCompanyId;
    }

    public void setMotherCompanyId(MotherCompanyIdModel motherCompanyId) {
        this.motherCompanyId = motherCompanyId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTaxIdentifier() {
        return taxIdentifier;
    }

    public void setTaxIdentifier(String taxIdentifier) {
        this.taxIdentifier = taxIdentifier;
    }

    public String getAdditionalTaxIdentifier() {
        return additionalTaxIdentifier;
    }

    public void setAdditionalTaxIdentifier(String additionalTaxIdentifier) {
        this.additionalTaxIdentifier = additionalTaxIdentifier;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getAccountingCode() {
        return accountingCode;
    }

    public void setAccountingCode(String accountingCode) {
        this.accountingCode = accountingCode;
    }

    public InvoiceDueIntervalModel getInvoiceDueInterval() {
        return invoiceDueInterval;
    }

    public void setInvoiceDueInterval(InvoiceDueIntervalModel invoiceDueInterval) {
        this.invoiceDueInterval = invoiceDueInterval;
    }

    public ContactPersonModel getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPersonModel contactPerson) {
        this.contactPerson = contactPerson;
    }

    public ContactModel getContact() {
        return contact;
    }

    public void setContact(ContactModel contact) {
        this.contact = contact;
    }

    public NotesModel getNotes() {
        return notes;
    }

    public void setNotes(NotesModel notes) {
        this.notes = notes;
    }

    public IataModel getIata() {
        return iata;
    }

    public void setIata(IataModel iata) {
        this.iata = iata;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public DunsNumberModel getDunsNumber() {
        return dunsNumber;
    }

    public void setDunsNumber(DunsNumberModel dunsNumber) {
        this.dunsNumber = dunsNumber;
    }

    public CreditRatingModel getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(CreditRatingModel creditRating) {
        this.creditRating = creditRating;
    }

    public ExternalIdentifierModel getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(ExternalIdentifierModel externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    public ReferenceIdentifierModel getReferenceIdentifier() {
        return referenceIdentifier;
    }

    public void setReferenceIdentifier(ReferenceIdentifierModel referenceIdentifier) {
        this.referenceIdentifier = referenceIdentifier;
    }

    public WebsiteUrlModel getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(WebsiteUrlModel websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public static class NameModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        // Add getters and setters
    }

    public static class OptionsModel {
        @JsonProperty("Invoiceable")
        private InvoiceableModel invoiceable;

        @JsonProperty("AddFeesToInvoices")
        private AddFeesToInvoicesModel addFeesToInvoices;

        public InvoiceableModel getInvoiceable() {
            return invoiceable;
        }

        public void setInvoiceable(InvoiceableModel invoiceable) {
            this.invoiceable = invoiceable;
        }

        public AddFeesToInvoicesModel getAddFeesToInvoices() {
            return addFeesToInvoices;
        }

        public void setAddFeesToInvoices(AddFeesToInvoicesModel addFeesToInvoices) {
            this.addFeesToInvoices = addFeesToInvoices;
        }
    }

    public static class InvoiceableModel {
        @JsonProperty("Value")
        private boolean value;

        public boolean isValue() {
            return value;
        }

        public void setValue(boolean value) {
            this.value = value;
        }
    }

    public static class AddFeesToInvoicesModel {
        @JsonProperty("Value")
        private boolean value;

        public boolean isValue() {
            return value;
        }

        public void setValue(boolean value) {
            this.value = value;
        }
    }

    public static class MotherCompanyIdModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class InvoiceDueIntervalModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ContactPersonModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ContactModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class NotesModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class IataModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class DepartmentModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class DunsNumberModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class CreditRatingModel {
        @JsonProperty("Basic")
        private BasicModel basic;

        public BasicModel getBasic() {
            return basic;
        }

        public void setBasic(BasicModel basic) {
            this.basic = basic;
        }
    }

    public static class BasicModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ExternalIdentifierModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ReferenceIdentifierModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class WebsiteUrlModel {
        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
