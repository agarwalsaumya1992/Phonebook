/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author saumya agarwal
 */
@Path("myservice")
public class Healthcheck {
    
    
      
@GET         

  @Produces("application/json")
         public String gethello() 
    {
        return "hello! this is test";
        
    }  
    

    @POST
     
  @Consumes("application/json") 
  @Produces("application/json")
     public Response posthello(String name)
    {
        String responsedata= "hello "+ name;
      return Response.status(201).entity(responsedata).build();
      
    }         
}
