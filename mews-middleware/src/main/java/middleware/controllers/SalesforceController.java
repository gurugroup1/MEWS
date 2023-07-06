package middleware.controllers;

import middleware.configurations.ApplicationConfiguration;
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

    public String getRecordFromSalesforce(String object, String sfAccessToken, String bookingId) throws IOException {
        return salesforceConnectorService.getDataFromSalesforce(
                Objects.requireNonNull(object, "Salesforce Object must not be null"),
                Objects.requireNonNull(sfAccessToken, "Salesforce access token must not be null"),
                Objects.requireNonNull(bookingId, "Reference Id must not be null")
        );
    }
}
