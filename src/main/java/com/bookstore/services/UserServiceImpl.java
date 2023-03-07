package com.bookstore.services;

import com.bookstore.daos.UserDAO;
import com.bookstore.models.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User authenticateUser(String email, String password) {
		return this.userDAO.findUserByEmailAndPassword(email, password);
	}

	@Override
	public int addUser(String firstName, String lastName, String email, String password) {
		return this.userDAO.addUser(firstName, lastName, email, password);
	}

	@Override
	public int updateUser(int userId, String firstName, String lastName, String email, String password) {
		return this.userDAO.editPersonalAccount(userId, firstName, lastName, email, password);
	}

}
