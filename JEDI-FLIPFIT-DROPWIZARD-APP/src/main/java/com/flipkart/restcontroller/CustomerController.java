package com.flipkart.restcontroller;



import com.flipkart.business.CustomerBusiness;
import com.flipkart.model.Customer;
import com.flipkart.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    private CustomerBusiness customerBusiness = new CustomerBusiness();

    @GET
    @Path("/test")
    public Response testFunc( ) {
        return Response.ok("Able to hit routes").build();
    }

    @POST
    @Path("/login")
    public Response loginCustomer(User user) {
        int CustId = customerBusiness.validateCustomer(user.getEmailId(), user.getPassword());
        if (CustId > 0) {
            return Response.ok("Successfully Logged In").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }

    @POST
    @Path("/register")
    public Response registerCustomer(Customer customer) {

        boolean isCreated = customerBusiness.createCustomer(customer);
        if (isCreated) {
            return Response.ok("Customer Registered Successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to Register Customer").build();
        }
    }

    @GET
    @Path("/profile/{custID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("custID") int userID) {
       Customer customer = customerBusiness.getCustomerByCustomerId(userID);
       if (customer != null) {
           // return the entire object as JSON
           return Response.ok(customer).build();
       }
       else{
           return Response.status(Response.Status.NOT_FOUND).entity("Invalid custID").build();
       }
    }
}

