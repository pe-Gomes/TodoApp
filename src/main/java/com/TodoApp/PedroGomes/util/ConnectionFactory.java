package com.TodoApp.PedroGomes.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class ConnectionFactory {
    static Dotenv dotenv = Dotenv.load();
    static String dbPath = dotenv.get("DB_PATH");
    public static final String DRIVER = "java.sql.Driver";
    public static final String URL = dbPath;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL);
        } catch  (Exception e) {
            if (e.getMessage() != null) {
                throw new RuntimeException(e.getMessage());
            } else {
                throw new RuntimeException("Database connection error.");
            }
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            if (e.getMessage() != null) {
                throw new RuntimeException(e);
            } else {
                throw new RuntimeException("Failed to end database connection");
            }
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw new RuntimeException(e);
            } else {
                throw new RuntimeException("Failed to end database connection");
            }
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw new RuntimeException(e);
            } else {
                throw new RuntimeException("Failed to end database connection");
            }
        }
    }

}
