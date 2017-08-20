package com.kalita_ivan.gb.lesson2.command;

import java.sql.ResultSet;
import java.sql.SQLException;

abstract class SelectGoodCommand extends PreparedStatementCommand {
    String stringify(ResultSet result) throws SQLException {
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
