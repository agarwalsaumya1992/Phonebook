/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contacts;

import java.io.IOException;
import java.io.Reader;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

/**
 *
 * @author saumya agarwal
 */
public class ContactsDAL {

    
    static String sqlpath = "com/mysql/SqlMapConfig.xml";
    Reader reader;

    public ContactsDAL() throws IOException {
        this.reader = Resources.getResourceAsReader(sqlpath);
    }

    public List getAllContacts() {
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        List<Contacts> contactList = session.selectList("Contacts.getAll");
        return contactList;

    }

    public String insertContact(Contacts c) {
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        int i = session.insert("Contacts.contactInsert", c);

        session.commit();
        session.close();
        return Integer.toString(i);
    }

    public String deleteContact(int id) {
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        int i = session.delete("Contacts.deleteById", id);
        session.commit();
        session.close();

        return Integer.toString(i);
    }

    public String updateContact(Contacts c) {
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        int i = session.update("Contacts.update", c);

        session.commit();
        session.close();

        return Integer.toString(i);

    }

}
