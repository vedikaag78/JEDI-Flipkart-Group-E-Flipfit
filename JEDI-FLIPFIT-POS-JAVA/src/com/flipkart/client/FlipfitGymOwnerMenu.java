package com.flipkart.client;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Slot;
import java.util.Scanner;

//import static com.flipkart.client.GymFlipFitApplication.scanner;

public class FlipfitGymOwnerMenu {
	static Scanner scanner = new Scanner(System.in);
	public void FlipfitGymOwnerMainPage(String gymOwnerId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME "+gymOwnerId+"!!"+formattedDate+"\nWhat do you want to do");
        while(true){
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. Add Slots to a Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 0:
                	//call the getAllCentresByOwnerId function using gymOwnerId from gymCentre service to return a list of gym centers
                    //printGymCentres list
                    break;

                case 1:
                	 //request GymOwner Approval by sending gymOwnerId in gymOwner service;
                    break;

                case 2:

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

                    //add gymCenter by creating a new object using about data
                    break;

                case 3:

                    System.out.println("Enter Gym Centre Id: ");
                    String gymCentreId = scanner.next();

                   // requestGymCentreApproval using gymCentreId
                    break;

                case 4:

                    boolean isAdding = true;
                    String centreId = null;

                    List<Slot> newSlotList = new ArrayList<>();
                    while (isAdding) {
                        System.out.println("Enter new slot id: ");
                        String slotId = scanner.next();

                        System.out.println("Enter Gym Centre Id: ");
                        centreId = scanner.next();

                        System.out.println("Enter time in 24h format (hh:mm:ss) : ");
                        String time = scanner.next();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime localTime = LocalTime.parse(time, formatter);

                        // add newSlotlist to the slots

                        System.out.println("Do you want to enter more slots (y/n)?: ");
                        String addChoice = scanner.next();
                        addChoice = addChoice.toLowerCase();

                        if(addChoice.equals("n") || addChoice.equals("no")) {
                            isAdding = false;
                        }
                    }

                    // addSlotsForGym using centreId, newSlotList to slot service
                    break;
                case 5:
                    System.out.println("\\nGOING BACK TO PREVIOUS MENU\\n");
                    return;
                default:
                    System.out.println("PLEASE CHOOSE A VALID SLOT");
                    break;
            }	
        }
	}
}