package com.flipkart.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

public class AdminServiceOperation implements AdminService{


	AdminDAOInterface adminDaoInterface = new AdminDAOImplementation();
	Scanner obj = new Scanner(System.in);

	@Override
	public void viewGymOwners() {
		adminDaoInterface.viewGymOwners();
	}

	@Override
	public void viewGyms() {
		adminDaoInterface.viewGyms();
	}

	@Override
	public void viewUsers() {
		adminDaoInterface.viewUsers();
	}

	@Override
	public void verifyGym(int gymId) {
		// TODO Auto-generated method stub
		adminDaoInterface.verifyGyms(gymId);
	}

	@Override
	public void verifyGymOwner(int gymOwnerId) {
		// TODO Auto-generated method stub
		adminDaoInterface.verifyGymOwners(gymOwnerId);

	}

	@Override
	public List<GymOwner> getUnverifiedGymOwners() {
		// TODO Auto-generated method stub
		return adminDaoInterface.getUnverifiedGymOwner();
	}

	@Override
	public List<Gym> getUnverifiedGyms() {
		// TODO Auto-generated method stub
		return adminDaoInterface.getUnverifiedGyms();
	}

}
