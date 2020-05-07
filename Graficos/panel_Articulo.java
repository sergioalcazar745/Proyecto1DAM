package Graficos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import Base_de_datos.Gestion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panel_Articulo extends JPanel  implements ActionListener{

	/**
	 * Create the panel.
	 */
	Gestion gdb;
	JButton btnCesta = new JButton("");
	JLabel lblNewLabel_1 = new JLabel();
	private JButton btnVolver;
	public panel_Articulo(String nombre_articulo, Gestion gdb){
		this.gdb=gdb;
		setName("laura callate");
		setBackground(Color.WHITE);
		String descripcion="";
		System.out.println("nombre: "+nombre_articulo);
		setBounds(0, 48, 853, 496);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");//imagen
		lblNewLabel.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/"+nombre_articulo+".jpg")));
		lblNewLabel.setBounds(185, 111, 175, 271);
		add(lblNewLabel);
		
		lblNewLabel_1.setText(nombre_articulo);
		lblNewLabel_1.setBounds(397, 161, 250, 23);
		add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		try {
			descripcion=gdb.devolverDescripcion(nombre_articulo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.setText(descripcion);
		textArea.setBounds(397, 228, 259, 99);
		add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(397, 194, 141, 23);
		add(lblNewLabel_2);
		
		JButton btnComprar = new JButton("");
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setIcon(new ImageIcon(panel_Articulo.class.getResource("/fotos_botones/comprar_boton.png")));
		btnComprar.setBounds(455, 423, 168, 49);
		btnComprar.setBorderPainted(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setFocusPainted(false);
		add(btnComprar);
		btnComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		

		btnCesta.setBackground(Color.WHITE);
		btnCesta.setIcon(new ImageIcon(panel_Articulo.class.getResource("/fotos_botones/boton_cesta.png")));
		btnCesta.setBounds(633, 423, 189, 49);
		btnCesta.setBorderPainted(false);
		btnCesta.setOpaque(false);
		btnCesta.setContentAreaFilled(false);
		btnCesta.setFocusPainted(false);
		btnCesta.addActionListener(this);
		add(btnCesta);
		btnCesta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnVolver = new JButton("");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setIcon(new ImageIcon(panel_Articulo.class.getResource("/Imagenes/Go-back_36760.png")));
		btnVolver.setBounds(72, 431, 44, 41);
		btnVolver.setBorderPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.addActionListener(this);
		add(btnVolver);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object evento=e.getSource();
		if(evento.equals(btnCesta)) {
			gdb.añadirCesta(lblNewLabel_1.getText());
		}else if(evento.equals(btnVolver)) {
			setVisible(false);
		}
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
}
