package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDaoInterface;
import com.flipkart.dao.UpdatePasswordDAOImplementation;
import com.flipkart.dao.UpdatePasswordDAOInterface;


public class GymOwnerServiceOperation implements GymOwnerService{

	HashMap<String,GymOwner> gymOwners = new HashMap();
	GymOwnerDaoInterface gymOwnerDaoInterface = new GymOwnerDAOImplementation();
	Scanner obj = new Scanner(System.in);
	UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImplementation();
	int id = 0;

	/**
	 * This method inserts a given Gym in the DB
	 * @param gym
	 */
	@Override
	public void addGymWithSlots(Gym gym) {
		gymOwnerDaoInterface.addGym(gym);
	}

	/**
	 * This method return the list of booked Gyms for a given user(userId)
	 * @param userId
	 * @return
	 */
	@Override
	public List<Gym> viewMyGyms(String userId){
		return gymOwnerDaoInterface.viewGymSlots(userId);
	}

	/**
	 * This method validates a user with given email and password
	 * @param email
	 * @param password
	 * @return
	 */
	@Override
	public boolean validateLogin(String email, String password) {
		return updatePasswordInterface.verifyGymUserPassword(email, password);
//		if(gymOwnerDaoInterface.validateLogin(email,password)) return true;
//        return false;
    }

	/**
	 * This method creates a new Gym Owner
	 * @param gymOwner
	 */
	@Override
	public void createGymOwner(GymOwner gymOwner){
		gymOwnerDaoInterface.newGymOwner(gymOwner);

	}

	/**
	 * This method verifies a Gym Owner with given email and password
	 * @param email
	 * @param password
	 * @return
	 */
	@Override
	public boolean verifyGymOwnerPassword(String email, String password) {
		return updatePasswordInterface.verifyGymUserPassword(email, password);
    }

	/**
	 * This method updates the Gym Owner Password
	 * @param email
	 * @param password
	 * @param updatedPassword
	 */
	@Override
	public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
		updatePasswordInterface.updateGymOwnerPassword(email, password, updatedPassword);
	}

}
