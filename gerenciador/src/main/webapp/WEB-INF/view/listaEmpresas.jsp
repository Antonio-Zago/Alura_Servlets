<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="logout-parcial.jsp"/>


	Usuario Logado: ${usuarioLogado.login }
	
	<br>
	<br>
	<br>
	
	Lista de Empresas:<br>
	
	<ul>
		<c:forEach items="${empresas }" var="empresa">
			
			<li>
				${empresa.nome } -  <!-- Acessa o getNome() -->
				<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/UnicaEntradaServlet?acao=RemoverEmpresas&id=${empresa.id}">Remover</a>
				<a href="/gerenciador/UnicaEntradaServlet?acao=MostraEmpresas&id=${empresa.id}">Atualizar</a>
			</li>
		</c:forEach>
	</ul>
	
	

</body>
</html>