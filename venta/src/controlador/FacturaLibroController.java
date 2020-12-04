package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.FacturaDAO;
import modelo.Factura;

/**
 * Servlet implementation class FacturaLibroController
 */
@WebServlet("/FacturaLibroController")
public class FacturaLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacturaDAO facturaDao;
	private Factura factura ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaLibroController() {
        facturaDao= DAOFactory.getFactory().getFacturaDAO();
        factura = new Factura();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		String tipo = null;
		int id= 0;
		double precio= 0;
		
		try {
			id = Integer.valueOf(request.getParameter("idL"));
			tipo = request.getParameter("tipoL");
			precio= Double.parseDouble(request.getParameter("precioL"));
			if (tipo.equals("impreso")) {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
