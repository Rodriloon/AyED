package P1E03;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String email;
	
	public Persona(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String aux = "nombre " + getNombre() + " apellido " + getApellido() + " email " + getEmail();
		return aux;
	}
	
}
