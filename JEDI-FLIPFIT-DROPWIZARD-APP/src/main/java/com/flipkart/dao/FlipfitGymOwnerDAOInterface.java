package com.flipkart.dao;

import com.flipkart.model.GymCenter;
import com.flipkart.model.GymOwner;

import java.util.List;

public interface FlipfitGymOwnerDAOInterface {
    public int isValidGymOwner(String emailId, String password);
    public int getGymOwnerId(int userId);
    public boolean createGymOwner(GymOwner gymOwner);
    public List<GymCenter> getAllGymCenterByGymOwnerId(int gymOwnerId);

}
