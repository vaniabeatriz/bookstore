<%@page import="com.bookstore.models.Book"%>
<%@page import="com.bookstore.models.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
<%
	User current_user =  (User) session.getAttribute("currentUser");
	if(current_user != null) {
%>
	<h3>Hi, <%= current_user.getFirstName() %></h3>
<% } %>
	<!-- HEADER MENU -->
	<table>
		<tr>
			<td>
				<a href="ListBookServlet">Home</a>
			</td>
			<td>
				<a href="book_search.html">Search Book</a>
			</td>
			<td>
				<a href="ViewBasketServlet">My Basket</a>
			</td>
			<td>
				<a href="LoginServlet">Login</a>
			</td>
			<td>
				<a href="RegistrationServlet">Create Account</a>
			</td>
			<td>
				<a href="ViewAccountServlet">My Account</a>
			</td>
		<tr>
	</table>
	<!-- END OF MENU -->

	<% // Scriptlet
		List<Book> bookList =  (List<Book>)session.getAttribute("bList");
	%>

	<table border="1">
		<tr>
			<td> Title  </td>
			<td> Author  </td>
			<td> Price </td>
			<td> Summary </td>
			<td> ISBN </td>
			<td> Add to basket </td>
		</tr>
				
		<%
			for(Book b : bookList){
		%>
		<tr>
			<td><a href="GetBookByIdServlet?id=<%= b.getId() %>"><%= b.getTitle() %></a></td>
			<td> <%= b.getAuthor() %> </td>
			<td> <%= b.getPrice() %> </td>
			<td> <%= b.getSummary() %> </td>
			<td> <%= b.getIsbn() %> </td>
			<td>
				<form action="AddBookToBasketServlet" method="POST">
 					<input type="hidden" name="id" value="<%= b.getId() %>" /> <br>
 					<input type="submit" value="Add to basket"/> 
				</form>
			</td>	
		</tr>
					
		<%
			}
		%>
	
	</table>

</body>
</html>