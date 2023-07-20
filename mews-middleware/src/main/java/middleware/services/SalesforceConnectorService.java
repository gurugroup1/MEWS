package middleware.services;

import com.fasterxml.jackson.databind.JsonNode;
import middleware.configurations.ApplicationConfiguration;
import middleware.models.SecretKeyAWS;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Objects;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class SalesforceConnectorService {
    private final ApplicationConfiguration applicationConfiguration;
    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;

    @Autowired
    public SalesforceConnectorService(ApplicationConfiguration applicationConfiguration, OkHttpClient httpClient) {
        this.applicationConfiguration = applicationConfiguration;
        this.objectMapper = new ObjectMapper();
        this.httpClient = httpClient;
    }

    public String getDataFromSalesforce(String object, String sfAccessToken, String bookingId) throws IOException {
        return executeGetSObject(object, sfAccessToken, bookingId);
    }

    public String getQueryDataFromSalesforce(String sfAccessToken, String bookingId, String object) throws IOException {
        return executeSalesforceQuery(sfAccessToken, bookingId,object);
    }

    public String executeSalesforceQuery(String token,String bookingId,String object) throws IOException {
        String url = "";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        if(Objects.equals(object, "Guest")){
            url = "https://postillion-hotels--postfull.sandbox.my.salesforce.com/services/data/v57.0/query/?q=SELECT+Id%2C+thn__Space_Area__c%2C+thn__Space_Area__r.thn__Mews_Id__c%2C+Rooms_amount__c%2C+thn__Unit_Price__c%2C+thn__Unit_Price_excl_Tax__c+FROM+thn__Quote_Hotel_Room__c+WHERE+thn__MYCE_Quote__c+%3D+%27" + bookingId + "%27";
        }
        if(Objects.equals(object, "PSM_Block")){
            url = "https://postillion-hotels--postfull.sandbox.my.salesforce.com/services/data/v57.0/query/?q=SELECT+id%2C+Name%2Cthn__PMSId__c%2Cthn__Rate__c%2Cthn__PMS_Release_Date_Time__c+from+thn__PMS_Block__c+where+thn__MYCE_Quote__c+%3D+'" + bookingId + "'";
        }
        if(Objects.equals(object, "PSM_Account")){
            url = "https://postillion-hotels--postfull.sandbox.my.salesforce.com/services/data/v57.0/query/?q=SELECT+id%2C+Name%2Cthn__PMSId__c%2Cthn__MYCE_Quote__c%2Cthn__Email__c%2Cthn__Phone__c+from+thn__PMS_Account__c+where+thn__MYCE_Quote__c+%3D+'" + bookingId + "'";
        }
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            String responseBody = calloutResponse.body().string();
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = parseErrorMessage(responseBody);
                throw new IOException(errorMessage);
            }
            return responseBody;
        }
    }

    public String setDataInSalesforce(String object, String sfAccessToken, String jsonBody) throws IOException {
        return executePostSObject(object, sfAccessToken, jsonBody);
    }

    public String updateDataInSalesforce(String object, String sfAccessToken, String jsonBody,String id) throws IOException {
        return executeUpdateSObject(object, sfAccessToken, jsonBody,id);
    }

    private String executeGetSObject(String object, String sfAccessToken, String bookingId) throws IOException {
        Request request = new Request.Builder()
                .url(String.format(applicationConfiguration.getSalesforceSObjectrUrlPrefix(), applicationConfiguration.getSalesforceSObjectUrl(), object + "/" + bookingId))
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + sfAccessToken)
                .build();

        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            String responseBody = calloutResponse.body().string();
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = parseErrorMessage(responseBody);
                throw new IOException(errorMessage);
            }
            return responseBody;
        }
    }

    private String executePostSObject(String object, String sfAccessToken, String jsonBody) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonBody);
        Request request = new Request.Builder()
                .url(String.format(applicationConfiguration.getSalesforceSObjectrUrlPrefix(),
                        applicationConfiguration.getSalesforceSObjectUrl(), object))
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + sfAccessToken)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String responseBody = response.body().string();
            if (!response.isSuccessful()) {
                String errorMessage = parseErrorMessage(responseBody);
                throw new IOException(errorMessage);
            }
            return responseBody;
        }
    }

    private String executeUpdateSObject(String object, String sfAccessToken, String jsonBody, String id) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonBody);
        Request request = new Request.Builder()
                .url(String.format(applicationConfiguration.getSalesforceSObjectrUrlPrefix(), applicationConfiguration.getSalesforceSObjectUrl(), object + "/" + id))
                .patch(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + sfAccessToken)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            String responseBody = response.body().string();
            if (!response.isSuccessful()) {
                String errorMessage = parseErrorMessage(responseBody);
                throw new IOException(errorMessage);
            }
            return responseBody;
        }
    }

    private String parseErrorMessage(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            String message = jsonNode.path("Message").asText();
            return message;
        } catch (IOException e) {
            LOGGER.error("Error parsing error message: " + e.getMessage());
            return "An error occurred while processing the request.";
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
