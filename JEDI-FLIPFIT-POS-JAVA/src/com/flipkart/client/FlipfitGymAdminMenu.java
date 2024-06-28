/**
 * 
 */
package com.flipkart.client;

import com.flipkart.business.AdminBusiness;
import com.flipkart.business.GymOwnerBusiness;

import java.util.ArrayList;

import static com.flipkart.client.GymFlipFitApplication.scanner;

/**
 * 
 */
public class FlipfitGymAdminMenu {
	private AdminBusiness adminBusiness = new AdminBusiness();

	public void loginAdmin(String email, String password){
		if (adminBusiness.validateAdmin(email,password)) {
			System.out.println("Successfully logged in");
			flipfitGymAdminMainMenu(email);
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	public static void viewApprovedGyms() {
		System.out.println("List of all Approved Gyms\n");
		return;
	}

	public void approveGymOwner() {
		System.out.print("Enter Gym Owner Id you want to verify: ");
		int gymOwnerId = scanner.nextInt();
		System.out.println(adminBusiness.approveGymOwner(gymOwnerId));
	}

	public static void viewPendingGymOwnerRequests() {
		System.out.println("List of all Pending Gyms");
	}

	public void flipfitGymAdminMainMenu(String emailId) {
		System.out.println("WELCOME ADMIN!!");

		while (true) {
			System.out.println("1. View All GymCenters\n" + "2. View Pending GymOwner Requests\n"
					+ "3. Approve a GymOwner Request\n" + "4. Go Back To Previous Menu");

			int pendingChoice = scanner.nextInt();
			switch (pendingChoice) {
			case 1:
				viewApprovedGyms();
				break;
			case 2:
				viewPendingGymOwnerRequests();
				break;
			case 3:
				approveGymOwner();
				break;
			case 4:
				System.out.println("\\nGOING BACK TO PREVIOUS MENU\\n");
				return;
			default:
				System.out.println("PLEASE CHOOSE A VALID OPTION");
				break;
			}
		}
	}
}
