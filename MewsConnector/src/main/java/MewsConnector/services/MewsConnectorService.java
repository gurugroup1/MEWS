package MewsConnector.services;

import MewsConnector.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.*;
import org.springframework.stereotype.Service;
import MewsConnector.configurations.ApplicationConfiguration;
import java.io.IOException;
import static MewsConnector.configurations.ApplicationConfiguration.getMewsAccessToken;

@Service
public class MewsConnectorService {
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private ApplicationConfiguration applicationConfiguration;

    public MewsConnectorService() {
        this.httpClient = new OkHttpClient.Builder().build();
        this.objectMapper = new ObjectMapper();
    }

    public String pushCompanyToMews(MewsCompanyRequest request) {
        try {
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            String jsonStr = ow.writeValueAsString(request);
            return executePostRequest(jsonStr,"companies");
        } catch (Exception e) {
            return String.format("{\"error\":\"error in response\", \"message\": \"%s\"}", e.getMessage());
        }
    }

    public String pushBookerToMews(MewsBookerRequest request) {
        try {
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            String jsonStr = ow.writeValueAsString(request);
            return executePostRequest(jsonStr,"customers");
        } catch (Exception e) {
            return String.format("{\"error\":\"error in response\", \"message\": \"%s\"}", e.getMessage());
        }
    }

    public String pushAvailabilityBlockerToMews(MewsAvailabilityBlockRequest request) {
        try {
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            String jsonStr = ow.writeValueAsString(request);
            return executePostRequest(jsonStr,"availabilityBlocks");
        } catch (Exception e) {
            return String.format("{\"error\":\"error in response\", \"message\": \"%s\"}", e.getMessage());
        }
    }

    public String executePostRequest(String jsonStr,String object) throws IOException {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            Request request = new Request.Builder()
                    .url(String.format(applicationConfiguration.getMewsApiUrl() + "/"+object+"/add"))
                    .method("POST", RequestBody.create(mediaType, jsonStr))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + getMewsAccessToken())
                    .build();
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .followRedirects(false)
                    .build();
                System.out.println("Request Body " + object + " : " + jsonStr);
            try (Response calloutResponse = httpClient.newCall(request).execute()) {
                if (!calloutResponse.isSuccessful()) {
                    throw new IOException("Unexpected code " + calloutResponse);
                }
                System.out.println("Success Body " + object + " : " + calloutResponse.body().string());
                return calloutResponse.body().string();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
