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
                <h1>Docentes</h1>
                <a class="btn btn-primary rounded" href="registrarDocente.jsp"><i class="fas fa-plus"></i></a>
            </div>            
        </div>
        <br>
        <div class="row">			
			<div class="col-12">
				<table class="table text-center">
					<thead>
						<tr>
							<th class="col-2">Código</th>
							<th class="col-2">DNI</th>
							<th class="col-4">Nombres y apellidos</th>
                            <th class="col-2">Acciones</th>
                            <th class="col-2">Contrato</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="docente" items="${ docentes }">							
							<tr>
								<td><c:out value="${ docente.getCodigo() }"></c:out></td>
								<td><c:out value="${ docente.getDni() }"></c:out></td>
								<td><c:out value="${ docente.getNombres() } ${ docente.getApellidos() }"></c:out></td>
								<td>
                                    <a href="ServletDocente?tipo=actualizar-vista&cod=${ docente.getCodigo() }" class="btn btn-warning rounded-circle"><i class="fas fa-pen-alt"></i></a>
                                    <a href="ServletDocente?tipo=eliminar&cod=${ docente.getCodigo() }" class="btn btn-danger rounded-circle"><i class="fas fa-trash-alt"></i></a>
                                </td>
                                <td>
                                	<a href="" class="btn btn-white rounded-circle"><i class="fas fa-file-contract"></i></a>
                                    <a href="" class="btn btn-white text-dark rounded-circle"><i class="fas fa-file-signature"></i></a>
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