package com.flipkart.bean;

public class Bookings {
	private int bookingId;
	private int userId;
	private int createdAt;
	private int bookingStatus;
	
//	public Booking(int bookingId, int userId, int createdAt, int bookingStatus) {
//		super();
//		this.bookingId = bookingId;
//		this.userId = userId;
//		this.createdAt = createdAt;
//		this.bookingStatus = bookingStatus;
//	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}
	public int getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	
}