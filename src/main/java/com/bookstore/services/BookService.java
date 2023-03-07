package com.bookstore.services;

import java.util.List;

import com.bookstore.models.Book;

public interface BookService {
	public List<Book> findAllBooks();
	public List<Book> searchBooksByTitle(String title);
	public Book getBookById(int id);
}
