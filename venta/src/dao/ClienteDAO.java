package dao;

import modelo.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, Integer> {

	public abstract Cliente login(String email, String contrasena);
	
}
