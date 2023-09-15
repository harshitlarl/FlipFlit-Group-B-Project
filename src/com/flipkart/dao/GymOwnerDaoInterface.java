package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;

import java.sql.SQLException;
import java.util.List;

public interface GymOwnerDaoInterface {
    void insertSlots(List<Slots> slots, int gymId);

    public void viewGymSlots(String gymOwnerID) throws SQLException;

    void addGym(Gym gym);
}
