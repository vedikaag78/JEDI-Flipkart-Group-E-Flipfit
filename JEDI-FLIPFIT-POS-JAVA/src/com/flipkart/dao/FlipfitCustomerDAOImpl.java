package com.flipkart.dao;

import com.flipkart.bean.Customer;

public class FlipfitCustomerDAOImpl implements FlipfitCustomerDAOInterface{
	public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {};

    public boolean isCustomerValid(String userName, String password) {
    	return true;
    };

    public Customer getCustomerById(String userName) {
    	return new Customer();
    };
}
