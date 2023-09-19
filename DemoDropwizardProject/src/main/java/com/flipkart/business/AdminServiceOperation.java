package com.flipkart.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

public class AdminServiceOperation implements AdminService{


	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation();
	Scanner obj = new Scanner(System.in);

	/**
	 * This function lists all the Gym Owners
	 */
	@Override
	public List<GymOwner> viewGymOwners() {
		return adminDaoInterface.viewGymOwners();
	}

	/**
	 * This function lists all the Gyms
	 */
	@Override
	public List<Gym> viewGyms() {
		return adminDaoInterface.viewGyms();
	}

	/**
	 * This function all the Users
	 */
	@Override
	public List<User> viewUsers() {
		return adminDaoInterface.viewUsers();
	}

	/**
	 * This function verifies the Gym with given gymId
	 * @param gymId
	 */
	@Override
	public String verifyGym(int gymId) {
		// TODO Auto-generated method stub
		return adminDaoInterface.verifyGyms(gymId);
	}

	/**
	 * This method verifies the Gym Owner with given GymOwnerId
	 * @param gymOwnerId
	 */
	@Override
	public String verifyGymOwner(int gymOwnerId) {
		// TODO Auto-generated method stub
		return adminDaoInterface.verifyGymOwners(gymOwnerId);

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
