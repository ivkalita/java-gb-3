package com.kalita_ivan.gb.lesson2.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectGoodsByTitleCommand extends SelectGoodCommand {
    static final String NAME = "/goods_by_title";
    private static final String SQL = "SELECT id, good_id, title, cost FROM goods WHERE LOWER(title) LIKE LOWER(?)";

    private String goodName;

    SelectGoodsByTitleCommand(String goodName) {
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
}
