package Graficos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Base_de_datos.conexion;

import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAccount;
	private JButton btnHome;
	
	private JPanel panelAdministrador = new panelAdministrador();
	private JPanel panelCuenta = new panelCuenta();
	private JPanel panelInicioSesion = new panelInicioSesion();
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String[7];
	private JButton btnSalir;
	private JButton btnOrders;

	
	private conexion cn = new conexion();
	private Connection con;
	private JTextField textField;
	private JButton btnSignOut;
	private JButton btnShop;
	private panel_articulos panel_articulos;
	private JScrollPane scrollPane;
	private JPanel panel_2 = new JPanel();
	
	public VentanaPrincipal() throws Exception{
		//creacion tipo de fuentee
	    File f = new File("src/font_family/Quicksand-Bold.ttf");
	    FileInputStream in = new FileInputStream(f);
	    Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, in);
	    Font dynamicFont32Pt = dynamicFont.deriveFont(20f);
	    
	    //colores
		Color color_menu=Color.decode("#643a7e");
		
		setResizable(false);
		setUndecorated(false);
		setSize(1095,640);
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(232, 11, 853, 544);
		

		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(232, 11, 853, 544);
		contentPane.add(panel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 853, 544);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(25);
		panel_2.setLayout(null);
		panel_2.add(scrollPane);
		
		panel_articulos = new panel_articulos();
		scrollPane.setViewportView(panel_articulos);
		panel_articulos.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(207, 11, 123, 26);
		panel_2.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(329, 11, 300, 26);
		panel_2.add(textField);
		textField.setColumns(10);
		
		panelInicioSesion.setBackground(Color.WHITE);		
		
		contentPane.add(panelInicioSesion);
		panelCuenta.setBackground(Color.WHITE);
		contentPane.add(panelCuenta);
		panelAdministrador.setBackground(Color.WHITE);
		contentPane.add(panelAdministrador);
		panelInicioSesion.setVisible(false);
		panelCuenta.setVisible(false);
		panelAdministrador.setVisible(false);
		
		panel = new JPanel();
		panel.setName("panelMenu");
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(36,41,46));
		panel.setBounds(0, 0, 222, 615);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(12, 149, 198, 2);
		panel.add(separator);
		

		btnHome = new JButton("HOME");
		btnHome.addActionListener(this);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(dynamicFont32Pt);
		btnHome.setBounds(12, 164, 198, 25);
		btnHome.setBorderPainted(false);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		panel.add(btnHome);
		
		btnAccount = new JButton("ACCOUNT");
		btnAccount.addActionListener(this);
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setFont(dynamicFont32Pt);
		btnAccount.setBounds(12, 278, 198, 25);
		btnAccount.setBorderPainted(false);
		btnAccount.setOpaque(false);
		btnAccount.setContentAreaFilled(false);
		btnAccount.setFocusPainted(false);
		panel.add(btnAccount);
		
		btnOrders = new JButton("ORDERS");
		btnOrders.addActionListener(this);
		btnOrders.setForeground(Color.WHITE);
		btnOrders.setFont(dynamicFont32Pt);
		btnOrders.setBounds(12, 240, 198, 25);
		btnOrders.setBorderPainted(false);
		btnOrders.setOpaque(false);
		btnOrders.setContentAreaFilled(false);
		btnOrders.setFocusPainted(false);
		panel.add(btnOrders);

		btnShop = new JButton("SHOPPING");
		btnShop.addActionListener(this);
		btnShop.setForeground(Color.WHITE);
		btnShop.setFont(dynamicFont32Pt);
		btnShop.setBounds(12, 202, 198, 25);
		btnShop.setBorderPainted(false);
		btnShop.setOpaque(false);
		btnShop.setContentAreaFilled(false);
		btnShop.setFocusPainted(false);
		panel.add(btnShop);
		
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setForeground(Color.WHITE);
		btnSetting.setFont(dynamicFont32Pt);
		btnSetting.setBounds(12, 316, 198, 25);
		btnSetting.setBorderPainted(false);
		btnSetting.setOpaque(false);
		btnSetting.setContentAreaFilled(false);
		btnSetting.setFocusPainted(false);
		btnSetting.setVisible(false);
		panel.add(btnSetting);
		
		btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(this);
		btnSignOut.setBackground(Color.RED);
		btnSignOut.setForeground(new Color(255, 255, 255));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignOut.setBounds(51, 566, 125, 25);
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setOpaque(true);
		btnSignOut.setFocusPainted(false);
		panel.add(btnSignOut);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setBounds(972, 554, 113, 50);
		btnSalir.setBorderPainted(false);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		contentPane.add(btnSalir);
		
		
		
		JButton btnNewButton = new JButton("Borrar");
	}
	protected JButton getBtnHome() {
		return btnHome;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 Object evento=e.getSource();
		
		if(evento.equals(btnSalir)) {
			 System.exit(WIDTH);
		}else if(evento.equals(btnHome)) {
			desactivarPaneles();
			panel_2.setVisible(true);
		}else if(evento.equals(btnAccount)) {
			desactivarPaneles();
			panelCuenta.setVisible(true);
		}else if(evento.equals(btnSignOut)) {
			desactivarPaneles();
			panelInicioSesion.setVisible(true);
		}else if(evento.equals(btnShop)) {
			desactivarPaneles();
			panelAdministrador.setVisible(true);
			contentPane.revalidate();
		}
	}
	
	protected JButton getBtnSalir() {
		return btnSalir;
	}
	
	public void desactivarPaneles() {
		Component[] components = contentPane.getComponents();
		for (int i = 0; i < components.length; i++) {
			if(components[i] instanceof JPanel && components[i].getName()==null) {
				components[i].setVisible(false);
			}else if(components[i] instanceof JScrollPane) {
				components[i].setVisible(false);
			}
		}
	}
	public JPanel getPanel() {
		return panel;
	}
	protected JButton getBtnProfits() {
		return btnAccount;
	}
	protected JButton getBtnOrders() {
		return btnOrders;
	}
	protected JButton getBtnSignOut() {
		return btnSignOut;
	}
	protected JButton getBtnShop() {
		return btnShop;
	}
	protected panel_articulos getPanel_articulos_() {
		return panel_articulos;
	}
	protected JScrollPane getScrollPane() {
		return scrollPane;
	}
}