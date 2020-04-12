package Clases;

public class Articulos {
	protected int id_articulo;
	protected String talla;
	protected double precio;
	
	protected int getId_articulo() {
		return id_articulo;
	}
	protected void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	protected String getTalla() {
		return talla;
	}
	protected void setTalla(String talla) {
		this.talla = talla;
	}
	protected double getPrecio() {
		return precio;
	}
	protected void setPrecio(double precio) {
		this.precio = precio;
	}	
}
