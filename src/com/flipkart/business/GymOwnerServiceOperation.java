package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;


public class GymOwnerServiceOperation implements GymOwnerService{

	HashMap<String,GymOwner> gymOwners = new HashMap();
	Scanner obj = new Scanner(System.in);
	int id = 0;
	@Override
	public void addGymWithSlots(String email) {
		Gym gym = new Gym();
		gym.setGymId(1);
		System.out.println("Enter the following info:");
		System.out.println("\nEnter gym name:");
		String gymName = obj.nextLine();
		System.out.println("\nGym Address:");
		String address = obj.nextLine();
		System.out.println("\nGym Location:");
		String location = obj.nextLine();

		gym.setGymAddress(address);
		gym.setLocation(location);
		gym.setGymName(gymName);
		List<Slots> slots = new ArrayList<>();
		System.out.println("\nHow many slots to be entered?");
		int slotNo = Integer.parseInt(obj.nextLine());
		int x = 1;
		while(slotNo != 0){
			System.out.println("Add slot no. " + x++ + "\n");
			System.out.println("\nEnter start time:");
			int startTime = Integer.parseInt(obj.nextLine());
			System.out.println("\nEnter available seats:");
			int number = Integer.parseInt(obj.nextLine());
			Slots slot = new Slots(x,startTime,number);
			slots.add(slot);
			slotNo--;
		}
		gym.setSlots(slots);
		List<Gym> currentGyms = gymOwners.get(email).getGyms();
		currentGyms.add(gym);
		gymOwners.get(email).setGyms(currentGyms);
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
