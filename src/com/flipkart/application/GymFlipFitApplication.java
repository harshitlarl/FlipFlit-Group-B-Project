package com.flipkart.application;

import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.business.UserServiceOperations;
import com.flipkart.business.UserServices;
import com.flipkart.utils.DatabaseConnector;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class GymFlipFitApplication {
    static GymFlipFitGymOwnerMenu owner = new GymFlipFitGymOwnerMenu();
    static GymFlipFitCustomerMenu customer = new GymFlipFitCustomerMenu();
    static GymOwnerService gymOwnerService = new GymOwnerServiceOperation();

    static UserServices userService = new UserServiceOperations();
    static Scanner obj = new Scanner(System.in);

    static Properties prop = new Properties();
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit application for slot booking!");
        boolean exitFlag = false;
        while(true) {
            System.out.println("1. Login");
            System.out.println("2. Registration");
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
                            GymFlipFitAdminMenu admin = new GymFlipFitAdminMenu();

                            if(admin.verifyAdminCredentials(userId,password)){
                                System.out.println("Invalid Credentials");
                                break;
                            }

                            boolean flag = true;

                            while(flag) {

                                System.out.println("1. View all users");
                                System.out.println("2. View all Gyms");
                                System.out.println("3. View all Gym Owners");
                                System.out.println("4. Verify Gym");
                                System.out.println("5. Verify GymOwner");
                                System.out.println("6. View pending Gyms");
                                System.out.println("7. View pending Gym Owners");
                                System.out.println("8. Exit");

                                int k = Integer.parseInt(obj.nextLine());

                                switch (k) {
                                    case 1:
                                        admin.viewUsers();
                                        break;
                                    case 2:
                                        admin.viewGyms();
                                        break;
                                    case 3:
                                        admin.viewGymOwners();
                                        break;
                                    case 4:
                                        System.out.println("Enter the Gym Id to be verified ");
                                        int id1 = Integer.parseInt(obj.nextLine());
                                        admin.verifyGym(id1);
                                        break;
                                    case 5:
                                        System.out.println("Enter the Gym Owner Id to be verified ");
                                        int id2 = Integer.parseInt(obj.nextLine());
                                        admin.verifyGymOwner(id2);
                                        break;
                                    case 6:
                                        admin.viewUnverifiedGyms();
                                        break;
                                    case 7:
                                        admin.viewUnverifiedGymOwners();
                                        break;
                                    case 8:
                                        flag = false;
                                        break;
                                }
                                if(!flag) break;
                            }
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
                    System.out.println("1. Register as a Customer");
                    System.out.println("2. Register as a Gym Owner");
                    System.out.println("3. Back");
                    int k = Integer.parseInt(obj.nextLine());
                    switch(k){
                        case 1:
                            customer.createCustomer();
                            break;
                        case 2:
                            owner.createGymOwner();
                        default:
                            break;
                    }
                    break;
                case 3 :
                    System.out.println("-----------Password Change -----------------------");
                    System.out.println("Enter email");
                    String user = obj.nextLine();
                    System.out.println("Enter password");
                    String userPassword = obj.nextLine();
                    System.out.println("Enter role (Admin/Customer/GymOwner)");
                    String respectiveRole = obj.nextLine();
                    System.out.println("Enter New password");
                    String updatedPassword = obj.nextLine();

                    switch (respectiveRole) {
                        case "Customer" :
                            if(!customer.validateUser(user,userPassword))
                                System.out.println("Invalid credentials");
                            else{
                                userService.updateGymUserPassword(user,userPassword, updatedPassword);
                            }
                            break;
                        case "GymOwner" :
                            if(!owner.verifyGymOwner(user,userPassword)){
                                System.out.println("Invalid credentials");
                            }
                            else{
                                gymOwnerService.updateGymOwnerPassword(user,userPassword, updatedPassword);
                            }

                            break;
                    }
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

