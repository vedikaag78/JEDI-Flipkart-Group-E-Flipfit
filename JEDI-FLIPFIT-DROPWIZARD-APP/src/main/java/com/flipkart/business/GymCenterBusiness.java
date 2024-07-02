/**
 *
 */
package com.flipkart.business;

/**
 *
 */
import com.flipkart.model.GymCenter;
import com.flipkart.dao.FlipfitGymCenterDAOImpl ;

public class GymCenterBusiness {
    FlipfitGymCenterDAOImpl gymCenterDAO = new FlipfitGymCenterDAOImpl();

    public void createGymCenter(GymCenter gymCenter, int gymOwnerId) {
        if(gymCenterDAO.createGymCenter(gymCenter, gymOwnerId))
            System.out.println("Gym center --> " + gymCenter.getGymCenterName() + "created successfully");
        else System.out.println("Oops! Failed to create gym center");
    }
}