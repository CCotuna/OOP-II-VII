<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.spring.pojo.Door"  %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <div class="rounded bg-black w-min p-4">
    	<p class="text-white">Hi there </p>
    </div>

	<% Door door = (Door) request.getAttribute("door");%>
	<% if(door != null) { %>
	<p> Door id: <%=door.getId() %></p>
		<p> Door material: <%=door.getMaterial() %></p>
			<p> Door height: <%=door.getHeight() %></p>
				<p> Door width: <%=door.getWidth() %></p>
					<p> Door installationDate: <%=door.getInstallationDate() %></p>
	<%} %>
	
	<a href="/Woods-MVC/doors">Back to homepage.</a>

	<script src="https://cdn.tailwindcss.com"></script>
</body>
</html>