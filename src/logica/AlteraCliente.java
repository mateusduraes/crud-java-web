package logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.Cliente;

public class AlteraCliente implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Connection connection = (Connection) request.getAttribute("conexao");
		new ClienteDAO(connection).altera(new Cliente(id, nome, endereco, null, cpf));
		return "sistema?rota=ListaClientes";
	}

}
