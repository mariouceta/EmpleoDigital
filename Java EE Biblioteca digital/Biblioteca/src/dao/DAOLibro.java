package dao;

import modelos.Libro;
import datos.BBDD;

import java.sql.*;
import java.util.ArrayList;

public class DAOLibro {
	
	private Connection con= BBDD.getConexion();

	public boolean create(Libro l){
		String sql = "insert into libro (isbn, titulo, autor, paginas)"
				+ " values (?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, l.getIsbn());
			ps.setString(2, l.getTitulo());
			ps.setString(3, l.getAutor());
			ps.setInt(4, l.getPaginas());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException sqle) {
			return false;
		}
	}
	
	public ArrayList<Libro> read(String titulo){
		Libro l = null;
		ArrayList<Libro> libros = new ArrayList<Libro>();

		String sql = "select * from libro where titulo like ?";
		try{
			
			PreparedStatement ps = con.prepareStatement(sql);
			titulo = "%" + titulo + "%";//Insertamos el trozo de título que queremos buscar
			ps.setString(1, titulo);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				l = new Libro(rs.getInt("isbn"),rs.getString("titulo"), rs.getString("autor"), rs.getInt("paginas"));
				libros.add(l);
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return libros;
	}
	
	
	public int delete(Libro l){
		String sql = "delete from libro where isbn = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, l.getIsbn());
			int c = ps.executeUpdate();
			if(c <= 0){
				return 1; //Todo ha ido bien pero no hay libro que borrar
			}else{return 0;//Todo ha ido bien del todo
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			return 2;//Falla la conexion a la BBDD
		}
	}
	
	public ArrayList<Libro> lista(){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		String sql = "select * from libro order by titulo";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Libro l = new Libro(rs.getInt("isbn"),rs.getString("titulo"), rs.getString("autor"), rs.getInt("paginas"));
				libros.add(l);
			}
			
			rs.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return libros;
	}
}
