package com.kalita_ivan.gb.lesson2.database.exception;

public class MissingConfigurationException extends RuntimeException {
    private String missingKey;

    public MissingConfigurationException(String missingKey) {
        super();
        this.missingKey = missingKey;
    }

    @Override
    public String toString() {
        return String.format("DatabaseManager missing configuration key %s.", missingKey);
    }
}
