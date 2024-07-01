package com.flipkart.dao;

import com.flipkart.model.GymCenter;
import com.flipkart.model.Slot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class for managing gym center-related functionalities in the Flipfit application.
 */
public class FlipfitGymCenterDAOImpl implements FlipfitGymCenterDAOInterface {

    /**
     * Adds a new time slot associated with a gym center to the database.
     *
     * @param slot the Slot object containing slot details to be added
     * @return true if the slot was successfully added, false otherwise
     */
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

    /**
     * Retrieves all time slots associated with a specific gym center from the database.
     *
     * @param gymCenterId the ID of the gym center for which to retrieve slots
     * @return a list of Slot objects representing all slots of the gym center,
     *         or null if an error occurs during database access
     */
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

    /**
     * Retrieves a list of all verified gym centers from the database.
     *
     * @return a list of GymCenter objects representing all verified gym centers,
     *         or null if an error occurs during database access
     */
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

    /**
     * Retrieves the capacity of a gym center based on the provided gym center ID.
     *
     * @param gymCenterId the ID of the gym center for which to retrieve capacity
     * @return the capacity of the gym center if found, or -1 if not found or an error occurs
     */
    public int getGymCapacity(int gymCenterId){
        int gymCapacity = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getAvailableSeatsStmt = connection.prepareStatement(
                    "SELECT capacity FROM GymCenters WHERE gymCenterId = ?;");

            getAvailableSeatsStmt.setInt(1,gymCenterId);
            ResultSet queryResult = getAvailableSeatsStmt.executeQuery();
            gymCapacity = (queryResult.next() ? queryResult.getInt("capacity") : -1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gymCapacity;
    }

    /**
     * Creates a new gym center record in the database.
     *
     * @param gymCenter the GymCenter object containing the details to be inserted
     * @param gymOwnerId the ID of the gym owner associated with the gym center
     * @return true if the gym center was successfully created, false otherwise
     */
    public boolean createGymCenter(GymCenter gymCenter,int gymOwnerId){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");
            PreparedStatement insertGymCenterStmt = connection.prepareStatement(
                    "INSERT INTO GymCenters ("+
                            "gymOwnerId, " +
                            "gymCenterName, " +
                            "address, " +
                            "city, " +
                            "price, " +
                            "capacity) " +
                            "VALUES (?,?, ?, ?, ?, ?);"
            );
            insertGymCenterStmt.setInt(1, gymOwnerId);
            insertGymCenterStmt.setString(2, gymCenter.getGymCenterName());
            insertGymCenterStmt.setString(3, gymCenter.getAddress());
            insertGymCenterStmt.setString(4, gymCenter.getCity());
            insertGymCenterStmt.setInt(5, gymCenter.getPrice());
            insertGymCenterStmt.setInt(6, gymCenter.getCapacity());

            int rowsAffected = insertGymCenterStmt.executeUpdate();
            insertGymCenterStmt.close();

            connection.close();
            return (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
