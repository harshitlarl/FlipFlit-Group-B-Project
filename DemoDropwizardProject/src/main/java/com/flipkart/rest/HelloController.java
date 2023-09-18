package com.flipkart.rest;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {

    @GET
    public String getEmployees() {
        return "my dropwizard service";
    }

}