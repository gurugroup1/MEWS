package middleware.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.command.BookingCommand;
import middleware.command.Invoker;
import middleware.configurations.ApplicationConfiguration;
import middleware.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"${cross.origin}"}) //It's better to configure this in the application properties
@RestController
@RequestMapping("/mews")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final ApplicationContext context;
    private final ApplicationConfiguration applicationConfiguration;
    private final SalesforceConnectorService salesforceConnectorService;
    private final MewsConnectorService mewsConnectorService;
    private final MewsController mewsController;
    private final SecretKeyManagerController secretKeyManagerController;
    private final SalesforceController salesforceController;
    private final AuthController authController;
    private final ObjectMapper objectMapper;

    private final CacheService cacheService;

    private Invoker invoker;

    @Autowired
    public WebhookController(ApplicationContext context, SalesforceConnectorService salesforceConnectorService,
                             MewsConnectorService mewsConnectorService, SecretKeyManagerController secretKeyManagerController,
                             ApplicationConfiguration applicationConfiguration, ObjectMapper objectMapper, CacheService cacheService) {
        this.context = context;
        this.salesforceConnectorService = salesforceConnectorService;
        this.mewsConnectorService = mewsConnectorService;
        this.secretKeyManagerController = secretKeyManagerController;
        this.applicationConfiguration = applicationConfiguration;
        this.objectMapper = objectMapper;
        this.mewsController = new MewsController(this.mewsConnectorService,applicationConfiguration);
        this.salesforceController = new SalesforceController(applicationConfiguration, this.secretKeyManagerController, this.salesforceConnectorService);
        this.authController = new AuthController(applicationConfiguration, this.secretKeyManagerController, this.salesforceConnectorService);
        this.cacheService = cacheService;
    }

    @PostMapping("/booking/")
    public ApiResponse executeProcess(@RequestBody String requestBody) {
        invoker = new Invoker();
        invoker.setCommand(new BookingCommand(logger, applicationConfiguration, salesforceConnectorService, mewsConnectorService, mewsController, secretKeyManagerController, salesforceController, authController, objectMapper));
        return invoker.invoke(requestBody);
    }

}
