package com.flipkart.dao;

import com.flipkart.model.Customer;

/**
 * Interface for managing customer-related functionalities in the Flipfit application.
 */
public interface FlipfitCustomerDAOInterface {

    /**
     * Validates if the provided email ID and password correspond to a registered gym customer.
     *
     * @param emailId the email ID of the customer
     * @param password the password of the customer
     * @return the user ID of the customer if valid, or -1 if not found or an error occurs
     */
    int isValidGymCustomer(String emailId, String password);

    /**
     * Creates a new customer record in the database.
     *
     * @param newCustomer the Customer object containing the details to be inserted
     * @return true if the customer was successfully created, false otherwise
     */
    boolean createCustomer(Customer newCustomer);

    // /**
    //  * Checks if the provided email and password combination is valid for a customer.
    //  *
    //  * @param email the email of the customer
    //  * @param password the password of the customer
    //  * @return true if the email and password match a customer record, false otherwise
    //  */
    // boolean isCustomerValid(String email, String password);

    /**
     * Retrieves the customer ID associated with the given user ID.
     *
     * @param userId the user ID for which to retrieve the customer ID
     * @return the customer ID if found, or -1 if not found or an error occurs
     */
    int getCustomerId(int userId);

    /**
     * Retrieves a Customer object based on the given customer ID.
     *
     * @param customerId the customer ID for which to retrieve the Customer object
     * @return a Customer object if found, or null if not found or an error occurs
     */
    Customer getCustomerByCustomerId(int customerId);
}
