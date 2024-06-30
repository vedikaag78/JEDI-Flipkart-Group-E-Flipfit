/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Schedule;
import com.flipkart.bean.Slot;

public class FlipfitGymBookingDAOImpl implements FlipfitGymBookingDAOInterface {
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
            e.printStackTrace();
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

            int rowsAffected = createScheduleStmt.executeUpdate();
            connection.close();
            return (rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public int getScheduleId(Schedule schedule){
        int scheduleId = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getScheduleIdStmt = connection.prepareStatement(
                    "SELECT scheduleId FROM schedules WHERE slotId = ? AND scheduleDate = ?;");

            getScheduleIdStmt.setInt(1, schedule.getSlotId());
            getScheduleIdStmt.setDate(2, Date.valueOf(schedule.getScheduleDate()));

            ResultSet queryResult = getScheduleIdStmt.executeQuery();

            if(queryResult.next()) scheduleId = queryResult.getInt("scheduleId");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleId;
    }

    public List<Booking> getAllBookingsByCustomerId(int customerId){
        List<Booking> bookingList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getAllBookingsStmt = connection.prepareStatement(
                    "SELECT * FROM bookings WHERE customerId = ?;");

            getAllBookingsStmt.setInt(1,customerId);

            ResultSet queryResult = getAllBookingsStmt.executeQuery();
            while (queryResult.next()) {
                Booking booking = new Booking();
                booking.setBookingId(queryResult.getInt("bookingId"));
                booking.setScheduleId(queryResult.getInt("scheduleId"));
                booking.setCustomerId(queryResult.getInt("customerId"));
                bookingList.add(booking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public Schedule getBookingSchedule(Booking booking){
        Schedule schedule = new Schedule();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getScheduleStmt = connection.prepareStatement(
                    "SELECT * FROM schedules WHERE scheduleId = ?;");

            getScheduleStmt.setInt(1,booking.getScheduleId());

            ResultSet queryResult = getScheduleStmt.executeQuery();
            if (queryResult.next()) {
               schedule.setScheduleDate(queryResult.getDate("scheduleDate").toLocalDate());
               schedule.setAvailablity(queryResult.getInt("availability"));
               schedule.setGymCenterId(queryResult.getInt("gymCenterId"));
               schedule.setSlotId(queryResult.getInt("slotId"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedule;
    }

    public Slot getBookingSlot(Schedule schedule){
        Slot slot = new Slot();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement getSlotStmt = connection.prepareStatement(
                    "SELECT * FROM Slots WHERE slotId = ?;");

            getSlotStmt.setInt(1, schedule.getSlotId());
            ResultSet queryResult = getSlotStmt.executeQuery();
            if (queryResult.next()) {
                slot.setSlotId(queryResult.getInt("slotId"));
                slot.setStartTime(queryResult.getString("startTime"));
                slot.setEndTime(queryResult.getString("endTime"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slot;
    }

    public boolean decrementAvailableSeat(int scheduleId){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement decrementAvailableSeatStmt = connection.prepareStatement(
                    "UPDATE schedules SET availability = availability - 1 WHERE scheduleId = ? AND availability > 0;");

            decrementAvailableSeatStmt.setInt(1, scheduleId);
            int rowsAffected = decrementAvailableSeatStmt.executeUpdate();
            return (rowsAffected>0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createBooking(Booking booking){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Gm!@#%215035");

            PreparedStatement decrementAvailableSeatStmt = connection.prepareStatement(
                    "INSERT INTO bookings (scheduleId, customerId)\n" +
                            "VALUES (?, ?);\n");

            decrementAvailableSeatStmt.setInt(1, booking.getScheduleId());
            decrementAvailableSeatStmt.setInt(2, booking.getCustomerId());

            int rowsAffected = decrementAvailableSeatStmt.executeUpdate();
            return (rowsAffected>0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
