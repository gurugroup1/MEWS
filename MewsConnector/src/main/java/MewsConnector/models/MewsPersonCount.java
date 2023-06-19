package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class MewsPersonCount {
    @JsonProperty("AgeCategoryId")
    private UUID AgeCategoryId;
    @JsonProperty("Count")
    private int Count;

    public UUID getAgeCategoryId() {
        return AgeCategoryId;
    }

    public void setAgeCategoryId(UUID ageCategoryId) {
        AgeCategoryId = ageCategoryId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
