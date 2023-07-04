package middleware.controllers;

import middleware.configurations.ApplicationConfiguration;
import middleware.models.SalesforceTokenResponse;
import middleware.models.SecretKeyAWS;
import middleware.services.SalesforceConnectorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@ResponseBody
public class AuthController {

    private final ApplicationConfiguration applicationConfiguration;
    private final SecretKeyManagerController secretKeyManagerController;
    private final SalesforceConnectorService salesforceConnectorService;

    @Autowired
    public AuthController(
            ApplicationConfiguration applicationConfiguration, SecretKeyManagerController secretKeyManagerController,
            SalesforceConnectorService salesforceConnectorService
    ) {
        this.applicationConfiguration = applicationConfiguration;
        this.secretKeyManagerController = secretKeyManagerController;
        this.salesforceConnectorService = salesforceConnectorService;
    }

    @GetMapping(value = "/salesforce/token")
    public SalesforceTokenResponse retrieveSalesforceTokenFromAWS() throws Exception {
        String secretKey = this.secretKeyManagerController.getSalesforceCredentials();
        ObjectMapper objectMapper = new ObjectMapper();
        SecretKeyAWS secretKeyAWS = objectMapper.readValue(secretKey, SecretKeyAWS.class);

        String salesforceToken = this.secretKeyManagerController.getSalesforceToken();
        if (isTokenExpired(salesforceToken)) {
            String newToken = this.salesforceConnectorService.getAccessTokenFromSalesforce(secretKeyAWS);
            SalesforceTokenResponse salesforceTokenResponse = generateSalesforceTokenResponse(newToken);
            updateSalesforceTokenInAws(salesforceTokenResponse);
            return salesforceTokenResponse;
        } else {
            return generateSalesforceTokenResponse(salesforceToken);
        }
    }

    private SalesforceTokenResponse generateSalesforceTokenResponse(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        SalesforceTokenResponse salesforceTokenResponse = new SalesforceTokenResponse();
        salesforceTokenResponse.setAccess_token(json.getString("access_token"));
        salesforceTokenResponse.setInstance_url(json.getString("instance_url"));
        salesforceTokenResponse.setId(json.getString("id"));
        salesforceTokenResponse.setToken_type(json.getString("token_type"));
        salesforceTokenResponse.setIssued_at(json.getString("issued_at"));
        salesforceTokenResponse.setSignature(json.getString("signature"));
        return salesforceTokenResponse;
    }

    private void updateSalesforceTokenInAws(SalesforceTokenResponse salesforceTokenResponse) {
        try {
            Map<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("access_token", salesforceTokenResponse.getAccess_token());
            tokenMap.put("token_type", salesforceTokenResponse.getToken_type());
            tokenMap.put("id", salesforceTokenResponse.getId());
            tokenMap.put("instance_url", salesforceTokenResponse.getInstance_url());
            tokenMap.put("signature", salesforceTokenResponse.getSignature());
            tokenMap.put("issued_at", salesforceTokenResponse.getIssued_at());

            // Set the created_at timestamp to the current Unix epoch timestamp
            long createdAt = Instant.now().getEpochSecond();
            salesforceTokenResponse.setCreated_at(createdAt);

            // Set the expires_in value to 2 hours from now
            long expiresIn = 2 * 60 * 60; // 2 hours in seconds
            salesforceTokenResponse.setExpires_in(expiresIn);
            tokenMap.put("expires_in", salesforceTokenResponse.getExpires_in());
            tokenMap.put("created_at", salesforceTokenResponse.getCreated_at());

            secretKeyManagerController.updateSalesforceToken(tokenMap);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update Salesforce token in AWS.", e);
        }
    }

    private boolean isTokenExpired(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        long createdAt = json.getLong("created_at");
        long expiresIn = json.getLong("expires_in");
        long expirationTime = createdAt + expiresIn;
        long currentTime = System.currentTimeMillis() / 1000L;

        return expirationTime <= currentTime;
    }
}
