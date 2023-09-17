package com.flipkart.constants;

import java.security.PublicKey;

public class SQLConstants {
    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
    public static final String GYM_OWNER_VIEW_GYM = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE gym_owner SET password = ? WHERE email = ? AND Password = ?";
    public static final String GYM_OWNER_UPDATE_PASSWORD = "INSERT INTO gyms (gymAddress,location,gymName,status,ownerId ) VALUES(?,?,?,?,?)";
    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * from  gym_owner WHERE email = ? AND Password = ?";
    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * from  gym_owner WHERE email = ? AND Password = ?";

    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";
    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM gyms";
    public static final String ADMIN_VIEW_ALL_GYMOWNERS = "SELECT * FROM gym_owner";
    public static final String ADMIN_VERIFY_GYMS = "UPDATE gyms set status = ? where gymId = ?";
    public static final String ADMIN_VERIFY_GYMOWNERS = "UPDATE gym_owner set status = ? where id = ?";
    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM gyms WHERE status=?";
    public static final String ADMIN_VIEW_UNVERIFIED_GYMOWNER = "SELECT * FROM gym_owner WHERE status=?";
    public static final String GYM_OWNER_INSERT = "INSERT INTO gym_owner (email,name, password, phone_number, pancard, aadhar, gst,status) VALUES(?,?,?,?,?,?,?,?)";
}
