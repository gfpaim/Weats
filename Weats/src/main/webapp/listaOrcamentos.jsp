<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orçamentos Recebidos</title>
</head>
<body>
	Descrição= ${licitacao.descricao}
	<br> Data Inicial= ${licitacao.data_inicio}
	<br> Data final= ${licitacao.data_fim}
	<br>
	<hr>
	<br>
	<c:choose>
	<c:when test="${orcamentos.isEmpty() }">Nenhum orçamento recebido. :(</c:when>
	
	<c:otherwise>
	<table border="1">
			<thead>
				<tr>
					<th>Fornecedor</th>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Prazo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${orcamentos}">
					<tr>
						<td>${i.fornecedor.getLogin()}</td>
						<td>${i.descricao}</td>
						<td>${i.valor}</td>
						<td>${i.prazo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
	</c:choose>

</body>
</html>