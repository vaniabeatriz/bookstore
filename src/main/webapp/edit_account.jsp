<%@page import="com.bookstore.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	User currentUser = (User) session.getAttribute("currentUser");
	%>
	
	<form action="EditAccountServlet" method="POST">
		First Name <input type="text" name="fname" value="<%= currentUser.getFirstName() %>"/><br>
		Last Name <input type="text" name="lname" value="<%= currentUser.getLastName() %>"/><br>
		Email  <input type="text" name="email" value="<%= currentUser.getEmail() %>"/><br>
 		Password  <input type="password" name="password" value="<%= currentUser.getPassword() %>"/><br>
 		<input type="submit" value="UPDATE ACCOUNT"/>
 	</form>
</body>
</html>