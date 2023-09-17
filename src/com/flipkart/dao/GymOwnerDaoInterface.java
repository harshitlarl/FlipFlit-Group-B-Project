package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.sql.SQLException;
import java.util.List;

public interface GymOwnerDaoInterface {
    void insertSlots(List<Slots> slots, int gymId);

    public List<Gym> viewGymSlots(String gymOwnerID);

    void addGym(Gym gym);

    void newGymOwner(GymOwner gymOwner);

    boolean validateLogin(String email, String password);
}
