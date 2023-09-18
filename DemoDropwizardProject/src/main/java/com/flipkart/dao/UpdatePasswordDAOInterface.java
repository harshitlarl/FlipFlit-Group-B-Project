package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface UpdatePasswordDAOInterface {
    /**
     * Update the password of a gym owner.
     *
     * @param email           - The email of the gym owner
     * @param password        - The current password of the gym owner
     * @param updatedPassword - The new password to set
     * @author: Harshit, Avinash
     */
    public void updateGymOwnerPassword(String email, String password, String updatedPassword);

    /**
     * Update the password of a gym user.
     *
     * @param email           - The email of the gym user
     * @param password        - The current password of the gym user
     * @param updatedPassword - The new password to set
     * @author: Harshit, Avinash
     */
    public void updateGymUserPassword(String email, String password, String updatedPassword);

    /**
     * Verify the password of a gym owner.
     *
     * @param email    - The email of the gym owner
     * @param password - The password to verify
     * @return true if the password is verified, false otherwise
     * @author: Harshit, Avinash
     */
    public boolean verifyGymOwnerPassword(String email, String password);

    /**
     * Verify the password of a gym user.
     *
     * @param email    - The email of the gym user
     * @param password - The password to verify
     * @return true if the password is verified, false otherwise
     * @author: Harshit, Avinash
     */
    public boolean verifyGymUserPassword(String email, String password);
}
