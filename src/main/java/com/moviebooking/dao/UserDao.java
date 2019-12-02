package com.moviebooking.dao;

import java.util.List;

import com.moviebooking.model.Users;

/**
 * @author Developer
 *
 */
public interface UserDao {

	/**
	 * @param loginName
	 * @param password
	 * @return
	 */
	Users authenticateUser(String loginName, String password);

	/**
	 * @param user
	 * @return
	 */
	int insertUser(Users user);

	/**
	 * @return list of all user
	 */
	List<Users> getAllUsers();
}
