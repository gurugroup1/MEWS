package middleware.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import middleware.services.SalesforceConnectorService;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Value("${salesforce_credentials_secret_manager}")
    private String salesforceCredentialsSecretName;

    @Value("${salesforce_token_secret_manager}")
    private String salesforceTokenSecretName;

    @Value("${salesforce_object_url}")
    private String salesforceSObjectUrl;

    @Value("${salesforce_object_url_prefix}")
    private String salesforceSObjectrUrlPrefix;

    @Value("${salesforce_booking_object}")
    private String salesforceBookingObject;

    @Value("${salesforce_account_object}")
    private String salesforceAccountObject;

    @Value("${salesforce_company_contact_object}")
    private String salesforceCompanyContactObject;

    @Value("${salesforce_rate_object}")
    private String salesforceRateObject;

    @Value("${salesforce_property_object}")
    private String salesforcePropertyObject;

    public String getSalesforceGuest() {
        return salesforceGuest;
    }

    public String getSalesforcePMSBlock() {
        return salesforcePMSBlock;
    }

    public String getSalesforceMewsBlockinventory() {
        return salesforceMewsBlockinventory;
    }

    public String getSalesforcePMSBlockRates() {
        return salesforcePMSBlockRates;
    }

    @Value("${salesforce_guest}")
    private String salesforceGuest;
    @Value("${salesforce_pms_block}")
    private String salesforcePMSBlock;
    @Value("${salesforce_mews_block_inventories}")
    private String salesforceMewsBlockinventory;
    @Value("${salesforce_pms_block_rates}")
    private String salesforcePMSBlockRates;


    public String getSalesforcePMSAccount() {
        return salesforcePMSAccount;
    }

    @Value("${salesforce_pms_account}")
    private String salesforcePMSAccount;

    @Value("${mews.clientName}")
    private String mewsClientName;

    @Value("${mews.clientToken}")
    private String mewsClientToken;

    @Value("${mews.accessToken}")
    private String mewsAccessToken;

    @Value("${mews.apiUrl}")
    private String mewsApiUrl;

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        return mapper;
//    }

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Bean
    public SalesforceConnectorService salesforceConnectorService(OkHttpClient httpClient) {
        return new SalesforceConnectorService(this, httpClient);
    }

    public String getSalesforceCredentialsSecretName() {
        return salesforceCredentialsSecretName;
    }

    public String getSalesforceTokenSecretName() {
        return salesforceTokenSecretName;
    }

    public String getSalesforceSObjectUrl() {
        return salesforceSObjectUrl;
    }

    public String getSalesforceSObjectrUrlPrefix() {
        return salesforceSObjectrUrlPrefix;
    }

    public String getSalesforceBookingObject() {
        return salesforceBookingObject;
    }

    public String getSalesforceAccountObject() {
        return salesforceAccountObject;
    }

    public String getSalesforceCompanyContactObject() {
        return salesforceCompanyContactObject;
    }

    public String getSalesforceRateObject() {
        return salesforceRateObject;
    }

    public String getSalesforcePropertyObject() {
        return salesforcePropertyObject;
    }

    public String getMewsClientName() {
        return mewsClientName;
    }

    public String getMewsClientToken() {
        return mewsClientToken;
    }

    public String getMewsAccessToken() {
        return mewsAccessToken;
    }

    public String getMewsApiUrl() {
        return mewsApiUrl;
    }
}
