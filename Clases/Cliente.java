package Clases;

public class Cliente extends Persona{
	protected String nombre, apellidos, fecha_nacimiento;
	protected int telefono;
	
	protected Cliente(int id_persona, int telefono, String correo, String contraseña, String nombre, String apellidos,String fecha_nacimiento, int telefono2) {
		super(id_persona, telefono, correo, contraseña);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		telefono = telefono2;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	protected void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	protected int getTelefono() {
		return telefono;
	}

	protected void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		return "";
	}
}
