package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceGetPMSBlockResponse {
    @JsonProperty("totalSize")
    private int totalSize;

    @JsonProperty("done")
    private boolean done;

    @JsonProperty("records")
    private List<BookingDetailsRecord> records;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<BookingDetailsRecord> getRecords() {
        return records;
    }

    public void setRecords(List<BookingDetailsRecord> records) {
        this.records = records;
    }

    // Getters and setters


@JsonIgnoreProperties(ignoreUnknown = true)
public static class BookingDetailsRecord {
    @JsonProperty("attributes")
    private BookingAttributes attributes;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("thn__PMSId__c")
    private String pmsId;

    @JsonProperty("thn__Rate__c")
    private String rate;

    @JsonProperty("thn__PMS_Release_Date_Time__c")
    private String releaseDateTime;

    public BookingAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(BookingAttributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPmsId() {
        return pmsId;
    }

    public void setPmsId(String pmsId) {
        this.pmsId = pmsId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(String releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }

    // Getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
public static class BookingAttributes {
    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Getters and setters
}
}