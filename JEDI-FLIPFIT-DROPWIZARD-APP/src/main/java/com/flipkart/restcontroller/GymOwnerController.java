package com.flipkart.restcontroller;

//import com.flipkart.model.GymCenter;
//import com.flipkart.model.GymOwner;
//import com.flipkart.model.Slot;
//import com.flipkart.model.GymCenterBusiness;
//import com.flipkart.model.GymOwnerBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gymOwner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymOwnerController {
//    private GymOwnerBusiness gymOwnerBusiness;
//    private GymCenterBusiness gymCenterBusiness;
//
//    public GymOwnerResource(GymOwnerBusiness gymOwnerBusiness, GymCenterBusiness gymCenterBusiness) {
//        this.gymOwnerBusiness = gymOwnerBusiness;
//        this.gymCenterBusiness = gymCenterBusiness;
//    }
//
//    @POST
//    @Path("/login")
//    public Response loginGymOwner(@QueryParam("email") String email, @QueryParam("password") String password) {
//        int gymOwnerId = gymOwnerBusiness.validateGymOwner(email, password);
//        if (gymOwnerId > 0) {
//            return Response.ok("Successfully Logged In").build();
//        } else {
//            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
//        }
//    }
//
//    @POST
//    @Path("/register")
//    public Response registerGymOwner(GymOwner gymOwner) {
//        gymOwner.setVerified(false);
//        boolean isCreated = gymOwnerBusiness.createGymOwner(gymOwner);
//        if (isCreated) {
//            return Response.ok("Gym Owner Registered Successfully").build();
//        } else {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to Register Gym Owner").build();
//        }
//    }
//
//    @GET
//    @Path("/{gymOwnerId}/centers")
//    public Response viewAllGymCenters(@PathParam("gymOwnerId") int gymOwnerId) {
//        List<GymCenter> gymCenters = gymOwnerBusiness.getAllGymCenterByGymOwnerId(gymOwnerId);
//        return Response.ok(gymCenters).build();
//    }
//
//    @POST
//    @Path("/addSlot")
//    public Response addSlotToGymCenter(Slot slot) {
//        gymOwnerBusiness.addSlotWithGymID(slot);
//        return Response.ok("Slot Successfully Created").build();
//    }
//
//    @POST
//    @Path("/{gymOwnerId}/addGymCenter")
//    public Response addGymCenter(@PathParam("gymOwnerId") int gymOwnerId, GymCenter gymCenter) {
//        gymCenterBusiness.createGymCenter(gymCenter, gymOwnerId);
//        return Response.ok("Gym Center Added Successfully").build();
//    }
}
