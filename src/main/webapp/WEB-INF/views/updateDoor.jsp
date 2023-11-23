<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update A Door</title>
</head>
<body>
	<form action="/Woods-MVC/doors/update" method="post" class="p-10">
		<h1 class="text-4xl my-2"><b>Enter the id of the<br>door you want to update:</b></h1>
		<div class="border-b border-teal-500 w-min my-2">
			<input type ="number" name = "id" placeholder="ID : "  class="appearance-none bg-transparent border-none text-gray-700 mr-3 py-1 px-2 leading-tight focus:outling-none"> <br>	
		</div>
		<div class="border-b border-teal-500 w-min my-2">
			<input type="text" name="material" placeholder="New Material" class="appearance-none bg-transparent border-none text-gray-700 mr-3 py-1 px-2 leading-tight focus:outling-none">
		</div>
		<div class="border-b border-teal-500 w-min my-2">
			<input type="number" name="height" placeholder="New Height" class="appearance-none bg-transparent border-none text-gray-700 mr-3 py-1 px-2 leading-tight focus:outling-none">
		</div>
		<div class="border-b border-teal-500 w-min my-2">
			<input type="number" name="width" placeholder="New Width" class="appearance-none bg-transparent border-none text-gray-700 mr-3 py-1 px-2 leading-tight focus:outling-none">	
		</div>
		<div class="border-b border-teal-500 w-min my-2">
			<input type="date" name="installationDate" placeholder="New Installation Date" class="appearance-none bg-transparent border-none text-gray-700 mr-3 py-1 px-2 leading-tight focus:outling-none">	
		</div>
		<input type="submit" value="Submit" class="justify-center flex md:hover:text-white md:hover:bg-black text-white rounded-md bg-teal-500 py-2 px-4 mt-2">
	</form>
	
	<script src="https://cdn.tailwindcss.com"></script>
</body>
</html>