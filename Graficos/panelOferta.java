package Graficos;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class panelOferta extends JPanel implements ActionListener{
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String [3];
	private JTextField tfPorcentaje;
	private ResultSet resultado;
	private Connection con;
	private conexion cx = new conexion();
	private Gestion gdb;
	private JComboBox comboBox_Nombres;
	private JComboBox comboBox_Categoria;
	private JButton btnAñadir;
	private ArrayList<String> oferta = new ArrayList<String>();

	public panelOferta() {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		table = new JTable();
		modelo.addColumn("Articulo");
		modelo.addColumn("Categoria");
		modelo.addColumn("Porcentaje");
		table.setModel(modelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 140, 666, 339);
		add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		comboBox_Nombres = new JComboBox();
		comboBox_Nombres.setBounds(230, 29, 146, 22);
		add(comboBox_Nombres);
		
		comboBox_Categoria = new JComboBox();
		comboBox_Categoria.setBounds(422, 29, 146, 22);
		add(comboBox_Categoria);
		
		tfPorcentaje = new JTextField();
		tfPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPorcentaje.setBounds(301, 105, 192, 22);
		add(tfPorcentaje);
		tfPorcentaje.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(496, 105, 12, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Porcentaje de descuento");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(301, 76, 192, 16);
		add(lblNewLabel_1);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblArticulo.setBounds(230, -4, 146, 38);
		add(lblArticulo);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategoria.setBounds(422, 2, 146, 27);
		add(lblCategoria);
		
		btnAñadir = new JButton("");
		btnAñadir.addActionListener(this);
		btnAñadir.setIcon(new ImageIcon(panelOferta.class.getResource("/Imagenes/plus.png")));
		btnAñadir.setBounds(604, 13, 62, 48);
		btnAñadir.setBorderPainted(false);
		btnAñadir.setOpaque(false);
		btnAñadir.setContentAreaFilled(false);
		btnAñadir.setFocusPainted(false);
		add(btnAñadir);
		
		JButton btnNewButton = new JButton("ExplicacionOfertas");
		btnNewButton.setBounds(96, 28, 85, 25);
		add(btnNewButton);
		
		comboBox_Nombres.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            	comboBox_Categoria.setSelectedIndex(0);
            }
        });
		comboBox_Categoria.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            	comboBox_Nombres.setSelectedIndex(0);
            }
        });;
        
        //Metodos
		
		insertarArticulos();
		insertarCategoria();
	}
	
	protected void insertarArticulos(){
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnAñadir)) {
			try {
				if((comboBox_Nombres.getSelectedItem().toString().equals("") && comboBox_Categoria.getSelectedItem().toString().equals("")) || tfPorcentaje.getText().equals("")){
					//Compruebo para que los valores que le pasamos sean los correctos
					JOptionPane.showMessageDialog(null, "Escribe algo");
				}else {					
					oferta = gdb.crearOfertas(comboBox_Nombres.getSelectedItem().toString(), comboBox_Categoria.getSelectedItem().toString(), tfPorcentaje.getText().toString());
					
					if(oferta.size() == 0) {
						Datos[0] = comboBox_Nombres.getSelectedItem().toString();
						Datos[1] = comboBox_Categoria.getSelectedItem().toString();
						Datos[2] = tfPorcentaje.getText();
						modelo.addRow(Datos);
					}else {
						int j = 0;
						for(int i = 0; i<oferta.size(); i++) {
							Datos[j] = oferta.get(j);
							modelo.addRow(Datos);
							j++;
							if(j==3) {
								j = 0;
							}
						}
					}
				}				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	protected JComboBox getComboBox_Nombres() {
		return comboBox_Nombres;
	}
	protected JComboBox getComboBox_Categoria() {
		return comboBox_Categoria;
	}
	protected JButton getBtnAñadir() {
		return btnAñadir;
	}
}
