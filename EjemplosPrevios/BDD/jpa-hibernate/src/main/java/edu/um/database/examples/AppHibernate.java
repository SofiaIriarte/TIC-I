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
public class AppHibernate {
	public static void main(String[] args) throws Exception {
				
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle("titulo2");
        theEvent.setDate(new Date());
        
//        for (int i = 0; i < 100000; i++) {
//        Person person = new Person();
//        person.setAge(20); person.setName(new Name("Name","LastName"));
        
        Person person = (Person)session.load(Person.class, Long.valueOf(2));
//        
//        session.save(theEvent);
//
//        person.getEvents().add(theEvent);
        
        session.saveOrUpdate(person);
//        }
        
        session.getTransaction().commit();
        //session.getTransaction().rollback();
        
        
        List<Object> events = (List<Object>)session.createQuery("SELECT COUNT(e) FROM Event e").list();
        
        
        System.out.println("Total Events: " + events.get(0));
        
        session.close();
	}
}
