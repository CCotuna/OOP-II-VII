<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete A Door</title>
</head>
<body>
	<h1> Enter the id of the door you want to delete:</h1>
	<form action="/Woods-MVC/doors/delete" method="post">
		<input type ="number" name = "id">
		<input type ="submit" value ="Submit">
	</form>
</body>
</html>