/**
 * 
 */
package com.flipkart.client;

import static com.flipkart.client.GymFlipFitApplication.scanner;

/**
 * 
 */
public class FlipfitGymAdminMenu {
	public static void viewApprovedGyms() {
		System.out.println("List of all Approved Gyms\n");
		return;
	}

	public static void approveGymOwner() {
		System.out.println("Enter Gym Owner Details\n");
		String gymId = scanner.next();
		return;
	}

	public static void viewPendingGymOwnerRequests() {
		System.out.println("List of all Pending Gyms");
	}

	public static void flipfitGymAdminMainMenu() {
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
