package Clases;

import java.util.ArrayList;

public class Compra {
	protected Cliente cl;
	protected ArrayList <Articulos> listaArticulos = new ArrayList <Articulos>();
	protected String fechaCompra;
	protected double precioTotal;
	
	protected Compra(Cliente cl, ArrayList<Articulos> listaArticulos, String fechaCompra, double precioTotal) {
		this.cl = cl;
		this.listaArticulos = listaArticulos;
		this.fechaCompra = fechaCompra;
		this.precioTotal = precioTotal;
	}

	protected Cliente getCl() {
		return cl;
	}

	protected void setCl(Cliente cl) {
		this.cl = cl;
	}

	protected ArrayList<Articulos> getListaArticulos() {
		return listaArticulos;
	}

	protected void setListaArticulos(ArrayList<Articulos> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	protected String getFechaCompra() {
		return fechaCompra;
	}

	protected void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	protected double getPrecioTotal() {
		return precioTotal;
	}

	protected void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
}
