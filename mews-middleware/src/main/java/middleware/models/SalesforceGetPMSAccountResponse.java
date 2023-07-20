package middleware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceGetPMSAccountResponse {

    @JsonProperty("totalSize")
    private int totalSize;

    @JsonProperty("done")
    private boolean done;

    @JsonProperty("records")
    private List<PMSAccountRecord> records;

    public int getTotalSize() {
        return totalSize;
    }

    public boolean isDone() {
        return done;
    }

    public List<PMSAccountRecord> getRecords() {
        return records;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setRecords(List<PMSAccountRecord> records) {
        this.records = records;
    }

    public static class PMSAccountRecord {

        @JsonProperty("attributes")
        private PMSAccountAttributes attributes;

        @JsonProperty("Id")
        private String id;

        @JsonProperty("Name")
        private String name;

        @JsonProperty("thn__PMSId__c")
        private String pmsId;

        @JsonProperty("thn__MYCE_Quote__c")
        private String myceQuote;

        @JsonProperty("thn__Email__c")
        private String email;

        @JsonProperty("thn__Phone__c")
        private String phone;

        public PMSAccountAttributes getAttributes() {
            return attributes;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPmsId() {
            return pmsId;
        }

        public String getMyceQuote() {
            return myceQuote;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public void setAttributes(PMSAccountAttributes attributes) {
            this.attributes = attributes;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPmsId(String pmsId) {
            this.pmsId = pmsId;
        }

        public void setMyceQuote(String myceQuote) {
            this.myceQuote = myceQuote;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class PMSAccountAttributes {

        @JsonProperty("type")
        private String type;

        @JsonProperty("url")
        private String url;

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
