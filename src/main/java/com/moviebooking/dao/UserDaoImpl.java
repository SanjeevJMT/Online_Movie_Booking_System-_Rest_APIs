package com.moviebooking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.moviebooking.db.HibernateUtility;
import com.moviebooking.model.Users;

/**
 * @author Developer
 *
 */
public class UserDaoImpl implements UserDao {

	static Logger logger = Logger.getLogger(UserDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.UserDao#getAllUsers()
	 */
	@Override
	public List<Users> getAllUsers() {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
			Root<Users> root = criteria.from(Users.class);
			criteria.select(root);

			List<Users> listOfUsers = entityManager.createQuery(criteria).getResultList();

			session.getTransaction().commit();
			return listOfUsers;
		} catch (HibernateException e) {
			logger.debug(e);
			return null;
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.UserDao#authenticateUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Users authenticateUser(String loginName, String password) {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			// creating the entity manager
			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			// Query Construction :
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
			Root<Users> root = criteria.from(Users.class);
			criteria.select(root);
			// adding where clause
			Predicate condition = builder.and(builder.equal(root.get("userName"), loginName),
					builder.equal(root.get("password"), password));
			criteria.where(condition);
			// quering the table
			Users user = entityManager.createQuery(criteria).getSingleResult();
			session.getTransaction().commit();
			return user;
		} catch (HibernateException e) {
			logger.debug(e);
			return null;
		} finally {
			session.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moviebooking.dao.UserDao#insertUser(com.moviebooking.model.Users)
	 */
	@Override
	public int insertUser(Users user) {

		Session session = HibernateUtility.getSession();
		int userId;
		try {
			session.beginTransaction();
			userId = (Integer) session.save(user);
			session.getTransaction().commit();
			return userId;
		} catch (HibernateException e) {
			logger.debug(e);
			return 0;
		} finally {
			session.close();
		}

	}

}
