package clases;
import java.sql.*;
import java.util.ArrayList;

public class ConeccionUsuario {
	
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/CL3";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<CSeguridad> miLista;
	
	public ConeccionUsuario(){
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Clave);
		} catch (Exception e) {
			System.out.println("ERROR CONECCION:" + e.getMessage());
		}
	}

	
	public CSeguridad ValidarVendedor(String usu, String pass){
		String SQL = "call VerificarUsuario(?,?)";
		CSeguridad ObjV = null;
		try{
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, usu);
			Stmt.setString(2, pass);
			Rs = Stmt.executeQuery();
			if(Rs.next()) {
				ObjV = new CSeguridad(Rs.getString("IdUsuario"),
						Rs.getString("Contraseña"));
			}
			Rs.close();
			
		}catch(Exception e){
			System.out.println("ERROR VALIDAR VENDEDOR:" + e.getMessage());
		}
		return ObjV;
	}
	
	
	
	
}
