package com.flipkart.bean;

/**
 * This class represents a User in the GymFlipFit application.
 * It stores user information such as user ID, name, contact details, address, location, email, and password.
 */
public class User {
	private int userId; // Unique identifier for the user

	private String userName; // User's name
	private String phoneNumber; // User's phone number
	private String address; // User's address
	private String location; // User's location
	private String email; // User's email address
	private String password; // User's password

	/**
	 * Get the user ID.
	 * @author atulya.kumar
	 * @return The user ID.
	 */
	public int getuserId() {
		return userId;
	}

	/**
	 * Set the user ID.
	 * @author atulya.kumar
	 * @param userId The user ID to set.
	 */
	public void setuserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get the user's name.
	 * @author atulya.kumar
	 * @return The user's name.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Set the user's name.
	 * @author atulya.kumar
	 * @param userName The user's name to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get the user's email address.
	 * @author atulya.kumar
	 * @return The user's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the user's email address.
	 * @author bhavya.khandelwal
	 * @param email The user's email address to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the user's phone number.
	 * @author bhavya.khandelwal
	 * @return The user's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the user's phone number.
	 * @author bhavya.khandelwal
	 * @param phoneNumber The user's phone number to set.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Get the user's address.
	 * @author bhavya.khandelwal
	 * @return The user's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the user's address.
	 * @author bhavya.khandelwal
	 * @param address The user's address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the user's location.
	 * @author shikha.rai
	 * @return The user's location.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Set the user's location.
	 * @author shikha.rai
	 * @param location The user's location to set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Get the user's password.
	 *
	 * @return The user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the user's password.
	 * @author shikha.rai
	 * @param password The user's password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
