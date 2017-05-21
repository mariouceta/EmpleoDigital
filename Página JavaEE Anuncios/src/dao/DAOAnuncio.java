package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import modelos.Anuncio;

public class DAOAnuncio {
	
	
	public ArrayList<Anuncio> getTodos(){
		ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
		
		String sql = "select * from anuncios order by id_anuncio";
		try(Connection con = DB.getConexion()){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Anuncio a = new Anuncio(rs.getInt("id_anuncio"), rs.getString("texto"));
				anuncios.add(a);
			}
			rs.close();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return anuncios;
	}
}
