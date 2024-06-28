/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Booking;

/**
 * 
 */
public interface FlipfitGymBookingDAOInterface {
	public void  addBooking(String userName, String date);
	public List<Booking> viewBookingByCustomerId(String customerId);
	public void cancelBookingById(String bookingID);
}
