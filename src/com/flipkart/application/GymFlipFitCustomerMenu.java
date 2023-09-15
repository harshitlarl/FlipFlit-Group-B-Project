package com.flipkart.application;
import java.util.*;
import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.UserServiceOperations;

import java.util.ArrayList;
import java.util.Scanner;

public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
    UserServiceOperations userServiceOperation = new UserServiceOperations();
    User user = new User();
    public boolean userLogin(String username, String pass){
        String dummyUsername="abc";
        String dummyPass="abc";
        if(username.equals(dummyUsername) && pass.equals(dummyPass)){
            boolean flag = true;
            System.out.println("Login Successful");
            while(flag){
                System.out.println("Login Successful");
                System.out.println("1. View all Gyms with slots");
                System.out.println("2. Book Slot");
                System.out.println("3. Cancel Slot");
                System.out.println("4. View all Bookings");
                System.out.println("5. View all Gyms by Area");
                System.out.println("6. Logout");
                int choice = Integer.parseInt(obj.nextLine());
                switch(choice){
                    case 1:
                        System.out.println(viewAllGymswithSlots());
                        break;
                    case 2:
                        System.out.println();
                        bookSlot();
                        break;
                    case 3:
                        Scanner sc=new Scanner(System.in);
                        int slotId=sc.nextInt();
                        cancelSlot(slotId);
                        break;
                    case 4:
                        System.out.println("My Bookings");
                        int userId=user.getuserId();
                        System.out.println(viewAllBookings(userId));
                        break;
                    case 5:
                        System.out.println("Gyms near me");
                        String location=user.getLocation();
                        System.out.println(viewAllGymsByArea(location));
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong Choice");
                }
            }

        }
        else return false;
        return true;
    }
    List<Gym> viewAllGymswithSlots(){
        System.out.println("List of Gyms");
        List<Gym> gymList=userServiceOperation.getAllGymsWithSlots();
        return gymList;
    }
    public boolean bookSlot(){
        return userServiceOperation.bookSlots();
    }
    public boolean cancelSlot(int slotId){
        System.out.println("Slot Cancelled");
        return userServiceOperation.cancelSlots(slotId);
    }
    public List<Bookings> viewAllBookings(int userid){
        System.out.println("My Bookings");
        List<Bookings> myBookings = userServiceOperation.getAllBookings(userid);
        return myBookings;
    }
    List<Gym> viewAllGymsByArea(String location){
        System.out.println("List of Gyms");
        List<Gym> gymList=userServiceOperation.getAllGymsByArea(location);
        return gymList;
    }
}
