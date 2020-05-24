package Graficos;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class panel_articulos_filtros extends JPanel implements MouseListener{
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	JPanel panel = new JPanel();
	ResultSet resultado;
	JPanel panel_Articulo;
	ArrayList<String> nombre_fotos = new ArrayList<String>();
	Gestion gdb;
	JPanel [] array_paneles = new JPanel[20];//el numero maximo de objetos que tenemso
	JLabel [] array_labels = new JLabel[80];//3 label por aticulo
	int posicion_label=0;
	String precio = null;
	float numero_filas=0;
	String filtro=null;
	String palabra_buscar=null;
	/**
	 ** Create the panel.
	 */
	public panel_articulos_filtros(Gestion gdb, conexion conx, String filtro, String palabra_buscar) {
		this.filtro=filtro;
		this.palabra_buscar=palabra_buscar;
		this.gdb=gdb;
		if(gdb.getArray_articuloGenerico().size()==0) {
			try {
				gdb.guardarImagenes();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<String> nombre_fotos_aux = new ArrayList<String>();
		try {
			if(!filtro.equals("")) {
				nombre_fotos=gdb.devolverArticulosDeCategoria(filtro);
			}else {
				nombre_fotos=gdb.recorrerArticuloGenericoString();
				// cuando pulsa enter hacemos una limpiza.
				if(!palabra_buscar.equals("")) {//si palabra buscar esta rellena es que busca por la palabra y no por la categoria
					for (String name : nombre_fotos) {
				        String patternString = ".*"+palabra_buscar+".*";
				        Pattern pattern = Pattern.compile(patternString);
				        Matcher matcher = pattern.matcher(name);
				        boolean matches = matcher.matches();
				        if(matches) {
				        	nombre_fotos_aux.add(name);
				        }
					}
					nombre_fotos.clear();
					nombre_fotos=nombre_fotos_aux;
				}
			}
			setNombre_fotos(nombre_fotos);
		} catch (SQLException e1) {
			System.out.println("Fallo con el nombre de los articulos");
			//e1.printStackTrace();
		}
		setLayout(null);
		

		panel.setBounds(0, 0, 839, 1421);
		//433 por filaa
		float real = 14.999f;
		int entero = (int)real;
		establecerTamaño(filtro,palabra_buscar);
		
		añadirPaneles();
}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object evento=e.getComponent().getName();
		for (int i=0; i<array_paneles.length; i++) {
			if(array_paneles[i]!=null) {
				if(evento.equals(array_paneles[i].getName())) {
					//si el panel tiene un nombre asignado entonces le establecemos el tamaño
					panel.removeAll();
					panel.setBounds(0, 48, 853, 496);
					panel.setPreferredSize(new Dimension(853, 496));
					panel.setLayout(new BorderLayout(0, 0));
					JPanel panel_Articulo=new panel_Articulo(nombre_fotos.get(i), gdb);
					
					panel_Articulo.addComponentListener(new ComponentAdapter() {
						@Override
						public void componentHidden(ComponentEvent arg0) {
							panel.removeAll();
							posicion_label=0;
							establecerTamaño(filtro,palabra_buscar);
							añadirPaneles();
							setVisible(true);
						}
					});
					panel.add(panel_Articulo, BorderLayout.CENTER);
					panel.repaint();
					panel.revalidate();
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Object evento=e.getComponent().getName();
		for (int i=0; i<array_paneles.length; i++) {
			if(array_paneles[i]!=null) {
				if(evento.equals(array_paneles[i].getName())) {
					array_paneles[i].setBorder(blackline);
				}
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object evento=e.getComponent().getName();
		for (int i=0; i<array_paneles.length; i++) {
			if(array_paneles[i]!=null) {
				if(evento.equals(array_paneles[i].getName())) {
					array_paneles[i].setBorder(null);
				}
			}
		}
	}

	public void añadirPaneles() {
		//insertamos los paneles de forma dinamica
		for(int i=0; i<nombre_fotos.size(); i++) {
			//recogemos el precio
			try {
				precio = gdb.devolverPrecioVentaDeCategoria(nombre_fotos.get(i));
			} catch (SQLException e) {
				System.out.println("Fallo al devolver precio");
				e.printStackTrace();
			}
			array_paneles[i] = new JPanel();
			array_paneles[i].addMouseListener(this);
			array_paneles[i].setName(""+i+"");
			array_paneles[i].setLayout(null);
			array_paneles[i].setBackground(Color.WHITE);
			array_paneles[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			array_paneles[i].addMouseListener(this);
		panel.add(array_paneles[i]);
		
		array_labels[posicion_label] = new JLabel("");
		System.out.println("hitler: "+nombre_fotos.get(i));
		array_labels[posicion_label].setIcon(new ImageIcon(gdb.insertarImagen(nombre_fotos.get(i))));
		array_labels[posicion_label].setBounds(35, 1, 175, 271);
		array_paneles[i].add(array_labels[posicion_label]);
		posicion_label++;
		
		array_labels[posicion_label] = new JLabel(nombre_fotos.get(i));
		array_labels[posicion_label].setHorizontalAlignment(SwingConstants.CENTER);
		array_labels[posicion_label].setFont(new Font("Tahoma", Font.PLAIN, 16));
		array_labels[posicion_label].setBounds(0, 283, 246, 20);
		array_paneles[i].add(array_labels[posicion_label]);
		posicion_label++;
		
		array_labels[posicion_label] = new JLabel("Precio: " + precio);
		array_labels[posicion_label].setHorizontalAlignment(SwingConstants.RIGHT);
		array_labels[posicion_label].setFont(new Font("Tahoma", Font.PLAIN, 14));
		array_labels[posicion_label].setBounds(/*128*/114, 314, /*86*/100, 17);
		array_paneles[i].add(array_labels[posicion_label]);
		posicion_label++;
		}
	//si tenemos 4 elementos el cardlayaout falla y hace solo dos columnas. Asi pues lo que haremos es añadir un panel vacio..
		if(nombre_fotos.size()==4 || nombre_fotos.size()==2) {
		JPanel panel_vacio=new JPanel();
		panel_vacio.setLayout(null);
		panel_vacio.setBackground(Color.WHITE);
		panel.add(panel_vacio);
		}else if(nombre_fotos.size()==0) {
			JPanel panel_resultado=new JPanel();
			panel_resultado.setLayout(null);
			panel_resultado.setBackground(Color.WHITE);
			panel.add(panel_resultado);
			
			JLabel mensaje = new JLabel("No se han encontrado resultados");
			mensaje.setHorizontalAlignment(SwingConstants.CENTER);
			mensaje.setForeground(Color.GRAY);
			mensaje.setFont(new Font("Arial", Font.BOLD, 20));
			mensaje.setBounds(0, 28, 853, 51);
			mensaje.setVisible(true);
			panel_resultado.add(mensaje);
		}else if(nombre_fotos.size()==1) {
			JPanel panel_vacio1=new JPanel();
			panel_vacio1.setLayout(null);
			panel_vacio1.setBackground(Color.WHITE);
			panel.add(panel_vacio1);
			
			JPanel panel_vacio2=new JPanel();
			panel_vacio2.setLayout(null);
			panel_vacio2.setBackground(Color.WHITE);
			panel.add(panel_vacio2);
			
		}
	}
	public void establecerTamaño(String filtro, String palabra_buscar) {
		if(!filtro.equals("")) {
			try {
				if(gdb.devolverArticulosDeCategoria(filtro).size()%3 == 0) {
					numero_filas=gdb.devolverArticulosDeCategoria(filtro).size()/3;
				}else {
					numero_filas=((int)gdb.devolverArticulosDeCategoria(filtro).size()/3)+1;
				}
			} catch (SQLException e) {
				System.out.println("Fallo al devolver articulo de categoria");
				e.printStackTrace();
			}
			panel.setPreferredSize(new Dimension(825, 433*(int)numero_filas));
		}else if(!palabra_buscar.equals("")) {
				if(nombre_fotos.size()%3 == 0) {
					numero_filas=nombre_fotos.size()/3;
				}else {
					numero_filas=((int)nombre_fotos.size()/3)+1;
				}
				panel.setPreferredSize(new Dimension(825, 433*(int)numero_filas));
		}else{
			panel.setPreferredSize(new Dimension(825, 3031));
		}
		panel.setBackground(Color.WHITE);
		add(panel);
		
		if(nombre_fotos.size()==0) {
			panel.setLayout(new GridLayout(1, 1, 50, 50));
		}else{
			panel.setLayout(new GridLayout((int)numero_filas, 3, 50, 50));
		}
	}
	protected JPanel getPanel_1() {
		return panel_1;
	}
	public JPanel getPanel_2() {
		return panel_2;
	}
	public JPanel getPanel_3() {
		return panel_3;
	}
	public JPanel getPanel_4() {
		return panel_4;
	}
	public JPanel getPanel_5() {
		return panel_5;
	}
	public JPanel getPanel_6() {
		return panel_6;
	}
	public JPanel getPanel_7() {
		return panel_7;
	}
	public JPanel getPanel_8() {
		return panel_8;
	}
	public JPanel getPanel_9() {
		return panel_9;
	}
	public ArrayList<String> getNombre_fotos() {
		return nombre_fotos;
	}

	public void setNombre_fotos(ArrayList<String> nombre_fotos) {
		this.nombre_fotos = nombre_fotos;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
