/**
 *
 */
package com.flipkart.dao;
import com.flipkart.bean.GymCenter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/*
Functions Implemented :
1. addGymDetails
2. updateGymDetails
3. getAllGymCCenters
4. deleteGymDetails
 */
/*
 Note :
 1) Rewrite GYM_TABLE as the gym_table used in db
 2) Rewrite the relevant password
 */

public abstract class FlipfitGymOwnerDAOImpl implements FlipfitGymOwnerDAOInterface{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_schema";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";
    private static final String GYM_TABLE = "GymCenters";


    public void addGymDetails(GymCenter gymCenter) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "12345678");
            PreparedStatement stmt = con.prepareStatement("insert into GymCenters values(?,?,?,?,?,?,?)");
            stmt.setInt(1, gymCenter.getGymCenterId());
            stmt.setInt(2,gymCenter.getGymOwnerId() );
            stmt.setString(3,gymCenter.getGymCenterName() );
            stmt.setString(4,gymCenter.getAddress() );
            stmt.setString(5,gymCenter.getCity() );
            stmt.setInt(6, gymCenter.getPrice());
            stmt.setInt(7, gymCenter.getCapacity());


            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Better exception handling/logging
        }

    }

    public void updateGymDetails(GymCenter gymCenter) {
        String updateQuery = "UPDATE " + GYM_TABLE + " SET gymOwnerId = ?, gymCenterName = ?, address = ?, city = ?, price = ?, capacity = ? WHERE gymCenterId = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(updateQuery)) {

            stmt.setInt(1, gymCenter.getGymOwnerId());
            stmt.setString(2, gymCenter.getGymCenterName());
            stmt.setString(3, gymCenter.getAddress());
            stmt.setString(4, gymCenter.getCity());
            stmt.setInt(5, gymCenter.getPrice());
            stmt.setInt(6, gymCenter.getCapacity());
            stmt.setInt(7, gymCenter.getGymCenterId());

            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GymCenter> getAllGymCenters(int gymOwnerId) {

        List<GymCenter> gymCenters = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + GYM_TABLE + " WHERE gymOwnerId = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(selectQuery)) {

            stmt.setInt(1, gymOwnerId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    GymCenter gymCenter = new GymCenter();
                    gymCenter.setGymCenterId(rs.getInt("gymCenterId"));
                    gymCenter.setGymOwnerId(rs.getInt("gymOwnerId"));
                    gymCenter.setGymCenterName(rs.getString("gymCenterName"));
                    gymCenter.setAddress(rs.getString("address"));
                    gymCenter.setCity(rs.getString("city"));
                    gymCenter.setPrice(rs.getInt("price"));
                    gymCenter.setCapacity(rs.getInt("capacity"));

                    gymCenters.add(gymCenter);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gymCenters;

    }




    public void deleteGymDetails(GymCenter gymCenter) {
        String deleteQuery = "DELETE FROM " + GYM_TABLE + " WHERE gymCenterId = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(deleteQuery)) {

            stmt.setInt(1, gymCenter.getGymCenterId());

            int i = stmt.executeUpdate();
            System.out.println(i + " records deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}



