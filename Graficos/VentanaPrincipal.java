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
	private JButton btnProfits;
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(232, 11, 853, 544);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 853, 544);
		panel_2.add(scrollPane);
		
		panel_articulos panel_articulos_ = new panel_articulos();
		scrollPane.setViewportView(panel_articulos_);
		panel_articulos_.setLayout(new GridLayout(1, 0, 0, 0));
		


		

		

		
		
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
		
		btnProfits = new JButton("PROFITS");
		btnProfits.addActionListener(this);
		btnProfits.setForeground(Color.WHITE);
		btnProfits.setFont(dynamicFont32Pt);
		btnProfits.setBounds(12, 202, 198, 25);
		btnProfits.setBorderPainted(false);
		btnProfits.setOpaque(false);
		btnProfits.setContentAreaFilled(false);
		btnProfits.setFocusPainted(false);
		panel.add(btnProfits);
		
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

		JButton btnCustomers = new JButton("CUSTOMERS");
		btnCustomers.setForeground(Color.WHITE);
		btnCustomers.setFont(dynamicFont32Pt);
		btnCustomers.setBounds(12, 278, 198, 25);
		btnCustomers.setBorderPainted(false);
		btnCustomers.setOpaque(false);
		btnCustomers.setContentAreaFilled(false);
		btnCustomers.setFocusPainted(false);
		panel.add(btnCustomers);
		
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setForeground(Color.WHITE);
		btnSetting.setFont(dynamicFont32Pt);
		btnSetting.setBounds(12, 316, 198, 25);
		btnSetting.setBorderPainted(false);
		btnSetting.setOpaque(false);
		btnSetting.setContentAreaFilled(false);
		btnSetting.setFocusPainted(false);
		panel.add(btnSetting);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.setBackground(Color.RED);
		btnSignOut.setForeground(new Color(255, 255, 255));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignOut.setBounds(51, 566, 125, 25);
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setOpaque(true);
		panel.add(btnSignOut);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setBounds(972, 568, 113, 36);
		btnSalir.setBorderPainted(false);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		contentPane.add(btnSalir);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(234, 568, 843, 12);
		contentPane.add(separator_1);
		
		
		
		JButton btnNewButton = new JButton("Borrar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });

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
			panelAdministrador.setVisible(true);
			contentPane.revalidate();
			
			 cn= new conexion();
             try {
                 con=cn.getConexion();
                 System.out.println("Conexion realizada");
             } catch (SQLException e1) {
                 e1.printStackTrace();
             }
             
		}else if(evento.equals(btnProfits)) {
			desactivarPaneles();
			panelCuenta.setVisible(true);
		}else if(evento.equals(btnOrders)) {
			desactivarPaneles();
			panelInicioSesion.setVisible(true);
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
		return btnProfits;
	}
	protected JButton getBtnOrders() {
		return btnOrders;
	}
}
