package com.flipkart.client;

import java.util.Scanner;

public class GymFlipFitApplication {

	static Scanner scanner = new Scanner(System.in);

	public static void loginUser() {
		System.out.print("Enter your userName: ");
		String name = scanner.next();

		System.out.println("userName: " + name);
		System.out.print("Enter your password: ");
		String password = scanner.next();
		System.out.println("password: " + password);

		System.out.print("Enter your role: ");
		String role = scanner.next();
		System.out.println("Role: " + role);

		switch (role) {
		case "Admin":
			FlipfitGymAdminMenu.flipfitGymAdminMainMenu();
			break;
		case "GymOwner":
			FlipfitGymOwnerMenu.FlipfitGymOwnerMainPage("101");
			break;
		case "Customer":
			FlipfitGymCustomerMenu.flipfitGymCustomerMainMenu("101");
			break;
		default:
			System.out.println("Please enter the Role in the CamelCase again");
			break;
		}
	}

	public static void registerAsCustomer() {
		System.out.println("Register as Customer ==> Enter Details");
	}

	public static void registerAsGymOwner() {
		System.out.println("Register as Gym Owner ==> Enter Details");
	}

	public static void changePassword() {
		System.out.println("change Password ==> Enter Details");
	}

	public static void main(String[] args) {
		boolean menuStatus = true;
		while (menuStatus) {
			System.out.println("--------Welcome to Flipfit App-------- ");
			System.out.println("" + "1. Login\n" + "2. Register as Customer\n" + "3. Register as Gym Owner\n"
					+ "4. Change Password\n" + "5. Exit\n");

			int choice = scanner.nextInt();
			switch (choice) {

			case 1:
				loginUser();
				break;

			case 2:
				registerAsCustomer();
				break;

			case 3:
				registerAsGymOwner();
				break;

			case 4:
				changePassword();
				break;

			case 5:
				System.out.println("Thank you for using FlipFit App!!\n");
				return;

			default:
				System.out.println("PLEASE CHOOSE A VALID SLOT");
				break;
			}
		}

	}

}
