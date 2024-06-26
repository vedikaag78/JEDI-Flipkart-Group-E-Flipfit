package com.flipkart.client;

import java.util.Scanner;

public class GymFlipFitApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//login
		 System.out.println("--------Welcome to Flipfit App-------- ");  
		 Scanner in = new Scanner(System.in);
         System.out.print("Enter your userName: ");    
         String name = in.next();   
         System.out.println("userName: " + name);           
         System.out.print("Enter your password: ");  
         String i = in.next();  
         System.out.println("password: " + i);  
         System.out.print("Enter your role: ");  
         String d = in.next();  
         System.out.println("Role: " + d);
         boolean flag=true;
         do {
        	 switch(d){    
        	 case "Admin":    
        		 //code to be executed;
        		 flag=false;
        		 break;  //optional  
        	 case "GymOwner":    
        		 //code to be executed;
        		 flag=false;
        		 break;  //optional  
        	 case "Customer":
        		 flag=false;
        		 break;   
             
        	 default:     
        		 System.out.println("Please enter the Role in the CamelCase again");
        	 }  
         }while(flag);
         in.close();  
         

	}

}
