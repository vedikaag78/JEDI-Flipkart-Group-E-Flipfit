package com.flipkart.restcontroller;

import com.flipkart.business.CustomerBusiness;
import com.flipkart.dao.FlipfitCustomerDAOImpl;
import com.flipkart.dao.FlipfitGymBookingDAOImpl;
import com.flipkart.dao.FlipfitGymCenterDAOImpl;
import com.flipkart.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/booking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingController {
    private CustomerBusiness customerBusiness = new CustomerBusiness();

    @GET
    @Path("/centers")
    public Response getAllCenters() {
        List<GymCenter> gymCenterList = customerBusiness.getAllGymCenters();
        return Response.ok(gymCenterList).build();
    }

    @GET
    @Path("/{centerId}/slots")
    public Response getAllSlots(@PathParam("centerId") int centerId) {
        List<Slot> slotList = customerBusiness.getAllSlotsByCenterId(centerId);
        return  Response.ok(slotList).build();
    }

    @POST
    @Path("/add/{customerId}/{centerId}/{slotId}")
    public Response addBooking(@PathParam("customerId") int customerId, @PathParam("centerId") int centerId, @PathParam("slotId") int slotId) {
        Schedule schedule = new Schedule();
        schedule.setGymCenterId(centerId);
        schedule.setSlotId(slotId);
        schedule.setScheduleDate(LocalDate.now());
        return customerBusiness.bookSlot(schedule, customerId);
    }
}

