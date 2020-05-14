package Clases;

public class Articulos {
	public String nombre="";
	public String talla="";
	public int cantidad = 0;
	public double precio = 0;
		
	public Articulos(String nombre, String talla, int cantidad, double precio) {
		super();
		this.nombre = nombre;
		this.talla = talla;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio += precio;
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
