package middleware.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import middleware.models.*;
import okhttp3.*;
import org.springframework.stereotype.Service;
import middleware.configurations.ApplicationConfiguration;

import java.io.IOException;

@Service
public class MewsConnectorService {
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private ApplicationConfiguration applicationConfiguration;

    public MewsConnectorService() {
        this.httpClient = new OkHttpClient.Builder()
                .followRedirects(false)
                .build();
        this.objectMapper = new ObjectMapper();
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
                .addHeader("Authorization", "Bearer " + ApplicationConfiguration.getMewsAccessToken())
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
                .addHeader("Authorization", "Bearer " + ApplicationConfiguration.getMewsAccessToken())
                .build();
        System.out.println("Request Body " + object + " : " + jsonStr);
        try (Response calloutResponse = httpClient.newCall(request).execute()) {
            if (!calloutResponse.isSuccessful()) {
                String errorMessage = "Error in " + object + " call: " + calloutResponse.code() + " - " + calloutResponse.message();
                throw new IOException(errorMessage);
            }
            String responseBody = calloutResponse.body().string();
            System.out.println("Success Body " + object + " : " + responseBody);

            if (responseBody.isEmpty() || responseBody.equals("{}")) {
                // Handle empty response body here
                // You can throw a custom exception or handle it accordingly
                throw new IOException("Empty response body received");
            }

            return responseBody;
        }
    }


}
