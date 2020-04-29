package Graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class panelAdministrador extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField tfDinero;
	JComboBox comboBox_Nombres = new JComboBox();
	JComboBox comboBox_Pertenece = new JComboBox();
	JComboBox comboBox_Categorias = new JComboBox();
	JButton btnAñadirCategoriaArticulo = new JButton("");
	private JButton btnCrearCategoria;
	private conexion cx = new conexion();
	private Connection con;
	private ResultSet resultado;
	private Gestion gdb;
	public panelAdministrador() {
		setBorder(new TitledBorder(null, "COMPRAR SUMINISTROS", TitledBorder.LEFT, TitledBorder.TOP, null, null));
				
		setBounds(232, 11, 853, 544);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Articulo:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(94, 57, 71, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Proveedor:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(665, 57, 88, 16);
		add(lblNewLabel_1);
		comboBox_Nombres.addActionListener(this);
		comboBox_Nombres.setBounds(32, 86, 211, 29);
		add(comboBox_Nombres);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(593, 86, 211, 29);
		add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(94, 217, 75, 16);
		add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(true);
		spinner.setBounds(32, 246, 220, 29);
		add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Precio final:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(654, 217, 99, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(593, 246, 211, 47);
		add(textField);
		textField.setColumns(10);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setIcon(new ImageIcon(panelAdministrador.class.getResource("/Imagenes/shopping_bag.png")));
		btnComprar.setFont(new Font("Arial", Font.BOLD, 16));
		btnComprar.setBounds(183, 322, 154, 40);
		btnComprar.setBorderPainted(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		add(btnComprar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 413, 778, 2);
		add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("Dinero disponible:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(51, 460, 142, 16);
		add(lblNewLabel_4);
		
		tfDinero = new JTextField();
		tfDinero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfDinero.setEnabled(false);
		tfDinero.setBounds(222, 455, 567, 29);
		add(tfDinero);
		tfDinero.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setIcon(new ImageIcon(panelAdministrador.class.getResource("/Imagenes/equis.png")));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setBounds(449, 322, 170, 40);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		add(btnCancelar);
		
		btnComprar.setBorderPainted(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setFocusPainted(false);
		
		comboBox_Categorias.setBounds(32, 167, 211, 29);
		add(comboBox_Categorias);
		
		JLabel lblCategoria = new JLabel("Pertenece a:");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategoria.setBounds(375, 56, 105, 19);
		add(lblCategoria);
		
		JLabel lblNewLabel_5 = new JLabel("A\u00F1adir categoria");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setBounds(44, 138, 188, 16);
		add(lblNewLabel_5);
		
		comboBox_Pertenece.setBounds(315, 86, 211, 29);
		add(comboBox_Pertenece);
		
		btnAñadirCategoriaArticulo.addActionListener(this);
		btnAñadirCategoriaArticulo.setIcon(new ImageIcon(panelAdministrador.class.getResource("/Imagenes/plus.png")));
		btnAñadirCategoriaArticulo.setBounds(254, 167, 43, 29);
		btnAñadirCategoriaArticulo.setBorderPainted(false);
		btnAñadirCategoriaArticulo.setOpaque(false);
		btnAñadirCategoriaArticulo.setContentAreaFilled(false);
		btnAñadirCategoriaArticulo.setFocusPainted(false);
		add(btnAñadirCategoriaArticulo);
		
		btnCrearCategoria = new JButton("Crear categoria");
		btnCrearCategoria.addActionListener(this);
		btnCrearCategoria.setBackground(new Color(192, 192, 192));
		btnCrearCategoria.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnCrearCategoria.setOpaque(false);
		btnCrearCategoria.setFocusPainted(false);
		btnCrearCategoria.setContentAreaFilled(false);
		btnCrearCategoria.setBorderPainted(false);
		btnCrearCategoria.setBounds(315, 167, 228, 29);
		add(btnCrearCategoria);
		
		introducirDatos();
		insertarNombres();
	}
	public void insertarNombres(){
		
		try {
			con = (Connection) cx.getConexion();
			System.out.println("Conexion realizada");
			gdb = new Gestion();
			resultado = gdb.recorrerArticuloGenerico();
			comboBox_Nombres.addItem("");
			
			while(resultado.next()) {
				comboBox_Nombres.addItem(resultado.getString("nombre"));
			}
			
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Fallo al conectar");
			e1.printStackTrace();
		}
			
		
	}
	public JButton getBtnCrearCategoria() {
		return btnCrearCategoria;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnCrearCategoria)) {
			try {
				panelCategoria pc = new panelCategoria();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(evento.equals(btnAñadirCategoriaArticulo)) {
			//creamos el objeto de que el articulo pertenece una categoria.
			//seleccionamos el articulo y la categoria elegidas se lo pasamos al objeto gestion y lo insertamos en la base de datos.
			try {
				gdb.asignarCategoriaArticulo(comboBox_Nombres.getSelectedItem().toString(), comboBox_Categorias.getSelectedItem().toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			comboBox_Pertenece.removeAllItems();
			updateComboBoxPertenece();			
		}else if(evento.equals(comboBox_Nombres)) {
			comboBox_Pertenece.removeAllItems();
			updateComboBoxPertenece();
		}
	}
	
	public void updateComboBoxPertenece() {
		if(comboBox_Nombres.getSelectedItem() != null) {
			for(String n : gdb.asociacionCategoria(comboBox_Nombres.getSelectedItem().toString())) {
				comboBox_Pertenece.addItem(n);
			}
		}
	}
	
	private void introducirDatos() {
		
		try {
			con = (Connection) cx.getConexion();
			System.out.println("Conexion realizada");
			gdb = new Gestion();
			resultado = gdb.recorrerCategorias();
			
			while(resultado.next()) {
				comboBox_Categorias.addItem(resultado.getString("nombre"));
			}
			
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Fallo al conectar");
			e1.printStackTrace();
		}
	}
	protected JComboBox getComboBox_Pertenece() {
		return comboBox_Pertenece;
	}
}
