package com.bookstore.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.models.Book;
import com.bookstore.models.User;
import com.bookstore.utils.DatabaseConnection;

public class UserDAOImpl implements UserDAO {
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public User findUserByEmailAndPassword(String email, String password) {
		this.con = DatabaseConnection.getMyDBConnection();
		
		try {
			this.pst = this.con.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ? LIMIT 1");
			this.pst.setString(1, email);
			this.pst.setString(2, password);
			this.rs = this.pst.executeQuery();
			this.rs.next();
			
			User user = new User(this.rs.getInt(1),
					this.rs.getString(2),
					this.rs.getString(3),
					this.rs.getString(4),
					this.rs.getString(5));
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int addUser(String firstName, String lastName, String email, String password) {
		int i = 0;
		this.con = DatabaseConnection.getMyDBConnection();
		
		try {
			this.pst = this.con.prepareStatement("INSERT INTO user (first_name, last_name, email, password) VALUES (?, ?, ?, ?)");
			this.pst.setString(1, firstName);
			this.pst.setString(2, lastName);
			this.pst.setString(3, email);
			this.pst.setString(4, password);
			
			i = this.pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int editPersonalAccount(int userId, String firstName, String lastName, String email, String password) {
		int i = 0;
		this.con = DatabaseConnection.getMyDBConnection();
		
		try {
			this.pst = this.con.prepareStatement("UPDATE user SET first_name = ?, last_name =?, email = ?, password = ? WHERE id = ?");
			this.pst.setString(1, firstName);
			this.pst.setString(2, lastName);
			this.pst.setString(3, email);
			this.pst.setString(4, password);
			this.pst.setInt(5, userId);
			
			i = this.pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
}
