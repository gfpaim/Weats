<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"  %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Fornecedor</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Licitação</th>
				<th>Descrição</th>
				<th>Data Final</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${licitacoes}">
				<tr>
					<td>${i.cliente.getLogin()}</td>
					<td><a href="./NovoOrcamento?id=${i.id}">${i.descricao}</a></td>
					<td>${i.data_fim}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>