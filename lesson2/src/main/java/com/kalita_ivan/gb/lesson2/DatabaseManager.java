package com.kalita_ivan.gb.lesson2;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;

class DatabaseManager {

    private String url;

    DatabaseManager(String url) {
        this.url = url;
    }

    void prepareDatabase() {
        createDatabaseIfDoesNotExist();
        migrate();
    }

    private void createDatabaseIfDoesNotExist() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);
            connection.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, "", "");
        flyway.migrate();
    }
}
