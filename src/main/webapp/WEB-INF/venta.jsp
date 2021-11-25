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
		<title>Venta::</title>
	</head>
	
	<body>
		<div class="container-fluid">
	
		<form:form method="post" action="/venta/generarventa" modelAttribute="venta">
		
			<form:label path="precio">Monto:</form:label>
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
                    <th scope="col">Monto</th>
                    <th scope="col-2">ACCIONES</th>
                 </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listaVentas}" var="venta" >
            	<tr>
            		<th scope="row">${venta.getId()}</th>
                      <td>${venta.getPrecio()}</td>
			          <td>
			          	<form action="/venta/actualizar" method="get">
			          		<input type="hidden" name="id" value="${venta.getId()}">
			          		<input type="submit" value="ACTUALIZAR">
			          	</form>
			          </td>
			          <td>
			          	<form action="/venta/eliminar" method="get">
			          		<input type="hidden" name="id" value="${venta.getId()}">
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