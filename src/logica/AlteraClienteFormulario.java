package logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;

public class AlteraClienteFormulario implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");		
		Integer id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("clienteParaAlterar", new Cliente(id, nome, endereco, null, cpf));
		
		return "/WEB-INF/jsp/formulario-altera.jsp";
	}
	
}
