package com.flipkart.business;
import java.util.List;
public interface AdminInterface {

	 void approveGymOwner(String gymOwnerId, int isApproved);
	 void  viewApprovedGymOwners(List<String> approvedGymOwnerIds);
	 void viewPendingGymOwners(List<String> pendingGymOwnerIds);
	 void cancelApprovedGymOwner(String gymOwnerId) ;
	
	 
}
