package com.flipkart.bean;

/**
 * This class represents a time slot for gym bookings in the GymFlipFit application.
 * It stores information about the slot ID, start time, and available seat count.
 */
public class Slots {

	private int slotsId; // Unique identifier for the slot
	private int startTime; // Start time of the slot
	private int seatCount; // Number of available seats in the slot

	/**
	 * Constructor to create a Slots object with the specified attributes.
	 *
	 * @param slotsId   The unique identifier for the slot.
	 * @param startTime The start time of the slot.
	 * @param seatCount The number of available seats in the slot.
	 */
	public Slots(int slotsId, int startTime, int seatCount) {
		this.setSlotsId(slotsId);
		this.setStartTime(startTime);
		this.setSeatCount(seatCount);
	}

	/**
	 * Get the slot ID.
	 * @author bhavya.khandelwal
	 * @return The slot ID.
	 */
	public int getSlotsId() {
		return slotsId;
	}

	/**
	 * Set the slot ID.
	 * @author bhavya.khandelwal
	 * @param slotsId The slot ID to set.
	 */
	public void setSlotsId(int slotsId) {
		this.slotsId = slotsId;
	}

	/**
	 * Get the start time of the slot.
	 * @author bhavya.khandelwal
	 * @return The start time of the slot.
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Set the start time of the slot.
	 * @author bhavya.khandelwal
	 * @param startTime The start time of the slot to set.
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * Get the number of available seats in the slot.
	 * @author avinash
	 * @return The number of available seats in the slot.
	 */
	public int getSeatCount() {
		return seatCount;
	}

	/**
	 * Set the number of available seats in the slot.
	 * @author avinash
	 * @param seatCount The number of available seats in the slot to set.
	 */
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
}
