package com.flipkart.bean;

public class Admin {
	private int adminId;
	private String password;

	/**
	 * Get the Admin's ID.
	 * @return The adminId
	 * @author: Bhavya, Harshit
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * Set the Admin's ID.
	 * @param adminId The adminId to set
	 * @author: Bhavya, Harshit
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * Get the Admin's password.
	 * @return The password
	 * @author: Bhavya, Harshit
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the Admin's password.
	 * @param password The password to set
	 * @author: Bhavya, Harshit
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
