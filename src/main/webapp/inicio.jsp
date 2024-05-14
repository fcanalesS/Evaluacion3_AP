<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class='container-fluid'>
		<div class='row'>
			<div class='col'>
				<h1>Datos del Usuario</h1>
			</div>
		</div>
		<hr>
		<div class='row'>
			<div class='col'>
				<% 
					String username = (String) request.getSession().getAttribute("username");
					if (username == null) {
					    // Redireccionar al usuario a la página de login
					    response.sendRedirect("login.jsp");
					} else {
					    // Mostrar la página de bienvenida
					    out.println("<h1>Bienvenido, " + username + "</h1>");
					}
				%>
			</div>
			
		</div>
	</div>
</body>
</html>