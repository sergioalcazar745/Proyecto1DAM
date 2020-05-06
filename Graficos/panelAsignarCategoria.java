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
	
	public panelAsignarCategoria() throws SQLException {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		
		table = new JTable();
		modelo.addColumn("Categoria");
		setLayout(null);
		table.setModel(modelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 123, 607, 320);
		add(scrollPane);
		scrollPane.setViewportView(table);
		
		tfInsertar = new JTextField();
		tfInsertar.setBounds(118, 88, 498, 22);
		tfInsertar.setFont(new Font("Arial", Font.PLAIN, 16));
		add(tfInsertar);
		tfInsertar.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(628, 85, 97, 25);
		btnAñadir.addActionListener(this);
		btnAñadir.setFont(new Font("Arial", Font.BOLD, 16));
		add(btnAñadir);
		
		JLabel lblNewLabel = new JLabel("Articulo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(188, 13, 126, 16);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(185, 42, 129, 25);
		add(comboBox);
		
		JButton btnAñadirCategoriaArticulo = new JButton("");
		btnAñadirCategoriaArticulo.setIcon(new ImageIcon(panelAsignarCategoria.class.getResource("/Imagenes/plus.png")));
		btnAñadirCategoriaArticulo.setBounds(390, 36, 40, 39);
		btnAñadirCategoriaArticulo.setBorderPainted(false);
		btnAñadirCategoriaArticulo.setOpaque(false);
		btnAñadirCategoriaArticulo.setContentAreaFilled(false);
		btnAñadirCategoriaArticulo.setFocusPainted(false);
		add(btnAñadirCategoriaArticulo);
		
		introducirDatos();
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
		}
	}
	protected JButton getBtnAñadir() {
		return btnAñadir;
	}
}
