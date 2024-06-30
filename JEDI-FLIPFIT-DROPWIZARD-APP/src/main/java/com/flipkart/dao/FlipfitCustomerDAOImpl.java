package com.flipkart.dao;


import com.flipkart.model.*;

import java.sql.*;

public class FlipfitCustomerDAOImpl  {
    
    public int isValidGymCustomer(String emailId, String password){
        int userId = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "12345678");

            PreparedStatement getUserRoleStmt = connection.prepareStatement(
                    "SELECT r.roleName, u.userId " +
                            "FROM users u " +
                            "JOIN roles r ON u.roleId = r.roleId " +
                            "WHERE u.emailId = ? AND u.password = ?");

            getUserRoleStmt.setString(1, emailId);
            getUserRoleStmt.setString(2, password);

            ResultSet queryResult = getUserRoleStmt.executeQuery();

            String roleName = (queryResult.next() ? queryResult.getString("roleName"):"");
            if(roleName.equals("Customer")) userId = queryResult.getInt("userId");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }

    public int getCustomerId(int userId){
        int customerId = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "12345678");

            PreparedStatement getGymOwnerIdStmt = connection.prepareStatement(
                    "SELECT * FROM customers WHERE userId = ?;");

            getGymOwnerIdStmt.setInt(1, userId);

            ResultSet queryResult = getGymOwnerIdStmt.executeQuery();

            customerId = (queryResult.next() ? queryResult.getInt("customerId"):-1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerId;
    }

    public boolean createCustomer(Customer newCustomer) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "12345678");

            PreparedStatement insertUserStmt = connection.prepareStatement(
                    "INSERT INTO Users (emailId, password, roleId)\n" +
                            "VALUES (?, ?, 3);", Statement.RETURN_GENERATED_KEYS);

            insertUserStmt.setString(1, newCustomer.getEmailId());
            insertUserStmt.setString(2, newCustomer.getPassword());

            insertUserStmt.executeUpdate();
            ResultSet rs = insertUserStmt.getGeneratedKeys();
            int last_inserted_id = -1;
            if(rs.next()) last_inserted_id = rs.getInt(1);

            PreparedStatement insertCustomerStmt = connection.prepareStatement(
                    "INSERT INTO Customers ("+
                            "customerName, " +
                            "customerAddress, " +
                            "gender, " +
                            "age, " +
                            "contactNumber, " +
                            "cardDetails, " +
                            "userId) " +
                            "VALUES (?,?,?,?,?,?,?);");

            insertCustomerStmt.setString(1, newCustomer.getCustomerName());
            insertCustomerStmt.setString(2, newCustomer.getCustomerAddress());
            insertCustomerStmt.setString(3, newCustomer.getGender());
            insertCustomerStmt.setInt(4, newCustomer.getAge());
            insertCustomerStmt.setString(5, newCustomer.getContactNumber());
            insertCustomerStmt.setString(6, newCustomer.getCardDetails());
            insertCustomerStmt.setInt(7, last_inserted_id);

            int rowsAffected = insertCustomerStmt.executeUpdate();
            connection.close();
            return (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer getCustomerByCustomerId(int custID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "12345678");

            PreparedStatement getCustomerByIdStmt = connection.prepareStatement(
                    "SELECT * FROM customers WHERE customerId = ?");

            getCustomerByIdStmt.setInt(1, custID);

            ResultSet queryResult = getCustomerByIdStmt.executeQuery();

            if (!queryResult.next()) {
                System.out.println("Customer not found with Customer ID " + custID);
                connection.close();
                return null;
            }

            Customer customer = new Customer();
            customer.setCustomerName(queryResult.getString("customerName"));
            customer.setCustomerAddress(queryResult.getString("customerAddress"));
            customer.setGender(queryResult.getString("gender"));
            customer.setAge(queryResult.getInt("age"));
            customer.setContactNumber(queryResult.getString("contactNumber"));
            customer.setCardDetails(queryResult.getString("cardDetails"));

            connection.close();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}