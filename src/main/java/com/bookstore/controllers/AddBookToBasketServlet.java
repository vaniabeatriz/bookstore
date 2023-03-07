package com.bookstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.daos.BookDAOImpl;
import com.bookstore.models.Book;
import com.bookstore.services.BookService;
import com.bookstore.services.BookServiceImpl;

/**
 * Servlet implementation class AddBookToBasketServlet
 */
public class AddBookToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookToBasketServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Code to capture user's input
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Initialize an empty list of books
		List<Book> bookList = new ArrayList<Book>();
		
		// Get the session
		HttpSession session = request.getSession(true);

		// If the session has a basket, read the values and add to the bookList
		if(session.getAttribute("basket") != null) {
			bookList = (List<Book>) session.getAttribute("basket");
		}
		
		// Get the book object by the book id (user's input) and append to the book List
		BookService bookService = new BookServiceImpl(new BookDAOImpl());
		bookList.add(bookService.getBookById(id));
			
		// Update the basket on the session
		session.setAttribute("basket", bookList);
		
		request.getRequestDispatcher("basket.jsp").forward(request, response);
	}

}
