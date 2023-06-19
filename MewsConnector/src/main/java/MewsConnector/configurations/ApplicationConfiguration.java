package MewsConnector.configurations;

import MewsConnector.services.SalesforceConnectorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class ApplicationConfiguration {

    //   private static final String PROPERTIES_FILE = System.getenv("AWS_PROFILE");
    private static final String PROPERTIES_FILE = "application-test.properties";
    private static Properties properties;

    static {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        try (InputStream input = ApplicationConfiguration.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input != null) {
                Properties props = new Properties();
                props.load(input);
                return props;
            } else {
                throw new FileNotFoundException("Unable to find application property" + PROPERTIES_FILE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    static String getProperty(String key) {
        if (properties != null) {
            return properties.getProperty(key);
        }
        return null;
    }

    public static String getApiUrl() {
        return getProperty("api_url");
    }

    public static String getApiAuthUrl() {
        return getProperty("api_auth_url");
    }

    public static String getSalesforceCredentialsSecretName() {
        return getProperty("salesforce_credentials_secret_manager");
    }

    public static String getSalesforceTokenSecretName() {
        return getProperty("salesforce_token_secret_manager");
    }

    public static String getStayntouchCredentialsSecretName() {
        return getProperty("stayntouch_credentials_secret_manager");
    }

    public static String getStayntouchTokenSecretName() {
        return getProperty("stayntouch_token_secret_manager");
    }

    public static String getThynkMessageApiSource() {
        return getProperty("tm_api_source");
    }

    public static String getThynkMessageSyncStatus() {
        return getProperty("tm_sync_status");
    }

    public static String getThynkMessageSetSyncRecord() {
        return getProperty("tm_set_synced_record");
    }

    public static String getThynkMessageSetTargetMethod() {
        return getProperty("tm_set_target_method");
    }

    public static String getThynkMessageSetTargetEndPoint() {
        return getProperty("tm_set_target_endpoint");
    }

    public static String getThynkMessageSetType() {
        return getProperty("tm_set_type");
    }

    public static String getThynkMessageSetObjectType() {
        return getProperty("tm_set_object_type");
    }
    public static String getSalesforceSObjectUrl() {
        return getProperty("salesforce_object_url");
    }
    public static String getSalesforceSObjectrUrlPrefix() {
        return getProperty("salesforce_object_url_prefix");
    }
    public static String getSalesforceObjectNameTMQ() {
        return getProperty("salesforce_object_name_tmq");
    }

    public static String getMewsClientName() {
        return getProperty("mews.clientName");
    }

    public static String getMewsClientToken() {
        return getProperty("mews.clientToken");
    }

    public static String getMewsAccessToken() {
        return getProperty("mews.accessToken");
    }

    public static String getMewsApiUrl() {
        return getProperty("mews.apiUrl");
    }

    @Bean
    public SalesforceConnectorService salesforceConnectorService() {
        return new SalesforceConnectorService();
    }

}


