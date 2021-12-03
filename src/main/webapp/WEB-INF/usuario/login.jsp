<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

	<body>
	<!--<jsp:include page='../template/navbar.jsp'/>-->
		<div class="container-fluid">
		<h2>INGRESO USUARIO</h2>
	
		<form action="/usuario/login" method="post">
		<label for="email">Email:</label>
		<input type="text" name=email>
		<br>
		<label for="password">Password:</label>
		<input type="password" name="password" placeholder="ingresa password">
		<br>
		<input type="submit" value="ingresar">
		</form>
	
		</div>
	<jsp:include page='../template/footer.jsp'/>
	</body>