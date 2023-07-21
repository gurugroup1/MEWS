package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SalesforceQueryResponse {

    @JsonProperty("totalSize")
    private int totalSize;

    @JsonProperty("done")
    private boolean done;



    @JsonProperty("records")
    private List<QuoteHotelRoom> records;

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

    public List<QuoteHotelRoom> getRecords() {
        return records;
    }

    public void setRecords(List<QuoteHotelRoom> records) {
        this.records = records;
    }

    // getters and setters

    public static class QuoteHotelRoom {

        @JsonProperty("Id")
        private String id;

        @JsonProperty("thn__Space_Area__c")
        private String spaceArea;

        @JsonProperty("thn__Space_Area__r")
        private SpaceArea spaceAreaDetails;

        @JsonProperty("Rooms_amount__c")
        private double roomsAmount;

        @JsonProperty("thn__Unit_Price__c")
        private double unitPrice;

        @JsonProperty("thn__Unit_Price_excl_Tax__c")
        private double unitPriceExclTax;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSpaceArea() {
            return spaceArea;
        }

        public void setSpaceArea(String spaceArea) {
            this.spaceArea = spaceArea;
        }

        public SpaceArea getSpaceAreaDetails() {
            return spaceAreaDetails;
        }

        public void setSpaceAreaDetails(SpaceArea spaceAreaDetails) {
            this.spaceAreaDetails = spaceAreaDetails;
        }

        public double getRoomsAmount() {
            return roomsAmount;
        }

        public void setRoomsAmount(double roomsAmount) {
            this.roomsAmount = roomsAmount;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public double getUnitPriceExclTax() {
            return unitPriceExclTax;
        }

        public void setUnitPriceExclTax(double unitPriceExclTax) {
            this.unitPriceExclTax = unitPriceExclTax;
        }

        // getters and setters
    }

    public static class SpaceArea {

        @JsonProperty("thn__Mews_Id__c")
        private String mewsId;

        public String getMewsId() {
            return mewsId;
        }

        public void setMewsId(String mewsId) {
            this.mewsId = mewsId;
        }

        // getters and setters
    }

    public static class Attributes {

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

        // getters and setters
    }
}