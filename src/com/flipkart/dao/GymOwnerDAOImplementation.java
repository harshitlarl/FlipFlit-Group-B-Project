package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

//import com.flipkart.dao.GymOwnerDAOImplementation;
//import com.flipkart.dao.DatabaseConnector;

import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GymOwnerDAOImplementation implements GymOwnerDaoInterface {
    DatabaseConnector connector ;
    Connection conn;

    public GymOwnerDAOImplementation() {
        connector = new DatabaseConnector();
        try {
            conn = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addGym(Gym gym){
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String insertQuery = "INSERT INTO gym (address, location, name, status, ownerid) VALUES (?, ?, ?, ?, ?)";
        int id = 0;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(insertQuery, statement.RETURN_GENERATED_KEYS);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, gym.getGymAddress());
            preparedStatement.setString(2, gym.getLocation());
            preparedStatement.setString(3, gym.getGymName());
            preparedStatement.setString(4, gym.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Failed to insert the record.");
                return ;
            }
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }


        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {
            // 7. Close the resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        insertSlots(gym.getSlots(),id);


    }

    @Override
    public void insertSlots(List<Slots> slots, int gymId){
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        for( Slots slot: slots){
            String insertQuery = "INSERT INTO slots (starttime, seats, gymid) VALUES (?, ?, ?)";

            try {
                statement = conn.createStatement();
                resultSet = statement.executeQuery(insertQuery);
                preparedStatement =  conn.prepareStatement(insertQuery);

                // 5. Set values for the placeholders in the prepared statement

                preparedStatement.setInt(1, slot.getStartTime());
                preparedStatement.setInt(2, slot.getSeatCount());
                preparedStatement.setInt(3, gymId);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Record inserted successfully!");
                } else {
                    System.out.println("Failed to insert the record.");
                    return ;
                }

            } catch (SQLException e) {

                throw new RuntimeException(e);
            } finally {
                // 7. Close the resources
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


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