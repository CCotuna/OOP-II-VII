<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Door</title>
</head>
<body>
<h1>Create a Door</h1>
	<form action="/Woods-MVC/doors/create" method="post">
		<input type="text" name="material">
		<input type="number" name="height">
		<input type="number" name="width">
		<input type="date" name="installationDate">
		<input type="submit" value="Submit">
	</form>
</body>
</html>