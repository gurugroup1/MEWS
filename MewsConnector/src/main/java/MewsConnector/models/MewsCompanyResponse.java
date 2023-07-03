package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MewsCompanyResponse {
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

    // Add getters and setters here


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
    private NchClassification nchClassifications;

    @JsonProperty("Options")
    private Option options;

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

    // Add getters and setters here
}

public static class NchClassification {
    @JsonProperty("Corporate")
    private Boolean corporate;

    @JsonProperty("Internal")
    private Boolean internal;

    @JsonProperty("Private")
    private Boolean privateCompany;

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

    public Boolean getPrivateCompany() {
        return privateCompany;
    }

    public void setPrivateCompany(Boolean privateCompany) {
        this.privateCompany = privateCompany;
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

    // Add getters and setters here
}

public static class Option {
    @JsonProperty("Invoiceable")
    private Boolean invoiceable;

    @JsonProperty("AddFeesToInvoices")
    private Boolean addFeesToInvoices;

    public Boolean getInvoiceable() {
        return invoiceable;
    }

    public void setInvoiceable(Boolean invoiceable) {
        this.invoiceable = invoiceable;
    }

    public Boolean getAddFeesToInvoices() {
        return addFeesToInvoices;
    }

    public void setAddFeesToInvoices(Boolean addFeesToInvoices) {
        this.addFeesToInvoices = addFeesToInvoices;
    }

    // Add getters and setters here
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

    // Add getters and setters here
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

    // Add getters and setters here
}
}