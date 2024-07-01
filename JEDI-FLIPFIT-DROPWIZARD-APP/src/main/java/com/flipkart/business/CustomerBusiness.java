package com.flipkart.business;
import com.flipkart.dao.FlipfitCustomerDAOImpl ;
import com.flipkart.model.Customer;


public class CustomerBusiness {
    FlipfitCustomerDAOImpl customerDAO = new FlipfitCustomerDAOImpl();
    public int validateCustomer(String emailId, String password){
        int custId = customerDAO.isValidGymCustomer(emailId, password);

        return (custId!=-1 ? 1 : -1);
    }

    public boolean createCustomer(Customer customer ) {
        return customerDAO.createCustomer(customer);
    }


    public int getCustomerId(int userId) {
        return customerDAO.getCustomerId(userId);
    }

    public Customer getCustomerByCustomerId(int userId){
        return customerDAO.getCustomerByCustomerId(userId);
    }




}
