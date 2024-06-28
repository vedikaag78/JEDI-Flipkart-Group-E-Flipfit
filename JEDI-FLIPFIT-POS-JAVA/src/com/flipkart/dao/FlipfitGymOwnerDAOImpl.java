/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

import java.sql.*;

/**
 * 
 */
public class FlipfitGymOwnerDAOImpl implements FlipfitGymOwnerDAOInterface{
    public boolean isValidGymOwner(String emailId, String password){
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
            System.out.println(e);
        }

        return roleName.equals("GymOwner");
    }

    public boolean createGymOwner(GymOwner gymOwner){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement insertUserStmt = connection.prepareStatement(
                    "INSERT INTO Users (emailId, password, roleId)\n" +
                            "VALUES (?, ?, 2);", Statement.RETURN_GENERATED_KEYS);

            insertUserStmt.setString(1, gymOwner.getEmailId());
            insertUserStmt.setString(2, gymOwner.getPassword());

            insertUserStmt.executeUpdate();
            ResultSet rs = insertUserStmt.getGeneratedKeys();
            int last_inserted_id = -1;
            if(rs.next()) last_inserted_id = rs.getInt(1);

            PreparedStatement insertGymOwnerStmt = connection.prepareStatement(
                    "INSERT INTO GymOwners ("+
                            "gymOwnerName, " +
                            "gymOwnerAddress, " +
                            "gender, " +
                            "age, " +
                            "contactNumber, " +
                            "gstNumber, " +
                            "aadharCardNumber, " +
                            "isVerified, " +
                            "userId) " +
                            "VALUES (?,?,?,?,?,?,?,?,?);");

            insertGymOwnerStmt.setString(1, gymOwner.getGymOwnerName());
            insertGymOwnerStmt.setString(2, gymOwner.getGymOwnerAddress());
            insertGymOwnerStmt.setString(3, gymOwner.getGender());
            insertGymOwnerStmt.setInt(4, gymOwner.getAge());
            insertGymOwnerStmt.setString(5, gymOwner.getContactNumber());
            insertGymOwnerStmt.setString(6, gymOwner.getGstNumber());
            insertGymOwnerStmt.setString(7, gymOwner.getAdharCardNumber());
            insertGymOwnerStmt.setBoolean(8, gymOwner.isVerified());
            insertGymOwnerStmt.setInt(9, last_inserted_id);

            insertGymOwnerStmt.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
