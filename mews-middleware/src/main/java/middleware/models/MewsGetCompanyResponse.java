package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MewsGetCompanyResponse {
    @JsonProperty("Companies")
    private List<Company> companies;

    @JsonProperty("Cursor")
    private String cursor;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    // Getters and Setters


public static class Company {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("ChainId")
    private String chainId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("MotherCompanyId")
    private String motherCompanyId;

    @JsonProperty("InvoicingEmail")
    private String invoicingEmail;

    @JsonProperty("WebsiteUrl")
    private String websiteUrl;

    @JsonProperty("InvoiceDueInterval")
    private Integer invoiceDueInterval;

    @JsonProperty("NchClassifications")
    private NchClassifications nchClassifications;

    @JsonProperty("Options")
    private Options options;

    @JsonProperty("CreditRating")
    private CreditRating creditRating;

    @JsonProperty("Department")
    private String department;

    @JsonProperty("DunsNumber")
    private String dunsNumber;

    @JsonProperty("ReferenceIdentifier")
    private String referenceIdentifier;

    @JsonProperty("AccountingCode")
    private String accountingCode;

    @JsonProperty("AdditionalTaxIdentifier")
    private String additionalTaxIdentifier;

    @JsonProperty("BillingCode")
    private String billingCode;

    @JsonProperty("Contact")
    private String contact;

    @JsonProperty("ContactPerson")
    private String contactPerson;

    @JsonProperty("ElectronicInvoiceIdentifier")
    private String electronicInvoiceIdentifier;

    @JsonProperty("Identifier")
    private String identifier;

    @JsonProperty("Iata")
    private String iata;

    @JsonProperty("IsActive")
    private Boolean isActive;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("Number")
    private Integer number;

    @JsonProperty("TaxIdentifier")
    private String taxIdentifier;

    @JsonProperty("Telephone")
    private String telephone;

    @JsonProperty("CreatedUtc")
    private String createdUtc;

    @JsonProperty("UpdatedUtc")
    private String updatedUtc;

    @JsonProperty("Address")
    private Address address;

    @JsonProperty("AddressId")
    private String addressId;

    @JsonProperty("TaxIdentificationNumber")
    private String taxIdentificationNumber;

    @JsonProperty("ExternalIdentifier")
    private String externalIdentifier;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotherCompanyId() {
        return motherCompanyId;
    }

    public void setMotherCompanyId(String motherCompanyId) {
        this.motherCompanyId = motherCompanyId;
    }

    public String getInvoicingEmail() {
        return invoicingEmail;
    }

    public void setInvoicingEmail(String invoicingEmail) {
        this.invoicingEmail = invoicingEmail;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Integer getInvoiceDueInterval() {
        return invoiceDueInterval;
    }

    public void setInvoiceDueInterval(Integer invoiceDueInterval) {
        this.invoiceDueInterval = invoiceDueInterval;
    }

    public NchClassifications getNchClassifications() {
        return nchClassifications;
    }

    public void setNchClassifications(NchClassifications nchClassifications) {
        this.nchClassifications = nchClassifications;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(CreditRating creditRating) {
        this.creditRating = creditRating;
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

    public String getReferenceIdentifier() {
        return referenceIdentifier;
    }

    public void setReferenceIdentifier(String referenceIdentifier) {
        this.referenceIdentifier = referenceIdentifier;
    }

    public String getAccountingCode() {
        return accountingCode;
    }

    public void setAccountingCode(String accountingCode) {
        this.accountingCode = accountingCode;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getElectronicInvoiceIdentifier() {
        return electronicInvoiceIdentifier;
    }

    public void setElectronicInvoiceIdentifier(String electronicInvoiceIdentifier) {
        this.electronicInvoiceIdentifier = electronicInvoiceIdentifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTaxIdentifier() {
        return taxIdentifier;
    }

    public void setTaxIdentifier(String taxIdentifier) {
        this.taxIdentifier = taxIdentifier;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    // Getters and Setters
}

    public static class  NchClassifications {
    @JsonProperty("Corporate")
    private Boolean corporate;

    @JsonProperty("Internal")
    private Boolean internal;

    @JsonProperty("Private")
    private Boolean privateClassification;

    @JsonProperty("OnlineTravelAgency")
    private Boolean onlineTravelAgency;

    @JsonProperty("GlobalDistributionSystem")
    private Boolean globalDistributionSystem;

    @JsonProperty("Marketing")
    private Boolean marketing;

    @JsonProperty("Inactive")
    private Boolean inactive;

        public Boolean getCorporate() {
            return corporate;
        }

        public void setCorporate(Boolean corporate) {
            this.corporate = corporate;
        }

        public Boolean getInternal() {
            return internal;
        }

        public void setInternal(Boolean internal) {
            this.internal = internal;
        }

        public Boolean getPrivateClassification() {
            return privateClassification;
        }

        public void setPrivateClassification(Boolean privateClassification) {
            this.privateClassification = privateClassification;
        }

        public Boolean getOnlineTravelAgency() {
            return onlineTravelAgency;
        }

        public void setOnlineTravelAgency(Boolean onlineTravelAgency) {
            this.onlineTravelAgency = onlineTravelAgency;
        }

        public Boolean getGlobalDistributionSystem() {
            return globalDistributionSystem;
        }

        public void setGlobalDistributionSystem(Boolean globalDistributionSystem) {
            this.globalDistributionSystem = globalDistributionSystem;
        }

        public Boolean getMarketing() {
            return marketing;
        }

        public void setMarketing(Boolean marketing) {
            this.marketing = marketing;
        }

        public Boolean getInactive() {
            return inactive;
        }

        public void setInactive(Boolean inactive) {
            this.inactive = inactive;
        }

        // Getters and Setters
}

        public static class Options {
    @JsonProperty("Invoiceable")
    private Boolean invoiceable;

    @JsonProperty("AddFeesToInvoices")
    private Boolean addFeesToInvoices;

    // Getters and Setters
}

            public static class CreditRating {
    @JsonProperty("Basic")
    private String basic;

    // Getters and Setters
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

    // Getters and Setters
}
}