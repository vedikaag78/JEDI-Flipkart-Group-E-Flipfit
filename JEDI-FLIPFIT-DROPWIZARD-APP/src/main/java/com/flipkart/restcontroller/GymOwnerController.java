package com.flipkart.restcontroller;

import com.flipkart.model.GymCenter;
import com.flipkart.model.GymOwner;
import com.flipkart.model.Slot;
import com.flipkart.business.GymCenterBusiness;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * REST controller for handling gym owner-related operations.
 */
@Path("/gymOwner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymOwnerController {

    // Instance of GymOwnerBusiness to handle gym owner business logic
    private GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();

    // Instance of GymCenterBusiness to handle gym center business logic
    private GymCenterBusiness gymCenterBusiness = new GymCenterBusiness();

    /**
     * Endpoint to handle gym owner login.
     *
     * @param user The user object containing email and password.
     * @return Response indicating success or failure of the login operation.
     */
    @POST
    @Path("/login")
    public Response loginGymOwner(User user) {
        int gymOwnerId = gymOwnerBusiness.validateGymOwner(user.getEmailId(), user.getPassword());
        if (gymOwnerId > 0) {
            return Response.ok("Successfully Logged In").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }

    /**
     * Endpoint to register a new gym owner.
     *
     * @param gymOwner The gym owner object containing registration details.
     * @return Response indicating success or failure of the registration operation.
     */
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(GymOwner gymOwner) {
        gymOwner.setVerified(false);
        boolean isCreated = gymOwnerBusiness.createGymOwner(gymOwner);
        System.out.println(gymOwner.getGymOwnerName());
        if (isCreated) {
            return Response.ok("Gym Owner Registered Successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to Register Gym Owner").build();
        }
    }

    /**
     * Endpoint to view all gym centers by gym owner ID.
     *
     * @param gymOwnerId The ID of the gym owner whose centers are to be retrieved.
     * @return Response containing the list of gym centers.
     */
    @GET
    @Path("/{gymOwnerId}/centers")
    public Response viewAllGymCenters(@PathParam("gymOwnerId") int gymOwnerId) {
        List<GymCenter> gymCenters = gymOwnerBusiness.getAllGymCenterByGymOwnerId(gymOwnerId);
        return Response.ok(gymCenters).build();
    }

    /**
     * Endpoint to add a slot to a gym center.
     *
     * @param slot The slot object containing slot details.
     * @return Response indicating success of the slot creation operation.
     */
    @POST
    @Path("/addSlot")
    public Response addSlotToGymCenter(Slot slot) {
        gymOwnerBusiness.addSlotWithGymID(slot);
        return Response.ok("Slot Successfully Created").build();
    }

    /**
     * Endpoint to add a gym center for a gym owner.
     *
     * @param gymOwnerId The ID of the gym owner.
     * @param gymCenter The gym center object containing gym center details.
     * @return Response indicating success of the gym center creation operation.
     */
    @POST
    @Path("/{gymOwnerId}/addGymCenter")
    public Response addGymCenter(@PathParam("gymOwnerId") int gymOwnerId, GymCenter gymCenter) {
        gymCenterBusiness.createGymCenter(gymCenter, gymOwnerId);
        return Response.ok("Gym Center Added Successfully").build();
    }
}
