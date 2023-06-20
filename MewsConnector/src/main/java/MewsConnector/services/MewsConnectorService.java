package MewsConnector.services;

import MewsConnector.models.MewsReservationRequest;
import MewsConnector.models.MewsReservationResponse;
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

    public String pushReservationsToMews(MewsReservationRequest request) {
        try {
            ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
            String jsonStr = ow.writeValueAsString(request);
            return executePostRequest(jsonStr);
        } catch (Exception e) {
            return String.format("{\"error\":\"error in response\", \"message\": \"%s\"}", e.getMessage());
        }
    }

    public String executePostRequest(String jsonStr) throws IOException {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            String requestBodyString = jsonStr;
            System.out.println("Response Code: " + jsonStr);
            Request request = new Request.Builder()
                    .url(String.format(applicationConfiguration.getMewsApiUrl() + "/reservations/add"))
                    .method("POST", RequestBody.create(mediaType, requestBodyString))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + getMewsAccessToken())
                    .build();
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .followRedirects(false)
                    .build();

            try (Response calloutResponse = httpClient.newCall(request).execute()) {
                System.out.println("Response Code: " + calloutResponse.code());
                System.out.println("Response Body: " + calloutResponse.body().string());

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
