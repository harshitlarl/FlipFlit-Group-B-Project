package com.flipkart.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertanyData {
    public static void main(String[] args) {
        // JDBC database URL, username, and password of the database
        String jdbcUrl = "jdbc:mysql://localhost/flipfit"; // Replace with your actual database URL
        String jdbcUsername = "root"; // Replace with your database username
        String jdbcPassword = "Fk!_197981"; // Replace with your database password

        // Initialize connection and prepared statement
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Register the JDBC driver (if you haven't already)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 3. Define an INSERT SQL query
            String insertQuery = "INSERT INTO gym_owner (id, email, name, password, phone_number, pancard, aadhar, gst) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // 4. Create a prepared statement with the INSERT query
            preparedStatement = connection.prepareStatement(insertQuery);

            // 5. Set values for the placeholders in the prepared statement
            preparedStatement.setInt(1, 16); // Replace with the desired ID
            preparedStatement.setString(2, "new_owner@example.com");
            preparedStatement.setString(3, "New Owner");
            preparedStatement.setString(4, "new_password");
            preparedStatement.setString(5, "987-654-3210");
            preparedStatement.setString(6, "ZYXWV9876A");
            preparedStatement.setString(7, "987654321098");
            preparedStatement.setString(8, "GST9876543");

            // 6. Execute the INSERT query to insert the new record
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Failed to insert the record.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. Close the resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
