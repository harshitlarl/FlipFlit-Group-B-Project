package com.flipkart.application;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
    public boolean userLogin(String userId, String pass){
        String dummyUserId="abc";
        String dummyPass="abc";
        if(userId.equals(dummyUserId) && pass.equals(dummyPass)){
            System.out.println("Login Successful");
            System.out.println("1. View all Gyms");
            System.out.println("2. Book Slot");
            System.out.println("3. Cancel Slot");
            System.out.println("4. View Profile");
            System.out.println("5. View all Bookings");
            int choice = Integer.parseInt(obj.nextLine());
            switch(choice){
                case 1:
                    ArrayList<Gym> gymList=viewAllGyms();
                    System.out.println(gymList);
                    break;
                case 2:

            }
        }
        return true;
    }
    ArrayList<Gym> viewAllGyms(){
        System.out.println("List of Gyms");
        ArrayList<Gym> gymList = new ArrayList<Gym>();
        return gymList;
    }
}
