package middleware.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    // Private constructor to prevent instantiation
    private JsonUtils() {
        throw new AssertionError("Cannot instantiate utility class.");
    }

    public static String getBookingIdFromRequestBody(String requestBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(requestBody);
        return jsonNode.has("bookingId") ? jsonNode.get("bookingId").asText() : null;
    }
}
