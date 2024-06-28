/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
public class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface {
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
            System.out.println(roleName);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
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

            int i = stmt.executeUpdate();
            System.out.println("Gym is Verified...");
            return true ;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
