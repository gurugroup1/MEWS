package middleware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public MewsController(MewsConnectorService mewsConnectorService, ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
        this.mewsConnectorService = Objects.requireNonNull(mewsConnectorService, "Salesforce connector service must not be null");
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
        limitation.setCount(1);
        request.setLimitation(limitation);

        return request;
    }
    public MewsCompanyRequest createCompanyPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact) throws JsonProcessingException {

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
    public MewsUpdateCompanyRequest createUpdateCompanyPayload(SalesforceAccountResponse account, SalesforceBookingResponse book, SalesforceContactResponse contact, MewsGetCompanyResponse companies) throws JsonProcessingException {
        MewsGetCompanyResponse.Company company = companies.getCompanies().get(0);
        String taxIdentifier = company.getTaxIdentifier();
        String contactName = company.getContact();
        String contactPerson = company.getContactPerson();
        String additionalTaxIdentifier = company.getAdditionalTaxIdentifier();
        String billingCode = company.getBillingCode();
        String accountingCode = company.getAccountingCode();
        String iata = company.getIata();
        String websiteUrl = company.getWebsiteUrl();
        String department = contact.getDepartment();
        String notes = company.getNotes();
        String companyName = company.getName();

        MewsUpdateCompanyRequest request = new MewsUpdateCompanyRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        request.setCompanyId(company.getId());

        MewsUpdateCompanyRequest.NameModel updatedName = new MewsUpdateCompanyRequest.NameModel();
        updatedName.setValue(getUpdatedValue(account.getName(), companyName));
        request.setName(updatedName);

        MewsUpdateCompanyRequest.IataModel updatedIata = new MewsUpdateCompanyRequest.IataModel();
        updatedIata.setValue(getUpdatedValue(account.getThn__IATA__c(), iata));
        request.setIata(updatedIata);

        request.setTaxIdentifier(getUpdatedValue(account.getThn__TaxIdentifier__c(), taxIdentifier));
        request.setAdditionalTaxIdentifier(getUpdatedValue(account.getThn__Additional_Tax_Identifier__c(), additionalTaxIdentifier));
        request.setBillingCode(getUpdatedValue(account.getThn__BillingCode__c(), billingCode));
        request.setAccountingCode(getUpdatedValue(account.getThn__Accounting_Code__c(), accountingCode));

        MewsUpdateCompanyRequest.ContactModel updatedContact = new MewsUpdateCompanyRequest.ContactModel();
        updatedContact.setValue(getUpdatedValue(contact.getName(), contactName));
        request.setContact(updatedContact);

        MewsUpdateCompanyRequest.ContactPersonModel updatedContactPerson = new MewsUpdateCompanyRequest.ContactPersonModel();
        updatedContactPerson.setValue(getUpdatedValue(contact.getEmail(), contactPerson));
        request.setContactPerson(updatedContactPerson);

        MewsUpdateCompanyRequest.DepartmentModel updatedDepartment = new MewsUpdateCompanyRequest.DepartmentModel();
        updatedDepartment.setValue(getUpdatedValue(contact.getDepartment(), department));
        request.setDepartment(updatedDepartment);

        MewsUpdateCompanyRequest.NotesModel updatedNotes = new MewsUpdateCompanyRequest.NotesModel();
        updatedNotes.setValue(getUpdatedValue(book.getQuote_Notes__c(), notes));
        request.setNotes(updatedNotes);

        MewsUpdateCompanyRequest.WebsiteUrlModel updatedWebsiteUrlModel = new MewsUpdateCompanyRequest.WebsiteUrlModel();
        updatedWebsiteUrlModel.setValue(getUpdatedValue(account.getWebsite(), websiteUrl));
        request.setWebsiteUrl(updatedWebsiteUrlModel);

        return request;
    }
    public MewsGetBookerRequest createGetBookerPayload(SalesforceAccountResponse account, SalesforceContactResponse contact) throws JsonProcessingException {

        MewsGetBookerRequest request = new MewsGetBookerRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        List<String> emailList = new ArrayList<>();
        String email = contact.getEmail();
        System.out.println(email);
        if (email != null && !email.isEmpty()) {
            emailList.add(email);
        }
        request.setEmails(emailList);

        MewsGetBookerRequest.Limitation limitation = new MewsGetBookerRequest.Limitation();
        limitation.setCount(1);
        request.setLimitation(limitation);
        System.out.println(request.getEmails());
        return request;
    }
    public MewsBookerRequest createBookerPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact) throws JsonProcessingException {

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

        MewsBookerRequest.Address address = new MewsBookerRequest.Address();
        address.setCity(contact.getMailingCity());
        address.setCountryCode(contact.getMailingCountryCode());
        address.setCountryCode(contact.getMailingCountryCode());
        address.setPostalCode(contact.getMailingPostalCode());
        address.setLine1(contact.getMailingAddress());

        mewsBookerRequest.setAddress(address);

        return mewsBookerRequest;
    }
    public MewsUpdateBookerRequest createUpdateBookerPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, MewsGetBookerResponse booker) throws JsonProcessingException {
        MewsGetBookerResponse.Customer customer = booker.getCustomers().get(0);
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String nationalityCode = customer.getNationalityCode();
        String birthDate = String.valueOf(customer.getBirthDate());
        String birthPlace = customer.getBirthPlace();
        String email = customer.getEmail();
        String phone = customer.getPhone();
        String loyaltyCode = customer.getLoyaltyCode();
        String notes = customer.getNotes();
        String contactFirstName = contact.getFirstName();
        String contactLastName = contact.getLastName();
        String contactNationalityCode = contact.getThn__Nationality__c();
//        String contactBirthDate = contact.getBirthdate();
//        String bookBirthPlace = book.getOrigin__c();
        String contactEmail = contact.getEmail();
        String contactPhone = contact.getPhone();
        String contactLoyaltyCode = contact.getLoyalty__c();
        String bookNotes = book.getQuote_Notes__c();

        MewsUpdateBookerRequest request = new MewsUpdateBookerRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        request.setCustomerId(customer.getId());

        request.setFirstName(getUpdatedValue(contactFirstName, firstName));
        request.setLastName(getUpdatedValue(contactLastName, lastName));
        request.setNationalityCode(getUpdatedValue(contactNationalityCode, nationalityCode));
//        request.setBirthDate(getUpdatedValue(contactBirthDate, birthDate));
//        request.setBirthPlace(getUpdatedValue(bookBirthPlace, birthPlace));
        request.setEmail(getUpdatedValue(contactEmail, email));
        request.setPhone(getUpdatedValue(contactPhone, phone));
        request.setLoyaltyCode(getUpdatedValue(contactLoyaltyCode, loyaltyCode));
        request.setNotes(getUpdatedValue(bookNotes, notes));

        return request;
    }
    public MewsGetAvailabilityBlockRequest createGetAvailabilityBlockPayload(SalesforceAccountResponse account, SalesforceContactResponse contact,SalesforceGetPMSBlockResponse psmBlock) throws JsonProcessingException {

        MewsGetAvailabilityBlockRequest request = new MewsGetAvailabilityBlockRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());

        List<String> blockId = new ArrayList<>();
//        blockId.add(psmBlock.getRecords().get(0).getPmsId());
        System.out.println(blockId);
        request.setAvailabilityBlockIds(blockId);

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
    public MewsAvailabilityBlockRequest createAvailabilityBlockPayload(SalesforceBookingResponse book, SalesforceRateResponse rate, SalesforceContactResponse contact, SalesforcePropertyResponse property, String bookerId) throws JsonProcessingException {

        MewsAvailabilityBlockRequest mewsAvailabilityBlockRequest = new MewsAvailabilityBlockRequest();
        mewsAvailabilityBlockRequest.setClient(applicationConfiguration.getMewsClientName());
        mewsAvailabilityBlockRequest.setAccessToken(applicationConfiguration.getMewsAccessToken());
        mewsAvailabilityBlockRequest.setClientToken(applicationConfiguration.getMewsClientToken());
        MewsAvailabilityBlockRequest.AvailabilityBlock availabilityBlock = new MewsAvailabilityBlockRequest.AvailabilityBlock();
        MewsAvailabilityBlockRequest.AvailabilityBlock.Budget budget = new MewsAvailabilityBlockRequest.AvailabilityBlock.Budget();
        availabilityBlock.setBookerId(bookerId);
        availabilityBlock.setRateId(rate.getThn__Mews_Id__c());
        availabilityBlock.setName(contact.getName());
        availabilityBlock.setServiceId(property.getThn__Mews_Reservation_Service_Id__c());
        availabilityBlock.setFirstTimeUnitStartUtc(book.getThn__Arrival_Date__c() + "T23:00:00.000Z");
        availabilityBlock.setLastTimeUnitStartUtc(book.getThn__Departure_Date__c() + "T23:00:00.000Z");
        availabilityBlock.setReleasedUtc(book.getThn__Release_Date__c());
        System.out.println(book.getThn__Release_Date__c());
        availabilityBlock.setNotes(book.getQuote_Notes__c());
        availabilityBlock.setState("Confirmed");
        availabilityBlock.setExternalIdentifier("Block-" + contact.getName());
        System.out.println("Block-" + contact.getName());
        budget.setValue((int) book.getThn__Total_Amount_incl_Tax__c());
        budget.setCurrency(rate.getCurrencyIsoCode());
        availabilityBlock.setBudget(budget);

        List<MewsAvailabilityBlockRequest.AvailabilityBlock> availabilityBlocks = new ArrayList<>();
        availabilityBlocks.add(availabilityBlock);
        System.out.println(availabilityBlock);
        mewsAvailabilityBlockRequest.setAvailabilityBlocks(availabilityBlocks);
        return mewsAvailabilityBlockRequest;
    }
    public MewsUpdateAvailabilityBlockRequest createUpdateAvailabilityBlockPayload(SalesforceAccountResponse account, SalesforceBookingResponse book, SalesforceContactResponse contact, SalesforcePropertyResponse property, MewsGetAvailabilityBlockResponse availabilityBlockId) throws JsonProcessingException {
        MewsUpdateAvailabilityBlockRequest request = new MewsUpdateAvailabilityBlockRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());

        MewsGetAvailabilityBlockResponse.AvailabilityBlock availabilityBlock = availabilityBlockId.getAvailabilityBlocks()[0];


        MewsUpdateAvailabilityBlockRequest.AvailabilityBlock block = new MewsUpdateAvailabilityBlockRequest.AvailabilityBlock();
        block.setAvailabilityBlockId(availabilityBlock.getId());
        System.out.println(availabilityBlockId.getAvailabilityBlocks()[0].getId());

        MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.Name updatedName = new MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.Name();
        updatedName.setValue(getUpdatedValue(contact.getName(), availabilityBlock.getName()));
        block.setName(updatedName);

        MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.FirstTimeUnitStartUtc startFirstTime = new MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.FirstTimeUnitStartUtc();
        startFirstTime.setValue(getUpdatedValue(book.getThn__Arrival_Date__c() + "T23:00:00.000Z", availabilityBlock.getFirstTimeUnitStartUtc()));
        block.setFirstTimeUnitStartUtc(startFirstTime);
        System.out.println(startFirstTime);

        MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.LastTimeUnitStartUtc startLastTime = new MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.LastTimeUnitStartUtc();
        startLastTime.setValue(getUpdatedValue(book.getThn__Departure_Date__c() + "T23:00:00.000Z", availabilityBlock.getLastTimeUnitStartUtc()));
        block.setLastTimeUnitStartUtc(startLastTime);
        System.out.println(startLastTime);

        MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.ReleasedUtc updatedReleasedUtc = new MewsUpdateAvailabilityBlockRequest.AvailabilityBlock.ReleasedUtc();
        updatedReleasedUtc.setValue(getUpdatedValue(availabilityBlock.getReleasedUtc(), availabilityBlock.getReleasedUtc()));
        block.setReleasedUtc(updatedReleasedUtc);

        List<MewsUpdateAvailabilityBlockRequest.AvailabilityBlock> availabilityBlocks = new ArrayList<>();
        availabilityBlocks.add(block);
        request.setAvailabilityBlocks(availabilityBlocks);

        return request;
    }
    public MewsUpdateAvailabilityRequest createUpdateAvailabilityPayload(SalesforceBookingResponse book, SalesforceRateResponse rate, SalesforcePropertyResponse property, MewsGetAvailabilityBlockResponse availabilityBlockId, List<SalesforceGuestRoomResponse> guestRooms) throws JsonProcessingException {

        MewsUpdateAvailabilityRequest request = new MewsUpdateAvailabilityRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        request.setServiceId(property.getThn__Mews_Reservation_Service_Id__c());

//        List<SalesforceGuestRoomResponse> records = guestRoom;
//        String blockId = "";
//        for (SalesforceGuestRoomResponse guestRoom : guestRooms) {
//            String id = record.getId();
//            String spaceArea = record.get
//            double roomsAmount = record.getRoomsAmount();
//            SalesforceQueryResponse.SpaceArea spaceAreaDetails = record.getSpaceAreaDetails();
//            String mewsId = "";
//            if (spaceAreaDetails != null) {
//                mewsId = spaceAreaDetails.getMewsId();
//            }
//            MewsUpdateAvailabilityRequest.AvailabilityUpdate availabilityUpdate = new MewsUpdateAvailabilityRequest.AvailabilityUpdate();
//            availabilityUpdate.setFirstTimeUnitStartUtc(book.getThn__Arrival_Date__c() + "T23:00:00.000Z");
//            availabilityUpdate.setLastTimeUnitStartUtc(book.getThn__Departure_Date__c() + "T23:00:00.000Z");
//            availabilityUpdate.setResourceCategoryId(mewsId);
//            List<MewsAvailabilityBlockResponse.AvailabilityBlock> availabilityBlocks = availabilityBlockId.getAvailabilityBlocks();
//
//            for (MewsAvailabilityBlockResponse.AvailabilityBlock block : availabilityBlocks) {
//                blockId = block.getId();
//            }
//            availabilityUpdate.setAvailabilityBlockId(blockId);
//
//            MewsUpdateAvailabilityRequest.UnitCountAdjustment unitCountAdjustment = new MewsUpdateAvailabilityRequest.UnitCountAdjustment();
//            unitCountAdjustment.setValue((int) (-1 * roomsAmount));
//            availabilityUpdate.setUnitCountAdjustment(unitCountAdjustment);
//
//            request.getAvailabilityUpdates().add(availabilityUpdate);
//        }

        return request;
    }

    public MewsUpdateRateRequest createUpdateRatePricePayloadByCreated(SalesforceBookingResponse book,MewsAvailabilityBlockResponse availabilityBlock) throws JsonProcessingException {
        String blockId = "";
        MewsUpdateRateRequest request = new MewsUpdateRateRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        List<MewsAvailabilityBlockResponse.AvailabilityBlock> availabilityBlocks = availabilityBlock.getAvailabilityBlocks();

        for (MewsAvailabilityBlockResponse.AvailabilityBlock block : availabilityBlocks) {
            blockId = block.getRateId();
        }
        request.setRateId(blockId);
        MewsUpdateRateRequest.PriceUpdate priceUpdate = new MewsUpdateRateRequest.PriceUpdate();
        priceUpdate.setFirstTimeUnitStartUtc(book.getThn__Arrival_Date__c() + "T23:00:00.000Z");
        priceUpdate.setLastTimeUnitStartUtc(book.getThn__Departure_Date__c() + "T23:00:00.000Z");
        priceUpdate.setValue(book.getThn__Hotel_Rooms_Amount__c());
        request.getPriceUpdates().add(priceUpdate);

        return request;
    }
    public MewsUpdateRateRequest createUpdateRatePricePayloadByGet(SalesforceBookingResponse book,MewsGetAvailabilityBlockResponse availabilityBlock) throws JsonProcessingException {
        String blockId = "";
        MewsUpdateRateRequest request = new MewsUpdateRateRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        MewsGetAvailabilityBlockResponse.AvailabilityBlock[] availabilityBlocks = availabilityBlock.getAvailabilityBlocks();

        for (MewsGetAvailabilityBlockResponse.AvailabilityBlock block : availabilityBlocks) {
            blockId = block.getRateId();
        }
        request.setRateId(blockId);
        MewsUpdateRateRequest.PriceUpdate priceUpdate = new MewsUpdateRateRequest.PriceUpdate();
        priceUpdate.setFirstTimeUnitStartUtc(book.getThn__Arrival_Date__c() + "T23:00:00.000Z");
        priceUpdate.setLastTimeUnitStartUtc(book.getThn__Departure_Date__c() + "T23:00:00.000Z");
        priceUpdate.setValue(book.getThn__Hotel_Rooms_Amount__c());
        request.getPriceUpdates().add(priceUpdate);

        return request;
    }
    public MewsDeleteAvailabilityBlockRequest createDeleteAvailabilityBlockPayload(MewsGetAvailabilityBlockResponse block) throws JsonProcessingException {
        MewsDeleteAvailabilityBlockRequest request = new MewsDeleteAvailabilityBlockRequest();
        request.setClient(applicationConfiguration.getMewsClientName());
        request.setAccessToken(applicationConfiguration.getMewsAccessToken());
        request.setClientToken(applicationConfiguration.getMewsClientToken());
        List<String> availabilityBlockIds = List.of(block.getAvailabilityBlocks()[0].getId());
        request.setAvailabilityBlockIds(availabilityBlockIds);
        return request;
    }

    private <ValueType> ValueType getUpdatedValue(ValueType salesforceValue, ValueType mewsValue) {
        return salesforceValue != null && mewsValue != null ? (salesforceValue.equals(mewsValue) ? mewsValue : salesforceValue) : (mewsValue != null ? mewsValue : salesforceValue);
    }

    public String addCompany(MewsCompanyRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request, "companies");
    }

    public String addBooker(MewsBookerRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request, "customers");
    }

    public String getBooker(MewsGetBookerRequest request) throws IOException {
        return mewsConnectorService.getRecordFromMews(request, "customers");
    }

    public String addAvailabilityBlock(MewsAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.pushToMews(request, "availabilityBlocks");
    }

    public String getMewsAvailabilityBlock(MewsGetAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.getRecordFromMews(request, "availabilityBlocks");
    }

    public String updateAvailabilityBlock(MewsUpdateAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request, "availabilityBlocks/update");
    }

    public String updateAvailability(MewsUpdateAvailabilityRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request, "services/updateAvailability");
    }

    public String updateRate(MewsUpdateRateRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request, "rates/updatePrice");
    }

    public String getCompany(MewsGetCompanyRequest request) throws IOException {
        return mewsConnectorService.getRecordFromMews(request, "companies");
    }

    public String updateBooker(MewsUpdateBookerRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request, "customers/update");
    }

    public String updateCompany(MewsUpdateCompanyRequest request) throws IOException {
        return mewsConnectorService.updateToMews(request, "companies/update");
    }

    public String deleteAvailabilityBlock(MewsDeleteAvailabilityBlockRequest request) throws IOException {
        return mewsConnectorService.deleteRecordFromMews(request);
    }


}