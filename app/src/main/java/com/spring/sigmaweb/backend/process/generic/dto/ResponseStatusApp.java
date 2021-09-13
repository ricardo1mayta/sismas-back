package com.spring.sigmaweb.backend.process.generic.dto;

public class ResponseStatusApp {
    private Boolean success;
    private String message;

    public ResponseStatusApp(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
