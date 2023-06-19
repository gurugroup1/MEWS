package MewsConnector.controllers;

import MewsConnector.configurations.ApplicationConfiguration;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@Controller
@RestController
public class SecretKeyManagerController {

    private ApplicationConfiguration applicationConfiguration;

    @GetMapping("/salesforce/credentials")
    public String getSalesforceCredentials() {
         return "{\"salesforceAuthUrl\":\"https://postillion-hotels--postfull.sandbox.my.salesforce.com/services/oauth2/token\",\"salesforceUsername\":\"interface@postillion.cloud.postfull\",\"salesforcePassword\":\"Welcome2023\",\"salesforceClientId\":\"3MVG9DMdJCij4PmHod5DlGRstr_2V36OMgmiew_8wSXSghX.9q8cuFW7uq93vaZmBpE.ge8nPaQh1vq9FasQM\",\"salesforceClientSecret\":\"2AC2E5DDEBAD06C0728F4AA67FD7C26FD244F31AF4083833BAA8154E770F8DD9\",\"salesforceGrantType\":\"password\"}\n";
    }

    @GetMapping("/salesforce/token")
    public String getSalesforceToken() throws JsonProcessingException {
        return "{\"access_token\":\"00D3X000004Vip4!AQUAQPcMnZy.jKL.DsKtCVs3WYLzNLEnJTOVJkMgg5vX5PiKSoVCfLK_1tC4WNBjlvLevWl8NaxKo7RVkRWlSf6hkVB3W7Id\",\"instance_url\":\"https://thdemo-dev-ed.my.salesforce.com\",\"id\":\"https://login.salesforce.com/id/00D3X000004Vip4UAC/0053X00000GiWcKQAV\",\"token_type\":\"Bearer\",\"issued_at\":\"1685017817987\",\"signature\":\"6GCS9RJDoPrSLpPH9pVMdDtnWYd2bMP6ZRiXffP7Kqg=\",\"created_at\":\"1685017493\",\"expires_in\":\"7200\"}\n";
    }

    @PutMapping("/salesforce/token/update")
    public ResponseEntity<String> updateSalesforceToken(@RequestBody Map<String, Object> requestMap) {
        try {
            AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
            UpdateSecretRequest updateSecretRequest = new UpdateSecretRequest()
                    .withSecretId(applicationConfiguration.getSalesforceTokenSecretName())
                    .withSecretString(new ObjectMapper().writeValueAsString(requestMap));
            client.updateSecret(updateSecretRequest);
            return ResponseEntity.ok("Secret updated successfully.");
        } catch (Exception e) {
            // Return an error response if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating secret: " + e.getMessage());
        }
    }

    private boolean isSalesforceTokenExpired(String accessToken) {
        try {
            Jwt<Header, Claims> jwt = Jwts.parser().parse(accessToken);
            Instant expirationTime = Instant.ofEpochSecond(jwt.getBody().getExpiration().getTime() / 1000);
            Instant now = Instant.now();
            return now.isAfter(expirationTime);
        } catch (Exception e) {
            // If there is an error parsing the JWT, treat the token as expired
            return true;
        }
    }

}
