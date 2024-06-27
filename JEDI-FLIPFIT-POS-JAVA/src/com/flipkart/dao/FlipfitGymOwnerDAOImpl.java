/**
 *
 */
package com.flipkart.dao;
import com.flipkart.bean.GymCenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 Remaining :
 1) Rewrite GYM_TABLE as the gym_table used in db
 2) Rewrite the relevant password
 */

public class FlipfitGymOwnerDAOImpl implements FlipfitGymOwnerDAOInterface{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_schema";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";
    private static final String GYM_TABLE = "gym_details";


    public void addGymDetails(GymCenter gymCenter) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "12345678");
            PreparedStatement stmt = con.prepareStatement("insert into tablename values(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, gymCenter.getGymCenterId());
            stmt.setInt(2,gymCenter.getGymOwnerId() );
            stmt.setString(3,gymCenter.getGymCenterName() );
            stmt.setString(4,gymCenter.getAddress() );
            stmt.setString(5,gymCenter.getCity() );
            stmt.setInt(6, gymCenter.getPrice());
            stmt.setInt(7, gymCenter.getCapacity());
          /* Logic to add slot ids as input
          for (int i = 0 ; i < gymCenter.getSlotListIds().size(); i++) {

          }

          stmt.setArrayList(8 , gymCenter.setSlotListIds());
           */

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
/*
Logic to update Array of slots
 */
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addSlots (GymCenter gymCenter) {
        

    }






}



