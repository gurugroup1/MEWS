package middleware.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesforceGuestRoomResponse {
    @JsonProperty("attributes")
    private Attributes attributes;

    @JsonProperty("Id")
    private String id;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and Setters
    // ...

    public static class Attributes {
        @JsonProperty("type")
        private String type;

        @JsonProperty("url")
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        // Getters and Setters
        // ...
    }

    // Getters and Setters
    // ...
}
