package com.bookstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bookstore.daos.UserDAOImpl;
import com.bookstore.models.User;
import com.bookstore.services.UserService;
import com.bookstore.services.UserServiceImpl;

/**
 * Servlet implementation class EditAccountServlet
 */
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("edit_account.jsp").forward(request, response);
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

		// Get the user from the session
		HttpSession session = request.getSession(true);
				
		User currentUser = (User) session.getAttribute("currentUser");
		
		int userId = currentUser.getId();

		// Create Service class object 
		
		UserService userService = new UserServiceImpl(new UserDAOImpl());
		userService.updateUser(userId, firstName, lastName, email, password);
		
		// Update the user and override the session with the new attributes for currentUser object
		
		currentUser.setFirstName(firstName);
		currentUser.setLastName(lastName);
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		session.setAttribute("currentUser", currentUser);
		
		request.getRequestDispatcher("view_account.jsp").forward(request, response);
	}

}
