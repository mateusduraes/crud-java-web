package logica;

import java.sql.Connection;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.Cliente;

public class AdicionaCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = (Connection) request.getAttribute("conexao");
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		Integer id = null;
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		Calendar dataCadastro = Calendar.getInstance();
		String cpf = request.getParameter("cpf");
		Cliente cliente = new Cliente(id, nome, endereco, dataCadastro, cpf);
		clienteDAO.adiciona(cliente);

		// retorna jsp
		return "sistema?rota=ListaClientes";
	}

}
