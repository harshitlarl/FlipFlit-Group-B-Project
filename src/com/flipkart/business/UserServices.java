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

	boolean cancelSlots(int slotId);
	List<Bookings> getAllBookings(String userId);
	List<Gym> getAllGymsWithSlots();
	List<Gym> getAllGymsByArea(String area);

	boolean bookSlots(int gymId, int time, String email);

	boolean validateUser(String username, String pass);

	void createUser(User user);
}
