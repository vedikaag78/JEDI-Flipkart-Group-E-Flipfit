/**
 * 
 */
package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.client.GymFlipFitApplication.scanner;

/**
 * 
 */
public class FlipfitGymCustomerMenu {

	private static void viewCustomerProfile() {
		System.out.println("Viewing Customer Profile...");
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

	public static void flipfitGymCustomerMainMenu(String userId) {

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentTime.format(myFormat);
		System.out.println("\nWELCOME " + userId + "!! " + formattedDate + "\nWhat do you want to do??");
		while (true) {
			System.out.println("1. View My Profile\n" + "2. Book a slot in a Gym\n" + "3. View Bookings\n"
					+ "4. Cancel Bookings\n" + "5. Go Back to previous menu");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				viewCustomerProfile();
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
