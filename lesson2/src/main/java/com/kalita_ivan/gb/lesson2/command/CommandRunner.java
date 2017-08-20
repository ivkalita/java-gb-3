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
        Scanner sc = new Scanner(inputStream);
        TokenParser parser = new TokenParser();
        CommandFactory commandFactory = new CommandFactory();
        while (sc.hasNextLine()) {
            String commandResult;
            try {
                String line = sc.nextLine();
                Token[] tokens = parser.parse(line);
                Command command = commandFactory.createFromTokens(tokens);
                commandResult = command.execute();
            }
            catch (Throwable e) {
                commandResult = String.format("%s\n", e.getMessage());
            }
            try {
                outputStream.write(commandResult.getBytes("UTF-8"));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
