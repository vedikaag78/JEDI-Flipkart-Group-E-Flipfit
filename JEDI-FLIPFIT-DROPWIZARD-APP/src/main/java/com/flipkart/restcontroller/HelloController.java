package com.flipkart.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloApi")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {
    @GET
    @Path("/helloService")
    public Response getHello() {

        return Response.ok("Hello My First fetch service").build();
    }
}