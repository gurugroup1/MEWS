package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;
public class ReservationResponse implements Serializable {

    private List<Reservation> results;

    public List<Reservation> getResults() {
        return results;
    }

    public void setResults(List<Reservation> results) {
        this.results = results;
    }

    @JsonIgnore
    public String getAsJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this) ;
    }
}
