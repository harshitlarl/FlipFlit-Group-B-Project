package com.flipkart.application;

import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceOperation;

public class GymFlipFitGymOwnerMenu {

    GymOwnerService gymOwnerService = new GymOwnerServiceOperation();
    void loginGymOwner(String email, String password){
        if(gymOwnerService.validateLogin(email, password)){
            System.out.println("Login Successful");
        }
        else System.out.println("Wrong credentials");
    }

    void createGymOwner(){
        gymOwnerService.createGymOwner();
    }
}
