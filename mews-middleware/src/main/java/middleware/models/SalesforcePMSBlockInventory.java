package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforcePMSBlockInventory {
    @JsonProperty("thn__PMS_Block__c")
    private String pmsBlock;

    public String getPmsBlock() {
        return pmsBlock;
    }

    public void setPmsBlock(String pmsBlock) {
        this.pmsBlock = pmsBlock;
    }

}

