package com.flipkart.dao;

import com.flipkart.model.GymCenter;
import com.flipkart.model.Slot;
import java.util.List;

/**
 * Interface for managing gym center-related functionalities in the Flipfit application.
 */
public interface FlipfitGymCenterDAOInterface {

    /**
     * Creates a new gym center record in the database.
     *
     * @param gymCenter the GymCenter object containing the details to be inserted
     * @param gymOwnerId the ID of the gym owner associated with the gym center
     * @return true if the gym center was successfully created, false otherwise
     */
    public boolean createGymCenter(GymCenter gymCenter, int gymOwnerId);

    /**
     * Adds a new time slot associated with a gym center to the database.
     *
     * @param slot the Slot object containing slot details to be added
     * @return true if the slot was successfully added, false otherwise
     */
    public boolean addSlotWithGymID(Slot slot);

    /**
     * Retrieves all time slots associated with a specific gym center from the database.
     *
     * @param gymCenterId the ID of the gym center for which to retrieve slots
     * @return a list of Slot objects representing all slots of the gym center,
     *         or null if an error occurs during database access
     */
    public List<Slot> getAllSlotByGymCenterId(int gymCenterId);

    /**
     * Retrieves a list of all verified gym centers from the database.
     *
     * @return a list of GymCenter objects representing all verified gym centers,
     *         or null if an error occurs during database access
     */
    public List<GymCenter> viewAllGym();

    /**
     * Retrieves the capacity of a gym center based on the provided gym center ID.
     *
     * @param gymCenterId the ID of the gym center for which to retrieve capacity
     * @return the capacity of the gym center if found, or -1 if not found or an error occurs
     */
    public int getGymCapacity(int gymCenterId);
}
