package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseMessage {
    private Integer error;
    private String message;
    @JsonProperty("cause")
    private Object cause;
    private String request;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
