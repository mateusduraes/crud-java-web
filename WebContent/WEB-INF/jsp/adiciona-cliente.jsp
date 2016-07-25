<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Adiciona Cliente</h2>

	<form method="post" action="sistema">	
		<input type="hidden" name="rota" value="AdicionaCliente" />	
		<label>
			Nome:
			<input type="text" name="nome" />
		</label>
		
		<label>
			Endereço:
			<input type="text" name="endereco" />
		</label>
				
		<label>
			CPF:
			<input type="text" name="cpf" />
		</label>
		
		<input type="submit" value="Adicionar Cliente" />
	</form>
</body>
</html>