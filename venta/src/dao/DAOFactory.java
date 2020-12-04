package dao;


public abstract class DAOFactory {
	protected static DAOFactory factory = new JDBCDAOFactory();
	
	
	
	public static DAOFactory getFactory() {
		return factory;
	}

	public abstract ClienteDAO getClienteDAO();
	public abstract FacturaDAO getFacturaDAO();
	public abstract LibroDAO getLibroDAO();
	
}
