package com.flipkart.bean;

import java.util.List;

/**
 * Represents a gym facility with various attributes.
 * @author Atulya, Avinash
 */
public class Gym {

	private int gymId;
	private String gymName;
	private String gymAddress;
	private String location;
	private List<Slots> slots;
	private String ownerId;
	private String Status;

	/**
	 * Get the owner ID of the gym.
	 * @return The owner ID
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * Set the owner ID of the gym.
	 * @param ownerId - The owner ID to set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Get the status of the gym.
	 * @return The gym status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * Set the status of the gym.
	 * @param status - The gym status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * Get the list of slots available at the gym.
	 * @return The list of gym slots
	 */
	public List<Slots> getSlots() {
		return slots;
	}

	/**
	 * Set the list of slots available at the gym.
	 * @param slots - The list of gym slots to set
	 */
	public void setSlots(List<Slots> slots) {
		this.slots = slots;
	}

	/**
	 * Get the ID of the gym.
	 * @return The gym ID
	 */
	public int getGymId() {
		return gymId;
	}

	/**
	 * Set the ID of the gym.
	 * @param gymId - The gym ID to set
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	/**
	 * Get the name of the gym.
	 * @return The gym name
	 */
	public String getGymName() {
		return gymName;
	}

	/**
	 * Set the name of the gym.
	 * @param gymName - The gym name to set
	 */
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	/**
	 * Get the address of the gym.
	 * @return The gym address
	 */
	public String getGymAddress() {
		return gymAddress;
	}

	/**
	 * Set the address of the gym.
	 * @param gymAddress - The gym address to set
	 */
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}

	/**
	 * Get the location of the gym.
	 * @return The gym location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Set the location of the gym.
	 * @param location - The gym location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
