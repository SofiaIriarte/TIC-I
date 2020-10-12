package edu.um.database.examples;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppHibernateJPA {
	public static void main(String[] args) {
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("edu.um.database.tutorial.jpa");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
        Event theEvent = new Event();
        theEvent.setTitle("titulo2");
        theEvent.setDate(new Date());
        
		em.persist(theEvent);
		
		em.getTransaction().commit();
		
		
		Query q1 = em.createQuery("SELECT COUNT(e) FROM Event e");
		
		System.out.println("Total Events: " + q1.getSingleResult());
		
		em.close();
	}
}
