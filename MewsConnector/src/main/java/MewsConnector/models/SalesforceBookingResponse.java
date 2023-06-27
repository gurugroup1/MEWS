package MewsConnector.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceBookingResponse {
    Attributes AttributesObject;
    private String Id;
    private String OwnerId;
    private boolean IsDeleted;
    private String Name;
    private String CurrencyIsoCode;
    private String RecordTypeId;
    private String CreatedDate;
    private String CreatedById;
    private String LastModifiedDate;
    private String LastModifiedById;
    private String SystemModstamp;
    private String LastActivityDate;
    private String LastViewedDate;
    private String LastReferencedDate;
    private String thn__Accomodation_Notes__c = null;
    private String thn__Agent_Contact__c = null;
    private String thn__Agent__c = null;
    private String thn__Arrival_Date__c;
    private String thn__Arrival_Day__c;
    private String thn__Bill_to__c = null;
    private String thn__Billing_Account__c;
    private String thn__Billing_Address__c;
    private String thn__Business_Segment__c = null;
    private String thn__Catering_Notes__c = null;
    private String thn__Channel__c = null;
    private String thn__Closed_Status__c;
    private String thn__Comment__c = null;
    private String thn__Company_Contact__c;
    private String thn__Company__c;
    private float thn__Days_until_Arrival__c;
    private String thn__Departure_Date__c;
    private String thn__Departure_Day__c;
    private String thn__Deposit_Pay_Date__c;
    private float thn__Deposit__c;
    private String thn__Dietary_Requirements__c = null;
    private float thn__Duration__c;
    private boolean thn__FS_DatesCreated__c;
    private String thn__Hotel__c;
    private String thn__Internal_Notes__c = null;
    private String thn__Invoicing_Details__c = null;
    private boolean thn__Is_Confirmed__c;
    private String thn__Lost_Refused_Remarks__c = null;
    private String thn__Mews_Group_Id__c;
    private boolean thn__No_VAT__c;
    private float thn__Pax__c;
    private String thn__Probability__c = null;
    private String thn__Reason_Lost_Cancelled__c = null;
    private String thn__Request_Date__c;
    private String thn__Reservation_Guest__c;
    private boolean thn__SendToMews__c;
    private String thn__Source__c;
    private String thn__Stage__c;
    private String thn__Structured_Reference__c = null;
    private String thn__Subtype__c = null;
    private float thn__Total_Amount_excl_Tax__c;
    private float thn__Total_Amount_incl_Tax__c;
    private String thn__Type__c;
    private boolean thn__ZT_Calculate_subtotals__c;
    private float thn__Hotel_Rooms_Amount__c;
    private float thn__Meeting_Rooms_Amount__c;
    private float thn__Number_of_Packs__c;
    private float thn__Products_Amount__c;
    private float thn__Total_Tax__c;
    private String thn__Market_Segment__c = null;
    private String thn__Offer_Date__c = null;
    private String thn__Release_Date__c;
    private String thn__Signature_Date__c = null;
    private String thn__Purchase_order__c = null;
    private String thn__Send_and_sign_time_tag__c = null;
    private String thn__Signature_Name__c = null;
    private String thn__Signature_Title__c = null;
    private String thn__Signature_URL__c = null;
    private String thn__Request__c = null;
    private float thn__Balance__c;
    private String thn__Brief__c = null;
    private String thn__Cancellation_to_be_reported__c = null;
    private boolean thn__Create_Invoice__c;
    private String thn__Credit_to_be_reported__c = null;
    private String thn__Invoiced_Amount_HT__c = null;
    private String thn__Invoiced_Amount__c = null;
    private String thn__Invoiced_Amount_excl_Tax__c = null;
    private String thn__Invoiced_to_be_reported__c = null;
    private String thn__Paid_Amount__c = null;
    private String thn__Paid_Amount_on_Invoices__c = null;
    private boolean thn__Won__c;
    private String thn__ZT_Hotel_Name__c = null;
    private float thn__Total_VAT_Amount__c;
    private String thn__ACCOUNT_NAME__c;
    private String thn__ARRIVAL_DATE2__c;
    private String thn__AVG_RATE__c = null;
    private String thn__BEV_REVENUE__c = null;
    private String thn__BLOCKED__c = null;
    private String thn__Beverage__c = null;
    private String thn__CAT_MGR__c;
    private String thn__CAT_REVENUE__c = null;
    private String thn__CXL_REASON__c = null;
    private String thn__DECISION_DATE2__c = null;
    private String thn__DENIED_REASON__c = null;
    private String thn__DEPARTURE_DATE2__c;
    private String thn__FOOD_REVENUE__c = null;
    private String thn__Food__c = null;
    private String thn__INSERT_DATE2__c;
    private String thn__LOST_REASON__c = null;
    private String thn__MYCE_Quote_Id__c = null;
    private boolean thn__Markup__c;
    private String thn__Meeting_Room__c = null;
    private String thn__NET_ADR__c = null;
    private String thn__OFFER_SENT2__c = null;
    private String thn__ORIGINAL__c = null;
    private String thn__OTHERS__c = null;
    private String thn__Other__c = null;
    private String thn__PICKED_UP_NET_ADR__c = null;
    private String thn__PICKED_UP__c = null;
    private String thn__ROOM_MGR__c;
    private String thn__ROOM_RENTAL__c = null;
    private String thn__Room__c = null;
    private String thn__SAL_MGR__c;
    private String thn__SOURCE_MARKET__c = null;
    private String Quote_Number__c;
    private String thn__CUTOFF_DATE2__c;
    private String thn__CUTOFF_DATE__c;
    private String thn__D1__c;
    private String thn__D2__c;
    private String thn__D3__c;
    private String thn__D4__c;
    private String thn__DECISION_DATE__c = null;
    private String thn__DX__c;
    private boolean thn__Generate_Rooming_List__c;
    private String thn__INSERT_DATE__c;
    private String thn__OFFER_SENT__c = null;
    private float thn__TW__c;
    private float thn__W1__c;
    private float thn__W2__c;
    private float thn__W3__c;
    private float thn__W4__c;
    private String thn__Hotels__c;
    private String thn__Resort__c = null;
    private float thn__ZT_Count_MR__c;
    private float thn__ZT_Count_QP__c;
    private String thn__Number_Of_Nights__c = null;
    private float thn__Discount_Percent__c;
    private String thn__Public_URL__c = null;
    private String Competitor__c = null;
    private String Other_reason_lost_turndown_Cancelled__c = null;
    private String thn__Language__c;
    private String Account_reference__c = null;
    private String Origin__c;
    private String Internal__c = null;
    private String Dietary_Requirements2__c = null;
    private String Payment_methode__c;
    private String Signage__c = null;
    private String Deposit2__c = null;
    private String Deposit_3__c = null;
    private String Deposit_2_Pay_Date__c = null;
    private String Deposit_3_Pay_Date__c = null;
    private String Onsite_Contact__c = null;
    private String Onsite_Contact_Phone__c = null;
    private float days__c;
    private float Package_Amount_inc__c;
    private float Package_Amount__c;
    private String Start_time__c;
    private String Option_date__c;
    private float Total_rooms_booked__c;
    private String Quote_Notes__c = null;
    private boolean Excl_Tax__c;
    private float Discount_Meeting_rooms__c;
    private float Discount_Hotel_rooms__c;
    private float Discount_AV__c;
    private float Discount_No_AV__c;
    private float Discount_packages__c;
    private boolean Hide_floorplans__c;
    private float Deposit_1_VAT__c;
    private String Deposit_2_VAT__c = null;
    private String Deposit_3_VAT__c = null;
    private float Deposit_1_Amount__c;
    private String Deposit_2_Amount__c = null;
    private String Deposit_3_Amount__c = null;
    private String PO_Number__c = null;
    private String Logo_URL__c;
    private float Hotel_Rooms_Amount_inc__c;
    private float Meeting_Rooms_Amount_inc__c;
    private float Products_Amount_Inc__c;
    private boolean Request_AR__c;
    private boolean Afwijkende_voorwaarden__c;
    private String LS_reference__c = null;
    private String AR_Nummer__c = null;
    private String Image_header__c;
    private String Image_header2__c;
    private String Image_header3__c;
    private String Image_header4__c;
    private String Image_header5__c;
    private String Image_header6__c;
    private boolean Generate_Offer__c;
    private String Last_Offer_Generation__c = null;
    private float Rooms_amount_total__c;
    private String ADR_Incl__c = null;
    private boolean thn__Clone__c;
    private boolean Hide_about_us__c;
    private boolean Hide_picture_page__c;
    private String Proforma_referentie__c;
    private float Unique_number_proforma__c;
    private String thn__Accomodation_NotesLong__c = null;
    private String thn__Catering_NotesLong__c = null;
    private String thn__Internal_NotesLong__c;
    private String thn__Reservation_Guest_Name__c = null;
    private String Locale_for_Documents__c;
    private String Company_short_name__c;
    private String thn__Comm_Activity__c = null;
    private String thn__Comm_Beverage__c = null;
    private String thn__Comm_Equipment__c = null;
    private String thn__Comm_Food__c = null;
    private String thn__Comm_Hotel_Rooms__c = null;
    private String thn__Comm_Meeting_Rooms__c = null;
    private String thn__Comm_Other__c = null;
    private String thn__Comm_Package__c = null;
    private String thn__Commission_to__c = null;
    private boolean thn__Commissionable__c;
    private String thn__Last_Sync__c = null;
    private String thn__Last_sync_status__c = null;
    private String thn__Option_date__c = null;
    private boolean thn__Send_Failed_Reservations__c;
    private String thn__Sync_Error_Message__c = null;
    private boolean thn__Sync_with_Meeting_Package__c;
    private float thn__Total_Commission_on_Quote__c;
    private boolean thn__Create_PMS_Block__c;
    private String thn__Shoulder_End_Date__c;
    private String thn__Shoulder_Start_Date__c;
    private float thn__Total_incl_Tax__c;
    private float thn__Total_Hotel_Room_incl_Tax__c;
    private float thn__Total_Meeting_Room_incl_Tax__c;
    private float thn__Total_Product_incl_Tax__c;
    private float thn__ZT_Count_HR__c;
    private String Release_Date_formula__c;
    private String Guest_Quote_Name__c;
    private String thn__Release_date_formula__c;
    private boolean thn__PMS_Warning__c;
    private float thn__Potential_max_revenue_field__c;
    private float thn__Potential_max_revenue_MR__c;
    private float thn__Potential_max_revenue_Package__c;
    private float thn__Potential_max_revenue_Product__c;
    private float thn__Total_paid__c;
    private boolean thn__Complimentary__c;
    private String thn__InventoryBlockType__c;
    private String thn__PMS_Company__c;
    private String thn__PMS_Group__c;
    private String thn__PMS_Source__c = null;
    private String thn__PMS_Travel_Agent__c = null;
    private boolean thn__SendToPMS__c;
    private String thn__Guarantee_Code__c;
    private String thn__Origin__c = null;
    private String thn__Dietary_Requirements_Long__c = null;
    private String Status__c;
    private boolean Has_Error__c;
    private String thn__Block_Rate__c;
    private String thn__InvoicingDetails__c = null;
    private String Rating_Stars__c;
    private boolean thn__Individual_Pickup__c;
    private boolean thn__Send_Failed_PMS_Block__c;
    private float thn__Package_Amount_Incl_Tax__c;
    private float thn__Package_Amount__c;
    private String thn__Tax_Calculation_Log__c = null;
    private String thn__Tax_Group_Type__c;
    private String thn__Tax_Last_Calculated_Date__c = null;
    private String thn__Expanded_status__c;
    private String thn__Locale_for_Documents__c = null;


    // Getter Methods

    public Attributes getAttributes() {
        return AttributesObject;
    }

    public String getId() {
        return Id;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public boolean getIsDeleted() {
        return IsDeleted;
    }

    public String getName() {
        return Name;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public String getCreatedById() {
        return CreatedById;
    }

    public String getLastModifiedDate() {
        return LastModifiedDate;
    }

    public String getLastModifiedById() {
        return LastModifiedById;
    }

    public String getSystemModstamp() {
        return SystemModstamp;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public String getLastViewedDate() {
        return LastViewedDate;
    }

    public String getLastReferencedDate() {
        return LastReferencedDate;
    }

    public String getThn__Accomodation_Notes__c() {
        return thn__Accomodation_Notes__c;
    }

    public String getThn__Agent_Contact__c() {
        return thn__Agent_Contact__c;
    }

    public String getThn__Agent__c() {
        return thn__Agent__c;
    }

    public String getThn__Arrival_Date__c() {
        return thn__Arrival_Date__c;
    }

    public String getThn__Arrival_Day__c() {
        return thn__Arrival_Day__c;
    }

    public String getThn__Bill_to__c() {
        return thn__Bill_to__c;
    }

    public String getThn__Billing_Account__c() {
        return thn__Billing_Account__c;
    }

    public String getThn__Billing_Address__c() {
        return thn__Billing_Address__c;
    }

    public String getThn__Business_Segment__c() {
        return thn__Business_Segment__c;
    }

    public String getThn__Catering_Notes__c() {
        return thn__Catering_Notes__c;
    }

    public String getThn__Channel__c() {
        return thn__Channel__c;
    }

    public String getThn__Closed_Status__c() {
        return thn__Closed_Status__c;
    }

    public String getThn__Comment__c() {
        return thn__Comment__c;
    }

    public String getThn__Company_Contact__c() {
        return thn__Company_Contact__c;
    }

    public String getThn__Company__c() {
        return thn__Company__c;
    }

    public float getThn__Days_until_Arrival__c() {
        return thn__Days_until_Arrival__c;
    }

    public String getThn__Departure_Date__c() {
        return thn__Departure_Date__c;
    }

    public String getThn__Departure_Day__c() {
        return thn__Departure_Day__c;
    }

    public String getThn__Deposit_Pay_Date__c() {
        return thn__Deposit_Pay_Date__c;
    }

    public float getThn__Deposit__c() {
        return thn__Deposit__c;
    }

    public String getThn__Dietary_Requirements__c() {
        return thn__Dietary_Requirements__c;
    }

    public float getThn__Duration__c() {
        return thn__Duration__c;
    }

    public boolean getThn__FS_DatesCreated__c() {
        return thn__FS_DatesCreated__c;
    }

    public String getThn__Hotel__c() {
        return thn__Hotel__c;
    }

    public String getThn__Internal_Notes__c() {
        return thn__Internal_Notes__c;
    }

    public String getThn__Invoicing_Details__c() {
        return thn__Invoicing_Details__c;
    }

    public boolean getThn__Is_Confirmed__c() {
        return thn__Is_Confirmed__c;
    }

    public String getThn__Lost_Refused_Remarks__c() {
        return thn__Lost_Refused_Remarks__c;
    }

    public String getThn__Mews_Group_Id__c() {
        return thn__Mews_Group_Id__c;
    }

    public boolean getThn__No_VAT__c() {
        return thn__No_VAT__c;
    }

    public float getThn__Pax__c() {
        return thn__Pax__c;
    }

    public String getThn__Probability__c() {
        return thn__Probability__c;
    }

    public String getThn__Reason_Lost_Cancelled__c() {
        return thn__Reason_Lost_Cancelled__c;
    }

    public String getThn__Request_Date__c() {
        return thn__Request_Date__c;
    }

    public String getThn__Reservation_Guest__c() {
        return thn__Reservation_Guest__c;
    }

    public boolean getThn__SendToMews__c() {
        return thn__SendToMews__c;
    }

    public String getThn__Source__c() {
        return thn__Source__c;
    }

    public String getThn__Stage__c() {
        return thn__Stage__c;
    }

    public String getThn__Structured_Reference__c() {
        return thn__Structured_Reference__c;
    }

    public String getThn__Subtype__c() {
        return thn__Subtype__c;
    }

    public float getThn__Total_Amount_excl_Tax__c() {
        return thn__Total_Amount_excl_Tax__c;
    }

    public float getThn__Total_Amount_incl_Tax__c() {
        return thn__Total_Amount_incl_Tax__c;
    }

    public String getThn__Type__c() {
        return thn__Type__c;
    }

    public boolean getThn__ZT_Calculate_subtotals__c() {
        return thn__ZT_Calculate_subtotals__c;
    }

    public float getThn__Hotel_Rooms_Amount__c() {
        return thn__Hotel_Rooms_Amount__c;
    }

    public float getThn__Meeting_Rooms_Amount__c() {
        return thn__Meeting_Rooms_Amount__c;
    }

    public float getThn__Number_of_Packs__c() {
        return thn__Number_of_Packs__c;
    }

    public float getThn__Products_Amount__c() {
        return thn__Products_Amount__c;
    }

    public float getThn__Total_Tax__c() {
        return thn__Total_Tax__c;
    }

    public String getThn__Market_Segment__c() {
        return thn__Market_Segment__c;
    }

    public String getThn__Offer_Date__c() {
        return thn__Offer_Date__c;
    }

    public String getThn__Release_Date__c() {
        return thn__Release_Date__c;
    }

    public String getThn__Signature_Date__c() {
        return thn__Signature_Date__c;
    }

    public String getThn__Purchase_order__c() {
        return thn__Purchase_order__c;
    }

    public String getThn__Send_and_sign_time_tag__c() {
        return thn__Send_and_sign_time_tag__c;
    }

    public String getThn__Signature_Name__c() {
        return thn__Signature_Name__c;
    }

    public String getThn__Signature_Title__c() {
        return thn__Signature_Title__c;
    }

    public String getThn__Signature_URL__c() {
        return thn__Signature_URL__c;
    }

    public String getThn__Request__c() {
        return thn__Request__c;
    }

    public float getThn__Balance__c() {
        return thn__Balance__c;
    }

    public String getThn__Brief__c() {
        return thn__Brief__c;
    }

    public String getThn__Cancellation_to_be_reported__c() {
        return thn__Cancellation_to_be_reported__c;
    }

    public boolean getThn__Create_Invoice__c() {
        return thn__Create_Invoice__c;
    }

    public String getThn__Credit_to_be_reported__c() {
        return thn__Credit_to_be_reported__c;
    }

    public String getThn__Invoiced_Amount_HT__c() {
        return thn__Invoiced_Amount_HT__c;
    }

    public String getThn__Invoiced_Amount__c() {
        return thn__Invoiced_Amount__c;
    }

    public String getThn__Invoiced_Amount_excl_Tax__c() {
        return thn__Invoiced_Amount_excl_Tax__c;
    }

    public String getThn__Invoiced_to_be_reported__c() {
        return thn__Invoiced_to_be_reported__c;
    }

    public String getThn__Paid_Amount__c() {
        return thn__Paid_Amount__c;
    }

    public String getThn__Paid_Amount_on_Invoices__c() {
        return thn__Paid_Amount_on_Invoices__c;
    }

    public boolean getThn__Won__c() {
        return thn__Won__c;
    }

    public String getThn__ZT_Hotel_Name__c() {
        return thn__ZT_Hotel_Name__c;
    }

    public float getThn__Total_VAT_Amount__c() {
        return thn__Total_VAT_Amount__c;
    }

    public String getThn__ACCOUNT_NAME__c() {
        return thn__ACCOUNT_NAME__c;
    }

    public String getThn__ARRIVAL_DATE2__c() {
        return thn__ARRIVAL_DATE2__c;
    }

    public String getThn__AVG_RATE__c() {
        return thn__AVG_RATE__c;
    }

    public String getThn__BEV_REVENUE__c() {
        return thn__BEV_REVENUE__c;
    }

    public String getThn__BLOCKED__c() {
        return thn__BLOCKED__c;
    }

    public String getThn__Beverage__c() {
        return thn__Beverage__c;
    }

    public String getThn__CAT_MGR__c() {
        return thn__CAT_MGR__c;
    }

    public String getThn__CAT_REVENUE__c() {
        return thn__CAT_REVENUE__c;
    }

    public String getThn__CXL_REASON__c() {
        return thn__CXL_REASON__c;
    }

    public String getThn__DECISION_DATE2__c() {
        return thn__DECISION_DATE2__c;
    }

    public String getThn__DENIED_REASON__c() {
        return thn__DENIED_REASON__c;
    }

    public String getThn__DEPARTURE_DATE2__c() {
        return thn__DEPARTURE_DATE2__c;
    }

    public String getThn__FOOD_REVENUE__c() {
        return thn__FOOD_REVENUE__c;
    }

    public String getThn__Food__c() {
        return thn__Food__c;
    }

    public String getThn__INSERT_DATE2__c() {
        return thn__INSERT_DATE2__c;
    }

    public String getThn__LOST_REASON__c() {
        return thn__LOST_REASON__c;
    }

    public String getThn__MYCE_Quote_Id__c() {
        return thn__MYCE_Quote_Id__c;
    }

    public boolean getThn__Markup__c() {
        return thn__Markup__c;
    }

    public String getThn__Meeting_Room__c() {
        return thn__Meeting_Room__c;
    }

    public String getThn__NET_ADR__c() {
        return thn__NET_ADR__c;
    }

    public String getThn__OFFER_SENT2__c() {
        return thn__OFFER_SENT2__c;
    }

    public String getThn__ORIGINAL__c() {
        return thn__ORIGINAL__c;
    }

    public String getThn__OTHERS__c() {
        return thn__OTHERS__c;
    }

    public String getThn__Other__c() {
        return thn__Other__c;
    }

    public String getThn__PICKED_UP_NET_ADR__c() {
        return thn__PICKED_UP_NET_ADR__c;
    }

    public String getThn__PICKED_UP__c() {
        return thn__PICKED_UP__c;
    }

    public String getThn__ROOM_MGR__c() {
        return thn__ROOM_MGR__c;
    }

    public String getThn__ROOM_RENTAL__c() {
        return thn__ROOM_RENTAL__c;
    }

    public String getThn__Room__c() {
        return thn__Room__c;
    }

    public String getThn__SAL_MGR__c() {
        return thn__SAL_MGR__c;
    }

    public String getThn__SOURCE_MARKET__c() {
        return thn__SOURCE_MARKET__c;
    }

    public String getQuote_Number__c() {
        return Quote_Number__c;
    }

    public String getThn__CUTOFF_DATE2__c() {
        return thn__CUTOFF_DATE2__c;
    }

    public String getThn__CUTOFF_DATE__c() {
        return thn__CUTOFF_DATE__c;
    }

    public String getThn__D1__c() {
        return thn__D1__c;
    }

    public String getThn__D2__c() {
        return thn__D2__c;
    }

    public String getThn__D3__c() {
        return thn__D3__c;
    }

    public String getThn__D4__c() {
        return thn__D4__c;
    }

    public String getThn__DECISION_DATE__c() {
        return thn__DECISION_DATE__c;
    }

    public String getThn__DX__c() {
        return thn__DX__c;
    }

    public boolean getThn__Generate_Rooming_List__c() {
        return thn__Generate_Rooming_List__c;
    }

    public String getThn__INSERT_DATE__c() {
        return thn__INSERT_DATE__c;
    }

    public String getThn__OFFER_SENT__c() {
        return thn__OFFER_SENT__c;
    }

    public float getThn__TW__c() {
        return thn__TW__c;
    }

    public float getThn__W1__c() {
        return thn__W1__c;
    }

    public float getThn__W2__c() {
        return thn__W2__c;
    }

    public float getThn__W3__c() {
        return thn__W3__c;
    }

    public float getThn__W4__c() {
        return thn__W4__c;
    }

    public String getThn__Hotels__c() {
        return thn__Hotels__c;
    }

    public String getThn__Resort__c() {
        return thn__Resort__c;
    }

    public float getThn__ZT_Count_MR__c() {
        return thn__ZT_Count_MR__c;
    }

    public float getThn__ZT_Count_QP__c() {
        return thn__ZT_Count_QP__c;
    }

    public String getThn__Number_Of_Nights__c() {
        return thn__Number_Of_Nights__c;
    }

    public float getThn__Discount_Percent__c() {
        return thn__Discount_Percent__c;
    }

    public String getThn__Public_URL__c() {
        return thn__Public_URL__c;
    }

    public String getCompetitor__c() {
        return Competitor__c;
    }

    public String getOther_reason_lost_turndown_Cancelled__c() {
        return Other_reason_lost_turndown_Cancelled__c;
    }

    public String getThn__Language__c() {
        return thn__Language__c;
    }

    public String getAccount_reference__c() {
        return Account_reference__c;
    }

    public String getOrigin__c() {
        return Origin__c;
    }

    public String getInternal__c() {
        return Internal__c;
    }

    public String getDietary_Requirements2__c() {
        return Dietary_Requirements2__c;
    }

    public String getPayment_methode__c() {
        return Payment_methode__c;
    }

    public String getSignage__c() {
        return Signage__c;
    }

    public String getDeposit2__c() {
        return Deposit2__c;
    }

    public String getDeposit_3__c() {
        return Deposit_3__c;
    }

    public String getDeposit_2_Pay_Date__c() {
        return Deposit_2_Pay_Date__c;
    }

    public String getDeposit_3_Pay_Date__c() {
        return Deposit_3_Pay_Date__c;
    }

    public String getOnsite_Contact__c() {
        return Onsite_Contact__c;
    }

    public String getOnsite_Contact_Phone__c() {
        return Onsite_Contact_Phone__c;
    }

    public float getDays__c() {
        return days__c;
    }

    public float getPackage_Amount_inc__c() {
        return Package_Amount_inc__c;
    }

    public float getPackage_Amount__c() {
        return Package_Amount__c;
    }

    public String getStart_time__c() {
        return Start_time__c;
    }

    public String getOption_date__c() {
        return Option_date__c;
    }

    public float getTotal_rooms_booked__c() {
        return Total_rooms_booked__c;
    }

    public String getQuote_Notes__c() {
        return Quote_Notes__c;
    }

    public boolean getExcl_Tax__c() {
        return Excl_Tax__c;
    }

    public float getDiscount_Meeting_rooms__c() {
        return Discount_Meeting_rooms__c;
    }

    public float getDiscount_Hotel_rooms__c() {
        return Discount_Hotel_rooms__c;
    }

    public float getDiscount_AV__c() {
        return Discount_AV__c;
    }

    public float getDiscount_No_AV__c() {
        return Discount_No_AV__c;
    }

    public float getDiscount_packages__c() {
        return Discount_packages__c;
    }

    public boolean getHide_floorplans__c() {
        return Hide_floorplans__c;
    }

    public float getDeposit_1_VAT__c() {
        return Deposit_1_VAT__c;
    }

    public String getDeposit_2_VAT__c() {
        return Deposit_2_VAT__c;
    }

    public String getDeposit_3_VAT__c() {
        return Deposit_3_VAT__c;
    }

    public float getDeposit_1_Amount__c() {
        return Deposit_1_Amount__c;
    }

    public String getDeposit_2_Amount__c() {
        return Deposit_2_Amount__c;
    }

    public String getDeposit_3_Amount__c() {
        return Deposit_3_Amount__c;
    }

    public String getPO_Number__c() {
        return PO_Number__c;
    }

    public String getLogo_URL__c() {
        return Logo_URL__c;
    }

    public float getHotel_Rooms_Amount_inc__c() {
        return Hotel_Rooms_Amount_inc__c;
    }

    public float getMeeting_Rooms_Amount_inc__c() {
        return Meeting_Rooms_Amount_inc__c;
    }

    public float getProducts_Amount_Inc__c() {
        return Products_Amount_Inc__c;
    }

    public boolean getRequest_AR__c() {
        return Request_AR__c;
    }

    public boolean getAfwijkende_voorwaarden__c() {
        return Afwijkende_voorwaarden__c;
    }

    public String getLS_reference__c() {
        return LS_reference__c;
    }

    public String getAR_Nummer__c() {
        return AR_Nummer__c;
    }

    public String getImage_header__c() {
        return Image_header__c;
    }

    public String getImage_header2__c() {
        return Image_header2__c;
    }

    public String getImage_header3__c() {
        return Image_header3__c;
    }

    public String getImage_header4__c() {
        return Image_header4__c;
    }

    public String getImage_header5__c() {
        return Image_header5__c;
    }

    public String getImage_header6__c() {
        return Image_header6__c;
    }

    public boolean getGenerate_Offer__c() {
        return Generate_Offer__c;
    }

    public String getLast_Offer_Generation__c() {
        return Last_Offer_Generation__c;
    }

    public float getRooms_amount_total__c() {
        return Rooms_amount_total__c;
    }

    public String getADR_Incl__c() {
        return ADR_Incl__c;
    }

    public boolean getThn__Clone__c() {
        return thn__Clone__c;
    }

    public boolean getHide_about_us__c() {
        return Hide_about_us__c;
    }

    public boolean getHide_picture_page__c() {
        return Hide_picture_page__c;
    }

    public String getProforma_referentie__c() {
        return Proforma_referentie__c;
    }

    public float getUnique_number_proforma__c() {
        return Unique_number_proforma__c;
    }

    public String getThn__Accomodation_NotesLong__c() {
        return thn__Accomodation_NotesLong__c;
    }

    public String getThn__Catering_NotesLong__c() {
        return thn__Catering_NotesLong__c;
    }

    public String getThn__Internal_NotesLong__c() {
        return thn__Internal_NotesLong__c;
    }

    public String getThn__Reservation_Guest_Name__c() {
        return thn__Reservation_Guest_Name__c;
    }

    public String getLocale_for_Documents__c() {
        return Locale_for_Documents__c;
    }

    public String getCompany_short_name__c() {
        return Company_short_name__c;
    }

    public String getThn__Comm_Activity__c() {
        return thn__Comm_Activity__c;
    }

    public String getThn__Comm_Beverage__c() {
        return thn__Comm_Beverage__c;
    }

    public String getThn__Comm_Equipment__c() {
        return thn__Comm_Equipment__c;
    }

    public String getThn__Comm_Food__c() {
        return thn__Comm_Food__c;
    }

    public String getThn__Comm_Hotel_Rooms__c() {
        return thn__Comm_Hotel_Rooms__c;
    }

    public String getThn__Comm_Meeting_Rooms__c() {
        return thn__Comm_Meeting_Rooms__c;
    }

    public String getThn__Comm_Other__c() {
        return thn__Comm_Other__c;
    }

    public String getThn__Comm_Package__c() {
        return thn__Comm_Package__c;
    }

    public String getThn__Commission_to__c() {
        return thn__Commission_to__c;
    }

    public boolean getThn__Commissionable__c() {
        return thn__Commissionable__c;
    }

    public String getThn__Last_Sync__c() {
        return thn__Last_Sync__c;
    }

    public String getThn__Last_sync_status__c() {
        return thn__Last_sync_status__c;
    }

    public String getThn__Option_date__c() {
        return thn__Option_date__c;
    }

    public boolean getThn__Send_Failed_Reservations__c() {
        return thn__Send_Failed_Reservations__c;
    }

    public String getThn__Sync_Error_Message__c() {
        return thn__Sync_Error_Message__c;
    }

    public boolean getThn__Sync_with_Meeting_Package__c() {
        return thn__Sync_with_Meeting_Package__c;
    }

    public float getThn__Total_Commission_on_Quote__c() {
        return thn__Total_Commission_on_Quote__c;
    }

    public boolean getThn__Create_PMS_Block__c() {
        return thn__Create_PMS_Block__c;
    }

    public String getThn__Shoulder_End_Date__c() {
        return thn__Shoulder_End_Date__c;
    }

    public String getThn__Shoulder_Start_Date__c() {
        return thn__Shoulder_Start_Date__c;
    }

    public float getThn__Total_incl_Tax__c() {
        return thn__Total_incl_Tax__c;
    }

    public float getThn__Total_Hotel_Room_incl_Tax__c() {
        return thn__Total_Hotel_Room_incl_Tax__c;
    }

    public float getThn__Total_Meeting_Room_incl_Tax__c() {
        return thn__Total_Meeting_Room_incl_Tax__c;
    }

    public float getThn__Total_Product_incl_Tax__c() {
        return thn__Total_Product_incl_Tax__c;
    }

    public float getThn__ZT_Count_HR__c() {
        return thn__ZT_Count_HR__c;
    }

    public String getRelease_Date_formula__c() {
        return Release_Date_formula__c;
    }

    public String getGuest_Quote_Name__c() {
        return Guest_Quote_Name__c;
    }

    public String getThn__Release_date_formula__c() {
        return thn__Release_date_formula__c;
    }

    public boolean getThn__PMS_Warning__c() {
        return thn__PMS_Warning__c;
    }

    public float getThn__Potential_max_revenue_field__c() {
        return thn__Potential_max_revenue_field__c;
    }

    public float getThn__Potential_max_revenue_MR__c() {
        return thn__Potential_max_revenue_MR__c;
    }

    public float getThn__Potential_max_revenue_Package__c() {
        return thn__Potential_max_revenue_Package__c;
    }

    public float getThn__Potential_max_revenue_Product__c() {
        return thn__Potential_max_revenue_Product__c;
    }

    public float getThn__Total_paid__c() {
        return thn__Total_paid__c;
    }

    public boolean getThn__Complimentary__c() {
        return thn__Complimentary__c;
    }

    public String getThn__InventoryBlockType__c() {
        return thn__InventoryBlockType__c;
    }

    public String getThn__PMS_Company__c() {
        return thn__PMS_Company__c;
    }

    public String getThn__PMS_Group__c() {
        return thn__PMS_Group__c;
    }

    public String getThn__PMS_Source__c() {
        return thn__PMS_Source__c;
    }

    public String getThn__PMS_Travel_Agent__c() {
        return thn__PMS_Travel_Agent__c;
    }

    public boolean getThn__SendToPMS__c() {
        return thn__SendToPMS__c;
    }

    public String getThn__Guarantee_Code__c() {
        return thn__Guarantee_Code__c;
    }

    public String getThn__Origin__c() {
        return thn__Origin__c;
    }

    public String getThn__Dietary_Requirements_Long__c() {
        return thn__Dietary_Requirements_Long__c;
    }

    public String getStatus__c() {
        return Status__c;
    }

    public boolean getHas_Error__c() {
        return Has_Error__c;
    }

    public String getThn__Block_Rate__c() {
        return thn__Block_Rate__c;
    }

    public String getThn__InvoicingDetails__c() {
        return thn__InvoicingDetails__c;
    }

    public String getRating_Stars__c() {
        return Rating_Stars__c;
    }

    public boolean getThn__Individual_Pickup__c() {
        return thn__Individual_Pickup__c;
    }

    public boolean getThn__Send_Failed_PMS_Block__c() {
        return thn__Send_Failed_PMS_Block__c;
    }

    public float getThn__Package_Amount_Incl_Tax__c() {
        return thn__Package_Amount_Incl_Tax__c;
    }

    public float getThn__Package_Amount__c() {
        return thn__Package_Amount__c;
    }

    public String getThn__Tax_Calculation_Log__c() {
        return thn__Tax_Calculation_Log__c;
    }

    public String getThn__Tax_Group_Type__c() {
        return thn__Tax_Group_Type__c;
    }

    public String getThn__Tax_Last_Calculated_Date__c() {
        return thn__Tax_Last_Calculated_Date__c;
    }

    public String getThn__Expanded_status__c() {
        return thn__Expanded_status__c;
    }

    public String getThn__Locale_for_Documents__c() {
        return thn__Locale_for_Documents__c;
    }

    // Setter Methods

    public void setAttributes( Attributes attributesObject ) {
        this.AttributesObject = attributesObject;
    }

    public void setId( String Id ) {
        this.Id = Id;
    }

    public void setOwnerId( String OwnerId ) {
        this.OwnerId = OwnerId;
    }

    public void setIsDeleted( boolean IsDeleted ) {
        this.IsDeleted = IsDeleted;
    }

    public void setName( String Name ) {
        this.Name = Name;
    }

    public void setCurrencyIsoCode( String CurrencyIsoCode ) {
        this.CurrencyIsoCode = CurrencyIsoCode;
    }

    public void setRecordTypeId( String RecordTypeId ) {
        this.RecordTypeId = RecordTypeId;
    }

    public void setCreatedDate( String CreatedDate ) {
        this.CreatedDate = CreatedDate;
    }

    public void setCreatedById( String CreatedById ) {
        this.CreatedById = CreatedById;
    }

    public void setLastModifiedDate( String LastModifiedDate ) {
        this.LastModifiedDate = LastModifiedDate;
    }

    public void setLastModifiedById( String LastModifiedById ) {
        this.LastModifiedById = LastModifiedById;
    }

    public void setSystemModstamp( String SystemModstamp ) {
        this.SystemModstamp = SystemModstamp;
    }

    public void setLastActivityDate( String LastActivityDate ) {
        this.LastActivityDate = LastActivityDate;
    }

    public void setLastViewedDate( String LastViewedDate ) {
        this.LastViewedDate = LastViewedDate;
    }

    public void setLastReferencedDate( String LastReferencedDate ) {
        this.LastReferencedDate = LastReferencedDate;
    }

    public void setThn__Accomodation_Notes__c( String thn__Accomodation_Notes__c ) {
        this.thn__Accomodation_Notes__c = thn__Accomodation_Notes__c;
    }

    public void setThn__Agent_Contact__c( String thn__Agent_Contact__c ) {
        this.thn__Agent_Contact__c = thn__Agent_Contact__c;
    }

    public void setThn__Agent__c( String thn__Agent__c ) {
        this.thn__Agent__c = thn__Agent__c;
    }

    public void setThn__Arrival_Date__c( String thn__Arrival_Date__c ) {
        this.thn__Arrival_Date__c = thn__Arrival_Date__c;
    }

    public void setThn__Arrival_Day__c( String thn__Arrival_Day__c ) {
        this.thn__Arrival_Day__c = thn__Arrival_Day__c;
    }

    public void setThn__Bill_to__c( String thn__Bill_to__c ) {
        this.thn__Bill_to__c = thn__Bill_to__c;
    }

    public void setThn__Billing_Account__c( String thn__Billing_Account__c ) {
        this.thn__Billing_Account__c = thn__Billing_Account__c;
    }

    public void setThn__Billing_Address__c( String thn__Billing_Address__c ) {
        this.thn__Billing_Address__c = thn__Billing_Address__c;
    }

    public void setThn__Business_Segment__c( String thn__Business_Segment__c ) {
        this.thn__Business_Segment__c = thn__Business_Segment__c;
    }

    public void setThn__Catering_Notes__c( String thn__Catering_Notes__c ) {
        this.thn__Catering_Notes__c = thn__Catering_Notes__c;
    }

    public void setThn__Channel__c( String thn__Channel__c ) {
        this.thn__Channel__c = thn__Channel__c;
    }

    public void setThn__Closed_Status__c( String thn__Closed_Status__c ) {
        this.thn__Closed_Status__c = thn__Closed_Status__c;
    }

    public void setThn__Comment__c( String thn__Comment__c ) {
        this.thn__Comment__c = thn__Comment__c;
    }

    public void setThn__Company_Contact__c( String thn__Company_Contact__c ) {
        this.thn__Company_Contact__c = thn__Company_Contact__c;
    }

    public void setThn__Company__c( String thn__Company__c ) {
        this.thn__Company__c = thn__Company__c;
    }

    public void setThn__Days_until_Arrival__c( float thn__Days_until_Arrival__c ) {
        this.thn__Days_until_Arrival__c = thn__Days_until_Arrival__c;
    }

    public void setThn__Departure_Date__c( String thn__Departure_Date__c ) {
        this.thn__Departure_Date__c = thn__Departure_Date__c;
    }

    public void setThn__Departure_Day__c( String thn__Departure_Day__c ) {
        this.thn__Departure_Day__c = thn__Departure_Day__c;
    }

    public void setThn__Deposit_Pay_Date__c( String thn__Deposit_Pay_Date__c ) {
        this.thn__Deposit_Pay_Date__c = thn__Deposit_Pay_Date__c;
    }

    public void setThn__Deposit__c( float thn__Deposit__c ) {
        this.thn__Deposit__c = thn__Deposit__c;
    }

    public void setThn__Dietary_Requirements__c( String thn__Dietary_Requirements__c ) {
        this.thn__Dietary_Requirements__c = thn__Dietary_Requirements__c;
    }

    public void setThn__Duration__c( float thn__Duration__c ) {
        this.thn__Duration__c = thn__Duration__c;
    }

    public void setThn__FS_DatesCreated__c( boolean thn__FS_DatesCreated__c ) {
        this.thn__FS_DatesCreated__c = thn__FS_DatesCreated__c;
    }

    public void setThn__Hotel__c( String thn__Hotel__c ) {
        this.thn__Hotel__c = thn__Hotel__c;
    }

    public void setThn__Internal_Notes__c( String thn__Internal_Notes__c ) {
        this.thn__Internal_Notes__c = thn__Internal_Notes__c;
    }

    public void setThn__Invoicing_Details__c( String thn__Invoicing_Details__c ) {
        this.thn__Invoicing_Details__c = thn__Invoicing_Details__c;
    }

    public void setThn__Is_Confirmed__c( boolean thn__Is_Confirmed__c ) {
        this.thn__Is_Confirmed__c = thn__Is_Confirmed__c;
    }

    public void setThn__Lost_Refused_Remarks__c( String thn__Lost_Refused_Remarks__c ) {
        this.thn__Lost_Refused_Remarks__c = thn__Lost_Refused_Remarks__c;
    }

    public void setThn__Mews_Group_Id__c( String thn__Mews_Group_Id__c ) {
        this.thn__Mews_Group_Id__c = thn__Mews_Group_Id__c;
    }

    public void setThn__No_VAT__c( boolean thn__No_VAT__c ) {
        this.thn__No_VAT__c = thn__No_VAT__c;
    }

    public void setThn__Pax__c( float thn__Pax__c ) {
        this.thn__Pax__c = thn__Pax__c;
    }

    public void setThn__Probability__c( String thn__Probability__c ) {
        this.thn__Probability__c = thn__Probability__c;
    }

    public void setThn__Reason_Lost_Cancelled__c( String thn__Reason_Lost_Cancelled__c ) {
        this.thn__Reason_Lost_Cancelled__c = thn__Reason_Lost_Cancelled__c;
    }

    public void setThn__Request_Date__c( String thn__Request_Date__c ) {
        this.thn__Request_Date__c = thn__Request_Date__c;
    }

    public void setThn__Reservation_Guest__c( String thn__Reservation_Guest__c ) {
        this.thn__Reservation_Guest__c = thn__Reservation_Guest__c;
    }

    public void setThn__SendToMews__c( boolean thn__SendToMews__c ) {
        this.thn__SendToMews__c = thn__SendToMews__c;
    }

    public void setThn__Source__c( String thn__Source__c ) {
        this.thn__Source__c = thn__Source__c;
    }

    public void setThn__Stage__c( String thn__Stage__c ) {
        this.thn__Stage__c = thn__Stage__c;
    }

    public void setThn__Structured_Reference__c( String thn__Structured_Reference__c ) {
        this.thn__Structured_Reference__c = thn__Structured_Reference__c;
    }

    public void setThn__Subtype__c( String thn__Subtype__c ) {
        this.thn__Subtype__c = thn__Subtype__c;
    }

    public void setThn__Total_Amount_excl_Tax__c( float thn__Total_Amount_excl_Tax__c ) {
        this.thn__Total_Amount_excl_Tax__c = thn__Total_Amount_excl_Tax__c;
    }

    public void setThn__Total_Amount_incl_Tax__c( float thn__Total_Amount_incl_Tax__c ) {
        this.thn__Total_Amount_incl_Tax__c = thn__Total_Amount_incl_Tax__c;
    }

    public void setThn__Type__c( String thn__Type__c ) {
        this.thn__Type__c = thn__Type__c;
    }

    public void setThn__ZT_Calculate_subtotals__c( boolean thn__ZT_Calculate_subtotals__c ) {
        this.thn__ZT_Calculate_subtotals__c = thn__ZT_Calculate_subtotals__c;
    }

    public void setThn__Hotel_Rooms_Amount__c( float thn__Hotel_Rooms_Amount__c ) {
        this.thn__Hotel_Rooms_Amount__c = thn__Hotel_Rooms_Amount__c;
    }

    public void setThn__Meeting_Rooms_Amount__c( float thn__Meeting_Rooms_Amount__c ) {
        this.thn__Meeting_Rooms_Amount__c = thn__Meeting_Rooms_Amount__c;
    }

    public void setThn__Number_of_Packs__c( float thn__Number_of_Packs__c ) {
        this.thn__Number_of_Packs__c = thn__Number_of_Packs__c;
    }

    public void setThn__Products_Amount__c( float thn__Products_Amount__c ) {
        this.thn__Products_Amount__c = thn__Products_Amount__c;
    }

    public void setThn__Total_Tax__c( float thn__Total_Tax__c ) {
        this.thn__Total_Tax__c = thn__Total_Tax__c;
    }

    public void setThn__Market_Segment__c( String thn__Market_Segment__c ) {
        this.thn__Market_Segment__c = thn__Market_Segment__c;
    }

    public void setThn__Offer_Date__c( String thn__Offer_Date__c ) {
        this.thn__Offer_Date__c = thn__Offer_Date__c;
    }

    public void setThn__Release_Date__c( String thn__Release_Date__c ) {
        this.thn__Release_Date__c = thn__Release_Date__c;
    }

    public void setThn__Signature_Date__c( String thn__Signature_Date__c ) {
        this.thn__Signature_Date__c = thn__Signature_Date__c;
    }

    public void setThn__Purchase_order__c( String thn__Purchase_order__c ) {
        this.thn__Purchase_order__c = thn__Purchase_order__c;
    }

    public void setThn__Send_and_sign_time_tag__c( String thn__Send_and_sign_time_tag__c ) {
        this.thn__Send_and_sign_time_tag__c = thn__Send_and_sign_time_tag__c;
    }

    public void setThn__Signature_Name__c( String thn__Signature_Name__c ) {
        this.thn__Signature_Name__c = thn__Signature_Name__c;
    }

    public void setThn__Signature_Title__c( String thn__Signature_Title__c ) {
        this.thn__Signature_Title__c = thn__Signature_Title__c;
    }

    public void setThn__Signature_URL__c( String thn__Signature_URL__c ) {
        this.thn__Signature_URL__c = thn__Signature_URL__c;
    }

    public void setThn__Request__c( String thn__Request__c ) {
        this.thn__Request__c = thn__Request__c;
    }

    public void setThn__Balance__c( float thn__Balance__c ) {
        this.thn__Balance__c = thn__Balance__c;
    }

    public void setThn__Brief__c( String thn__Brief__c ) {
        this.thn__Brief__c = thn__Brief__c;
    }

    public void setThn__Cancellation_to_be_reported__c( String thn__Cancellation_to_be_reported__c ) {
        this.thn__Cancellation_to_be_reported__c = thn__Cancellation_to_be_reported__c;
    }

    public void setThn__Create_Invoice__c( boolean thn__Create_Invoice__c ) {
        this.thn__Create_Invoice__c = thn__Create_Invoice__c;
    }

    public void setThn__Credit_to_be_reported__c( String thn__Credit_to_be_reported__c ) {
        this.thn__Credit_to_be_reported__c = thn__Credit_to_be_reported__c;
    }

    public void setThn__Invoiced_Amount_HT__c( String thn__Invoiced_Amount_HT__c ) {
        this.thn__Invoiced_Amount_HT__c = thn__Invoiced_Amount_HT__c;
    }

    public void setThn__Invoiced_Amount__c( String thn__Invoiced_Amount__c ) {
        this.thn__Invoiced_Amount__c = thn__Invoiced_Amount__c;
    }

    public void setThn__Invoiced_Amount_excl_Tax__c( String thn__Invoiced_Amount_excl_Tax__c ) {
        this.thn__Invoiced_Amount_excl_Tax__c = thn__Invoiced_Amount_excl_Tax__c;
    }

    public void setThn__Invoiced_to_be_reported__c( String thn__Invoiced_to_be_reported__c ) {
        this.thn__Invoiced_to_be_reported__c = thn__Invoiced_to_be_reported__c;
    }

    public void setThn__Paid_Amount__c( String thn__Paid_Amount__c ) {
        this.thn__Paid_Amount__c = thn__Paid_Amount__c;
    }

    public void setThn__Paid_Amount_on_Invoices__c( String thn__Paid_Amount_on_Invoices__c ) {
        this.thn__Paid_Amount_on_Invoices__c = thn__Paid_Amount_on_Invoices__c;
    }

    public void setThn__Won__c( boolean thn__Won__c ) {
        this.thn__Won__c = thn__Won__c;
    }

    public void setThn__ZT_Hotel_Name__c( String thn__ZT_Hotel_Name__c ) {
        this.thn__ZT_Hotel_Name__c = thn__ZT_Hotel_Name__c;
    }

    public void setThn__Total_VAT_Amount__c( float thn__Total_VAT_Amount__c ) {
        this.thn__Total_VAT_Amount__c = thn__Total_VAT_Amount__c;
    }

    public void setThn__ACCOUNT_NAME__c( String thn__ACCOUNT_NAME__c ) {
        this.thn__ACCOUNT_NAME__c = thn__ACCOUNT_NAME__c;
    }

    public void setThn__ARRIVAL_DATE2__c( String thn__ARRIVAL_DATE2__c ) {
        this.thn__ARRIVAL_DATE2__c = thn__ARRIVAL_DATE2__c;
    }

    public void setThn__AVG_RATE__c( String thn__AVG_RATE__c ) {
        this.thn__AVG_RATE__c = thn__AVG_RATE__c;
    }

    public void setThn__BEV_REVENUE__c( String thn__BEV_REVENUE__c ) {
        this.thn__BEV_REVENUE__c = thn__BEV_REVENUE__c;
    }

    public void setThn__BLOCKED__c( String thn__BLOCKED__c ) {
        this.thn__BLOCKED__c = thn__BLOCKED__c;
    }

    public void setThn__Beverage__c( String thn__Beverage__c ) {
        this.thn__Beverage__c = thn__Beverage__c;
    }

    public void setThn__CAT_MGR__c( String thn__CAT_MGR__c ) {
        this.thn__CAT_MGR__c = thn__CAT_MGR__c;
    }

    public void setThn__CAT_REVENUE__c( String thn__CAT_REVENUE__c ) {
        this.thn__CAT_REVENUE__c = thn__CAT_REVENUE__c;
    }

    public void setThn__CXL_REASON__c( String thn__CXL_REASON__c ) {
        this.thn__CXL_REASON__c = thn__CXL_REASON__c;
    }

    public void setThn__DECISION_DATE2__c( String thn__DECISION_DATE2__c ) {
        this.thn__DECISION_DATE2__c = thn__DECISION_DATE2__c;
    }

    public void setThn__DENIED_REASON__c( String thn__DENIED_REASON__c ) {
        this.thn__DENIED_REASON__c = thn__DENIED_REASON__c;
    }

    public void setThn__DEPARTURE_DATE2__c( String thn__DEPARTURE_DATE2__c ) {
        this.thn__DEPARTURE_DATE2__c = thn__DEPARTURE_DATE2__c;
    }

    public void setThn__FOOD_REVENUE__c( String thn__FOOD_REVENUE__c ) {
        this.thn__FOOD_REVENUE__c = thn__FOOD_REVENUE__c;
    }

    public void setThn__Food__c( String thn__Food__c ) {
        this.thn__Food__c = thn__Food__c;
    }

    public void setThn__INSERT_DATE2__c( String thn__INSERT_DATE2__c ) {
        this.thn__INSERT_DATE2__c = thn__INSERT_DATE2__c;
    }

    public void setThn__LOST_REASON__c( String thn__LOST_REASON__c ) {
        this.thn__LOST_REASON__c = thn__LOST_REASON__c;
    }

    public void setThn__MYCE_Quote_Id__c( String thn__MYCE_Quote_Id__c ) {
        this.thn__MYCE_Quote_Id__c = thn__MYCE_Quote_Id__c;
    }

    public void setThn__Markup__c( boolean thn__Markup__c ) {
        this.thn__Markup__c = thn__Markup__c;
    }

    public void setThn__Meeting_Room__c( String thn__Meeting_Room__c ) {
        this.thn__Meeting_Room__c = thn__Meeting_Room__c;
    }

    public void setThn__NET_ADR__c( String thn__NET_ADR__c ) {
        this.thn__NET_ADR__c = thn__NET_ADR__c;
    }

    public void setThn__OFFER_SENT2__c( String thn__OFFER_SENT2__c ) {
        this.thn__OFFER_SENT2__c = thn__OFFER_SENT2__c;
    }

    public void setThn__ORIGINAL__c( String thn__ORIGINAL__c ) {
        this.thn__ORIGINAL__c = thn__ORIGINAL__c;
    }

    public void setThn__OTHERS__c( String thn__OTHERS__c ) {
        this.thn__OTHERS__c = thn__OTHERS__c;
    }

    public void setThn__Other__c( String thn__Other__c ) {
        this.thn__Other__c = thn__Other__c;
    }

    public void setThn__PICKED_UP_NET_ADR__c( String thn__PICKED_UP_NET_ADR__c ) {
        this.thn__PICKED_UP_NET_ADR__c = thn__PICKED_UP_NET_ADR__c;
    }

    public void setThn__PICKED_UP__c( String thn__PICKED_UP__c ) {
        this.thn__PICKED_UP__c = thn__PICKED_UP__c;
    }

    public void setThn__ROOM_MGR__c( String thn__ROOM_MGR__c ) {
        this.thn__ROOM_MGR__c = thn__ROOM_MGR__c;
    }

    public void setThn__ROOM_RENTAL__c( String thn__ROOM_RENTAL__c ) {
        this.thn__ROOM_RENTAL__c = thn__ROOM_RENTAL__c;
    }

    public void setThn__Room__c( String thn__Room__c ) {
        this.thn__Room__c = thn__Room__c;
    }

    public void setThn__SAL_MGR__c( String thn__SAL_MGR__c ) {
        this.thn__SAL_MGR__c = thn__SAL_MGR__c;
    }

    public void setThn__SOURCE_MARKET__c( String thn__SOURCE_MARKET__c ) {
        this.thn__SOURCE_MARKET__c = thn__SOURCE_MARKET__c;
    }

    public void setQuote_Number__c( String Quote_Number__c ) {
        this.Quote_Number__c = Quote_Number__c;
    }

    public void setThn__CUTOFF_DATE2__c( String thn__CUTOFF_DATE2__c ) {
        this.thn__CUTOFF_DATE2__c = thn__CUTOFF_DATE2__c;
    }

    public void setThn__CUTOFF_DATE__c( String thn__CUTOFF_DATE__c ) {
        this.thn__CUTOFF_DATE__c = thn__CUTOFF_DATE__c;
    }

    public void setThn__D1__c( String thn__D1__c ) {
        this.thn__D1__c = thn__D1__c;
    }

    public void setThn__D2__c( String thn__D2__c ) {
        this.thn__D2__c = thn__D2__c;
    }

    public void setThn__D3__c( String thn__D3__c ) {
        this.thn__D3__c = thn__D3__c;
    }

    public void setThn__D4__c( String thn__D4__c ) {
        this.thn__D4__c = thn__D4__c;
    }

    public void setThn__DECISION_DATE__c( String thn__DECISION_DATE__c ) {
        this.thn__DECISION_DATE__c = thn__DECISION_DATE__c;
    }

    public void setThn__DX__c( String thn__DX__c ) {
        this.thn__DX__c = thn__DX__c;
    }

    public void setThn__Generate_Rooming_List__c( boolean thn__Generate_Rooming_List__c ) {
        this.thn__Generate_Rooming_List__c = thn__Generate_Rooming_List__c;
    }

    public void setThn__INSERT_DATE__c( String thn__INSERT_DATE__c ) {
        this.thn__INSERT_DATE__c = thn__INSERT_DATE__c;
    }

    public void setThn__OFFER_SENT__c( String thn__OFFER_SENT__c ) {
        this.thn__OFFER_SENT__c = thn__OFFER_SENT__c;
    }

    public void setThn__TW__c( float thn__TW__c ) {
        this.thn__TW__c = thn__TW__c;
    }

    public void setThn__W1__c( float thn__W1__c ) {
        this.thn__W1__c = thn__W1__c;
    }

    public void setThn__W2__c( float thn__W2__c ) {
        this.thn__W2__c = thn__W2__c;
    }

    public void setThn__W3__c( float thn__W3__c ) {
        this.thn__W3__c = thn__W3__c;
    }

    public void setThn__W4__c( float thn__W4__c ) {
        this.thn__W4__c = thn__W4__c;
    }

    public void setThn__Hotels__c( String thn__Hotels__c ) {
        this.thn__Hotels__c = thn__Hotels__c;
    }

    public void setThn__Resort__c( String thn__Resort__c ) {
        this.thn__Resort__c = thn__Resort__c;
    }

    public void setThn__ZT_Count_MR__c( float thn__ZT_Count_MR__c ) {
        this.thn__ZT_Count_MR__c = thn__ZT_Count_MR__c;
    }

    public void setThn__ZT_Count_QP__c( float thn__ZT_Count_QP__c ) {
        this.thn__ZT_Count_QP__c = thn__ZT_Count_QP__c;
    }

    public void setThn__Number_Of_Nights__c( String thn__Number_Of_Nights__c ) {
        this.thn__Number_Of_Nights__c = thn__Number_Of_Nights__c;
    }

    public void setThn__Discount_Percent__c( float thn__Discount_Percent__c ) {
        this.thn__Discount_Percent__c = thn__Discount_Percent__c;
    }

    public void setThn__Public_URL__c( String thn__Public_URL__c ) {
        this.thn__Public_URL__c = thn__Public_URL__c;
    }

    public void setCompetitor__c( String Competitor__c ) {
        this.Competitor__c = Competitor__c;
    }

    public void setOther_reason_lost_turndown_Cancelled__c( String Other_reason_lost_turndown_Cancelled__c ) {
        this.Other_reason_lost_turndown_Cancelled__c = Other_reason_lost_turndown_Cancelled__c;
    }

    public void setThn__Language__c( String thn__Language__c ) {
        this.thn__Language__c = thn__Language__c;
    }

    public void setAccount_reference__c( String Account_reference__c ) {
        this.Account_reference__c = Account_reference__c;
    }

    public void setOrigin__c( String Origin__c ) {
        this.Origin__c = Origin__c;
    }

    public void setInternal__c( String Internal__c ) {
        this.Internal__c = Internal__c;
    }

    public void setDietary_Requirements2__c( String Dietary_Requirements2__c ) {
        this.Dietary_Requirements2__c = Dietary_Requirements2__c;
    }

    public void setPayment_methode__c( String Payment_methode__c ) {
        this.Payment_methode__c = Payment_methode__c;
    }

    public void setSignage__c( String Signage__c ) {
        this.Signage__c = Signage__c;
    }

    public void setDeposit2__c( String Deposit2__c ) {
        this.Deposit2__c = Deposit2__c;
    }

    public void setDeposit_3__c( String Deposit_3__c ) {
        this.Deposit_3__c = Deposit_3__c;
    }

    public void setDeposit_2_Pay_Date__c( String Deposit_2_Pay_Date__c ) {
        this.Deposit_2_Pay_Date__c = Deposit_2_Pay_Date__c;
    }

    public void setDeposit_3_Pay_Date__c( String Deposit_3_Pay_Date__c ) {
        this.Deposit_3_Pay_Date__c = Deposit_3_Pay_Date__c;
    }

    public void setOnsite_Contact__c( String Onsite_Contact__c ) {
        this.Onsite_Contact__c = Onsite_Contact__c;
    }

    public void setOnsite_Contact_Phone__c( String Onsite_Contact_Phone__c ) {
        this.Onsite_Contact_Phone__c = Onsite_Contact_Phone__c;
    }

    public void setDays__c( float days__c ) {
        this.days__c = days__c;
    }

    public void setPackage_Amount_inc__c( float Package_Amount_inc__c ) {
        this.Package_Amount_inc__c = Package_Amount_inc__c;
    }

    public void setPackage_Amount__c( float Package_Amount__c ) {
        this.Package_Amount__c = Package_Amount__c;
    }

    public void setStart_time__c( String Start_time__c ) {
        this.Start_time__c = Start_time__c;
    }

    public void setOption_date__c( String Option_date__c ) {
        this.Option_date__c = Option_date__c;
    }

    public void setTotal_rooms_booked__c( float Total_rooms_booked__c ) {
        this.Total_rooms_booked__c = Total_rooms_booked__c;
    }

    public void setQuote_Notes__c( String Quote_Notes__c ) {
        this.Quote_Notes__c = Quote_Notes__c;
    }

    public void setExcl_Tax__c( boolean Excl_Tax__c ) {
        this.Excl_Tax__c = Excl_Tax__c;
    }

    public void setDiscount_Meeting_rooms__c( float Discount_Meeting_rooms__c ) {
        this.Discount_Meeting_rooms__c = Discount_Meeting_rooms__c;
    }

    public void setDiscount_Hotel_rooms__c( float Discount_Hotel_rooms__c ) {
        this.Discount_Hotel_rooms__c = Discount_Hotel_rooms__c;
    }

    public void setDiscount_AV__c( float Discount_AV__c ) {
        this.Discount_AV__c = Discount_AV__c;
    }

    public void setDiscount_No_AV__c( float Discount_No_AV__c ) {
        this.Discount_No_AV__c = Discount_No_AV__c;
    }

    public void setDiscount_packages__c( float Discount_packages__c ) {
        this.Discount_packages__c = Discount_packages__c;
    }

    public void setHide_floorplans__c( boolean Hide_floorplans__c ) {
        this.Hide_floorplans__c = Hide_floorplans__c;
    }

    public void setDeposit_1_VAT__c( float Deposit_1_VAT__c ) {
        this.Deposit_1_VAT__c = Deposit_1_VAT__c;
    }

    public void setDeposit_2_VAT__c( String Deposit_2_VAT__c ) {
        this.Deposit_2_VAT__c = Deposit_2_VAT__c;
    }

    public void setDeposit_3_VAT__c( String Deposit_3_VAT__c ) {
        this.Deposit_3_VAT__c = Deposit_3_VAT__c;
    }

    public void setDeposit_1_Amount__c( float Deposit_1_Amount__c ) {
        this.Deposit_1_Amount__c = Deposit_1_Amount__c;
    }

    public void setDeposit_2_Amount__c( String Deposit_2_Amount__c ) {
        this.Deposit_2_Amount__c = Deposit_2_Amount__c;
    }

    public void setDeposit_3_Amount__c( String Deposit_3_Amount__c ) {
        this.Deposit_3_Amount__c = Deposit_3_Amount__c;
    }

    public void setPO_Number__c( String PO_Number__c ) {
        this.PO_Number__c = PO_Number__c;
    }

    public void setLogo_URL__c( String Logo_URL__c ) {
        this.Logo_URL__c = Logo_URL__c;
    }

    public void setHotel_Rooms_Amount_inc__c( float Hotel_Rooms_Amount_inc__c ) {
        this.Hotel_Rooms_Amount_inc__c = Hotel_Rooms_Amount_inc__c;
    }

    public void setMeeting_Rooms_Amount_inc__c( float Meeting_Rooms_Amount_inc__c ) {
        this.Meeting_Rooms_Amount_inc__c = Meeting_Rooms_Amount_inc__c;
    }

    public void setProducts_Amount_Inc__c( float Products_Amount_Inc__c ) {
        this.Products_Amount_Inc__c = Products_Amount_Inc__c;
    }

    public void setRequest_AR__c( boolean Request_AR__c ) {
        this.Request_AR__c = Request_AR__c;
    }

    public void setAfwijkende_voorwaarden__c( boolean Afwijkende_voorwaarden__c ) {
        this.Afwijkende_voorwaarden__c = Afwijkende_voorwaarden__c;
    }

    public void setLS_reference__c( String LS_reference__c ) {
        this.LS_reference__c = LS_reference__c;
    }

    public void setAR_Nummer__c( String AR_Nummer__c ) {
        this.AR_Nummer__c = AR_Nummer__c;
    }

    public void setImage_header__c( String Image_header__c ) {
        this.Image_header__c = Image_header__c;
    }

    public void setImage_header2__c( String Image_header2__c ) {
        this.Image_header2__c = Image_header2__c;
    }

    public void setImage_header3__c( String Image_header3__c ) {
        this.Image_header3__c = Image_header3__c;
    }

    public void setImage_header4__c( String Image_header4__c ) {
        this.Image_header4__c = Image_header4__c;
    }

    public void setImage_header5__c( String Image_header5__c ) {
        this.Image_header5__c = Image_header5__c;
    }

    public void setImage_header6__c( String Image_header6__c ) {
        this.Image_header6__c = Image_header6__c;
    }

    public void setGenerate_Offer__c( boolean Generate_Offer__c ) {
        this.Generate_Offer__c = Generate_Offer__c;
    }

    public void setLast_Offer_Generation__c( String Last_Offer_Generation__c ) {
        this.Last_Offer_Generation__c = Last_Offer_Generation__c;
    }

    public void setRooms_amount_total__c( float Rooms_amount_total__c ) {
        this.Rooms_amount_total__c = Rooms_amount_total__c;
    }

    public void setADR_Incl__c( String ADR_Incl__c ) {
        this.ADR_Incl__c = ADR_Incl__c;
    }

    public void setThn__Clone__c( boolean thn__Clone__c ) {
        this.thn__Clone__c = thn__Clone__c;
    }

    public void setHide_about_us__c( boolean Hide_about_us__c ) {
        this.Hide_about_us__c = Hide_about_us__c;
    }

    public void setHide_picture_page__c( boolean Hide_picture_page__c ) {
        this.Hide_picture_page__c = Hide_picture_page__c;
    }

    public void setProforma_referentie__c( String Proforma_referentie__c ) {
        this.Proforma_referentie__c = Proforma_referentie__c;
    }

    public void setUnique_number_proforma__c( float Unique_number_proforma__c ) {
        this.Unique_number_proforma__c = Unique_number_proforma__c;
    }

    public void setThn__Accomodation_NotesLong__c( String thn__Accomodation_NotesLong__c ) {
        this.thn__Accomodation_NotesLong__c = thn__Accomodation_NotesLong__c;
    }

    public void setThn__Catering_NotesLong__c( String thn__Catering_NotesLong__c ) {
        this.thn__Catering_NotesLong__c = thn__Catering_NotesLong__c;
    }

    public void setThn__Internal_NotesLong__c( String thn__Internal_NotesLong__c ) {
        this.thn__Internal_NotesLong__c = thn__Internal_NotesLong__c;
    }

    public void setThn__Reservation_Guest_Name__c( String thn__Reservation_Guest_Name__c ) {
        this.thn__Reservation_Guest_Name__c = thn__Reservation_Guest_Name__c;
    }

    public void setLocale_for_Documents__c( String Locale_for_Documents__c ) {
        this.Locale_for_Documents__c = Locale_for_Documents__c;
    }

    public void setCompany_short_name__c( String Company_short_name__c ) {
        this.Company_short_name__c = Company_short_name__c;
    }

    public void setThn__Comm_Activity__c( String thn__Comm_Activity__c ) {
        this.thn__Comm_Activity__c = thn__Comm_Activity__c;
    }

    public void setThn__Comm_Beverage__c( String thn__Comm_Beverage__c ) {
        this.thn__Comm_Beverage__c = thn__Comm_Beverage__c;
    }

    public void setThn__Comm_Equipment__c( String thn__Comm_Equipment__c ) {
        this.thn__Comm_Equipment__c = thn__Comm_Equipment__c;
    }

    public void setThn__Comm_Food__c( String thn__Comm_Food__c ) {
        this.thn__Comm_Food__c = thn__Comm_Food__c;
    }

    public void setThn__Comm_Hotel_Rooms__c( String thn__Comm_Hotel_Rooms__c ) {
        this.thn__Comm_Hotel_Rooms__c = thn__Comm_Hotel_Rooms__c;
    }

    public void setThn__Comm_Meeting_Rooms__c( String thn__Comm_Meeting_Rooms__c ) {
        this.thn__Comm_Meeting_Rooms__c = thn__Comm_Meeting_Rooms__c;
    }

    public void setThn__Comm_Other__c( String thn__Comm_Other__c ) {
        this.thn__Comm_Other__c = thn__Comm_Other__c;
    }

    public void setThn__Comm_Package__c( String thn__Comm_Package__c ) {
        this.thn__Comm_Package__c = thn__Comm_Package__c;
    }

    public void setThn__Commission_to__c( String thn__Commission_to__c ) {
        this.thn__Commission_to__c = thn__Commission_to__c;
    }

    public void setThn__Commissionable__c( boolean thn__Commissionable__c ) {
        this.thn__Commissionable__c = thn__Commissionable__c;
    }

    public void setThn__Last_Sync__c( String thn__Last_Sync__c ) {
        this.thn__Last_Sync__c = thn__Last_Sync__c;
    }

    public void setThn__Last_sync_status__c( String thn__Last_sync_status__c ) {
        this.thn__Last_sync_status__c = thn__Last_sync_status__c;
    }

    public void setThn__Option_date__c( String thn__Option_date__c ) {
        this.thn__Option_date__c = thn__Option_date__c;
    }

    public void setThn__Send_Failed_Reservations__c( boolean thn__Send_Failed_Reservations__c ) {
        this.thn__Send_Failed_Reservations__c = thn__Send_Failed_Reservations__c;
    }

    public void setThn__Sync_Error_Message__c( String thn__Sync_Error_Message__c ) {
        this.thn__Sync_Error_Message__c = thn__Sync_Error_Message__c;
    }

    public void setThn__Sync_with_Meeting_Package__c( boolean thn__Sync_with_Meeting_Package__c ) {
        this.thn__Sync_with_Meeting_Package__c = thn__Sync_with_Meeting_Package__c;
    }

    public void setThn__Total_Commission_on_Quote__c( float thn__Total_Commission_on_Quote__c ) {
        this.thn__Total_Commission_on_Quote__c = thn__Total_Commission_on_Quote__c;
    }

    public void setThn__Create_PMS_Block__c( boolean thn__Create_PMS_Block__c ) {
        this.thn__Create_PMS_Block__c = thn__Create_PMS_Block__c;
    }

    public void setThn__Shoulder_End_Date__c( String thn__Shoulder_End_Date__c ) {
        this.thn__Shoulder_End_Date__c = thn__Shoulder_End_Date__c;
    }

    public void setThn__Shoulder_Start_Date__c( String thn__Shoulder_Start_Date__c ) {
        this.thn__Shoulder_Start_Date__c = thn__Shoulder_Start_Date__c;
    }

    public void setThn__Total_incl_Tax__c( float thn__Total_incl_Tax__c ) {
        this.thn__Total_incl_Tax__c = thn__Total_incl_Tax__c;
    }

    public void setThn__Total_Hotel_Room_incl_Tax__c( float thn__Total_Hotel_Room_incl_Tax__c ) {
        this.thn__Total_Hotel_Room_incl_Tax__c = thn__Total_Hotel_Room_incl_Tax__c;
    }

    public void setThn__Total_Meeting_Room_incl_Tax__c( float thn__Total_Meeting_Room_incl_Tax__c ) {
        this.thn__Total_Meeting_Room_incl_Tax__c = thn__Total_Meeting_Room_incl_Tax__c;
    }

    public void setThn__Total_Product_incl_Tax__c( float thn__Total_Product_incl_Tax__c ) {
        this.thn__Total_Product_incl_Tax__c = thn__Total_Product_incl_Tax__c;
    }

    public void setThn__ZT_Count_HR__c( float thn__ZT_Count_HR__c ) {
        this.thn__ZT_Count_HR__c = thn__ZT_Count_HR__c;
    }

    public void setRelease_Date_formula__c( String Release_Date_formula__c ) {
        this.Release_Date_formula__c = Release_Date_formula__c;
    }

    public void setGuest_Quote_Name__c( String Guest_Quote_Name__c ) {
        this.Guest_Quote_Name__c = Guest_Quote_Name__c;
    }

    public void setThn__Release_date_formula__c( String thn__Release_date_formula__c ) {
        this.thn__Release_date_formula__c = thn__Release_date_formula__c;
    }

    public void setThn__PMS_Warning__c( boolean thn__PMS_Warning__c ) {
        this.thn__PMS_Warning__c = thn__PMS_Warning__c;
    }

    public void setThn__Potential_max_revenue_field__c( float thn__Potential_max_revenue_field__c ) {
        this.thn__Potential_max_revenue_field__c = thn__Potential_max_revenue_field__c;
    }

    public void setThn__Potential_max_revenue_MR__c( float thn__Potential_max_revenue_MR__c ) {
        this.thn__Potential_max_revenue_MR__c = thn__Potential_max_revenue_MR__c;
    }

    public void setThn__Potential_max_revenue_Package__c( float thn__Potential_max_revenue_Package__c ) {
        this.thn__Potential_max_revenue_Package__c = thn__Potential_max_revenue_Package__c;
    }

    public void setThn__Potential_max_revenue_Product__c( float thn__Potential_max_revenue_Product__c ) {
        this.thn__Potential_max_revenue_Product__c = thn__Potential_max_revenue_Product__c;
    }

    public void setThn__Total_paid__c( float thn__Total_paid__c ) {
        this.thn__Total_paid__c = thn__Total_paid__c;
    }

    public void setThn__Complimentary__c( boolean thn__Complimentary__c ) {
        this.thn__Complimentary__c = thn__Complimentary__c;
    }

    public void setThn__InventoryBlockType__c( String thn__InventoryBlockType__c ) {
        this.thn__InventoryBlockType__c = thn__InventoryBlockType__c;
    }

    public void setThn__PMS_Company__c( String thn__PMS_Company__c ) {
        this.thn__PMS_Company__c = thn__PMS_Company__c;
    }

    public void setThn__PMS_Group__c( String thn__PMS_Group__c ) {
        this.thn__PMS_Group__c = thn__PMS_Group__c;
    }

    public void setThn__PMS_Source__c( String thn__PMS_Source__c ) {
        this.thn__PMS_Source__c = thn__PMS_Source__c;
    }

    public void setThn__PMS_Travel_Agent__c( String thn__PMS_Travel_Agent__c ) {
        this.thn__PMS_Travel_Agent__c = thn__PMS_Travel_Agent__c;
    }

    public void setThn__SendToPMS__c( boolean thn__SendToPMS__c ) {
        this.thn__SendToPMS__c = thn__SendToPMS__c;
    }

    public void setThn__Guarantee_Code__c( String thn__Guarantee_Code__c ) {
        this.thn__Guarantee_Code__c = thn__Guarantee_Code__c;
    }

    public void setThn__Origin__c( String thn__Origin__c ) {
        this.thn__Origin__c = thn__Origin__c;
    }

    public void setThn__Dietary_Requirements_Long__c( String thn__Dietary_Requirements_Long__c ) {
        this.thn__Dietary_Requirements_Long__c = thn__Dietary_Requirements_Long__c;
    }

    public void setStatus__c( String Status__c ) {
        this.Status__c = Status__c;
    }

    public void setHas_Error__c( boolean Has_Error__c ) {
        this.Has_Error__c = Has_Error__c;
    }

    public void setThn__Block_Rate__c( String thn__Block_Rate__c ) {
        this.thn__Block_Rate__c = thn__Block_Rate__c;
    }

    public void setThn__InvoicingDetails__c( String thn__InvoicingDetails__c ) {
        this.thn__InvoicingDetails__c = thn__InvoicingDetails__c;
    }

    public void setRating_Stars__c( String Rating_Stars__c ) {
        this.Rating_Stars__c = Rating_Stars__c;
    }

    public void setThn__Individual_Pickup__c( boolean thn__Individual_Pickup__c ) {
        this.thn__Individual_Pickup__c = thn__Individual_Pickup__c;
    }

    public void setThn__Send_Failed_PMS_Block__c( boolean thn__Send_Failed_PMS_Block__c ) {
        this.thn__Send_Failed_PMS_Block__c = thn__Send_Failed_PMS_Block__c;
    }

    public void setThn__Package_Amount_Incl_Tax__c( float thn__Package_Amount_Incl_Tax__c ) {
        this.thn__Package_Amount_Incl_Tax__c = thn__Package_Amount_Incl_Tax__c;
    }

    public void setThn__Package_Amount__c( float thn__Package_Amount__c ) {
        this.thn__Package_Amount__c = thn__Package_Amount__c;
    }

    public void setThn__Tax_Calculation_Log__c( String thn__Tax_Calculation_Log__c ) {
        this.thn__Tax_Calculation_Log__c = thn__Tax_Calculation_Log__c;
    }

    public void setThn__Tax_Group_Type__c( String thn__Tax_Group_Type__c ) {
        this.thn__Tax_Group_Type__c = thn__Tax_Group_Type__c;
    }

    public void setThn__Tax_Last_Calculated_Date__c( String thn__Tax_Last_Calculated_Date__c ) {
        this.thn__Tax_Last_Calculated_Date__c = thn__Tax_Last_Calculated_Date__c;
    }

    public void setThn__Expanded_status__c( String thn__Expanded_status__c ) {
        this.thn__Expanded_status__c = thn__Expanded_status__c;
    }

    public void setThn__Locale_for_Documents__c( String thn__Locale_for_Documents__c ) {
        this.thn__Locale_for_Documents__c = thn__Locale_for_Documents__c;
    }
    public static class Attributes {
        private String type;
        private String url;


        // Getter Methods

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        // Setter Methods

        public void setType( String type ) {
            this.type = type;
        }

        public void setUrl( String url ) {
            this.url = url;
        }
    }
}
