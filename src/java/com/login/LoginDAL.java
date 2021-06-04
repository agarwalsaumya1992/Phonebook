/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author saumya agarwal
 */
public class LoginDAL {
    
    static String sqlpath = "com/mysql/SqlMapConfig.xml";
    Reader reader;
    
      public LoginDAL() throws IOException {
        this.reader = Resources.getResourceAsReader(sqlpath);
    }
 public Logins getById(String login) {
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();   
      Logins lobj = (Logins) session.selectOne("Logins.getById",login ); 	
      session.commit();
      session.close();
			
      return lobj;
    }

    String insertUser(Logins l) {
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        int i = session.insert("Logins.insertUser", l);

        session.commit();
        session.close();
        return Integer.toString(i);
    }
    
}
