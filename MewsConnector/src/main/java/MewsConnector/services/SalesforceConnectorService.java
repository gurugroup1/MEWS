package MewsConnector.services;


import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.SecretKeyAWS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.*;
import org.jvnet.hk2.annotations.Service;

import java.io.IOException;

@Service
public class SalesforceConnectorService {
    private ApplicationConfiguration applicationConfiguration;
    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;

    public SalesforceConnectorService() {
        this.objectMapper = new ObjectMapper();
        this.httpClient = new OkHttpClient.Builder().build();
    }

    public String getDataFromSalesforce(String object,String sfAccessToken, String bookingId) {
        try {
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            return executeGetSObject(object, sfAccessToken,bookingId);
        } catch (Exception e) {
            return String.format("{\"error\":\"error in response\", \"message\": \"%s\"}", e.getMessage());
        }
    }

    private String executeGetSObject(String object,String sfAccessToken, String bookingId) throws IOException {
        Request request = new Request.Builder()
                .url(String.format(applicationConfiguration.getSalesforceSObjectrUrlPrefix(), applicationConfiguration.getSalesforceSObjectUrl(), object +"/"+bookingId))
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


    public String getAccessTokenFromSalesforce(SecretKeyAWS secretKey) {
        try {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

