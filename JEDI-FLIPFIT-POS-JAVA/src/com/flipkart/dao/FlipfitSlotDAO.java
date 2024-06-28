/**
 * 
 */
package com.flipkart.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import com.flipkart.bean.Slot;

/**
 * 
 */
public class FlipfitSlotDAO implements FlipfitSlotDAOInterface{
	public List<Slot> getSlotList() {
		List<Slot> slotList = new ArrayList<>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Flipfit_schema","root","mysqlPassword");  
			String sql="SELECT * FROM Slots"; 
			PreparedStatement stmt=con.prepareStatement(sql);  
			ResultSet rs = stmt.executeQuery();
			// Process the ResultSet to populate the slotList
            while (rs.next()) {
                // Retrieve slot details from ResultSet and create Slot object
                Slot slot = new Slot();
             // Adjust column name and type as per your schema
                slot.setSlotId(rs.getInt("slotId")); 
                slot.setStartTime(rs.getTime("startTime").toLocalTime()); 
                slot.setEndTime(rs.getTime("endTime").toLocalTime()); 
                // Set other properties as needed

                // Add Slot object to the list
                slotList.add(slot);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);// Handle or log the exception as per your application's requirements
        }
		return slotList;
	}
	
	public List<Slot> getAvailableSlotList (LocalTime startTime, LocalTime endTime) {
		List<Slot> slotList = new ArrayList<>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Flipfit_schema","root","mysqlPassword");  
			String sql="SELECT * FROM Slot WHERE startTime >= ? AND endTime <= ?"; 
			PreparedStatement stmt=con.prepareStatement(sql);  
			stmt.setTime(1, Time.valueOf(startTime));
            stmt.setTime(2, Time.valueOf(endTime));
			ResultSet rs = stmt.executeQuery();
			// Process the ResultSet to populate the slotList
            while (rs.next()) {
                // Retrieve slot details from ResultSet and create Slot object
            	Slot slot = new Slot();
                slot.setSlotId(rs.getInt("slotId"));
                slot.setStartTime(rs.getTime("startTime").toLocalTime());
                slot.setEndTime(rs.getTime("endTime").toLocalTime());
                // Set other properties as needed

                // Add Slot object to the list
                slotList.add(slot);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);// Handle or log the exception as per your application's requirements
        }
		return slotList;
	}

}
