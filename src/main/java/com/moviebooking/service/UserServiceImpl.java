package com.moviebooking.service;

import java.util.List;

import com.moviebooking.dao.UserDao;
import com.moviebooking.dao.UserDaoImpl;
import com.moviebooking.model.Users;

/**
 * @author Developer
 *
 */
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see com.moviebooking.service.UserService#authenticateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public Users authenticateUser(String loginName, String password) {
		UserDao udao = new UserDaoImpl();
		return udao.authenticateUser(loginName, password);
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.service.UserService#insertUser(com.moviebooking.model.Users)
	 */
	@Override
	public int insertUser(Users user) {
			UserDao udao=new UserDaoImpl();
			return udao.insertUser(user);
		
	}

	/* (non-Javadoc)
	 * @see com.moviebooking.service.UserService#getAllUsers()
	 */
	@Override
	public List<Users> getAllUsers() {
		UserDao udao=new UserDaoImpl();
		return udao.getAllUsers();
	}

}
