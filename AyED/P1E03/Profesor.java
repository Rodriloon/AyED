package P1E03;

public class Profesor extends Persona{
	
	private String catedra;
	private String facultad;
	
	public Profesor(String unNombre, String unApellido, String unEmail, String unaCatedra, String unaFacultad) {
		super(unNombre, unApellido, unEmail);
		setCatedra(unaCatedra);
		setFacultad(unaFacultad);
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String tusDatos() {
		String aux;
		aux = super.toString() + ", catedra " + getCatedra() + ", facultad " + getFacultad();
		return aux;
	}
	
}
