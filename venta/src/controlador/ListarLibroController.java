package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.FacturaDAO;
import modelo.Factura;
import modelo.Libro;

/**
 * Servlet implementation class ListarLibroController
 */
@WebServlet("/ListarLibroController")
public class ListarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacturaDAO facturaDao;
	private List<Factura>listaFacturas;
	private Libro libro;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarLibroController() {
        facturaDao= DAOFactory.getFactory().getFacturaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String url = null;
	try {
		
		int idC =Integer.valueOf(request.getParameter("idC"));
		System.out.println("El codigo es: "+ idC);
		
		listaFacturas = facturaDao.listarFactura(idC);
		System.out.println("Tamaño de la Lista: " + listaFacturas.size());
		request.setAttribute("facturas", listaFacturas);
		url = "/JSP/factura.jsp";
	} catch (Exception e) {
		e.printStackTrace();
		url = "/JSP/error.jsp";
	}
	getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
