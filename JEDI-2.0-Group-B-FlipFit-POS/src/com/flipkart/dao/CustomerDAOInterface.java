package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

public interface CustomerDAOInterface {
    /**
     * Retrieve a list of all gyms in a specific area.
     * @return List of gyms in the specified area
     * @author: Atulya, Bhavya
     */
    List<Gym> getAllGymsByArea();

    /**
     * Book a slot at a specific gym for a given time using the user's email.
     * @param gymId - The ID of the gym
     * @param time - The time slot to be booked
     * @param email - The email of the user making the booking
     * @return True if the booking is successful, false otherwise
     * @author: Atulya, Bhavya
     */
    boolean bookSlot(int gymId, int time, String email);

    /**
     * Retrieve a list of all bookings made by a specific user.
     * @param userId - The ID of the user
     * @return List of bookings made by the user
     * @author: Atulya, Bhavya
     */
    List<Bookings> getAllBookingByUserID(String userId);

    /**
     * Cancel a specific booking by its ID.
     * @param bookingId - The ID of the booking to be canceled
     * @return True if the booking is successfully canceled, false otherwise
     * @author: Atulya, Bhavya
     */
    boolean cancelBooking(int bookingId);

    /**
     * Validate a user's credentials (username and password).
     * @param username - The username of the user
     * @param pass - The password of the user
     * @return True if the user's credentials are valid, false otherwise
     * @author: Atulya, Bhavya
     */
    boolean validateUser(String username, String pass);

    /**
     * Create a new user.
     * @param user - The user object to be created
     * @author: Atulya, Bhavya
     */
    void createUser(User user);
}
