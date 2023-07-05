package middleware.services;

import middleware.configurations.ApplicationConfiguration;
import middleware.models.SecretKeyAWS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.*;
import org.jvnet.hk2.annotations.Service;

import java.io.IOException;

@Service
public class SalesforceConnectorService {
    private final ApplicationConfiguration applicationConfiguration;
    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;

    public SalesforceConnectorService(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
        this.objectMapper = new ObjectMapper();
        this.httpClient = new OkHttpClient.Builder().build();
    }

    public String getDataFromSalesforce(String object, String sfAccessToken, String bookingId) throws IOException {
        return executeGetSObject(object, sfAccessToken, bookingId);
    }

    private String executeGetSObject(String object, String sfAccessToken, String bookingId) throws IOException {
        Request request = new Request.Builder()
                .url(String.format(applicationConfiguration.getSalesforceSObjectrUrlPrefix(), applicationConfiguration.getSalesforceSObjectUrl(), object + "/" + bookingId))
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + sfAccessToken)
                .build();

        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                throw new IOException("Unexpected code " + calloutResponse);
            }
            return calloutResponse.body().string();
        }
    }

    public String getAccessTokenFromSalesforce(SecretKeyAWS secretKey) throws IOException {
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("username", secretKey.getSalesforceUsername())
                .addFormDataPart("password", secretKey.getSalesforcePassword())
                .addFormDataPart("client_id", secretKey.getSalesforceClientId())
                .addFormDataPart("client_secret", secretKey.getSalesforceClientSecret())
                .addFormDataPart("grant_type", secretKey.getSalesforceGrantType())
                .build();

        Request request = new Request.Builder()
                .url(secretKey.getSalesforceAuthUrl())
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", "BrowserId=toBvB9lOEe2pKCmuHLCFzA; CookieConsentPolicy=0:1; LSKey-c$CookieConsentPolicy=0:1")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                throw new IOException("Unexpected code " + calloutResponse);
            }
            return calloutResponse.body().string();
        }
    }
}
