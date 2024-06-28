/**
 * 
 */
package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.CustomerBusiness;
import com.flipkart.business.GymOwnerBusiness;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.client.GymFlipFitApplication.scanner;

/**
 * 
 */
public class FlipfitGymCustomerMenu {
	private CustomerBusiness customerBusiness = new CustomerBusiness();

	public void loginGymCustomer(String email, String password){
		int userId = customerBusiness.validateGymCustomer(email,password);
		if (userId > 0) {
			System.out.println("Successfully Logged In");
			flipfitGymCustomerMainMenu(email, userId);
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

	private void viewCustomerProfile(int userId) {
		Customer customer = customerBusiness.getCustomerProfile(userId);
		customer.printProfile();
	}

	private static void bookFlipfitGymSlot() {
		System.out.println("booking Flipfit Gym Slot...");
	}

	private static void viewAllBookings() {
		System.out.println("Viewing all bookings...");
	}

	private static void cancleBooking() {
		System.out.println("Cancle Booking...");
	}

	public void flipfitGymCustomerMainMenu(String email, int userId) {

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentTime.format(myFormat);
		System.out.println("\nWELCOME " + email + "!! " + formattedDate + "\nWhat do you want to do??");
		while (true) {
			System.out.println("1. View My Profile\n" + "2. Book a slot in a Gym\n" + "3. View Bookings\n"
					+ "4. Cancel Bookings\n" + "5. Go Back to previous menu");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				viewCustomerProfile(userId);
				break;
			case 2:
				bookFlipfitGymSlot();
				break;
			case 3:
				viewAllBookings();
				break;
			case 4:
				cancleBooking();
				break;
			case 5:
				System.out.println("\\nGOING BACK TO PREVIOUS MENU\\n");
				return;
			default:
				System.out.println("PLEASE CHOOSE A VALID OPTION");
				break;
			}
		}
	}
}
