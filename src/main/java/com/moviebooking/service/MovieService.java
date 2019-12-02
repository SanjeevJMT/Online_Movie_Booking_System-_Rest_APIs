package com.moviebooking.service;

import java.util.List;

import com.moviebooking.model.BookingDetails;
import com.moviebooking.model.Movie;


public interface MovieService {
	
	/**
	 * @param movie
	 * @return
	 */
	public int addMovie(Movie movie) ;
	
	/**
	 * @return
	 */
	public List<Movie> getAllMovies(int start, int size);
	
	/**
	 * @param movieName
	 * @return
	 */
	public Movie getMovieById(int movieId);
	
	/**
	 * @param movie
	 * @return
	 */
	public Movie editMovie(Movie movie);

	/**
	 * @param seatNos
	 * @param classs
	 * @return 
	 */
	public int calculatePrice(int seatNos, String classs);

	/**
	 * @param bookingDetails
	 * @return
	 */
	public BookingDetails confirmBooking(BookingDetails bookingDetails);

	/**
	 * @return
	 */
	public List<BookingDetails> getAllBookings();

	/**
	 * @param bookingDetailsList
	 * @return
	 */
	public int calculateIncome(List<BookingDetails> bookingDetailsList);

	public Movie getMoviesByName(String movieName);

	public BookingDetails confirmBooking(int movieId, int seats, String gallery);

	public BookingDetails getBooking(int ticketId);

	public int deleteMovie(int movieId);
	

}
