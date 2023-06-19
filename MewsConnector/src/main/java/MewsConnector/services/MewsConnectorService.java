package MewsConnector.services;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public MewsConnectorService(ApplicationConfiguration applicationConfiguration) {
        this.httpClient = new OkHttpClient.Builder().build();
        this.objectMapper = new ObjectMapper();
        this.applicationConfiguration = applicationConfiguration;
    }

    public String addReservation() {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            String requestBodyString = "{\n" +
                    "    \"Client\": \"Thynk 0.1\",\n" +
                    "    \"AccessToken\": \"0F5E505064BC49F1A209AEA0008C938A-24DFA25272C784034F9AD7E3685F4E4\",\n" +
                    "    \"ClientToken\": \"B0602874D5B945C0B12FADEC01068C88-C5ABFC221B4C8AF57C9192C5015A8CD\",\n" +
                    "    \"ServiceId\": \"2c65e490-8618-432e-b254-abd100d7ed6e\",\n" +
                    "    \"Reservations\": [\n" +
                    "        {\n" +
                    "            \"StartUtc\": \"2023-08-22T00:00:00Z\",\n" +
                    "            \"EndUtc\": \"2023-08-25T00:00:00Z\",\n" +
                    "            \"CustomerId\": \"359a6cd6-f3d0-46e6-b14e-b01f007f8c85\",\n" +
                    "            \"RequestedCategoryId\": \"d33a088a-b479-4b9c-ab51-abd100d7ede4\",\n" +
                    "            \"RateId\": \"bd870c5b-25c6-44c6-9959-acc200fbbd7c\",\n" +
                    "            \"PersonCounts\": [\n" +
                    "                {\n" +
                    "                    \"AgeCategoryId\": \"d0ea43d2-4c76-485c-97e4-ade30117ad9c\",\n" +
                    "                    \"Count\": 1\n" +
                    "                }\n" +
                    "            ]\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";

            Request request = new Request.Builder()
                    .url(String.format(applicationConfiguration.getMewsApiUrl() + "/reservations/add"))
                    .method("POST", RequestBody.create(mediaType, requestBodyString))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + getMewsAccessToken())
                    .build();

            System.out.println("Request URL: " + request.url());
            System.out.println("Request Headers: " + request.headers());
            System.out.println("Request Body: " + requestBodyString);

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
