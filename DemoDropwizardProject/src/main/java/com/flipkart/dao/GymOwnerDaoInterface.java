package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.sql.SQLException;
import java.util.List;

public interface GymOwnerDaoInterface {
    /**
     * Insert slots for a gym.
     *
     * @param slots - List of slots to be inserted
     * @param gymId - The ID of the gym where slots are to be inserted
     * @author: Harshit, Avinash
     */
    void insertSlots(List<Slots> slots, int gymId);

    /**
     * View gym slots for a gym owner.
     *
     * @param gymOwnerID - The ID of the gym owner
     * @return List of gym slots
     * @author: Harshit, Avinash
     */
    public List<Gym> viewGymSlots(String gymOwnerID);

    /**
     * Add a new gym.
     *
     * @param gym - The gym object to be added
     * @author: Harshit, Avinash
     */
    void addGym(Gym gym);

    /**
     * Add a new gym owner.
     *
     * @param gymOwner - The gym owner object to be added
     * @author: Harshit, Avinash
     */
    void newGymOwner(GymOwner gymOwner);

    /**
     * Validate login credentials for a gym owner.
     *
     * @param email - The email of the gym owner
     * @param password - The password of the gym owner
     * @return True if login is valid, false otherwise
     * @author: Harshit, Avinash
     */
    boolean validateLogin(String email, String password);
}
