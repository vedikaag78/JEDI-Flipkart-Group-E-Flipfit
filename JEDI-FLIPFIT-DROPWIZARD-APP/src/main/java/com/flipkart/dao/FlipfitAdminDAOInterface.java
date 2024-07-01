package com.flipkart.dao;

import com.flipkart.model.GymOwner;

import java.util.List;

/**
 * Interface for managing administrative functionalities related to Flipfit application.
 */
public interface FlipfitAdminDAOInterface {

    /**
     * Validates if the provided email ID and password correspond to an admin user.
     *
     * @param emailId the email ID of the user
     * @param password the password of the user
     * @return true if the user is a valid admin, false otherwise
     */
    public boolean isValidAdmin(String emailId, String password);

    /**
     * Verifies a gym owner by updating their verification status in the database.
     *
     * @param gymOwnerId the ID of the gym owner to be verified
     * @return true if the gym owner was successfully verified, false otherwise
     */
    public boolean verifyGymOwner(int gymOwnerId);

    /**
     * Retrieves a list of pending gym owner requests from the database.
     *
     * @return a list of GymOwner objects representing pending gym owner requests,
     *         or an empty list if no requests are pending or null if an error occurs during database access
     */
    public List<GymOwner> viewPendingGymOwnerRequests();

}
