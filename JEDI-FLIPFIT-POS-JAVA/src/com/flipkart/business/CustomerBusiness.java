/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Schedule;
import com.flipkart.dao.FlipfitCustomerDAOImpl;
import com.flipkart.dao.FlipfitGymBookingDAOImpl;
import com.flipkart.dao.FlipfitGymCenterDAOImpl;
import com.flipkart.dao.FlipfitGymOwnerDAOImpl;
import com.flipkart.utils.GymCenterUtils;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

/**
 * 
 */
public class CustomerBusiness implements CustomerInterface{
	private FlipfitCustomerDAOImpl customerDAO = new FlipfitCustomerDAOImpl();
	private FlipfitGymCenterDAOImpl gymCenterDAO = new FlipfitGymCenterDAOImpl();
	private FlipfitGymBookingDAOImpl bookingDAO = new FlipfitGymBookingDAOImpl();

	public int validateGymCustomer(String emailId, String password){
		int userId = customerDAO.isValidGymCustomer(emailId, password);
		return (userId!=-1 ? customerDAO.getCustomerId(userId) : -1);
	}

	public Customer getCustomerProfile(int userId){
		return customerDAO.getCustomerByCustomerId(userId);
	}

	public boolean createCustomer(Customer customer) {
		return customerDAO.createCustomer(customer);
	}

	public void viewAllGym(){
		GymCenterUtils.printGymCenterList(gymCenterDAO.viewAllGym());
	}

	public void viewAllSlotByGymCenterId(int gymCenterId){
		GymCenterUtils.printGymCenterSlotList(gymCenterDAO.getAllSlotByGymCenterId(gymCenterId));
	}

//	public boolean checkForAvailablity(int scheduleId){
//		if(scheduleId==-1) return false;
////		return (bookingDAO.getAvailableSeats(scheduleId) > 0);
//		return true;
//	}

	public boolean bookSlot(Schedule schedule, int customerId){
		if(!bookingDAO.checkSchedule(schedule)){
			int capacity = gymCenterDAO.getGymCapacity(schedule.getGymCenterId());
			if(capacity < 0) return false;
			bookingDAO.createSchedule(schedule, capacity);
		}

//		int scheduleId = bookingDAO.getScheduleId(schedule);
//
//		if(!checkForAvailablity(scheduleId)) {
//			return false;
//		}
//		bookingDAO.decrementeAvailableSeat(scheduleId);
//		Booking booking = new Booking();
//		booking.setCustomerId(customerId);
//		booking.setScheduleId(scheduleId);
//		bookingDAO.createBooking();
		return true;
	}

	public boolean updateCustomer(int customerId) {
		System.out.println("Customer Updated ==> " + customerId);
		return true;
	}

	public boolean deleteCustomer(int customerId) {
		System.out.println("Customer Deleted ==> " + customerId);
		return true;
	}

	public void listCustomer() {
		System.out.println("Get all Customer List");
	}
}
