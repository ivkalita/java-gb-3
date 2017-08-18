package db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1__Create_goods implements JdbcMigration {
    @Override
    public void migrate(Connection connection) throws Exception {
        PreparedStatement statement = connection.prepareStatement(
        "CREATE TABLE goods (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "good_id INTEGER UNIQUE NOT NULL," +
                "title VARCHAR(255) NOT NULL," +
                "cost INTEGER NOT NULL" +
            ")"
        );
        try {
            statement.execute();
        } finally {
            statement.close();
        }
    }
}
