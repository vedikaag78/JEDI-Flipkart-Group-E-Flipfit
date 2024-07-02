/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Schedule;
import com.flipkart.business.CustomerBusiness;
import com.flipkart.business.GymOwnerBusiness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.client.GymFlipFitApplication.scanner;

/**
 * 
 */
public class FlipfitGymCustomerMenu {
	private CustomerBusiness customerBusiness = new CustomerBusiness();

	public void loginGymCustomer(String email, String password){
		int customerId = customerBusiness.validateGymCustomer(email,password);
		if (customerId > 0) {
			System.out.println("Successfully Logged In");
			flipfitGymCustomerMainMenu(email, customerId);
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	public boolean registerCustomer(){
		Customer customer = new Customer();
		System.out.print("Enter your email: ");
		customer.setEmailId(scanner.next());

		System.out.print("Enter your password: ");
		customer.setPassword(scanner.next());

		System.out.print("Enter your Name: ");
		customer.setCustomerName(scanner.next());

		System.out.print("Enter your Address: ");
		customer.setCustomerAddress(scanner.next());

		System.out.print("Enter your Gender: ");
		customer.setGender(scanner.next());

		System.out.print("Enter your Age: ");
		customer.setAge(scanner.nextInt());

		System.out.print("Enter your contact number: ");
		customer.setContactNumber(scanner.next());

		System.out.print("Enter your Card Details: ");
		customer.setCardDetails(scanner.next());

		return customerBusiness.createCustomer(customer);
	}

	private void viewCustomerProfile(int customerId) {
		Customer customer = customerBusiness.getCustomerProfile(customerId);
		customer.printProfile();
	}

	private void bookFlipfitGymSlot(int customerId) {
		customerBusiness.viewAllGym();
		Schedule schedule = new Schedule();
		System.out.print("Select a center Id to book a slot: ");
		schedule.setGymCenterId(scanner.nextInt());
		if(!customerBusiness.viewAllSlotByGymCenterId(schedule.getGymCenterId()))
			return;
		System.out.println("Select a slot Id: ");
		schedule.setSlotId(scanner.nextInt());
		schedule.setScheduleDate(LocalDate.now());
		if(customerBusiness.bookSlot(schedule, customerId))
			System.out.println("Booking Successful");
		else System.out.println("Booking Failed");
		System.out.println("--------------------------------------------");
	}

	private void viewAllBookings(int customerId) {
		customerBusiness.viewAllBookings(customerId);
	}

	public void flipfitGymCustomerMainMenu(String email, int customerId) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentTime.format(myFormat);
		while (true) {
			System.out.println("--------------------------------------------");
			System.out.println("WELCOME Customer - " + email + "!! " + formattedDate);
			System.out.println("What do you want to do?");
			System.out.println("""
						1. View My Profile
						2. Book a slot in a Gym
						3. View Booking
						4. Go Back to previous menu
					--------------------------------------------""");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				viewCustomerProfile(customerId);
				break;
			case 2:
				bookFlipfitGymSlot(customerId);
				break;
			case 3:
				viewAllBookings(customerId);
				break;
			case 4:
				return;
			default:
				System.out.println("PLEASE CHOOSE A VALID OPTION");
				break;
			}
		}
	}
}
