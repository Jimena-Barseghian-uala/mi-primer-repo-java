package com.uala.services.error;

import com.uala.lambda.support.enums.LambdaErrorCode;

public enum ContactError implements LambdaErrorCode {
    INVALID_FIRSTNAME("firstName can not be empty", 6000),
    INVALID_LASTNAME("lastName can not be empty", 6001);

    private int code;
    private String description;

    ContactError(String description, int code) {
        this.code = code;
        this.description = description;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
