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

/**
 * @author avinash.parashar
 */
public class UserServiceOperations implements UserServices {

	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();


	@Override
	public boolean cancelSlots(int bookingId) {
		// TODO Auto-generated method stub

		return customerDAOInterface.cancelBooking(bookingId);
	}

	@Override
	public List<Bookings> getAllBookings(String userId) {
		// TODO Auto-generated method stub

		return customerDAOInterface.getAllBookingByUserID( userId);
	}

	@Override
	public List<Gym> getAllGymsWithSlots() {
		// TODO Auto-generated method stub
		customerDAOInterface.getAllGymsByArea();
		return null;
	}

	@Override
	public List<Gym> getAllGymsByArea(String area) {
		// TODO Auto-generated method stub
		customerDAOInterface.getAllGymsByArea();
		return null;
	}

	@Override
	public boolean bookSlots(int gymId, int time, String email) {
		boolean x = customerDAOInterface.bookSlot(gymId,time,email);
		return false;
	}

	@Override
	public boolean validateUser(String username, String pass) {
		return customerDAOInterface.validateUser(username,pass);
	}

	@Override
	public void createUser(User user) {
		customerDAOInterface.createUser(user);
	}

}
