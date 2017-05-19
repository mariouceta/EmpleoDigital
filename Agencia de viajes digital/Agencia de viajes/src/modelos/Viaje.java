package modelos;

/**
 * 
 * @author Mario Uceta García
 *
 */
public class Viaje {
	
	//Propiedades del modelo
	
	private int id;
	private String destino;
	private int duracion;
	private double precio;
	
	//Constructores
	public Viaje(){}
	
	public Viaje(int id, String destino, int duracion, double precio){
		this.id = id;
		this.destino = destino;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	public Viaje(String destino, int duracion, double precio){
		this.destino = destino;
		this.duracion = duracion;
		this.precio = precio;
	}

	public String getDestino() {
		return destino;
	}

	public int getDuracion() {
		return duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	public boolean equals(Object o){
		if(o == null ) return false;
		else if(!(o instanceof Viaje))return false;
		else{
			Viaje v = (Viaje)o;
			return v.id==id;
		}
	}
	
}
