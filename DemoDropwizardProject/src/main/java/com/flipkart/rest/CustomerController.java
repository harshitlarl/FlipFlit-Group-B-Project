package com.flipkart.rest;


import com.flipkart.bean.Bookings;
import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.UserServices;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {
    Validator validator;
    UserServices userServices;

    public CustomerController(Validator validator, UserServices userServices) {
        this.validator = validator;
        this.userServices = userServices;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Credentials credentials){
        if(userServices.validateUser(credentials.getUser(),credentials.getPassword())){
            return Response.ok().build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/viewAllGymswithSlots")
    public Response viewAllGymswithSlots(){
        List<Gym> gymList = userServices.getAllGymsWithSlots();
        if(gymList != null)
        return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bookSlot/gymId/{id}/time/{time}/email/{email}")
    public Response bookSlot(@PathParam("id") Integer gymId, @PathParam("time") Integer time,@PathParam("email") String email){
        boolean booked = userServices.bookSlots(gymId, time, email);
        if(booked)
            return Response.ok().build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cancelSlot/{id}")
    public Response cancelSlot(@PathParam("id") Integer id){
        boolean booked = userServices.cancelSlots(id);
        if(booked)
            return Response.ok().build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllBookings/{id}")
    public Response getAllBookings(@PathParam("id") String id){
        List<Bookings> myBookings = userServices.getAllBookings(id);
        if(!myBookings.isEmpty())
            return Response.ok(myBookings).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/viewAllGymsByArea/{area}")
    public Response viewAllGymsByArea(@PathParam("area") String area){
        List<Gym> gymList = userServices.getAllGymsByArea(area);
        if(gymList != null)
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCustomer(User user){
        userServices.createUser(user);
        return Response.ok().build();
    }

}
