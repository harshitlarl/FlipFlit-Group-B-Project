package com.flipkart.dao;

import java.sql.SQLException;

public interface GymOwnerDaoInterface {
    public void viewGymSlots(String gymOwnerID) throws SQLException;
}
