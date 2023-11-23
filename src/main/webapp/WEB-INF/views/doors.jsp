<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.spring.pojo.Door" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doors</title>
</head>
<body>
	
<h1 class="justify-center flex text-4xl p-2"><b>---- All Doors Page ----</b></h1>
<% ArrayList<Door> doors = (ArrayList<Door>) request.getAttribute("doors"); %>
<% int numberOfDoors; %>
<% if (doors != null ) { %>
<% numberOfDoors = doors.size(); %>
<% } else { %>
<%  numberOfDoors = 0; %>
<% } %>

<div class="flex justify-center align-middle mt-2">
<table class="rounded bg-black text-white">
	<caption class="caption-top text-black">
    	 Number of doors: <%= numberOfDoors %>
  	</caption>
	<tr class="md:hover:text-red-600">
		<th class="p-3">ID</th>
		<th class="p-3">Material</th>
		<th class="p-3">Height</th>
		<th class="p-3">Width</th>
		<th class="p-3">Installation Date</th>
	</tr>
	
	<% for(Door d : doors) { %>
		<tr class="md:hover:text-blue-600">
			<td class="p-3"> <a href="doors/<%= d.getId() %>"> <%= d.getId() %></a></td>
			<td class="p-3"> <%= d.getMaterial() %> </td>
			<td class="p-3"> <%= d.getHeight() %> </td>
			<td class="p-3"> <%= d.getWidth() %> </td>
			<td class="p-3"> <%= d.getInstallationDate() %> </td>
		</tr>
	<% } %>	
</table>

<div class="flex flex-col ps-24 justify-center">
	<a href="doors/create"  class="justify-center flex mt-5 md:hover:text-blue-600 text-white rounded-md bg-black p-4" >Create Door</a> <br>
	<a href="doors/delete"  class="justify-center flex md:hover:text-blue-600 text-white rounded-md bg-black p-4">Delete Door</a> <br>
	<a href="doors/update"  class="justify-center flex md:hover:text-blue-600 text-white rounded-md bg-black p-4">Update Door</a>
</div>
</div>

<script src="https://cdn.tailwindcss.com"></script>
</body>
</html>