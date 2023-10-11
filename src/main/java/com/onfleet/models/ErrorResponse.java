package com.onfleet.models;

public class ErrorResponse {
    private String code;
    private ErrorResponseMessage message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorResponseMessage getMessage() {
        return message;
    }

    public void setMessage(ErrorResponseMessage message) {
        this.message = message;
    }

}
