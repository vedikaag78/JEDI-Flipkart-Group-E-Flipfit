/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Customer;

/**
 * 
 */
public interface FlipfitCustomerDAOInterface {
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);

    boolean isCustomerValid(String userName, String password);

    Customer getCustomerById(String userName);
}
