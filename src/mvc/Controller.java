package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Logica;

@WebServlet("/sistema")
public class Controller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String rota = request.getParameter("rota");
		String nomeDaClasse = "logica." +rota;
		System.out.println(nomeDaClasse);
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}
	
}
