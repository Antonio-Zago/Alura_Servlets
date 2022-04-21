<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="UpdadeEmpresasServlet" var="linkServletUpdateEmpresa"/>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form action="${linkServletUpdateEmpresa}" method="post">
	
		<input type="text" name="nome" value="${empresa.nome }">
		<input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
		<input type="hidden" name="id" value="${empresa.id}">
		
		<input type="submit">
	</form>
</body>
</html>