package com.bookstore.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.models.Book;
import com.bookstore.utils.DatabaseConnection;

public class BookDAOImpl implements BookDAO {
	private List<Book> books = new ArrayList<>();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public List<Book> viewAllBooks() {
		
		this.con = DatabaseConnection.getMyDBConnection();
		
		try {
			this.pst = this.con.prepareStatement("SELECT * FROM Book");
			this.rs = this.pst.executeQuery();
			
			while(this.rs.next()) {
				
				Book b = new Book(this.rs.getInt(1),
						this.rs.getString(2),
						this.rs.getString(3),
						this.rs.getFloat(4),
						this.rs.getString(5),
						this.rs.getString(6));
				
				books.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.books;
		
	}

	@Override
	public List<Book> searchBooksByTitle(String title) {
		this.con = DatabaseConnection.getMyDBConnection();
		
		try {
			this.pst = this.con.prepareStatement("SELECT * FROM book WHERE LOWER(title) LIKE ?");
			this.pst.setString(1, "%" + title.toLowerCase() + "%");
			this.rs = this.pst.executeQuery();
			
			while(this.rs.next()) {
				
				Book b = new Book(this.rs.getInt(1),
						this.rs.getString(2),
						this.rs.getString(3),
						this.rs.getFloat(4),
						this.rs.getString(5),
						this.rs.getString(6));
				
				books.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.books;
	}

	@Override
	public Book getBookById(int id) {
		this.con = DatabaseConnection.getMyDBConnection();
		
		try {
			this.pst = this.con.prepareStatement("SELECT * FROM book WHERE id = ?");
			this.pst.setInt(1, id);
			this.rs = this.pst.executeQuery();
			this.rs.next();
			
			Book book = new Book(this.rs.getInt(1),
					this.rs.getString(2),
					this.rs.getString(3),
					this.rs.getFloat(4),
					this.rs.getString(5),
					this.rs.getString(6));
			
			return book;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
