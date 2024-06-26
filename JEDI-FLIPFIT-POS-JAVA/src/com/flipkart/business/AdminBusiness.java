package com.flipkart.business;

import java.util.List;

public class AdminBusiness implements AdminInterface {
	
	public void approveGymOwner(String gymCentreId, int isApproved) {
		System.out.println("Gym Owner Approved");
		return ;
	}
	public void  viewApprovedGymOwners(List<String> approvedGymsOwnerIds) {
		System.out.println("List of Approved Gym Owners");
		return ;
	}
	public void viewPendingGymOwners(List<String> pendingGymOwnerIds) {
		System.out.println("List of Pending Gyms");
		return ;
	}
	public void cancelApprovedGymOwner(String gymID) {
		System.out.println("List of Pending Gyms");
		return ;
	}
	

}
