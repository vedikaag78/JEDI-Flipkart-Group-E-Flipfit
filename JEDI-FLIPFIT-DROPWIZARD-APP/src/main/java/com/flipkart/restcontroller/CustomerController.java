package com.flipkart.restcontroller;



import com.flipkart.business.CustomerBusiness;
import com.flipkart.model.Customer;
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

    // api test done
    @POST
    @Path("/login")
    public Response loginCustomer(@QueryParam("email") String email, @QueryParam("password") String password) {
        int CustId = customerBusiness.validateCustomer(email, password);
        if (CustId > 0) {
            return Response.ok("Successfully Logged In").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }

    /* api test not done , cause unsure of how customer object is getting passed
        body ko json mai parse karke bhej rahe kya ?
        query se toh bahot bada link ban jayega
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

     // api test done
    @GET
    @Path("/getCustomerID/{userID}")
    public Response getCustomerIdByUserId(  @PathParam("userID") int userID ) {
        int custId = customerBusiness.getCustomerId(userID);
        if (custId > 0) {
            return Response.ok("Customer ID: "+custId).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).entity("Invalid UserID").build();
        }


    }

    // api test done

    @GET
    @Path("/getCustomer/{custID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("custID") int userID) {
       Customer customer = customerBusiness.getCustomerByCustomerId(userID);
       if (customer != null) {
           // return the entire object as JSON
           return Response.ok("Customer Details: "+ customer.getCustomerName() ).build();
       }
       else{
           return Response.status(Response.Status.NOT_FOUND).entity("Invalid custID").build();
       }
    }


}

