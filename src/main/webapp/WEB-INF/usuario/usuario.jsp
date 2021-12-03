<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

	<body>
	<jsp:include page='../template/navbar.jsp'/>
		<div class="container-fluid">
	
		<form:form method="post" action="/usuario/registrar" modelAttribute="usuario">
		
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
				 	<th scope="col">#ID</th>
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
						<a href="/usuario/${usuario.getId()}/editar" class="btn btn-prrimary" role="button" data-bs-toggle="button">Editar</a>
						
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
	
	<jsp:include page='../template/footer.jsp'/>
	</body>