package MewsConnector.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceReservationResponse {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("OwnerId")
    private String ownerId;

    @JsonProperty("IsDeleted")
    private Boolean isDeleted;

    @JsonProperty("Name")
    private String name;

    // You would have more fields here

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // You would have more getters and setters here
}

