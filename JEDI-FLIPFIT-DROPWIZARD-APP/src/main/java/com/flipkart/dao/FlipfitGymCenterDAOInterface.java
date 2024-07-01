package com.flipkart.dao;

/**
 *
 */

import com.flipkart.model.GymCenter;
import com.flipkart.model.Slot;

import java.util.List;

public interface FlipfitGymCenterDAOInterface {
    public boolean createGymCenter(GymCenter gymCenter, int gymOwnerId);
    public boolean addSlotWithGymID(Slot slot);
    public List<Slot> getAllSlotByGymCenterId(int gymCenterId);
    public List<GymCenter> viewAllGym();
    public int getGymCapacity(int gymCenterId);


}