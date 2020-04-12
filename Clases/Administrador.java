package Clases;

public class Administrador extends Persona{
	protected double dineroDisponible;

	protected Administrador(int id_persona, int telefono, String correo, String contraseña, double dineroDisponible) {
		super(id_persona, telefono, correo, contraseña);
		this.dineroDisponible = dineroDisponible;
	}

	protected double getDineroDisponible() {
		return dineroDisponible;
	}

	protected void setDineroDisponible(double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
}
