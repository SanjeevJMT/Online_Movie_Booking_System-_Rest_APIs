package com.moviebooking.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.moviebooking.model.Movie;
import com.moviebooking.service.MovieService;
import com.moviebooking.service.MovieServiceImpl;

/**
 * @author Developer
 *
 */
@Path("admin/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

	MovieService movieService = new MovieServiceImpl();

	/**
	 * @param start
	 *            it provides start point of the desired list.
	 * @param size
	 *            it provides the no of result list to be fetched.
	 * @return paginated list.
	 */
	@GET
	public List<Movie> getMovies(@QueryParam("start") int start, @QueryParam("size") int size) {
		return movieService.getAllMovies(start, size);

	}

	/**
	 * @param movieId
	 * @param uriInfo
	 * @return Movie object.
	 */
	@GET
	@Path("/{movieId}")
	public Movie getMovie(@PathParam("movieId") Integer movieId, @Context UriInfo uriInfo) {

		return movieService.getMovieById(movieId);
	}

	/**
	 * POST method used to add a new movie
	 * 
	 * @param movie
	 *            the parameter provided by the application in json form
	 * @param uriInfo
	 *            provides handler to pathbuilder which is used for creating
	 *            URIs
	 * @return a response with created status code along with details of movie
	 */
	@POST
	public Response addMovie(Movie movie, @Context UriInfo uriInfo) {

		int result = movieService.addMovie(movie);
		movie.setMovieId(result);
		String newId = String.valueOf(result);
		URI newUri = uriInfo.getAbsolutePathBuilder().path(newId).build();

		return Response.created(newUri).entity(movie).build();
	}

	/**
	 * PUT method is used to update existing movie information
	 * 
	 * @param movie
	 *            the parameter provided by the application in json form
	 * @param uriInfo
	 *            provides handler to pathbuilder which is used for creating
	 *            urls
	 * @return a response with ok status code and movie entity in the json form
	 */
	@PUT
	public Response updateMovie(Movie movie, @Context UriInfo uriInfo) {
		movie = movieService.editMovie(movie);
		String newId = String.valueOf(movie.getMovieId());
		URI newUri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.ok(newUri).entity(movie).build();
	}

	/**
	 * DELETE method being used to delete resources
	 * 
	 * @param movieId
	 *            the id of the movie to be deleted
	 * @return
	 */
	@DELETE
	@Path("/{movieId}")
	public Response deleteMovie(@PathParam("movieId") int movieId) {
		movieService.deleteMovie(movieId);
		return Response.status(Status.OK).build();
	}

}
