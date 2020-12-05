package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.DAOFactory;
import modelo.Cliente;

/**
 * Servlet implementation class CreditosController
 */
@WebServlet("/CreditosController")
public class CreditosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
	private Cliente cliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditosController() {
    	clienteDAO = DAOFactory.getFactory().getClienteDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int creditos = Integer.valueOf(request.getParameter("creditos").toString());
		double aux;
		HttpSession session = request.getSession(true);
		String url;
		System.out.println(creditos);
		
		cliente = clienteDAO.read(Integer.valueOf(session.getAttribute("id").toString()));	
		
		if (creditos == 1) {
			request.setAttribute("mensaje", cliente.getCredito());
			System.out.println("1");
			url = "/JSP/creditos.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		} else {
			aux = cliente.getCredito()+creditos;
			cliente.setCredito(aux);
			System.out.println("2");
			clienteDAO.update(cliente);
			url= "/JSP/index.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
