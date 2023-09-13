/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Gym;

/**
 * @author bhavya.khandelwal
 */
public interface BookingService {
	Gym getGymWithBookingId(String bookingId);
}
