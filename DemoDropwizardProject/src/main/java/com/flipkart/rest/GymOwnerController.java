package com.flipkart.rest;

import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerService;
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
@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerController {
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    Validator validator;
    GymOwnerService gymOwnerService;

    public GymOwnerController(Validator validator, GymOwnerService gymOwnerService) {
        this.validator = validator;
        this.gymOwnerService = gymOwnerService;
    }

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Login for gym owners.
     *
     * @param credentials The gym owner credentials.
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
        if(gymOwnerService.validateLogin(credentials.getUser(),credentials.getPassword())){
            return Response.ok(jwtToken).build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    /**
     * Add a gym with available slots.
     *
     * @param gym The gym information.
     * @return A Response indicating the success of gym addition.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addgymwithslots")
    public Response addGymWithSlots(Gym gym,@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        gymOwnerService.addGymWithSlots(gym);
        return Response.ok().build();
    }

    /**
     * Create a new gym owner.
     *
     * @param gymOwner The gym owner information.
     * @return A Response indicating the success of gym owner creation.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createGymOwner(GymOwner gymOwner){
        gymOwnerService.createGymOwner(gymOwner);
        return Response.ok().build();
    }

    /**
     * View gyms owned by a gym owner.
     *
     * @param id The ID of the gym owner.
     * @return A Response containing a list of gyms owned by the gym owner.
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/viewMyGyms/{id}")
    public Response viewMyGyms(@PathParam("id") String id,@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<Gym> gymList = gymOwnerService.viewMyGyms(id);
        return Response.ok(gymList).build();
    }
}
