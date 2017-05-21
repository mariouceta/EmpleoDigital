package modelos;

import java.io.Serializable;

public class Anuncio implements Serializable{
	
	
	/**
	 * @author Mario Uceta
	 */
	public static final long serialVersionUID = 1L;
	private int idAnuncio;
	private String texto;
	
	public Anuncio(){
		
	}
	
	public Anuncio(int idAnuncio, String texto){
		this.idAnuncio = idAnuncio;
		this.texto = texto;
	}

	public int getidAnuncio() {
		return idAnuncio;
	}

	public String getTexto() {
		return texto;
	}

	public void setidAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
