package com.pratik.ClientApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pratik.BO_Domain.product;

public class ClientApp {

	public static void main(String[] args) {

//activate hibernate framework
		Configuration cfg = null;
    		cfg = new Configuration();
    //Qualified name of configuration file
		cfg = cfg.configure("/com/pratik/cfgs/hibernate.cfg.xml");
    //create session factory object
		SessionFactory factory = null;
   		factory = cfg.buildSessionFactory();
    //create session object
		Session ses = null;
        //get session object
		        ses = factory.openSession();
    //create domain/BO class object
		product prod = null;
        	prod = new product();
		Transaction tx = null;

    //set values to the bo/entity class object

		prod.setPid(111);
		prod.setPname("Tea");
		prod.setPrice(400f);
		prod.setQuantity(3);

		try {
			tx = ses.beginTransaction();
			ses.save(prod);   //saving object using ses.save() method
			tx.commit();
			System.out.println("object is saved");
		} catch (Exception e) {
    e.printStackTrace();
			tx.rollback();
		}
    //close the resources
		ses.close();
		factory.close();
    }//main()close
    }//class close
