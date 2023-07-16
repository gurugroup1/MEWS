package middleware.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import middleware.models.*;
import okhttp3.*;
import org.springframework.stereotype.Service;
import middleware.configurations.ApplicationConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Service
public class MewsConnectorService {
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final ApplicationConfiguration applicationConfiguration;

    private static final Logger LOGGER = LoggerFactory.getLogger(MewsConnectorService.class);

    public MewsConnectorService(ApplicationConfiguration applicationConfiguration, OkHttpClient httpClient) {
        this.applicationConfiguration = applicationConfiguration;
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper();
    }

    public String getRecordFromMews(Object request, String object) throws IOException {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(request);
        return executeGetRequest(jsonStr, object);
    }

    public String executeGetRequest(String jsonStr, String object) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url(applicationConfiguration.getMewsApiUrl() + "/" + object + "/getAll")
                .method("POST", RequestBody.create(mediaType, jsonStr))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + applicationConfiguration.getMewsAccessToken())
                .build();
        System.out.println("Request Body " + object + " : " + jsonStr);
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + calloutResponse.message();
                throw new IOException(errorMessage);
            }
            String responseBody = calloutResponse.body().string();
            System.out.println("Success Body " + object + " : " + responseBody);
            return responseBody;
        }
    }
    public String pushToMews(Object request, String object) throws IOException {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(request);
        return executePostRequest(jsonStr, object);
    }

    public String executePostRequest(String jsonStr, String object) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url(applicationConfiguration.getMewsApiUrl() + "/" + object + "/add")
                .method("POST", RequestBody.create(mediaType, jsonStr))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + applicationConfiguration.getMewsAccessToken())
                .build();
        System.out.println("Request Body " + object + " : " + jsonStr);
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + calloutResponse.message();
                throw new IOException(errorMessage);
            }
            String responseBody = calloutResponse.body().string();
            System.out.println("Success Body " + object + " : " + responseBody);
            return responseBody;
        }
    }

    public String updateToMews(Object request, String object) throws IOException {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(request);
        return executeUpdateRequest(jsonStr, object);
    }

    public String executeUpdateRequest(String jsonStr, String object) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url(applicationConfiguration.getMewsApiUrl() + "/" + object)
                .method("POST", RequestBody.create(mediaType, jsonStr))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + applicationConfiguration.getMewsAccessToken())
                .build();
        System.out.println("Request Body " + object + " : " + jsonStr);

        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + calloutResponse.message();
                throw new IOException(errorMessage);
            }

            String responseBody = calloutResponse.body().string();
            System.out.println("Success Body " + object + " : " + responseBody);

            if (responseBody == null || responseBody.trim().isEmpty()) {
                // Handle empty response body here
                System.out.println("Empty response body received");
                return null; // Or return any specific value that indicates empty response
            }

            if (responseBody.equals("{}")) {
                // Handle success with empty response body here
                System.out.println("Success with empty response body");
                return responseBody; // Or return any specific value for success with empty response
            }

            return responseBody;
        }
    }



}
