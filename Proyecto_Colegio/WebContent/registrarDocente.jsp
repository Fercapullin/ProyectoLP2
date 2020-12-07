<%@page import="modelo.Docente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registrar Docente</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<%
        List<Docente> docentes = (List<Docente>) request.getAttribute("docentes");
    %>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-8">
                <h1>Registrar docente</h1>
                <form action="ServletDocente">
                	<input style="display: none;" type="text" name="tipo" value="registrar">
                	<div class="form-group">
                		<label>DNI</label>
                		<input type="text" name="dni">
                	</div>
                	<div class="form-group">
                		<label>Nombres</label>
                		<input type="text" name="nombres">
                	</div>
                	<div class="form-group">
                		<label>Apellidos</label>
                		<input type="text" name="apellidos">
                	</div>
                	<button type="submit" class="btn btn-primary">Registrar</button>
                </form>
            </div>            
        </div>
    </div>
</body>
</html>