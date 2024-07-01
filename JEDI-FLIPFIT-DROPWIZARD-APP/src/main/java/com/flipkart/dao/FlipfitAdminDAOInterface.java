package com.flipkart.dao;

import com.flipkart.model.GymOwner;

import java.util.List;

public interface FlipfitAdminDAOInterface {
    public boolean isValidAdmin(String emailId, String password);
    public boolean verifyGymOwner(int gymOwnerId);
    public List<GymOwner> viewPendingGymOwnerRequests();

}
