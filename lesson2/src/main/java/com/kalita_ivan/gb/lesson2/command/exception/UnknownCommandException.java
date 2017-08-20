package com.kalita_ivan.gb.lesson2.command.exception;

public class UnknownCommandException extends CommandException {
    static private final String message = "Unable to find command name.";

    public UnknownCommandException() {
        super(message);
    }
}
