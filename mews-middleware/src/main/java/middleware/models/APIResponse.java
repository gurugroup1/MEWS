package middleware.models;

public class APIResponse {
    private String bookingId;
    private String createdDate;
    private String status;
    private BookingDetails bookingDetails;
    private AccountDetails accountDetails;

    // Getters and setters...

    @Override
    public String toString() {
        return "APIResponse{" +
                "bookingId:'" + bookingId + '\'' +
                ", createdDate:'" + createdDate + '\'' +
                ", status:'" + status + '\'' +
                ", bookingDetails:" + (bookingDetails != null ? bookingDetails.toString() : null) +
                ", accountDetails:" + (accountDetails != null ? accountDetails.toString() : null) +
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
}
