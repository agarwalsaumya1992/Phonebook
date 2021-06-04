/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contacts;

import com.mypkg.JsonBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("contacts")
public class ContactsEndpoint {

    private final static Logger LOGGER
            = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    ContactsDAL dal;
    JsonBuilder builder = new JsonBuilder();

    public ContactsEndpoint() throws IOException {
        this.dal = new ContactsDAL();
    }

    @GET

    @Produces("application/json")
    public Response getAllContacts() throws JsonProcessingException {
        String responsedata = builder.objListTojson(dal.getAllContacts());
        LOGGER.log(Level.INFO, "Response : {0}", responsedata);
        return Response.status(200).entity(responsedata).build();
    }

    @POST

    @Consumes("application/json")
    @Produces("text/html")
    public Response insertContact(String json) throws IOException {
        LOGGER.log(Level.INFO, "Request : {0}", json);
        String responsedata = dal.insertContact(builder.jsonToObj(json));
        LOGGER.log(Level.INFO, "Response : {0}", responsedata);
        return Response.ok(responsedata).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("text/html")
    public Response deleteContact(@PathParam("id") int id) {
        LOGGER.log(Level.INFO, "Request : {0}", id);
        String responsedata = dal.deleteContact(id);
        LOGGER.log(Level.INFO, "Response : {0}", responsedata);
        return Response.ok(responsedata).build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("text/html")
    public Response updateContact(String json) throws IOException {
        LOGGER.log(Level.INFO, "Request : {0}", json);
        String responsedata = dal.updateContact(builder.jsonToObj(json));
        LOGGER.log(Level.INFO, "Response : {0}", responsedata);
        return Response.ok(responsedata).build();
    }

}
