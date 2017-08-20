package com.kalita_ivan.gb.lesson2.command.exception;

class CommandException extends RuntimeException {
    static private final String message = "General command exception.";

    CommandException() {
        super(message);
    }

    CommandException(String message) {
        super(message);
    }
}
