package com.kalita_ivan.gb.lesson2.command;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CommandRunner {
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public CommandRunner(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void run() {
        displayHelp();
        Scanner sc = new Scanner(inputStream);
        TokenParser parser = new TokenParser();
        CommandFactory commandFactory = new CommandFactory();
        while (sc.hasNextLine()) {
            CommandResult commandResult;
            try {
                String line = sc.nextLine();
                Token[] tokens = parser.parse(line);
                Command command = commandFactory.createFromTokens(tokens);
                commandResult = command.execute();
            }
            catch (Throwable e) {
                commandResult = new CommandResult(String.format("%s\n", e.getMessage()));
            }
            writeCommandResult(commandResult);
            if (commandResult.isAbort()) {
                break;
            }
        }
    }

    private void displayHelp() {
        writeCommandResult(new HelpCommand().execute());
    }

    private void writeCommandResult(CommandResult commandResult) {
        try {
            outputStream.write(commandResult.getResult().getBytes("UTF-8"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
