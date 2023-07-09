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
import java.util.Objects;

@RestController
public class SalesforceController {

    private final Logger logger = LoggerFactory.getLogger(SalesforceController.class);
    private final ApplicationConfiguration applicationConfiguration;
    private final SecretKeyManagerController secretKeyManagerController;
    private final SalesforceConnectorService salesforceConnectorService;

    @Autowired
    public SalesforceController(ApplicationConfiguration applicationConfiguration, SecretKeyManagerController secretKeyManagerController, SalesforceConnectorService salesforceConnectorService) {
        this.applicationConfiguration = Objects.requireNonNull(applicationConfiguration, "Application configuration must not be null");
        this.secretKeyManagerController = Objects.requireNonNull(secretKeyManagerController, "Secret key manager controller must not be null");
        this.salesforceConnectorService = Objects.requireNonNull(salesforceConnectorService, "Salesforce connector service must not be null");
    }

    public SalesforceBookingRequest createBookingPayload() throws JsonProcessingException {
        SalesforceBookingRequest payload = new SalesforceBookingRequest();
        payload.setName("Booking Testing Name");
        return payload;
    }

    public PSMAccountRequest createPSMAccountPayload() throws JsonProcessingException {
        PSMAccountRequest payload = new PSMAccountRequest();
        payload.setName("Testing Account 1");
        return payload;
    }

    public SalesforceGuestRequest createGuestBookerPayload() throws JsonProcessingException {
        SalesforceGuestRequest payload = new SalesforceGuestRequest();
        payload.setFirstName("New test 123");
        return payload;
    }

    public SalesforcePSMBlockRequest createPMSBlockPayload() throws JsonProcessingException {
        SalesforcePSMBlockRequest payload = new SalesforcePSMBlockRequest();
        payload.setName("New test 123");
        return payload;
    }

    public SalesforcePMSBlockInventory createMewsBlockInventoryPayload() throws JsonProcessingException {
        SalesforcePMSBlockInventory payload = new SalesforcePMSBlockInventory();
        payload.setPmsBlock("a1kFg000000xTdtIAE");
        return payload;
    }

    public SalesforcePMSBlockRate createPMSBlockRatesPayload() throws JsonProcessingException {
        SalesforcePMSBlockRate payload = new SalesforcePMSBlockRate();
        payload.setPmsBlock("a1kFg000000xTdtIAE");
        return payload;
    }

    public String getRecordFromSalesforce(String object, String sfAccessToken, String bookingId) throws IOException {
        return salesforceConnectorService.getDataFromSalesforce(
                Objects.requireNonNull(object, "Salesforce Object must not be null"),
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Reference Id must not be null")
        );
    }

    public String addRecordInSalesforce(String object, String sfAccessToken,String request) throws IOException {
        return salesforceConnectorService.setDataInSalesforce(object,sfAccessToken,request);
    }

    public String updateRecordInSalesforce(String object, String sfAccessToken,String request,String Id) throws IOException {
        return salesforceConnectorService.updateDataInSalesforce(object,sfAccessToken,request,Id);
    }
}
