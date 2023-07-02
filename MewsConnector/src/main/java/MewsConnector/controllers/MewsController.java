package MewsConnector.controllers;

import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.*;
import MewsConnector.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Objects;

public class MewsController {
    private ApplicationConfiguration applicationConfiguration;
    private final MewsConnectorService mewsConnectorService;
    @Autowired
    public MewsController(MewsConnectorService mewsConnectorService) {
        this.mewsConnectorService = Objects.requireNonNull(mewsConnectorService, "Salesforce connector service must not be null");
    }
    public MewsCompanyRequest createCompanyPayload(SalesforceBookingResponse book ,SalesforceAccountResponse account,SalesforceContactResponse contact) throws JsonProcessingException {

        MewsCompanyRequest mewsCompanyRequest = new MewsCompanyRequest();
        MewsCompanyRequest.Options options = new MewsCompanyRequest.Options();
        mewsCompanyRequest.setClient(applicationConfiguration.getMewsClientName());
        mewsCompanyRequest.setAccessToken(applicationConfiguration.getMewsAccessToken());
        mewsCompanyRequest.setClientToken(applicationConfiguration.getMewsClientToken());
        mewsCompanyRequest.setName(account.getName());

        options.setInvoiceable(true);
        options.setAddFeesToInvoices(false);
        mewsCompanyRequest.setOptions(options);

        mewsCompanyRequest.setMotherCompanyId(account.getParentId());
        mewsCompanyRequest.setIdentifier("");
        mewsCompanyRequest.setTaxIdentifier(account.getThn__TaxIdentifier__c());
        mewsCompanyRequest.setAdditionalTaxIdentifier(account.getThn__Additional_Tax_Identifier__c());
        mewsCompanyRequest.setBillingCode(account.getBillingAddress());
        mewsCompanyRequest.setAccountingCode(account.getThn__Accounting_Code__c());
        mewsCompanyRequest.setAddress(account.getShippingAddress());
        // mewsCompanyRequest.setInvoiceDueInterval("");
        mewsCompanyRequest.setTelephone(account.getPhone());
        mewsCompanyRequest.setContacPerson(contact.getFirstName());
        mewsCompanyRequest.setContact(contact.getEmail());
        mewsCompanyRequest.setNotes(book.getQuote_Notes__c());
        mewsCompanyRequest.setIata(account.getThn__IATA__c());
        mewsCompanyRequest.setDepartment(contact.getDepartment());
        mewsCompanyRequest.setDunsNumber("");
        mewsCompanyRequest.setExternalIdentifier("");
        mewsCompanyRequest.setReferenceIdentifier("");
        mewsCompanyRequest.setWebsiteUrl(account.getWebsite());

        return mewsCompanyRequest;
    }

    public String addCompany(MewsCompanyRequest request) throws JsonProcessingException {
        return mewsConnectorService.pushCompanyToMews(request);
    }
}