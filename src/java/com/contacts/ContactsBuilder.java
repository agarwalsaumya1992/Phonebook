/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contacts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author saumya agarwal
 */
public class ContactsBuilder {
    
 
    
    public String objListTojson(List<Contacts> contactList) throws JsonProcessingException
    {
         
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(contactList);   
         
        return jsonInString;
    }
    
    public Contacts jsonToObj(String json) throws IOException 
    {
        
        ObjectMapper mapper = new ObjectMapper();   
        Contacts cb = mapper.readValue(json,Contacts.class);
        return cb;
    }
    
}
