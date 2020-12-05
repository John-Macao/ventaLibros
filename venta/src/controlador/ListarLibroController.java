package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.FacturaDAO;
import dao.LibroDAO;
import modelo.Factura;
import modelo.Libro;

/**
 * Servlet implementation class ListarLibroController
 */
@WebServlet("/ListarLibroController")
public class ListarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacturaDAO facturaDao;
	private LibroDAO libroDao;
	private List<Factura>listaFacturas;
	private ArrayList<String> titulos;
	private Libro libro;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarLibroController() {
        facturaDao= DAOFactory.getFactory().getFacturaDAO();
        libroDao=DAOFactory.getFactory().getLibroDAO();
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
		
		/*for (Factura f : listaFacturas) {
			titulos.add(libroDao.read(f.getLib_id()).getTitulo());
		}*/
		
		request.setAttribute("facturas", listaFacturas);
		//request.setAttribute("titulos", titulos);
		url = "/JSP/factura.jsp";
	} catch (Exception e) {
		e.printStackTrace();
		//url = "/JSP/error.jsp";
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
