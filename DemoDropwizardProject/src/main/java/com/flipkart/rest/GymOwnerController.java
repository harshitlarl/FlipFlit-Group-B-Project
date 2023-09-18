package com.flipkart.rest;

import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerService;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerController {
    Validator validator;
    GymOwnerService gymOwnerService;

    public GymOwnerController(Validator validator, GymOwnerService gymOwnerService) {
        this.validator = validator;
        this.gymOwnerService = gymOwnerService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Credentials credentials){
        if(gymOwnerService.validateLogin(credentials.getUser(), credentials.getPassword())){
            return Response.ok().build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addgymwithslots")
    public Response addGymWithSlots(Gym gym){
        gymOwnerService.addGymWithSlots(gym);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createGymOwner(GymOwner gymOwner){
        gymOwnerService.createGymOwner(gymOwner);
        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/viewMyGyms/{id}")
    public Response viewMyGyms(@PathParam("id") String id){
        List<Gym> gymList = gymOwnerService.viewMyGyms(id);
        return Response.ok(gymList).build();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/viewMyGyms/{id}")
//    public Response updateGymOwnerPassword(@PathParam("id") String id){
//        gymOwnerService.viewMyGyms(id);
//        return Response.ok().build();
//    }



}
