/**
 *
 */
package com.flipkart.business;
import com.flipkart.model.*;
import com.flipkart.dao.FlipfitCustomerDAOImpl;
import com.flipkart.dao.FlipfitGymBookingDAOImpl;
import com.flipkart.dao.FlipfitGymCenterDAOImpl;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
public class CustomerBusiness {
    private FlipfitCustomerDAOImpl customerDAO = new FlipfitCustomerDAOImpl();
    private FlipfitGymCenterDAOImpl gymCenterDAO = new FlipfitGymCenterDAOImpl();
    private FlipfitGymBookingDAOImpl bookingDAO = new FlipfitGymBookingDAOImpl();

    public int validateCustomer(String emailId, String password){
        int userId = customerDAO.isValidGymCustomer(emailId, password);
        return (userId!=-1 ? customerDAO.getCustomerId(userId) : -1);
    }

    public Customer getCustomerByCustomerId(int userId){
        return customerDAO.getCustomerByCustomerId(userId);
    }

    public boolean createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    public List<GymCenter> getAllGymCenters(){
        return gymCenterDAO.viewAllGym();
    }

    public List<Slot> getAllSlotsByCenterId(int centerId){
       return gymCenterDAO.getAllSlotByGymCenterId(centerId);
    }

    public Response bookSlot(Schedule schedule, int customerId){
        if(!bookingDAO.checkSchedule(schedule)){
            int capacity = gymCenterDAO.getGymCapacity(schedule.getGymCenterId());
            if(capacity < 0) Response.status(Response.Status.NOT_FOUND).entity("Unable to book").build();;
            bookingDAO.createSchedule(schedule, capacity);
        }

        int scheduleId = bookingDAO.getScheduleId(schedule);
        System.out.println(scheduleId);
        if(scheduleId == -1 || !bookingDAO.decrementAvailableSeat(scheduleId))
            return Response.status(Response.Status.NOT_FOUND).entity("No Available seat...").build();

        Booking booking = new Booking();
        booking.setCustomerId(customerId);
        booking.setScheduleId(scheduleId);
        if(bookingDAO.createBooking(booking))
            return Response.ok("Slot booked Successfully").build();
        else return Response.status(Response.Status.NOT_FOUND).entity("Opps!! Failed to book slot").build();
    }
}
