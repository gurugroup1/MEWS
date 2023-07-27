package middleware.controllers;


import middleware.models.*;
import middleware.models.SalesforceRestControllerResponse;

import java.util.List;

public class StateController {

    private String bookingId;

    public String getCreatedPMSAccount() {
        return createdPMSAccount;
    }

    public void setCreatedPMSAccount(String createdPMSAccount) {
        this.createdPMSAccount = createdPMSAccount;
    }

    public String getCreatedGuest() {
        return createdGuest;
    }

    public void setCreatedGuest(String createdGuest) {
        this.createdGuest = createdGuest;
    }

    public String getCreatedPMSBlock() {
        return createdPMSBlock;
    }

    public void setCreatedPMSBlock(String createdPMSBlock) {
        this.createdPMSBlock = createdPMSBlock;
    }

    public String getCreatedBlockInventories() {
        return createdBlockInventories;
    }

    public void setCreatedBlockInventories(String createdBlockInventories) {
        this.createdBlockInventories = createdBlockInventories;
    }

    public String getCreatedPMSBlockRate() {
        return createdPMSBlockRate;
    }

    public void setCreatedPMSBlockRate(String createdPMSBlockRate) {
        this.createdPMSBlockRate = createdPMSBlockRate;
    }

    private String createdPMSAccount;
    private String createdGuest;
    private String createdPMSBlock;
    private String createdBlockInventories;
    private String createdPMSBlockRate;

    public String getSalesforceToken() {
        return salesforceToken;
    }

    public void setSalesforceToken(String salesforceToken) {
        this.salesforceToken = salesforceToken;
    }

    private String salesforceToken;

    private Integer pmsAccountSize;

    private Integer pmsBlockSize;


    public Boolean getHasCompany() {
        return hasCompany;
    }

    public void setHasCompany(Boolean hasCompany) {
        this.hasCompany = hasCompany;
    }

    private Boolean hasCompany;

    public Boolean getHasAvailabilityBlock() {
        return hasAvailabilityBlock;
    }

    public void setHasAvailabilityBlock(Boolean hasAvailabilityBlock) {
        this.hasAvailabilityBlock = hasAvailabilityBlock;
    }

    private Boolean hasAvailabilityBlock;


    public SalesforceBookingResponse getBookingData() {
        return bookingData;
    }

    public void setBookingData(SalesforceBookingResponse bookingData) {
        this.bookingData = bookingData;
    }


    private SalesforceBookingResponse bookingData;

    public SalesforceAccountResponse getAccountData() {
        return accountData;
    }

    public void setAccountData(SalesforceAccountResponse accountData) {
        this.accountData = accountData;
    }

    public SalesforceContactResponse getContactData() {
        return ContactData;
    }

    public void setContactData(SalesforceContactResponse contactData) {
        ContactData = contactData;
    }

    public SalesforceRateResponse getRateData() {
        return rateData;
    }

    public void setRateData(SalesforceRateResponse rateData) {
        this.rateData = rateData;
    }

    public SalesforcePropertyResponse getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(SalesforcePropertyResponse propertyData) {
        this.propertyData = propertyData;
    }

    public SalesforceGetPMSAccountResponse getPmsAccountData() {
        return pmsAccountData;
    }

    public void setPmsAccountData(SalesforceGetPMSAccountResponse pmsAccountData) {
        this.pmsAccountData = pmsAccountData;
    }


    private SalesforceAccountResponse accountData;
    private SalesforceContactResponse ContactData;
    private SalesforceRateResponse rateData;
    private SalesforcePropertyResponse propertyData;
    private SalesforceGetPMSAccountResponse pmsAccountData;

    public List<SalesforceGetPMSBlockResponse> getPmsBlockData() {
        return pmsBlockData;
    }

    public void setPmsBlockData(List<SalesforceGetPMSBlockResponse> pmsBlockData) {
        this.pmsBlockData = pmsBlockData;
    }

    private List<SalesforceGetPMSBlockResponse> pmsBlockData; // Change the type to List<GuestRoom>



    public List<SalesforceGuestRoomResponse> getGuestRoomData() {
        return guestRoomData;
    }

    public void setGuestRoomData(List<SalesforceGuestRoomResponse> guestRoomData) {
        this.guestRoomData = guestRoomData;
    }

    private List<SalesforceGuestRoomResponse> guestRoomData; // Change the type to List<GuestRoom>

    public MewsGetCompanyResponse getMewsCompany() {
        return MewsCompany;
    }

    public void setMewsCompany(MewsGetCompanyResponse mewsCompany) {
        MewsCompany = mewsCompany;
    }

    private MewsGetCompanyResponse MewsCompany;
    private MewsCompanyResponse MewsCompanyCreated;

    public MewsGetBookerResponse getMewsBooker() {
        return MewsBooker;
    }

    public void setMewsBooker(MewsGetBookerResponse MewsBooker) {
        MewsBooker = MewsBooker;
    }

    public MewsBookerResponse getMewsBookerCreated() {
        return MewsBookerCreated;
    }

    public void setMewsBookerCreated(MewsBookerResponse mewsBookerCreated) {
        MewsBookerCreated = mewsBookerCreated;
    }

    private MewsGetBookerResponse MewsBooker;
    private MewsBookerResponse MewsBookerCreated;

    public MewsGetAvailabilityBlockResponse getMewsAvailabilityBlock() {
        return MewsAvailabilityBlock;
    }

    public void setMewsAvailabilityBlock(MewsGetAvailabilityBlockResponse mewsAvailabilityBlock) {
        MewsAvailabilityBlock = mewsAvailabilityBlock;
    }

    public MewsAvailabilityBlockResponse getMewsAvailabilityBlockCreated() {
        return MewsAvailabilityBlockCreated;
    }

    public void setMewsAvailabilityBlockCreated(MewsAvailabilityBlockResponse mewsAvailabilityBlockCreated) {
        MewsAvailabilityBlockCreated = mewsAvailabilityBlockCreated;
    }

    private MewsGetAvailabilityBlockResponse MewsAvailabilityBlock;
    private MewsAvailabilityBlockResponse MewsAvailabilityBlockCreated;


    public MewsCompanyResponse getMewsCompanyCreated() {
        return MewsCompanyCreated;
    }

    public void setMewsCompanyCreated(MewsCompanyResponse mewsCompanyCreated) {
        MewsCompanyCreated = mewsCompanyCreated;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getPmsAccountSize() {
        return pmsAccountSize;
    }

    public void setPmsAccountSize(Integer pmsAccountSize) {
        this.pmsAccountSize = pmsAccountSize;
    }

    public Integer getPmsBlockSize() {
        return pmsBlockSize;
    }

    public void setPmsBlockSize(Integer pmsBlockSize) {
        this.pmsBlockSize = pmsBlockSize;
    }
}
