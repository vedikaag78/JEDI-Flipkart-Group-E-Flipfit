package com.flipkart.client;
import java.util.*;  
import static com.flipkart.client.GymFlipFitApplication.scanner;
public class FlipfitGymAdmin {
	
	
	public void viewApprovedGyms() {
		/*
    	 * Logic to view approved gyms
    	 */
		System.out.println("List of all Approved Gyms\n");
		return ;
    }
	
	public void approveGymCenter() {
    	System.out.println("Enter Gym Center Details\n");
    	String gymId = scanner.next(); 
    	/*
    	 * Logic to approve a gym 
    	 */
    	return ;
    }
	
	public void approveGymOwner() {
    	System.out.println("Enter Gym Owner Details\n");
    	String gymId = scanner.next(); 
    	/*
    	 * Logic to approve a gym 
    	 */
    	return ;
    }
	
	
	public void viewPendingGymCenterRequests() {
		/*
		 * Logic to view Pending Gyms Centers
		 */
		System.out.println("List of all Pending Gyms");
	}
	
	public void viewPendingGymOwnerRequests() {
		/*
		 * Logic to view Pending Gyms Centers
		 */
		System.out.println("List of all Pending Gyms");
	}

public void adminClientMainPage() {
    System.out.println("WELCOME ADMIN!!");
//    Scanner scanner = new Scanner(System.in);  
    while(true){
        System.out.println("0. View All GymCenters\n1. "
        		+ "View Pending GymCenter Requests\n2. "
        		+ "View Pending GymOwner Requests\n3 "
        		+ "Approve a GymOwner Request\n4. "
        		+ "Approve a GymCenter Request\n4. "
        		+ "Go Back To Previous Menu");
        int pendingChoice = scanner.nextInt();
        switch (pendingChoice) {
            case 0:
                viewApprovedGyms() ;
                break;
            case 1:
                viewPendingGymCenterRequests();
                break;

            case 2:
            	viewPendingGymOwnerRequests() ;
                break;
            case 3:
            	approveGymOwner() ;
                break;
            case 4:
            	approveGymCenter() ;
            	
            case 5 :
                return;
        }
        
    }
 
    
    
   
    
    	
    }
    
    
    
     
//    System.out.print("Enter your name: ");    
//      
//    System.out.println("Name: " + name);           
//    System.out.print("Enter your age: ");  
//    int i = in.nextInt();  
//    System.out.println("Age: " + i);  
//    System.out.print("Enter your salary: ");  
//    double d = in.nextDouble();  
//    System.out.println("Salary: " + d);         
//    in.close();  

}
