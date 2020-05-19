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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	JButton btnMenos = new JButton("");
	private JButton btnEliminar;
	
	public panelAsignarCategoria() throws SQLException {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		
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
		comboBox_Categoria.setBounds(515, 42, 147, 25);
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setEnabled(false);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminar.setBounds(628, 469, 97, 25);
		add(btnEliminar);
		
		table = new JTable(){//esto desactiva que podamos editar la tabla
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
			}
		});
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));

		modelo.addColumn("Categoria");
		setLayout(null);
		table.setModel(modelo);
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 136, 607, 320);
		add(scrollPane);
		scrollPane.setViewportView(table);
		
		btnMenos.setForeground(Color.RED);
		btnMenos.addActionListener(this);
		btnMenos.setIcon(new ImageIcon(panelAsignarCategoria.class.getResource("/Imagenes/eliminar.png")));
		btnMenos.setOpaque(false);
		btnMenos.setFocusPainted(false);
		btnMenos.setContentAreaFilled(false);
		btnMenos.setBorderPainted(false);
		btnMenos.setBounds(450, 37, 53, 33);
		add(btnMenos);
		
		introducirDatos();
		insertarArticulos();
		insertarCategoria();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnAñadir)) {
		}else if(evento.equals(btnAñadirCategoriaArticulo)) {
			//creamos el objeto de que el articulo pertenece una categoria.
			//seleccionamoss el articulo y la categoria elegidas se lo pasamos al objeto gestion y lo insertamos en la base de datos.
			try {
				if(comboBox_Categoria.getSelectedItem().toString().equals("") || comboBox_Nombres.getSelectedItem().toString().equals("") ) {
					
				}else {
					gdb.asignarCategoriaArticulo(comboBox_Nombres.getSelectedItem().toString(), comboBox_Categoria.getSelectedItem().toString());
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			comboBox_Pertenece.removeAllItems();
			updateComboBoxPertenece();			
		}else if(evento.equals(comboBox_Nombres)) {
			comboBox_Pertenece.removeAllItems();
			updateComboBoxPertenece();
		}else if(evento.equals(btnMenos)) {
			if(comboBox_Nombres.getSelectedItem().toString().equals("") ) {
				
			}else {
				if(comboBox_Pertenece.getSelectedItem()!=null) {
					try {
						gdb.eliminarArticuloCategoria(comboBox_Nombres.getSelectedItem().toString(), comboBox_Pertenece.getSelectedItem().toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			comboBox_Pertenece.removeAllItems();
			updateComboBoxPertenece();		
		}else if(evento.equals(btnEliminar)) {
		}
	}
	
	public void eliminarCategorias() {
		int row = table.getSelectedRow();
		String value = table.getModel().getValueAt(row, 0).toString();
		try {
			gdb.eliminarCategorias(value);
			btnEliminar.setEnabled(false);
			modelo.removeRow(row);
			comboBox_Categoria.removeAllItems();
			insertarCategoria();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void añadirCategoria() {
		if(!tfInsertar.getText().isEmpty() && !tfInsertar.getText().equals("")) {
			boolean existe=false;
			for(int i=0; i<modelo.getRowCount(); i++) {
				if(modelo.getValueAt(i, 0).toString().equals(tfInsertar.getText())) {
					existe=true;
					JOptionPane.showMessageDialog(null, "No puede insertar una categoria que ya existe");
				}
			}
			if(existe==false) {
				Datos [0] = tfInsertar.getText();
				modelo.addRow(Datos);
				
				gdb = new Gestion();
				if(gdb.insertarCategoria(tfInsertar.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Categoria insertada");
					comboBox_Categoria.addItem(tfInsertar.getText());
					tfInsertar.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Categoria no insertada");
				}
			}
		}
	}
	public void mostrarMensaje() {
		if(tfInsertar.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Inserte algun nombre");
		}else {
			//añadirCategoria();
		}
	}
	private void introducirDatos() throws SQLException {
		con = cx.getConexion();
		
		try {
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
	
	protected void insertarCategoria() {
		comboBox_Categoria.removeAllItems();
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
	protected JTable getTable() {
		return table;
	}
	protected JButton getBtnEliminar() {
		return btnEliminar;
	}
}
