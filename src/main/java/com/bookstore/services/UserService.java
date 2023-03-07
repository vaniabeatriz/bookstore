package com.bookstore.services;

import com.bookstore.models.User;

public interface UserService {
	public User authenticateUser(String email, String password);
	public int addUser(String firstName, String lastName, String email, String password);
	public int updateUser(int userId, String firstName, String lastName, String email, String password);
}
