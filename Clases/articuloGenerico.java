package Clases;

import java.awt.Image;

public class articuloGenerico {
	Image imagen;
	String nombre;
	public articuloGenerico(Image img, String nombre) {
		this.imagen=img;
		this.nombre=nombre;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
