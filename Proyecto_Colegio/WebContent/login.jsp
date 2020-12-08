<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Iniciar SesiÃ³n</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
        integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
</head>

<body>
	<%
		String error = (String) request.getAttribute("error");
	%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3 mt-5 pt-5">
                <img src="" alt="">
                <form action="ServletLogin">
                    <h3>Hola</h3>
                    <h6>Inicia sesión con tu cuenta</h6>
                    <br>
                    <div class="form-group">
                        <input class="form-control" type="text" name="user" placeholder="Su usuario">
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="password" placeholder="Su contraseña">
                    </div>
                    <button class="btn btn-primary btn-block" type="submit">Iniciar Sesión</button>
                </form>
                <br>
                <c:if test="${ error != null }">
                	<div class="alert alert-danger" role="alert">
  						<c:out value="${ error }"></c:out>
					</div>
                </c:if>
            </div>
            <div class="col-1"></div>
            <div class="col-7">
                <img src="equilateral.svg" alt="img banner" height="100" width="100" />
                <h5>¡Empieza tu aventura aprendiendo sin parar
                    y muéstrale al mundo lo mejor que puedes
                    llegar a ser!
                </h5>
            </div>
        </div>
    </div>
</body>

</html>