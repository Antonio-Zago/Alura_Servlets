<%
	String nomeEmpresa = (String)request.getAttribute("empresa");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Empresa Criada: <%out.println(nomeEmpresa);%> 
	<%=nomeEmpresa%>
</body>
</html>

