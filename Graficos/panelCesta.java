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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class panelCesta extends JPanel {
	ArrayList<String> array_articulos=new ArrayList<String>();
	ArrayList<JPanel> array_paneles=new ArrayList<JPanel>();
	Gestion gdb;
	conexion conx;
	int fila=0;
	public panelCesta(Gestion gdb, conexion conx) {
		/*IMPORTANTE CAMBIAR EL METODO DE GESTION PUESTO QUE TENFRA QUE GUARDAR EN EL CARRO 
		 * NO SOLO EL NOMBRE SI NO TAMBIEN LA TALLA Y LA CANTIDAD DE ESA FORMA EN ESTE METODO NOS AHORRAREMOS PANELES*/
		setBounds(0, 0, 853, 496);
		setLayout(new GridLayout(1, 1, 0, 0));
		array_articulos=gdb.getArray_articulosCesta();
		fila=array_articulos.size();
		System.out.println("fila antes: "+fila);
		setLayout(new GridLayout(array_articulos.size(), 1, 0, 0));
		
		
		for (String nombre_articulo: array_articulos) {
			JPanel panel_Articulo=new panel_Articulo(nombre_articulo, gdb);
			desactivarBotones(panel_Articulo);
			array_paneles.add(panel_Articulo);
		}
		//System.out.println("abse_datos: "+array_paneles.size());
		for(int i=0; i<array_paneles.size(); i++) {
			add(array_paneles.get(i));
			array_paneles.get(i).setName(String.valueOf(i));
			System.out.println(array_paneles.get(i).getName());
			array_paneles.get(i).addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent evento) {
					Object name=evento.getComponent().getName();
					System.out.println("NAME: "+name);
					Component[] array_componentes=getComponents();
					for(int i=0; i<array_componentes.length; i++) {
						if(array_componentes[i] instanceof JPanel) {
							if(array_componentes[i].getName().equals(name)) {
								remove(array_componentes[i]);
								fila--;
								System.out.println("fila: "+fila);
								setLayout(new GridLayout(array_articulos.size(), 1, 0, 0));
								setPreferredSize(new Dimension(825, 496*fila));
								repaint();
								revalidate();
								setLayout(new GridLayout(array_articulos.size(), 1, 0, 0));
							}
						}
					}
				}
			});
		}
		setPreferredSize(new Dimension(825, 496*array_articulos.size()));
		

		this.gdb=gdb;
		this.conx=conx;
		this.array_articulos=array_articulos;
		this.array_paneles=array_paneles;
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
