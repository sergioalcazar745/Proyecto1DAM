package Graficos;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class panelAsignarCategoria extends JPanel implements ActionListener{
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String [1];
	private JTable table;
	private JTextField tfInsertar;
	private ResultSet resultado;
	private Connection con;
	private conexion cx = new conexion();
	private Gestion gdb;
	private JButton btnAñadir;
	private JButton btnAñadirCategoriaArticulo;
	private JComboBox comboBox_Nombres;
	private JComboBox comboBox_Categoria;
	private JComboBox comboBox_Pertenece;
	
	public panelAsignarCategoria() throws SQLException {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		
		table = new JTable();
		modelo.addColumn("Categoria");
		setLayout(null);
		table.setModel(modelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 136, 607, 320);
		add(scrollPane);
		scrollPane.setViewportView(table);
		
		tfInsertar = new JTextField();
		tfInsertar.setBounds(118, 101, 498, 22);
		tfInsertar.setFont(new Font("Arial", Font.PLAIN, 16));
		add(tfInsertar);
		tfInsertar.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(628, 100, 97, 25);
		btnAñadir.addActionListener(this);
		btnAñadir.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnAñadir);
		
		JLabel lblNewLabel = new JLabel("Articulo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(118, 13, 126, 16);
		add(lblNewLabel);
		
		comboBox_Nombres = new JComboBox();
		comboBox_Nombres.addActionListener(this);
		comboBox_Nombres.setBounds(118, 42, 147, 25);
		add(comboBox_Nombres);
		
		btnAñadirCategoriaArticulo = new JButton("");
		btnAñadirCategoriaArticulo.addActionListener(this);
		btnAñadirCategoriaArticulo.setIcon(new ImageIcon(panelAsignarCategoria.class.getResource("/Imagenes/plus.png")));
		btnAñadirCategoriaArticulo.setBounds(674, 28, 51, 50);
		btnAñadirCategoriaArticulo.setBorderPainted(false);
		btnAñadirCategoriaArticulo.setOpaque(false);
		btnAñadirCategoriaArticulo.setContentAreaFilled(false);
		btnAñadirCategoriaArticulo.setFocusPainted(false);
		add(btnAñadirCategoriaArticulo);
		
		comboBox_Categoria = new JComboBox();
		comboBox_Categoria.setBounds(512, 42, 147, 25);
		add(comboBox_Categoria);
		
		JLabel lblAadirCategoria = new JLabel("Categoria");
		lblAadirCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirCategoria.setFont(new Font("Arial", Font.BOLD, 16));
		lblAadirCategoria.setBounds(515, 13, 147, 16);
		add(lblAadirCategoria);
		
		JLabel lblPertenece = new JLabel("Pertenece a:");
		lblPertenece.setHorizontalAlignment(SwingConstants.CENTER);
		lblPertenece.setFont(new Font("Arial", Font.BOLD, 16));
		lblPertenece.setBounds(309, 13, 126, 16);
		add(lblPertenece);
		
		comboBox_Pertenece = new JComboBox();
		comboBox_Pertenece.setBounds(297, 42, 141, 25);
		add(comboBox_Pertenece);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(628, 469, 97, 25);
		add(btnEliminar);
		
		introducirDatos();
		insertarArticulos();
		insertarCatergoria();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnAñadir)) {
			if(tfInsertar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Si escribes algo mejor bro.");
			}else {
				Datos [0] = tfInsertar.getText();
				modelo.addRow(Datos);
				
				gdb = new Gestion();
				if(gdb.insertarCategoria(tfInsertar.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Categoria insertada");
					tfInsertar.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Categoria no insertada");
				}
			}
		}else if(evento.equals(btnAñadirCategoriaArticulo)) {
			//creamos el objeto de que el articulo pertenece una categoria.
			//seleccionamos el articulo y la categoria elegidas se lo pasamos al objeto gestion y lo insertamos en la base de datos.
			try {
				gdb.asignarCategoriaArticulo(comboBox_Nombres.getSelectedItem().toString(), comboBox_Categoria.getSelectedItem().toString());
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
	
	private void introducirDatos() throws SQLException {
		con = cx.getConexion();
		
		try {
			System.out.println("Conexion realizada");
			gdb = new Gestion();
			resultado = gdb.recorrerCategorias();
			
			while(resultado.next()) {
				Datos [0] = resultado.getString("nombre");
				modelo.addRow(Datos);
			}
			
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Fallo al conectar");
			e1.printStackTrace();
		}
	}
	
	private void updateComboBoxPertenece() {
		if(comboBox_Nombres.getSelectedItem() != null) {
			for(String n : gdb.asociacionCategoria(comboBox_Nombres.getSelectedItem().toString())) {
				comboBox_Pertenece.addItem(n);
			}
		}
	}
	
	private void insertarArticulos(){
		
		try {
			con = (Connection) cx.getConexion();
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
	
	private void insertarCatergoria() {
		try {
			con = (Connection) cx.getConexion();
			gdb = new Gestion();
			resultado = gdb.recorrerCategorias();
			comboBox_Categoria.addItem("");
			
			while(resultado.next()) {
				comboBox_Categoria.addItem(resultado.getString("nombre"));
			}
			
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Fallo al conectar");
			e1.printStackTrace();
		}
	}
	
	protected JButton getBtnAñadir() {
		return btnAñadir;
	}
	protected JButton getBtnAñadirCategoriaArticulo() {
		return btnAñadirCategoriaArticulo;
	}
	protected JComboBox getComboBox_Nombres() {
		return comboBox_Nombres;
	}
	protected JComboBox getComboBox_Categoria() {
		return comboBox_Categoria;
	}
	protected JComboBox getComboBox__Pertenece() {
		return comboBox_Pertenece;
	}
}
