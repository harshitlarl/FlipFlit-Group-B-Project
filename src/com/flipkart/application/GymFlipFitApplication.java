package com.flipkart.application;

import java.util.Scanner;

public class GymFlipFitApplication {
    static GymFlipFitGymOwnerMenu owner = new GymFlipFitGymOwnerMenu();
    static GymFlipFitCustomerMenu customer = new GymFlipFitCustomerMenu();
    static Scanner obj = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit application for slot booking!");
        boolean loggedInGym = false;
        String currentUser = null;
        boolean exitFlag = false;
        while(true) {
            System.out.println("1. Login");
            System.out.println("2. Registration of Gymowner");
            System.out.println("3. Update Password");
            System.out.println("4. Exit");
            int x = Integer.parseInt(obj.nextLine());
            switch (x) {
                case 1 :
                    //System.out.println("Call gymFlipFitApp");
                    System.out.println("Enter email");
                    String userId = obj.nextLine();
                    System.out.println("Enter password");
                    String password = obj.nextLine();
                    System.out.println("Enter role (Admin/Customer/GymOwner)");
                    String role = obj.nextLine();

                    switch (role) {
                        case "Admin" :
                            //GymFlipFitAdminMenu admin = new GymFlipFitAdminMenu();
                            //insert here the specific method

                            System.out.println("1. Approve Gym Owners");
                            System.out.println("2. View Pending Gym Owners");
                            System.out.println("3. Approve Gym slots");
                            System.out.println("4. View Pending Gym slots");
                            System.out.println("5. Logout");
                            int k = Integer.parseInt(obj.nextLine());
                            break;
                        case "Customer" :
                            if(!customer.userLogin(userId,password))
                                System.out.println("Invalid credentials");
                            break;
                        case "GymOwner" :
                            if(!owner.gymOwnerLogin(userId,password)){
                                System.out.println("Invalid credentials");
                            }

                            break;
                    }

                    break;
                case 2 :
                    owner.createGymOwner();
                    break;
                case 3 :
                    System.out.println("Call to update password in the customer menu");
                    break;
                case 4 :
                    //end
                    exitFlag = true;
                    System.out.println("Thank you for using FlipFit :)");
                    break;
                }
            if(exitFlag)break;
        }


    }
}

