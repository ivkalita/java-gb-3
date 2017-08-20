package com.kalita_ivan.gb.lesson2.command;

class HelpCommand extends Command {
    static final String NAME = "/help";
    private static final CommandResult commandResult = new CommandResult(
        "Commands:\n" +
        "---------------------------------------------------------------\n" +
        "Get goods by cost range (inclusive)\n" +
        "/goods_by_cost_range low high\n" +
        "    low  – decimal, minimal cost;\n" +
        "    high – decimal, maximum cost;\n" +
        "Example: /goods_by_cost_range 1000.5 6000\n" +
        "---------------------------------------------------------------\n" +
        "Get goods by title\n" +
        "/goods_by_title title\n" +
        "    title – string, title of good(s) to find (case insensitive)\n" +
        "Example: /goods_by_title 100\n" +
        "---------------------------------------------------------------\n" +
        "Update goods title\n" +
        "/set_cost title cost\n" +
        "    title – string, title of good(s) to update (case sensitive)\n" +
        "    cost  – decimal, new cost of good\n" +
        "---------------------------------------------------------------\n" +
        "Exit\n" +
        "/exit\n" +
        "---------------------------------------------------------------\n" +
        "Help\n" +
        "/help\n"
    );

    @Override
    CommandResult execute() {
        return commandResult;
    }
}
