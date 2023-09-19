package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

/**
 *
 */
public interface AdminService {

    //public void createAdmin();
    /**
     * @author shikha.rai1
     * This function lists all the Gym Owners
     */
    public List<GymOwner> viewGymOwners();
    /**
     * @author shikha.rai1
     * This function lists all the Gyms
     */
    public List<Gym> viewGyms();

    /**
     * @author shikha.rai1
     * This function all the Users
     */
    public List<User> viewUsers();

    /**
     * @author shikha.rai1
     * This function verifies the Gym with given gymId
     * @param gymId
     */
    public String verifyGym(int gymId);

    /**
     * @author shikha.rai1
     * This method verifies the Gym Owner with given GymOwnerId
     * @param gymOwnerId
     */
    public String verifyGymOwner(int gymOwnerId);

    /**
     * @author shikha.rai1
     * This function fetches the list of Un-verified Gym Owners
     * @return List<GymOwner>
     */
    public List<GymOwner> getUnverifiedGymOwners() ;

    /**
     * @author shikha.rai1
     * This function fetches the list of Un-verified Gyms
     * @return List<Gym>
     */
    public List<Gym> getUnverifiedGyms() ;

}
