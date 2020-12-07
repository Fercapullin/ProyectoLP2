<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.List"%>
    <%@page import="modelo.Detalle_estudiante"%>
   
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
<h2 align ="center" >Detalle de matricula del Estudiante</h2>
<br>
<table border="2" align ="center" width="75%" class = "table table-striped">
<tr>

    <th>Nro Matricula</th>
    <th>Grado</th>
    <th>Seccion</th>
    <th>Curso</th>
    <th>Creditos</th>
</tr>
  <%

	List<Detalle_estudiante> lista = (List<Detalle_estudiante>) request.getAttribute("data");
  
 if (lista != null){
	  
	  for (Detalle_estudiante de : lista){
		  
		  out.println("<tr>");
		  out.println("<td>"+de.getNro_matri()+"</td>");
		   out.println("<td>"+de.getGrado()+"</td>");
			out.println("<td>"+de.getSeccion()+"</td>");
			out.println("<td>"+de.getNombredes()+"</td>");
			out.println("<td>"+de.getCreditos()+"</td>");	

	  }
  }
  %>
</table>
</div>

</body>
</html>