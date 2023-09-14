package com.flipkart.application;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceOperation;

import java.util.List;

public class GymFlipFitGymOwnerMenu {

    GymOwnerService gymOwnerService = new GymOwnerServiceOperation();
    boolean loginGymOwner(String email, String password){
        if(gymOwnerService.validateLogin(email, password)){
            System.out.println("Login Successful");
            return true;
        }
        System.out.println("Wrong credentials");
        return true;
    }
    void addGym(String userId){
        gymOwnerService.addGymWithSlots(userId);
    }
    void createGymOwner(){
        gymOwnerService.createGymOwner();
    }

    void displayGyms(String userId){
        List<Gym> gymsList= gymOwnerService.viewMyGyms(userId);
        int x = 1;
        for(Gym gym:gymsList){
            System.out.println("Gym " + x + ": Name " + gym.getGymName() + " Address: " + gym.getGymAddress() + " Location: " + gym.getLocation() );
            System.out.println("Slots: ");
            for(Slots slot:gym.getSlots()){
                System.out.println("Slot: " + slot.getSlotsId() + " Slot Time: " + slot.getStartTime() + " - " + (slot.getStartTime() + 1) + " Seats: " + slot.getSeatCount() );
            }
            x++;
        }
    }
}
