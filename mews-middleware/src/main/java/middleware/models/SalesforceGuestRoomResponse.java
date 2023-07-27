package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceGuestRoomResponse {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("thn__Space_Area__c")
    private String spaceArea;

    @JsonProperty("Rooms_amount__c")
    private int roomsAmount;

    @JsonProperty("thn__Unit_Price__c")
    private double unitPrice;

    @JsonProperty("thn__Unit_Price_excl_Tax__c")
    private double unitPriceExclTax;

    @JsonProperty("thn__Space_Area__r")
    private SpaceArea spaceAreaDetails;

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

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
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

    public SpaceArea getSpaceAreaDetails() {
        return spaceAreaDetails;
    }

    public void setSpaceAreaDetails(SpaceArea spaceAreaDetails) {
        this.spaceAreaDetails = spaceAreaDetails;
    }

    // Constructors, getters, and setters (if not already present)

    public static class SpaceArea {
        @JsonProperty("Id")
        public String id;

        @JsonProperty("thn__Mews_Id__c")
        public String mewsId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMewsId() {
            return mewsId;
        }

        public void setMewsId(String mewsId) {
            this.mewsId = mewsId;
        }

        // Constructors, getters, and setters (if not already present)
    }
}
