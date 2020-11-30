<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="modelo.Estudiante"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Estudiante> da = (List<Estudiante>) request.getAttribute("data");
	%>
	<h2 align = "center">LISTADO DE ESTUDIANTES</h2>
	<p align="center">
		<a href="registrarAlumno.jsp">+ Nuevo Registro </a>
		
	<table border="2" align="center" width="75%" class = "table table-striped">
		<tr>
			<th>CODIGO</th>
			<th>NOMBRES</th>
			<th>APELLIDOS</th>
			<th>DNI</th>
			<th>ID_GRADO</th>
			
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

		</tr>
		<%
			}
		}
		%>
	</table>



</body>
</html>