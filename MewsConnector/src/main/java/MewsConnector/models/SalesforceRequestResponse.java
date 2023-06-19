package MewsConnector.models;

import java.util.List;

public class SalesforceRequestResponse {
    private String id;
    private boolean success;
    private List<String> errors;

    public SalesforceRequestResponse() {
    }

    public SalesforceRequestResponse(String id, boolean success, List<String> errors) {
        this.id = id;
        this.success = success;
        this.errors = errors;
    }

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
