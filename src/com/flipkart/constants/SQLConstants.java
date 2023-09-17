package com.flipkart.constants;

public class SQLConstants {
    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
    public static final String GYM_OWNER_VIEW_GYM = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE gym_owner SET password = ? WHERE email = ? AND Password = ?";
    public static final String GYM_OWNER_UPDATE_PASSWORD = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * from  gym_owner WHERE email = ? AND Password = ?";
    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * from  gym_owner WHERE email = ? AND Password = ?";

    public static final String GYM_OWNER_INSERT = "INSERT INTO gym_owner (email,name, password, phone_number, pancard, aadhar, gst,status) VALUES(?,?,?,?,?,?,?,?)";
}
