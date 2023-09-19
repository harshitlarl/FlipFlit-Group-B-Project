package com.flipkart.rest;

import com.flipkart.bean.Credentials;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.AdminService;
import com.flipkart.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Author: bhavya.khandelwal
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // JWT expiration time (in milliseconds)
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    private Validator validator;
    private AdminService adminService;

    public AdminController(Validator validator, AdminService adminService){
        this.validator = validator;
        this.adminService = adminService;
    }

    /**
     * Login for admin.
     *
     * @param credentials The admin credentials.
     * @return A Response indicating success or failure.
     */
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials){

        Properties prop = new Properties(); // Properties is used to read files
        java.net.URL url = ClassLoader.getSystemResource("config.properties");
        try {
            prop.load(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String admin_id = prop.getProperty("admin_id");
        String admin_password = prop.getProperty("admin_password");

        if (credentials.getUser().equals(admin_id) && credentials.getPassword().equals(admin_password)){

            Date now = new Date();
            Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
            String jwtToken = Jwts.builder()
                    .setSubject(credentials.getUser())
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .signWith(SECRET_KEY)
                    .compact();

            return Response.ok(jwtToken).build();

        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();

    }

    /**
     * View Gym Owners.
     *
     * @return A Response containing a list of Gym Owners.
     */
    @GET
    @Path("/viewGymOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGymOwners(@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<GymOwner> gymOwnerList =  adminService.viewGymOwners();
        return Response.ok(gymOwnerList).build();
    }

    /**
     * View Gyms.
     *
     * @return A Response containing a list of Gyms.
     */
    @GET
    @Path("/viewGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGyms(@HeaderParam("Authorization") String token){
        List<Gym> gyms =  adminService.viewGyms();
        return Response.ok(gyms).build();
    }

    /**
     * View Users.
     *
     * @return A Response containing a list of Users.
     */
    @GET
    @Path("/viewUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUsers(@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<User> users = adminService.viewUsers();
        return Response.ok(users).build();
    }

    /**
     * Verify Gym.
     *
     * @param id The ID of the Gym to verify.
     * @return A Response indicating the verification result.
     */
    @PUT
    @Path("/verifyGym/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyGym(@PathParam("id") Integer id,@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        String res =  adminService.verifyGym(id);
        System.out.println(res);
        return Response.ok(res).build();
    }

    /**
     * Verify Gym Owner.
     *
     * @param id The ID of the Gym Owner to verify.
     * @return A Response indicating the verification result.
     */
    @GET
    @Path("/verifyGymOwner/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyGymOwner(@PathParam("id") Integer id,@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        adminService.verifyGymOwner(id);
        return Response.ok().build();
    }

    /**
     * Get Unverified Gym Owners.
     *
     * @return A Response containing a list of unverified Gym Owners.
     */
    @GET
    @Path("/getUnverifiedGymOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnverifiedGymOwners(@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<GymOwner> uv =  adminService.getUnverifiedGymOwners();
        return Response.ok(uv).build();
    }

    /**
     * Get Unverified Gyms.
     *
     * @return A Response containing a list of unverified Gyms.
     */
    @GET
    @Path("/getUnverifiedGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnverifiedGyms(@HeaderParam("Authorization") String token){
        if(!JwtUtils.verifyJwtToken(token,SECRET_KEY)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        List<Gym> gym = adminService.getUnverifiedGyms();
        return Response.ok(gym).build();
    }
}
