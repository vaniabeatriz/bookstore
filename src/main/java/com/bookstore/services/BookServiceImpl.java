package com.bookstore.services;

import java.util.List;

import com.bookstore.daos.BookDAO;
import com.bookstore.models.Book;

public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@Override
	public List<Book> findAllBooks() {
		return this.bookDAO.viewAllBooks();
	}

	@Override
	public List<Book> searchBooksByTitle(String title) {
		return this.bookDAO.searchBooksByTitle(title);
	}

	@Override
	public Book getBookById(int id) {
		return this.bookDAO.getBookById(id);
	}
}
