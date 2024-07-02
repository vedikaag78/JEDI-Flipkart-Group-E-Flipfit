package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {

    boolean approveGymOwner(int gymOwnerId);

    void viewApprovedGymOwners(List<String> approvedGymOwnerIds);

    void cancelApprovedGymOwner(String gymOwnerId);

    List<GymOwner> viewPendingGymOwners();
}
