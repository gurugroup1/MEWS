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
    private String name;

    @JsonProperty("Options")
    private Options options;

    @JsonProperty("MotherCompanyId")
    private String motherCompanyId;

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
    private String invoiceDueInterval;

    @JsonProperty("ContactPerson")
    private String contactPerson;

    @JsonProperty("Contact")
    private String contact;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("Iata")
    private String iata;

    @JsonProperty("Department")
    private String department;

    @JsonProperty("DunsNumber")
    private String dunsNumber;

    @JsonProperty("CreditRating")
    private CreditRating creditRating;

    @JsonProperty("ExternalIdentifier")
    private String externalIdentifier;

    @JsonProperty("ReferenceIdentifier")
    private String referenceIdentifier;

    @JsonProperty("WebsiteUrl")
    private String websiteUrl;

    // Getters and setters for the fields

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getMotherCompanyId() {
        return motherCompanyId;
    }

    public void setMotherCompanyId(String motherCompanyId) {
        this.motherCompanyId = motherCompanyId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String setIdentifier(String identifier) {
        return identifier;
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

    public String getInvoiceDueInterval() {
        return invoiceDueInterval;
    }

    public void setInvoiceDueInterval(String invoiceDueInterval) {
        this.invoiceDueInterval = invoiceDueInterval;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDunsNumber() {
        return dunsNumber;
    }

    public void setDunsNumber(String dunsNumber) {
        this.dunsNumber = dunsNumber;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(CreditRating creditRating) {
        this.creditRating = creditRating;
    }

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    public String getReferenceIdentifier() {
        return referenceIdentifier;
    }

    public void setReferenceIdentifier(String referenceIdentifier) {
        this.referenceIdentifier = referenceIdentifier;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public static class Options {
        @JsonProperty("Invoiceable")
        private boolean invoiceable;

        @JsonProperty("AddFeesToInvoices")
        private boolean addFeesToInvoices;

        public boolean isInvoiceable() {
            return invoiceable;
        }

        public void setInvoiceable(boolean invoiceable) {
            this.invoiceable = invoiceable;
        }

        public boolean isAddFeesToInvoices() {
            return addFeesToInvoices;
        }

        public void setAddFeesToInvoices(boolean addFeesToInvoices) {
            this.addFeesToInvoices = addFeesToInvoices;
        }
    }

    public static class CreditRating {
        @JsonProperty("Basic")
        private String basic;

        public String getBasic() {
            return basic;
        }

        public void setBasic(String basic) {
            this.basic = basic;
        }
    }
}
