/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Slot;

public class FlipfitGymBookingDAOImpl implements FlipfitGymBookingDAOInterface {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_schema";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Fk!@#%215040";

    @Override
    public List<Object> findSlotsbygymId(int id) {
        List<Object> slots = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver (not needed for newer JDBC versions)
            // Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Step 3: Prepare SQL statement to fetch gymCenter data
            String sql = "SELECT * FROM GymCenter WHERE gymCenterId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            // Step 4: Execute query and process result set
            rs = stmt.executeQuery();
            if (rs.next()) {
                // Retrieve slotListIds from GymCenter
                ArrayList<Integer> slotIds = deserializeSlotIds(rs.getString("slotListIds"));
                
                // Step 5: Fetch Slot objects corresponding to slotIds
                for (Integer slotId : slotIds) {
                    Slot slot = findSlotById(conn, slotId);
                    if (slot != null) {
                        slots.add(slot);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly in a real application
        } finally {
            // Step 6: Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return slots;
    }

    // Helper method to deserialize slotListIds stored as a string in the database
    private ArrayList<Integer> deserializeSlotIds(String slotListIdsString) {
        ArrayList<Integer> slotIds = new ArrayList<>();
        if (slotListIdsString != null && !slotListIdsString.isEmpty()) {
            String[] parts = slotListIdsString.split(",");
            for (String part : parts) {
                slotIds.add(Integer.parseInt(part.trim()));
            }
        }
        return slotIds;
    }

    // Helper method to find Slot by slotId
    private Slot findSlotById(Connection conn, int slotId) throws SQLException {
        Slot slot = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Prepare SQL statement to fetch slot details
            String sql = "SELECT * FROM Slot WHERE slotId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, slotId);

            // Execute query and process result set
            rs = stmt.executeQuery();
            if (rs.next()) {
                slot = new Slot();
                slot.setSlotId(rs.getInt("slotId"));
                slot.setStartTime(rs.getTime("startTime").toLocalTime());
                slot.setEndTime(rs.getTime("endTime").toLocalTime());
            }
        } finally {
            // Close resources
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }

        return slot;
    }
}
