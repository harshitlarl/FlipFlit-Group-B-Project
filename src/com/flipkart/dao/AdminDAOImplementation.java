package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImplementation implements AdminDAOInterface {
    DatabaseConnector connector ;
    Connection conn;
    @Override
    public void viewGyms()  {
        Statement statement = null;
        ResultSet resultSet = null;
        conn = DatabaseConnector.getConnection();
        try {
            statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM gyms";
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                int ownerId = resultSet.getInt("ownerId");
                String name = resultSet.getString("name");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String status = resultSet.getString("status");

                // Print the data or perform any other operations you need
                System.out.println("Gym ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Owner Id : " + ownerId);
                System.out.println("Gym Address : " + gymAddress);
                System.out.println("Gym Location : " + location);
                System.out.println("Status of Gym(verified or not) : " + status);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void viewUsers() {
        Statement statement = null;
        ResultSet resultSet = null;
        conn = DatabaseConnector.getConnection();
        try {
            statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM users";
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("userId");
                int phoneNo = resultSet.getInt("phoneNumber");
                String name = resultSet.getString("userName");
                String address = resultSet.getString("address");
                String loc = resultSet.getString("location");
                String email = resultSet.getString("email");

                // Print the data or perform any other operations you need
                System.out.println("Gym ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone No : " + phoneNo);
                System.out.println("Address : " + address);
                System.out.println("Email Id : " + email);

                System.out.println("Location : " + loc);
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void viewGymOwners() {
        Statement statement = null;
        ResultSet resultSet = null;
        conn = DatabaseConnector.getConnection();
        try {
            statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM gymOwners";
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("gymOwnerId");
                int phoneNo = resultSet.getInt("phoneNumber");
                String name = resultSet.getString("userName");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String adhaar = resultSet.getString("adhaarNumber");
                String pan = resultSet.getString("panNumber");

                // Print the data or perform any other operations you need
                System.out.println("Gym ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone No : " + phoneNo);
                System.out.println("Address : " + address);
                System.out.println("Email Id : " + email);
                System.out.println("Adhaar no : " + adhaar);
                System.out.println("PAN Card Number : " + pan);

                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void verifyGymOwners(int id) {
        // update the gymOwner db's status as verified.
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //TODO -> for each onwer, update their status as verified.
            String query = "UPDATE gymOwners set STATUS = ? where gymOwnerId = ? ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "verified"); // set input parameter 1
            pstmt.setString(2, Integer.toString(id)); // set input parameter 2
            int stats = pstmt.executeUpdate(); // execute update statement
            //conn.commit();

            if(stats > 0 ) {
                System.out.println("Verified GymOwner successfully");
            } else {
                System.out.println("Gym Owner verification failed");
            }

            System.out.println("---------------------------------");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void verifyGyms(int id) {
        PreparedStatement preparedStatement = null;
        conn = DatabaseConnector.getConnection();
        try {
            //TODO -> for each onwer, update their status as verified.
            String query = "UPDATE gyms set STATUS = ? where gymId = ? ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "verified"); // set input parameter 1
            pstmt.setString(2, Integer.toString(id)); // set input parameter 2
            int stats = pstmt.executeUpdate(); // execute update statement
            //conn.commit();

            if(stats > 0 ) {
                System.out.println("Verified Gym successfully");
            } else {
                System.out.println("Gym Owner verification failed");
            }

            System.out.println("---------------------------------");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Gym> getUnverifiedGyms() {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM gyms WHERE status=?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Unverified");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                String gymOwnerID = resultSet.getString("id");
                Gym gym = new Gym();
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gym.setLocation(location);
                gym.setStatus(status);
                gyms.add(gym);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gyms;
    }

    @Override
    public List<GymOwner> getUnverifiedGymOwner() {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GymOwner> gymOwners = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM gymOwners WHERE status=?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Unverified");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymOwnerId");
                String gymOwnerID = resultSet.getString("ownerId");
                String email = resultSet.getString("ownerEmail");
                String ph = resultSet.getString("phoneNo");
                String nationalId = resultSet.getString("nationalId");
                String gst = resultSet.getString("GST");

                GymOwner x = new GymOwner();
                x.setOwnerId(id);
                x.setOwnerEmail(email);
                x.setPhoneNo(ph);
                x.setNationalId(nationalId);
                x.setGST(gst);

                gymOwners.add(x);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gymOwners;
    }
}
