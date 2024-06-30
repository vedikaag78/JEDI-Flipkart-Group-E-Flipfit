package com.flipkart.dao;

/**
 * 
 */
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipfitGymCenterDAOImpl implements FlipfitGymCenterDAOInterface {

    public boolean addSlotWithGymID(Slot slot){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement addSlotStmt = connection.prepareStatement(
                    "INSERT INTO slots(gymCenterId, startTime, endTime)\n" +
                            "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            addSlotStmt.setInt(1, slot.getGymCenterId());
            addSlotStmt.setString(2, slot.getStartTime());
            addSlotStmt.setString(3, slot.getEndTime());
            int rowsAffected = addSlotStmt.executeUpdate();
            connection.close();

            return (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Slot> getAllSlotByGymCenterId(int gymCenterId){
        List<Slot> slotList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getGymCenterStmt = connection.prepareStatement(
                    "SELECT * FROM Slots WHERE gymCenterId = ?;");

            getGymCenterStmt.setInt(1,gymCenterId);
            ResultSet queryResult = getGymCenterStmt.executeQuery();

            while (queryResult.next()) {
                Slot slot = new Slot();
                slot.setSlotId(queryResult.getInt("slotId"));
                slot.setStartTime(queryResult.getString("startTime"));
                slot.setEndTime(queryResult.getString("endTime"));
                slot.setGymCenterId(gymCenterId);
                slotList.add(slot);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return slotList;
    }

    public List<GymCenter> viewAllGym(){
        List<GymCenter> gymCenterList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getGymCenterStmt = connection.prepareStatement(
                    "SELECT gc.*\n" +
                            "FROM gymCenters gc\n" +
                            "JOIN gymOwners go ON gc.gymOwnerId = go.gymOwnerId\n" +
                            "WHERE go.isVerified = TRUE;");

            ResultSet queryResult = getGymCenterStmt.executeQuery();

            while (queryResult.next()) {
                GymCenter gymCenter = new GymCenter();
                gymCenter.setGymCenterId(queryResult.getInt("gymCenterId"));
                gymCenter.setGymCenterName(queryResult.getString("gymCenterName"));
                gymCenter.setAddress(queryResult.getString("address"));
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

    public int getGymCapacity(int gymCenterId){
        int getGymCapacity = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getAvailableSeatsStmt = connection.prepareStatement(
                    "SELECT capacity FROM GymCenters WHERE gymCenterId = ?;");

            getAvailableSeatsStmt.setInt(1,gymCenterId);
            ResultSet queryResult = getAvailableSeatsStmt.executeQuery();
            getGymCapacity = (queryResult.next() ? queryResult.getInt("capacity") : -1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getGymCapacity;
    }
}
