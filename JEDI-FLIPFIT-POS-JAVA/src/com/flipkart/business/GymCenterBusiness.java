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



	public void createGymCenter(GymCenter gymCenter, int gymOwnerId) {
		FlipfitGymCenterDAOImpl gymCenterDAO = new FlipfitGymCenterDAOImpl();
		gymCenterDAO.createGymCenter(gymCenter, gymOwnerId);
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