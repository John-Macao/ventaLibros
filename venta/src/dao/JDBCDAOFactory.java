package dao;

import jdbc.JDBCClienteDAO;
import jdbc.JDBCFacturaDAO;
import jdbc.JDBCLibroDAO;

public class JDBCDAOFactory extends DAOFactory {

	public ClienteDAO getClienteDAO() {
		return new JDBCClienteDAO();
	}

	public FacturaDAO getFacturaDAO() {
		return new JDBCFacturaDAO();
	}

	public LibroDAO getLibroDAO() {
		return new JDBCLibroDAO();
	}

}
