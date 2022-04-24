<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="UnicaEntradaServlet" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp"/>
	
	<form action="${linkServletNovaEmpresa}" method="post">
		<input type="text" name="nome">
		<input type="text" name="data">
		<input type="hidden" name="acao" value="NovaEmpresas">
		
		<input type="submit">
	</form>
	
	
</body>
</html>