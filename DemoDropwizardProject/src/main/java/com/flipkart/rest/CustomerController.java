package com.flipkart.rest;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.business.UserServices;
import com.flipkart.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.security.Key;
import java.util.Date;
import java.util.List;

/**
 * Author: bhavya.khandelwal
 */


@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {

    // Secret key to sign the JWT
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // JWT expiration time (in milliseconds)
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    Validator validator;
    UserServices userServices;



    public CustomerController(Validator validator, UserServices userServices) {
        this.validator = validator;
        this.userServices = userServices;
    }

    /**
     * Login for customers.
     *
     * @param credentials The user credentials.
     * @return A Response indicating login success or failure.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Credentials credentials){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
        String jwtToken = Jwts.builder()
                .setSubject(credentials.getUser())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SECRET_KEY)
                .compact();
        if(userServices.validateUser(credentials.getUser(),credentials.getPassword())){
            return Response.ok(jwtToken).build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    /**
     * View all gyms with available slots.
     *
     * @return A Response containing a list of gyms with slots.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/viewAllGymswithSlots")
    public Response viewAllGymswithSlots(@HeaderParam("Authorization") String token){

        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<Gym> gymList = userServices.getAllGymsWithSlots();
        if(gymList != null)
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * Book a slot at a gym.
     *
     * @param gymId The ID of the gym.
     * @param time The time slot to book.
     * @param email The email of the user booking the slot.
     * @return A Response indicating the booking status.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bookSlot/gymId/{id}/time/{time}/email/{email}")
    public Response bookSlot(@PathParam("id") Integer gymId, @PathParam("time") Integer time,@PathParam("email") String email, @HeaderParam("Authorization") String token){
        boolean booked = userServices.bookSlots(gymId, time, email);
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        if(booked)
            return Response.ok().build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * Cancel a booked slot.
     *
     * @param id The ID of the slot to cancel.
     * @return A Response indicating the cancellation status.
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cancelSlot/{id}")
    public Response cancelSlot(@PathParam("id") Integer id, @HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        boolean booked = userServices.cancelSlots(id);
        if(booked)
            return Response.ok().build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * Get all bookings for a user.
     *
     * @param id The ID of the user.
     * @return A Response containing a list of user bookings.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllBookings/{id}")
    public Response getAllBookings(@PathParam("id") String id, @HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<Bookings> myBookings = userServices.getAllBookings(id);
        if(!myBookings.isEmpty())
            return Response.ok(myBookings).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * View all gyms in a specific area.
     *
     * @param area The area name.
     * @return A Response containing a list of gyms in the specified area.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/viewAllGymsByArea/{area}")
    public Response viewAllGymsByArea(@PathParam("area") String area, @HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<Gym> gymList = userServices.getAllGymsByArea(area);
        if(gymList != null)
            return Response.ok(gymList).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * Create a new customer.
     *
     * @param user The user information.
     * @return A Response indicating the success of user creation.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCustomer(User user){
        userServices.createUser(user);
        return Response.ok().build();
    }
}
