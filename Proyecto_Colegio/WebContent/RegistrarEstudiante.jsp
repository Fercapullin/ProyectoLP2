<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
   <div class = "container">
	<form action="ServletEstudiante?tipo=registrar" id="frmregistro"
		method="post">

		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Formulario de registro de Estudiantess</h1>
			</div>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">Codigo del Estudiante</label> 
			  <input
				class="form-control" name="txt_cod"
				placeholder="Ingrese la descripcion aqui" required 
			    > 
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">Nombres: </label> <input
				class="form-control" name="txt_nom"
				placeholder="Ingrese el nombre aqui" required >
		</div>


		<div class="form-group">
			<label for="exampleInputEmail1">Apellido: </label>
			    <input
				class="form-control" name="txt_ape" placeholder="Ingrese el Apellido aqui" 
				required >
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">DNI:</label> 
			<input
				class="form-control" name="txt_dni" placeholder="Ingrese el nro de dni" 
				required >
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">ID_Grado:</label> 
			<input
				class="form-control" name="txt_grado" placeholder="ingrese el id grado 3AS20" 
				required >
		</div>
		
       <div class="form-group">
       <input type="submit" value="Registrar" class="btn btn-primary btn-lg active">
       </div>
       <div class ="form-group">
		<a href="ServletEstudiante?tipo=listar"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true" class ="form-control">Atras</a><br> 
		<br>
       </div>
	</form>
	</div>





</body>
</html>