package com.flipkart.business;
import java.util.List;
public interface AdminInterface {

	 boolean approveGymOwner(int gymOwnerId);
	 void  viewApprovedGymOwners(List<String> approvedGymOwnerIds);
	 void viewPendingGymOwners(List<String> pendingGymOwnerIds);
	 void cancelApprovedGymOwner(String gymOwnerId) ;
	
	 
}
