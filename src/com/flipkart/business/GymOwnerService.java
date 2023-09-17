/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * @author bhavya.khandelwal
 */
public interface GymOwnerService {
	void addGymWithSlots(Gym gym);
	List<Gym> viewMyGyms(String userId);

    boolean verifyGymOwnerPassword(String email, String password, String updatedPassword);

    boolean validateLogin(String email, String password);

	void createGymOwner(GymOwner gymOwner);



	void updateGymOwnerPassword(String email, String password, String updatedPassword);
}
