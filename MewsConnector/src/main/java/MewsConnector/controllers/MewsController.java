package MewsConnector.controllers;

import MewsConnector.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

public class MewsController {


    public MewsCompanyRequest createCompanyPayload(SalesforceBookingResponse booking,SalesforceAccountResponse account,SalesforceContactResponse contact) throws JsonProcessingException {

        MewsCompanyRequest mewsCompanyRequest = new MewsCompanyRequest();

        return mewsCompanyRequest;
    }
}