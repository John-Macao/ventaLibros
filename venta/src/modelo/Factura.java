package modelo;

public class Factura {


	private int id;
	 private double subtotal ;
	 private double comision;
	 private double envio ; 
	 private double total ;
	 private Cliente cliente;
	 private Libro libro;
	 
	 
	 public Factura() {
		
	}
	 
	 
	 public Factura(int id, double subtotal, double comision, double envio, double total, Cliente cliente, Libro libro) {
		this.setId(id) ;
		this.setSubtotal(subtotal) ;
		this.setComision(comision) ;
		this.setEnvio(envio) ;
		this.setTotal(total) ;
		this.setCliente(cliente) ;
		this.setLibro(libro) ;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}


	public double getEnvio() {
		return envio;
	}


	public void setEnvio(double envio) {
		this.envio = envio;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	
	 
	 
	 
	 
}
