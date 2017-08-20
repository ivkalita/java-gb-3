package com.kalita_ivan.gb.lesson2.database;

import com.kalita_ivan.gb.lesson2.database.exception.DatabaseConnectionFailedException;
import com.kalita_ivan.gb.lesson2.database.exception.MissingConfigurationException;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseManager {

    private String url;

    private static DatabaseManager instance;
    private static HashMap<String, String> config;

    static {
        config = new HashMap<>();
    }

    public static void setConfiguration(String key, String value) {
        DatabaseManager.config.put(key, value);
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            String url = DatabaseManager.config.get("url");
            if (url == null) {
                throw new MissingConfigurationException("url");
            }
            instance = new DatabaseManager(url);
        }

        return instance;
    }

    public void prepareDatabase() {
        createDatabaseIfDoesNotExist();
        migrate();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    private DatabaseManager(String url) {
        this.url = url;
    }

    private void createDatabaseIfDoesNotExist() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);
            connection.close();
        } catch (Throwable e) {
            throw new DatabaseConnectionFailedException(e.getMessage());
        }
    }

    private void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, "", "");
        flyway.migrate();
    }
}
