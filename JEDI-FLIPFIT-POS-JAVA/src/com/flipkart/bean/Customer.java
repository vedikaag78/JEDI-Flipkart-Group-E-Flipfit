/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.business.CustomerBusiness;

/**
 * 
 */
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	

}
