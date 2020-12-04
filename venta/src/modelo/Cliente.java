package modelo;

public class Cliente {

	 private int id;
	 private String nombre;
	 private double credito ; 
	 private String  email;
	 private String contrasena; 
	 private String telefono;
	

	 public Cliente () {
		 
	 }
	 
	 public Cliente(int id, String nombre, double credito, String email, String contrasena, String telefono) {
		this.setId(id);
		this.setNombre(nombre) ;
		this.setCredito(credito) ;
		this.setEmail(email);
		this.setContrasena(contrasena);
		this.setTelefono(telefono);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	 
	
}
