package com.kalita_ivan.gb.lesson2.command;

import com.kalita_ivan.gb.lesson2.command.exception.*;

class CommandFactory {
    Command createFromTokens(Token[] tokens) {
        if (tokens.length == 0) {
            throw new UnknownCommandException();
        }
        Token commandName = tokens[0];
        switch (commandName.toString()) {
            case (SelectGoodsByTitleCommand.NAME):
                return createGoodCostCommand(tokens);
            case (ExitCommand.NAME):
                return new ExitCommand();
            case (SetGoodCostCommand.NAME):
                return createSetGoodCostCommand(tokens);
            case (SelectGoodsByCostRangeCommand.NAME):
                return createGoodsByCostRangeCommand(tokens);
            case (HelpCommand.NAME):
                return new HelpCommand();
            default:
                throw new NotResolvedException();
        }
    }

    private SelectGoodsByTitleCommand createGoodCostCommand(Token[] tokens) {
        if (tokens.length != 2) {
            throw new BadArgumentException();
        }
        return new SelectGoodsByTitleCommand(tokens[1].toString());
    }

    private SetGoodCostCommand createSetGoodCostCommand(Token[] tokens) {
        if (tokens.length != 3) {
            throw new BadArgumentException();
        }
        try {
            return new SetGoodCostCommand(tokens[1].toString(), tokens[2].toFloat());
        }
        catch (NumberFormatException e) {
            throw new BadArgumentException();
        }
    }

    private SelectGoodsByCostRangeCommand createGoodsByCostRangeCommand(Token[] tokens) {
        if (tokens.length != 3) {
            throw new BadArgumentException();
        }
        try {
            return new SelectGoodsByCostRangeCommand(tokens[1].toFloat(), tokens[2].toFloat());
        }
        catch (NumberFormatException e) {
            throw new BadArgumentException();
        }
    }
}
