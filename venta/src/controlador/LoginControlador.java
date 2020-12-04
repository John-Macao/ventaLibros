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
 * Servlet implementation class LoginControlador
 */
@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
	private Cliente cliente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlador() {
        clienteDAO = DAOFactory.getFactory().getClienteDAO();
        cliente = new Cliente();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session;
		
		try {
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");
			
			cliente = clienteDAO.login(mail, pass);
			
			if(cliente.getNombre()!=null) {
				
				session = request.getSession(true);
				session.setAttribute("id", cliente.getId());
				session.setAttribute("nombre", cliente.getNombre());
				request.setAttribute("cliente", cliente);
				url = "/JSP/index.jsp";
				//httpResponse.sendRedirect(url);
			}
			
			else {
				url = "/venta/IniciarSesion.html";
				httpResponse.sendRedirect(url);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			url = "/venta/IniciarSesion.html";
			httpResponse.sendRedirect(url);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
