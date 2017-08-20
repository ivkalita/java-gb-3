package com.kalita_ivan.gb.lesson2.command;

import com.kalita_ivan.gb.lesson2.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class GoodCostCommand extends PreparedStatementCommand {
    static final String NAME = "/good";
    private static final String SQL = "SELECT id, good_id, title, cost FROM goods WHERE LOWER(title) LIKE LOWER(?)";

    private String goodName;

    GoodCostCommand(String goodName) {
        this.goodName = goodName;
    }

    @Override
    String getSQL() {
        return SQL;
    }

    @Override
    protected CommandResult execute(Connection connection, PreparedStatement statement) throws SQLException {
        statement.setString(1, goodName);
        ResultSet result = statement.executeQuery();
        return new CommandResult(stringify(result));
    }

    private String stringify(ResultSet result) throws SQLException {
        StringBuilder out = new StringBuilder();
        boolean atLeastOne = false;
        while (result.next()) {
            atLeastOne = true;
            out.append(String.format(
                "Good id=%d good_id=%d title=%s cost=%.2f\n",
                result.getInt(1),
                result.getInt(2),
                result.getString(3),
                result.getInt(4) / 100.0
            ));
        }
        if (!atLeastOne) {
            out.append("No goods found.\n");
        }
        return out.toString();
    }
}
