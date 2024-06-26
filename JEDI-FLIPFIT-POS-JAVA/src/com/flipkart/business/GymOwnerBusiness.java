/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerInterface {
	public void createGymOwner() {
		System.out.println("Gym Owner  Created");
	}

	public boolean updateGymOwner(int gymOwnerId) {
		System.out.println("Gym Owner Updated ==> " + gymOwnerId);
		return true;
	}

	public boolean deleteGymOwner(int gymOwnerId) {
		System.out.println("Gym Owner Deleted ==> " + gymOwnerId);
		return true;
	}

	public void listGymOwner() {
		System.out.println("Get all Gym Owner List");
	}
}