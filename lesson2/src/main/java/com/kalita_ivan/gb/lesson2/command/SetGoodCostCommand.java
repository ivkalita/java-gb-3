package com.kalita_ivan.gb.lesson2.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetGoodCostCommand extends PreparedStatementCommand {
    static final String NAME = "/set_cost";
    static private final String SQL = "UPDATE goods SET cost = ? WHERE title = ?";

    private String goodName;
    private float cost;

    SetGoodCostCommand(String goodName, float cost) {
        this.goodName = goodName;
        this.cost = cost;
    }

    @Override
    String getSQL() {
        return SQL;
    }

    @Override
    protected CommandResult execute(Connection connection, PreparedStatement statement) throws SQLException {
        statement.setInt(1, Math.round(cost * 100));
        statement.setString(2, goodName);
        int updated = statement.executeUpdate();
        return new CommandResult(String.format("%d rows updated\n", updated));
    }
}
