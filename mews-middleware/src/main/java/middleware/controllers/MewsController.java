package middleware.controllers;

import middleware.configurations.ApplicationConfiguration;
import middleware.models.*;
import middleware.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MewsController {

    private ApplicationConfiguration applicationConfiguration;
    private final MewsConnectorService mewsConnectorService;
    @Autowired
    public MewsController(MewsConnectorService mewsConnectorService,ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
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

    public MewsGetBookerRequest createGetBookerPayload(SalesforceAccountResponse account,SalesforceContactResponse contact) throws JsonProcessingException {

        MewsGetBookerRequest request = new MewsGetBookerRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        List<String> email = new ArrayList<>();
        email.add(contact.getEmail());
        request.setEmail(email);

        MewsGetBookerRequest.Limitation limitation = new MewsGetBookerRequest.Limitation();
        limitation.setCount(10);
        request.setLimitation(limitation);

        return request;
    }
    public MewsUpdateBookerRequest createUpdateBookerPayload(SalesforceAccountResponse account,SalesforceContactResponse contact,MewsGetBookerResponse getbooker) throws JsonProcessingException {

        MewsUpdateBookerRequest request = new MewsUpdateBookerRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());

        MewsGetBookerResponse.Customer customer = getbooker.getCustomers()[0];

        request.setCustomerId(customer.getId());

        return request;
    }

    public MewsUpdateAvailabilityBlockRequest createUpdateAvailabilityBlockPayload(SalesforceAccountResponse account,SalesforceContactResponse contact,MewsGetAvailabilityBlockResponse getAvailabilityBlockId) throws JsonProcessingException {

        MewsUpdateAvailabilityBlockRequest request = new MewsUpdateAvailabilityBlockRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());

        MewsGetAvailabilityBlockResponse.AvailabilityBlock availabilityBlock = getAvailabilityBlockId.getAvailabilityBlocks()[0];
        List<MewsUpdateAvailabilityBlockRequest.AvailabilityBlock> availabilityBlocks = new ArrayList<>();
        // Create a new AvailabilityBlock object and set the ID
        MewsUpdateAvailabilityBlockRequest.AvailabilityBlock block = new MewsUpdateAvailabilityBlockRequest.AvailabilityBlock();
        block.setAvailabilityBlockId(availabilityBlock.getId());

        // Add the availability block to the list
        availabilityBlocks.add(block);

        // Set the availability blocks in the request
        request.setAvailabilityBlocks(availabilityBlocks);
        return request;
    }
    public MewsGetAvailabilityBlockRequest createGetAvailabilityBlockPayload(SalesforceAccountResponse account,SalesforceContactResponse contact) throws JsonProcessingException {

        MewsGetAvailabilityBlockRequest request = new MewsGetAvailabilityBlockRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());

        MewsGetAvailabilityBlockRequest.CreatedUtc createdUtc = new MewsGetAvailabilityBlockRequest.CreatedUtc();
        createdUtc.setStartUtc("2023-07-11T00:00:00Z");
        createdUtc.setEndUtc("2023-07-12T00:00:00Z");
        request.setCreatedUtc(createdUtc);

        MewsGetAvailabilityBlockRequest.Extent extent = new MewsGetAvailabilityBlockRequest.Extent();
        extent.setAdjustments(true);
        extent.setRates(false);
        extent.setServiceOrders(false);
        extent.setAvailabilityBlocks(true);
        request.setExtent(extent);


        MewsGetAvailabilityBlockRequest.Limitation limitation = new MewsGetAvailabilityBlockRequest.Limitation();
        limitation.setCount(1);
        request.setLimitation(limitation);
        return request;
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
    public MewsGetCompanyRequest createGetCompanyPayload(SalesforceAccountResponse account) throws JsonProcessingException {

        MewsGetCompanyRequest request = new MewsGetCompanyRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        List<String> emails = new ArrayList<>();
        emails.add(account.getName());
        request.setNames(emails);

        MewsGetCompanyRequest.Limitation limitation = new MewsGetCompanyRequest.Limitation();
        limitation.setCount(10);
        request.setLimitation(limitation);

        return request;
    }

    public MewsUpdateCompanyRequest createUpdateCompanyPayload(SalesforceAccountResponse account) throws JsonProcessingException {

        MewsUpdateCompanyRequest request = new MewsUpdateCompanyRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        request.setCompanyId(account.getThn__Mews_Id__c());

        return request;
    }

    public String addCompany(MewsCompanyRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request,"companies");
    }

    public String addBooker(MewsBookerRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request,"customers");
    }
    public String getBooker(MewsGetBookerRequest request) throws IOException {
        return mewsConnectorService.getRecordFromMews(request,"customers");
    }
    public String addAvailabilityBlock(MewsAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request,"availabilityBlocks");
    }
    public String getMewsAvailabilityBlock(MewsGetAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.getRecordFromMews(request,"availabilityBlocks");
    }
    public String updateAvailabilityBlock(MewsUpdateAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"availabilityBlocks/update");
    }
    public String updateAvailability(MewsUpdateAvailabilityRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"services/updateAvailability");
    }
    public String updateRate(MewsUpdateRateRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"rates/updatePrice");
    }
    public String getCompany(MewsGetCompanyRequest request) throws IOException {
        return mewsConnectorService.getRecordFromMews(request,"companies");
    }
    public String updateBooker(MewsUpdateBookerRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"customers/update");
    }

    public String updateCompany(MewsUpdateCompanyRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request,"companies/update");
    }

}