package com.moviebooking.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Developer
 *
 */
public enum HibernateUtility {

	INSTANCE;
	private HibernateUtility() {
	}

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/**
	 * @return
	 */
	public static Session getSession() {

		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
}
