package middleware.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import middleware.models.*;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Optional;


@Component

public class ResponseParser {
    private final MewsController mewsController;
    private final SalesforceController salesforceController;
    private final AuthController authController;
    private final ObjectMapper objectMapper;

    public ResponseParser(MewsController mewsController, SalesforceController salesforceController, AuthController authController, ObjectMapper objectMapper) {
        this.mewsController = mewsController;
        this.salesforceController = salesforceController;
        this.authController = authController;
        this.objectMapper = objectMapper;
    }

    public <T> Optional<T> retrieveAndParseResponse(SalesforceTokenResponse salesforceToken, String parameter, Class<T> responseClass, String object) {
        try {
            String response = salesforceController.getRecordFromSalesforce(
                    object,
                    salesforceToken.getAccess_token(),
                    parameter
            );

            if (response == null || response.isEmpty()) {
                return Optional.empty();
            }

            // Check for API errors
            JsonNode jsonResponse = objectMapper.readTree(response);
            if (jsonResponse.has("error")) {
                String errorMessage = jsonResponse.get("error").asText();
                String message = jsonResponse.get("message").asText();
                return Optional.empty();
            }

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseClass);
            return Optional.ofNullable(parsedResponse);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public <T> Optional<T> retrieveAndParseQueryResponse(SalesforceTokenResponse salesforceToken,String parameter, Class<T> responseClass) {
        try {
            String response = salesforceController.getQueryDataFromSalesforce(
                    salesforceToken.getAccess_token(),
                    parameter
            );
            System.out.println(response);
            System.out.println(response.isEmpty());
            if (response == null || response.isEmpty()) {
                return Optional.empty();
            }

            // Check for API errors
            JsonNode jsonResponse = objectMapper.readTree(response);
            if (jsonResponse.has("error")) {
                String errorMessage = jsonResponse.get("error").asText();
                String message = jsonResponse.get("message").asText();
                return Optional.empty();
            }

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseClass);
            return Optional.ofNullable(parsedResponse);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    public <T> T parseResponse(String response, Class<T> responseType, String object) throws Exception {
        try {
            JsonNode responseJson = objectMapper.readTree(response);

            if (responseJson.has("error")) {
                String errorMessage = responseJson.get("error").asText();
                throw new Exception("Error in " + responseType.getSimpleName() + " response from Mews: " + errorMessage);
            }

            // Parse the response
            T parsedResponse = objectMapper.readValue(response, responseType);
            return parsedResponse;
        } catch (IOException e) {
            throw new Exception("Unable to parse " + responseType.getSimpleName() + " Response", e);
        }
    }
    public Optional<MewsCompanyResponse> addCompanyInMews(MewsCompanyRequest payload) throws Exception {
        String response = mewsController.addCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }

        return Optional.ofNullable(parseResponse(response, MewsCompanyResponse.class, "Company Response"));
    }
    public Optional<MewsBookerResponse> addBookerInMews(MewsBookerRequest payload) throws Exception {
        String response = mewsController.addBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsBookerResponse.class, "Booker Response"));
    }
    public Optional<MewsAvailabilityBlockResponse> addAvailabilityBlockInMews(MewsAvailabilityBlockRequest payload) throws Exception {
        String response = mewsController.addAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty Availability Block response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsAvailabilityBlockResponse.class, "Availability Block Response"));
    }
    public Optional<MewsUpdateCompanyResponse> updateCompanyInMews(MewsUpdateCompanyRequest payload) throws Exception {
        String response = mewsController.updateCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception(" empty update company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsUpdateCompanyResponse.class, "Update Company Response"));
    }
    public Optional<MewsUpdateBookerResponse> updateBookerInMews(MewsUpdateBookerRequest payload) throws Exception {
        String response = mewsController.updateBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty update booker response from Mews.");
        }

        return Optional.ofNullable(parseResponse(response, MewsUpdateBookerResponse.class, "Update Booker Response"));
    }
    public Optional<MewsGetCompanyResponse> getCompanyFromMews(MewsGetCompanyRequest payload) throws Exception {
        String response = mewsController.getCompany(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsGetCompanyResponse.class, "Company Response"));
    }
    public Optional<MewsGetBookerResponse> getBookerFromMews(MewsGetBookerRequest payload) throws Exception {
        String response = mewsController.getBooker(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsGetBookerResponse.class, "Get Booker Response"));
    }
    public Optional<MewsGetAvailabilityBlockResponse> getAvailabilityBlockFromMews(MewsGetAvailabilityBlockRequest payload) throws Exception {
        String response = mewsController.getMewsAvailabilityBlock(payload);

        if (response == null || response.isEmpty()) {
            throw new Exception("Empty company response from Mews.");
        }


        return Optional.ofNullable(parseResponse(response, MewsGetAvailabilityBlockResponse.class, "Get Availability Block Response"));
    }
    public SalesforceTokenResponse retrieveSalesforceToken() throws Exception {
        SalesforceTokenResponse salesforceToken = authController.retrieveSalesforceTokenFromAWS();
        if (salesforceToken == null || salesforceToken.getAccess_token() == null) {
            throw new Exception("Salesforce token is not available.");
        }
        return salesforceToken;
    }

}
