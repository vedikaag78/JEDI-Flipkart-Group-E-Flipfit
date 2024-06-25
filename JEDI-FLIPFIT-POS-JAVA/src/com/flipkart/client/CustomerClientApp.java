/**
 * 
 */
package com.flipkart.client;

import com.flipkart.business.CustomerBusiness;

/**
 * 
 */
public class CustomerClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// client ---> business--- bean
		// create the business instance
		CustomerBusiness service = new CustomerBusiness();
		service.createCustomer();
		System.out.println("update customer-->" + service.updateCustomer(101));
		System.out.println("Delete Customer-->" + service.deleteCustomer(101));
		service.listCustomer();

	}

}
