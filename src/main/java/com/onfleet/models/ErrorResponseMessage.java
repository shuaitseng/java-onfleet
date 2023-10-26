package com.onfleet.models;


public class ErrorResponseMessage {
    private Integer error;
    private String message;
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
