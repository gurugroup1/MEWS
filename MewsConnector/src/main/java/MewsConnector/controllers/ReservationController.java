package MewsConnector.controllers;

import MewsConnector.configurations.ApplicationConfiguration;
import MewsConnector.models.ReservationRequest;
import MewsConnector.models.ReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RestController
public class ReservationController {

    private final WebClient webClient;

    private final String API_URL;

    @Autowired
    private AuthController authController;

    public ReservationController(WebClient.Builder webClientBuilder, ApplicationConfiguration applicationConfiguration) {
        this.webClient = webClientBuilder.build();
        this.API_URL = applicationConfiguration.getApiUrl();
    }
    @GetMapping("/reservations")
    public ReservationResponse getReservation(ReservationRequest request) throws Exception {

        String constructedUrl = API_URL.concat(String.format("?hotel_id=%s&reservation_id=%s",
                request.getHotel_id(),
                request.getReservation_id()));
        return webClient.get()
                .uri(constructedUrl)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + authController.retrieveSalesforceTokenFromAWS().getAccess_token())
                .header("api-version", "2.0")
                .retrieve()
                .bodyToMono(ReservationResponse.class)
                .block();
    }


}