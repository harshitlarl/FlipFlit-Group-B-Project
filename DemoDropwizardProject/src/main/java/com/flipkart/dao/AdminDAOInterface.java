package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAOInterface {
    /**
     * Admin Can View All the Gyms
     * @author: Harshit, Shikha
     */
    public void viewGyms();

    /**
     * Admin Can View All the Users
     * @author: Harshit, Shikha
     */
    public void viewUsers();

    /**
     * Admin Can View All the Gym Owners
     * @author: Harshit, Shikha
     */
    public List<GymOwner> viewGymOwners();

    /**
     * Admin Can Verify the Gym Owners and change their Status Like Verified Profile
     * @author: Harshit, Shikha
     * @param id - The ID of the gym owner to be verified
     */
    public void verifyGymOwners(int id);

    /**
     * Admin Can Verify the Gyms and change their Status Like Verified Profile
     * @param id - The ID of the gym to be verified
     */
    public void verifyGyms(int id);

    /**
     * Get a list of unverified gyms
     * @return List of unverified gyms
     */
    public List<Gym> getUnverifiedGyms();

    /**
     * Get a list of unverified gym owners
     * @return List of unverified gym owners
     */
    public List<GymOwner> getUnverifiedGymOwner();
}
