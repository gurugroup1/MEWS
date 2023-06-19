package MewsConnector.models;

public class SecretKeyAWS {

        private String salesforce_auth_url;
        private String salesforce_username;
        private String salesforce_password;
        private String salesforce_client_id;
        private String salesforce_client_secret;
        private String salesforce_grant_type;

        public SecretKeyAWS() {}

        public SecretKeyAWS(String salesforce_auth_url, String salesforce_username, String salesforce_password, String salesforce_client_id, String salesforce_client_secret, String salesforce_grant_type) {
            this.salesforce_auth_url = salesforce_auth_url;
            this.salesforce_username = salesforce_username;
            this.salesforce_password = salesforce_password;
            this.salesforce_client_id = salesforce_client_id;
            this.salesforce_client_secret = salesforce_client_secret;
            this.salesforce_grant_type = salesforce_grant_type;
        }

        public String getSalesforceAuthUrl() {
            return salesforce_auth_url;
        }

        public void setSalesforceAuthUrl(String salesforce_auth_url) {
            this.salesforce_auth_url = salesforce_auth_url;
        }

        public String getSalesforceUsername() {
            return salesforce_username;
        }

        public void setSalesforceUsername(String salesforce_username) {
            this.salesforce_username = salesforce_username;
        }

        public String getSalesforcePassword() {
            return salesforce_password;
        }

        public void setSalesforcePassword(String salesforce_password) {
            this.salesforce_password = salesforce_password;
        }

        public String getSalesforceClientId() {
            return salesforce_client_id;
        }

        public void setSalesforceClientId(String salesforce_client_id) {
            this.salesforce_client_id = salesforce_client_id;
        }

        public String getSalesforceClientSecret() {
            return salesforce_client_secret;
        }

        public void setSalesforceClientSecret(String salesforce_client_secret) {
            this.salesforce_client_secret = salesforce_client_secret;
        }

        public String getSalesforceGrantType() {
            return salesforce_grant_type;
        }

        public void setSalesforceGrantType(String salesforce_grant_type) {
            this.salesforce_grant_type = salesforce_grant_type;
        }


    }
