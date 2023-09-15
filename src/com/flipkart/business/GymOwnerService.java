/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Gym;

/**
 * @author bhavya.khandelwal
 */
public interface GymOwnerService {
	void addGymWithSlots(Gym gym);
	List<Gym> viewMyGyms(String userId);

	boolean validateLogin(String email, String password);

	void createGymOwner();
}
