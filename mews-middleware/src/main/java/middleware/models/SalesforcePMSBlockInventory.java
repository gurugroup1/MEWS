package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforcePMSBlockInventory {
    @JsonProperty("thn__PMS_Block__c")
    private String pmsBlock;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("thn__End__c")
    private String thnEnd;

    @JsonProperty("thn__Occupancy_1_Blocked__c")
    private String thnOccupancy1Blocked;

    @JsonProperty("thn__Occupancy_1_Pickedup__c")
    private String thnOccupancy1Pickedup;

    @JsonProperty("thn__Occupancy_2_Blocked__c")
    private String thnOccupancy2Blocked;

    @JsonProperty("thn__Occupancy_2_Pickedup__c")
    private String thnOccupancy2Pickedup;

    @JsonProperty("thn__Occupancy_3_Blocked__c")
    private String thnOccupancy3Blocked;

    @JsonProperty("thn__Occupancy_3_Pickedup__c")
    private String thnOccupancy3Pickedup;

    @JsonProperty("thn__Occupancy_4_Blocked__c")
    private String thnOccupancy4Blocked;

    @JsonProperty("thn__Occupancy_4_Pickedup__c")
    private String thnOccupancy4Pickedup;

    @JsonProperty("thn__RoomTypeCode__c")
    private String thnRoomTypeCode;

    @JsonProperty("thn__RoomType__c")
    private String thnRoomType;

    @JsonProperty("thn__Start__c")
    private String thnStart;

    @JsonProperty("thn__TotalBlocked__c")
    private String thnTotalBlocked;

    @JsonProperty("thn__TotalPickedUp__c")
    private String thnTotalPickedUp;

    @JsonProperty("thn__ZT_Inventory_Change__c")
    private boolean thnZTInventoryChange;

    @JsonProperty("thn__UniquePMSKey__c")
    private String thnUniquePMSKey;

    public String getPmsBlock() {
        return pmsBlock;
    }

    public void setPmsBlock(String pmsBlock) {
        this.pmsBlock = pmsBlock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThnEnd() {
        return thnEnd;
    }

    public void setThnEnd(String thnEnd) {
        this.thnEnd = thnEnd;
    }

    public String getThnOccupancy1Blocked() {
        return thnOccupancy1Blocked;
    }

    public void setThnOccupancy1Blocked(String thnOccupancy1Blocked) {
        this.thnOccupancy1Blocked = thnOccupancy1Blocked;
    }

    public String getThnOccupancy1Pickedup() {
        return thnOccupancy1Pickedup;
    }

    public void setThnOccupancy1Pickedup(String thnOccupancy1Pickedup) {
        this.thnOccupancy1Pickedup = thnOccupancy1Pickedup;
    }

    public String getThnOccupancy2Blocked() {
        return thnOccupancy2Blocked;
    }

    public void setThnOccupancy2Blocked(String thnOccupancy2Blocked) {
        this.thnOccupancy2Blocked = thnOccupancy2Blocked;
    }

    public String getThnOccupancy2Pickedup() {
        return thnOccupancy2Pickedup;
    }

    public void setThnOccupancy2Pickedup(String thnOccupancy2Pickedup) {
        this.thnOccupancy2Pickedup = thnOccupancy2Pickedup;
    }

    public String getThnOccupancy3Blocked() {
        return thnOccupancy3Blocked;
    }

    public void setThnOccupancy3Blocked(String thnOccupancy3Blocked) {
        this.thnOccupancy3Blocked = thnOccupancy3Blocked;
    }

    public String getThnOccupancy3Pickedup() {
        return thnOccupancy3Pickedup;
    }

    public void setThnOccupancy3Pickedup(String thnOccupancy3Pickedup) {
        this.thnOccupancy3Pickedup = thnOccupancy3Pickedup;
    }

    public String getThnOccupancy4Blocked() {
        return thnOccupancy4Blocked;
    }

    public void setThnOccupancy4Blocked(String thnOccupancy4Blocked) {
        this.thnOccupancy4Blocked = thnOccupancy4Blocked;
    }

    public String getThnOccupancy4Pickedup() {
        return thnOccupancy4Pickedup;
    }

    public void setThnOccupancy4Pickedup(String thnOccupancy4Pickedup) {
        this.thnOccupancy4Pickedup = thnOccupancy4Pickedup;
    }

    public String getThnRoomTypeCode() {
        return thnRoomTypeCode;
    }

    public void setThnRoomTypeCode(String thnRoomTypeCode) {
        this.thnRoomTypeCode = thnRoomTypeCode;
    }

    public String getThnRoomType() {
        return thnRoomType;
    }

    public void setThnRoomType(String thnRoomType) {
        this.thnRoomType = thnRoomType;
    }

    public String getThnStart() {
        return thnStart;
    }

    public void setThnStart(String thnStart) {
        this.thnStart = thnStart;
    }

    public String getThnTotalBlocked() {
        return thnTotalBlocked;
    }

    public void setThnTotalBlocked(String thnTotalBlocked) {
        this.thnTotalBlocked = thnTotalBlocked;
    }

    public String getThnTotalPickedUp() {
        return thnTotalPickedUp;
    }

    public void setThnTotalPickedUp(String thnTotalPickedUp) {
        this.thnTotalPickedUp = thnTotalPickedUp;
    }

    public boolean isThnZTInventoryChange() {
        return thnZTInventoryChange;
    }

    public void setThnZTInventoryChange(boolean thnZTInventoryChange) {
        this.thnZTInventoryChange = thnZTInventoryChange;
    }

    public String getThnUniquePMSKey() {
        return thnUniquePMSKey;
    }

    public void setThnUniquePMSKey(String thnUniquePMSKey) {
        this.thnUniquePMSKey = thnUniquePMSKey;
    }
}
