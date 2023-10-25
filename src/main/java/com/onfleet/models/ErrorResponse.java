package com.onfleet.models;

public class ErrorResponse {
    private String code;
    private ErrorResponseMessage message;

    public String getCode() {
        return code;
    }

    public ErrorResponseMessage getMessage() {
        return message;
    }

}
