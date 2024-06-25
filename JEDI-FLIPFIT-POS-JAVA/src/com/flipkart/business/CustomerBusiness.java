/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class CustomerBusiness {
	// add // update // delete // list

	public void createCustomer() {
		System.out.println("Customer Created");
	}

	public boolean updateCustomer(int CustomerId) {
		System.out.println("Customer is updated by id --->" + CustomerId);
		return true;
	}

	public boolean deleteCustomer(int CustomerId) {
		System.out.println("Customer is deleted by id --->" + CustomerId);
		return true;
	}

	public void listCustomer() {
		System.out.println("Customer display over here -->");
	}

}
