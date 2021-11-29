<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

	<body>
	<jsp:include page='../template/navbar.jsp'/>
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
				 	<th scope="col">#Boleta</th>
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
	<!-- EDITAR -->			<a href="/venta/${venta.getId()}/editar" class="btn btn-prrimary" role="button" data-bs-toggle="button">Editar</a>
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
	
	<jsp:include page='../template/footer.jsp'/>
	</body>
