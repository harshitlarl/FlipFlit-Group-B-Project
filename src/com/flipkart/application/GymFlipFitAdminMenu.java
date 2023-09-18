package com.flipkart.application;


import com.flipkart.bean.Admin;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceOperation;
import com.flipkart.utils.DatabaseConnector;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import java.util.ArrayList;

public class GymFlipFitAdminMenu {

    AdminService adminService = new AdminServiceOperation();

    public void viewGyms() {
        adminService.viewGyms();
    }
    public void viewUsers() {
        adminService.viewUsers();
    }

    public void viewGymOwners() {
        adminService.viewGymOwners();
    }

    public void verifyGym(int id) {
        adminService.verifyGym(id);
    }
    public void verifyGymOwner(int id) {
        adminService.verifyGymOwner(id);
    }
    public void viewUnverifiedGyms() {
        List<Gym>gyms = adminService.getUnverifiedGyms();
        int x = 1;
        for(Gym g : gyms) {
            System.out.println("Gym " + x + ": Name " + g.getGymName()+ "   Gym Id:  "+ g.getGymId() + "     Address: " + g.getGymAddress() + "     Location: " + g.getLocation()  + "     Status:   "+ g.getStatus() );
            x++;
            System.out.println("\n-------------------------------------------------------------");
        }

    }

    public void viewUnverifiedGymOwners() {
        List<GymOwner>g = adminService.getUnverifiedGymOwners();
        int x = 1;
        for(GymOwner gymOwner : g) {
            System.out.println("GymOwner " + x + "-->   Gym Owner Id " + gymOwner.getOwnerId() + "    Email: " + gymOwner.getOwnerEmail() + "    Phone No: " + gymOwner.getPhoneNo() + "   Status:"+ gymOwner.getStatus());
            x++;
            System.out.println("\n-------------------------------------------------------------");
        }
    }

    public boolean verifyAdminCredentials(String id, String pass) {
        try {
            Properties prop = new Properties(); //Properties is used to read files
            InputStream inputStream = DatabaseConnector.class.getClassLoader().getResourceAsStream("./config.properties");
            prop.load(inputStream);
            String admin_id = prop.getProperty("admin_id");
            String admin_password = prop.getProperty("admin_password");

            return (id == admin_id && admin_password == pass );
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
