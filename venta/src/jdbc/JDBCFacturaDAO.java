package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.FacturaDAO;
import dao.LibroDAO;
import modelo.Cliente;
import modelo.Factura;
import modelo.Libro;

public class JDBCFacturaDAO extends JDBCGenericDAO<Factura, Integer> implements FacturaDAO {

	private LibroDAO libroDAO;
	
	@Override
	public void create(Factura entity) {
		sql.update("INSERT VEN_Facturas VALUES (0, " + entity.getComision() + ", "
				+ entity.getSubtotal() + ", "+ entity.getEnvio() + ", " + entity.getTotal() + ", "+  + entity.getCliente().getId() +","+ entity.getLibro().getId() + ")");
		
	}
	
	public void crear(Factura factura, int cli_id, int lib_id) {
		
		sql.update("INSERT VEN_Facturas VALUES (0, " + factura.getComision() + ", "
				+ factura.getSubtotal() + ", "+ factura.getEnvio() + ", " + factura.getTotal() + ", "+  + cli_id +","+ lib_id + ")");
	}

	public Factura read(Integer id) {
		Factura factura = null;
		ResultSet rs = sql.query("SELECT * FROM VEN_Facturas WHERE fac_id=" + id);
		try {
			if (rs != null && rs.next()) {
				factura = new Factura(rs.getInt("fac_id"), rs.getDouble(" fac_subtotal "), rs.getDouble("fac_comision"),
						rs.getDouble("fac_envio"), rs.getDouble("fac_total"),  null, null);
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return factura;
	}

	@Override
	public void update(Factura entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Factura entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Factura> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Factura> listarFactura(int idC ) {
		List<Factura> list = new ArrayList<Factura>();
		Cliente cli = new Cliente ();
		Libro lib;
		ResultSet rs = sql.query("SELECT * FROM VEN_Facturas WHERE cli_id=" + idC );
		libroDAO = DAOFactory.getFactory().getLibroDAO();
		
		try {
			while (rs.next()) {
				
				list.add(new Factura(rs.getInt("fac_id"), rs.getDouble("fac_subtotal"), rs.getDouble("fac_comision"),
						rs.getDouble("fac_envio"), rs.getDouble("fac_total"), null, null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}


}
