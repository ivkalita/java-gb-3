package com.kalita_ivan.gb.lesson2;

import com.kalita_ivan.gb.lesson2.command.*;
import com.kalita_ivan.gb.lesson2.database.DatabaseManager;

public class Application {
    public static void main(String[] args) {
        prepareDatabase("jdbc:sqlite:goods.db");

        CommandRunner runner = new CommandRunner(System.in, System.out);
        runner.run();
    }

    private static void prepareDatabase(String url) {
        try {
            Class.forName("com.kalita_ivan.gb.lesson2.database.DatabaseManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to prepare database.");
        }

        DatabaseManager.setConfiguration("url", url);
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        databaseManager.prepareDatabase();
    }
}
