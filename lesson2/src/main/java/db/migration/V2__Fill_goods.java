package db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class V2__Fill_goods implements JdbcMigration {
    @Override
    public void migrate(Connection connection) throws Exception {
        String insert = "INSERT INTO goods (good_id, title, cost) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insert);

        final int batchSize = 500;
        final int totalCount = 10000;
        int count = 0;

        while (count < totalCount) {
            int goodId = count + 1;
            statement.setInt(1, goodId);
            statement.setString(2, String.format("good%d", goodId));
            statement.setInt(3, goodId * 1000 * 100);
            statement.addBatch();

            if (++count % batchSize == 0) {
                this.executeBatchOrClose(statement);
            }
        }
        this.executeBatchOrClose(statement);
        statement.close();
    }

    private void executeBatchOrClose(Statement statement) throws java.sql.SQLException {
        try {
            statement.executeBatch();
        }
        catch (java.sql.SQLException e) {
            statement.close();
            throw e;
        }
    }
}
