package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MewsReservation {

    @JsonProperty("StartUtc")
    private Date startUtc;

    @JsonProperty("EndUtc")
    private Date endUtc;

    @JsonProperty("CustomerId")
    private String customerId;

    @JsonProperty("RequestedCategoryId")
    private String requestedCategoryId;

    @JsonProperty("RateId")
    private String rateId;

    @JsonProperty("PersonCounts")
    private List<MewsPersonCount> mewsPersonCounts;

    public Date getStartUtc() {
        return startUtc;
    }

    public void setStartUtc(Date startUtc) {
        this.startUtc = startUtc;
    }

    public Date getEndUtc() {
        return endUtc;
    }

    public void setEndUtc(Date endUtc) {
        this.endUtc = endUtc;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRequestedCategoryId() {
        return requestedCategoryId;
    }

    public void setRequestedCategoryId(String requestedCategoryId) {
        this.requestedCategoryId = requestedCategoryId;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public List<MewsPersonCount> getMewsPersonCounts() {
        return mewsPersonCounts;
    }

    public void setMewsPersonCounts(List<MewsPersonCount> mewsPersonCounts) {
        this.mewsPersonCounts = mewsPersonCounts;
    }
}
