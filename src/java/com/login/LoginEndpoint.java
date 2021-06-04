/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.login.LoginService;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author saumya agarwal
 */
@Path("login")
public class LoginEndpoint {
    
    LoginService service;
    
      public LoginEndpoint() throws IOException {
        service=new LoginService();
    }
     private final static Logger LOGGER = 
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @POST
    
    @Produces(MediaType.TEXT_PLAIN)
    public Response isUserValid(String json) throws JsonProcessingException, IOException{
        LOGGER.log(Level.INFO, "Request : {0}", json);
        String responsedata=service.isUserValid(json);
        
       LOGGER.log(Level.INFO, "Response : {0}", responsedata);
       return Response.status(200).entity(responsedata).build(); 
       
    }
      @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerUser(String json) throws JsonProcessingException, IOException{
        LOGGER.log(Level.INFO, "Request : {0}", json);
        String responsedata=service.registerUser(json);
       LOGGER.log(Level.INFO, "Response : {0}", responsedata);
       return Response.status(200).entity(responsedata).build(); 
       
    }  
    
}
