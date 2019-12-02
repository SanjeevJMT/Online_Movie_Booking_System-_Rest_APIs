package com.moviebooking.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.moviebooking.model.BookingDetails;
import com.moviebooking.model.Movie;
import com.moviebooking.service.MovieService;
import com.moviebooking.service.MovieServiceImpl;
import com.moviebooking.service.UserService;
import com.moviebooking.service.UserServiceImpl;


/**
 * @author Developer
 *
 */
@Path("user/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	MovieService movieService = new MovieServiceImpl();

	
	/**
	 * @param start  it provides start point of the desired list.
	 * @param size it provides the no of result list to be fetched.
	 * @return paginated list.
	 */
	@GET
	public List<Movie> getMovies(@QueryParam("start") int start, @QueryParam("size") int size) {
		return movieService.getAllMovies(start, size);

	}

	/**
	 * @param movieName
	 * @return returns the details of the movie searched.
	 */
	@GET
	@Path("/search")
	public Movie searchMovie(@QueryParam("movieName") String movieName) {
		return movieService.getMoviesByName(movieName);
	}

	
	/**
	 * @param movieId
	 * @param seats
	 * @param gallery
	 * @param uriInfo
	 * @return BookingDetails
	 */
	@POST
	@Path("/tickets")
	public Response createBooking(@QueryParam("movieId") int movieId, @QueryParam("seats") int seats, @QueryParam("gallery") String gallery,
			@Context UriInfo uriInfo) {
		BookingDetails booking = movieService.confirmBooking(movieId, seats,gallery);
		URI newUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(booking.getBookingId())).build();
		return Response.created(newUri).entity(booking).build();

	}

	/**
	 * @param ticketId id of the booking which is used to fetch details of the ticket booking from the database 
	 * @return
	 */
	@GET
	@Path("/tickets/{ticketId}")
	public BookingDetails getTicket(@PathParam("ticketId") int ticketId) {
		return movieService.getBooking(ticketId);
	}

}
