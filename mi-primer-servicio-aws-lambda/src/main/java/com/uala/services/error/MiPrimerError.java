package com.uala.services.error;

import com.uala.lambda.support.enums.LambdaErrorCode;

public enum MiPrimerError implements LambdaErrorCode {
    INVALID_USERNAME("userName can not be empty", 6000);

    private int code;
    private String description;

    MiPrimerError(String description, int code) {
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
