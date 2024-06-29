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

import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

public class FlipfitGymBookingDAOImpl implements FlipfitGymBookingDAOInterface {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_schema";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Fk!@#%215040";

    public boolean checkSchedule(Schedule schedule){
        boolean isPresent = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement checkForScheduleStmt = connection.prepareStatement(
                    "SELECT COUNT(*) AS cnt FROM schedules WHERE slotId = ? AND scheduleDate = ?;");

            checkForScheduleStmt.setInt(1, schedule.getSlotId());
            checkForScheduleStmt.setDate(2, Date.valueOf(schedule.getScheduleDate()));

            ResultSet queryResult = checkForScheduleStmt.executeQuery();

            if(queryResult.next()) isPresent = queryResult.getInt("cnt")>0;
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isPresent;
    }


    public boolean createSchedule(Schedule schedule, int availableSeats){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement createScheduleStmt = connection.prepareStatement(
                    "INSERT INTO schedules (gymCenterId, slotId, ScheduleDate, availability)\n" +
                            "VALUES (?, ?, ?, ?);");

            createScheduleStmt.setInt(1, schedule.getGymCenterId());
            createScheduleStmt.setInt(2, schedule.getSlotId());
            createScheduleStmt.setDate(3, Date.valueOf(schedule.getScheduleDate()));
            createScheduleStmt.setInt(4, availableSeats);

            createScheduleStmt.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
