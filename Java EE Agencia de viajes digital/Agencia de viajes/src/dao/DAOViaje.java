package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import modelos.Viaje;

public class DAOViaje {

	public ArrayList<Viaje> listar(){
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		
		String sql="select * from viajes";
		try(Connection con=DB.getConexion();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);){
			
			while(rs.next()){
				Viaje v= new Viaje(rs.getInt("id"),rs.getString("destino"), rs.getInt("duracion"), rs.getDouble("precio"));
				lista.add(v);
			}
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Viaje> buscar(String palabra){
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		
		String sql="select * from viajes where destino like ?";
		
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,"%"+palabra+"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Viaje v= new Viaje(rs.getInt("id"),rs.getString("destino"), rs.getInt("duracion"), rs.getDouble("precio"));
				lista.add(v);
			}


			
			rs.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return lista;
	
	}
	
	public Viaje getViaje(int id){
		Viaje v=null;
		
		String sql="select * from viajes where id=?";
		
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				v= new Viaje(rs.getInt("id"),rs.getString("destino"), rs.getInt("duracion"), rs.getDouble("precio"));

			}
			
			rs.close();
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return v;
	}
	
	
}
