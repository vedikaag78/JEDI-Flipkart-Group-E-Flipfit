package com.flipkart.client;

import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.GymOwnerBusiness;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.client.GymFlipFitApplication.scanner;

public class FlipfitGymOwnerMenu {
	private GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();

	public void loginGymOwner(String email, String password){
		if (gymOwnerBusiness.validateGymOwner(email,password)) {
			System.out.println("Successfully logged in");
			FlipfitGymOwnerMainPage(email);
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	public boolean registerGymOwner(){
		GymOwner gymOwner = new GymOwner();
		System.out.print("Enter your email: ");
		gymOwner.setEmailId(scanner.next());

		System.out.print("Enter your password: ");
		gymOwner.setPassword(scanner.next());

		System.out.print("Enter your Name: ");
		gymOwner.setGymOwnerName(scanner.next());

		System.out.print("Enter your Address: ");
		gymOwner.setGymOwnerAddress(scanner.next());

		System.out.print("Enter your Gender: ");
		gymOwner.setGender(scanner.next());

		System.out.print("Enter your Age: ");
		gymOwner.setAge(scanner.nextInt());

		System.out.print("Enter your contact number: ");
		gymOwner.setContactNumber(scanner.next());

		System.out.print("Enter your GST Number: ");
		gymOwner.setGstNumber(scanner.next());

		System.out.print("Enter your Adhar Card Number: ");
		gymOwner.setAdharCardNumber(scanner.next());

		gymOwner.setVerified(false);

		return gymOwnerBusiness.createGymOwner(gymOwner);
	}

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