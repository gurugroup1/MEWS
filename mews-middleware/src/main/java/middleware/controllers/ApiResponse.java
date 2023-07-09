package middleware.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.enums.ResponseStatus;

import java.util.Map;

public class ApiResponse {
    private ResponseStatus status;
    private String message;
    private Object bookingResponse;
    private Object accountResponse;
    private Object rateResponse;
    private Object propertyResponse;
    private Object contactResponse;
    private Object mewsCompanyResponse;
    private Object mewsBookerResponse;
    private Object mewsAvailabilityBlockResponse;
    private Object mewsUpdateAvailabilityResponse;
    private Object mewsUpdateRatePriceResponse;
    private Object salesforceCreatePMSAccountResponse;
    private Object salesforceCreateGuestResponse;
    private Object salesforceCreatePMSBlockResponse;
    private Object salesforceCreatePMSBlockRatesResponse;
    private Object salesforceUpdateGuestRoomResponse;
    private Object salesforceUpdateBookingResponse;
    private Map<String, Object> data;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBookingResponse() {
        return bookingResponse;
    }

    public void setBookingResponse(Object bookingResponse) {
        this.bookingResponse = bookingResponse;
    }

    public Object getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(Object accountResponse) {
        this.accountResponse = accountResponse;
    }

    public Object getRateResponse() {
        return rateResponse;
    }

    public void setRateResponse(Object rateResponse) {
        this.rateResponse = rateResponse;
    }

    public Object getPropertyResponse() {
        return propertyResponse;
    }

    public void setPropertyResponse(Object propertyResponse) {
        this.propertyResponse = propertyResponse;
    }

    public Object getContactResponse() {
        return contactResponse;
    }

    public void setContactResponse(Object contactResponse) {
        this.contactResponse = contactResponse;
    }

    public Object getMewsCompanyResponse() {
        return mewsCompanyResponse;
    }

    public void setMewsCompanyResponse(Object mewsCompanyResponse) {
        this.mewsCompanyResponse = mewsCompanyResponse;
    }

    public Object getMewsBookerResponse() {
        return mewsBookerResponse;
    }

    public void setMewsBookerResponse(Object mewsBookerResponse) {
        this.mewsBookerResponse = mewsBookerResponse;
    }

    public Object getMewsAvailabilityBlockResponse() {
        return mewsAvailabilityBlockResponse;
    }

    public void setMewsAvailabilityBlockResponse(Object mewsAvailabilityBlockResponse) {
        this.mewsAvailabilityBlockResponse = mewsAvailabilityBlockResponse;
    }

    public Object getMewsUpdateAvailabilityResponse() {
        return mewsUpdateAvailabilityResponse;
    }

    public void setMewsUpdateAvailabilityResponse(Object mewsUpdateAvailabilityResponse) {
        this.mewsUpdateAvailabilityResponse = mewsUpdateAvailabilityResponse;
    }

    public Object getMewsUpdateRatePriceResponse() {
        return mewsUpdateRatePriceResponse;
    }

    public void setMewsUpdateRatePriceResponse(Object mewsUpdateRatePriceResponse) {
        this.mewsUpdateRatePriceResponse = mewsUpdateRatePriceResponse;
    }

    public Object getSalesforceCreatePMSAccountResponse() {
        return salesforceCreatePMSAccountResponse;
    }

    public void setSalesforceCreatePMSAccountResponse(Object salesforceCreatePMSAccountResponse) {
        this.salesforceCreatePMSAccountResponse = salesforceCreatePMSAccountResponse;
    }

    public Object getSalesforceCreateGuestResponse() {
        return salesforceCreateGuestResponse;
    }

    public void setSalesforceCreateGuestResponse(Object salesforceCreateGuestResponse) {
        this.salesforceCreateGuestResponse = salesforceCreateGuestResponse;
    }

    public Object getSalesforceCreatePMSBlockResponse() {
        return salesforceCreatePMSBlockResponse;
    }

    public void setSalesforceCreatePMSBlockResponse(Object salesforceCreatePMSBlockResponse) {
        this.salesforceCreatePMSBlockResponse = salesforceCreatePMSBlockResponse;
    }

    public Object getSalesforceCreatePMSBlockRatesResponse() {
        return salesforceCreatePMSBlockRatesResponse;
    }

    public void setSalesforceCreatePMSBlockRatesResponse(Object salesforceCreatePMSBlockRatesResponse) {
        this.salesforceCreatePMSBlockRatesResponse = salesforceCreatePMSBlockRatesResponse;
    }

    public Object getSalesforceUpdateGuestRoomResponse() {
        return salesforceUpdateGuestRoomResponse;
    }

    public void setSalesforceUpdateGuestRoomResponse(Object salesforceUpdateGuestRoomResponse) {
        this.salesforceUpdateGuestRoomResponse = salesforceUpdateGuestRoomResponse;
    }

    public Object getSalesforceUpdateBookingResponse() {
        return salesforceUpdateBookingResponse;
    }

    public void setSalesforceUpdateBookingResponse(Object salesforceUpdateBookingResponse) {
        this.salesforceUpdateBookingResponse = salesforceUpdateBookingResponse;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            // Convert the response to JSON
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert the response to JSON", e);
        }
    }
}
