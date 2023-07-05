package middleware.entity;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookingId;
    private String object;
    @Lob
    @Column(columnDefinition = "BLOB") // Use BLOB column type
    private byte[] payload;
    private String status;
    private String status_code;
    private String error;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setPayload(String payloadString) {
        this.payload = payloadString.getBytes(StandardCharsets.UTF_8);
    }

    // Helper method to convert bytes to JSON string
    public String getPayload() {
        return new String(this.payload, StandardCharsets.UTF_8);
    }
}


//
//{
//        "bookingId": "123123",
//        "booking": {
//        "success": true,
//        "error": "field is missing",
//        "source": "Salesforce",
//        "payload": {}
//        },
//        "rate": {
//        "success": false,
//        "error": "field is missing",
//        "source": "Salesforce",
//        "payload": {}
//        },
//        "property": {
//        "success": true,
//        "error": "field is missing",
//        "source": "Salesforce",
//        "payload": {}
//        },
//        "account": {
//        "success": false,
//        "error": "field is missing",
//        "source": "Salesforce",
//        "payload": {}
//        }
//        }
