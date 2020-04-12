package Clases;

public class Ofertas {
	protected int ID;
	protected double descuento;
	
	protected Ofertas(int iD, double descuento) {
		ID = iD;
		this.descuento = descuento;
	}
	protected int getID() {
		return ID;
	}
	protected void setID(int iD) {
		ID = iD;
	}
	protected double getDescuento() {
		return descuento;
	}
	protected void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
