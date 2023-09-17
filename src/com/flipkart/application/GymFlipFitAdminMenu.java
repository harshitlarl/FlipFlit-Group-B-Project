package com.flipkart.application;


import com.flipkart.bean.Admin;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceOperation;

import java.util.List;
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
            System.out.println("Gym " + x + ": Name " + g.getGymName() + " Address: " + g.getGymAddress() + " Location: " + g.getLocation() );
            x++;
        }
    }

    public void viewUnverifiedGymOwners() {
        List<GymOwner>g = adminService.getUnverifiedGymOwners();
        int x = 1;
        for(GymOwner gymOwner : g) {
            System.out.println("GymOwner " + x + ": Id " + gymOwner.getOwnerId() + " Email: " + gymOwner.getOwnerEmail() + " Phone No: " + gymOwner.getPhoneNo());
            x++;
        }
    }
}
