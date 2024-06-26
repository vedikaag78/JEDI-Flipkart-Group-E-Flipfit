/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class CustomerBusiness {

	public void createCustomer() {
		System.out.println("Customer  Created");
	}

	public boolean updateCustomer(int customerId) {
		System.out.println("Customer Updated ==> " + customerId);
		return true;
	}

	public boolean deleteCustomer(int customerId) {
		System.out.println("Customer Deleted ==> " + customerId);
		return true;
	}

	public void listCustomer() {
		System.out.println("Get all Customer List");
	}
}
