package com.pratik.ClientApp

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pratikn.Emp;

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
		Emp em = null;
        	em = new Emp();
		Transaction tx = null;
    //search the recird is exist or not
		em=ses.get(Emp.class, 22);
		if(em!=null)  //if record is found
		{
        //set values to the bo/entity class object to update
			em.setEcity("Lonand");
			em.setEsalary(50000);
			try {
				tx = ses.beginTransaction();
				ses.update(em);     //update record using ses.update()
				tx.commit();    //save changes to database
				System.out.println("object is updated");
			} catch (Exception e) {
				tx.rollback();

			}
      //show the updated record
			System.out.println("===Record Found and Updated===");
			System.out.println("\t"+em.getEid()+"\t"+em.getEname()+"\t"+em.getEsalary()+"\t"+em.getEcity());
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
