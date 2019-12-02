package com.moviebooking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.moviebooking.db.HibernateUtility;
import com.moviebooking.model.BookingDetails;
import com.moviebooking.model.Movie;

/**
 * @author Developer
 *
 */
public class MovieDaoImpl implements MovieDao {

	static Logger logger = Logger.getLogger(MovieDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.MovieDao#addMovie(com.moviebooking.model.Movie)
	 */
	@Override
	public int addMovie(Movie movie) {
		int movieId = 0;
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			movieId = (Integer) session.save(movie);
			session.getTransaction().commit();
			session.close();
			return movieId;
		} catch (Exception e) {
			logger.error(e);
			return 0;
		}finally {
			session.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.MovieDao#getAllMovies()
	 */
	@Override
	public List<Movie> getAllMovies() {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Movie> criteria = builder.createQuery(Movie.class);
			Root<Movie> root = criteria.from(Movie.class);
			criteria.select(root);

			List<Movie> listOfMovies = entityManager.createQuery(criteria).getResultList();

			session.getTransaction().commit();
			return listOfMovies;
		} catch (HibernateException e) {
			logger.error(e);
			return null;
		}finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.MovieDao#getMovieByName(java.lang.String)
	 */
	@Override
	public Movie getMovieById(int movieId) {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Movie> criteria = builder.createQuery(Movie.class);
			Root<Movie> root = criteria.from(Movie.class);
			criteria.select(root);

			Predicate condition = builder.and(builder.equal(root.get("movieId"), movieId));
			criteria.where(condition);

			Movie movie = entityManager.createQuery(criteria).getSingleResult();

			session.getTransaction().commit();
			return movie;
		} catch (NoResultException e) {
			logger.error(e);
			return null;
		}finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.dao.MovieDao#editMovie(com.moviebooking.model.Movie)
	 */
	@Override
	public Movie editMovie(Movie movie) {
		//yet to be implemented 
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.MovieDao#addBooking(com.moviebooking.model.
	 * BookingDetails)
	 */
	@Override
	public BookingDetails addBooking(BookingDetails bookingDetails) {
		int bookingId = 0;
		Session session = HibernateUtility.getSession();

		try {
			session.beginTransaction();
			bookingId = (Integer) session.save(bookingDetails);
			session.getTransaction().commit();
			bookingDetails.setBookingId(bookingId);
			return bookingDetails;
		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			session.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.dao.MovieDao#getAllBookings()
	 */
	@Override
	public List<BookingDetails> getAllBookings() {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<BookingDetails> criteria = builder.createQuery(BookingDetails.class);
			Root<BookingDetails> root = criteria.from(BookingDetails.class);
			criteria.select(root);

			List<BookingDetails> listOfBookingDetails = entityManager.createQuery(criteria).getResultList();

			session.getTransaction().commit();
			return listOfBookingDetails;
		} catch (HibernateException e) {
			logger.error(e);
			return null;
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.dao.MovieDao#getMoviesByName(java.lang.String)
	 */
	@Override
	public Movie getMoviesByName(String movieName) {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<Movie> criteria = builder.createQuery(Movie.class);
			Root<Movie> root = criteria.from(Movie.class);
			criteria.select(root);

			Predicate condition = builder.and(builder.equal(root.get("movieName"), movieName));
			criteria.where(condition);

			Movie movie = entityManager.createQuery(criteria).getSingleResult();

			session.getTransaction().commit();
			return movie;
		} catch (NoResultException e) {
			logger.error(e);
			return null;
		}finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.dao.MovieDao#getBooking(int)
	 */
	@Override
	public BookingDetails getBooking(int bookingId) {

		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();

			EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();

			CriteriaQuery<BookingDetails> criteria = builder.createQuery(BookingDetails.class);
			Root<BookingDetails> root = criteria.from(BookingDetails.class);
			criteria.select(root);

			Predicate condition = builder.and(builder.equal(root.get("bookingId"), bookingId));
			criteria.where(condition);

			BookingDetails bookingDetails = entityManager.createQuery(criteria).getSingleResult();

			session.getTransaction().commit();
			return bookingDetails;
		} catch (HibernateException e) {
			logger.error(e);
			return null;
		}finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.dao.MovieDao#deleteMovie(int)
	 */
	@Override
	public int deleteMovie(int movieId) {
		Session session = HibernateUtility.getSession();
		try {
			session.beginTransaction();
			Movie movie = new Movie();
			movie.setMovieId(movieId);
			session.delete(movie);
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException e) {
			logger.error(e);
			return 0;
		}finally {
			session.close();
		}
		
	}

}
