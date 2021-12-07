package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cempleado {

	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/CL3";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	public Connection Cn;
	public Statement Cmd;
	public CallableStatement Stmt;
	public ResultSet Rs;
	public ArrayList<Empleados> miLista;
	//public executeQuery exe;
	
	
	public Cempleado(){
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Clave);
		} catch (Exception e) {
			System.out.println("ERROR CONECCION:" + e.getMessage());
		}
	}

	
	
	//METODO LISTAR CLIENTE
		public ArrayList<Empleados> Listar(){
			String SQL = "call ListarEmpleados();";
			miLista = new ArrayList<Empleados>();
			try {
					Cmd = Cn.createStatement();
					Rs = Cmd.executeQuery(SQL);
					while(Rs.next()) {
						miLista.add(new Empleados(Rs.getString("IdEmpleado"),
								Rs.getString("Apellidos"),
								Rs.getString("Nombres"),
								Rs.getInt("Edad"),
								Rs.getString("Sexo")));
					}
					Rs.close();		
					
					System.out.println("puede listar");
			} catch (Exception e) {
				System.out.println("ERROR LISTAR CLIENTE:" + e.getMessage());
			}
			return miLista;
			
			
		}
		
		
		//METODO INSERTAR PRODUCTO
		public void Insertar(Empleados ObjP){
			String SQL = "call InsertarEmpleados(?,?,?,?,?)";
			try {
					Stmt = Cn.prepareCall(SQL);
					Stmt.setString(1, ObjP.getCod());
					Stmt.setString(2, ObjP.getApellidos());
					Stmt.setString(3, ObjP.getNombres());
					Stmt.setInt(4, ObjP.getEdad());
					Stmt.setString(5, ObjP.getSexo());				
					Stmt.executeUpdate();
			} catch (Exception e) {
					System.out.println("ERROR INSERTAR EMPLEADO:" + e.getMessage());
			}
		}
	

		//METODO MODIFICAR PRODUCTO
		public void Modificar(Empleados ObjP){
			String SQL = "call ModificaEmpleado(?,?,?,?,?)";
			try {
					Stmt = Cn.prepareCall(SQL);
					Stmt.setString(1, ObjP.getCod());
					Stmt.setString(2, ObjP.getApellidos());
					Stmt.setString(3, ObjP.getNombres());
					Stmt.setInt(4, ObjP.getEdad());
					Stmt.setString(5, ObjP.getSexo());
					Stmt.executeUpdate();
			} catch (Exception e) {
					System.out.println("ERROR MODIFICAR EMPLEADO:" + e.getMessage());
			}
		}
	
		
		//METODO SUPRIMIR PRODUCTO
		public void Suprimir(String Id){
			String SQL = "call SuprimirEmpleado(?)";
			try {
					Stmt = Cn.prepareCall(SQL);
					Stmt.setString(1, Id);
					Stmt.executeUpdate();
			} catch (Exception e) {
					System.out.println("ERROR SUPRIMIR EMPLEADO:" + e.getMessage());
			}
		}
		
		//METODO PARA GENERAR CODIGO
		public String GeneraCodigoProducto() {
			String SQL = "call GenerarCodigo()", nuevo = "";
			try {
					Cmd = Cn.createStatement();
					Rs = Cmd.executeQuery(SQL);
					if(Rs.next()) {
							nuevo = Rs.getString(1);
					}
					Rs.close();
			} catch (Exception e) {
				System.out.println("ERROR GENERAR CODIGO:" + e.getMessage());
			}
			return nuevo;
		}
		
		
		
		////////////////////////////
		
		public Empleados Buscar(String Id){
			String SQL = "select * from Empleado where IdEmpleado =?";
			Empleados ObjP = null;
			try {
					Stmt = Cn.prepareCall(SQL);
					Stmt.setString(1, Id);
					Rs = Stmt.executeQuery();
					if(Rs.next()) {
						ObjP = new Empleados(Rs.getString("IdEmpleado"),
								Rs.getString("Apellidos"),
								Rs.getString("Nombres"),
								Rs.getInt("Edad"),
								Rs.getString("Sexo"));
					}
					Rs.close();
					System.out.println("pude buscar");
			} catch (Exception e) {
					System.out.println("ERROR BUSCAR Empleando por id:" + e.getMessage());
			}
			return ObjP;
		}
	
		
		
		public Empleados BuscarApellido(String Id){
			String SQL = "select * from Empleado where Apellidos =?";
			Empleados ObjP = null;
			try {
					Stmt = Cn.prepareCall(SQL);
					Stmt.setString(1, Id);
					Rs = Stmt.executeQuery();
					if(Rs.next()) {
						ObjP = new Empleados(Rs.getString("IdEmpleado"),
								Rs.getString("Apellidos"),
								Rs.getString("Nombres"),
								Rs.getInt("Edad"),
								Rs.getString("Sexo"));
					}
					Rs.close();
					System.out.println("pude buscar");
			} catch (Exception e) {
					System.out.println("ERROR BUSCAR Empleando por id:" + e.getMessage());
			}
			return ObjP;
		}
		
		public Empleados BuscarEdad(int Id){
			String SQL = "select * from Empleado where Edad =?";
			Empleados ObjP = null;
			try {
					Stmt = Cn.prepareCall(SQL);
					Stmt.setInt(1, Id);
					Rs = Stmt.executeQuery();
					if(Rs.next()) {
						ObjP = new Empleados(Rs.getString("IdEmpleado"),
								Rs.getString("Apellidos"),
								Rs.getString("Nombres"),
								Rs.getInt("Edad"),
								Rs.getString("Sexo"));
					}
					Rs.close();
					System.out.println("pude buscar");
			} catch (Exception e) {
					System.out.println("ERROR BUSCAR Empleando por id:" + e.getMessage());
			}
			return ObjP;
		}
	
}
