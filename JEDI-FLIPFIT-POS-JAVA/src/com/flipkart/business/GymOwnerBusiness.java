/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.dao.FlipfitGymCenterDAOImpl;
import com.flipkart.dao.FlipfitGymOwnerDAOImpl;

import java.util.List;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerInterface {
	private FlipfitGymOwnerDAOImpl gymOwnerDAO = new FlipfitGymOwnerDAOImpl();
	private FlipfitGymCenterDAOImpl gymCenterDAO = new FlipfitGymCenterDAOImpl();

	public int validateGymOwner(String emailId, String password){
		int userId = gymOwnerDAO.isValidGymOwner(emailId, password);
		return (userId!=-1 ? gymOwnerDAO.getGymOwnerId(userId) : -1);
	}

	public boolean createGymOwner(GymOwner gymOwner) {
		return gymOwnerDAO.createGymOwner(gymOwner);
	}

	public List<GymCenter> getAllGymCenterByGymOwnerId(int gymOwnerId){
		return gymOwnerDAO.getAllGymCenterByGymOwnerId(gymOwnerId);
	}

	public boolean addSlotWithGymID(Slot slot){
		return gymCenterDAO.addSlotWithGymID(slot);
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