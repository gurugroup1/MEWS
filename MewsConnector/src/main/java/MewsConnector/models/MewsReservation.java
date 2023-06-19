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
    private UUID customerId;

    @JsonProperty("RequestedCategoryId")
    private UUID requestedCategoryId;

    @JsonProperty("RateId")
    private UUID rateId;

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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getRequestedCategoryId() {
        return requestedCategoryId;
    }

    public void setRequestedCategoryId(UUID requestedCategoryId) {
        this.requestedCategoryId = requestedCategoryId;
    }

    public UUID getRateId() {
        return rateId;
    }

    public void setRateId(UUID rateId) {
        this.rateId = rateId;
    }

    public List<MewsPersonCount> getMewsPersonCounts() {
        return mewsPersonCounts;
    }

    public void setMewsPersonCounts(List<MewsPersonCount> mewsPersonCounts) {
        this.mewsPersonCounts = mewsPersonCounts;
    }
}
