/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Gym;

/**
 * @author bhavya.khandelwal
 */
public interface BookingService {

	/**
	 * This function returns a Gym with given bookingId
	 * @param bookingId
	 * @return
	 * @author bhavya.khandelwal, avinash, atulya
	 */
	Gym getGymWithBookingId(String bookingId);
}
