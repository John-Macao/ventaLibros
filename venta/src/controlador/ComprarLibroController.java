package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DAOFactory;
import dao.LibroDAO;
import modelo.Cliente;
import modelo.Factura;
import modelo.Libro;



/**
 * Servlet implementation class ComprarLibroController
 */
@WebServlet("/ComprarLibroController")
public class ComprarLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDao;
	private ClienteDAO clienteDao;
	private List<Libro>listaLibros;
	private Cliente cliente;
	private ArrayList<Factura> facturas;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarLibroController() {
        libroDao=DAOFactory.getFactory().getLibroDAO();
        clienteDao = DAOFactory.getFactory().getClienteDAO();
        cliente = new Cliente();
        facturas = new ArrayList<Factura>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=null;
		int idC =0;
		
		try {
			//Recibimos el id de cliente
			idC = Integer.parseInt(request.getParameter("idC"));
			cliente = clienteDao.read(idC);
			//Recibimos la lista de libros
			listaLibros= libroDao.find();
			System.out.println("El tamaño de la lista es de "+ listaLibros.size());
			//Seteamos el cliente y los libros en Factura
			for (int i = 0; i < listaLibros.size(); i++) {
				Factura aux = new Factura();
				aux.setCliente(cliente);
				aux.setLibro(listaLibros.get(i));
				facturas.add(aux);
			}
			
			
			request.setAttribute("listaFact", facturas);
			url= "/JSP/comprar.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
