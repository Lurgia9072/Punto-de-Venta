package clases;

public class CSeguridad {
	
	String IdUsuario ;
	String Contraseña;
	public CSeguridad() {
		super();
	}
	public CSeguridad(String idUsuario, String contraseña) {
		super();
		IdUsuario = idUsuario;
		Contraseña = contraseña;
	}
	public String getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	

}
