package com.kalita_ivan.gb.lesson2.command;

class ExitCommand extends Command {
    static final String NAME = "/exit";
    static final private CommandResult exitResult = new CommandResult("Exiting.\n", true);

    @Override
    CommandResult execute() {
        return exitResult;
    }
}
