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
import javax.swing.UIManager;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class panelAdministrador extends JPanel implements ActionListener{
	private JTextField tfPrecioFinal;
	private JTextField tfDinero;
	JComboBox comboBox_Nombres = new JComboBox();
	private conexion cx = new conexion();
	private Connection con;
	private ResultSet resultado;
	private Gestion gdb;
	private JComboBox comboBox_proveedor_1;
	JSpinner spinner = new JSpinner();
	JButton btnComprar = new JButton("COMPRAR");
	JComboBox comboBox_Tallas = new JComboBox();
	JLabel lblFalloCompra = new JLabel("");
	
	public panelAdministrador() throws SQLException {
				
		setBounds(232, 11, 853, 544);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Articulo:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(106, 57, 99, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Proveedor:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(665, 57, 88, 16);
		add(lblNewLabel_1);
		comboBox_Nombres.addActionListener(this);
		comboBox_Nombres.setBounds(32, 86, 211, 29);
		add(comboBox_Nombres);
		
		comboBox_proveedor_1 = new JComboBox();
		comboBox_proveedor_1.addActionListener(this);
		comboBox_proveedor_1.setBounds(593, 86, 211, 29);
		add(comboBox_proveedor_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(94, 217, 75, 16);
		add(lblNewLabel_2);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblFalloCompra.setText("");
			}
		});

		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		spinner.setEnabled(true);
		spinner.setBounds(32, 246, 220, 29);
		add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Precio final:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(654, 217, 99, 16);
		add(lblNewLabel_3);
		
		tfPrecioFinal = new JTextField();
		tfPrecioFinal.setEnabled(false);
		tfPrecioFinal.setEditable(false);
		tfPrecioFinal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tfPrecioFinal.setBounds(593, 246, 211, 47);
		add(tfPrecioFinal);
		tfPrecioFinal.setColumns(10);
		
		
		btnComprar.addActionListener(this);
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
		comboBox_Tallas.addActionListener(this);
		
		comboBox_Tallas.setModel(new DefaultComboBoxModel(new String[] {"", "S", "X", "L", "XL", "XXL", "XXXL"}));
		comboBox_Tallas.setBounds(330, 87, 178, 26);
		add(comboBox_Tallas);
		
		JLabel lblNewLabel_6 = new JLabel("Talla");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_6.setBounds(398, 57, 56, 16);
		add(lblNewLabel_6);
		
		
		lblFalloCompra.setForeground(Color.RED);
		lblFalloCompra.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblFalloCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblFalloCompra.setBounds(183, 388, 467, 14);
		add(lblFalloCompra);
		
		UIManager.put("TextField.disabledBackground",Color.WHITE);
		
		insertarArticulos();
		insertarProveedores();
	}
	public void insertarArticulos(){
		
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
	
	public void insertarProveedores() throws SQLException{
		ArrayList<String> nombres = new ArrayList<String>();
		gdb = new Gestion();
		nombres = gdb.recorrerProveedores();
		comboBox_proveedor_1.addItem("");
		
		for(String n : nombres) {
			comboBox_proveedor_1.addItem(n);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		if(evento.equals(btnComprar)) {
			//primero comprobamos que todos los campos tienen un valor seleccionado.
			//IMPORTANTE AHORA NO ESTA LA CONDICION DE COMPROBAR EL DINERO PERO SE DEBERA A�ADIR MAS ADELANTE
			if(comboBox_Nombres.getSelectedItem().equals("") ) {
				//System.out.println("rellene todos los campos");
				lblFalloCompra.setForeground(Color.RED);
				lblFalloCompra.setText("*Debe seleccionar un articulo");
			}else if(comboBox_Tallas.getSelectedItem().equals("")) {
				lblFalloCompra.setText("*Debe seleccionar una talla");
				lblFalloCompra.setForeground(Color.RED);
			}else if(comboBox_proveedor_1.getSelectedItem().equals("")) {
				lblFalloCompra.setText("*Debe seleccionar un proovedor");
				lblFalloCompra.setForeground(Color.RED);
			}else if(((Integer) spinner.getValue())<=0) {
				lblFalloCompra.setText("*La cantidad debe ser mayor que 0");
				lblFalloCompra.setForeground(Color.RED);
			}else {
				try {
					gdb.comprarSuministros(comboBox_Nombres.getSelectedItem().toString(), comboBox_Tallas.getSelectedItem().toString(), (Integer) spinner.getValue());
					lblFalloCompra.setText("*COMPRA REALIZADA");
					lblFalloCompra.setForeground(Color.GREEN);
					lblFalloCompra.setFont(new Font("Tahoma", Font.ITALIC, 14));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(evento.equals(comboBox_Nombres) || evento.equals(comboBox_Nombres) || evento.equals(comboBox_proveedor_1) ) {
			lblFalloCompra.setText("");
		}
	}
}
