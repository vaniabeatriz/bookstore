package com.bookstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookstore.daos.UserDAOImpl;
import com.bookstore.models.User;
import com.bookstore.services.UserService;
import com.bookstore.services.UserServiceImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Code to capture user's input 
		
		String firstName  = request.getParameter("fname");
		String lastName  = request.getParameter("lname");
		String email   = request.getParameter("email");
		String password   = request.getParameter("password");
		
		
		
		// Create Service class object 
		
		UserService userService = new UserServiceImpl(new UserDAOImpl());
		
		// returns 1 if addUser is successful
		
		int i = userService.addUser(firstName, lastName, email, password);
		
		
		if(i > 0) {
			request.getRequestDispatcher("reg_success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("reg_failure.jsp").forward(request, response);;
		}
	}

}
