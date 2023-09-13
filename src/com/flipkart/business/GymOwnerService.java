/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;

/**
 * @author bhavya.khandelwal
 */
public interface GymOwnerService {
	void addGymWithSlots();
	List<Gym> viewMyGyms();
}
