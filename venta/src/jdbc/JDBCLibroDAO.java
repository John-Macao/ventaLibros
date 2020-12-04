package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LibroDAO;
import modelo.Libro;

public class JDBCLibroDAO extends JDBCGenericDAO<Libro, Integer> implements LibroDAO  {

	@Override
	public void create(Libro entity) {
		// TODO Auto-generated method stub
		
	}

	public Libro read(Integer id) {
		Libro libro = null;
		ResultSet rs = sql.query("SELECT * FROM VEN_Libros WHERE lib_id=" + id);
		try {
			if (rs != null && rs.next()) {
				libro = new Libro(rs.getInt("lib_id"), rs.getString("lib_titulo"), rs.getString("lib_autor"),
						rs.getString("lib_edicion"), rs.getDouble("lib_precio"), rs.getString("lib_tipo"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return libro;
	}

	@Override
	public void update(Libro entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Libro entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Libro> find() {
		List<Libro> list = new ArrayList<Libro>();
		ResultSet rs = sql.query("SELECT * FROM VEN_Libros");
		try {
			while (rs.next()) {
				list.add(new Libro(rs.getInt("lib_id"), rs.getString("lib_titulo"), rs.getString("lib_autor"),
						rs.getString("lib_edicion"), rs.getDouble("lib_precio"), rs.getString("lib_tipo")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

}
