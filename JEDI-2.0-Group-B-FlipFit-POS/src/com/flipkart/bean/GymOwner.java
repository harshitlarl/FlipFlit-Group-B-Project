package com.flipkart.bean;

import java.util.List;

public class GymOwner {
	private int ownerId; // Unique identifier for the gym owner
	private String ownerEmail; // Email address of the gym owner
	private String password; // Password for the gym owner's account
	private String phoneNo; // Phone number of the gym owner
	private String nationalId; // National ID of the gym owner
	private String GST; // GST (Goods and Services Tax) number of the gym owner
	private List<Gym> gyms; // List of gyms owned by the gym owner
	private String PAN; // PAN (Permanent Account Number) of the gym owner
	private String ownerName; // Name of the gym owner
	private String status; // Current status of the gym owner
	private String verificationStatus; // Verification status of the gym owner

	/**
	 * Get the unique identifier of the gym owner.
	 * @return The gym owner's unique identifier
	 * @author: Atulya, Avinash
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * Set the unique identifier of the gym owner.
	 * @param ownerId - The gym owner's unique identifier
	 * @author: Atulya, Avinash
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Get the email address of the gym owner.
	 * @return The gym owner's email address
	 * @author: Atulya, Avinash
	 */
	public String getOwnerEmail() {
		return ownerEmail;
	}

	/**
	 * Set the email address of the gym owner.
	 * @param ownerEmail - The gym owner's email address
	 * @author: Atulya, Avinash
	 */
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	/**
	 * Get the password of the gym owner's account.
	 * @return The gym owner's password
	 * @author: Atulya, Avinash
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the gym owner's account.
	 * @param password - The gym owner's password
	 * @author: Atulya, Avinash
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the phone number of the gym owner.
	 * @return The gym owner's phone number
	 * @author: Atulya, Avinash
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Set the phone number of the gym owner.
	 * @param phoneNo - The gym owner's phone number
	 * @author: Atulya, Avinash
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Get the national ID of the gym owner.
	 * @return The gym owner's national ID
	 * @author: Atulya, Avinash
	 */
	public String getNationalId() {
		return nationalId;
	}

	/**
	 * Set the national ID of the gym owner.
	 * @param nationalId - The gym owner's national ID
	 * @author: Atulya, Avinash
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	/**
	 * Get the GST (Goods and Services Tax) number of the gym owner.
	 * @return The gym owner's GST number
	 * @author: Atulya, Avinash
	 */
	public String getGST() {
		return GST;
	}

	/**
	 * Set the GST (Goods and Services Tax) number of the gym owner.
	 * @param GST - The gym owner's GST number
	 * @author: Atulya, Avinash
	 */
	public void setGST(String GST) {
		this.GST = GST;
	}

	/**
	 * Get the list of gyms owned by the gym owner.
	 * @return The list of gyms owned by the gym owner
	 * @author: Atulya, Avinash
	 */
	public List<Gym> getGyms() {
		return gyms;
	}

	/**
	 * Set the list of gyms owned by the gym owner.
	 * @param gyms - The list of gyms owned by the gym owner
	 * @author: Atulya, Avinash
	 */
	public void setGyms(List<Gym> gyms) {
		this.gyms = gyms;
	}

	/**
	 * Get the PAN (Permanent Account Number) of the gym owner.
	 * @return The gym owner's PAN number
	 * @author: Atulya, Avinash
	 */
	public String getPAN() {
		return PAN;
	}

	/**
	 * Set the PAN (Permanent Account Number) of the gym owner.
	 * @param PAN - The gym owner's PAN number
	 * @author: Atulya, Avinash
	 */
	public void setPAN(String PAN) {
		this.PAN = PAN;
	}

	/**
	 * Get the name of the gym owner.
	 * @return The gym owner's name
	 * @author: Atulya, Avinash
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Set the name of the gym owner.
	 * @param ownerName - The gym owner's name
	 * @author: Atulya, Avinash
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * Get the current status of the gym owner.
	 * @return The gym owner's current status
	 * @author: Atulya, Avinash
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the current status of the gym owner.
	 * @param status - The gym owner's current status
	 * @author: Atulya, Avinash
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the verification status of the gym owner.
	 * @return The gym owner's verification status
	 * @author: Atulya, Avinash
	 */
	public String getVerificationStatus() {
		return verificationStatus;
	}

	/**
	 * Set the verification status of the gym owner.
	 * @param verificationStatus - The gym owner's verification status
	 * @author: Atulya, Avinash
	 */
	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
}
