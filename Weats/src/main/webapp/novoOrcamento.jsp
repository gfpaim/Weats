<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Or�amento</title>
</head>
<body>
id= ${licitacao.id} <br>
Descri��o= ${licitacao.descricao} <br>
Data Inicial= ${licitacao.data_inicio} <br>
Data final= ${licitacao.data_fim} <br>
UserId= ${licitacao.cliente.id} <br>
<hr> <br>
<form action="./NovoOrcamento" method="post">
	<input name="licitacao_id" type="hidden" value="${licitacao.id }"> 
	Descri��o: <input name="descricao" type="text"> <br> <br>
	Valor: <input name="valor" type="text"> <br> <br> 
	Prazo: <input name="prazo" type="text"> <br> <br> 
	<br>
		<button type="submit">Confirmar</button>
	</form>
</body>
</html>