/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

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
    @GET
    
    @Produces(MediaType.TEXT_PLAIN)
    public Response isUserValid(@HeaderParam("authorization") String authString){
        LOGGER.log(Level.INFO, "Request : {0}", authString);
       int responsedata=service.isUserValid(authString);
       LOGGER.log(Level.INFO, "Response : {0}", responsedata);
       return Response.status(200).entity(responsedata).build(); 
       
    }
       
    
}
