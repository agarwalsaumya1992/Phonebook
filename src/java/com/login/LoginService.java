/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;


import com.contacts.ContactsDAL;
import java.io.IOException;
import java.util.Base64;
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

    public int isUserValid(String authString) {
       
        Logins inputcreds=getCreds(authString);
        Logins dbcreds=dal.getById(inputcreds.getLogin());
        
       if (dbcreds==null) 
           return 2;
       else if (dbcreds.getPass().equals(inputcreds.getPass()))
           return 1;
        else 
           return 0;
       
//        return decodedString.equals("admin:admin123")?1:0;

    }
    
    Logins getCreds(String authString){
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] str = authString.split("\\s+");
        String encodedString = str[1];
         byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

        String decodedString = new String(decodedBytes);
        
        LOGGER.log(Level.INFO, "User login : {0}", decodedString);
        
        String[] creds = decodedString.split(":"); 
        Logins l=new Logins();
        l.setLogin(creds[0]);
        l.setPass(creds[1]);
        LOGGER.log(Level.INFO, "User login obj : {0}", l.toString());
        return l;
    }
}
