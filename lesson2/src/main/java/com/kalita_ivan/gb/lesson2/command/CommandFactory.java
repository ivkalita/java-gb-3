package com.kalita_ivan.gb.lesson2.command;

import com.kalita_ivan.gb.lesson2.command.exception.*;

class CommandFactory {
    Command createFromTokens(Token[] tokens) {
        if (tokens.length == 0) {
            throw new UnknownCommandException();
        }
        Token commandName = tokens[0];
        switch (commandName.toString()) {
            case (GoodCostCommand.NAME):
                return createGoodCostCommand(tokens);
            default:
                throw new NotResolvedException();
        }
    }

    private GoodCostCommand createGoodCostCommand(Token[] tokens) {
        if (tokens.length != 2) {
            throw new BadArgumentException();
        }
        return new GoodCostCommand(tokens[1].toString());
    }
}
