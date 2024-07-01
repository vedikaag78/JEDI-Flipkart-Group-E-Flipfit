/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.dao.FlipfitCustomerDAOImpl;
import com.flipkart.dao.FlipfitGymBookingDAOImpl;
import com.flipkart.dao.FlipfitGymCenterDAOImpl;
import com.flipkart.utils.GymCenterUtils;

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

	public boolean viewAllSlotByGymCenterId(int gymCenterId){
		List<Slot> slotList = gymCenterDAO.getAllSlotByGymCenterId(gymCenterId);
		GymCenterUtils.printGymCenterSlotList(slotList);
		return (slotList.size()>0);
	}

	public boolean bookSlot(Schedule schedule, int customerId){
		if(!bookingDAO.checkSchedule(schedule)){
			int capacity = gymCenterDAO.getGymCapacity(schedule.getGymCenterId());
			if(capacity < 0) return false;
			bookingDAO.createSchedule(schedule, capacity);
		}

		int scheduleId = bookingDAO.getScheduleId(schedule);
		System.out.println(scheduleId);
		if(scheduleId == -1 || !bookingDAO.decrementAvailableSeat(scheduleId)) return false;

		Booking booking = new Booking();
		booking.setCustomerId(customerId);
		booking.setScheduleId(scheduleId);
		return bookingDAO.createBooking(booking);
	}

	public void viewAllBookings(int customerId){
		List<Booking> bookingList = bookingDAO.getAllBookingsByCustomerId(customerId);
		System.out.println("--------------------------------------------");
		System.out.println("Booking History: ");
		int i = 1;
		for(Booking booking:bookingList){
			Schedule schedule = bookingDAO.getBookingSchedule(booking);
			Slot slot = bookingDAO.getBookingSlot(schedule);
			System.out.println(i + ". " + "Date: " + schedule.getScheduleDate() +
					"\t\tbookingId: " + booking.getBookingId() +
					"\t\tslot date: " + schedule.getScheduleDate() +
					"\t\tstart time: " + slot.getStartTime() +
					"\t\tend time: " + slot.getEndTime() +
					"\t\tcenterId: " + schedule.getGymCenterId());
		}
		System.out.println("--------------------------------------------");
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
