/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipfitGymOwnerDAOImpl;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerInterface {
	private FlipfitGymOwnerDAOImpl gymOwnerDAO = new FlipfitGymOwnerDAOImpl();

	public boolean validateGymOwner(String emailId, String password){
		return gymOwnerDAO.isValidGymOwner(emailId, password);
	}

	public boolean createGymOwner(GymOwner gymOwner) {
		return gymOwnerDAO.createGymOwner(gymOwner);
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