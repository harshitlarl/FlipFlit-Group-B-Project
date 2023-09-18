/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

/**
 * @author avinash.parashar
 */
public interface UserServices {

	/**
	 * This method cancels a slot with a given bookingId
	 * @param slotId
	 * @return
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	boolean cancelSlots(int slotId);

	/**
	 * This method lists all the Bookings with given userId
	 * @param userId
	 * @return
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	List<Bookings> getAllBookings(String userId);

	/**
	 * This method lists all the Gyms with all the slots available
	 * @return List<Gym>
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	List<Gym> getAllGymsWithSlots();

	/**
	 * This method lists all the Gyms in a particular area
	 * @param area
	 * @return List<Gym>
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	List<Gym> getAllGymsByArea(String area);

	/**
	 * This method books a slot with given gymId, time and email specific to a user
	 * @param gymId
	 * @param time
	 * @param email
	 * @return
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	boolean bookSlots(int gymId, int time, String email);

	/**
	 * This method validates a User with a given Username and password
	 * @param username
	 * @param pass
	 * @return true if validation succeeds
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	boolean validateUser(String username, String pass);

	/**
	 * This method creates a User
	 * @param user
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	void createUser(User user);
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword);

	/**
	 * This method verifies a User Password with given email and password
	 * @param email
	 * @param password
	 * @param updatedPassword
	 * @return
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	void updateGymUserPassword(String email, String password, String updatedPassword);
}
