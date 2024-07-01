/**
 *
 */
package com.flipkart.dao;

import com.flipkart.model.GymCenter;
import com.flipkart.model.GymOwner;

import java.sql.*;
import java.util.*;

public class FlipfitGymOwnerDAOImpl {
    public int isValidGymOwner(String emailId, String password){
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
            if(roleName.equals("GymOwner")) userId = queryResult.getInt("userId");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }

    public int getGymOwnerId(int userId){
        int gymOwnerId = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getGymOwnerIdStmt = connection.prepareStatement(
                    "SELECT gymOwnerId FROM GymOwners WHERE userId = ?;");

            getGymOwnerIdStmt.setInt(1, userId);

            ResultSet queryResult = getGymOwnerIdStmt.executeQuery();

            gymOwnerId = (queryResult.next() ? queryResult.getInt("gymOwnerId"):-1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gymOwnerId;
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

            int rowsAffected = insertGymOwnerStmt.executeUpdate();
            connection.close();
            return (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<GymCenter> getAllGymCenterByGymOwnerId(int gymOwnerId){
        List<GymCenter> gymCenterList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getGymCenterStmt = connection.prepareStatement(
                    "SELECT * FROM gymCenters WHERE gymOwnerId = ?;");

            getGymCenterStmt.setInt(1,gymOwnerId);

            ResultSet queryResult = getGymCenterStmt.executeQuery();
            while (queryResult.next()) {
                GymCenter gymCenter = new GymCenter();
                gymCenter.setGymCenterId(queryResult.getInt("gymCenterId"));
                gymCenter.setGymOwnerId(queryResult.getInt("gymOwnerId"));
                gymCenter.setGymCenterName(queryResult.getString("gymCenterName"));
                gymCenter.setAddress(queryResult.getString("address"));
                gymCenter.setCapacity(queryResult.getInt("capacity"));
                gymCenter.setPrice(queryResult.getInt("price"));
                gymCenter.setCity(queryResult.getString("city"));
                gymCenterList.add(gymCenter);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return gymCenterList;
    }
}
