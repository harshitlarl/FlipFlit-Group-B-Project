package com.flipkart.bean;


/**
 * The Bookings class represents a booking made by a user.
 * It contains information such as booking ID, user ID, creation timestamp,
 * booking status, date, time, slot ID, gym ID, and status.
 *
 * @author Atulya
 * @author Avinash
 */

public class Bookings {
	private int bookingId;
	private int userId;
	private int createdAt;
	private int bookingStatus;
	private int date;
	private int time;
	private int slotId;
	private int gymId;
	private String status;


	/**
	 * Get the date of the booking.
	 *
	 * @return The date of the booking.
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Set the date of the booking.
	 *
	 * @param date The date to set for the booking.
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * Get the slot identifier of the booking.
	 *
	 * @return The slot identifier of the booking.
	 */
	public int getSlotId() {
		return slotId;
	}

	/**
	 * Set the slot identifier of the booking.
	 *
	 * @param slotId The slot identifier to set for the booking.
	 */
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	/**
	 * Get the gym identifier of the booking.
	 *
	 * @return The gym identifier of the booking.
	 */
	public int getGymId() {
		return gymId;
	}

	/**
	 * Set the gym identifier of the booking.
	 *
	 * @param gymId The gym identifier to set for the booking.
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	/**
	 * Get the booking status.
	 *
	 * @return The booking status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the booking status.
	 *
	 * @param status The status to set for the booking.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the time of the booking.
	 *
	 * @return The time of the booking.
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Set the time of the booking.
	 *
	 * @param time The time to set for the booking.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Get the booking identifier.
	 *
	 * @return The booking identifier.
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Set the booking identifier.
	 *
	 * @param bookingId The booking identifier to set.
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * Get the user identifier associated with the booking.
	 *
	 * @return The user identifier.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Set the user identifier associated with the booking.
	 *
	 * @param userId The user identifier to set.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get the timestamp when the booking was created.
	 *
	 * @return The timestamp when the booking was created.
	 */
	public int getCreatedAt() {
		return createdAt;
	}

	/**
	 * Set the timestamp when the booking was created.
	 *
	 * @param createdAt The timestamp to set for when the booking was created.
	 */
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Get the booking status code.
	 *
	 * @return The booking status code.
	 */
	public int getBookingStatus() {
		return bookingStatus;
	}

	/**
	 * Set the booking status code.
	 *
	 * @param bookingStatus The status code to set for the booking.
	 */
	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
