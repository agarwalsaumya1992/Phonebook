/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypkg;

import com.contacts.Contacts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.Logins;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author saumya agarwal
 */
public class JsonBuilder {
    
 
    
    public String objListTojson(List list) throws JsonProcessingException
    {
         
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(list);   
         
        return jsonInString;
    }
    
    public Contacts jsonToObj(String json) throws IOException 
    {
        
        ObjectMapper mapper = new ObjectMapper();   
        Contacts cb = mapper.readValue(json,Contacts.class);
        return cb;
    }
    public Logins jsonToObjLogin(String json) throws IOException 
    {
        
        ObjectMapper mapper = new ObjectMapper();   
        Logins cb = mapper.readValue(json,Logins.class);
        return cb;
    }
     public String stringToJson(HashMap<String, String> resp) throws JsonProcessingException
    {
         
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(resp);   
         
        return jsonInString;
    }

   
   
    
}
