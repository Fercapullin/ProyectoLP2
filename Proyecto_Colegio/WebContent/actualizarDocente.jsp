<%@page import="modelo.Docente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Actualizar Docente</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<%
        Docente docente = (Docente) request.getAttribute("docente");
    %>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-8">
                <h1>Actualizar docente</h1>
                <form action="ServletDocente">
                	<input style="display: none;" type="text" name="tipo" value="actualizar">
                	<input style="display: none;" type="text" name="codigo" value="${ docente.getCodigo() }">
                	<div class="form-group">
                		<label>DNI</label>
                		<input type="text" name="dni" value="${ docente.getDni() }">
                	</div>
                	<div class="form-group">
                		<label>Nombres</label>
                		<input type="text" name="nombres" value="${ docente.getNombres() }">
                	</div>
                	<div class="form-group">
                		<label>Apellidos</label>
                		<input type="text" name="apellidos" value="${ docente.getApellidos() }">
                	</div>
                	<button type="submit" class="btn btn-primary">Actualizar</button>
                </form>
            </div>            
        </div>
    </div>
</body>
</html>