package com.flipkart.restcontroller;

import com.flipkart.business.CustomerBusiness;
import com.flipkart.model.Customer;
import com.flipkart.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST controller for handling customer-related operations.
 */
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    // Instance of CustomerBusiness to handle business logic
    private CustomerBusiness customerBusiness = new CustomerBusiness();

    /**
     * Endpoint to test if the routes are reachable.
     *
     * @return Response indicating the route is reachable.
     */
    @GET
    @Path("/test")
    public Response testFunc() {
        return Response.ok("Able to hit routes").build();
    }

    /**
     * Endpoint to handle customer login.
     *
     * @param user The user object containing email and password.
     * @return Response indicating success or failure of the login operation.
     */
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

    /**
     * Endpoint to register a new customer.
     *
     * @param customer The customer object containing registration details.
     * @return Response indicating success or failure of the registration operation.
     */
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

    /**
     * Endpoint to get customer details by customer ID.
     *
     * @param userID The ID of the customer to retrieve.
     * @return Response containing the customer details or an error message if not found.
     */
    @GET
    @Path("/profile/{custID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("custID") int userID) {
        Customer customer = customerBusiness.getCustomerByCustomerId(userID);
        if (customer != null) {
            // Return the entire object as JSON
            return Response.ok(customer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Invalid custID").build();
        }
    }
}
