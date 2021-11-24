<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
		<meta charset="ISO-8859-1">
		<title>Usuario::</title>
	</head>
	
	<body>
		<div class="container-fluid">
	
		<form:form method="post" action="/usuario/login" modelAttribute="usuario">
		
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input type="text" path="apellido"/>
			<br>
			<form:label path="edad">Edad:</form:label>
			<form:input type="text" path="edad"/>
			<br>
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"/>
			<br>
			<input type="button" value="Limpiar">
			<input type="submit" value="Submit">

		</form:form>
	
		</div>
	
		<div>
	
		<table class="table">
			<thead>
				 <tr>
				 	<th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Edad</th>
                    <th scope="col">Email</th>
                    <th scope="col-2">ACCIONES</th>
                 </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listaUsuarios}" var="usuario" >
            	<tr>
            		<th scope="row">${usuario.getId()}</th>
                      <td>${usuario.getNombre()}</td>
                      <td>${usuario.getApellido()}</td>
					  <td>${usuario.getEdad()}</td>
			          <td>${usuario.getEmail()}</td>
			          <td>
			          	<form action="/usuario/actualizar" method="get">
			          		<input type="hidden" name="id" value="${usuario.getId()}">
			          		<input type="submit" value="ACTUALIZAR">
			          	</form>
			          </td>
			          <td>
			          	<form action="/usuario/eliminar" method="get">
			          		<input type="hidden" name="id" value="${usuario.getId()}">
			          		<input type="submit" value="X">
			          	</form>
			          
			          </td>
              	</tr>
                </c:forEach>
            </tbody>
          </table>
	
	</div>
	

	</body>
</html>