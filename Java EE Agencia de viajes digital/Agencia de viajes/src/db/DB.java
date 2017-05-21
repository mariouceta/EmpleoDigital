package db;

//Librerías importadas
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author Mario Uceta García
 * 
 * Conexiones a la base de datos
 *
 */
public class DB {

	/**
	 * @return Conexion a la base de datos
	 */
	public static Connection getConexion(){
		Connection con=null;
		try {
			DataSource dataSource;
			
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/AgenciaViajes");
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace(); //En caso de error imprimimos la traza del error
		}
		catch(SQLException sqle){
			sqle.printStackTrace(); //En caso de error imprimimos la traza del error
		}
		return con;
	}
}
