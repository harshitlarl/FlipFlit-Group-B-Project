package com.flipkart.dao;

import com.flipkart.dao.DatabaseConnector;
import com.flipkart.dao.GymOwnerDaoInterface;

//import com.flipkart.dao.GymOwnerDAOImplementation;
//import com.flipkart.dao.DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GymOwnerDAOImplementation implements GymOwnerDaoInterface {
    DatabaseConnector connector ;
    Connection conn;

    public GymOwnerDAOImplementation() throws SQLException {
        connector = new DatabaseConnector();
        conn = DatabaseConnector.getConnection();
    }

    @Override
    public  void viewGymSlots(String gymOwnerID) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;

        statement = conn.createStatement();

        String sqlQuery = "SELECT * FROM gym_owner";
        resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phone_number");
            String pancard = resultSet.getString("pancard");
            String aadhar = resultSet.getString("aadhar");
            String gst = resultSet.getString("gst");

            // Print the data or perform any other operations you need
            System.out.println("ID: " + id);
            System.out.println("Email: " + email);
            System.out.println("Name: " + name);
            System.out.println("Password: " + password);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Pancard: " + pancard);
            System.out.println("Aadhar: " + aadhar);
            System.out.println("GST: " + gst);
            System.out.println("---------------------------------");
        }

    }
}