/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

/**
 * @author avinash.parashar
 */
public class UserServiceOperations implements UserServices {

	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();
	@Override
	public boolean bookSlots() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelSlots(int slotId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Bookings> getAllBookings(int userId) {
		// TODO Auto-generated method stub
		return null;
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

		return null;
	}

}
