package middleware.controllers;

import middleware.configurations.ApplicationConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.amazonaws.services.secretsmanager.model.UpdateSecretRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/salesforce")
public class SecretKeyManagerController {

    private final ApplicationConfiguration applicationConfiguration;

    public SecretKeyManagerController(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @GetMapping("/credentials")
    public String getSalesforceCredentials() {
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
        GetSecretValueRequest request = new GetSecretValueRequest()
                .withSecretId(applicationConfiguration.getSalesforceCredentialsSecretName());
        GetSecretValueResult result = client.getSecretValue(request);
        return result.getSecretString();
    }

    @GetMapping("/token")
    public String getSalesforceToken() throws JsonProcessingException {
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                .build();
        GetSecretValueRequest request = new GetSecretValueRequest()
                .withSecretId(applicationConfiguration.getSalesforceTokenSecretName());
        GetSecretValueResult result = client.getSecretValue(request);
        return result.getSecretString();
    }

    @PutMapping("/token/update")
    public ResponseEntity<String> updateSalesforceToken(@RequestBody Map<String, Object> requestMap) {
        try {
            AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                    .withRegion(Regions.US_EAST_1)
                    .build();
            UpdateSecretRequest updateSecretRequest = new UpdateSecretRequest()
                    .withSecretId(applicationConfiguration.getSalesforceTokenSecretName())
                    .withSecretString(new ObjectMapper().writeValueAsString(requestMap));
            client.updateSecret(updateSecretRequest);
            return ResponseEntity.ok("Secret updated successfully.");
        } catch (Exception e) {
            // Return an error response if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating secret: " + e.getMessage());
        }
    }

    private boolean isSalesforceTokenExpired(String accessToken) {
        try {
            Jwt<Header, Claims> jwt = Jwts.parser().parse(accessToken);
            Instant expirationTime = Instant.ofEpochSecond(jwt.getBody().getExpiration().getTime() / 1000);
            Instant now = Instant.now();
            return now.isAfter(expirationTime);
        } catch (Exception e) {
            return true;
        }
    }
}
