<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
	
	<form action="LoginServlet" method="POST">
		Email  <input type="text" name="email"/><br>
 		Password  <input type="password" name="password"/><br>
 	<input type="submit" value="LOGIN"/>
 	</form>
</body>
</html>