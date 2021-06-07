/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.mypkg.JsonBuilder;
import java.io.IOException;

import java.util.Base64;
import java.util.HashMap;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author saumya agarwal
 */
public class LoginService {

    private final static Logger LOGGER = 
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    LoginDAL dal;
     public LoginService() throws IOException {
        this.dal = new LoginDAL();
    }
     JsonBuilder builder = new JsonBuilder();
     
     
    public String isUserValid(String json) throws JsonProcessingException, IOException {
       
        Logins inputcreds=builder.jsonToObjLogin(json);
        Logins dbcreds=dal.getById(inputcreds.getLogin());
           
        
        
         HashMap<String, String> resp = new HashMap<String, String>();

   
        
       if (dbcreds==null) {
           resp.put("statusCode","0");
           resp.put("statusMsg","User not found");
           
           
           
       }
       else if (dbcreds.getPass().equals(inputcreds.getPass())){
           resp.put("statusCode","1");
           resp.put("statusMsg","Login successful");
           resp.put("loginId",String.valueOf(dbcreds.getId()));
          
       }
        else {
           resp.put("statusCode","9");
           resp.put("statusMsg","Incorrect password");
          
       }
       
       
       
       
      return  builder.stringToJson(resp);
     
//        return decodedString.equals("admin:admin123")?1:0;

    }
    
   
    String registerUser(String json) throws IOException {
        
        
        Logins inputcreds=builder.jsonToObjLogin(json);
        
        
        return dal.insertUser(inputcreds);
        
               
        
        
    }
}
