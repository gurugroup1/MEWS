package MewsConnector.controllers;


import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.services.SalesforceConnectorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class SalesforceController {

    private final Logger logger = LoggerFactory.getLogger(SalesforceController.class);
    private ApplicationConfiguration applicationConfiguration;
    private final SecretKeyManagerController secretKeyManagerController;
    private final SalesforceConnectorService salesforceConnectorService;

    @Autowired
    public SalesforceController(SecretKeyManagerController secretKeyManagerController, SalesforceConnectorService salesforceConnectorService) {
        this.secretKeyManagerController = Objects.requireNonNull(secretKeyManagerController, "Secret key manager controller must not be null");
        this.salesforceConnectorService = Objects.requireNonNull(salesforceConnectorService, "Salesforce connector service must not be null");
    }

    public String getBookingFromSalesforce(String object,String sfAccessToken, String bookingId) throws JsonProcessingException {
        return salesforceConnectorService.getBookingFromSalesforce(
                Objects.requireNonNull(object, "Salesforce Object must not be null"),
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Booking Id must not be null")
        );
    }
}