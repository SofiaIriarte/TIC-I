package edu.um.database.examples;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AppObjectDB {
	
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("$objectdb/db/points.odb");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
        Event theEvent = new Event();
        theEvent.setTitle("titulo2");
        theEvent.setDate(new Date());
        
		em.persist(theEvent);
		
		em.getTransaction().commit();
		
		
		Query q1 = em.createQuery("SELECT COUNT(e) FROM Event e");
		
		TypedQuery<Event> q2 = em.createQuery("Select e from Event e", Event.class);

		List<Event> events = q2.getResultList();
		events.forEach(event -> {
			System.out.println(event);
		});
		
		Query q3 = em.createQuery("SELECT e.id, e.date from Event e");
		List<Object[]> objects = q3.getResultList();
		
		objects.forEach(object -> {
			Date date = (Date)object[1];
			System.out.println("Id: " + object[0] + 
					 ", date: " + date);
		});
		
		System.out.println("EventDetail query...");
		
		TypedQuery<EventDetail> q4 = em.createQuery(
				"SELECT new edu.um.database.examples.EventDetail(e.id, e.date) "
				+ "from Event e", EventDetail.class);

		List<EventDetail> eventDetails = q4.getResultList();
		
		eventDetails.forEach(eventDetail -> {
			System.out.println("Id: " + eventDetail.getId() + 
					 ", date: " + eventDetail.getDate());
		});
		
		
		System.out.println("Total Events: " + q1.getSingleResult());
		
		em.close();
		
	}

}
