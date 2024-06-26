/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class GymCenterBusiness {
	public void createGymCenter() {
		System.out.println("Gym Center Created");
	}
	
	public boolean updateGymCenter(int gymCenterId) {
		System.out.println("Gym Center Updated ==> " + gymCenterId);
		return true;
	}
	
	public boolean deleteGymCenter(int gymCenterId) {
		System.out.println("Gym Center Deleted ==> " + gymCenterId);
		return true;
	}
	
	public void listGymCenter() {
		System.out.println("Get all Gym Center List");
	}
}
