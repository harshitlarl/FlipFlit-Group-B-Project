package com.flipkart.application;

import java.util.Scanner;

public class GymFlipFitApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit application for slot booking!");

        while(true) {
            Scanner obj = new Scanner(System.in);
            System.out.println("1. Login");
            System.out.println("2. Registration of Customer");
            System.out.println("3. Update Password");
            System.out.println("4. Exit\n");

            int x = obj.nextInt();
            boolean exitFlag = false;

            switch (x) {
                case 1 :
                    //System.out.println("Call gymFlipFitApp");
                    System.out.println("Enter userId");
                    String userId = obj.nextLine();
                    System.out.println("Enter password");
                    String password = obj.nextLine();
                    System.out.println("Enter role (Admin/Customer/GymOwner)");
                    String role = obj.nextLine();

                    switch (role) {
                        case "Admin" :
                            //GymFlipFitAdminMenu admin = new GymFlipFitAdminMenu();
                            //insert here the specific method
                            System.out.println("Admin service calls here");
                            break;
                        case "Customer" :
                            //GymFlipFitCustomerMenu customer = new GymFlipFitCustomerMenu();
                            //insert the customer service call
                            System.out.println("Customer service calls here");
                            break;
                        case "GymOwner" :
                            //GymFlipFitGymOwnerMenu owner = new GymFlipFitGymOwnerMenu();
                            //
                            System.out.println("GymOwner service calls here");
                            break;
                    }

                    break;
                case 2 :
                    System.out.println("Call GymFlipFitCustomerApp");
                    break;
                case 3 :
                    System.out.println("Call to update password in the customer menu");
                    break;
                case 4 :
                    //end
                    exitFlag = true;
                    System.out.println("Thankyou for using FlipFit :)");
                    break;
            }

            if(exitFlag)break;
        }
    }
}
