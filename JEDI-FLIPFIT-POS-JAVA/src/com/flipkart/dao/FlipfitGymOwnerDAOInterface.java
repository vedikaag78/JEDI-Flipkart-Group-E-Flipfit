/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymCenter;

/**
 * 
 */
public interface FlipfitGymOwnerDAOInterface {
    public void addGymDetails(GymCenter gymCenter) ;
    public void updateGymDetails(GymCenter gymCenter);
    public void deleteGymDetails(GymCenter gymCenter);
    public GymCenter getGymDetails(GymCenter gymCenter);

}
