<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='template/header.jsp'/>

<body>
	<jsp:include page='template/navbar.jsp'/>
	<div class="container">
	<h2>Bienvenidos!!</h2>
	 	<ul>
		 	<li><a href="/usuario/registrarjsp">Registrate!</a></li>
		 	<li><a href="/login">Ingresa</a></li> <!-- INGRESO/LOGIN -->
		 </ul>
	</div>
	<jsp:include page='template/footer.jsp'/>
	</body>
</html>