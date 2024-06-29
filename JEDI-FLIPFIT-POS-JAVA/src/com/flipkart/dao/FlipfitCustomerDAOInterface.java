/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Customer;

/**
 * 
 */
public interface FlipfitCustomerDAOInterface {
    int isValidGymCustomer(String emailId, String password);
    boolean createCustomer(Customer newCustomer);

//    boolean isCustomerValid(String email, String password);

    Customer getCustomerByCustomerId(int customerId);
}
