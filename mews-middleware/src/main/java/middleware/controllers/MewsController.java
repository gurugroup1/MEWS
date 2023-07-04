package middleware.controllers;

import middleware.configurations.ApplicationConfiguration;
import middleware.models.*;
import middleware.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
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
//        mewsBookerRequest.setEmail(contact.getEmail());
      mewsBookerRequest.setEmail("Doe009@gmail.com");
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
        availabilityBlock.setName("1234567");
        availabilityBlock.setServiceId(property.getThn__Mews_Reservation_Service_Id__c());
        availabilityBlock.setFirstTimeUnitStartUtc("2023-07-20T00:00:00+2");
        availabilityBlock.setLastTimeUnitStartUtc("2023-07-20T00:00:00+2");
        availabilityBlock.setReleasedUtc("2023-07-20T00:00:00+2");
        availabilityBlock.setNotes(book.getQuote_Notes__c());
//      availabilityBlock.setState(book.getStatus__c());
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

    public MewsUpdateAvailabilityRequest createUpdateAvailabilityPayload(SalesforceBookingResponse book,SalesforceRateResponse rate, SalesforcePropertyResponse property,MewsBookerResponse booker) throws JsonProcessingException {

        MewsUpdateAvailabilityRequest request = new MewsUpdateAvailabilityRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        request.setServiceId("2c65e490-8618-432e-b254-abd100d7ed6e");

        MewsUpdateAvailabilityRequest.AvailabilityUpdate availabilityUpdate1 = new MewsUpdateAvailabilityRequest.AvailabilityUpdate();
        availabilityUpdate1.setFirstTimeUnitStartUtc("2023-07-01T00:00:00+2");
        availabilityUpdate1.setLastTimeUnitStartUtc("2023-07-01T00:00:00+2");
        availabilityUpdate1.setAvailabilityBlockId("de3e2d8a-8c75-485d-9f70-b01a00eac151");
        availabilityUpdate1.setResourceCategoryId("11950924-ce98-40cb-80c2-abd100d7ede4");

        MewsUpdateAvailabilityRequest.UnitCountAdjustment unitCountAdjustment1 = new MewsUpdateAvailabilityRequest.UnitCountAdjustment();
        unitCountAdjustment1.setValue(-6);
        availabilityUpdate1.setUnitCountAdjustment(unitCountAdjustment1);

        request.getAvailabilityUpdates().add(availabilityUpdate1);

        return request;
    }

    public MewsUpdateRateRequest createUpdateRatePayload(SalesforceBookingResponse book,SalesforceRateResponse rate, SalesforcePropertyResponse property,MewsBookerResponse booker) throws JsonProcessingException {

        MewsUpdateRateRequest request = new MewsUpdateRateRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());

        request.setRateId("bd870c5b-25c6-44c6-9959-acc200fbbd7c");

        MewsUpdateRateRequest.PriceUpdate priceUpdate = new MewsUpdateRateRequest.PriceUpdate();
//        priceUpdate.setCategoryId("e3aa3117-dff0-46b7-b49a-2c0391e70ff9");
        priceUpdate.setFirstTimeUnitStartUtc("2024-01-04T23:00:00.000Z");
        priceUpdate.setLastTimeUnitStartUtc("2024-01-05T23:00:00.000Z");
        priceUpdate.setValue(222);

        request.getPriceUpdates().add(priceUpdate);

        return request;
    }

    public String addCompany(MewsCompanyRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request,"companies");
    }

    public String addBooker(MewsBookerRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request,"customers");
    }

    public String addAvailabilityBlock(MewsAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request,"availabilityBlocks");
    }

    public String updateAvailability(MewsUpdateAvailabilityRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"services/updateAvailability");
    }
    public String updateRate(MewsUpdateRateRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"rates/updatePrice");
    }

}