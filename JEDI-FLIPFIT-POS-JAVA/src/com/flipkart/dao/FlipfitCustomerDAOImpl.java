package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.sql.*;

public class FlipfitCustomerDAOImpl implements FlipfitCustomerDAOInterface {
    public int isValidGymCustomer(String emailId, String password){
        int userId = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

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
            System.out.println(e);
        }

        return userId;
    }



//    public static String getUserRole(String emailId, String password){
//        String roleName = "";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");
//
//            PreparedStatement getUserRoleStmt = connection.prepareStatement(
//                    "SELECT r.roleName, r.roleDescription " +
//                            "FROM user u " +
//                            "JOIN role r ON u.roleId = r.roleId " +
//                            "WHERE u.emailId = ? AND u.password = ?");
//
//            getUserRoleStmt.setString(1, emailId);
//            getUserRoleStmt.setString(2, password);
//
//            ResultSet queryResult = getUserRoleStmt.executeQuery();
//
//            roleName = (queryResult.next() ? queryResult.getString("roleName"):"");
//            connection.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return roleName;
//    }

    public boolean createCustomer(Customer newCustomer) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

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

            insertCustomerStmt.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Customer getCustomerByUserId(int userId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getCustomerByIdStmt = connection.prepareStatement(
                    "SELECT * FROM customers WHERE userId = ?");

            getCustomerByIdStmt.setInt(1, userId);

            ResultSet queryResult = getCustomerByIdStmt.executeQuery();

            if (!queryResult.next()) {
                System.out.println("Customer not found with Customer ID " + userId);
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
            System.out.println(e);
            return null;
        }
    }
}
