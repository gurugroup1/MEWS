package middleware.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import middleware.configurations.ApplicationConfiguration;
import middleware.models.*;
import middleware.services.SalesforceConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class SalesforceController {

    private final Logger logger = LoggerFactory.getLogger(SalesforceController.class);
    private final ApplicationConfiguration applicationConfiguration;
    private final SecretKeyManagerController secretKeyManagerController;
    private final SalesforceConnectorService salesforceConnectorService;

    @Autowired
    public SalesforceController(ApplicationConfiguration applicationConfiguration, SecretKeyManagerController secretKeyManagerController, SalesforceConnectorService salesforceConnectorService) {
        this.applicationConfiguration = Objects.requireNonNull(applicationConfiguration, "Application configuration " +
                "must not be null");
        this.secretKeyManagerController = Objects.requireNonNull(secretKeyManagerController, "Secret key manager " +
                "controller must not be null");
        this.salesforceConnectorService = Objects.requireNonNull(salesforceConnectorService, "Salesforce connector " +
                "service must not be null");
    }

    public SalesforceRestControllerRequest createRestControllerPayload(String bookingId) throws JsonProcessingException {
        SalesforceRestControllerRequest payload = new SalesforceRestControllerRequest();
        payload.setBookingId(bookingId);
        return payload;
    }


    public SalesforceBookingRequest createBookingPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, String pmsAccountId,String GuestId) throws JsonProcessingException {
        SalesforceBookingRequest payload = new SalesforceBookingRequest();
        payload.setName(book.getName());
        payload.setCurrencyIsoCode(account.getCurrencyIsoCode());
        payload.setReservationGuest(GuestId);
        payload.setHotel(property.getId());
        payload.setPax(book.getThn__Pax__c());
        payload.setBeverage(account.getThn__Beverage__c());
        payload.setFood(account.getThn__Food__c());
        payload.setMeetingRoom(account.getThn__Meeting_Room__c());
        payload.setRoom(account.getThn__Meeting_Room__c());
        payload.setResort(property.getResort());
        payload.setLogoURL(property.getLogoURL());
        payload.setCommBeverage(property.getCommBeverage());
        payload.setCommEquipment(account.getThn__Comm_Equipment__c());
        payload.setCommFood(property.getCommFood());
        payload.setCommHotelRooms(property.getCommHotelRooms());
        payload.setCommMeetingRooms(property.getCommMeetingRooms());
        payload.setCommOther(property.getCommOther());
        payload.setCommPackage(property.getCommPackage());
        payload.setPmsCompany(pmsAccountId);
        payload.setPmsGroup(pmsAccountId);
        payload.setPmsSource(pmsAccountId);
        payload.setPmsTravelAgent(pmsAccountId);
        return payload;
    }

    public PSMAccountRequest createPSMAccountPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, String accountPSMId) throws JsonProcessingException {
        PSMAccountRequest payload = new PSMAccountRequest();
        payload.setName(account.getName());
        payload.setCurrencyIsoCode(book.getCurrencyIsoCode());
        payload.setAccount(account.getId());
        payload.setBillingCity(account.getBillingCity());
        payload.setBillingCountryCode(account.getBillingCountryCode());
        payload.setBillingCountry(account.getBillingCountry());
        payload.setBillingPostalCode(account.getBillingPostalCode());
        payload.setBillingStateCode(account.getBillingStateCode());
        payload.setBillingState(account.getBillingState());
        payload.setBillingStreet(account.getBillingStreet());
        payload.setCorporateId(account.getThn__Corporate_Id__c());
        payload.setEmail(contact.getEmail());
        payload.setFax(contact.getFax());
        payload.setPmsId(account.getThn__Mews_Id__c());
        payload.setPhone(contact.getPhone());
        payload.setPrimaryCity(account.getThn__PrimaryCity__c());
        payload.setPrimaryCountryCode(account.getThn__PrimaryCountryCode__c());
        payload.setPrimaryCountry(account.getThn__PrimaryCountry__c());
        payload.setPrimaryPostalCode(account.getThn__PrimaryPostalCode__c());
        payload.setPrimaryState(account.getThn__PrimaryState__c());
        payload.setPrimaryStreet(account.getThn__PrimaryStreet__c());
        payload.setSendToPms(book.getThn__SendToPMS__c());
        payload.setShippingCity(account.getShippingCity());
        payload.setShippingCountryCode(account.getShippingCountryCode());
        payload.setShippingCountry(account.getShippingCountry());
        payload.setShippingPostalCode(account.getShippingPostalCode());
        payload.setShippingStateCode(account.getShippingStateCode());
        payload.setShippingState(account.getShippingState());
        payload.setShippingStreet(account.getShippingStreet());
        payload.setSicCode(account.getSic());
        payload.setSicDescription(account.getSicDesc());
        payload.setStatus(account.getThn__Status__c());
        payload.setTaxId(account.getThn__TaxIdentifier__c());
        payload.setPmsId(accountPSMId);
        payload.setType(book.getThn__Type__c());
        payload.setUniquePMSKey(rate.getUniquePmsKey());
        payload.setWebsite(account.getWebsite());
        payload.setFullName(account.getName());
        payload.setPmsDB(property.getPmsDb());
        payload.setBusinessPhone(book.getOnsite_Contact_Phone__c());
        payload.setAdditionalTaxIdentifier(account.getThn__Additional_Tax_Identifier__c());
        payload.setElectronicInvoiceIdentifier(account.getThn__Electronic_Invoice_Identifier__c());
        payload.setMyceQuote(book.getId());
        payload.setNotes(book.getQuote_Notes__c());
        payload.setNumber(account.getThn__Number__c());
        payload.setProperty(property.getId());
        return payload;
    }

    public SalesforceGuestRequest createGuestBookerPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property) throws JsonProcessingException {
        SalesforceGuestRequest payload = new SalesforceGuestRequest();
        payload.setFirstName(contact.getFirstName());
        payload.setLastName(contact.getLastName());
        payload.setEmail(contact.getEmail());
        payload.setMobilePhone(contact.getMobilePhone());
        payload.setHotel(property.getId());
        payload.setLanguageCode(book.getThn__Language__c());
        payload.setNationality(contact.getThn__Nationality__c());
        payload.setBirthDate(contact.getBirthdate());
        payload.setBirthPlace(book.getOrigin__c());
        payload.setAccount(account.getId());
        payload.setContact(contact.getId());
        payload.setCurrencyIsoCode(contact.getCurrencyIsoCode());
        payload.setAccountingCode(account.getThn__Accounting_Code__c());
        payload.setBillingCode(account.getThn__BillingCode__c());
        payload.setNotes(account.getThn__Notes__c());
        payload.setPhone(contact.getPhone());
        payload.setSendToMews(book.getThn__SendToMews__c());
        payload.setTaxIdentificationNumber(account.getThn__TaxIdentifier__c());
        payload.setTitle(contact.getTitle());
        payload.setMobilePhone(contact.getMobilePhone());
        payload.setSalutation(contact.getSalutation());
        payload.setDepartment(contact.getDepartment());
        payload.setFax(contact.getFax());
        payload.setHomePhone(contact.getHomePhone());
        payload.setMailingCountry(contact.getMailingCountry());
        payload.setMailingStateCode(contact.getMailingStateCode());
        payload.setMailingState(contact.getMailingState());
        payload.setMailingStreetLine2(contact.getMailingStreet());
        payload.setOtherCity(contact.getOtherCity());
        payload.setOtherCountryCode(contact.getOtherCountryCode());
        payload.setOtherCountry(contact.getOtherCountry());
        payload.setOtherPhone(contact.getOtherPhone());
        payload.setOtherPostalCode(contact.getOtherPostalCode());
        payload.setOtherStateCode(contact.getOtherStateCode());
        payload.setOtherState(contact.getOtherState());
        payload.setOtherStreet(contact.getOtherStreet());
        payload.setPmsId(account.getThn__Mews_Id__c());
        payload.setSendToPms(book.getThn__SendToMews__c());
        payload.setSource(book.getThn__Source__c());
        payload.setType(book.getThn__Type__c());
        payload.setUniquePMSKey(rate.getUniquePmsKey());
        payload.setLanguage(book.getThn__Language__c());
        payload.setNationality(contact.getThn__Nationality__c());
        payload.setBusinessEmail(property.getBusinessEmail());
        payload.setSyncStatus(account.getThn__Sync_Status__c());
        payload.setJobTitle(contact.getTitle());

        return payload;
    }

    public SalesforcePSMBlockRequest createPMSBlockPayloadByGet(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, MewsAvailabilityBlockResponse availabilityBlockId, String pmsAccountId, String GuestId) throws JsonProcessingException {
        SalesforcePSMBlockRequest payload = new SalesforcePSMBlockRequest();
        payload.setName(contact.getName());
        payload.setCurrencyIsoCode(book.getCurrencyIsoCode());
        payload.setMyceQuote(book.getId());
        payload.setPmsBlockEndTime(property.getCheckOut());
        payload.setPmsBlockStartTime(property.getCheckIn());
        payload.setPmsReleaseDateTime(book.getThn__Release_Date__c());
        payload.setFirstName(contact.getFirstName());
        payload.setLastName(contact.getLastName());
        payload.setNationality(contact.getThn__Nationality__c());
        payload.setPhone(contact.getPhone());
        payload.setRate(rate.getId());
        payload.setCurrencyCode(rate.getCurrencyIsoCode());
        payload.setEndShoulderDate(book.getThn__Shoulder_End_Date__c());
        payload.setEnd(book.getThn__Departure_Date__c());
        payload.setInventoryBlockType(book.getThn__InventoryBlockType__c());
        payload.setSegmentationSource(book.getThn__Source__c());
        payload.setSendToPms(book.getThn__SendToPMS__c());
        payload.setStartShoulderDate(book.getThn__Shoulder_Start_Date__c());
        payload.setStart(book.getThn__Arrival_Date__c());
        payload.setUniquePMSKey(rate.getUniquePmsKey());
        payload.setProperty(property.getId());
        payload.setBooker(GuestId);
        payload.setPmsAccountCompany(pmsAccountId);
        payload.setPmsAccountGroup(pmsAccountId);
        payload.setPmsAccountSource(pmsAccountId);
        payload.setPmsAccountTravelAgent(pmsAccountId);
        payload.setPmsId(availabilityBlockId.getAvailabilityBlocks().get(0).getId());
        return payload;
    }

    public SalesforcePSMBlockRequest createPMSBlockPayloadByCreated(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, MewsAvailabilityBlockResponse availabilityBlockId, String pmsAccountId, String GuestId) throws JsonProcessingException {
        SalesforcePSMBlockRequest payload = new SalesforcePSMBlockRequest();
        payload.setName(contact.getName());
        payload.setCurrencyIsoCode(book.getCurrencyIsoCode());
        payload.setMyceQuote(book.getId());
        payload.setPmsBlockEndTime(property.getCheckOut());
        payload.setPmsBlockStartTime(property.getCheckIn());
        payload.setPmsReleaseDateTime(book.getThn__Release_Date__c());
        payload.setFirstName(contact.getFirstName());
        payload.setLastName(contact.getLastName());
        payload.setNationality(contact.getThn__Nationality__c());
        payload.setPhone(contact.getPhone());
        payload.setRate(rate.getId());
        payload.setCurrencyCode(rate.getCurrencyIsoCode());
        payload.setEndShoulderDate(book.getThn__Shoulder_End_Date__c());
        payload.setEnd(book.getThn__Departure_Date__c());
        payload.setInventoryBlockType(book.getThn__InventoryBlockType__c());
        payload.setSegmentationSource(book.getThn__Source__c());
        payload.setSendToPms(book.getThn__SendToPMS__c());
        payload.setStartShoulderDate(book.getThn__Shoulder_Start_Date__c());
        payload.setStart(book.getThn__Arrival_Date__c());
        payload.setUniquePMSKey(rate.getUniquePmsKey());
        payload.setProperty(property.getId());
        payload.setBooker(GuestId);
        payload.setPmsAccountCompany(pmsAccountId);
        payload.setPmsAccountGroup(pmsAccountId);
        payload.setPmsAccountSource(pmsAccountId);
        payload.setPmsAccountTravelAgent(pmsAccountId);
        payload.setPmsId(availabilityBlockId.getAvailabilityBlocks().get(0).getId());
        return payload;
    }

    public SalesforcePMSBlockInventory createMewsBlockInventoryPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, String pmsBlockRequestResponse, List<SalesforceGuestRoomResponse> guestRoom) throws JsonProcessingException {
        SalesforcePMSBlockInventory payload = new SalesforcePMSBlockInventory();
        payload.setPmsBlock(pmsBlockRequestResponse);
        for (SalesforceGuestRoomResponse guestRoomInstance : guestRoom) {
            String id = guestRoomInstance.getSpaceArea();
            payload.setThnRoomType(id);
            payload.setThnUniquePMSKey(rate.getUniquePmsKey());
            payload.setThnEnd(book.getThn__Departure_Date__c());
            payload.setThnStart(book.getThn__Arrival_Date__c());
        }
        return payload;
    }

    public SalesforcePMSBlockRate createPMSBlockRatesPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property, String pmsBlockRequestResponse, List<SalesforceGuestRoomResponse> guestRoom) throws JsonProcessingException {
        SalesforcePMSBlockRate payload = new SalesforcePMSBlockRate();
        payload.setPmsBlock(pmsBlockRequestResponse);
        payload.setEnd(book.getThn__Departure_Date__c());
        payload.setRate(rate.getId());
        for (SalesforceGuestRoomResponse guestRoomInstance : guestRoom) {
            String id = guestRoomInstance.getSpaceArea();
            payload.setRoomType(id);
            payload.setStart(book.getThn__Arrival_Date__c());
        }
        return payload;
    }

    public SalesforceUpdateGuestRoomWithPmsBlock createUpdateGuestRoomWithPmsBlock(SalesforceBookingResponse book, SalesforceContactResponse contact, String pmsBlockId) throws JsonProcessingException {
        SalesforceUpdateGuestRoomWithPmsBlock payload = new SalesforceUpdateGuestRoomWithPmsBlock();
        payload.setName(contact.getName());
        payload.setThn__Pax__c(book.getThn__Pax__c());
        payload.setThn__ReleasedDate__c(book.getThn__Release_Date__c());
        payload.setThn__PMS_Block__c(pmsBlockId);
        return payload;
    }


    public String getRecordFromSalesforce(String object, String sfAccessToken, String bookingId) throws IOException {
        return salesforceConnectorService.getDataFromSalesforce(
                Objects.requireNonNull(object, "Salesforce Object must not be null"),
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Reference Id must not be null")
        );
    }

    public String getQueryDataFromSalesforce(String sfAccessToken, String bookingId, String object) throws IOException {
        return salesforceConnectorService.getQueryDataFromSalesforce(
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Reference Id must not be null"),
                Objects.requireNonNull(object, "Object Name must not be null")
        );
    }

    public String addRecordInSalesforce(String object, String sfAccessToken, String request) throws IOException {
        return salesforceConnectorService.setDataInSalesforce(object, sfAccessToken, request);
    }

    public String updateRecordInSalesforce(String object, String sfAccessToken, String request, String Id) throws IOException {
        return salesforceConnectorService.updateDataInSalesforce(object, sfAccessToken, request, Id);
    }

    public String restControllerSalesforce(String sfAccessToken, String request) throws IOException {
        return salesforceConnectorService.restCallOut(sfAccessToken, request);
    }
}
