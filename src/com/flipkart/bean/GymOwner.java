package com.flipkart.bean;

import java.util.List;

public class GymOwner {
	private int ownerId;
	private String ownerEmail;
	private String password;
	private String phoneNo;
	private String nationalId;
	private String GST;
	private List<Gym> gyms;

	public List<Gym> getGyms() {
		return gyms;
	}

	public void setGyms(List<Gym> gyms) {
		this.gyms = gyms;
	}

	private String verificationStatus;
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getVerificationStatus() {
		return verificationStatus;
	}
	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	public String getGST() { return GST; }
	public void setGST(String GST) { this.GST = GST; }

}