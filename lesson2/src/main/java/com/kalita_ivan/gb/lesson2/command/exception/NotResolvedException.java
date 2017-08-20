package com.kalita_ivan.gb.lesson2.command.exception;

public class NotResolvedException extends CommandException {
    static private final String message = "Unknown command name.";

    public NotResolvedException() {
        super(message);
    }
}
