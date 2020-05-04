package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	ResultSet resultado;
	
	
	
	JPanel [] array_paneles = new JPanel[20];//el numero maximo de objetos que tenemso
	JLabel [] array_labels = new JLabel[80];//2 label por aticulo
	/**
	 ** Create the panel.
	 */
	public panel_articulos_filtros(Gestion gdb, conexion conx, String filtro) {
		float numero_filas=0;
		int posicion_label=0;
		ArrayList<String> nombre_fotos=new ArrayList<String>();
		try {
			if(!filtro.equals("")) {
				nombre_fotos=gdb.devolverArticulosDeCategoria(filtro);
			}else {
				nombre_fotos=gdb.recorrerArticuloGenericoString();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 839, 1421);
		//433 por fila
		System.out.println("numeroooo");
		float real = 14.999f;
		int entero = (int)real;
		System.out.println("entero: "+entero);
		if(!filtro.equals("")) {
			try {
				if(gdb.devolverArticulosDeCategoria(filtro).size()%3 == 0) {
					numero_filas=gdb.devolverArticulosDeCategoria(filtro).size()%3;
				}else {
					numero_filas=((int)gdb.devolverArticulosDeCategoria(filtro).size()/3)+1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.setPreferredSize(new Dimension(825, 433*(int)numero_filas));
			System.out.println("jesus: "+433*(int)numero_filas);
		}else {
			panel.setPreferredSize(new Dimension(825, 3031));
			System.out.println("hola: dimensiones");
		}
		panel.setBackground(Color.WHITE);
		add(panel);
		System.out.println("filas: "+(int)numero_filas);
		panel.setLayout(new GridLayout((int)numero_filas, 3, 50, 50));
		
		System.out.println(nombre_fotos.size()+"hitler");
			for(int i=0; i<nombre_fotos.size(); i++) {
				System.out.println("añadido: "+i);
				array_paneles[i] = new JPanel();
				array_paneles[i].addMouseListener(this);
				array_paneles[i].setLayout(null);
				array_paneles[i].setBackground(Color.WHITE);
			panel.add(array_paneles[i]);
			
			array_labels[posicion_label] = new JLabel("");
			array_labels[posicion_label].setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/"+nombre_fotos.get(i)+".jpg")));
			array_labels[posicion_label].setBounds(35, 1, 175, 271);
			array_paneles[i].add(array_labels[posicion_label]);
			posicion_label++;
			
			array_labels[posicion_label] = new JLabel(nombre_fotos.get(i));
			array_labels[posicion_label].setHorizontalAlignment(SwingConstants.CENTER);
			array_labels[posicion_label].setFont(new Font("Tahoma", Font.PLAIN, 16));
			array_labels[posicion_label].setBounds(0, 283, 246, 20);
			array_paneles[i].add(array_labels[posicion_label]);
			posicion_label++;
			
			array_labels[posicion_label] = new JLabel("Precio: 30000");
			array_labels[posicion_label].setHorizontalAlignment(SwingConstants.RIGHT);
			array_labels[posicion_label].setFont(new Font("Tahoma", Font.PLAIN, 14));
			array_labels[posicion_label].setBounds(128, 314, 86, 17);
			array_paneles[i].add(array_labels[posicion_label]);
			posicion_label++;
			}
		//si tenemos 4 elementos el cardlayaout falla y hace solo dos columnas. Asi pues lo que haremos es añadir un panel vacio..
			if(nombre_fotos.size()==4) {
			JPanel panel_vacio=new JPanel();
			panel_vacio.setLayout(null);
			panel_vacio.setBackground(Color.WHITE);
			panel.add(panel_vacio);
			}
			
			
			
//		if(filtro.equals("")) {
//			array_paneles[1] = new JPanel();
//			array_paneles[1].addMouseListener(this);
//			array_paneles[1].setLayout(null);
//			array_paneles[1].setBackground(Color.WHITE);
//		panel.add(array_paneles[1]);
//		
//		array_labels[10] = new JLabel("");
//		array_labels[10].setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/Bermuda Denim Mom Fit.jpg")));
//		array_labels[10].setBounds(35, 1, 175, 271);
//		array_paneles[1].add(array_labels[10]);
//		
//		array_labels[11] = new JLabel("Bermuda denim mom fit");
//		array_labels[11].setHorizontalAlignment(SwingConstants.CENTER);
//		array_labels[11].setFont(new Font("Tahoma", Font.PLAIN, 16));
//		array_labels[11].setBounds(0, 283, 246, 20);
//		array_paneles[1].add(array_labels[11]);
//		
//		array_labels[12] = new JLabel("Precio: 30000");
//		array_labels[12].setHorizontalAlignment(SwingConstants.RIGHT);
//		array_labels[12].setFont(new Font("Tahoma", Font.PLAIN, 14));
//		array_labels[12].setBounds(128, 314, 86, 17);
//		array_paneles[1].add(array_labels[12]);
		
//		
//		panel_2 = new JPanel();
//		panel_2.addMouseListener(this);
//		panel_2.setLayout(null);
//		panel_2.setBackground(Color.WHITE);
//		panel.add(panel_2);
//		
//		JLabel label_3 = new JLabel("");
//		label_3.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/BERMUDA EFECTO BRILLO.jpg")));
//		label_3.setBounds(35, 1, 175, 271);
//		panel_2.add(label_3);
//		
//		JLabel label_4 = new JLabel("Bermuda efecto brillo");
//		label_4.setHorizontalAlignment(SwingConstants.CENTER);
//		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_4.setBounds(0, 283, 246, 20);
//		panel_2.add(label_4);
//		
//		JLabel label_5 = new JLabel("Precio: 30000");
//		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_5.setBounds(128, 314, 86, 17);
//		panel_2.add(label_5);
//		System.out.println("todos");
//		}	
//		panel_3 = new JPanel();
//		panel_3.addMouseListener(this);
//		panel_3.setLayout(null);
//		panel_3.setBackground(Color.WHITE);
//		panel.add(panel_3);
//		
//		JLabel label_6 = new JLabel("");
//		label_6.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/BODY ENCAJE.jpg")));
//		label_6.setBounds(35, 1, 175, 271);
//		panel_3.add(label_6);
//		
//		JLabel label_7 = new JLabel("Body encaje");
//		label_7.setHorizontalAlignment(SwingConstants.CENTER);
//		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_7.setBounds(0, 283, 246, 20);
//		panel_3.add(label_7);
//		
//		JLabel label_8 = new JLabel("Precio: 30000");
//		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_8.setBounds(128, 314, 86, 17);
//		panel_3.add(label_8);
//		
//		panel_4 = new JPanel();
//		panel_4.addMouseListener(this);
//		panel_4.setLayout(null);
//		panel_4.setBackground(Color.WHITE);
//		panel.add(panel_4);
//		
//		JLabel label_9 = new JLabel("");
//		label_9.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/CAMISETA ESTAMPADA SMILEY.jpg")));
//		label_9.setBounds(35, 1, 175, 271);
//		panel_4.add(label_9);
//		
//		JLabel label_10 = new JLabel("Camiseta estampada smiley");
//		label_10.setHorizontalAlignment(SwingConstants.CENTER);
//		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_10.setBounds(0, 283, 241, 20);
//		panel_4.add(label_10);
//		
//		JLabel label_11 = new JLabel("Precio: 30000");
//		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_11.setBounds(128, 314, 86, 17);
//		panel_4.add(label_11);
//		
//		panel_5 = new JPanel();
//		panel_5.addMouseListener(this);
//		panel_5.setLayout(null);
//		panel_5.setBackground(Color.WHITE);
//		panel.add(panel_5);
//		
//		JLabel label_12 = new JLabel("");
//		label_12.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/CAMISETA MARILYN MONROE TM.jpg")));
//		label_12.setBounds(35, 1, 175, 271);
//		panel_5.add(label_12);
//		
//		JLabel label_13 = new JLabel("Camiseta marilyn");
//		label_13.setHorizontalAlignment(SwingConstants.CENTER);
//		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_13.setBounds(0, 283, 241, 20);
//		panel_5.add(label_13);
//		
//		JLabel label_14 = new JLabel("Precio: 30000");
//		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_14.setBounds(128, 314, 86, 17);
//		panel_5.add(label_14);
//		
//		panel_6 = new JPanel();
//		panel_6.addMouseListener(this);
//		panel_6.setLayout(null);
//		panel_6.setBackground(Color.WHITE);
//		panel.add(panel_6);
//		
//		JLabel label_15 = new JLabel("");
//		label_15.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/CAMISETA VOLANTES.jpg")));
//		label_15.setBounds(35, 1, 175, 271);
//		panel_6.add(label_15);
//		
//		JLabel label_16 = new JLabel("Camiseta Volantes");
//		label_16.setHorizontalAlignment(SwingConstants.CENTER);
//		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_16.setBounds(0, 283, 241, 20);
//		panel_6.add(label_16);
//		
//		JLabel label_17 = new JLabel("Precio: 30000");
//		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_17.setBounds(128, 314, 86, 17);
//		panel_6.add(label_17);
//		
//		panel_7 = new JPanel();
//		panel_7.addMouseListener(this);
//		panel_7.setLayout(null);
//		panel_7.setBackground(Color.WHITE);
//		panel.add(panel_7);
//		
//		JLabel label_18 = new JLabel("");
//		label_18.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/CAZADORA DENIM CROPPED.jpg")));
//		label_18.setBounds(35, 1, 175, 271);
//		panel_7.add(label_18);
//		
//		JLabel label_19 = new JLabel("Cazadora denim cropped");
//		label_19.setHorizontalAlignment(SwingConstants.CENTER);
//		label_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_19.setBounds(0, 283, 246, 20);
//		panel_7.add(label_19);
//		
//		JLabel label_20 = new JLabel("Precio: 30000");
//		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_20.setBounds(128, 314, 86, 17);
//		panel_7.add(label_20);
//		
//		panel_8 = new JPanel();
//		panel_8.addMouseListener(this);
//		panel_8.setLayout(null);
//		panel_8.setBackground(Color.WHITE);
//		panel.add(panel_8);
//		
//		JLabel label_21 = new JLabel("");
//		label_21.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/DEPORTIVO RETRO SUELA VOLUMEN.jpg")));
//		label_21.setBounds(35, 1, 175, 271);
//		panel_8.add(label_21);
//		
//		JLabel label_22 = new JLabel("Deportivo retro");
//		label_22.setHorizontalAlignment(SwingConstants.CENTER);
//		label_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_22.setBounds(0, 283, 247, 20);
//		panel_8.add(label_22);
//		
//		JLabel label_23 = new JLabel("Precio: 30000");
//		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_23.setBounds(128, 314, 86, 17);
//		panel_8.add(label_23);
//		
//		panel_9 = new JPanel();
//		panel_9.addMouseListener(this);
//		panel_9.setLayout(null);
//		panel_9.setBackground(Color.WHITE);
//		panel.add(panel_9);
//		
//		JLabel label_24 = new JLabel("");
//		label_24.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/DEPORTIVO VOLUMEN MULTIPIEZAS.jpg")));
//		label_24.setBounds(35, 1, 175, 271);
//		panel_9.add(label_24);
//		
//		JLabel label_25 = new JLabel("Deportivo volumen multipiezas");
//		label_25.setHorizontalAlignment(SwingConstants.CENTER);
//		label_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		label_25.setBounds(0, 283, 247, 20);
//		panel_9.add(label_25);
//		
//		JLabel label_26 = new JLabel("Precio: 30000");
//		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
//		label_26.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		label_26.setBounds(128, 314, 86, 17);
//		panel_9.add(label_26);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object evento=e.getSource();
		if(e.getComponent() instanceof JPanel) {
			System.out.println("hola"+e.getComponent());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}