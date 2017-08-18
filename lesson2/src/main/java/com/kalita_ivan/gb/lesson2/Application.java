package com.kalita_ivan.gb.lesson2;

public class Application {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager("jdbc:sqlite:goods.db");
        databaseManager.prepareDatabase();
    }
}
