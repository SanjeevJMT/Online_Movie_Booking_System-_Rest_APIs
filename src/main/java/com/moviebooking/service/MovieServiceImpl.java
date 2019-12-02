package com.moviebooking.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.*;
import com.moviebooking.dao.MovieDao;
import com.moviebooking.dao.MovieDaoImpl;
import com.moviebooking.model.BookingDetails;
import com.moviebooking.model.Movie;

/**
 * @author Developer
 *
 */
public class MovieServiceImpl implements MovieService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moviebooking.service.MovieService#addMovie(com.moviebooking.model.
	 * Movie)
	 */
	@Override
	public int addMovie(Movie movie) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.addMovie(movie);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.service.MovieService#getAllMovies()
	 */
	@Override
	public List<Movie> getAllMovies(int start, int size) {
		MovieDao mdao = new MovieDaoImpl();
		List<Movie> movieList = mdao.getAllMovies();
		if (start > 0 && size >= 0) {
			if (start + size > movieList.size()) {
				return new ArrayList<>();
			} else
				return movieList.subList(start-1,  size);
		}
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moviebooking.service.MovieService#getMovieByName(java.lang.String)
	 */
	@Override
	public Movie getMovieById(int movieId) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.getMovieById(movieId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moviebooking.service.MovieService#editMovie(com.moviebooking.model.
	 * Movie)
	 */
	@Override
	public Movie editMovie(Movie movie) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.editMovie(movie);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.service.MovieService#calculatePrice(int,
	 * java.lang.String)
	 */
	@Override
	public int calculatePrice(int seatNos, String gallery) {
		int cost;
		if (gallery.equalsIgnoreCase("gold")) {
			cost = 200;
		} else {
			cost = 150;
		}
		return (cost * seatNos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moviebooking.service.MovieService#confirmBooking(com.moviebooking.
	 * model.BookingDetails)
	 */
	@Override
	public BookingDetails confirmBooking(BookingDetails bookingDetails) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.addBooking(bookingDetails);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moviebooking.service.MovieService#getAllBookings()
	 */
	@Override
	public List<BookingDetails> getAllBookings() {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.getAllBookings();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moviebooking.service.MovieService#calculateIncome(java.util.List)
	 */
	@Override
	public int calculateIncome(List<BookingDetails> bookingDetailsList) {
		int income = 0;
		for (BookingDetails booking : bookingDetailsList) {
			income = income + booking.getPrice();
		}
		return income;
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.service.MovieService#getMoviesByName(java.lang.String)
	 */
	@Override
	public Movie getMoviesByName(String movieName) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.getMoviesByName(movieName);
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.service.MovieService#confirmBooking(int, int, java.lang.String)
	 */
	@Override
	public BookingDetails confirmBooking(int movieId, int seats, String gallery) {
		BookingDetails bookingDetails= new BookingDetails();
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		bookingDetails.setSeatNumbers(seats);
		bookingDetails.setPrice(calculatePrice(seats, gallery));
		bookingDetails.setMovie(movie);
		bookingDetails.setGallery(gallery);
		bookingDetails.setBookingDate(new java.util.Date());
		MovieDao mdao = new MovieDaoImpl();
		return mdao.addBooking(bookingDetails);
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.service.MovieService#getBooking(int)
	 */
	@Override
	public BookingDetails getBooking(int bookingId) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.getBooking( bookingId);
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.service.MovieService#deleteMovie(int)
	 */
	@Override
	public int deleteMovie(int movieId) {
		MovieDao mdao = new MovieDaoImpl();
		return mdao.deleteMovie(movieId);
	}

}
