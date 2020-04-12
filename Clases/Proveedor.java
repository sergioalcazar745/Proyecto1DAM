package Clases;

public class Proveedor {
	protected int id_proveedor;
	protected String nombreCompaņia;
	
	protected Proveedor(int id_proveedor, String nombreCompaņia) {
		this.id_proveedor = id_proveedor;
		this.nombreCompaņia = nombreCompaņia;
	}

	protected int getId_proveedor() {
		return id_proveedor;
	}

	protected void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	protected String getNombreCompaņia() {
		return nombreCompaņia;
	}

	protected void setNombreCompaņia(String nombreCompaņia) {
		this.nombreCompaņia = nombreCompaņia;
	}
}
