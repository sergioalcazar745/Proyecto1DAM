package Clases;

public class Proveedor {
	protected int id_proveedor;
	protected String nombreCompañia;
	
	protected Proveedor(int id_proveedor, String nombreCompañia) {
		this.id_proveedor = id_proveedor;
		this.nombreCompañia = nombreCompañia;
	}

	protected int getId_proveedor() {
		return id_proveedor;
	}

	protected void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	protected String getNombreCompañia() {
		return nombreCompañia;
	}

	protected void setNombreCompañia(String nombreCompañia) {
		this.nombreCompañia = nombreCompañia;
	}
}
