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

    private Object rateResponse;
    private Object propertyResponse;

    public Object getContactResponse() {
        return contactResponse;
    }

    public void setContactResponse(Object contactResponse) {
        this.contactResponse = contactResponse;
    }

    private Object contactResponse;
    private Map<String, Object> data;

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

    public Map<String, Object> getData() {
        return data;
    }
}
