package com.flipkart.application;
import java.util.*;

import com.flipkart.bean.*;
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
                System.out.println("=========CUSTOMER MENU=========");
                System.out.println("Press 1 to View all Gyms with slots");
                System.out.println("Press 2 to Book Slot");
                System.out.println("Press 3 to Cancel Slot");
                System.out.println("Press 4 to View all Bookings");
                System.out.println("Press 5 to View all Gyms by Area");
                System.out.println("Press 6 to Logout");
                int choice = Integer.parseInt(obj.nextLine());
                switch(choice){
                    case 1:
                        List<Gym> x = viewAllGymswithSlots();
                        for(Gym gym:x){
                            System.out.println("Gym name: " + gym.getGymName() + " Gym ID: " + gym.getGymId() + " Gym Location: " + gym.getLocation() + " Gym Address: " + gym.getGymAddress());
                            System.out.println("Slot List");
                            for(Slots slot: gym.getSlots()) {
                                System.out.println(" Slot start time: "  + slot.getStartTime() + " Slot end time: " + (slot.getStartTime() + 1) + " Remaining seat count: " + slot.getSeatCount());
                            }
                        }
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
                        System.out.println("My Bookings");
                        System.out.println(viewAllBookings(username));
                        System.out.println("Enter Booking ID");
                        int bookingId=sc.nextInt();
                        cancelSlot(bookingId);
                        break;
                    case 4:
                        System.out.println("My Bookings");
                        List<Bookings> bookings = viewAllBookings(username);
                        for(Bookings booking:bookings ){
                            System.out.println("Booking ID: " + booking.getBookingId() + " Booking Status: " + booking.getStatus() + " Time: " + booking.getTime() + " GymID: " + booking.getGymId());
                        }
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
