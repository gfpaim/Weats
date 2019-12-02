<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c"  %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Orçamento</title>
</head>
<body>
Descrição= ${licitacao.descricao} <br>
Data Inicial= ${licitacao.data_inicio} <br>
Data final= ${licitacao.data_fim} <br>
Cliente= ${licitacao.cliente.getLogin()} <br>
<hr> <br>
<form action="./NovoOrcamento" method="post">
	<input name="licitacao_id" type="hidden" value="${licitacao.id }"> 
	Descrição: <input name="descricao" type="text"> <br> <br>
	Valor: <input name="valor" type="text"> <br> <br> 
	Prazo: <input name="prazo" type="text"> <br> <br> 
	<br>
		<button type="submit">Confirmar</button>
	</form>
</body>
</html>