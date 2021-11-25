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
		<title>Producto::</title>
	</head>
	
	<body>
		<div class="container-fluid">
	
		<form:form method="post" action="/producto/agregarproducto" modelAttribute="producto">
		
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="descripcion">Descripcion:</form:label>
			<form:input type="text" path="descripcion"/>
			<br>
			<form:label path="precio">Precio:</form:label>
			<form:input type="text" path="precio"/>
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
                    <th scope="col">Descripcion</th>
                    <th scope="col">Precio</th>
                    <th scope="col-2">ACCIONES</th>
                 </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listaProductos}" var="producto" >
            	<tr>
            		<th scope="row">${producto.getId()}</th>
                      <td>${producto.getNombre()}</td>
                      <td>${producto.getDescripcion()}</td>
					  <td>${producto.getPrecio()}</td>
			          <td>
			          	<a href="/producto/${producto.getId()}/editar" class="btn btn-prrimary" role="button" data-bs-toggle="button">Editar</a>
			          	<!--<form action="/producto/actualizar" method="get">
			          		<input type="hidden" name="id" value="${producto.getId()}">
			          		<input type="submit" value="ACTUALIZAR">
			          	</form>-->
			          </td>
			          <td>
			          	<form action="/producto/eliminar" method="get">
			          		<input type="hidden" name="id" value="${producto.getId()}">
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