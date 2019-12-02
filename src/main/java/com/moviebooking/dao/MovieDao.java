package com.moviebooking.dao;

import java.sql.SQLException;
import java.util.List;

import com.moviebooking.model.BookingDetails;
import com.moviebooking.model.Movie;

/**
 * @author Developer
 *
 */
public interface MovieDao {

	/**
	 * @param movie
	 * @return
	 */
	public int addMovie(Movie movie) ;

	/**
	 * @return
	 */
	public List<Movie> getAllMovies();

	/**
	 * @param movieName
	 * @return
	 */
	public Movie getMovieById(int movieId) ;

	/**
	 * @param movie
	 * @return
	 */
	public Movie editMovie(Movie movie);

	/**
	 * @param bookingDetails
	 * @return
	 */
	public BookingDetails addBooking(BookingDetails bookingDetails);

	/**
	 * @return AllBookings
	 */
	public List<BookingDetails> getAllBookings();

	/**
	 * @param movieName
	 * @return
	 */
	public Movie getMoviesByName(String movieName);


	/**
	 * @param bookingId
	 * @return
	 */
	public BookingDetails getBooking(int bookingId);

	/**
	 * @param movieId
	 * @return
	 */
	public int deleteMovie(int movieId);

}
