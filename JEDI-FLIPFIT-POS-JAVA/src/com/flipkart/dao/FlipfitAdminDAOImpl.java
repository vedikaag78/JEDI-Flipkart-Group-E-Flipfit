/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
/*
    Functions :
    1) Add a gymOwner
    2) Approve a gymOwner
    3) View Pending List
    4) View Approved list
    5) Delete a gymOwner
 */
//Note check dbName and Tables name
public abstract class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_schema";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";
    private static final String GYM_TABLE = "GymCenters";
    private static final String GYM_OWNERS_TABLE = "GymOwners";
    public void addGymOwnerDetails(GymOwner gymOwner) {

            String insertQuery = "INSERT INTO " +GYM_OWNERS_TABLE+" (gymOwnerName, gymOwnerAddress, gender, age, contactNumber, gstNumber, aadharCardNumber, isVerified) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(insertQuery)) {

                stmt.setString(1, gymOwner.getGymOwnerName());
                stmt.setString(2, gymOwner.getGymOwnerAddress());
                stmt.setString(3, gymOwner.getGender());
                stmt.setInt(4, gymOwner.getAge());
                stmt.setLong(5, gymOwner.getContactNumber());
                stmt.setString(6, gymOwner.getGstNumber());
                stmt.setString(7, gymOwner.getAdharCardNumber());
                stmt.setBoolean(8, gymOwner.isVerified());

                int i = stmt.executeUpdate();
                System.out.println(i + " record inserted");

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public boolean approveGymOwner(int  gymOwnerId) {
        String updateQuery = "UPDATE " + GYM_TABLE+" SET isVerified = ? WHERE gymOwnerId = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(updateQuery)) {

            // Set parameters
            stmt.setBoolean(1, true);
            stmt.setInt(2, gymOwnerId);

            // Execute update
            int i = stmt.executeUpdate();
            System.out.println(i + " gymOwner updated");
            return true ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<GymOwner> viewPendingListofGymOwners() {
        List<GymOwner> gymOwners = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + GYM_OWNERS_TABLE + " WHERE isVerified = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(selectQuery)) {

            stmt.setBoolean(1, false); // Assuming isVerified = false for pending gym owners

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    GymOwner gymOwner = new GymOwner();
                    gymOwner.setGymOwnerId(rs.getInt("gymOwnerId"));
                    gymOwner.setGymOwnerName(rs.getString("gymOwnerName"));
                    gymOwner.setGymOwnerAddress(rs.getString("gymOwnerAddress"));
                    gymOwner.setGender(rs.getString("gender"));
                    gymOwner.setAge(rs.getInt("age"));
                    gymOwner.setContactNumber(rs.getInt("contactNumber"));
                    gymOwner.setGstNumber(rs.getString("gstNumber"));
                    gymOwner.setAdharCardNumber(rs.getString("aadharCardNumber"));
                    gymOwner.setVerified(rs.getBoolean("isVerified"));

                    gymOwners.add(gymOwner);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymOwners;
    }
    public List<GymOwner> viewApprovedListofGymOwners() {
        List<GymOwner> gymOwners = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + GYM_OWNERS_TABLE + " WHERE isVerified = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(selectQuery)) {

            stmt.setBoolean(1, true); // Assuming isVerified = false for pending gym owners

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    GymOwner gymOwner = new GymOwner();
                    gymOwner.setGymOwnerId(rs.getInt("gymOwnerId"));
                    gymOwner.setGymOwnerName(rs.getString("gymOwnerName"));
                    gymOwner.setGymOwnerAddress(rs.getString("gymOwnerAddress"));
                    gymOwner.setGender(rs.getString("gender"));
                    gymOwner.setAge(rs.getInt("age"));
                    gymOwner.setContactNumber(rs.getInt("contactNumber"));
                    gymOwner.setGstNumber(rs.getString("gstNumber"));
                    gymOwner.setAdharCardNumber(rs.getString("aadharCardNumber"));
                    gymOwner.setVerified(rs.getBoolean("isVerified"));

                    gymOwners.add(gymOwner);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymOwners;
    }

    public boolean deleteGymOwner(int gymOwnerId) {
        String deleteQuery = "DELETE FROM " + GYM_OWNERS_TABLE + " WHERE gymOwnerId = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(deleteQuery)) {

            stmt.setInt(1, gymOwnerId);

            int i = stmt.executeUpdate();
            System.out.println(i + " Gym Owner deleted");
            return true ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false ;
    }





}

