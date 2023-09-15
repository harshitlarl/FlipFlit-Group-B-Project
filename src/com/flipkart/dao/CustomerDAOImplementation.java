package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplementation implements CustomerDAOInterface {

    DatabaseConnector connector ;
    Connection conn;

    public CustomerDAOImplementation() {
        connector = new DatabaseConnector();
        try {
            conn = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Gym> getAllGymsByArea() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM gyms";
            preparedStatement = conn.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                String gymOwnerID = resultSet.getString("ownerid");
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
//
        return gyms;
    }
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
