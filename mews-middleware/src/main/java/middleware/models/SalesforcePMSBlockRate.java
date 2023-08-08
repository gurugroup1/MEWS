package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforcePMSBlockRate {
    @JsonProperty("thn__PMS_Block__c")
    private String pmsBlock;

    @JsonProperty("thn__AdditionalAdultPrice__c")
    private String additionalAdultPrice;

    @JsonProperty("thn__AdditionalGuestPrice__c")
    private String additionalGuestPrice;

    @JsonProperty("thn__End__c")
    private String end;

    @JsonProperty("thn__Occupancy_1_price__c")
    private Double occupancy1Price;

    @JsonProperty("thn__Occupancy_2_price__c")
    private Double occupancy2Price;

    @JsonProperty("thn__Occupancy_3_price__c")
    private Double occupancy3Price;

    @JsonProperty("thn__Occupancy_4_price__c")
    private Double occupancy4Price;

    @JsonProperty("thn__Rate__c")
    private String rate;

    @JsonProperty("thn__RateCode__c")
    private String rateCode;

    @JsonProperty("thn__RoomType__c")
    private String roomType;

    @JsonProperty("thn__RoomTypeCode__c")
    private String roomTypeCode;

    @JsonProperty("thn__Start__c")
    private String start;

    public String getPmsBlock() {
        return pmsBlock;
    }

    public void setPmsBlock(String pmsBlock) {
        this.pmsBlock = pmsBlock;
    }

    public String getAdditionalAdultPrice() {
        return additionalAdultPrice;
    }

    public void setAdditionalAdultPrice(String additionalAdultPrice) {
        this.additionalAdultPrice = additionalAdultPrice;
    }

    public String getAdditionalGuestPrice() {
        return additionalGuestPrice;
    }

    public void setAdditionalGuestPrice(String additionalGuestPrice) {
        this.additionalGuestPrice = additionalGuestPrice;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Double getOccupancy1Price() {
        return occupancy1Price;
    }

    public void setOccupancy1Price(Double occupancy1Price) {
        this.occupancy1Price = occupancy1Price;
    }

    public Double getOccupancy2Price() {
        return occupancy2Price;
    }

    public void setOccupancy2Price(Double occupancy2Price) {
        this.occupancy2Price = occupancy2Price;
    }

    public Double getOccupancy3Price() {
        return occupancy3Price;
    }

    public void setOccupancy3Price(Double occupancy3Price) {
        this.occupancy3Price = occupancy3Price;
    }

    public Double getOccupancy4Price() {
        return occupancy4Price;
    }

    public void setOccupancy4Price(Double occupancy4Price) {
        this.occupancy4Price = occupancy4Price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
