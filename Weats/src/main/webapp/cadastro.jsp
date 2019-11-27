<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<div id="titulo">
		<h1 align="left">Weats</h1>
	</div>


	<form action="Cadastro" method="post">
		Login: <input name="login" type="text"> <br> <br>
		Senha: <input name="senha" type="password"> <br> <br>
		CNPJ: <input name="cnpj" type="text"> <br> <br>
		ENDEREÇO: <input name="endereco" type="text"> <br> <br>
		PAPEL: <select name="papel">
			<option value="">Selecione</option>
			<option value="0">Cliente</option>
			<option value="1">Fornecedor</option>
		</select>
		<button type="submit">Cadastrar-se</button>
		<br>
		${erro}
	</form>
</body>
</html>