package com.flipkart.business;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

public class AdminServiceOperation implements AdminService{


	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation();
	Scanner obj = new Scanner(System.in);

	/**
	 * This function lists all the Gym Owners
	 *
	 * @return
	 */
	@Override
	public List<GymOwner> viewGymOwners() {
		return adminDaoInterface.viewGymOwners();
	}

	/**
	 * This function lists all the Gyms
	 */
	@Override
	public void viewGyms() {
		adminDaoInterface.viewGyms();
	}

	/**
	 * This function all the Users
	 */
	@Override
	public void viewUsers() {
		adminDaoInterface.viewUsers();
	}

	/**
	 * This function verifies the Gym with given gymId
	 * @param gymId
	 */
	@Override
	public void verifyGym(int gymId) {
		// TODO Auto-generated method stub
		adminDaoInterface.verifyGyms(gymId);
	}

	/**
	 * This method verifies the Gym Owner with given GymOwnerId
	 * @param gymOwnerId
	 */
	@Override
	public void verifyGymOwner(int gymOwnerId) {
		// TODO Auto-generated method stub
		adminDaoInterface.verifyGymOwners(gymOwnerId);

	}

	/**
	 * This function fetches the list of Un-verified Gym Owners
	 * @return List<GymOwner>
	 */
	@Override
	public List<GymOwner> getUnverifiedGymOwners() {
		// TODO Auto-generated method stub
		return adminDaoInterface.getUnverifiedGymOwner();
	}

	/**
	 * This function fetches the list of Un-verified Gyms
	 * @return List<Gym>
	 */
	@Override
	public List<Gym> getUnverifiedGyms() {
		// TODO Auto-generated method stub
		return adminDaoInterface.getUnverifiedGyms();
	}

}
