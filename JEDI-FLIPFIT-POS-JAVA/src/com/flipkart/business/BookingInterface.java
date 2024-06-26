/**
 * 
 */
package com.flipkart.business;

import java.sql.Date;

/**
 * 
 */
public interface BookingInterface {
	
	public boolean checkBooking(String customerId, Date date, String slotId);
    public void addBooking(String userName, Date date ) ;
    public void getBookingByCustomerId(String customerId);
    public void cancelBooking(String bookingID);
	
}
