package middleware.models;

public class APIResponse {
    private String bookingId;
    private String createdDate;
    private String status;
    private BookingDetails bookingDetails;
    private AccountDetails accountDetails;
    private ContactDetails contactDetails;
    private RateDetails rateDetails;
    private PropertyDetails propertyDetails;
    private MewsCompanyDetails mewsCompanyDetails;
    private MewsBookerDetails mewsBookerDetails;
    private MewsAvailabilityBlockDetails mewsAvailabilityBlockDetails;
    private MewsUpdateAvailabilityDetails mewsUpdateAvailabilityDetails;
    private MewsUpdateRateDetails mewsUpdateRateDetails;


    @Override
    public String toString() {
        return "APIResponse{" +
                "bookingId:'" + bookingId + '\'' +
                ", createdDate:'" + createdDate + '\'' +
                ", status:'" + status + '\'' +
                ", bookingDetails:" + (bookingDetails != null ? bookingDetails.toString() : null) +
                ", accountDetails:" + (accountDetails != null ? accountDetails.toString() : null) +
                ", contactDetails:" + (contactDetails != null ? contactDetails.toString() : null) +
                ", RateDetails:" + (rateDetails != null ? rateDetails.toString() : null) +
                ", PropertyDetails:" + (propertyDetails != null ? propertyDetails.toString() : null) +
                ", MewsCompanyDetails:" + (mewsCompanyDetails != null ? mewsCompanyDetails.toString() : null) +
                ", MewsBookerDetails:" + (mewsBookerDetails != null ? mewsBookerDetails.toString() : null) +
                ", MewsAvailabilityBlockDetails:" + (mewsAvailabilityBlockDetails != null ? mewsAvailabilityBlockDetails.toString() : null) +
                ", MewsUpdateAvailabilityDetails:" + (mewsUpdateAvailabilityDetails != null ? mewsUpdateAvailabilityDetails.toString() : null) +
                ", MewsUpdateRateDetails:" + (mewsUpdateRateDetails != null ? mewsUpdateRateDetails.toString() : null) +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public RateDetails getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(RateDetails rateDetails) {
        this.rateDetails = rateDetails;
    }

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public MewsCompanyDetails getMewsCompanyDetails() {
        return mewsCompanyDetails;
    }

    public void setMewsCompanyDetails(MewsCompanyDetails mewsCompanyDetails) {
        this.mewsCompanyDetails = mewsCompanyDetails;
    }

    public MewsBookerDetails getMewsBookerDetails() {
        return mewsBookerDetails;
    }

    public void setMewsBookerDetails(MewsBookerDetails mewsBookerDetails) {
        this.mewsBookerDetails = mewsBookerDetails;
    }

    public MewsAvailabilityBlockDetails getMewsAvailabilityBlockDetails() {
        return mewsAvailabilityBlockDetails;
    }

    public void setMewsAvailabilityBlockDetails(MewsAvailabilityBlockDetails mewsAvailabilityBlockDetails) {
        this.mewsAvailabilityBlockDetails = mewsAvailabilityBlockDetails;
    }

    public MewsUpdateAvailabilityDetails getMewsUpdateAvailabilityDetails() {
        return mewsUpdateAvailabilityDetails;
    }

    public void setMewsUpdateAvailabilityDetails(MewsUpdateAvailabilityDetails mewsUpdateAvailabilityDetails) {
        this.mewsUpdateAvailabilityDetails = mewsUpdateAvailabilityDetails;
    }

    public MewsUpdateRateDetails getMewsUpdateRateDetails() {
        return mewsUpdateRateDetails;
    }

    public void setMewsUpdateRateDetails(MewsUpdateRateDetails mewsUpdateRateDetails) {
        this.mewsUpdateRateDetails = mewsUpdateRateDetails;
    }

    public static class BookingDetails {
        private String request;
        private SalesforceBookingResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "BookingDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public SalesforceBookingResponse getResponse() {
            return response;
        }

        public void setResponse(SalesforceBookingResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class AccountDetails {
        private String request;
        private SalesforceAccountResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "AccountDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public SalesforceAccountResponse getResponse() {
            return response;
        }

        public void setResponse(SalesforceAccountResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class ContactDetails {
        private String request;
        private SalesforceContactResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "ContactDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public SalesforceContactResponse getResponse() {
            return response;
        }

        public void setResponse(SalesforceContactResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class RateDetails {
        private String request;
        private SalesforceRateResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "RateDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public SalesforceRateResponse getResponse() {
            return response;
        }

        public void setResponse(SalesforceRateResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class PropertyDetails {  private String request;
        private SalesforcePropertyResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "PropertyDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public SalesforcePropertyResponse getResponse() {
            return response;
        }

        public void setResponse(SalesforcePropertyResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class MewsCompanyDetails {  private String request;
        private MewsCompanyResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "MewsCompanyDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public MewsCompanyResponse getResponse() {
            return response;
        }

        public void setResponse(MewsCompanyResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class MewsBookerDetails {  private String request;
        private MewsBookerResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "MewsBookerDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public MewsBookerResponse getResponse() {
            return response;
        }

        public void setResponse(MewsBookerResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class MewsAvailabilityBlockDetails {  private String request;
        private MewsAvailabilityBlockResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "MewsAvailabilityBlockDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public MewsAvailabilityBlockResponse getResponse() {
            return response;
        }

        public void setResponse(MewsAvailabilityBlockResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class MewsUpdateAvailabilityDetails {  private String request;
        private MewsUpdateAvailabilityRequest response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "MewsUpdateAvailabilityDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public MewsUpdateAvailabilityRequest getResponse() {
            return response;
        }

        public void setResponse(MewsUpdateAvailabilityRequest response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
    public static class MewsUpdateRateDetails {  private String request;
        private SalesforceRateResponse response;
        private String source;
        private String status;
        private String error;

        // Getters and setters...

        @Override
        public String toString() {
            return "MewsUpdateRateDetails{" +
                    "request:'" + request + '\'' +
                    ", response:'" + response + '\'' +
                    ", source:'" + source + '\'' +
                    ", status:'" + status + '\'' +
                    ", error:'" + error + '\'' +
                    '}';
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public SalesforceRateResponse getResponse() {
            return response;
        }

        public void setResponse(SalesforceRateResponse response) {
            this.response = response;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

}
