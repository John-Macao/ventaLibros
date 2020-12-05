package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {
	

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/venta_libros";
	//private static final String URL = "jdbc:mysql://127.0.0.1:3307/pedidos?serverTimezone=UTC";
	private static final String USER = "root";
	//private static final String PASS = "Patito.123@456";
	//private static final String PASS = "";
	private static final String PASS = "DFTUrptu9799";
	private static ContextJDBC jdbc = null;	
	private Statement statement = null;

	public ContextJDBC() {
		this.connect();
	}

	
	public void connect() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			this.statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con el driver\n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con la BD\n" + e.getMessage());
		}
	}

	
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:query): ---" + sql + "---" + e);
		}
		return null;
	}

	
	public boolean update(String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:update)... actualizacion: ---" + sql + "---" + e);
			return false;
		}
	}

	
	protected static ContextJDBC getJDBC() {
		if (jdbc == null) {
			jdbc = new ContextJDBC();
		}
		return jdbc;

	}
	
}
