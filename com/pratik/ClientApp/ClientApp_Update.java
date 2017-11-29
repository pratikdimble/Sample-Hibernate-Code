package com.pratik.ClientApp

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pratik.BO_Domain.product;

public class ClientApp_Update {

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
    //search the recird is exist or not
		prod=ses.get(product.class, 22);
		if(prod!=null)  //if record is found
		{
        //set values to the bo/entity class object to update
			prod.setPrice(350f);
			prod.setQuantity(4);
			try {
				tx = ses.beginTransaction();
				ses.update(prod);     //update record using ses.update()
				tx.commit();    //save changes to database
				System.out.println("object is updated");
			} catch (Exception e) {
				tx.rollback();

			}

			System.out.println("===Record Found and Updated===");
		}
		else
		{
			System.out.println("Record Not Found");
		}
    //close the resources
		ses.close();
		factory.close();
    }//main()close
    }//class close
