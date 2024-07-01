package com.flipkart.dao;

import com.flipkart.model.GymCenter;
import com.flipkart.model.GymOwner;

import java.sql.*;
import java.util.*;

/**
 * Implementation of FlipfitGymOwnerDAOInterface for managing GymOwner-related operations in Flipfit application.
 */
public class FlipfitGymOwnerDAOImpl implements FlipfitGymOwnerDAOInterface {

    /**
     * Validates if the provided credentials belong to a GymOwner and returns the corresponding user ID.
     *
     * @param emailId the email ID of the GymOwner
     * @param password the password associated with the email ID
     * @return the user ID of the GymOwner if valid, or -1 if invalid or an error occurs
     */
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

    /**
     * Retrieves the gym owner ID associated with the given user ID.
     *
     * @param userId the user ID for which to retrieve the gym owner ID
     * @return the gym owner ID if found, or -1 if not found or an error occurs
     */
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

    /**
     * Creates a new gym owner record in the database.
     *
     * @param gymOwner the GymOwner object containing the details to be inserted
     * @return true if the gym owner was successfully created, false otherwise
     */
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

    /**
     * Retrieves a list of all gym centers associated with a specific gym owner from the database.
     *
     * @param gymOwnerId the ID of the gym owner for which to retrieve gym centers
     * @return a list of GymCenter objects representing all gym centers owned by the gym owner,
     *         or null if an error occurs during database access
     */
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
