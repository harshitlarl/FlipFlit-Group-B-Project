package com.flipkart.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Bookings class represents a booking made by a user.
 * It contains information such as booking ID, user ID, creation timestamp,
 * booking status, date, time, slot ID, gym ID, and status.
 *
 * @author Atulya
 * @author Avinash
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
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
}
