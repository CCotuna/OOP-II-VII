<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update A Door</title>
</head>
<body>
<h1> Enter the id of the door you want to update:</h1>
	<form action="/Woods-MVC/doors/update" method="post">
		<input type ="number" name = "id" placeholder="ID of the door you wanna update"> <br>
		<input type ="text" name = "material" placeholder="New material"> <br>
		<input type ="number" name = "height" placeholder="New height"> <br>
		<input type ="number" name = "width" placeholder="New width"> <br>
		<input type ="Date" name = "installationDate" placeholder="New installation date"> <br>
		
		<input type ="submit" value ="Submit">
	</form>
</body>
</html>