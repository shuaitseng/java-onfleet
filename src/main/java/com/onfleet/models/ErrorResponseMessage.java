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

    public String getMessage() {
        return message;
    }

    public Object getCause() {
        return cause;
    }

    public String getRequest() {
        return request;
    }
}
