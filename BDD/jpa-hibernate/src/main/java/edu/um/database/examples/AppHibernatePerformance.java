package edu.um.database.examples;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class AppHibernatePerformance {
	public static void main(String[] args) throws Exception {
				
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

        Session session = sessionFactory.openSession();
	
        ElapsedTimeMeasure measure = new ElapsedTimeMeasure();
        measure.start();
        

        for (int i = 0 ; i < 10000; i++) {
            session.beginTransaction();
	
	        Event theEvent = new Event();
	        theEvent.setTitle("titulo2");
	        theEvent.setDate(new Date());
	        
	        session.save(theEvent);
	        session.getTransaction().commit();
	        
        }
        

        System.out.println(measure.result());
        
        
        //session.getTransaction().rollback();
        
        
        List<Object> events = (List<Object>)session.createQuery("SELECT COUNT(e) FROM Event e").list();
        
        System.out.println("Total Events: " + events.get(0));
        
        session.close();
	}
}
