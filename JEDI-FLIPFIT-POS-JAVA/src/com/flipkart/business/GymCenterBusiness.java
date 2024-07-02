/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
import com.flipkart.bean.GymCenter;
import com.flipkart.dao.FlipfitGymCenterDAOImpl ;
public class GymCenterBusiness implements GymCenterBusinessInterface {
	FlipfitGymCenterDAOImpl gymCenterDAO = new FlipfitGymCenterDAOImpl();

	public void createGymCenter(GymCenter gymCenter, int gymOwnerId) {
		if(gymCenterDAO.createGymCenter(gymCenter, gymOwnerId))
			System.out.println("Gym center --> " + gymCenter.getGymCenterName() + "created successfully");
		else System.out.println("Oops! Failed to create gym center");
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