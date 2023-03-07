package com.bookstore.daos;

import com.bookstore.models.User;

public interface UserDAO {
	
	public User findUserByEmailAndPassword(String email, String password);
	public int addUser(String firstName, String lastName, String email, String password);
	public int editPersonalAccount(int userId, String firstName, String lastName, String email, String password);
}
