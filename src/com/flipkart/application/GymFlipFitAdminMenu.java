package com.flipkart.application;


import com.flipkart.bean.GymOwner;

import java.util.ArrayList;

public class GymFlipFitAdminMenu {

    public ArrayList<Gym> verifiedGym(){
        // will return verified Gym
        System.out.println("Returning list of verified gyms");
        ArrayList<Gym> gymList = new ArrayList<Gym>();
        return gymList;
    }
    public ArrayList<GymOwner> verifiedGymOwner(){
        // will return verified GymOwner
        System.out.println("Returning list of verified gym owners");
        ArrayList<GymOwner> gymOwnersList = new ArrayList<GymOwner>();
        return gymOwnersList;
    }
    public ArrayList<Gym> verificationPendingGym(){
        // will return list of gyms yet to be verified
        System.out.println("Returning list of gyms for which verification is pending");
        ArrayList<Gym> gymList = new ArrayList<Gym>();
        return gymList;

    }
    public ArrayList<GymOwner> verificationPendingGymOwner(){
        // will return list of gym owners yet to be verified
        System.out.println("Returning list of gym owners for which verificiation is pending");
        ArrayList<GymOwner> gymOwnersList = new ArrayList<GymOwner>();
        return gymOwnersList;
    }
    public ArrayList<Gym> verificationFailedGym(){
        // will return gym with failed verificaiton
        System.out.println("Returning list of gyms for which verification has failed");
        ArrayList<Gym> gymList = new ArrayList<Gym>();
        return gymList;
    }
    public ArrayList<GymOwner> verificationFailedGymOwner(){
        // will return gymowner with failed verification
        System.out.println("Returning list of gym owners for which verification has failed");
        ArrayList<GymOwner> gymOwnersList = new ArrayList<GymOwner>();
        return gymOwnersList;
    }
    public void addGymToVerifiedList(Gym gym ){
        // add gym to database
        System.out.println("Adding gym to verified list");
    }
    public void addGymToVerificationFailedList(Gym gym ){
        // add gym to database
        System.out.println("Adding gym to failed verification list");
    }
    public void addGymOwnerToVerifiedList(GymOwner gymOwner){
        // add gym owner to database
        System.out.println("Adding gym owner to verified gym owner list");
    }
    public void addGymOwnerToVerificationFailedList(GymOwner gymOwner){
        // add gym owner to database
        System.out.println("Adding gym owner to verification failed list");
    }
    public boolean approveGymVerification(Gym gym){
        // if details are correct
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Gym information and details correct (Yes/No):");
        String isVerified = scanner.nextLine();

        if(isVerified.equals("Yes")){
            this.addGymToVerifiedList(gym);
            return true;
        }

        //else
        else{
            this.addGymToVerificationFailedList(gym);
            return false;
        }


    }
    public boolean approveGymOwnerVerification(GymOwner gymOwner){
        // if details are correct
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is Gym owner information and details correct (Yes/No):");
        String isVerified = scanner.nextLine();
        if(isVerified.equals("Yes")){
            this.addGymOwnerToVerifiedList(gymOwner);
            return true;
        }

        //else
        else{
            this.addGymOwnerToVerificationFailedList(gymOwner);
            return false;
        }

    }
    public boolean adminLogin(int adminId, String adminPassword){
        // We will look for admin
        boolean isVerifiedAdmin = true;

        if(isVerifiedAdmin){
            System.out.println("Credentials are verified");

            Scanner scanner = new Scanner(System.in);
            int caseNum = scanner.nextInt("1. Pending Gym verification list(1)" +
                    "2. Pending Gym owner verification list(2)" +
                    "3. Verified Gym list(3)" +
                    "4. Verified Gym owner list(4)" +
                    "5. Verification failed gym list(5)" +
                    "6. Verification failed gym owner list(6)" +

                    "Select one option from the menu: \n " );

            switch (caseNum){
                case 1:
                    System.out.println(verificationPendingGym());
                    break;
                case 2:
                    System.out.println(verificationPendingGymOwner());
                    break;
                case 3:
                    System.out.println(verifiedGym());
                    break;
                case 4:
                    System.out.println(verifiedGymOwner());
                    break;
                case 5:
                    System.out.println(verificationFailedGym());
                    break;
                case 6:
                    System.out.println(verificationFailedGymOwner());
                    break;
            }

            return true;
        }

        return false;
    }
}