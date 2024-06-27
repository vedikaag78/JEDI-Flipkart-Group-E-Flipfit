/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.util.List;

/**
 * 
 */
public interface FlipfitAdminDAOInterface {
    public void addGymOwnerDetails(GymOwner gymOwner);
    public boolean approveGymOwner(int  gymOwnerId);
    public List<GymOwner> viewPendingListofGymOwners();
    public List<GymOwner> viewApprovedListofGymOwners();
    public boolean deleteGymOwner(int gymOwnerId);



}
