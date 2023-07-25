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
import java.util.Optional;

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

    public SalesforceBookingRequest createBookingPayload(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property,String pmsAccountId) throws JsonProcessingException {
        SalesforceBookingRequest payload = new SalesforceBookingRequest();
        payload.setName(book.getName());
        payload.setCurrencyIsoCode(account.getCurrencyIsoCode());
//        payload.setRecordTypeId(account.getRecordTypeId());
//        payload.setAccomodationNotes(booking.getAccomodationNotes());
//        payload.setAgentContact(booking.getAgentContact());
//        payload.setAgent(booking.getAgent());
//        payload.setArrivalDate(book.getThn__Arrival_Date__c());
//        payload.setArrivalDay(booking.getArrivalDay());
//        payload.setBillTo(booking.getBillTo());
//        payload.setBillingAccount(booking.getBillingAccount());
//        payload.setBillingAddress(booking.getBillingAddress());
//        payload.setBusinessSegment(booking.getBusinessSegment());
//        payload.setCateringNotes(booking.getCateringNotes());
//        payload.setChannel(booking.getChannel());
//        payload.setClosedStatus(booking.getClosedStatus());
//        payload.setComment(booking.getComment());
//        payload.setCompanyContact(booking.getCompanyContact());
//        payload.setCompany(booking.getCompany());
//        payload.setDaysUntilArrival(booking.getDaysUntilArrival());
//        payload.setDepartureDate(book.getThn__Departure_Date__c());
//        payload.setDepartureDay(booking.getDepartureDay());
//        payload.setDepositPayDate(booking.getDepositPayDate());
//        payload.setDeposit(booking.getDeposit());
//        payload.setDietaryRequirements(booking.getDietaryRequirements());
//        payload.setDuration(booking.getDuration());
        payload.setHotel(property.getId());
//        payload.setInternalNotes(property.getBookingInternalNotes());
//        payload.setInvoicingDetails(booking.getInvoicingDetails());
//        payload.setLostRefusedRemarks(booking.getLostRefusedRemarks());
//        payload.setMewsGroupId(booking.getMewsGroupId());
        payload.setPax(book.getThn__Pax__c());
//        payload.setProbability(booking.getProbability());
//        payload.setReasonLostCancelled(booking.getReasonLostCancelled());
//        payload.setRequestDate(booking.getRequestDate());
//        payload.setReservationGuest(booking.getReservationGuest());
//        payload.setSource(booking.getSource());
//        payload.setStage(account.getStage__c());
//        payload.setStructuredReference(booking.getStructuredReference());
//        payload.setSubtype(account.getThn__Subtype__c());
//        payload.setTotalAmountExclTax(booking.getTotalAmountExclTax());
//        payload.setTotalAmountInclTax(booking.getTotalAmountInclTax());
//        payload.setType(account.getThn__Type__c());
//        payload.setHotelRoomsAmount(property.getHotelRoomsAmount());
//        payload.setMeetingRoomsAmount(booking.getMeetingRoomsAmount());
//        payload.setNumberOfPacks(booking.getNumberOfPacks());
//        payload.setProductsAmount(booking.getProductsAmount());
//        payload.setTotalTax(booking.getTotalTax());
//        payload.setOfferDate(booking.getOfferDate());
//        payload.setReleaseDate(booking.getReleaseDate());
//        payload.setSignatureDate(booking.getSignatureDate());
//        payload.setPurchaseOrder(booking.getPurchaseOrder());
//        payload.setSendAndSignTimeTag(booking.getSendAndSignTimeTag());
//        payload.setSignatureName(booking.getSignatureName());
//        payload.setSignatureTitle(booking.getSignatureTitle());
//        payload.setSignatureURL(booking.getSignatureURL());
//        payload.setRequest(booking.getRequest());
//        payload.setBalance(booking.getBalance());
//        payload.setBrief(booking.getBrief());
//        payload.setCancellationToBeReported(booking.getCancellationToBeReported());
//        payload.setCreditToBeReported(booking.getCreditToBeReported());
//        payload.setInvoicedAmountHT(booking.getInvoicedAmountHT());
//        payload.setInvoicedAmount(booking.getInvoicedAmount());
//        payload.setInvoicedAmountExclTax(booking.getInvoicedAmountExclTax());
//        payload.setInvoicedToBeReported(booking.getInvoicedToBeReported());
//        payload.setPaidAmount(booking.getPaidAmount());
//        payload.setPaidAmountOnInvoices(booking.getPaidAmountOnInvoices());
//        payload.setZtHotelName(booking.getZtHotelName());
//        payload.setTotalVATAmount(booking.getTotalVATAmount());
//        payload.setAccountName(booking.getAccountName());
//        payload.setArrivalDate2(booking.getArrivalDate2());
//        payload.setAvgRate(booking.getAvgRate());
//        payload.setBevRevenue(booking.getBevRevenue());
//        payload.setBlocked(booking.getBlocked());
        payload.setBeverage(account.getThn__Beverage__c());
//        payload.setCatMgr(booking.getCatMgr());
//        payload.setCatRevenue(booking.getCatRevenue());
//        payload.setCxlReason(booking.getCxlReason());
//        payload.setDecisionDate2(booking.getDecisionDate2());
//        payload.setDeniedReason(booking.getDeniedReason());
//        payload.setDepartureDate2(booking.getDepartureDate2());
//        payload.setFoodRevenue(booking.getFoodRevenue());
        payload.setFood(account.getThn__Food__c());
//        payload.setInsertDate2(booking.getInsertDate2());
//        payload.setLostReason(booking.getLostReason());
//        payload.setMyceQuoteId(booking.getMyceQuoteId());
        payload.setMeetingRoom(account.getThn__Meeting_Room__c());
//        payload.setNetADR(booking.getNetADR());
//        payload.setOfferSent2(booking.getOfferSent2());
//        payload.setOriginal(booking.getOriginal());
//        payload.setOthers(booking.getOthers());
//        payload.setOther(account.getThn__Other__c());
//        payload.setPickedUpNetADR(booking.getPickedUpNetADR());
//        payload.setPickedUp(booking.getPickedUp());
//        payload.setRoomMgr(booking.getRoomMgr());
//        payload.setRoomRental(booking.getRoomRental());
        payload.setRoom(account.getThn__Meeting_Room__c());
//        payload.setSalMgr(booking.getSalMgr());
//        payload.setSourceMarket(booking.getSourceMarket());
//        payload.setQuoteNumber(booking.getQuoteNumber());
//        payload.setCutoffDate2(booking.getCutoffDate2());
//        payload.setCutoffDate(block.getAbsoluteCutoffDate());
//        payload.setD1(booking.getD1());
//        payload.setD2(booking.getD2());
//        payload.setD3(booking.getD3());
//        payload.setD4(booking.getD4());
//        payload.setDecisionDate(booking.getDecisionDate());
//        payload.setDx(booking.getDx());
//        payload.setInsertDate(booking.getInsertDate());
//        payload.setOfferSent(booking.getOfferSent());
//        payload.setTw(booking.getTw());
//        payload.setW1(booking.getW1());
//        payload.setW2(booking.getW2());
//        payload.setW3(booking.getW3());
//        payload.setW4(booking.getW4());
//        payload.setHotels(booking.getHotels());
        payload.setResort(property.getResort());
//        payload.setZtCountMR(booking.getZtCountMR());
//        payload.setZtCountQP(booking.getZtCountQP());
//        payload.setNumberofNights(booking.getNumberofNights());
//        payload.setDiscountPercent(booking.getDiscountPercent());
//        payload.setPublicURL(booking.getPublicURL());
//        payload.setCompetitor(booking.getCompetitor());
//        payload.setOtherReasonLostTurndownCancelled(booking.getOtherReasonLostTurndownCancelled());
//        payload.setLanguage(contact.getThn__Language__c());
//        payload.setAccountReference(booking.getAccountReference());
//        payload.setOrigin(account.getOrigin__c());
//        payload.setInternal(booking.getInternal());
//        payload.setDietaryRequirements2(booking.getDietaryRequirements2());
//        payload.setPaymentMethod(booking.getPaymentMethod());
//        payload.setSignage(booking.getSignage());
//        payload.setDeposit2(booking.getDeposit2());
//        payload.setDeposit3(booking.getDeposit3());
//        payload.setDeposit2PayDate(booking.getDeposit2PayDate());
//        payload.setDeposit3PayDate(booking.getDeposit3PayDate());
//        payload.setOnsiteContact(booking.getOnsiteContact());
//        payload.setOnsiteContactPhone(booking.getOnsiteContactPhone());
//        payload.setDays(booking.getDays());
//        payload.setPackageAmountInc(booking.getPackageAmountInc());
//        payload.setPackageAmount(booking.getPackageAmount());
//        payload.setStartTime(booking.getStartTime());
//        payload.setOptionDate(booking.getOptionDate());
//        payload.setTotalRoomsBooked(booking.getTotalRoomsBooked());
//        payload.setQuoteNotes(booking.getQuoteNotes());
//        payload.setDiscountMeetingRooms(booking.getDiscountMeetingRooms());
//        payload.setDiscountHotelRooms(booking.getDiscountHotelRooms());
//        payload.setDiscountAV(booking.getDiscountAV());
//        payload.setDiscountNoAV(booking.getDiscountNoAV());
//        payload.setDiscountPackages(booking.getDiscountPackages());
//        payload.setDeposit1VAT(booking.getDeposit1VAT());
//        payload.setDeposit2VAT(booking.getDeposit2VAT());
//        payload.setDeposit3VAT(booking.getDeposit3VAT());
//        payload.setDeposit1Amount(booking.getDeposit1Amount());
//        payload.setDeposit2Amount(booking.getDeposit2Amount());
//        payload.setDeposit3Amount(booking.getDeposit3Amount());
//        payload.setPoNumber(booking.getPoNumber());
        payload.setLogoURL(property.getLogoURL());
//        payload.setHotelRoomsAmountInc(booking.getHotelRoomsAmountInc());
//        payload.setMeetingRoomsAmountInc(booking.getMeetingRoomsAmountInc());
//        payload.setProductsAmountInc(booking.getProductsAmountInc());
//        payload.setLsReference(booking.getLsReference());
//        payload.setArNummer(booking.getArNummer());
//        payload.setLastOfferGeneration(booking.getLastOfferGeneration());
//        payload.setRoomsAmountTotal(booking.getRoomsAmountTotal());
//        payload.setAdrIncl(booking.getAdrIncl());
//        payload.setUniqueNumberProforma(booking.getUniqueNumberProforma());
//        payload.setAccommodationNotesLong(booking.getAccommodationNotesLong());
//        payload.setCateringNotesLong(booking.getCateringNotesLong());
//        payload.setInternalNotesLong(booking.getInternalNotesLong());
//        payload.setReservationGuestName(booking.getReservationGuestName());
//        payload.setLocaleForDocuments(booking.getLocaleForDocuments());
//        payload.setCompanyShortName(booking.getCompanyShortName());
//        payload.setCommActivity(account.getThn__Comm_Activity__c());
        payload.setCommBeverage(property.getCommBeverage());
        payload.setCommEquipment(account.getThn__Comm_Equipment__c());
        payload.setCommFood(property.getCommFood());
        payload.setCommHotelRooms(property.getCommHotelRooms());
        payload.setCommMeetingRooms(property.getCommMeetingRooms());
        payload.setCommOther(property.getCommOther());
        payload.setCommPackage(property.getCommPackage());
//        payload.setCommissionTo(booking.getCommissionTo());
//        payload.setLastSync(booking.getLastSync());
//        payload.setLastSyncStatus(booking.getLastSyncStatus());
//        payload.setSyncErrorMessage(booking.getSyncErrorMessage());
//        payload.setTotalCommissionOnQuote(booking.getTotalCommissionOnQuote());
//        payload.setShoulderEndDate(block.getEndShoulderDate());
//        payload.setShoulderStartDate(block.getStartShoulderDate());
//        payload.setTotalInclTax(booking.getTotalInclTax());
//        payload.setTotalHotelRoomInclTax(booking.getTotalHotelRoomInclTax());
//        payload.setTotalMeetingRoomInclTax(booking.getTotalMeetingRoomInclTax());
//        payload.setTotalProductInclTax(booking.getTotalProductInclTax());
//        payload.setZtCountHR(booking.getZtCountHR());
//        payload.setReleaseDateFormula(booking.getReleaseDateFormula());
//        payload.setGuestQuoteName(booking.getGuestQuoteName());
//        payload.setReleaseDateFormula2(booking.getReleaseDateFormula2());
//        payload.setPotentialMaxRevenueField(booking.getPotentialMaxRevenueField());
//        payload.setPotentialMaxRevenueMR(booking.getPotentialMaxRevenueMR());
//        payload.setPotentialMaxRevenuePackage(booking.getPotentialMaxRevenuePackage());
//        payload.setPotentialMaxRevenueProduct(booking.getPotentialMaxRevenueProduct());
//        payload.setTotalPaid(booking.getTotalPaid());
//        payload.setInventoryBlockType(block.getInventoryBlockType());
        payload.setPmsCompany(pmsAccountId);
        payload.setPmsGroup(pmsAccountId);
        payload.setPmsSource(pmsAccountId);
        payload.setPmsTravelAgent(pmsAccountId);
//        payload.setGuaranteeCode(block.getGuaranteeCode());
//        payload.setDietaryRequirementsLong(booking.getDietaryRequirementsLong());
//        payload.setStatus(account.getThn__Status__c());
//        payload.setBlockRate(booking.getBlockRate());
//        payload.setRatingStars(booking.getRatingStars());
//        payload.setPackageAmountInclTax(booking.getPackageAmountInclTax());
//        payload.setTaxCalculationLog(booking.getTaxCalculationLog());
//        payload.setTaxGroupType(booking.getTaxGroupType());
//        payload.setTaxLastCalculatedDate(booking.getTaxLastCalculatedDate());
//        payload.setExpandedStatus(booking.getExpandedStatus());
        return payload;
    }

    public PSMAccountRequest createPSMAccountPayload(SalesforceBookingResponse book, SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property) throws JsonProcessingException {
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
//      payload.setBillingStreetLine2("Billing Street Line 2");
//      payload.setBillingStreetLine3("Billing Street Line 3");
//      payload.setBillingStreetLine4("Billing Street Line 4");
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
//      payload.setPrimaryStreetLine2("Primary Street Line 2");
//      payload.setPrimaryStreetLine3("Primary Street Line 3");
//      payload.setPrimaryStreetLine4("Primary Street Line 4");
        payload.setPrimaryStreet(account.getThn__PrimaryStreet__c());
        payload.setSendToPms(book.getThn__SendToPMS__c());
        payload.setShippingCity(account.getShippingCity());
        payload.setShippingCountryCode(account.getShippingCountryCode());
        payload.setShippingCountry(account.getShippingCountry());
        payload.setShippingPostalCode(account.getShippingPostalCode());
        payload.setShippingStateCode(account.getShippingStateCode());
        payload.setShippingState(account.getShippingState());
//      payload.setShippingStreetLine2("Shipping Street Line 2");
//      payload.setShippingStreetLine3("Shipping Street Line 3");
//      payload.setShippingStreetLine4("Shipping Street Line 4");
        payload.setShippingStreet(account.getShippingStreet());
        payload.setSicCode(account.getSic());
        payload.setSicDescription(account.getSicDesc());
        payload.setStatus(account.getThn__Status__c());
        payload.setTaxId(account.getThn__TaxIdentifier__c());
//        payload.setPmsId(mewsCompanyId.get().getCompanies().get(0).getId());
//      payload.setAccountReceivableNumber("12345");
//      payload.setCreateAccount(true);
//      payload.setHapiId("Hapi ID");
//      payload.setIataNumber("IATA Number");
//      payload.setPmsSystemId("PMS System ID");
//      payload.setPmsSystemType("PMS System Type");
//      payload.setPmsAddressType("PMS Address Type");
//      payload.setPrimaryStateCode("CA");
//      payload.setPropertyDetailsChainCode("Property Details Chain Code");
//      payload.setPropertyDetailsCode("Property Details Code");
//      payload.setSecondaryName("Secondary Name");
//      payload.setSendToPmsStatus("Send To PMS Status");
//      payload.setSyncAccount(true);
//      payload.setTerritory("Territory");
//      payload.setTertiaryName("Tertiary Name");
//      payload.setEmailAddressType("Email Address Type");
//      payload.setMobilePhone(contact.getMobilePhone());
//      payload.setVipStatus("VIP Status");
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

    public SalesforceGuestRequest createGuestBookerPayload(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property) throws JsonProcessingException {
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
//        payload.setMyceQuote(book.getName());
//        payload.setCompany(account.getId());
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

//      payload.setInvoiceable(invoiceable);
//      payload.setCarRegistrationNumber(carRegistrationNumber);
//      payload.setCategoryId(categoryId);
//      payload.setCitizenNumber(citizenNumber);
//      payload.setClassifications(classifications);
//      payload.setCreatedUtc(createdUtc);
//      payload.setFatherName(fatherName);
//      payload.setMotherName(motherName);
//      payload.setNationalityCode(nationalityCode);
//      payload.setOccupation(occupation);
//      payload.setUpdatedUtc(updatedUtc);
//      payload.setSendMarketingEmails(sendMarketingEmails);
//      payload.setDoNotCall(doNotCall);
//      payload.setEmailOptOut(emailOptOut);
//      payload.setOtherStreetLine2(otherStreetLine2);
//      payload.setOtherStreetLine3(otherStreetLine3);
//      payload.setOtherStreetLine4(otherStreetLine4);
//      payload.setPmsSystemId(pmsSystemId);
//      payload.setPmsSystemType(pmsSystemType);
//      payload.setPosCompanyId(posCompanyId);
//      payload.setPosCredits(posCredits);
//      payload.setPosDeliveryCity(posDeliveryCity);
//      payload.setPosDeliveryCountry(posDeliveryCountry);
//      payload.setPosDeliveryStreetNumber(posDeliveryStreetNumber);
//      payload.setPosDeliveryStreet(posDeliveryStreet);
//      payload.setPosDeliveryZip(posDeliveryZip);
//      payload.setPosErrorMessage(posErrorMessage);
//      payload.setPosId(posId);
//      payload.setPosLanguage(posLanguage);
//      payload.setPosStreetNumber(posStreetNumber);
//      payload.setPosUuid(posUuid);
//      payload.setPosVatNumber(posVatNumber);
//      payload.setPosVisible(posVisible);
//      payload.setPropertyDetailsChainCode(propertyDetailsChainCode);
//      payload.setPropertyDetailsCode(propertyDetailsCode);
//      payload.setGender(gender);
//      payload.setSendToPos(sendToPos);
//      payload.setHapiId(hapiId);
//      payload.setCreateContact(createContact);
//      payload.setEmailAddressType(emailAddressType);
//      payload.setVip(isVip);
//      payload.setOptedPromotionalEmails(optedPromotionalEmails);
//      payload.setWorksAt(worksAt);

        return payload;
    }

    public SalesforcePSMBlockRequest createPMSBlockPayloadByGet(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property,MewsAvailabilityBlockResponse availabilityBlockId,String pmsAccountId,String contactId,SalesforceQueryResponse pmsId) throws JsonProcessingException {
        SalesforcePSMBlockRequest payload = new SalesforcePSMBlockRequest();
        payload.setName(contact.getName());
        payload.setCurrencyIsoCode(book.getCurrencyIsoCode());
        payload.setMyceQuote(book.getId());
//        payload.setPmsId(availabilityBlockId.getRateId());
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
        payload.setBooker(contactId);
        System.out.println("contactId"+contactId);
        payload.setPmsAccountCompany(pmsAccountId);
        payload.setPmsAccountGroup(pmsAccountId);
        payload.setPmsAccountSource(pmsAccountId);
        payload.setPmsAccountTravelAgent(pmsAccountId);
        payload.setPmsId(availabilityBlockId.getAvailabilityBlocks().get(0).getId());
//        payload.setPmsResponse(book.getPmsResponse());
//        payload.setPmsResponseDateTime(book.getPmsResponseDateTime());
//        payload.setPmsStatus(book.getPmsStatus());
//        payload.setStatus(book.getStatus());
//        payload.setAbsoluteCutoffDate(book.getAbsoluteCutoffDate());
//        payload.setCancellationReasonCode(book.getCancellationReasonCode());
//        payload.setCancellationReasonText(book.getCancellationReasonText());
//        payload.setCode(book.getCode());
//        payload.setCreatedDateTime(book.getCreatedDateTime());
//        payload.setCurrencyPrecision(rate.getCurrencyPrecision());
//        payload.setGuaranteeCode(book.getGuaranteeCode());
//        payload.setHapiId(book.getHapiId());
//        payload.setPmsSystemId(book.getPmsSystemId());
//        payload.setPmsSystemType(book.getPmsSystemType());
//        payload.setPmsBlockStatus(book.getPmsBlockStatus());
//        payload.setPaymentMethodCode(book.getPaymentMethodCode());
//        payload.setPropertyDetailsBrandCode(property.getPropertyDetailsBrandCode());
//        payload.setPropertyDetailsChainCode(property.getPropertyDetailsChainCode());
//        payload.setPropertyDetailsCode(property.getPropertyDetailsCode());
//        payload.setPropertyDetailsId(property.getPropertyDetailsId());
//        payload.setReleaseDaysBeforeStayDate(book.getReleaseDaysBeforeStayDate());
//        payload.setReservationPickUpMethod(book.getReservationPickUpMethod());
//        payload.setSegmentationChannel(book.getSegmentationChannel());
//        payload.setSegmentationMarket(book.getSegmentationMarket());
//        payload.setSegmentationOrigin(book.getSegmentationOrigin());
//        payload.setType(book.getType());
//        payload.setSyncStatus(book.getSyncStatus());
//        payload.setBlockStatus(book.getBlockStatus());
//        payload.setGuaranteeCode2(book.getGuaranteeCode2());
//        payload.setSendFailedPMSBlock(book.isSendFailedPMSBlock());
//        payload.setCountry(contact.getCountry());
//        payload.setEmail(contact.getEmail());
//        payload.setPostingAccountId(account.getPostingAccountId());
//        payload.setReservationTypeCode(book.getReservationTypeCode());
//        payload.setSegmentationCode(book.getSegmentationCode());
        return payload;
    }

    public SalesforcePSMBlockRequest createPMSBlockPayloadByCreated(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property,MewsAvailabilityBlockResponse availabilityBlockId,String pmsAccountId,String contactId,SalesforceQueryResponse pmsId) throws JsonProcessingException {
        SalesforcePSMBlockRequest payload = new SalesforcePSMBlockRequest();
        payload.setName(contact.getName());
        payload.setCurrencyIsoCode(book.getCurrencyIsoCode());
        payload.setMyceQuote(book.getId());
//        payload.setPmsId(availabilityBlockId.getRateId());
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
        payload.setBooker(contactId);
        System.out.println("contactId"+contactId);
        payload.setPmsAccountCompany(pmsAccountId);
        payload.setPmsAccountGroup(pmsAccountId);
        payload.setPmsAccountSource(pmsAccountId);
        payload.setPmsAccountTravelAgent(pmsAccountId);
        payload.setPmsId(availabilityBlockId.getAvailabilityBlocks().get(0).getId());

//        payload.setPmsResponse(book.getPmsResponse());
//        payload.setPmsResponseDateTime(book.getPmsResponseDateTime());
//        payload.setPmsStatus(book.getPmsStatus());
//        payload.setStatus(book.getStatus());
//        payload.setAbsoluteCutoffDate(book.getAbsoluteCutoffDate());
//        payload.setCancellationReasonCode(book.getCancellationReasonCode());
//        payload.setCancellationReasonText(book.getCancellationReasonText());
//        payload.setCode(book.getCode());
//        payload.setCreatedDateTime(book.getCreatedDateTime());
//        payload.setCurrencyPrecision(rate.getCurrencyPrecision());
//        payload.setGuaranteeCode(book.getGuaranteeCode());
//        payload.setHapiId(book.getHapiId());
//        payload.setPmsSystemId(book.getPmsSystemId());
//        payload.setPmsSystemType(book.getPmsSystemType());
//        payload.setPmsBlockStatus(book.getPmsBlockStatus());
//        payload.setPaymentMethodCode(book.getPaymentMethodCode());
//        payload.setPropertyDetailsBrandCode(property.getPropertyDetailsBrandCode());
//        payload.setPropertyDetailsChainCode(property.getPropertyDetailsChainCode());
//        payload.setPropertyDetailsCode(property.getPropertyDetailsCode());
//        payload.setPropertyDetailsId(property.getPropertyDetailsId());
//        payload.setReleaseDaysBeforeStayDate(book.getReleaseDaysBeforeStayDate());
//        payload.setReservationPickUpMethod(book.getReservationPickUpMethod());
//        payload.setSegmentationChannel(book.getSegmentationChannel());
//        payload.setSegmentationMarket(book.getSegmentationMarket());
//        payload.setSegmentationOrigin(book.getSegmentationOrigin());
//        payload.setType(book.getType());
//        payload.setSyncStatus(book.getSyncStatus());
//        payload.setBlockStatus(book.getBlockStatus());
//        payload.setGuaranteeCode2(book.getGuaranteeCode2());
//        payload.setSendFailedPMSBlock(book.isSendFailedPMSBlock());
//        payload.setCountry(contact.getCountry());
//        payload.setEmail(contact.getEmail());
//        payload.setPostingAccountId(account.getPostingAccountId());
//        payload.setReservationTypeCode(book.getReservationTypeCode());
//        payload.setSegmentationCode(book.getSegmentationCode());
        return payload;
    }

    public SalesforcePMSBlockInventory createMewsBlockInventoryPayload(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property,String pmsBlockRequestResponse,SalesforceQueryResponse query) throws JsonProcessingException {
        SalesforcePMSBlockInventory payload = new SalesforcePMSBlockInventory();
        payload.setPmsBlock(pmsBlockRequestResponse);
        List<SalesforceQueryResponse.QuoteHotelRoom> records = query.getRecords();
        String id = records.get(0).getSpaceArea();
        payload.setThnRoomType(id);
        payload.setThnUniquePMSKey(rate.getUniquePmsKey());
        payload.setThnEnd(book.getThn__Departure_Date__c());
        payload.setThnStart(book.getThn__Arrival_Date__c());

//        payload.setThnOccupancy1Blocked();
//        payload.setThnOccupancy1Pickedup();
//        payload.setThnOccupancy2Blocked();
//        payload.setThnOccupancy2Pickedup();
//        payload.setThnOccupancy3Blocked();
//        payload.setThnOccupancy4Blocked();
//        payload.setThnOccupancy4Pickedup();
//        payload.setThnRoomTypeCode();
//        payload.setThnTotalBlocked();
//        payload.setThnTotalPickedUp();
//        payload.setThnZTInventoryChange();



        return payload;
    }

    public SalesforcePMSBlockRate createPMSBlockRatesPayload(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property,String pmsBlockRequestResponse,SalesforceQueryResponse query) throws JsonProcessingException {
        SalesforcePMSBlockRate payload = new SalesforcePMSBlockRate();
        payload.setPmsBlock(pmsBlockRequestResponse);
        payload.setEnd(book.getThn__Departure_Date__c());
        payload.setRate(rate.getId());
        List<SalesforceQueryResponse.QuoteHotelRoom> records = query.getRecords();
        String id = records.get(0).getSpaceArea();
        payload.setRoomType(id);
        payload.setStart(book.getThn__Arrival_Date__c());

//        payload.setAdditionalAdultPrice(property.getAdditionalAdult());
//        payload.setAdditionalGuestPrice(property.getAdditionalChild());
//        payload.setOccupancy1Price(rate.getOccupancy1Price());
//        payload.setOccupancy2Price(rate.getOccupancy2Price());
//        payload.setOccupancy3Price(rate.getOccupancy3Price());
//        payload.setOccupancy4Price(rate.getOccupancy4Price());
//        payload.setRateCode();
//        payload.setRoomTypeCode(property.getRoomTypeCode());

        return payload;
    }

    public SalesforceUpdateGuestRoomWithPmsBlock createUpdateGuestRoomWithPmsBlock(SalesforceBookingResponse book,SalesforceAccountResponse account, SalesforceContactResponse contact, SalesforceRateResponse rate, SalesforcePropertyResponse property,SalesforceQueryResponse guestRoom,String pmsBlockId) throws JsonProcessingException {
        SalesforceUpdateGuestRoomWithPmsBlock payload = new SalesforceUpdateGuestRoomWithPmsBlock();

            payload.setName(contact.getName());
          payload.setThn__Pax__c(book.getThn__Pax__c());
          payload.setThn__ReleasedDate__c(book.getThn__Release_Date__c());
          payload.setThn__PMS_Block__c(pmsBlockId);
//        List<SalesforceQueryResponse.QuoteHotelRoom> records = guestRoom.getRecords();
//        for (SalesforceQueryResponse.QuoteHotelRoom record : records) {
//            String id = record.getId();
//            System.out.println("Record ID: " + id);
//        }

        return payload;
    }


    public String getRecordFromSalesforce(String object, String sfAccessToken, String bookingId) throws IOException {
        return salesforceConnectorService.getDataFromSalesforce(
                Objects.requireNonNull(object, "Salesforce Object must not be null"),
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Reference Id must not be null")
        );
    }

    public String getQueryDataFromSalesforce(String sfAccessToken, String bookingId,String object) throws IOException {
        return salesforceConnectorService.getQueryDataFromSalesforce(
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Reference Id must not be null"),
                Objects.requireNonNull(object, "Object Name must not be null")
        );
    }

    public String addRecordInSalesforce(String object, String sfAccessToken,String request) throws IOException {
        return salesforceConnectorService.setDataInSalesforce(object,sfAccessToken,request);
    }

    public String updateRecordInSalesforce(String object, String sfAccessToken, String request, String Id) throws IOException {
        return salesforceConnectorService.updateDataInSalesforce(object, sfAccessToken, request, Id);
    }
}
