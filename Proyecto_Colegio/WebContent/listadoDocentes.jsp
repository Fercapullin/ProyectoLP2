<%@page import="modelo.Docente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Docentes</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
</head>
<body>
    <%
        List<Docente> docentes = (List<Docente>) request.getAttribute("docentes");
    %>
    <div class="container">
    	<div class="row justify-content-center">
    		<div class="col-12">
    			<nav class="navbar navbar-light bg-light">
  					<form class="form-inline" action="ServletDocente">
  						<input style="display: none;" type="text" name="tipo" value="buscar">
    					<input class="form-control" type="search" placeholder="Código docente" aria-label="Search" name="cod">
    					<button class="btn btn-outline-success" type="submit">Buscar</button>
  					</form>
				</nav>
    		</div>
    	</div>
        <div class="row">
            <div class="col-12">
                <h1>Lista de Docentes</h1>
                <a class="btn btn-primary rounded" href="registrarDocente.jsp"><i class="fas fa-plus"></i></a>
            </div>            
        </div>
        <br>
        <div class="row">			
			<div class="col-12">
				<table class="table text-center">
					<thead>
						<tr>
							<th class="col-3">Código</th>
							<th class="col-3">DNI</th>
							<th class="col-3">Nombres y apellidos</th>
                            <th class="col-3">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="docente" items="${ docentes }">							
							<tr>
								<td><c:out value="${ docente.getCodigo() }"></c:out></td>
								<td><c:out value="${ docente.getDni() }"></c:out></td>
								<td><c:out value="${ docente.getNombres() }"></c:out></td>
								<td>
                                    <a href="ServletDocente?tipo=actualizar-vista&cod=${ docente.getCodigo() }" class="btn btn-warning rounded-circle"><i class="fas fa-pen-alt"></i></a>
                                    <a href="ServletDocente?tipo=eliminar&cod=${ docente.getCodigo() }" class="btn btn-danger rounded-circle"><i class="fas fa-trash-alt"></i></a>
                                </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
    </div>    
</body>
</html>