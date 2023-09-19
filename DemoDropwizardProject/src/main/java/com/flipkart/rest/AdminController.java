package com.flipkart.rest;

import com.flipkart.bean.Credentials;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminService;
import com.flipkart.utils.DatabaseConnector;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {

    private Validator validator;
    private AdminService adminService;

    public AdminController(Validator validator, AdminService adminService){
        this.validator = validator;
        this.adminService = adminService;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials credentials){
        Properties prop = new Properties(); // Properties is used to read files
        InputStream inputStream = DatabaseConnector.class.getClassLoader().getResourceAsStream("./config.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String admin_id = prop.getProperty("admin_id");
        String admin_password = prop.getProperty("admin_password");

        if (credentials.getUser().equals(admin_id) && credentials.getPassword().equals(admin_password)){
            return Response.ok().build();
        }
        else return Response.status(Response.Status.UNAUTHORIZED).build();

    }


    @GET
    @Path("/viewGymOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGymOwners(){
        List<GymOwner> gymOwnerList =  adminService.viewGymOwners();
        return Response.ok(gymOwnerList).build();
    }

    @GET
    @Path("/viewGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGyms(){
        adminService.viewGyms();
        return Response.ok().build();
    }

    @GET
    @Path("/viewUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUsers(){
        adminService.viewUsers();
        return Response.ok().build();
    }

    @GET
    @Path("/verifyGym/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyGym(@PathParam("id") Integer id){
        adminService.verifyGym(id);
        return Response.ok().build();
    }

    @GET
    @Path("/verifyGymOwner/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verifyGymOwner(@PathParam("id") Integer id){
        adminService.verifyGymOwner(id);
        return Response.ok().build();
    }

    @GET
    @Path("/getUnverifiedGymOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnverifiedGymOwners(){
        adminService.getUnverifiedGymOwners();
        return Response.ok().build();
    }

    @GET
    @Path("/getUnverifiedGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUnverifiedGyms(){
        adminService.getUnverifiedGyms();
        return Response.ok().build();
    }
}