package com.kalita_ivan.gb.lesson2.command;

import com.kalita_ivan.gb.lesson2.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class PreparedStatementCommand extends Command {
    abstract String getSQL();

    @Override
    CommandResult execute() {
        CommandResult commandResult;
        try (Connection connection = DatabaseManager.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(getSQL())
        ) {
            commandResult = execute(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
            commandResult = new CommandResult(String.format("SQLException:%s", e.getMessage()));
        }
        return commandResult;
    }

    abstract protected CommandResult execute(Connection connection, PreparedStatement statement) throws SQLException;
}
