package com.bookstore.daos;

import java.util.List;

import com.bookstore.models.Book;

public interface BookDAO {	
	public List<Book> viewAllBooks();
	public List<Book> searchBooksByTitle(String title);
	public Book getBookById(int id);
}
