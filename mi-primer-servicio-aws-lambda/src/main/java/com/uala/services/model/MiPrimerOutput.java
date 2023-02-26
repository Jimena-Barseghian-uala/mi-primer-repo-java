package com.uala.services.model;

public class MiPrimerOutput {
    private boolean exists;

    public MiPrimerOutput(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}