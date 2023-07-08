package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforcePSMBlockRequest {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("CurrencyIsoCode")
    private String currencyIsoCode;

    @JsonProperty("thn__MYCE_Quote__c")
    private String myceQuote;

    @JsonProperty("thn__PMSId__c")
    private String pmsId;

    @JsonProperty("thn__PMS_Block_End_Time__c")
    private String pmsBlockEndTime;

    @JsonProperty("thn__PMS_Block_Start_Time__c")
    private String pmsBlockStartTime;

    @JsonProperty("thn__PMS_Release_Date_Time__c")
    private String pmsReleaseDateTime;

    @JsonProperty("thn__PMS_Response__c")
    private String pmsResponse;

    @JsonProperty("thn__PMS_Response_date_time__c")
    private String pmsResponseDateTime;

    @JsonProperty("thn__PMS_Status__c")
    private String pmsStatus;

    @JsonProperty("thn__Rate__c")
    private String rate;

    @JsonProperty("thn__Status__c")
    private String status;

    @JsonProperty("thn__AbsoluteCutoffDate__c")
    private String absoluteCutoffDate;

    @JsonProperty("thn__CancellationReasonCode__c")
    private String cancellationReasonCode;

    @JsonProperty("thn__CancellationReasonText__c")
    private String cancellationReasonText;

    @JsonProperty("thn__Code__c")
    private String code;

    @JsonProperty("thn__CreatedDateTime__c")
    private String createdDateTime;

    @JsonProperty("thn__CurrencyCode__c")
    private String currencyCode;

    @JsonProperty("thn__CurrencyPrecision__c")
    private String currencyPrecision;

    @JsonProperty("thn__EndShoulderDate__c")
    private String endShoulderDate;

    @JsonProperty("thn__End__c")
    private String end;

    @JsonProperty("thn__GuaranteeCode__c")
    private String guaranteeCode;

    @JsonProperty("thn__HapiId__c")
    private String hapiId;

    @JsonProperty("thn__InventoryBlockType__c")
    private String inventoryBlockType;

    @JsonProperty("thn__PMSAccountCompany__c")
    private String pmsAccountCompany;

    @JsonProperty("thn__PMSAccountGroup__c")
    private String pmsAccountGroup;

    @JsonProperty("thn__PMSAccountSource__c")
    private String pmsAccountSource;

    @JsonProperty("thn__PMSAccountTravelAgent__c")
    private String pmsAccountTravelAgent;

    @JsonProperty("thn__PMSSystemId__c")
    private String pmsSystemId;

    @JsonProperty("thn__PMSSystemType__c")
    private String pmsSystemType;

    @JsonProperty("thn__PMS_Block_Status__c")
    private String pmsBlockStatus;

    @JsonProperty("thn__PaymentMethodCode__c")
    private String paymentMethodCode;

    @JsonProperty("thn__PropertyDetailsBrandCode__c")
    private String propertyDetailsBrandCode;

    @JsonProperty("thn__PropertyDetailsChainCode__c")
    private String propertyDetailsChainCode;

    @JsonProperty("thn__PropertyDetailsCode__c")
    private String propertyDetailsCode;

    @JsonProperty("thn__PropertyDetailsId__c")
    private String propertyDetailsId;

    @JsonProperty("thn__ReleaseDaysBeforeStayDate__c")
    private String releaseDaysBeforeStayDate;

    @JsonProperty("thn__ReservationPickUpMethod__c")
    private String reservationPickUpMethod;

    @JsonProperty("thn__SegmentationChannel__c")
    private String segmentationChannel;

    @JsonProperty("thn__SegmentationMarket__c")
    private String segmentationMarket;

    @JsonProperty("thn__SegmentationOrigin__c")
    private String segmentationOrigin;

    @JsonProperty("thn__SegmentationSource__c")
    private String segmentationSource;

    @JsonProperty("thn__SendToPms__c")
    private boolean sendToPms;

    @JsonProperty("thn__StartShoulderDate__c")
    private String startShoulderDate;

    @JsonProperty("thn__Start__c")
    private String start;

    @JsonProperty("thn__Type__c")
    private String type;

    @JsonProperty("thn__UniquePMSKey__c")
    private String uniquePMSKey;

    @JsonProperty("thn__Sync_Status__c")
    private String syncStatus;

    @JsonProperty("thn__Property__c")
    private String property;

    @JsonProperty("thn__Block_Status__c")
    private String blockStatus;

    @JsonProperty("thn__Guarantee_Code__c")
    private String guaranteeCode2;

    @JsonProperty("thn__Send_Failed_PMS_Block__c")
    private boolean sendFailedPMSBlock;

    @JsonProperty("thn__Booker__c")
    private String booker;

    @JsonProperty("thn__Country__c")
    private String country;

    @JsonProperty("thn__Email__c")
    private String email;

    @JsonProperty("thn__First_Name__c")
    private String firstName;

    @JsonProperty("thn__Last_Name__c")
    private String lastName;

    @JsonProperty("thn__Nationality__c")
    private String nationality;

    @JsonProperty("thn__Phone__c")
    private String phone;

    @JsonProperty("thn__Posting_Account_Id__c")
    private String postingAccountId;

    @JsonProperty("thn__Reservation_Type_Code__c")
    private String reservationTypeCode;

    @JsonProperty("thn__SegmentationCode__c")
    private String segmentationCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getMyceQuote() {
        return myceQuote;
    }

    public void setMyceQuote(String myceQuote) {
        this.myceQuote = myceQuote;
    }

    public String getPmsId() {
        return pmsId;
    }

    public void setPmsId(String pmsId) {
        this.pmsId = pmsId;
    }

    public String getPmsBlockEndTime() {
        return pmsBlockEndTime;
    }

    public void setPmsBlockEndTime(String pmsBlockEndTime) {
        this.pmsBlockEndTime = pmsBlockEndTime;
    }

    public String getPmsBlockStartTime() {
        return pmsBlockStartTime;
    }

    public void setPmsBlockStartTime(String pmsBlockStartTime) {
        this.pmsBlockStartTime = pmsBlockStartTime;
    }

    public String getPmsReleaseDateTime() {
        return pmsReleaseDateTime;
    }

    public void setPmsReleaseDateTime(String pmsReleaseDateTime) {
        this.pmsReleaseDateTime = pmsReleaseDateTime;
    }

    public String getPmsResponse() {
        return pmsResponse;
    }

    public void setPmsResponse(String pmsResponse) {
        this.pmsResponse = pmsResponse;
    }

    public String getPmsResponseDateTime() {
        return pmsResponseDateTime;
    }

    public void setPmsResponseDateTime(String pmsResponseDateTime) {
        this.pmsResponseDateTime = pmsResponseDateTime;
    }

    public String getPmsStatus() {
        return pmsStatus;
    }

    public void setPmsStatus(String pmsStatus) {
        this.pmsStatus = pmsStatus;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAbsoluteCutoffDate() {
        return absoluteCutoffDate;
    }

    public void setAbsoluteCutoffDate(String absoluteCutoffDate) {
        this.absoluteCutoffDate = absoluteCutoffDate;
    }

    public String getCancellationReasonCode() {
        return cancellationReasonCode;
    }

    public void setCancellationReasonCode(String cancellationReasonCode) {
        this.cancellationReasonCode = cancellationReasonCode;
    }

    public String getCancellationReasonText() {
        return cancellationReasonText;
    }

    public void setCancellationReasonText(String cancellationReasonText) {
        this.cancellationReasonText = cancellationReasonText;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyPrecision() {
        return currencyPrecision;
    }

    public void setCurrencyPrecision(String currencyPrecision) {
        this.currencyPrecision = currencyPrecision;
    }

    public String getEndShoulderDate() {
        return endShoulderDate;
    }

    public void setEndShoulderDate(String endShoulderDate) {
        this.endShoulderDate = endShoulderDate;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getGuaranteeCode() {
        return guaranteeCode;
    }

    public void setGuaranteeCode(String guaranteeCode) {
        this.guaranteeCode = guaranteeCode;
    }

    public String getHapiId() {
        return hapiId;
    }

    public void setHapiId(String hapiId) {
        this.hapiId = hapiId;
    }

    public String getInventoryBlockType() {
        return inventoryBlockType;
    }

    public void setInventoryBlockType(String inventoryBlockType) {
        this.inventoryBlockType = inventoryBlockType;
    }

    public String getPmsAccountCompany() {
        return pmsAccountCompany;
    }

    public void setPmsAccountCompany(String pmsAccountCompany) {
        this.pmsAccountCompany = pmsAccountCompany;
    }

    public String getPmsAccountGroup() {
        return pmsAccountGroup;
    }

    public void setPmsAccountGroup(String pmsAccountGroup) {
        this.pmsAccountGroup = pmsAccountGroup;
    }

    public String getPmsAccountSource() {
        return pmsAccountSource;
    }

    public void setPmsAccountSource(String pmsAccountSource) {
        this.pmsAccountSource = pmsAccountSource;
    }

    public String getPmsAccountTravelAgent() {
        return pmsAccountTravelAgent;
    }

    public void setPmsAccountTravelAgent(String pmsAccountTravelAgent) {
        this.pmsAccountTravelAgent = pmsAccountTravelAgent;
    }

    public String getPmsSystemId() {
        return pmsSystemId;
    }

    public void setPmsSystemId(String pmsSystemId) {
        this.pmsSystemId = pmsSystemId;
    }

    public String getPmsSystemType() {
        return pmsSystemType;
    }

    public void setPmsSystemType(String pmsSystemType) {
        this.pmsSystemType = pmsSystemType;
    }

    public String getPmsBlockStatus() {
        return pmsBlockStatus;
    }

    public void setPmsBlockStatus(String pmsBlockStatus) {
        this.pmsBlockStatus = pmsBlockStatus;
    }

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getPropertyDetailsBrandCode() {
        return propertyDetailsBrandCode;
    }

    public void setPropertyDetailsBrandCode(String propertyDetailsBrandCode) {
        this.propertyDetailsBrandCode = propertyDetailsBrandCode;
    }

    public String getPropertyDetailsChainCode() {
        return propertyDetailsChainCode;
    }

    public void setPropertyDetailsChainCode(String propertyDetailsChainCode) {
        this.propertyDetailsChainCode = propertyDetailsChainCode;
    }

    public String getPropertyDetailsCode() {
        return propertyDetailsCode;
    }

    public void setPropertyDetailsCode(String propertyDetailsCode) {
        this.propertyDetailsCode = propertyDetailsCode;
    }

    public String getPropertyDetailsId() {
        return propertyDetailsId;
    }

    public void setPropertyDetailsId(String propertyDetailsId) {
        this.propertyDetailsId = propertyDetailsId;
    }

    public String getReleaseDaysBeforeStayDate() {
        return releaseDaysBeforeStayDate;
    }

    public void setReleaseDaysBeforeStayDate(String releaseDaysBeforeStayDate) {
        this.releaseDaysBeforeStayDate = releaseDaysBeforeStayDate;
    }

    public String getReservationPickUpMethod() {
        return reservationPickUpMethod;
    }

    public void setReservationPickUpMethod(String reservationPickUpMethod) {
        this.reservationPickUpMethod = reservationPickUpMethod;
    }

    public String getSegmentationChannel() {
        return segmentationChannel;
    }

    public void setSegmentationChannel(String segmentationChannel) {
        this.segmentationChannel = segmentationChannel;
    }

    public String getSegmentationMarket() {
        return segmentationMarket;
    }

    public void setSegmentationMarket(String segmentationMarket) {
        this.segmentationMarket = segmentationMarket;
    }

    public String getSegmentationOrigin() {
        return segmentationOrigin;
    }

    public void setSegmentationOrigin(String segmentationOrigin) {
        this.segmentationOrigin = segmentationOrigin;
    }

    public String getSegmentationSource() {
        return segmentationSource;
    }

    public void setSegmentationSource(String segmentationSource) {
        this.segmentationSource = segmentationSource;
    }

    public boolean isSendToPms() {
        return sendToPms;
    }

    public void setSendToPms(boolean sendToPms) {
        this.sendToPms = sendToPms;
    }

    public String getStartShoulderDate() {
        return startShoulderDate;
    }

    public void setStartShoulderDate(String startShoulderDate) {
        this.startShoulderDate = startShoulderDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniquePMSKey() {
        return uniquePMSKey;
    }

    public void setUniquePMSKey(String uniquePMSKey) {
        this.uniquePMSKey = uniquePMSKey;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getGuaranteeCode2() {
        return guaranteeCode2;
    }

    public void setGuaranteeCode2(String guaranteeCode2) {
        this.guaranteeCode2 = guaranteeCode2;
    }

    public boolean isSendFailedPMSBlock() {
        return sendFailedPMSBlock;
    }

    public void setSendFailedPMSBlock(boolean sendFailedPMSBlock) {
        this.sendFailedPMSBlock = sendFailedPMSBlock;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostingAccountId() {
        return postingAccountId;
    }

    public void setPostingAccountId(String postingAccountId) {
        this.postingAccountId = postingAccountId;
    }

    public String getReservationTypeCode() {
        return reservationTypeCode;
    }

    public void setReservationTypeCode(String reservationTypeCode) {
        this.reservationTypeCode = reservationTypeCode;
    }

    public String getSegmentationCode() {
        return segmentationCode;
    }

    public void setSegmentationCode(String segmentationCode) {
        this.segmentationCode = segmentationCode;
    }
}

