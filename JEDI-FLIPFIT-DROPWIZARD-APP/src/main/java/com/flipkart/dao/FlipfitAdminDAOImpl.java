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
 *
 */
public class FlipfitAdminDAOImpl {

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

            roleName = (queryResult.next() ? queryResult.getString("roleName"):"");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roleName.equals("Admin");
    }

    public boolean verifyGymOwner(int gymOwnerId){
        String updateQuery = "UPDATE gymOwners SET isVerified = true WHERE gymOwnerId = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            stmt.setInt(1, gymOwnerId);

            int rowsAffected = stmt.executeUpdate();
            return  (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<GymOwner> viewPendingGymOwnerRequests(){
        String updateQuery = "SELECT * FROM gymOwners WHERE isVerified = false";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            ResultSet queryResult = stmt.executeQuery();
            List<GymOwner> gymOwnerList = new ArrayList<GymOwner>();
            while(queryResult.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setGymOwnerId(queryResult.getInt("gymOwnerId"));
                gymOwner.setGymOwnerName(queryResult.getString("gymOwnerName"));
                gymOwner.setGstNumber(queryResult.getString("gstNumber"));
                gymOwner.setAdharCardNumber(queryResult.getString("aadharCardNumber"));
                gymOwner.setContactNumber(queryResult.getString("contactNumber"));
                gymOwnerList.add(gymOwner);
            }
            return gymOwnerList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
