package middleware.models;

import java.util.List;

public class PSMAccountResponse {
    private String id;
    private boolean success;
    private List<String> errors;

    // Getter and Setter methods for the fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
