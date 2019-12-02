package com.moviebooking.service;

import java.util.List;

import com.moviebooking.model.Users;

/**
 * @author Developer
 *
 */
public interface UserService {

	/**
	 * @param loginName
	 * @param password
	 * @return
	 */
	Users authenticateUser(String loginName, String password);

	/**
	 * @param user
	 * @return Users object
	 */
	int insertUser(Users user);
	
	/**
	 * @return List of Users
	 */
	List<Users> getAllUsers();

}
