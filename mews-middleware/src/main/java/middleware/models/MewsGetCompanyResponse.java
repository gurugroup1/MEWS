package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class MewsGetCompanyResponse {
    @JsonProperty("Companies")
    private Company[] companies;

    @JsonProperty("Cursor")
    private String cursor;

    public Company[] getCompanies() {
        return companies;
    }

    public void setCompanies(Company[] companies) {
        this.companies = companies;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

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
        private boolean isActive;

        @JsonProperty("Notes")
        private String notes;

        @JsonProperty("Number")
        private Integer number;

        @JsonProperty("TaxIdentifier")
        private String taxIdentifier;

        @JsonProperty("Telephone")
        private String telephone;

        @JsonProperty("CreatedUtc")
        private LocalDateTime createdUtc;

        @JsonProperty("UpdatedUtc")
        private LocalDateTime updatedUtc;

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

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
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

        public LocalDateTime getCreatedUtc() {
            return createdUtc;
        }

        public void setCreatedUtc(LocalDateTime createdUtc) {
            this.createdUtc = createdUtc;
        }

        public LocalDateTime getUpdatedUtc() {
            return updatedUtc;
        }

        public void setUpdatedUtc(LocalDateTime updatedUtc) {
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

        public static class NchClassifications {
            @JsonProperty("Corporate")
            private boolean corporate;

            @JsonProperty("Internal")
            private boolean internal;

            @JsonProperty("Private")
            private boolean privateCompany;

            @JsonProperty("OnlineTravelAgency")
            private boolean onlineTravelAgency;

            @JsonProperty("GlobalDistributionSystem")
            private boolean globalDistributionSystem;

            @JsonProperty("Marketing")
            private boolean marketing;

            @JsonProperty("Inactive")
            private boolean inactive;

            public boolean isCorporate() {
                return corporate;
            }

            public void setCorporate(boolean corporate) {
                this.corporate = corporate;
            }

            public boolean isInternal() {
                return internal;
            }

            public void setInternal(boolean internal) {
                this.internal = internal;
            }

            public boolean isPrivateCompany() {
                return privateCompany;
            }

            public void setPrivateCompany(boolean privateCompany) {
                this.privateCompany = privateCompany;
            }

            public boolean isOnlineTravelAgency() {
                return onlineTravelAgency;
            }

            public void setOnlineTravelAgency(boolean onlineTravelAgency) {
                this.onlineTravelAgency = onlineTravelAgency;
            }

            public boolean isGlobalDistributionSystem() {
                return globalDistributionSystem;
            }

            public void setGlobalDistributionSystem(boolean globalDistributionSystem) {
                this.globalDistributionSystem = globalDistributionSystem;
            }

            public boolean isMarketing() {
                return marketing;
            }

            public void setMarketing(boolean marketing) {
                this.marketing = marketing;
            }

            public boolean isInactive() {
                return inactive;
            }

            public void setInactive(boolean inactive) {
                this.inactive = inactive;
            }
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
        }
    }
}
