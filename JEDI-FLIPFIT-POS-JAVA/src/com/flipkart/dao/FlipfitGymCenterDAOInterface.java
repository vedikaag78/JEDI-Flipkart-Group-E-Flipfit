/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */

import com.flipkart.bean.GymCenter;

import java.util.List;

public interface FlipfitGymCenterDAOInterface {
    public boolean createGymCenter(GymCenter gymCenter, int gymOwnerId);

}