package com.kalita_ivan.gb.lesson2.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectGoodsByCostRangeCommand extends SelectGoodCommand {
    static final String NAME = "/goods_by_cost_range";
    static private final String SQL = "SELECT id, good_id, title, cost FROM goods WHERE cost >= ? AND cost <= ?";

    private float low;
    private float high;

    SelectGoodsByCostRangeCommand(float low, float high) {
        this.low = low;
        this.high = high;
    }

    @Override
    String getSQL() {
        return SQL;
    }

    @Override
    protected CommandResult execute(Connection connection, PreparedStatement statement) throws SQLException {
        statement.setInt(1, Math.round(low * 100));
        statement.setInt(2, Math.round(high * 100));
        ResultSet result = statement.executeQuery();
        return new CommandResult(stringify(result));
    }
}
