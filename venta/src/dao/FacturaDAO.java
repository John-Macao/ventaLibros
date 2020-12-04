package dao;

import java.util.List;

import modelo.Cliente;
import modelo.Factura;

public interface FacturaDAO extends GenericDAO<Factura, Integer> {
	public abstract void crear(Factura factura,  int cli_id, int lib_id);
	public abstract List<Factura> listarFactura(int id_fac , Cliente cliente);
}
