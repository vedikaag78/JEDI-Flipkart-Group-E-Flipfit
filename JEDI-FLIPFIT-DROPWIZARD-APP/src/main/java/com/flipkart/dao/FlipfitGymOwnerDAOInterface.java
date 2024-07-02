package com.flipkart.dao;

import com.flipkart.model.GymCenter;
import com.flipkart.model.GymOwner;

import java.util.List;

/**
 * Interface for managing GymOwner-related operations in the Flipfit application.
 */
public interface FlipfitGymOwnerDAOInterface {

    /**
     * Validates if the provided credentials belong to a GymOwner and returns the corresponding user ID.
     *
     * @param emailId the email ID of the GymOwner
     * @param password the password associated with the email ID
     * @return the user ID of the GymOwner if valid, or -1 if invalid or an error occurs
     */
    public int isValidGymOwner(String emailId, String password);

    /**
     * Retrieves the gym owner ID associated with the given user ID.
     *
     * @param userId the user ID for which to retrieve the gym owner ID
     * @return the gym owner ID if found, or -1 if not found or an error occurs
     */
    public int getGymOwnerId(int userId);

    /**
     * Creates a new gym owner record in the database.
     *
     * @param gymOwner the GymOwner object containing the details to be inserted
     * @return true if the gym owner was successfully created, false otherwise
     */
    public boolean createGymOwner(GymOwner gymOwner);

    /**
     * Retrieves a list of all gym centers associated with a specific gym owner from the database.
     *
     * @param gymOwnerId the ID of the gym owner for which to retrieve gym centers
     * @return a list of GymCenter objects representing all gym centers owned by the gym owner,
     *         or null if an error occurs during database access
     */
    public List<GymCenter> getAllGymCenterByGymOwnerId(int gymOwnerId);

}
