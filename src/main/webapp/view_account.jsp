<%@page import="com.bookstore.models.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Account</title>
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

	<%
		User current_user =  (User) session.getAttribute("currentUser");
 	%>

	<table border="1">
		<tr>
			<td> ID </td>
			<td> <%= current_user.getId() %> </td>
		</tr>
		<tr>
			<td> First Name  </td>
			<td> <%= current_user.getFirstName() %> </td>
		</tr>
		<tr>
			<td> Last Name  </td>
			<td> <%= current_user.getLastName() %> </td>
		</tr>
		<tr>
			<td> Email </td>
			<td> <%= current_user.getEmail() %> </td>
		</tr>	
	</table>
	<a href="EditAccountServlet">Edit Account</a>

</body>
</html>