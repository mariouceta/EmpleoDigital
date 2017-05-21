package modelos;

public class Libro {
	
	private int isbn;
	private String titulo;
	private String autor;
	private int paginas;
	
	public Libro(int isbn, String titulo, String autor, int paginas){
		this.autor = autor;
		this.isbn = isbn;
		this.paginas = paginas;
		this.titulo = titulo;
	}


	public int getIsbn() {
		return isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	@Override
	public String toString(){
		return "Título: " + titulo
				+ " | ISBN: " + isbn
				+ " | Autor: " + autor
				+ " | Número de páginas: " + paginas;
	}
	
	
}
