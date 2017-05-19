package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
	
	private static Connection con;
	
	/*Método que inicializará la conexión con la BBDD*/
	public static void init(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
			
		}catch(ClassNotFoundException cnfe){
			System.out.println("--No se puede conectar con la base de datos."
					+ " Por favor, consulte el estado del sistema");
		}catch(SQLException sqle){
			System.out.println("--Base de datos inexistente. No se pudo conectar");
		}
	}
	
	public static Connection getConexion(){
		return con;
	}
	
}
