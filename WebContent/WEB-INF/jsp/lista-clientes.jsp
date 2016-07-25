<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Lista de Clientes</h2>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Endereço</th>
					<th>CPF</th>
					<th>Data de Cadastro</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
		<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td>${cliente.nome}</td>
					<td>${cliente.endereco}</td>
					<td>${cliente.cpf}</td>
					<td>
						<fmt:formatDate value="${cliente.dataCadastro.time}" pattern="dd/MM/yyyy" />
					</td>
					<td>
						<form method="post" action="sistema">
							<input type="hidden" name="rota" value="RemoveContato" />
							<input type="hidden" name="id" value="${cliente.id}" />	
							<input type="submit" value="Remover" />
						</form>
						
						<form method="post" action="sistema">
							<input type="hidden" name="rota" value="AlteraClienteFormulario" />
							<input type="hidden" name="nome" value="${cliente.nome}" />
							<input type="hidden" name="endereco" value="${cliente.endereco}" />
							<input type="hidden" name="cpf" value="${cliente.cpf}" />
							<input type="hidden" name="id" value="${cliente.id}" />
							<input type="submit" value="Alterar Dados" />
						</form>
					</td>	
				</tr>			
		</c:forEach>
			</tbody>
		</table>

</body>
</html>