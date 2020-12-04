package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ClienteDAO;
import modelo.Cliente;

public class JDBCClienteDAO extends JDBCGenericDAO<Cliente, Integer> implements ClienteDAO {

	public Cliente login(String usuairo, String contrasena) {
		Cliente cliente = null;
		ResultSet rs = sql.query("SELECT * FROM VEN_Clientes WHERE cli_email='" + usuairo + "' AND cli_contrasena='" + contrasena +"'");
		try {
			if (rs != null && rs.next()) {
				cliente = new Cliente(rs.getInt("cli_id"), rs.getString("cli_nombre"), rs.getDouble("cli_credito"),
						rs.getString("cli_email"), rs.getString("cli_contrasena"), rs.getString("cli_telefono"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return cliente;
	}
	
	
	
	@Override
	public void create(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	public Cliente read(Integer id) {
		Cliente cliente = null;
		ResultSet rs = sql.query("SELECT * FROM VEN_Clientes WHERE cli_id=" + id);
		try {
			if (rs != null && rs.next()) {
				cliente = new Cliente(rs.getInt("cli_id"), rs.getString("cli_nombre"), rs.getDouble("cli_credito"),
						rs.getString("cli_email"), rs.getString("cli_contrasena"), rs.getString("cli_telefono"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return cliente;
	}

	
	public void update(Cliente cliente) {
		sql.update("UPDATE VEN_Clientes SET cli_credito = " + cliente.getCredito() );
		
	}

	@Override
	public void delete(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
