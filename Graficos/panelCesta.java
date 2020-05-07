package Graficos;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class panelCesta extends JPanel {

	public panelCesta(Gestion gdb, conexion conx) {
		/*IMPORTANTE CAMBIAR EL METODO DE GESTION PUESTO QUE TENFRA QUE GUARDAR EN EL CARRO 
		 * NO SOLO EL NOMBRE SI NO TAMBIEN LA TALLA Y LA CANTIDAD DE ESA FORMA EN ESTE METODO NOS AHORRAREMOS PANELES*/
		setBounds(0, 0, 853, 496);
		setLayout(new GridLayout(1, 1, 0, 0));
		ArrayList<String> array_articulos=new ArrayList<String>();
		array_articulos=gdb.getArray_articulosCesta();
		
		setLayout(new GridLayout(array_articulos.size(), 1, 0, 0));
		
		ArrayList<JPanel> array_paneles=new ArrayList<JPanel>();
		
		for (String nombre_articulo: array_articulos) {
			JPanel panel_Articulo=new panel_Articulo(nombre_articulo, gdb);
			desactivarBotones(panel_Articulo);
			array_paneles.add(panel_Articulo);
		}
		//System.out.println("abse_datos: "+array_paneles.size());
		for(int i=0; i<array_paneles.size(); i++) {
			add(array_paneles.get(i));
			System.out.println("añadido: "+i);
		}
		setPreferredSize(new Dimension(825, 496*array_articulos.size()));
		
		//insertamos toods los paneles de articulo
	}
	
	public void desactivarBotones(JPanel panel) {
		Component[] components = panel.getComponents();
		for (int i = 0; i < components.length; i++) {
			if(components[i] instanceof JButton) {
				components[i].setVisible(false);
			}
		}
	}
}
