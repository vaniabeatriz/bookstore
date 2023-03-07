package com.bookstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.bookstore.daos.BookDAOImpl;
import com.bookstore.models.Book;
import com.bookstore.services.BookService;
import com.bookstore.services.BookServiceImpl;

/**
 * Servlet implementation class GetBookByIdServlet
 */
public class GetBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		BookService bookService = new BookServiceImpl(new BookDAOImpl());
		Book book = bookService.getBookById(id);
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("book", book);
		
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}



}
