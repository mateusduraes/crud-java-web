<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="sistema">	
		<input type="hidden" name="rota" value="AlteraCliente" />	
		<label>
			Nome:
			<input type="text" name="nome" value="${clienteParaAlterar.nome}" />
		</label>
		
		<label>
			Endereço:
			<input type="text" name="endereco" value="${clienteParaAlterar.endereco}" />
		</label>
				
		<label>
			CPF:
			<input type="text" name="cpf" value="${clienteParaAlterar.cpf}"/>
		</label>
		
		<input type="hidden" name="id" value="${clienteParaAlterar.id}" />
		
		<input type="submit" value="Adicionar Cliente" />
	</form>
</body>
</html>