package Clases;

public class Articulos {
	public String nombre;
	public String talla;
	public int cantidad;
	
	public Articulos(String nombre, String talla, int cantidad) {
		this.nombre = nombre;
		this.talla = talla;
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}	
}
