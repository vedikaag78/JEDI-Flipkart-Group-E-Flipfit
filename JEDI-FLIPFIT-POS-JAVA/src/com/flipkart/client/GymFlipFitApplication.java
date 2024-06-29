package com.flipkart.client;

import java.util.Scanner;

public class GymFlipFitApplication {
    static Scanner scanner = new Scanner(System.in);
    private static FlipfitGymAdminMenu flipfitGymAdminMenu = new FlipfitGymAdminMenu();
    private static FlipfitGymOwnerMenu flipfitGymOwnerMenu = new FlipfitGymOwnerMenu();
    private static FlipfitGymCustomerMenu flipfitGymCustomerMenu = new FlipfitGymCustomerMenu();

    public static void loginUser() {
        System.out.println("--------------------------------------------");
        System.out.println("---- ENTER LOGIN DETAILS ---");
        System.out.print("Enter your email: ");
        String email = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        System.out.print("Enter your role: ");
        String roleName = scanner.next();

        switch (roleName) {
            case "Admin":
                flipfitGymAdminMenu.loginAdmin(email, password);
                break;
            case "GymOwner":
                flipfitGymOwnerMenu.loginGymOwner(email, password);
                break;
            case "Customer":
                flipfitGymCustomerMenu.loginGymCustomer(email, password);
                break;
            default:
                System.out.println("Please enter the Role in the CamelCase again");
                break;
        }
    }

    public static void registerAsCustomer() {
     if(flipfitGymCustomerMenu.registerCustomer()) loginUser();
     else System.out.println("Failed to Register");
    }

    public static void registerAsGymOwner() {
        if(flipfitGymOwnerMenu.registerGymOwner()) loginUser();
        else System.out.println("Failed to Register");
    }

    public static void changePassword() {
        System.out.println("change Password ==> Enter Details");
    }

    public static void main(String[] args) {
        boolean menuStatus = true;
        while (menuStatus) {
            System.out.println("""
                --------------------------------------------
                -----------Welcome to Flipfit App-----------
                    1. Login
                    2. Register as Customer
                    3. Register as Gym Owner
                    4. Change Password
                    5. Exit
                --------------------------------------------""");

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
