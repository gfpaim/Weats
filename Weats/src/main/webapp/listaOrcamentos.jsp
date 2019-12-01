<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Descrição= ${licitacao.descricao}
	<br> Data Inicial= ${licitacao.data_inicio}
	<br> Data final= ${licitacao.data_fim}
	<br>
	<hr>
	<br>
<c:if test="orcamentos.isEmpty()">
Nenhum orçamento recebido. :(
</c:if>

	<c:if test="!orcamentos.isEmpty()">
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
	</c:if>

</body>
</html>