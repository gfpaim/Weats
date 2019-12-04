<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

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
					<td><a href="./ListaOrcamentos?id=${i.id}">${i.descricao}</a></td>
					<td>${i.data_inicio}</td>
					<td>${i.data_fim}</td>
					<td>Em aberto</td>
					<td><a href="./ExcluirLicitacao?id=${i.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./CriarLicitacao">Nova Licitação</a>
</body>
</html>
