<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weats Cliente</title>
</head>
<body>
	<input name="Usuario" type="hidden" value="${usuario}">
	<div>Usuario: ${usuario.login} CNPJ: ${usuario.cnpj}</div>
	<br><hr><br>
	<form action="./NovaLicitacao" method="post">
		Descrição: <input name="descricao" type="text"> <br> <br>
		Data de inicio: <input name="data_inicio" type="text"> <br>
		<br> Data final: <input name="data_final" type="text"> <br>
		<br> Observações: <input name="obs" type="text"> <br>
		<br>
		<button type="submit">Confirmar</button>
	</form>

</body>
</html>