<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	
	<div class="container-fluid">
	
		<form:form method="post" action="/login/login" modelAttribute="usuario">
		
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre" value="${usuario.getNombre()}"/>
			<br>
			
			<input type="button" value="Limpiar">
			<input type="submit" value="Submit">

		</form:form>
	
		</div>
	<jsp:include page='../template/footer.jsp'/>
	</body>
</html>