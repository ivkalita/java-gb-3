package com.kalita_ivan.gb.lesson2.database.exception;

public class DatabaseConnectionFailedException extends RuntimeException {
    public DatabaseConnectionFailedException(String message) {
        super(message);
    }
}
