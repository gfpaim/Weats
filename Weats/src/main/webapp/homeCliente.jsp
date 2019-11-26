<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Cliente</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Descrição</th>
				<th>Data Inicial</th>
				<th>Data Final</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${licitacoes}">
				<tr>
					<td>${i.descricao}</td>
					<td>${i.data_inicio}</td>
					<td>${i.data_fim}</td>
					<td>Em aberto</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="novaLicitacao.jsp">Nova Licitação</a>
</body>
</html>