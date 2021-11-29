<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>


<body>
<jsp:include page='../template/navbar.jsp'/>
	
	
	<div class="container-fluid">

		<form:form method="post" action="/categoria/crear" modelAttribute="categoria">
		
			<form:label path="nombre">Nombre Categoria:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="descripcion">Descripcion:</form:label>
			<form:input type="text" path="descripcion"/>
			<br>
			<input type="button" value="Limpiar">
			<input type="submit" value="Submit">

		</form:form>

		
	 <table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Descripcion</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaCategorias}" var="categoria">
			    <tr>
			      <th scope="row">${categoria.getId()}</th>
			      <td>${categoria.getNombre()}</td>
			      <td>${categoria.getDescripcion()}</td>
			      
			      <td>
			      <a href="/categoria/${categoria.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
			
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
<jsp:include page='../template/footer.jsp'/>
</body>
