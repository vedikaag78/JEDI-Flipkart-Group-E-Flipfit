/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;

/**
 * 
 */
public class FlipfitGymBookingDAOImpl implements FlipfitGymBookingDAOInterface{
	public void  addBooking(String userName, String date) {
        try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Flipfit_schema","root","mysqlPassword");  
			String sql="INSERT INTO bookings (userName, bookingDate) VALUES (?, ?)"; 
			PreparedStatement stmt=con.prepareStatement(sql);  
			// Set the parameters for the PreparedStatement
	        stmt.setString(1, userName);
	        stmt.setString(2, date);
	        stmt.executeUpdate();

	        // Close the statement and connection
	        stmt.close();
	        con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);// Handle or log the exception as per your application's requirements
        }

    }
	public List<Booking> viewBookingByCustomerId(String customerId) {
        List<Booking> allBookingList = new ArrayList<>();
        try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Flipfit_schema","root","mysqlPassword");  
			String sql="SELECT * FROM bookings WHERE customerId = ?"; 
			PreparedStatement stmt=con.prepareStatement(sql);  
			// Set the parameters for the PreparedStatement
			stmt.setString(1, customerId);
	       
			// Execute the query and get the ResultSet
	        ResultSet rs = stmt.executeQuery();

	        // Process the ResultSet to populate the allBookingList
	        while (rs.next()) {
	            Booking booking = new Booking();
	            // Adjust column names and types as per your schema
	            booking.setBookingId(rs.getInt("bookingId"));
	            booking.setCustomerId(Integer.parseInt(rs.getString("customerId")));
	            booking.setScheduleId(Integer.parseInt(rs.getString("ScheduleId")));
	            // Set other properties as needed

	            // Add the Booking object to the list
	            allBookingList.add(booking);
	        }

	        // Close the ResultSet, statement, and connection
	        rs.close();
	        stmt.close();
	        con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);// Handle or log the exception as per your application's requirements
        }catch(Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return allBookingList;
    }
	public void cancelBookingById(String bookingID) {
		 try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				  
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/Flipfit_schema","root","mysqlPassword");  
				String sql="DELETE FROM bookings WHERE bookingId = ?"; 
				PreparedStatement stmt=con.prepareStatement(sql);  
				// Set the parameters for the PreparedStatement
				stmt.setString(1, bookingID);
		        
		        stmt.executeUpdate();

		        // Close the statement and connection
		        stmt.close();
		        con.close();

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e);// Handle or log the exception as per your application's requirements
	        }
    }

}