/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;

/**
 * @author avinash.parashar
 */
public interface UserServices {
	boolean bookSlots();
	boolean cancelSlots(int slotId);
	List<Bookings> getAllBookings(int userId);
	List<Gym> getAllGymsWithSlots();
	List<Gym> getAllGymsByArea(String area);
	
}
