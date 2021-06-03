/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contacts;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saumya agarwal
 */
@XmlRootElement
public class Contacts {

  
    
  
    private int id;
     private String name;
      private String phone;
    private String addr;

           
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

  
    
}
