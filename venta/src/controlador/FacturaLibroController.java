package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DAOFactory;
import dao.FacturaDAO;
import dao.LibroDAO;
import modelo.Cliente;
import modelo.Factura;
import modelo.Libro;

/**
 * Servlet implementation class FacturaLibroController
 */
@WebServlet("/FacturaLibroController")
public class FacturaLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacturaDAO facturaDao;
	private ClienteDAO clienteDao;
	private LibroDAO libroDao;
	private Factura factura;
	private Cliente cliente;
	private Libro libro;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaLibroController() {
        facturaDao= DAOFactory.getFactory().getFacturaDAO();
        clienteDao = DAOFactory.getFactory().getClienteDAO();
        libroDao = DAOFactory.getFactory().getLibroDAO();
        factura = new Factura();
        cliente = new Cliente();
        libro = new Libro();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		String tipo = null;
		int idCl = 0;
		int id= 0;
		double precio= 0;
		
		try {
			idCl = Integer.valueOf(request.getParameter("idCl"));	//Id cliente
			id = Integer.valueOf(request.getParameter("idL"));	//Id Libro
			tipo = request.getParameter("tipoL");	//Tipo Libro
			precio= Double.parseDouble(request.getParameter("precioL"));	//Precio Libro
			
			//Agregamos cliente
			cliente = clienteDao.read(idCl);
			
			//Agregamos Libro
			libro = libroDao.read(id);
			
			//Agregamos Factura
			factura.setCliente(cliente);
			factura.setLibro(libro);
			factura.setSubtotal(precio);
			//Vemos el tipo
			if (tipo.equals("Impreso")) {
				factura.setComision(precio*0.2);
				factura.setEnvio(20.00);
			}else {
				factura.setComision(0);
				factura.setEnvio(0.00);
			}
			factura.setTotal(precio+(Double)factura.getComision()+factura.getEnvio());
			
			//Creamos la factira
			facturaDao.create(factura);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>>ERROR EN EL FACTURA");
		}
		
		request.setAttribute("cliente", cliente);
		url= "/JSP/index.jsp";
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
