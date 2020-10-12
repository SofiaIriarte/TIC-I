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
public class AppPaymentsHibernate {
	public static void main(String[] args) throws Exception {
				
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        session.beginTransaction();

        session.save(new Payment(50000, "$"));
        session.save(
        		new CheckPayment(10000, "$")
        			.account("1234").bank("111").number("22222222222").toDate(new Date()).authorizationCode("56789"));
        session.save(new CreditCardPayment(1000,"US$", "546375","1234567890", "1111"));
        session.getTransaction().commit();

        List<Payment> payments = (List<Payment>)session.createQuery("FROM CheckPayment").list();

        session.close();
	}
}
