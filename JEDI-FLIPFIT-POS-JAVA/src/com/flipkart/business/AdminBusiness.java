package com.flipkart.business;

import com.flipkart.dao.FlipfitAdminDAOImpl;

import java.util.List;

public class AdminBusiness implements AdminInterface {
	private FlipfitAdminDAOImpl adminDAO = new FlipfitAdminDAOImpl();

	public boolean validateAdmin(String emailId, String password){
		return adminDAO.isValidAdmin(emailId, password);
	}

	public boolean approveGymOwner(int gymCentreId) {
		return adminDAO.verifyGymOwner(gymCentreId);
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
