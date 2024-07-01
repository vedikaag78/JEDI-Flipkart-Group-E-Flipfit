/**
 *
 */
package com.flipkart.dao;

import com.flipkart.model.GymOwner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with administrative functionalities related to Flipfit application.
 */
public class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface{

    /**
     * Validates if the provided email ID and password correspond to an admin user.
     *
     * @param emailId the email ID of the user
     * @param password the password of the user
     * @return true if the user is a valid admin, false otherwise
     */
    public boolean isValidAdmin(String emailId, String password){
        String roleName = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getUserRoleStmt = connection.prepareStatement(
                    "SELECT r.roleName, r.roleDescription " +
                            "FROM users u " +
                            "JOIN roles r ON u.roleId = r.roleId " +
                            "WHERE u.emailId = ? AND u.password = ?");

            getUserRoleStmt.setString(1, emailId);
            getUserRoleStmt.setString(2, password);

            ResultSet queryResult = getUserRoleStmt.executeQuery();

            roleName = (queryResult.next() ? queryResult.getString("roleName") : "");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roleName.equals("Admin");
    }

    /**
     * Verifies a gym owner by updating their verification status in the database.
     *
     * @param gymOwnerId the ID of the gym owner to be verified
     * @return true if the gym owner was successfully verified, false otherwise
     */
    public boolean verifyGymOwner(int gymOwnerId){
        String updateQuery = "UPDATE gymOwners SET isVerified = true WHERE gymOwnerId = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            stmt.setInt(1, gymOwnerId);

            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a list of pending gym owner requests from the database.
     *
     * @return a list of GymOwner objects representing pending gym owner requests,
     *         or null if an error occurs during database access
     */
    public List<GymOwner> viewPendingGymOwnerRequests(){
        String selectQuery = "SELECT * FROM gymOwners WHERE isVerified = false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement stmt = connection.prepareStatement(selectQuery);
            ResultSet queryResult = stmt.executeQuery();

            List<GymOwner> gymOwnerList = new ArrayList<>();
            while (queryResult.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setGymOwnerId(queryResult.getInt("gymOwnerId"));
                gymOwner.setGymOwnerName(queryResult.getString("gymOwnerName"));
                gymOwner.setGstNumber(queryResult.getString("gstNumber"));
                gymOwner.setAdharCardNumber(queryResult.getString("aadharCardNumber"));
                gymOwner.setContactNumber(queryResult.getString("contactNumber"));
                gymOwnerList.add(gymOwner);
            }

            connection.close();
            return gymOwnerList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

