/**
 * 
 */
package com.flipkart.business;
import com.flipkart.bean.Customer;
import com.flipkart.dao.FlipfitCustomerDAOImpl;
import com.flipkart.dao.FlipfitGymOwnerDAOImpl;

/**
 * 
 */
public class CustomerBusiness implements CustomerInterface{
	private FlipfitCustomerDAOImpl customerDAO = new FlipfitCustomerDAOImpl();

	public int validateGymCustomer(String emailId, String password){
		return customerDAO.isValidGymCustomer(emailId, password);
	}

	public Customer getCustomerProfile(int userId){
		return customerDAO.getCustomerByUserId(userId);
	}

	public boolean createCustomer(Customer customer) {
		return customerDAO.createCustomer(customer);
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
