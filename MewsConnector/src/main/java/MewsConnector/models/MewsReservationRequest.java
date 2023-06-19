package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.UUID;
public class MewsReservationRequest {
    @JsonProperty("Client")
    private String client;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("ClientToken")
    private String clientToken;

    @JsonProperty("ServiceId")
    private UUID serviceId;

    @JsonProperty("MewsReservationRequest")
    private List<MewsReservationRequest> mewsReservationRequest;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }

    public List<MewsReservationRequest> getMewsReservationRequest() {
        return mewsReservationRequest;
    }

    public void setMewsReservationRequest(List<MewsReservationRequest> mewsReservationRequest) {
        this.mewsReservationRequest = mewsReservationRequest;
    }
}
