package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {
	/**
	 * @author Mario
	 * Devuelve la conexión a una base de datos
	 * 
	 */

	public static Connection getConexion(){
		Connection con = null;
		
		try{
			DataSource dataSource;
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/Sim_Ex_2_DB");
			con = dataSource.getConnection();
		
					
		}catch(NamingException ne){
			ne.printStackTrace();
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("EEEEEERRRRROOOOOOOR");
		}	
		return con;
	}
}
