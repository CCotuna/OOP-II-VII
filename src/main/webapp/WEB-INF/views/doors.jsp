<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.Door" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doors</title>
</head>
<body>
	
<h1>All Doors Page</h1>
<% ArrayList<Door> doors = (ArrayList<Door>) request.getAttribute("doors"); %>
<% int numberOfDoors; %>
<% if (doors != null ) { %>
<% numberOfDoors = doors.size(); %>
<% } else { %>
<%  numberOfDoors = 0; %>
<% } %>

<p> Number of doors: <%= numberOfDoors %></p>

<table border="1">
	<tr>
		<th>ID</th>
		<th>Material</th>
		<th>Height</th>
		<th>Width</th>
		<th>Installation Date</th>
	</tr>
	
	<% for(Door d : doors) { %>
		<tr>
			<td> <a href="doors/<%= d.getId() %>"> <%= d.getId() %></a></td>
			<td> <%= d.getMaterial() %> </td>
			<td> <%= d.getHeight() %> </td>
			<td> <%= d.getWidth() %> </td>
			<td> <%= d.getInstallationDate() %> </td>
		</tr>
	<% } %>	
</table>
	
</body>
</html>