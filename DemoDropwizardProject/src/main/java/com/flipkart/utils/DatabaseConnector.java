package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    private static Connection connection = null;

    /**
     * Get a database connection.
     *
     * @author: Bhavya, Harshit
     * @return A database connection instance.
     */
    public static Connection getConnection() {
        try {
            if (isValid()) {
                return connection;
            } else {
                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/flipfit";
                    String user = "root";
                    String password = "bhavyakh";
                    Class.forName(driver);
                    connection = DriverManager.getConnection(url, user, password);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Check if the current database connection is valid and not closed.
     *
     * @return true if the connection is valid and not closed, otherwise false.
     */
    public static boolean isValid() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}
