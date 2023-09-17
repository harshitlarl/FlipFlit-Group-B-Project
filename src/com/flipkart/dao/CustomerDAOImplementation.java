package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.bean.User;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.exception.SlotsUnavailableException;
import com.flipkart.utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImplementation implements CustomerDAOInterface {

    DatabaseConnector connector ;
    Connection conn;
    @Override
    public List<Gym> getAllGymsByArea() {
        conn = DatabaseConnector.getConnection();
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
            System.out.println(e.getMessage());;
        }

        return gyms;
    }

    @Override
    public boolean bookSlot(int gymId, int time,String email) {
        conn = DatabaseConnector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String insertQuery = "INSERT INTO Booking (userId,status,date,time,slotId,GymId ) VALUES(?,?,?,?,?,?)";


        try {
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(insertQuery);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, "CONFIRMED");
            preparedStatement.setInt(3, 11);
            preparedStatement.setInt(4, time);
            preparedStatement.setInt(5, time);
            preparedStatement.setInt(6, gymId);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                throw new SlotsUnavailableException();

//                System.out.println("Failed to insert the record.");
//                return false;
            }

        }catch(SlotsUnavailableException | SQLException ex){
            System.out.println(ex.getMessage());

        }
        return true;
    }

    @Override
    public List<Bookings> getAllBookingByUserID(String userId) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bookings> bookings = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM Booking where userId=" + userId;
            preparedStatement = conn.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("bookingId");
                int date = resultSet.getInt("date");
                int time = resultSet.getInt("time");
                int slotId = resultSet.getInt("slotId");
                String status = resultSet.getString("status");
                int gymId = resultSet.getInt("gymId");
                Bookings booking = new Bookings();
                booking.setBookingId(id);
                booking.setDate(date);
                booking.setTime(time);
                booking.setSlotId(slotId);
                booking.setStatus(status);
                booking.setGymId(gymId);
                bookings.add(booking);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookings;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        conn = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bookings> bookings = new ArrayList<>();

        try {
            String sqlQuery = "DELETE * FROM Booking where bookingId=" + bookingId;
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean validateUser(String username, String pass) {
        conn = DatabaseConnector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String password2 = "-";
        try {
            String sqlQuery = "SELECT * FROM User WHERE email= \""  + username + "\"";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                password2 = resultSet.getString("password");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return password2.equals(pass);
    }

    @Override
    public void createUser(User user) {
        conn = DatabaseConnector.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String insertQuery = "INSERT INTO User (userName,email, password, phoneNumber, Address, location) VALUES(?,?,?,?,?,?)";

        try {
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(insertQuery);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getLocation());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                throw new RegistrationFailedException();

//                System.out.println("Failed to insert the record.");
            }

        }catch(RegistrationFailedException ex){
            System.out.println("User "+ ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Slots> getGymSlotsWithGymId(int id){
        conn = DatabaseConnector.getConnection();
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
            System.out.println(e.getMessage());
        }
        return slotList;
    }
}
