package logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;

public class RemoveContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection connection = (Connection) request.getAttribute("conexao");
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		int id = Integer.parseInt((String) request.getParameter("id"));
		clienteDAO.remove(id);
		return "sistema?rota=ListaClientes";
	}
}
