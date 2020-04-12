package Clases;

class Persona {
	protected int id_persona, telefono;
	protected String correo, contraseña;
	
	protected Persona(int id_persona, int telefono, String correo, String contraseña) {
		this.id_persona = id_persona;
		this.telefono = telefono;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	protected int getId_persona() {
		return id_persona;
	}

	protected void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	protected int getTelefono() {
		return telefono;
	}

	protected void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	protected String getCorreo() {
		return correo;
	}

	protected void setCorreo(String correo) {
		this.correo = correo;
	}

	protected String getContraseña() {
		return contraseña;
	}

	protected void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
