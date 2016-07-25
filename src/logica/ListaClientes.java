package logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.Cliente;

public class ListaClientes implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		List<Cliente> lista = clienteDAO.getLista();		
		request.setAttribute("clientes", lista);		
		return "/WEB-INF/jsp/lista-clientes.jsp";
	}

}
