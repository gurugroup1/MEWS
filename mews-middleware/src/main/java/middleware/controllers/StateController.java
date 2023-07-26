package middleware.controllers;


import middleware.models.*;
import middleware.models.SalesforceRestControllerResponse;

import java.util.List;

public class StateController {

    private String bookingId;

    private Integer pmsAccountSize;

    private Integer pmsBlockSize;


    public Boolean getHasCompany() {
        return hasCompany;
    }

    public void setHasCompany(Boolean hasCompany) {
        this.hasCompany = hasCompany;
    }

    private Boolean hasCompany;

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
