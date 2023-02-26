package com.uala.services.model;

public class ContactOutput {
    private String message;

    public ContactOutput(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}