/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  saumya agarwal
 * Created: Jun 3, 2021
 */

DROP table TBL_CONTACTS

create TABLE TBL_CONTACTS 
( CID INT NOT NULL AUTO_INCREMENT , 
CNAME VARCHAR(50) NOT NULL , 
ADDR VARCHAR(50) NOT NULL , 
PHONE VARCHAR(20) NOT NULL , 
PRIMARY KEY (CID));


create TABLE TBL_LOGINS
( LID INT NOT NULL AUTO_INCREMENT , 
LOGIN VARCHAR(20) NOT NULL , 
PASS VARCHAR(30) NOT NULL , 
UNAME VARCHAR(30) NOT NULL , 
PRIMARY KEY (LID));


