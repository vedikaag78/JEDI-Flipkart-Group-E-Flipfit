package com.flipkart.restcontroller;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.business.AdminBusiness;
import com.flipkart.model.GymOwner;
import com.flipkart.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * REST controller for handling admin-related operations.
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminController {
    // Instance of AdminBusiness to handle business logic
    private final AdminBusiness adminBusiness = new AdminBusiness();

    /**
     * Endpoint to handle admin login.
     *
     * @param user The user object containing email and password.
     * @return Response indicating success or failure of the login operation.
     */
    @POST
    @Path("/login")
    @Timed
    public Response loginAdmin(User user) {
        if (adminBusiness.validateAdmin(user.getEmailId(), user.getPassword())) {
            return Response.ok("Successfully logged in").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Credentials").build();
        }
    }

    /**
     * Endpoint to approve a gym owner.
     *
     * @param gymOwnerId The ID of the gym owner to be approved.
     * @return Response indicating success or failure of the approval operation.
     */
    @POST
    @Path("/gym-owner/approve")
    @Timed
    public Response approveGymOwner(@QueryParam("gymOwnerId") int gymOwnerId) {
        if (adminBusiness.approveGymOwner(gymOwnerId)) {
            return Response.ok("Gym Owner is Successfully Verified").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Gym Owner Verification Failed...\n\t--> Please Enter a Valid Gym Owner Id.")
                    .build();
        }
    }

    /**
     * Endpoint to view pending gym owner approval requests.
     *
     * @return Response containing the list of pending gym owner requests.
     */
    @GET
    @Path("/gym-owner/pending")
    @Timed
    public Response viewPendingGymOwnerRequests() {
        List<GymOwner> pendingGymOwnerList = adminBusiness.viewPendingGymOwners();
        return Response.ok(pendingGymOwnerList).build();
    }
}
