package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

//import com.flipkart.dao.GymOwnerDAOImplementation;
//import com.flipkart.dao.DatabaseConnector;

import java.sql.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
//        String insertQuery = "INSERT INTO gyms (address, location, name, status, ownerid) VALUES (?, ?, ?, ?, ?)";
        String insertQuery = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
        int id = 0;
        try {
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(insertQuery, statement.RETURN_GENERATED_KEYS);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, gym.getGymAddress());
            preparedStatement.setString(2, gym.getLocation());
            preparedStatement.setString(3, gym.getGymName());
            preparedStatement.setString(4, gym.getStatus());
            preparedStatement.setString(5, gym.getOwnerId());

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
        }
//        finally {
        // 7. Close the resources
//            try {
//                if (preparedStatement != null) preparedStatement.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        insertSlots(gym.getSlots(),id);

    }

    @Override
    public void newGymOwner(GymOwner gymOwner) {
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String insertQuery = "INSERT INTO gym_owner (email,name, password, phone_number, pancard, aadhar, gst,status ) VALUES(?,?,?,?,?,?,?)";

        try {
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(insertQuery);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, gymOwner.getOwnerEmail());
            preparedStatement.setString(2, gymOwner.getPassword());
            preparedStatement.setString(3, gymOwner.getPhoneNo());
            preparedStatement.setString(4, gymOwner.getPAN());
            preparedStatement.setString(5, gymOwner.getNationalId());
            preparedStatement.setString(6, gymOwner.getGST());
            preparedStatement.setString(7, gymOwner.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Failed to insert the record.");
                return ;
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validateLogin(String email, String password) {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Slots> slotList = new ArrayList<>();
        String password2 = "-";
        try {
            String sqlQuery = "SELECT * FROM gym_owners WHERE email= " + email;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                password2 = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return password2.equals(password);

    }

    @Override
    public void insertSlots(List<Slots> slots, int gymId){
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        for( Slots slot: slots){
            String insertQuery = "INSERT INTO slots (startTime, seatCount, gymId) VALUES (?, ?, ?)";

            try {
                statement = conn.createStatement();
//                resultSet = statement.executeQuery(insertQuery);
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
            }
//            finally {
            // 7. Close the resources
//                try {
//                    if (preparedStatement != null) preparedStatement.close();
//                    if (conn != null) conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }


    }

    @Override
    public List<Gym> viewGymSlots(String gymOwnerID) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM gyms WHERE ownerId=?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, gymOwnerID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                Gym gym = new Gym();
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gym.setLocation(location);
                gym.setStatus(status);
                gyms.add(gym);

                List<Slots> slots = getGymSlotsWithGymId(id);
                gym.setSlots(slots);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            try {
//                if (resultSet != null) resultSet.close();
//                if (preparedStatement != null) preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace(); // Handle or log the exception
//            }
//        }

        return gyms;
    }
//    public List<Gym> viewGymSlots(String gymOwnerID)  {
//        Statement statement = null;
//        ResultSet resultSet = null;
//        List<Gym> gyms = null;
//        try {
//            String sqlQuery = "SELECT * FROM gyms WHERE email= " + gymOwnerID;
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery(sqlQuery);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String gymAddress = resultSet.getString("gymAddress");
//                String location = resultSet.getString("location");
//                String gymName = resultSet.getString("gymName");
//                String status = resultSet.getString("status");
//                Gym gym = new Gym();
//                gym.setGymName(gymName);
//                gym.setGymAddress(gymAddress);
//                gym.setOwnerId(gymOwnerID);
//                gym.setLocation(location);
//                gym.setStatus(status);
//                gyms.add(gym);
//
////                List<Slots> slots = getGymSlotsWithGymId(id);
////                gym.setSlots(slots);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        return gyms;
//    }

    public List<Slots> getGymSlotsWithGymId(int id){
        Statement statement = null;
        ResultSet resultSet = null;
        List<Slots> slotList = new ArrayList<>();
        try {
            String sqlQuery = "SELECT * FROM slots WHERE gymId= " + id;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {

                int startTime = resultSet.getInt("startTime");
                int seats = resultSet.getInt("seatCount");
                Slots slots = new Slots(1,startTime,seats);

                slotList.add(slots);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return slotList;
    }
}