<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="modelo.Estudiante"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">

	<%
		List<Estudiante> da = (List<Estudiante>) request.getAttribute("data");
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
	  <a class="navbar-brand" href="#">Navbar</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Colegio<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ServletEstudiante?tipo=listar">Estudiantes</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ServletDocente?tipo=listar">Docentes</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<h2 align = "center">LISTADO DE ESTUDIANTES</h2>
	<p align="center">
		<a href="RegistrarEstudiante.jsp">+ Agregue un nuevo Estudiante! </a>
		
	<table border="2" align="center" width="75%" class = "table table-striped">
		<tr>
			<th>CODIGO</th>
			<th>NOMBRES</th>
			<th>APELLIDOS</th>
			<th>DNI</th>
			<th>ID_GRADO</th>
			<th colspan="2">ACCIONES</th>
			
			
		</tr>
		<%
			if (da != null) {
			for (Estudiante e : da) {
		%>
		<tr>
			<td><%= e.getCodestudiant() %></td>
			<td><%= e.getNombre() %></td>
			<td><%= e.getApellido()  %></td>
			<td><%= e.getDni() %></td>
			<td><%= e.getId_grado() %></td>
			<td colspan="2" align="center">
            <a href="ServletEstudiante?tipo=buscar&cod=<%= e.getCodestudiant() %>">
            <img title="listar" src="img/edit.gif">Ver matrícula</a>

		</tr>
		<%
			}
		}
		%>
	</table>
</div>
</body>
</html>