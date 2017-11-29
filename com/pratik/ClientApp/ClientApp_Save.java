package com.nt.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Emp;

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
		Emp em = null;
        	em = new Emp();
		Transaction tx = null;

    //set values to the bo/entity class object
		em.setEid(9999);
		em.setEname("gannu");
		em.setEsalary(40000);
		em.setEcity("bhor");

		try {
			tx = ses.beginTransaction();
			ses.save(em);   //saving object using ses.save() method
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
