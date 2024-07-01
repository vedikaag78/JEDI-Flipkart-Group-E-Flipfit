package com.flipkart.dao;
import com.flipkart.model.Customer;

/**
 *
 */
public interface FlipfitCustomerDAOInterface {
    int isValidGymCustomer(String emailId, String password);
    boolean createCustomer(Customer newCustomer);

    //    boolean isCustomerValid(String email, String password);
    int getCustomerId(int userId);
    Customer getCustomerByCustomerId(int customerId);
}
