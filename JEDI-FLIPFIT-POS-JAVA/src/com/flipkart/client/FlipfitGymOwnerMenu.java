package com.flipkart.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.client.GymFlipFitApplication.scanner;

public class FlipfitGymOwnerMenu {
	public static void FlipfitGymOwnerMainPage(String gymOwnerId) {

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentTime.format(myFormat);
		System.out.println("WELCOME " + gymOwnerId + "!! " + formattedDate + "\nWhat do you want to do");

		while (true) {
			System.out.println("" + "1. View all my Gym Centres\n" + "2. Sending Gym Owner Approval Request\n"
					+ "3. Add a new Gym Center\n" + "4. Add Slots to a Gym Centre\n" + "5. Go Back to Previous Menu");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Viewing All Gym Centers...");
				break;
			case 2:
				System.out.println("Requesting Gym Owner Approval...");
				// add gymCenter by creating a new object using about data
				break;

			case 3:
				System.out.println("Enter gym centre id: ");
				String gymId = scanner.next();

				System.out.println("Enter Gym Centre name: ");
				String gymCentreName = scanner.next();

				System.out.println("Enter Gym Centre GSTIN: ");
				String gstin = scanner.next();

				System.out.println("Enter Gym Centre city: ");
				String city = scanner.next();

				System.out.println("Enter Gym Centre capacity: ");
				int capacity = scanner.nextInt();

				System.out.println("Enter price: ");
				int price = scanner.nextInt();
				break;

			case 4:
				System.out.println("Adding Slots to a Gym Center");
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