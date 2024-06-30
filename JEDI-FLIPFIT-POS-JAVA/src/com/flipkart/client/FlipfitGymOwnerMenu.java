package com.flipkart.client;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.GymCenterBusiness;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.utils.GymCenterUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.flipkart.client.GymFlipFitApplication.scanner;

public class FlipfitGymOwnerMenu {
	private GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();

	public void loginGymOwner(String email, String password){
		int gymOwnerId = gymOwnerBusiness.validateGymOwner(email,password);
		if (gymOwnerId > 0) {
			System.out.println("Successfully Logged In");
			FlipfitGymOwnerMainPage(email, gymOwnerId);
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

	public void viewAllGymCenters(int gymCenterId){
		GymCenterUtils.printGymCenterList(gymOwnerBusiness.getAllGymCenterByGymOwnerId(gymCenterId));
	}

	public void addSlotToGymCenter(){
		System.out.println("--------------------------------------------");
		Slot centerSlot = new Slot();
		System.out.print("""
			> Enter Details Following Details to add Slots
			> Enter Center Id of the Slots to be Added: """);
		centerSlot.setGymCenterId(scanner.nextInt());
		System.out.print("> Enter Slot Start Time: (HH:MM in 24hr Format): ");
		centerSlot.setStartTime(scanner.next());
		System.out.print("> Enter Slot End Time: (HH:MM in 24hr Format): ");
		centerSlot.setEndTime(scanner.next());
		gymOwnerBusiness.addSlotWithGymID(centerSlot);
		System.out.println("Slot Successfully Created");
		System.out.println("--------------------------------------------");
	}

	public void FlipfitGymOwnerMainPage(String email, int gymOwnerId) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentTime.format(myFormat);
		while (true) {
			System.out.println("--------------------------------------------");
			System.out.println("WELCOME Gym Owner - " + email + "!! " + formattedDate + "\nWhat do you want to do?");
			System.out.println("""
					1. View all my Gym Centres
					2. Add a new Gym Center
					3. Add Slots to a Gym Centre
					4. Go Back to Previous Menu
				--------------------------------------------""");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				viewAllGymCenters(gymOwnerId);
				break;
			case 2:
				System.out.println("-----Enter Gym Center Details-----");
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

			case 3:
				addSlotToGymCenter();
				break;

			case 4:
				System.out.println("--------------------------------------------\n");
				return;

			default:
				System.out.println("PLEASE CHOOSE A VALID OPTION");
				break;
			}
		}
	}
}