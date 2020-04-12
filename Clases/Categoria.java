package Clases;

public class Categoria {
	protected int id_categoria;
	protected String nombre, sexo;
	
	protected int getId_categoria() {
		return id_categoria;
	}
	protected void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getSexo() {
		return sexo;
	}
	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
