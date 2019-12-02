package com.moviebooking.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


import com.moviebooking.model.Users;
import com.moviebooking.service.UserService;
import com.moviebooking.service.UserServiceImpl;

/**
 * @author Developer
 *
 */
@Path("/authentication")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {
	UserService userService = new UserServiceImpl();

	/**
	 * @param username
	 * @param password
	 * @param uriInfo
	 * @return User object if authentication successful else null.
	 */
	@POST
	public Users authenticate(Users user) {
		try {
			// Authenticating the user using the credentials provided
			Users userr = userService.authenticateUser(user.getUserName(), user.getPassword());
			
			if (userr != null) {
				return userr;
			} else{
				return null;}
		} catch (Exception e) {
			
			return null;
		}
	}

}
