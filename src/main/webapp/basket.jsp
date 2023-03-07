<%@page import="com.bookstore.models.Book"%>
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

	<h1>My Basket</h1>

	<%
		// Read basket from the session
		List<Book> bookList =  (List<Book>)session.getAttribute("basket");
	%>

	<table border="1">
		<tr>
			<td> Title  </td>
			<td> Author  </td>
			<td> ISBN </td>
			<td> Price </td>
			<td> Remove </td>
		</tr>
				
		<%
			// Check if basket is empty
			// Iterate over the book list and add a row for each book
			if(bookList != null) {
				for(int i = 0; i < bookList.size(); i++){
					Book b = bookList.get(i);
		%>
		<tr>
			<td><a href="GetBookById?id=<%= b.getId() %>"><%= b.getTitle() %></a></td>
			<td> <%= b.getAuthor() %> </td>
			<td> <%= b.getIsbn() %> </td>
			<td> <%= b.getPrice() %> </td>
			<td>
				<%
				// Add a Remove button sending the element index of the bookList to be removed
				// from the basket
				%>
				<form action="RemoveBookFromBasketServlet" method="POST">
 					<input type="hidden" name="index" value="<%= i %>" /> <br>
 					<input type="submit" value="Remove"/> 
				</form>
			</td>
		</tr>
					
		<%
				}
			
		%>
	
	<tr>
		<td colspan=3>Total</td>
		<%
		// calculate the total amount of the basket
		%>
		<td colspan=2> <%= bookList.stream().mapToDouble(b -> b.getPrice()).sum() %> </td>
	<tr>
	
	<tr>
		<td colspan=4></td>
		<td colspan=1>
			<form action="CheckoutServlet" method="POST">
				<input type="submit" value="Checkout"/> 
			</form>
		</td>
	</tr>
	<% } else { %>
		<h2>Your basket is empty</h2>				
	<% } %>
	</table>

</body>
</html>