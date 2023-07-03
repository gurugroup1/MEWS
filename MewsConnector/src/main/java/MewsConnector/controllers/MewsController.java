package MewsConnector.controllers;

import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.*;
import MewsConnector.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
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

    public MewsBookerRequest createBookerPayload(SalesforceBookingResponse book ,SalesforceAccountResponse account,SalesforceContactResponse contact) throws JsonProcessingException {

        MewsBookerRequest mewsBookerRequest = new MewsBookerRequest();
        mewsBookerRequest.setClient(applicationConfiguration.getMewsClientName());
        mewsBookerRequest.setAccessToken(applicationConfiguration.getMewsAccessToken());
        mewsBookerRequest.setClientToken(applicationConfiguration.getMewsClientToken());
        mewsBookerRequest.setOverwriteExisting(false);
        mewsBookerRequest.setFirstName(contact.getFirstName());
        mewsBookerRequest.setLastName(contact.getLastName());
        mewsBookerRequest.setTitle(contact.getTitle());
        mewsBookerRequest.setNationalityCode(contact.getThn__Nationality__c());
        mewsBookerRequest.setBirthDate(contact.getBirthdate());
        mewsBookerRequest.setEmail(contact.getEmail());
//        mewsBookerRequest.setEmail("doe1@gmail.com");
        mewsBookerRequest.setPhone(contact.getPhone());
        mewsBookerRequest.setLoyaltyCode(contact.getLoyalty__c());

        MewsBookerRequest.Address address = new  MewsBookerRequest.Address();
        address.setCity(contact.getMailingCity());
        address.setCountryCode(contact.getMailingCountryCode());
        address.setCountryCode(contact.getMailingCountryCode());
        address.setPostalCode(contact.getMailingPostalCode());
        address.setLine1(contact.getMailingAddress());

        mewsBookerRequest.setAddress(address);

        return mewsBookerRequest;
    }

    public MewsAvailabilityBlockRequest createAvailabilityBlockPayload(SalesforceBookingResponse book,SalesforceRateResponse rate, SalesforcePropertyResponse property,MewsBookerResponse booker) throws JsonProcessingException {

        MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = new MewsAvailabilityBlockRequest();
        mewsAvailabilityBlockRequest.setClient(applicationConfiguration.getMewsClientName());
        mewsAvailabilityBlockRequest.setAccessToken(applicationConfiguration.getMewsAccessToken());
        mewsAvailabilityBlockRequest.setClientToken(applicationConfiguration.getMewsClientToken());
        MewsAvailabilityBlockRequest.AvailabilityBlock availabilityBlock = new MewsAvailabilityBlockRequest.AvailabilityBlock();
        MewsAvailabilityBlockRequest.AvailabilityBlock.Budget budget = new MewsAvailabilityBlockRequest.AvailabilityBlock.Budget();
        availabilityBlock.setBookerId(booker.getId());
        availabilityBlock.setRateId(rate.getThn__Mews_Id__c());
        availabilityBlock.setServiceId(property.getThn__Mews_Reservation_Service_Id__c());
        availabilityBlock.setFirstTimeUnitStartUtc("2023-07-20T00:00:00+2");
        availabilityBlock.setLastTimeUnitStartUtc("2023-07-20T00:00:00+2");
        availabilityBlock.setReleasedUtc("2023-07-20T00:00:00+2");
        availabilityBlock.setNotes(book.getQuote_Notes__c());
//        availabilityBlock.setState(book.getStatus__c());
        availabilityBlock.setState("Confirmed");

        budget.setValue((int) book.getThn__Package_Amount__c());
        budget.setCurrency(rate.getCurrencyIsoCode());
        availabilityBlock.setBudget(budget);

        // Set the availabilityBlock in the list
        List<MewsAvailabilityBlockRequest.AvailabilityBlock> availabilityBlocks = new ArrayList<>();
        availabilityBlocks.add(availabilityBlock);

        mewsAvailabilityBlockRequest.setAvailabilityBlocks(availabilityBlocks);
        return mewsAvailabilityBlockRequest;
    }

    public String addCompany(MewsCompanyRequest request) throws JsonProcessingException {
        return mewsConnectorService.pushCompanyToMews(request);
    }

    public String addBooker(MewsBookerRequest request) throws JsonProcessingException {
        return mewsConnectorService.pushBookerToMews(request);
    }

    public String addAvailabilityBlock(MewsAvailabilityBlockRequest request) throws JsonProcessingException {
        return mewsConnectorService.pushAvailabilityBlockerToMews(request);
    }
}