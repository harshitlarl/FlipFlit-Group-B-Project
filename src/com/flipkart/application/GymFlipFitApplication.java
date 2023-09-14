package com.flipkart.application;

import java.util.Scanner;

public class GymFlipFitApplication {
    static GymFlipFitGymOwnerMenu owner = new GymFlipFitGymOwnerMenu();
    static Scanner obj = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit application for slot booking!");
        boolean loggedInGym = false;
        String currentUser = null;
        while(true) {




            boolean exitFlag = false;
            if(loggedInGym){
                System.out.println("1. Add a gym");
                System.out.println("2. View all gyms");
                System.out.println("3. Logout");
                int y = Integer.parseInt(obj.nextLine());

                switch (y) {
                    case 1:
                        owner.addGym(currentUser);
                        break;
                    case 2:
                        owner.displayGyms(currentUser);
                        break;
                    case 3:
                        currentUser= null;
                        loggedInGym=false;
                        break;
                }
            }
            else{
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
                                //GymFlipFitCustomerMenu customer = new GymFlipFitCustomerMenu();
                                //insert the customer service call
                                System.out.println("1. View lists of gyms and info");
                                System.out.println("2. Book slots in gyms");
                                System.out.println("3. Cancel booked slots");
                                System.out.println("4. Logout");
                                k = Integer.parseInt(obj.nextLine());
                                break;
                            case "GymOwner" :
                                if(owner.loginGymOwner(userId,password)){
                                    loggedInGym = true;
                                    currentUser = userId;
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
            }

            if(exitFlag)break;
        }
    }
}
