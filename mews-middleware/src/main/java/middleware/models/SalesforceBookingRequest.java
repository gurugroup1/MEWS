package middleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceBookingRequest {
    @JsonProperty("Name")
    private String name;

//    @JsonProperty("CurrencyIsoCode")
//    private String currencyIsoCode;
//
//    @JsonProperty("RecordTypeId")
//    private String recordTypeId;
//
//    @JsonProperty("thn__Accomodation_Notes__c")
//    private String accomodationNotes;
//
//    @JsonProperty("thn__Agent_Contact__c")
//    private String agentContact;
//
//    @JsonProperty("thn__Agent__c")
//    private String agent;
//
//    @JsonProperty("thn__Arrival_Date__c")
//    private String arrivalDate;
//
//    @JsonProperty("thn__Arrival_Day__c")
//    private String arrivalDay;
//
//    @JsonProperty("thn__Bill_to__c")
//    private String billTo;
//
//    @JsonProperty("thn__Billing_Account__c")
//    private String billingAccount;
//
//    @JsonProperty("thn__Billing_Address__c")
//    private String billingAddress;
//
//    @JsonProperty("thn__Business_Segment__c")
//    private String businessSegment;
//
//    @JsonProperty("thn__Catering_Notes__c")
//    private String cateringNotes;
//
//    @JsonProperty("thn__Channel__c")
//    private String channel;
//
//    @JsonProperty("thn__Closed_Status__c")
//    private String closedStatus;
//
//    @JsonProperty("thn__Comment__c")
//    private String comment;
//
//    @JsonProperty("thn__Company_Contact__c")
//    private String companyContact;
//
//    @JsonProperty("thn__Company__c")
//    private String company;
//
//    @JsonProperty("thn__Days_until_Arrival__c")
//    private Double daysUntilArrival;
//
//    @JsonProperty("thn__Departure_Date__c")
//    private String departureDate;
//
//    @JsonProperty("thn__Departure_Day__c")
//    private String departureDay;
//
//    @JsonProperty("thn__Deposit_Pay_Date__c")
//    private String depositPayDate;
//
//    @JsonProperty("thn__Deposit__c")
//    private Double deposit;
//
//    @JsonProperty("thn__Dietary_Requirements__c")
//    private String dietaryRequirements;
//
//    @JsonProperty("thn__Duration__c")
//    private Double duration;
//
//    @JsonProperty("thn__Hotel__c")
//    private String hotel;
//
//    @JsonProperty("thn__Internal_Notes__c")
//    private String internalNotes;
//
//    @JsonProperty("thn__Invoicing_Details__c")
//    private String invoicingDetails;
//
//    @JsonProperty("thn__Lost_Refused_Remarks__c")
//    private String lostRefusedRemarks;
//
//    @JsonProperty("thn__Mews_Group_Id__c")
//    private String mewsGroupId;
//
//
//    @JsonProperty("thn__Pax__c")
//    private Double pax;
//
//    @JsonProperty("thn__Probability__c")
//    private String probability;
//
//    @JsonProperty("thn__Reason_Lost_Cancelled__c")
//    private String reasonLostCancelled;
//
//    @JsonProperty("thn__Request_Date__c")
//    private String requestDate;
//
//    @JsonProperty("thn__Reservation_Guest__c")
//    private String reservationGuest;
//
//    @JsonProperty("thn__Source__c")
//    private String source;
//
//    @JsonProperty("thn__Stage__c")
//    private String stage;
//
//    @JsonProperty("thn__Structured_Reference__c")
//    private String structuredReference;
//
//    @JsonProperty("thn__Subtype__c")
//    private String subtype;
//
//    @JsonProperty("thn__Total_Amount_excl_Tax__c")
//    private Double totalAmountExclTax;
//
//    @JsonProperty("thn__Total_Amount_incl_Tax__c")
//    private Double totalAmountInclTax;
//
//    @JsonProperty("thn__Type__c")
//    private String type;
//
//    @JsonProperty("thn__Hotel_Rooms_Amount__c")
//    private Double hotelRoomsAmount;
//
//    @JsonProperty("thn__Meeting_Rooms_Amount__c")
//    private Double meetingRoomsAmount;
//
//    @JsonProperty("thn__Number_of_Packs__c")
//    private Double numberOfPacks;
//
//    @JsonProperty("thn__Products_Amount__c")
//    private Double productsAmount;
//
//    @JsonProperty("thn__Total_Tax__c")
//    private Double totalTax;
//
//    @JsonProperty("thn__Market_Segment__c")
//    private String marketSegment;
//
//    @JsonProperty("thn__Offer_Date__c")
//    private String offerDate;
//
//    @JsonProperty("thn__Release_Date__c")
//    private String releaseDate;
//
//    @JsonProperty("thn__Signature_Date__c")
//    private String signatureDate;
//
//    @JsonProperty("thn__Purchase_order__c")
//    private String purchaseOrder;
//
//    @JsonProperty("thn__Send_and_sign_time_tag__c")
//    private String sendAndSignTimeTag;
//
//    @JsonProperty("thn__Signature_Name__c")
//    private String signatureName;
//
//    @JsonProperty("thn__Signature_Title__c")
//    private String signatureTitle;
//
//    @JsonProperty("thn__Signature_URL__c")
//    private String signatureURL;
//
//    @JsonProperty("thn__Request__c")
//    private String request;
//
//    @JsonProperty("thn__Balance__c")
//    private Double balance;
//
//    @JsonProperty("thn__Brief__c")
//    private String brief;
//
//    @JsonProperty("thn__Cancellation_to_be_reported__c")
//    private String cancellationToBeReported;
//
//    @JsonProperty("thn__Credit_to_be_reported__c")
//    private String creditToBeReported;
//
//    @JsonProperty("thn__Invoiced_Amount_HT__c")
//    private Double invoicedAmountHT;
//
//    @JsonProperty("thn__Invoiced_Amount__c")
//    private Double invoicedAmount;
//
//    @JsonProperty("thn__Invoiced_Amount_excl_Tax__c")
//    private Double invoicedAmountExclTax;
//
//    @JsonProperty("thn__Invoiced_to_be_reported__c")
//    private String invoicedToBeReported;
//
//    @JsonProperty("thn__Paid_Amount__c")
//    private Double paidAmount;
//
//    @JsonProperty("thn__Paid_Amount_on_Invoices__c")
//    private Double paidAmountOnInvoices;
//
//    @JsonProperty("thn__ZT_Hotel_Name__c")
//    private String ztHotelName;
//
//    @JsonProperty("thn__Total_VAT_Amount__c")
//    private Double totalVATAmount;
//
//    @JsonProperty("thn__ACCOUNT_NAME__c")
//    private String accountName;
//
//    @JsonProperty("thn__ARRIVAL_DATE2__c")
//    private String arrivalDate2;
//
//    @JsonProperty("thn__AVG_RATE__c")
//    private Double avgRate;
//
//    @JsonProperty("thn__BEV_REVENUE__c")
//    private Double bevRevenue;
//
//    @JsonProperty("thn__BLOCKED__c")
//    private Double blocked;
//
//    @JsonProperty("thn__Beverage__c")
//    private String beverage;
//
//    @JsonProperty("thn__CAT_MGR__c")
//    private String catMgr;
//
//    @JsonProperty("thn__CAT_REVENUE__c")
//    private Double catRevenue;
//
//    @JsonProperty("thn__CXL_REASON__c")
//    private String cxlReason;
//
//    @JsonProperty("thn__DECISION_DATE2__c")
//    private String decisionDate2;
//
//    @JsonProperty("thn__DENIED_REASON__c")
//    private String deniedReason;
//
//    @JsonProperty("thn__DEPARTURE_DATE2__c")
//    private String departureDate2;
//
//    @JsonProperty("thn__FOOD_REVENUE__c")
//    private Double foodRevenue;
//
//    @JsonProperty("thn__Food__c")
//    private String food;
//
//    @JsonProperty("thn__INSERT_DATE2__c")
//    private String insertDate2;
//
//    @JsonProperty("thn__LOST_REASON__c")
//    private String lostReason;
//
//    @JsonProperty("thn__MYCE_Quote_Id__c")
//    private String myceQuoteId;
//
//    @JsonProperty("thn__Meeting_Room__c")
//    private String meetingRoom;
//
//    @JsonProperty("thn__NET_ADR__c")
//    private Double netADR;
//
//    @JsonProperty("thn__OFFER_SENT2__c")
//    private String offerSent2;
//
//    @JsonProperty("thn__ORIGINAL__c")
//    private String original;
//
//    @JsonProperty("thn__OTHERS__c")
//    private Double others;
//
//    @JsonProperty("thn__Other__c")
//    private String other;
//
//    @JsonProperty("thn__PICKED_UP_NET_ADR__c")
//    private Double pickedUpNetADR;
//
//    @JsonProperty("thn__PICKED_UP__c")
//    private Double pickedUp;
//
//    @JsonProperty("thn__ROOM_MGR__c")
//    private String roomMgr;
//
//    @JsonProperty("thn__ROOM_RENTAL__c")
//    private Double roomRental;
//
//    @JsonProperty("thn__Room__c")
//    private String room;
//
//    @JsonProperty("thn__SAL_MGR__c")
//    private String salMgr;
//
//    @JsonProperty("thn__SOURCE_MARKET__c")
//    private String sourceMarket;
//
//    @JsonProperty("Quote_Number__c")
//    private String quoteNumber;
//
//    @JsonProperty("thn__CUTOFF_DATE2__c")
//    private String cutoffDate2;
//
//    @JsonProperty("thn__CUTOFF_DATE__c")
//    private String cutoffDate;
//
//    @JsonProperty("thn__D1__c")
//    private String d1;
//
//    @JsonProperty("thn__D2__c")
//    private String d2;
//
//    @JsonProperty("thn__D3__c")
//    private String d3;
//
//    @JsonProperty("thn__D4__c")
//    private String d4;
//
//    @JsonProperty("thn__DECISION_DATE__c")
//    private String decisionDate;
//
//    @JsonProperty("thn__DX__c")
//    private String dx;
//
//    @JsonProperty("thn__INSERT_DATE__c")
//    private String insertDate;
//
//    @JsonProperty("thn__OFFER_SENT__c")
//    private String offerSent;
//
//    @JsonProperty("thn__TW__c")
//    private Double tw;
//
//    @JsonProperty("thn__W1__c")
//    private Double w1;
//
//    @JsonProperty("thn__W2__c")
//    private Double w2;
//
//    @JsonProperty("thn__W3__c")
//    private String w3;
//
//    @JsonProperty("thn__W4__c")
//    private String w4;
//
//    @JsonProperty("thn__Hotels__c")
//    private String hotels;
//
//    @JsonProperty("thn__Resort__c")
//    private String resort;
//
//    @JsonProperty("thn__ZT_Count_MR__c")
//    private Double ztCountMR;
//
//    @JsonProperty("thn__ZT_Count_QP__c")
//    private Double ztCountQP;
//
//    @JsonProperty("thn__Number_Of_Nights__c")
//    private String numberofNights;
//
//    @JsonProperty("thn__Discount_Percent__c")
//    private Double discountPercent;
//
//    @JsonProperty("thn__Public_URL__c")
//    private String publicURL;
//
//    @JsonProperty("Competitor__c")
//    private String competitor;
//
//    @JsonProperty("Other_reason_lost_turndown_Cancelled__c")
//    private String otherReasonLostTurndownCancelled;
//
//    @JsonProperty("thn__Language__c")
//    private String language;
//
//    @JsonProperty("Account_reference__c")
//    private String accountReference;
//
//    @JsonProperty("Origin__c")
//    private String origin;
//
//    @JsonProperty("Internal__c")
//    private String internal;
//
//    @JsonProperty("Dietary_Requirements2__c")
//    private String dietaryRequirements2;
//
//    @JsonProperty("Payment_methode__c")
//    private String paymentMethod;
//
//    @JsonProperty("Signage__c")
//    private String signage;
//
//    @JsonProperty("Deposit2__c")
//    private String deposit2;
//
//    @JsonProperty("Deposit_3__c")
//    private String deposit3;
//
//    @JsonProperty("Deposit_2_Pay_Date__c")
//    private String deposit2PayDate;
//
//    @JsonProperty("Deposit_3_Pay_Date__c")
//    private String deposit3PayDate;
//
//    @JsonProperty("Onsite_Contact__c")
//    private String onsiteContact;
//
//    @JsonProperty("Onsite_Contact_Phone__c")
//    private String onsiteContactPhone;
//
//    @JsonProperty("days__c")
//    private Double days;
//
//    @JsonProperty("Package_Amount_inc__c")
//    private Double packageAmountInc;
//
//    @JsonProperty("Package_Amount__c")
//    private Double packageAmount;
//
//    @JsonProperty("Start_time__c")
//    private String startTime;
//
//    @JsonProperty("Option_date__c")
//    private String optionDate;
//
//    @JsonProperty("Total_rooms_booked__c")
//    private Double totalRoomsBooked;
//
//    @JsonProperty("Quote_Notes__c")
//    private String quoteNotes;
//
//    @JsonProperty("Discount_Meeting_rooms__c")
//    private Double discountMeetingRooms;
//
//    @JsonProperty("Discount_Hotel_rooms__c")
//    private Double discountHotelRooms;
//
//    @JsonProperty("Discount_AV__c")
//    private Double discountAV;
//
//    @JsonProperty("Discount_No_AV__c")
//    private Double discountNoAV;
//
//    @JsonProperty("Discount_packages__c")
//    private Double discountPackages;
//
//
//    @JsonProperty("Deposit_1_VAT__c")
//    private Double deposit1VAT;
//
//    @JsonProperty("Deposit_2_VAT__c")
//    private Double deposit2VAT;
//
//    @JsonProperty("Deposit_3_VAT__c")
//    private Double deposit3VAT;
//
//    @JsonProperty("Deposit_1_Amount__c")
//    private Double deposit1Amount;
//
//    @JsonProperty("Deposit_2_Amount__c")
//    private Double deposit2Amount;
//
//    @JsonProperty("Deposit_3_Amount__c")
//    private Double deposit3Amount;
//
//    @JsonProperty("PO_Number__c")
//    private String poNumber;
//
//    @JsonProperty("Logo_URL__c")
//    private String logoURL;
//
//    @JsonProperty("Hotel_Rooms_Amount_inc__c")
//    private Double hotelRoomsAmountInc;
//
//    @JsonProperty("Meeting_Rooms_Amount_inc__c")
//    private Double meetingRoomsAmountInc;
//
//    @JsonProperty("Products_Amount_Inc__c")
//    private Double productsAmountInc;
//
//    @JsonProperty("LS_reference__c")
//    private String lsReference;
//
//    @JsonProperty("AR_Nummer__c")
//    private String arNummer;
//
//    @JsonProperty("Last_Offer_Generation__c")
//    private String lastOfferGeneration;
//
//    @JsonProperty("Rooms_amount_total__c")
//    private Double roomsAmountTotal;
//
//    @JsonProperty("ADR_Incl__c")
//    private Double adrIncl;
//
//    @JsonProperty("Unique_number_proforma__c")
//    private Double uniqueNumberProforma;
//
//    @JsonProperty("thn__Accomodation_NotesLong__c")
//    private String accommodationNotesLong;
//
//    @JsonProperty("thn__Catering_NotesLong__c")
//    private String cateringNotesLong;
//
//    @JsonProperty("thn__Internal_NotesLong__c")
//    private String internalNotesLong;
//
//    @JsonProperty("thn__Reservation_Guest_Name__c")
//    private String reservationGuestName;
//
//    @JsonProperty("Locale_for_Documents__c")
//    private String localeForDocuments;
//
//    @JsonProperty("Company_short_name__c")
//    private String companyShortName;
//
//    @JsonProperty("thn__Comm_Activity__c")
//    private String commActivity;
//
//    @JsonProperty("thn__Comm_Beverage__c")
//    private String commBeverage;
//
//    @JsonProperty("thn__Comm_Equipment__c")
//    private String commEquipment;
//
//    @JsonProperty("thn__Comm_Food__c")
//    private String commFood;
//
//    @JsonProperty("thn__Comm_Hotel_Rooms__c")
//    private String commHotelRooms;
//
//    @JsonProperty("thn__Comm_Meeting_Rooms__c")
//    private String commMeetingRooms;
//
//    @JsonProperty("thn__Comm_Other__c")
//    private String commOther;
//
//    @JsonProperty("thn__Comm_Package__c")
//    private String commPackage;
//
//    @JsonProperty("thn__Commission_to__c")
//    private String commissionTo;
//
//    @JsonProperty("thn__Last_Sync__c")
//    private String lastSync;
//
//    @JsonProperty("thn__Last_sync_status__c")
//    private String lastSyncStatus;
//
//    @JsonProperty("thn__Sync_Error_Message__c")
//    private String syncErrorMessage;
//
//    @JsonProperty("thn__Total_Commission_on_Quote__c")
//    private Double totalCommissionOnQuote;
//
//    @JsonProperty("thn__Shoulder_End_Date__c")
//    private String shoulderEndDate;
//
//    @JsonProperty("thn__Shoulder_Start_Date__c")
//    private String shoulderStartDate;
//
//    @JsonProperty("thn__Total_incl_Tax__c")
//    private Double totalInclTax;
//
//    @JsonProperty("thn__Total_Hotel_Room_incl_Tax__c")
//    private Double totalHotelRoomInclTax;
//
//    @JsonProperty("thn__Total_Meeting_Room_incl_Tax__c")
//    private Double totalMeetingRoomInclTax;
//
//    @JsonProperty("thn__Total_Product_incl_Tax__c")
//    private Double totalProductInclTax;
//
//    @JsonProperty("thn__ZT_Count_HR__c")
//    private Double ztCountHR;
//
//    @JsonProperty("Release_Date_formula__c")
//    private String releaseDateFormula;
//
//    @JsonProperty("Guest_Quote_Name__c")
//    private String guestQuoteName;
//
//    @JsonProperty("thn__Release_date_formula__c")
//    private String releaseDateFormula2;
//
//
//    @JsonProperty("thn__Potential_max_revenue_field__c")
//    private Double potentialMaxRevenueField;
//
//    @JsonProperty("thn__Potential_max_revenue_MR__c")
//    private Double potentialMaxRevenueMR;
//
//    @JsonProperty("thn__Potential_max_revenue_Package__c")
//    private Double potentialMaxRevenuePackage;
//
//    @JsonProperty("thn__Potential_max_revenue_Product__c")
//    private Double potentialMaxRevenueProduct;
//
//    @JsonProperty("thn__Total_paid__c")
//    private Double totalPaid;
//
//
//    @JsonProperty("thn__InventoryBlockType__c")
//    private String inventoryBlockType;
//
//    @JsonProperty("thn__PMS_Company__c")
//    private String pmsCompany;
//
//    @JsonProperty("thn__PMS_Group__c")
//    private String pmsGroup;
//
//    @JsonProperty("thn__PMS_Source__c")
//    private String pmsSource;
//
//    @JsonProperty("thn__PMS_Travel_Agent__c")
//    private String pmsTravelAgent;
//
//
//    @JsonProperty("thn__Guarantee_Code__c")
//    private String guaranteeCode;
//
//    @JsonProperty("thn__Dietary_Requirements_Long__c")
//    private String dietaryRequirementsLong;
//
//    @JsonProperty("Status__c")
//    private String status;
//
//
//    @JsonProperty("thn__Block_Rate__c")
//    private String blockRate;
//
//    @JsonProperty("Rating_Stars__c")
//    private String ratingStars;
//
//    @JsonProperty("thn__Package_Amount_Incl_Tax__c")
//    private Double packageAmountInclTax;
//
//    @JsonProperty("thn__Tax_Calculation_Log__c")
//    private String taxCalculationLog;
//
//    @JsonProperty("thn__Tax_Group_Type__c")
//    private String taxGroupType;
//
//    @JsonProperty("thn__Tax_Last_Calculated_Date__c")
//    private String taxLastCalculatedDate;
//
//    @JsonProperty("thn__Expanded_status__c")
//    private String expandedStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public String getCurrencyIsoCode() {
//        return currencyIsoCode;
//    }
//
//    public void setCurrencyIsoCode(String currencyIsoCode) {
//        this.currencyIsoCode = currencyIsoCode;
//    }
//
//    public String getRecordTypeId() {
//        return recordTypeId;
//    }
//
//    public void setRecordTypeId(String recordTypeId) {
//        this.recordTypeId = recordTypeId;
//    }
//
//    public String getAccomodationNotes() {
//        return accomodationNotes;
//    }
//
//    public void setAccomodationNotes(String accomodationNotes) {
//        this.accomodationNotes = accomodationNotes;
//    }
//
//    public String getAgentContact() {
//        return agentContact;
//    }
//
//    public void setAgentContact(String agentContact) {
//        this.agentContact = agentContact;
//    }
//
//    public String getAgent() {
//        return agent;
//    }
//
//    public void setAgent(String agent) {
//        this.agent = agent;
//    }
//
//    public String getArrivalDate() {
//        return arrivalDate;
//    }
//
//    public void setArrivalDate(String arrivalDate) {
//        this.arrivalDate = arrivalDate;
//    }
//
//    public String getArrivalDay() {
//        return arrivalDay;
//    }
//
//    public void setArrivalDay(String arrivalDay) {
//        this.arrivalDay = arrivalDay;
//    }
//
//    public String getBillTo() {
//        return billTo;
//    }
//
//    public void setBillTo(String billTo) {
//        this.billTo = billTo;
//    }
//
//    public String getBillingAccount() {
//        return billingAccount;
//    }
//
//    public void setBillingAccount(String billingAccount) {
//        this.billingAccount = billingAccount;
//    }
//
//    public String getBillingAddress() {
//        return billingAddress;
//    }
//
//    public void setBillingAddress(String billingAddress) {
//        this.billingAddress = billingAddress;
//    }
//
//    public String getBusinessSegment() {
//        return businessSegment;
//    }
//
//    public void setBusinessSegment(String businessSegment) {
//        this.businessSegment = businessSegment;
//    }
//
//    public String getCateringNotes() {
//        return cateringNotes;
//    }
//
//    public void setCateringNotes(String cateringNotes) {
//        this.cateringNotes = cateringNotes;
//    }
//
//    public String getChannel() {
//        return channel;
//    }
//
//    public void setChannel(String channel) {
//        this.channel = channel;
//    }
//
//    public String getClosedStatus() {
//        return closedStatus;
//    }
//
//    public void setClosedStatus(String closedStatus) {
//        this.closedStatus = closedStatus;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public String getCompanyContact() {
//        return companyContact;
//    }
//
//    public void setCompanyContact(String companyContact) {
//        this.companyContact = companyContact;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public Double getDaysUntilArrival() {
//        return daysUntilArrival;
//    }
//
//    public void setDaysUntilArrival(Double daysUntilArrival) {
//        this.daysUntilArrival = daysUntilArrival;
//    }
//
//    public String getDepartureDate() {
//        return departureDate;
//    }
//
//    public void setDepartureDate(String departureDate) {
//        this.departureDate = departureDate;
//    }
//
//    public String getDepartureDay() {
//        return departureDay;
//    }
//
//    public void setDepartureDay(String departureDay) {
//        this.departureDay = departureDay;
//    }
//
//    public String getDepositPayDate() {
//        return depositPayDate;
//    }
//
//    public void setDepositPayDate(String depositPayDate) {
//        this.depositPayDate = depositPayDate;
//    }
//
//    public Double getDeposit() {
//        return deposit;
//    }
//
//    public void setDeposit(Double deposit) {
//        this.deposit = deposit;
//    }
//
//    public String getDietaryRequirements() {
//        return dietaryRequirements;
//    }
//
//    public void setDietaryRequirements(String dietaryRequirements) {
//        this.dietaryRequirements = dietaryRequirements;
//    }
//
//    public Double getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Double duration) {
//        this.duration = duration;
//    }
//
//    public String getHotel() {
//        return hotel;
//    }
//
//    public void setHotel(String hotel) {
//        this.hotel = hotel;
//    }
//
//    public String getInternalNotes() {
//        return internalNotes;
//    }
//
//    public void setInternalNotes(String internalNotes) {
//        this.internalNotes = internalNotes;
//    }
//
//    public String getInvoicingDetails() {
//        return invoicingDetails;
//    }
//
//    public void setInvoicingDetails(String invoicingDetails) {
//        this.invoicingDetails = invoicingDetails;
//    }
//
//    public String getLostRefusedRemarks() {
//        return lostRefusedRemarks;
//    }
//
//    public void setLostRefusedRemarks(String lostRefusedRemarks) {
//        this.lostRefusedRemarks = lostRefusedRemarks;
//    }
//
//    public String getMewsGroupId() {
//        return mewsGroupId;
//    }
//
//    public void setMewsGroupId(String mewsGroupId) {
//        this.mewsGroupId = mewsGroupId;
//    }
//
//    public Double getPax() {
//        return pax;
//    }
//
//    public void setPax(Double pax) {
//        this.pax = pax;
//    }
//
//    public String getProbability() {
//        return probability;
//    }
//
//    public void setProbability(String probability) {
//        this.probability = probability;
//    }
//
//    public String getReasonLostCancelled() {
//        return reasonLostCancelled;
//    }
//
//    public void setReasonLostCancelled(String reasonLostCancelled) {
//        this.reasonLostCancelled = reasonLostCancelled;
//    }
//
//    public String getRequestDate() {
//        return requestDate;
//    }
//
//    public void setRequestDate(String requestDate) {
//        this.requestDate = requestDate;
//    }
//
//    public String getReservationGuest() {
//        return reservationGuest;
//    }
//
//    public void setReservationGuest(String reservationGuest) {
//        this.reservationGuest = reservationGuest;
//    }
//
//
//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getStage() {
//        return stage;
//    }
//
//    public void setStage(String stage) {
//        this.stage = stage;
//    }
//
//    public String getStructuredReference() {
//        return structuredReference;
//    }
//
//    public void setStructuredReference(String structuredReference) {
//        this.structuredReference = structuredReference;
//    }
//
//    public String getSubtype() {
//        return subtype;
//    }
//
//    public void setSubtype(String subtype) {
//        this.subtype = subtype;
//    }
//
//    public Double getTotalAmountExclTax() {
//        return totalAmountExclTax;
//    }
//
//    public void setTotalAmountExclTax(Double totalAmountExclTax) {
//        this.totalAmountExclTax = totalAmountExclTax;
//    }
//
//    public Double getTotalAmountInclTax() {
//        return totalAmountInclTax;
//    }
//
//    public void setTotalAmountInclTax(Double totalAmountInclTax) {
//        this.totalAmountInclTax = totalAmountInclTax;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//
//    public Double getHotelRoomsAmount() {
//        return hotelRoomsAmount;
//    }
//
//    public void setHotelRoomsAmount(Double hotelRoomsAmount) {
//        this.hotelRoomsAmount = hotelRoomsAmount;
//    }
//
//    public Double getMeetingRoomsAmount() {
//        return meetingRoomsAmount;
//    }
//
//    public void setMeetingRoomsAmount(Double meetingRoomsAmount) {
//        this.meetingRoomsAmount = meetingRoomsAmount;
//    }
//
//    public Double getNumberOfPacks() {
//        return numberOfPacks;
//    }
//
//    public void setNumberOfPacks(Double numberOfPacks) {
//        this.numberOfPacks = numberOfPacks;
//    }
//
//    public Double getProductsAmount() {
//        return productsAmount;
//    }
//
//    public void setProductsAmount(Double productsAmount) {
//        this.productsAmount = productsAmount;
//    }
//
//    public Double getTotalTax() {
//        return totalTax;
//    }
//
//    public void setTotalTax(Double totalTax) {
//        this.totalTax = totalTax;
//    }
//
//    public String getMarketSegment() {
//        return marketSegment;
//    }
//
//    public void setMarketSegment(String marketSegment) {
//        this.marketSegment = marketSegment;
//    }
//
//    public String getOfferDate() {
//        return offerDate;
//    }
//
//    public void setOfferDate(String offerDate) {
//        this.offerDate = offerDate;
//    }
//
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public String getSignatureDate() {
//        return signatureDate;
//    }
//
//    public void setSignatureDate(String signatureDate) {
//        this.signatureDate = signatureDate;
//    }
//
//    public String getPurchaseOrder() {
//        return purchaseOrder;
//    }
//
//    public void setPurchaseOrder(String purchaseOrder) {
//        this.purchaseOrder = purchaseOrder;
//    }
//
//    public String getSendAndSignTimeTag() {
//        return sendAndSignTimeTag;
//    }
//
//    public void setSendAndSignTimeTag(String sendAndSignTimeTag) {
//        this.sendAndSignTimeTag = sendAndSignTimeTag;
//    }
//
//    public String getSignatureName() {
//        return signatureName;
//    }
//
//    public void setSignatureName(String signatureName) {
//        this.signatureName = signatureName;
//    }
//
//    public String getSignatureTitle() {
//        return signatureTitle;
//    }
//
//    public void setSignatureTitle(String signatureTitle) {
//        this.signatureTitle = signatureTitle;
//    }
//
//    public String getSignatureURL() {
//        return signatureURL;
//    }
//
//    public void setSignatureURL(String signatureURL) {
//        this.signatureURL = signatureURL;
//    }
//
//    public String getRequest() {
//        return request;
//    }
//
//    public void setRequest(String request) {
//        this.request = request;
//    }
//
//    public Double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Double balance) {
//        this.balance = balance;
//    }
//
//    public String getBrief() {
//        return brief;
//    }
//
//    public void setBrief(String brief) {
//        this.brief = brief;
//    }
//
//    public String getCancellationToBeReported() {
//        return cancellationToBeReported;
//    }
//
//    public void setCancellationToBeReported(String cancellationToBeReported) {
//        this.cancellationToBeReported = cancellationToBeReported;
//    }
//
//    public String getCreditToBeReported() {
//        return creditToBeReported;
//    }
//
//    public void setCreditToBeReported(String creditToBeReported) {
//        this.creditToBeReported = creditToBeReported;
//    }
//
//    public Double getInvoicedAmountHT() {
//        return invoicedAmountHT;
//    }
//
//    public void setInvoicedAmountHT(Double invoicedAmountHT) {
//        this.invoicedAmountHT = invoicedAmountHT;
//    }
//
//    public Double getInvoicedAmount() {
//        return invoicedAmount;
//    }
//
//    public void setInvoicedAmount(Double invoicedAmount) {
//        this.invoicedAmount = invoicedAmount;
//    }
//
//    public Double getInvoicedAmountExclTax() {
//        return invoicedAmountExclTax;
//    }
//
//    public void setInvoicedAmountExclTax(Double invoicedAmountExclTax) {
//        this.invoicedAmountExclTax = invoicedAmountExclTax;
//    }
//
//    public String getInvoicedToBeReported() {
//        return invoicedToBeReported;
//    }
//
//    public void setInvoicedToBeReported(String invoicedToBeReported) {
//        this.invoicedToBeReported = invoicedToBeReported;
//    }
//
//    public Double getPaidAmount() {
//        return paidAmount;
//    }
//
//    public void setPaidAmount(Double paidAmount) {
//        this.paidAmount = paidAmount;
//    }
//
//    public Double getPaidAmountOnInvoices() {
//        return paidAmountOnInvoices;
//    }
//
//    public void setPaidAmountOnInvoices(Double paidAmountOnInvoices) {
//        this.paidAmountOnInvoices = paidAmountOnInvoices;
//    }
//
//    public String getZtHotelName() {
//        return ztHotelName;
//    }
//
//    public void setZtHotelName(String ztHotelName) {
//        this.ztHotelName = ztHotelName;
//    }
//
//    public Double getTotalVATAmount() {
//        return totalVATAmount;
//    }
//
//    public void setTotalVATAmount(Double totalVATAmount) {
//        this.totalVATAmount = totalVATAmount;
//    }
//
//    public String getAccountName() {
//        return accountName;
//    }
//
//    public void setAccountName(String accountName) {
//        this.accountName = accountName;
//    }
//
//    public String getArrivalDate2() {
//        return arrivalDate2;
//    }
//
//    public void setArrivalDate2(String arrivalDate2) {
//        this.arrivalDate2 = arrivalDate2;
//    }
//
//    public Double getAvgRate() {
//        return avgRate;
//    }
//
//    public void setAvgRate(Double avgRate) {
//        this.avgRate = avgRate;
//    }
//
//    public Double getBevRevenue() {
//        return bevRevenue;
//    }
//
//    public void setBevRevenue(Double bevRevenue) {
//        this.bevRevenue = bevRevenue;
//    }
//
//    public Double getBlocked() {
//        return blocked;
//    }
//
//    public void setBlocked(Double blocked) {
//        this.blocked = blocked;
//    }
//
//    public String getBeverage() {
//        return beverage;
//    }
//
//    public void setBeverage(String beverage) {
//        this.beverage = beverage;
//    }
//
//    public String getCatMgr() {
//        return catMgr;
//    }
//
//    public void setCatMgr(String catMgr) {
//        this.catMgr = catMgr;
//    }
//
//    public Double getCatRevenue() {
//        return catRevenue;
//    }
//
//    public void setCatRevenue(Double catRevenue) {
//        this.catRevenue = catRevenue;
//    }
//
//    public String getCxlReason() {
//        return cxlReason;
//    }
//
//    public void setCxlReason(String cxlReason) {
//        this.cxlReason = cxlReason;
//    }
//
//    public String getDecisionDate2() {
//        return decisionDate2;
//    }
//
//    public void setDecisionDate2(String decisionDate2) {
//        this.decisionDate2 = decisionDate2;
//    }
//
//    public String getDeniedReason() {
//        return deniedReason;
//    }
//
//    public void setDeniedReason(String deniedReason) {
//        this.deniedReason = deniedReason;
//    }
//
//    public String getDepartureDate2() {
//        return departureDate2;
//    }
//
//    public void setDepartureDate2(String departureDate2) {
//        this.departureDate2 = departureDate2;
//    }
//
//    public Double getFoodRevenue() {
//        return foodRevenue;
//    }
//
//    public void setFoodRevenue(Double foodRevenue) {
//        this.foodRevenue = foodRevenue;
//    }
//
//    public String getFood() {
//        return food;
//    }
//
//    public void setFood(String food) {
//        this.food = food;
//    }
//
//    public String getInsertDate2() {
//        return insertDate2;
//    }
//
//    public void setInsertDate2(String insertDate2) {
//        this.insertDate2 = insertDate2;
//    }
//
//    public String getLostReason() {
//        return lostReason;
//    }
//
//    public void setLostReason(String lostReason) {
//        this.lostReason = lostReason;
//    }
//
//    public String getMyceQuoteId() {
//        return myceQuoteId;
//    }
//
//    public void setMyceQuoteId(String myceQuoteId) {
//        this.myceQuoteId = myceQuoteId;
//    }
//
//    public String getMeetingRoom() {
//        return meetingRoom;
//    }
//
//    public void setMeetingRoom(String meetingRoom) {
//        this.meetingRoom = meetingRoom;
//    }
//
//    public Double getNetADR() {
//        return netADR;
//    }
//
//    public void setNetADR(Double netADR) {
//        this.netADR = netADR;
//    }
//
//    public String getOfferSent2() {
//        return offerSent2;
//    }
//
//    public void setOfferSent2(String offerSent2) {
//        this.offerSent2 = offerSent2;
//    }
//
//    public String getOriginal() {
//        return original;
//    }
//
//    public void setOriginal(String original) {
//        this.original = original;
//    }
//
//    public Double getOthers() {
//        return others;
//    }
//
//    public void setOthers(Double others) {
//        this.others = others;
//    }
//
//    public String getOther() {
//        return other;
//    }
//
//    public void setOther(String other) {
//        this.other = other;
//    }
//
//    public Double getPickedUpNetADR() {
//        return pickedUpNetADR;
//    }
//
//    public void setPickedUpNetADR(Double pickedUpNetADR) {
//        this.pickedUpNetADR = pickedUpNetADR;
//    }
//
//    public Double getPickedUp() {
//        return pickedUp;
//    }
//
//    public void setPickedUp(Double pickedUp) {
//        this.pickedUp = pickedUp;
//    }
//
//    public String getRoomMgr() {
//        return roomMgr;
//    }
//
//    public void setRoomMgr(String roomMgr) {
//        this.roomMgr = roomMgr;
//    }
//
//    public Double getRoomRental() {
//        return roomRental;
//    }
//
//    public void setRoomRental(Double roomRental) {
//        this.roomRental = roomRental;
//    }
//
//    public String getRoom() {
//        return room;
//    }
//
//    public void setRoom(String room) {
//        this.room = room;
//    }
//
//    public String getSalMgr() {
//        return salMgr;
//    }
//
//    public void setSalMgr(String salMgr) {
//        this.salMgr = salMgr;
//    }
//
//    public String getSourceMarket() {
//        return sourceMarket;
//    }
//
//    public void setSourceMarket(String sourceMarket) {
//        this.sourceMarket = sourceMarket;
//    }
//
//    public String getQuoteNumber() {
//        return quoteNumber;
//    }
//
//    public void setQuoteNumber(String quoteNumber) {
//        this.quoteNumber = quoteNumber;
//    }
//
//    public String getCutoffDate2() {
//        return cutoffDate2;
//    }
//
//    public void setCutoffDate2(String cutoffDate2) {
//        this.cutoffDate2 = cutoffDate2;
//    }
//
//    public String getCutoffDate() {
//        return cutoffDate;
//    }
//
//    public void setCutoffDate(String cutoffDate) {
//        this.cutoffDate = cutoffDate;
//    }
//
//    public String getD1() {
//        return d1;
//    }
//
//    public void setD1(String d1) {
//        this.d1 = d1;
//    }
//
//    public String getD2() {
//        return d2;
//    }
//
//    public void setD2(String d2) {
//        this.d2 = d2;
//    }
//
//    public String getD3() {
//        return d3;
//    }
//
//    public void setD3(String d3) {
//        this.d3 = d3;
//    }
//
//    public String getD4() {
//        return d4;
//    }
//
//    public void setD4(String d4) {
//        this.d4 = d4;
//    }
//
//    public String getDecisionDate() {
//        return decisionDate;
//    }
//
//    public void setDecisionDate(String decisionDate) {
//        this.decisionDate = decisionDate;
//    }
//
//    public String getDx() {
//        return dx;
//    }
//
//    public void setDx(String dx) {
//        this.dx = dx;
//    }
//
//    public String getInsertDate() {
//        return insertDate;
//    }
//
//    public void setInsertDate(String insertDate) {
//        this.insertDate = insertDate;
//    }
//
//    public String getOfferSent() {
//        return offerSent;
//    }
//
//    public void setOfferSent(String offerSent) {
//        this.offerSent = offerSent;
//    }
//
//    public Double getTw() {
//        return tw;
//    }
//
//    public void setTw(Double tw) {
//        this.tw = tw;
//    }
//
//    public Double getW1() {
//        return w1;
//    }
//
//    public void setW1(Double w1) {
//        this.w1 = w1;
//    }
//
//    public Double getW2() {
//        return w2;
//    }
//
//    public void setW2(Double w2) {
//        this.w2 = w2;
//    }
//
//    public String getW3() {
//        return w3;
//    }
//
//    public void setW3(String w3) {
//        this.w3 = w3;
//    }
//
//    public String getW4() {
//        return w4;
//    }
//
//    public void setW4(String w4) {
//        this.w4 = w4;
//    }
//
//    public String getHotels() {
//        return hotels;
//    }
//
//    public void setHotels(String hotels) {
//        this.hotels = hotels;
//    }
//
//    public String getResort() {
//        return resort;
//    }
//
//    public void setResort(String resort) {
//        this.resort = resort;
//    }
//
//    public Double getZtCountMR() {
//        return ztCountMR;
//    }
//
//    public void setZtCountMR(Double ztCountMR) {
//        this.ztCountMR = ztCountMR;
//    }
//
//    public Double getZtCountQP() {
//        return ztCountQP;
//    }
//
//    public void setZtCountQP(Double ztCountQP) {
//        this.ztCountQP = ztCountQP;
//    }
//
//    public String getNumberofNights() {
//        return numberofNights;
//    }
//
//    public void setNumberofNights(String numberofNights) {
//        this.numberofNights = numberofNights;
//    }
//
//    public Double getDiscountPercent() {
//        return discountPercent;
//    }
//
//    public void setDiscountPercent(Double discountPercent) {
//        this.discountPercent = discountPercent;
//    }
//
//    public String getPublicURL() {
//        return publicURL;
//    }
//
//    public void setPublicURL(String publicURL) {
//        this.publicURL = publicURL;
//    }
//
//    public String getCompetitor() {
//        return competitor;
//    }
//
//    public void setCompetitor(String competitor) {
//        this.competitor = competitor;
//    }
//
//    public String getOtherReasonLostTurndownCancelled() {
//        return otherReasonLostTurndownCancelled;
//    }
//
//    public void setOtherReasonLostTurndownCancelled(String otherReasonLostTurndownCancelled) {
//        this.otherReasonLostTurndownCancelled = otherReasonLostTurndownCancelled;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public String getAccountReference() {
//        return accountReference;
//    }
//
//    public void setAccountReference(String accountReference) {
//        this.accountReference = accountReference;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public String getInternal() {
//        return internal;
//    }
//
//    public void setInternal(String internal) {
//        this.internal = internal;
//    }
//
//    public String getDietaryRequirements2() {
//        return dietaryRequirements2;
//    }
//
//    public void setDietaryRequirements2(String dietaryRequirements2) {
//        this.dietaryRequirements2 = dietaryRequirements2;
//    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    public String getSignage() {
//        return signage;
//    }
//
//    public void setSignage(String signage) {
//        this.signage = signage;
//    }
//
//    public String getDeposit2() {
//        return deposit2;
//    }
//
//    public void setDeposit2(String deposit2) {
//        this.deposit2 = deposit2;
//    }
//
//    public String getDeposit3() {
//        return deposit3;
//    }
//
//    public void setDeposit3(String deposit3) {
//        this.deposit3 = deposit3;
//    }
//
//    public String getDeposit2PayDate() {
//        return deposit2PayDate;
//    }
//
//    public void setDeposit2PayDate(String deposit2PayDate) {
//        this.deposit2PayDate = deposit2PayDate;
//    }
//
//    public String getDeposit3PayDate() {
//        return deposit3PayDate;
//    }
//
//    public void setDeposit3PayDate(String deposit3PayDate) {
//        this.deposit3PayDate = deposit3PayDate;
//    }
//
//    public String getOnsiteContact() {
//        return onsiteContact;
//    }
//
//    public void setOnsiteContact(String onsiteContact) {
//        this.onsiteContact = onsiteContact;
//    }
//
//    public String getOnsiteContactPhone() {
//        return onsiteContactPhone;
//    }
//
//    public void setOnsiteContactPhone(String onsiteContactPhone) {
//        this.onsiteContactPhone = onsiteContactPhone;
//    }
//
//    public Double getDays() {
//        return days;
//    }
//
//    public void setDays(Double days) {
//        this.days = days;
//    }
//
//    public Double getPackageAmountInc() {
//        return packageAmountInc;
//    }
//
//    public void setPackageAmountInc(Double packageAmountInc) {
//        this.packageAmountInc = packageAmountInc;
//    }
//
//    public Double getPackageAmount() {
//        return packageAmount;
//    }
//
//    public void setPackageAmount(Double packageAmount) {
//        this.packageAmount = packageAmount;
//    }
//
//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public String getOptionDate() {
//        return optionDate;
//    }
//
//    public void setOptionDate(String optionDate) {
//        this.optionDate = optionDate;
//    }
//
//    public Double getTotalRoomsBooked() {
//        return totalRoomsBooked;
//    }
//
//    public void setTotalRoomsBooked(Double totalRoomsBooked) {
//        this.totalRoomsBooked = totalRoomsBooked;
//    }
//
//    public String getQuoteNotes() {
//        return quoteNotes;
//    }
//
//    public void setQuoteNotes(String quoteNotes) {
//        this.quoteNotes = quoteNotes;
//    }
//
//
//    public Double getDiscountMeetingRooms() {
//        return discountMeetingRooms;
//    }
//
//    public void setDiscountMeetingRooms(Double discountMeetingRooms) {
//        this.discountMeetingRooms = discountMeetingRooms;
//    }
//
//    public Double getDiscountHotelRooms() {
//        return discountHotelRooms;
//    }
//
//    public void setDiscountHotelRooms(Double discountHotelRooms) {
//        this.discountHotelRooms = discountHotelRooms;
//    }
//
//    public Double getDiscountAV() {
//        return discountAV;
//    }
//
//    public void setDiscountAV(Double discountAV) {
//        this.discountAV = discountAV;
//    }
//
//    public Double getDiscountNoAV() {
//        return discountNoAV;
//    }
//
//    public void setDiscountNoAV(Double discountNoAV) {
//        this.discountNoAV = discountNoAV;
//    }
//
//    public Double getDiscountPackages() {
//        return discountPackages;
//    }
//
//    public void setDiscountPackages(Double discountPackages) {
//        this.discountPackages = discountPackages;
//    }
//
//
//    public Double getDeposit1VAT() {
//        return deposit1VAT;
//    }
//
//    public void setDeposit1VAT(Double deposit1VAT) {
//        this.deposit1VAT = deposit1VAT;
//    }
//
//    public Double getDeposit2VAT() {
//        return deposit2VAT;
//    }
//
//    public void setDeposit2VAT(Double deposit2VAT) {
//        this.deposit2VAT = deposit2VAT;
//    }
//
//    public Double getDeposit3VAT() {
//        return deposit3VAT;
//    }
//
//    public void setDeposit3VAT(Double deposit3VAT) {
//        this.deposit3VAT = deposit3VAT;
//    }
//
//    public Double getDeposit1Amount() {
//        return deposit1Amount;
//    }
//
//    public void setDeposit1Amount(Double deposit1Amount) {
//        this.deposit1Amount = deposit1Amount;
//    }
//
//    public Double getDeposit2Amount() {
//        return deposit2Amount;
//    }
//
//    public void setDeposit2Amount(Double deposit2Amount) {
//        this.deposit2Amount = deposit2Amount;
//    }
//
//    public Double getDeposit3Amount() {
//        return deposit3Amount;
//    }
//
//    public void setDeposit3Amount(Double deposit3Amount) {
//        this.deposit3Amount = deposit3Amount;
//    }
//
//    public String getPoNumber() {
//        return poNumber;
//    }
//
//    public void setPoNumber(String poNumber) {
//        this.poNumber = poNumber;
//    }
//
//    public String getLogoURL() {
//        return logoURL;
//    }
//
//    public void setLogoURL(String logoURL) {
//        this.logoURL = logoURL;
//    }
//
//    public Double getHotelRoomsAmountInc() {
//        return hotelRoomsAmountInc;
//    }
//
//    public void setHotelRoomsAmountInc(Double hotelRoomsAmountInc) {
//        this.hotelRoomsAmountInc = hotelRoomsAmountInc;
//    }
//
//    public Double getMeetingRoomsAmountInc() {
//        return meetingRoomsAmountInc;
//    }
//
//    public void setMeetingRoomsAmountInc(Double meetingRoomsAmountInc) {
//        this.meetingRoomsAmountInc = meetingRoomsAmountInc;
//    }
//
//    public Double getProductsAmountInc() {
//        return productsAmountInc;
//    }
//
//    public void setProductsAmountInc(Double productsAmountInc) {
//        this.productsAmountInc = productsAmountInc;
//    }
//
//
//    public String getLsReference() {
//        return lsReference;
//    }
//
//    public void setLsReference(String lsReference) {
//        this.lsReference = lsReference;
//    }
//
//    public String getArNummer() {
//        return arNummer;
//    }
//
//    public void setArNummer(String arNummer) {
//        this.arNummer = arNummer;
//    }
//
//
//    public String getLastOfferGeneration() {
//        return lastOfferGeneration;
//    }
//
//    public void setLastOfferGeneration(String lastOfferGeneration) {
//        this.lastOfferGeneration = lastOfferGeneration;
//    }
//
//    public Double getRoomsAmountTotal() {
//        return roomsAmountTotal;
//    }
//
//    public void setRoomsAmountTotal(Double roomsAmountTotal) {
//        this.roomsAmountTotal = roomsAmountTotal;
//    }
//
//    public Double getAdrIncl() {
//        return adrIncl;
//    }
//
//    public void setAdrIncl(Double adrIncl) {
//        this.adrIncl = adrIncl;
//    }
//
//
//    public Double getUniqueNumberProforma() {
//        return uniqueNumberProforma;
//    }
//
//    public void setUniqueNumberProforma(Double uniqueNumberProforma) {
//        this.uniqueNumberProforma = uniqueNumberProforma;
//    }
//
//    public String getAccommodationNotesLong() {
//        return accommodationNotesLong;
//    }
//
//    public void setAccommodationNotesLong(String accommodationNotesLong) {
//        this.accommodationNotesLong = accommodationNotesLong;
//    }
//
//    public String getCateringNotesLong() {
//        return cateringNotesLong;
//    }
//
//    public void setCateringNotesLong(String cateringNotesLong) {
//        this.cateringNotesLong = cateringNotesLong;
//    }
//
//    public String getInternalNotesLong() {
//        return internalNotesLong;
//    }
//
//    public void setInternalNotesLong(String internalNotesLong) {
//        this.internalNotesLong = internalNotesLong;
//    }
//
//    public String getReservationGuestName() {
//        return reservationGuestName;
//    }
//
//    public void setReservationGuestName(String reservationGuestName) {
//        this.reservationGuestName = reservationGuestName;
//    }
//
//    public String getLocaleForDocuments() {
//        return localeForDocuments;
//    }
//
//    public void setLocaleForDocuments(String localeForDocuments) {
//        this.localeForDocuments = localeForDocuments;
//    }
//
//    public String getCompanyShortName() {
//        return companyShortName;
//    }
//
//    public void setCompanyShortName(String companyShortName) {
//        this.companyShortName = companyShortName;
//    }
//
//    public String getCommActivity() {
//        return commActivity;
//    }
//
//    public void setCommActivity(String commActivity) {
//        this.commActivity = commActivity;
//    }
//
//    public String getCommBeverage() {
//        return commBeverage;
//    }
//
//    public void setCommBeverage(String commBeverage) {
//        this.commBeverage = commBeverage;
//    }
//
//    public String getCommEquipment() {
//        return commEquipment;
//    }
//
//    public void setCommEquipment(String commEquipment) {
//        this.commEquipment = commEquipment;
//    }
//
//    public String getCommFood() {
//        return commFood;
//    }
//
//    public void setCommFood(String commFood) {
//        this.commFood = commFood;
//    }
//
//    public String getCommHotelRooms() {
//        return commHotelRooms;
//    }
//
//    public void setCommHotelRooms(String commHotelRooms) {
//        this.commHotelRooms = commHotelRooms;
//    }
//
//    public String getCommMeetingRooms() {
//        return commMeetingRooms;
//    }
//
//    public void setCommMeetingRooms(String commMeetingRooms) {
//        this.commMeetingRooms = commMeetingRooms;
//    }
//
//    public String getCommOther() {
//        return commOther;
//    }
//
//    public void setCommOther(String commOther) {
//        this.commOther = commOther;
//    }
//
//    public String getCommPackage() {
//        return commPackage;
//    }
//
//    public void setCommPackage(String commPackage) {
//        this.commPackage = commPackage;
//    }
//
//    public String getCommissionTo() {
//        return commissionTo;
//    }
//
//    public void setCommissionTo(String commissionTo) {
//        this.commissionTo = commissionTo;
//    }
//
//
//
//    public String getLastSync() {
//        return lastSync;
//    }
//
//    public void setLastSync(String lastSync) {
//        this.lastSync = lastSync;
//    }
//
//    public String getLastSyncStatus() {
//        return lastSyncStatus;
//    }
//
//    public void setLastSyncStatus(String lastSyncStatus) {
//        this.lastSyncStatus = lastSyncStatus;
//    }
//
//
//
//    public String getSyncErrorMessage() {
//        return syncErrorMessage;
//    }
//
//    public void setSyncErrorMessage(String syncErrorMessage) {
//        this.syncErrorMessage = syncErrorMessage;
//    }
//
//
//
//    public Double getTotalCommissionOnQuote() {
//        return totalCommissionOnQuote;
//    }
//
//    public void setTotalCommissionOnQuote(Double totalCommissionOnQuote) {
//        this.totalCommissionOnQuote = totalCommissionOnQuote;
//    }
//
//
//    public String getShoulderEndDate() {
//        return shoulderEndDate;
//    }
//
//    public void setShoulderEndDate(String shoulderEndDate) {
//        this.shoulderEndDate = shoulderEndDate;
//    }
//
//    public String getShoulderStartDate() {
//        return shoulderStartDate;
//    }
//
//    public void setShoulderStartDate(String shoulderStartDate) {
//        this.shoulderStartDate = shoulderStartDate;
//    }
//
//    public Double getTotalInclTax() {
//        return totalInclTax;
//    }
//
//    public void setTotalInclTax(Double totalInclTax) {
//        this.totalInclTax = totalInclTax;
//    }
//
//    public Double getTotalHotelRoomInclTax() {
//        return totalHotelRoomInclTax;
//    }
//
//    public void setTotalHotelRoomInclTax(Double totalHotelRoomInclTax) {
//        this.totalHotelRoomInclTax = totalHotelRoomInclTax;
//    }
//
//    public Double getTotalMeetingRoomInclTax() {
//        return totalMeetingRoomInclTax;
//    }
//
//    public void setTotalMeetingRoomInclTax(Double totalMeetingRoomInclTax) {
//        this.totalMeetingRoomInclTax = totalMeetingRoomInclTax;
//    }
//
//    public Double getTotalProductInclTax() {
//        return totalProductInclTax;
//    }
//
//    public void setTotalProductInclTax(Double totalProductInclTax) {
//        this.totalProductInclTax = totalProductInclTax;
//    }
//
//    public Double getZtCountHR() {
//        return ztCountHR;
//    }
//
//    public void setZtCountHR(Double ztCountHR) {
//        this.ztCountHR = ztCountHR;
//    }
//
//    public String getReleaseDateFormula() {
//        return releaseDateFormula;
//    }
//
//    public void setReleaseDateFormula(String releaseDateFormula) {
//        this.releaseDateFormula = releaseDateFormula;
//    }
//
//    public String getGuestQuoteName() {
//        return guestQuoteName;
//    }
//
//    public void setGuestQuoteName(String guestQuoteName) {
//        this.guestQuoteName = guestQuoteName;
//    }
//
//    public String getReleaseDateFormula2() {
//        return releaseDateFormula2;
//    }
//
//    public void setReleaseDateFormula2(String releaseDateFormula2) {
//        this.releaseDateFormula2 = releaseDateFormula2;
//    }
//
//
//
//    public Double getPotentialMaxRevenueField() {
//        return potentialMaxRevenueField;
//    }
//
//    public void setPotentialMaxRevenueField(Double potentialMaxRevenueField) {
//        this.potentialMaxRevenueField = potentialMaxRevenueField;
//    }
//
//    public Double getPotentialMaxRevenueMR() {
//        return potentialMaxRevenueMR;
//    }
//
//    public void setPotentialMaxRevenueMR(Double potentialMaxRevenueMR) {
//        this.potentialMaxRevenueMR = potentialMaxRevenueMR;
//    }
//
//    public Double getPotentialMaxRevenuePackage() {
//        return potentialMaxRevenuePackage;
//    }
//
//    public void setPotentialMaxRevenuePackage(Double potentialMaxRevenuePackage) {
//        this.potentialMaxRevenuePackage = potentialMaxRevenuePackage;
//    }
//
//    public Double getPotentialMaxRevenueProduct() {
//        return potentialMaxRevenueProduct;
//    }
//
//    public void setPotentialMaxRevenueProduct(Double potentialMaxRevenueProduct) {
//        this.potentialMaxRevenueProduct = potentialMaxRevenueProduct;
//    }
//
//    public Double getTotalPaid() {
//        return totalPaid;
//    }
//
//    public void setTotalPaid(Double totalPaid) {
//        this.totalPaid = totalPaid;
//    }
//
//
//
//    public String getInventoryBlockType() {
//        return inventoryBlockType;
//    }
//
//    public void setInventoryBlockType(String inventoryBlockType) {
//        this.inventoryBlockType = inventoryBlockType;
//    }
//
//    public String getPmsCompany() {
//        return pmsCompany;
//    }
//
//    public void setPmsCompany(String pmsCompany) {
//        this.pmsCompany = pmsCompany;
//    }
//
//    public String getPmsGroup() {
//        return pmsGroup;
//    }
//
//    public void setPmsGroup(String pmsGroup) {
//        this.pmsGroup = pmsGroup;
//    }
//
//    public String getPmsSource() {
//        return pmsSource;
//    }
//
//    public void setPmsSource(String pmsSource) {
//        this.pmsSource = pmsSource;
//    }
//
//    public String getPmsTravelAgent() {
//        return pmsTravelAgent;
//    }
//
//    public void setPmsTravelAgent(String pmsTravelAgent) {
//        this.pmsTravelAgent = pmsTravelAgent;
//    }
//
//
//
//    public String getGuaranteeCode() {
//        return guaranteeCode;
//    }
//
//    public void setGuaranteeCode(String guaranteeCode) {
//        this.guaranteeCode = guaranteeCode;
//    }
//
//    public String getDietaryRequirementsLong() {
//        return dietaryRequirementsLong;
//    }
//
//    public void setDietaryRequirementsLong(String dietaryRequirementsLong) {
//        this.dietaryRequirementsLong = dietaryRequirementsLong;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getBlockRate() {
//        return blockRate;
//    }
//
//    public void setBlockRate(String blockRate) {
//        this.blockRate = blockRate;
//    }
//
//    public String getRatingStars() {
//        return ratingStars;
//    }
//
//    public void setRatingStars(String ratingStars) {
//        this.ratingStars = ratingStars;
//    }
//
//    public Double getPackageAmountInclTax() {
//        return packageAmountInclTax;
//    }
//
//    public void setPackageAmountInclTax(Double packageAmountInclTax) {
//        this.packageAmountInclTax = packageAmountInclTax;
//    }
//
//    public String getTaxCalculationLog() {
//        return taxCalculationLog;
//    }
//
//    public void setTaxCalculationLog(String taxCalculationLog) {
//        this.taxCalculationLog = taxCalculationLog;
//    }
//
//    public String getTaxGroupType() {
//        return taxGroupType;
//    }
//
//    public void setTaxGroupType(String taxGroupType) {
//        this.taxGroupType = taxGroupType;
//    }
//
//    public String getTaxLastCalculatedDate() {
//        return taxLastCalculatedDate;
//    }
//
//    public void setTaxLastCalculatedDate(String taxLastCalculatedDate) {
//        this.taxLastCalculatedDate = taxLastCalculatedDate;
//    }
//
//    public String getExpandedStatus() {
//        return expandedStatus;
//    }
//
//    public void setExpandedStatus(String expandedStatus) {
//        this.expandedStatus = expandedStatus;
//    }
}
