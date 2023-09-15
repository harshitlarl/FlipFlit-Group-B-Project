package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDaoInterface;


public class GymOwnerServiceOperation implements GymOwnerService{

	HashMap<String,GymOwner> gymOwners = new HashMap();
	GymOwnerDaoInterface gymOwnerDaoInterface = new GymOwnerDAOImplementation();
	Scanner obj = new Scanner(System.in);
	int id = 0;
	@Override
	public void addGymWithSlots(Gym gym) {
		gymOwnerDaoInterface.addGym(gym);
	}
	@Override
	public List<Gym> viewMyGyms(String userId){
		return gymOwners.get(userId).getGyms();
	}

	@Override
	public boolean validateLogin(String email, String password) {
		if(!gymOwners.containsKey(email)) return false;
        return Objects.equals(gymOwners.get(email).getPassword(), password);
    }

	@Override
	public void createGymOwner(){


		System.out.println("Enter the following info:");
		System.out.println("\nYour email: ");
		String ownerEmail = obj.nextLine();
		System.out.println("\nEnter a password: ");
		String password = obj.nextLine();
		System.out.println("\nPhone number: ");
		String phoneNo = obj.nextLine();
		System.out.println("\nNation ID/ Aadhar Number: ");
		String nationalId = obj.nextLine();
		System.out.println("\nGST: ");
		String GST = obj.nextLine();

		GymOwner gymOwner = new GymOwner();
		List<Gym> emptyGymList = new ArrayList<>();
		gymOwner.setOwnerEmail(ownerEmail);
		gymOwner.setOwnerId(id++);
		gymOwner.setGST(GST);
		gymOwner.setPassword(password);
		gymOwner.setNationalId(nationalId);
		gymOwner.setPhoneNo(phoneNo);
		gymOwner.setGyms(emptyGymList);

		gymOwners.put(ownerEmail,gymOwner);
	}

}
