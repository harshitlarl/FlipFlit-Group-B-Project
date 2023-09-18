/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.dao.UpdatePasswordDAOImplementation;
import com.flipkart.dao.UpdatePasswordDAOInterface;

/**
 * @author avinash.parashar
 */
public class UserServiceOperations implements UserServices {

	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();
	UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImplementation();

	/**
	 * This method verifies a User Password with given email and password
	 * @param email
	 * @param password
	 * @param updatedPassword
	 * @return
	 */
	@Override
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
		return false;
	}

	/**
	 * This method cancels a slot with a given bookingId
	 * @param bookingId
	 * @return
	 */
	@Override
	public boolean cancelSlots(int bookingId) {
		// TODO Auto-generated method stub

		return customerDAOInterface.cancelBooking(bookingId);
	}

	/**
	 * This method lists all the Bookings with given userId
	 * @param userId
	 * @return
	 */
	@Override
	public List<Bookings> getAllBookings(String userId) {
		// TODO Auto-generated method stub

		return customerDAOInterface.getAllBookingByUserID( userId);
	}

	/**
	 * This method lists all the Gyms with all the slots available
	 * @return List<Gym>
	 */
	@Override
	public List<Gym> getAllGymsWithSlots() {
		// TODO Auto-generated method stub
		return customerDAOInterface.getAllGymsByArea();
	}

	/**
	 * This method lists all the Gyms in a particular area
	 * @param area
	 * @return
	 */
	@Override
	public List<Gym> getAllGymsByArea(String area) {
		// TODO Auto-generated method stub
		return customerDAOInterface.getAllGymsByArea();

	}

	/**
	 * This method books a slot with given gymId, time and email specific to a user
	 * @param gymId
	 * @param time
	 * @param email
	 * @return
	 */
	@Override
	public boolean bookSlots(int gymId, int time, String email) {
		boolean x = customerDAOInterface.bookSlot(gymId,time,email);
		return false;
	}

	/**
	 * This method validates a User with a given Username and password
	 * @param username
	 * @param pass
	 * @return true if validation succeeds
	 */
	@Override
	public boolean validateUser(String username, String pass) {
		return customerDAOInterface.validateUser(username,pass);
	}

	/**
	 * This method creates a User
	 * @param user
	 */
	@Override
	public void createUser(User user) {
		customerDAOInterface.createUser(user);
	}

	/**
	 * This method updates the Gym User Password
	 * @param email
	 * @param password
	 * @param updatedPassword
	 */
	@Override
	public void updateGymUserPassword(String email, String password, String updatedPassword) {
		updatePasswordInterface.updateGymUserPassword(email, password, updatedPassword);
	}

}
