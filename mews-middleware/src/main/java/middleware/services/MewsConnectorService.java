package middleware.services;

import com.fasterxml.jackson.databind.JsonNode;
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

    public String deleteRecordFromMews(Object request) throws IOException {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(request);
        return executeDeleteRequest(jsonStr);
    }

    public String executeDeleteRequest(String jsonStr) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url(applicationConfiguration.getMewsApiUrl() + "/" + "availabilityBlocks" + "/delete")
                .method("POST", RequestBody.create(mediaType, jsonStr))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + applicationConfiguration.getMewsAccessToken())
                .build();
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            String responseBody = calloutResponse.body().string();
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in  call: " + calloutResponse.code() + " - " + parseErrorMessage(responseBody);
                throw new IOException(errorMessage);
            }
            return responseBody;
        }
    }

    public String executeGetRequest(String jsonStr, String object) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder()
                .url(applicationConfiguration.getMewsApiUrl() + "/" + object + "/getAll")
                .method("POST", RequestBody.create(mediaType, jsonStr))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + applicationConfiguration.getMewsAccessToken())
                .build();
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + calloutResponse.message();
                throw new IOException(errorMessage);
            }
            String responseBody = calloutResponse.body().string();
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
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            String responseBody = calloutResponse.body().string();
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + parseErrorMessage(responseBody);
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
                System.out.println(jsonStr);

        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            String responseBody = calloutResponse.body().string();
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + parseErrorMessage(responseBody);
                throw new IOException(errorMessage);
            }
            if (responseBody == null || responseBody.trim().isEmpty()) {
                return null;
            }

            if (responseBody.equals("{}")) {
                System.out.println(responseBody);
                return responseBody;
            }
            return responseBody;
        }
    }



}
