package com.flipkart.restcontroller;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.business.AdminBusiness;
import com.flipkart.model.GymOwner;
import com.flipkart.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminController {
    private final AdminBusiness adminBusiness = new AdminBusiness();

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

    @GET
    @Path("/gym-owner/pending")
    @Timed
    public Response viewPendingGymOwnerRequests() {
        List<GymOwner> pendingGymOwnerList = adminBusiness.viewPendingGymOwners();
        return Response.ok(pendingGymOwnerList).build();
    }
}

