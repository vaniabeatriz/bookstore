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
 * Servlet implementation class RemoveBookFromBasketServlet
 */
public class RemoveBookFromBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBookFromBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index"));
		
		HttpSession session = request.getSession(true);
		List<Book> bookList = (List<Book>) session.getAttribute("basket");
		
		bookList.remove(index);
				
		session.setAttribute("basket", bookList);
		
		request.getRequestDispatcher("basket.jsp").forward(request, response);
	}

}
