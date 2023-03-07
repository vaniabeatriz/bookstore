<%@page import="com.bookstore.models.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Information</title>
</head>
<body>

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
		Book book = (Book)session.getAttribute("book");
	%>

	<table border="1">
		<tr>
			<td> ID </td>
			<td> <%= book.getId() %> </td>
		</tr>
		<tr>
			<td> Title  </td>
			<td> <%= book.getTitle() %> </td>
		</tr>
		<tr>
			<td> Author  </td>
			<td> <%= book.getAuthor() %> </td>
		</tr>
		<tr>
			<td> Price </td>
			<td> <%= book.getPrice() %> </td>
		</tr>
		<tr>
			<td> Summary </td>
			<td> <%= book.getSummary() %> </td>
		</tr>
		<tr>
			<td> ISBN </td>
			<td> <%= book.getIsbn() %> </td>
		</tr>
		<tr>
		<td colspan=2>
			<form action="AddBookToBasketServlet" method="POST">
				<input type="hidden" name="id" value="<%= book.getId() %>" /> <br>
				<input type="submit" value="Add to basket"/> 
			</form>
		</td>
		</tr>				
	</table>
</body>
</html>