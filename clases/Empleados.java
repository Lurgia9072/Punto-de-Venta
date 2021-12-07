package clases;

public class Empleados {
	
	
	String cod ;
	String Apellidos;
	String Nombres;
	int Edad;
	String Sexo;
	
	public Empleados() {
		super();
	}
	public Empleados(String cod, String apellidos, String nombres, int edad, String sexo) {
		super();
		this.cod = cod;
		Apellidos = apellidos;
		Nombres = nombres;
		Edad = edad;
		Sexo = sexo;
	}
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	

}
