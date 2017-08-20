package com.kalita_ivan.gb.lesson2.command;

import com.kalita_ivan.gb.lesson2.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class GoodCostCommand extends Command {
    static final String NAME = "/good_cost";
    static final private String sql = "SELECT id, title, cost FROM goods WHERE LOWER(title) LIKE LOWER(?)";

    private String goodName;

    GoodCostCommand(String goodName) {
        this.goodName = goodName;
    }

    @Override
    CommandResult execute() {
        StringBuilder out = new StringBuilder();
        try (Connection connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, goodName);
            ResultSet result = statement.executeQuery();
            out.append(stringify(result));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new CommandResult(out.toString());
    }

    private String stringify(ResultSet result) throws SQLException {
        StringBuilder out = new StringBuilder();
        boolean atLeastOne = false;
        while (result.next()) {
            atLeastOne = true;
            out.append(String.format(
                "Good id=%d title=%s cost=%.2f\n",
                result.getInt(1),
                result.getString(2),
                result.getInt(3) / 100.0
            ));
        }
        if (!atLeastOne) {
            out.append("No goods found.\n");
        }
        return out.toString();
    }
}
