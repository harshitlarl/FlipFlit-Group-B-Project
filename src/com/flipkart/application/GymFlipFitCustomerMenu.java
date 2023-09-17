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
        if(validateUser(username,pass)){
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
                        List<Gym> x = viewAllGymswithSlots();
                        System.out.println(x.size());
                        break;
                    case 2:
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID");
                        int gymId = Integer.parseInt(obj.nextLine());
//                        System.out.println("Slot Date (only date, no month)");
//                        int date = Integer.parseInt(obj.nextLine());
                        System.out.println("Slot Time");
                        int time = Integer.parseInt(obj.nextLine());

                        if(bookSlot(gymId,time,username)){
                            System.out.println("Booked Successfully");
                        }else{
                            System.out.println("Booking Unsuccessful");
                        }
                        break;
                    case 3:
                        Scanner sc=new Scanner(System.in);
                        System.out.println(viewAllBookings(username));
                        System.out.println("Enter Booking ID");
                        int bookingId=sc.nextInt();
                        cancelSlot(bookingId);
                        break;
                    case 4:
                        System.out.println("My Bookings");

                        System.out.println(viewAllBookings(username));
                        break;
                    case 5:

                        String location="bangalore";
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

    public boolean validateUser(String username, String pass) {
        return userServiceOperation.validateUser(username,pass);
    }

    List<Gym> viewAllGymswithSlots(){
        System.out.println("List of Gyms");
        List<Gym> gymList=userServiceOperation.getAllGymsWithSlots();
        return gymList;
    }
    public boolean bookSlot(int gymId, int time,String email){
        return userServiceOperation.bookSlots(gymId,time,email);
    }
    public boolean cancelSlot(int bookingId){
        System.out.println("Slot Cancelled");
        return userServiceOperation.cancelSlots(bookingId);
    }
    public List<Bookings> viewAllBookings(String userid){
        System.out.println("My Bookings");
        List<Bookings> myBookings = userServiceOperation.getAllBookings(userid);
        return myBookings;
    }
    List<Gym> viewAllGymsByArea(String location){
        System.out.println("List of Gyms");
        List<Gym> gymList=userServiceOperation.getAllGymsByArea(location);
        return gymList;
    }

    public void createCustomer() {
        System.out.println("Enter the following info:");
        System.out.println("\nYour email: ");
        String ownerEmail = obj.nextLine();
        System.out.println("\nYour name: ");
        String ownerName = obj.nextLine();
        System.out.println("\nEnter a password: ");
        String password = obj.nextLine();
        System.out.println("\nPhone number: ");
        String phoneNo = obj.nextLine();
        System.out.println("\nEnter Address ");
        String nationalId = obj.nextLine();
        System.out.println("\nLocation: ");
        String GST = obj.nextLine();

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(nationalId);
        user.setLocation(GST);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);


        userServiceOperation.createUser(user);
    }
}
