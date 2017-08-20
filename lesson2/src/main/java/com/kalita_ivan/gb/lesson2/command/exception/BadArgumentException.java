package com.kalita_ivan.gb.lesson2.command.exception;

public class BadArgumentException extends CommandException {
    static private final String message = "Bad arguments passed to the command.";

    public BadArgumentException() {
        super(message);
    }
}
