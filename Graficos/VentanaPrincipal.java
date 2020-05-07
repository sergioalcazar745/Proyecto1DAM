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

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
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
import java.awt.List;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAccount;
	private JButton btnHome;
	private JButton btnCesta;
	ResultSet resultado;
	conexion cnx=new conexion();
	Gestion gdb=new Gestion();
	String correo = "";
	private JPanel panelCuenta = new panelCuenta(gdb, cnx);
	private JPanel panelInicioSesion = new panelInicioSesion(gdb, cnx);
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String[7];
	private JButton btnSalir;
	private JButton btnOrders;
	String palabra="hola";
	
	private conexion cn = new conexion();
	private Connection con;
	private JTextField textField_filtro;
	private JButton btnSignOut;
	private JButton btnShop;
	private JPanel panel_articulos_filtros= new panel_articulos_filtros(gdb, cnx, "", "");
	private JScrollPane scrollPane;
	private JPanel panel_2 = new JPanel();
	private JPanel panel_Cesta = new JPanel();
	private JComboBox comboBox_Filtro = new JComboBox();
	private JPanel panel_3;
	private JPanel panelCesta= new panelCesta(gdb,cnx);
	private JScrollPane scrollPane_Cesta;
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
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setVisible(false);
				
				panel_Cesta.setBackground(Color.WHITE);
				panel_Cesta.setBounds(232, 11, 853, 544);
				contentPane.add(panel_Cesta);
				panel_Cesta.setLayout(new BorderLayout(0, 0));
				panel_Cesta.setVisible(false);
				
				scrollPane_Cesta = new JScrollPane();
				panel_Cesta.add(scrollPane_Cesta, BorderLayout.CENTER);
				scrollPane_Cesta.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane_Cesta.getVerticalScrollBar().setUnitIncrement(25);
				scrollPane_Cesta.setViewportView(panelCesta);

				
				panel_2.setBackground(Color.WHITE);
				panel_2.setBounds(232, 11, 853, 544);
				contentPane.add(panel_2);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 48, 853, 496);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBorder(BorderFactory.createEmptyBorder());
				scrollPane.getVerticalScrollBar().setUnitIncrement(25);
				panel_2.setLayout(null);
				panel_2.add(scrollPane);
				
				//panel_articulos_filtros = new panel_articulos_filtros();
				scrollPane.setViewportView(panel_articulos_filtros);
				panel_articulos_filtros.setLayout(new GridLayout(1, 0, 0, 0));
				comboBox_Filtro.addActionListener(this);
				

				comboBox_Filtro.setBounds(207, 11, 123, 26);
				comboBox_Filtro.addItem("");
				panel_2.add(comboBox_Filtro);
				
				textField_filtro = new JTextField();
						textField_filtro.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								if(e.getKeyCode()==KeyEvent.VK_ENTER) {
									panel_articulos_filtros=new panel_articulos_filtros(gdb, cnx, "", textField_filtro.getText());
									scrollPane.setViewportView(panel_articulos_filtros);
									panel_articulos_filtros.setLayout(new GridLayout(1, 0, 0, 0));
									panel_2.revalidate();
									panel_2.repaint();
								}
							}
						});
						textField_filtro.setBounds(329, 11, 300, 26);
						panel_2.add(textField_filtro);
						textField_filtro.setColumns(10);
		panel_3.setBounds(232, 11, 853, 544);
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		panel_3.add(tabbedPane);
		
		panelAdministrador panelAdministrador_ = new panelAdministrador();
		tabbedPane.addTab("Suministros", null, panelAdministrador_, null);
		
		panelAsignarCategoria panelAsignarCategoria_ = new panelAsignarCategoria();
		tabbedPane.addTab("Categoria", null, panelAsignarCategoria_, null);
		resultado=gdb.recorrerCategorias();
		while(resultado.next()) {
			comboBox_Filtro.addItem(resultado.getString("nombre"));
		}
		panelInicioSesion.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				if(gdb.getSesionIniciada()) {
					btnAccount.setVisible(true);
					panel_2.setVisible(true);
				}
			}
		});
		
		panelInicioSesion.setBackground(Color.WHITE);		
		panelInicioSesion.setVisible(false);
		contentPane.add(panelInicioSesion);
		panelCuenta.setBackground(Color.WHITE);
		contentPane.add(panelCuenta);
		panelCuenta.setVisible(false);
		
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
		btnAccount.setVisible(false);
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
		
		btnCesta = new JButton("CESTA");
		btnCesta.addActionListener(this);
		btnCesta.setForeground(Color.WHITE);
		btnCesta.setFont(dynamicFont32Pt);
		btnCesta.setBounds(51, 366, 125, 25);
		btnCesta.setBorderPainted(false);
		btnCesta.setOpaque(false);
		btnCesta.setContentAreaFilled(false);
		btnCesta.setFocusPainted(false);
		panel.add(btnCesta);
//		panel_articulos_filtros.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentHidden(ComponentEvent arg0) {
//				comboBox_Filtro.setVisible(false);
//				textField_filtro.setVisible(false);
//			}
//		});
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
			contentPane.revalidate();
		}else if(evento.equals(btnAccount)) {
			desactivarPaneles();
			//volvemos a crear el panel para que se cargue el codigo interno. con revalidate o repaint no funciona.
			try {
				gdb.guardarDatos(gdb.getDatos().get(0).toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			JPanel panelCuenta=new panelCuenta(gdb, cnx);
			contentPane.add(panelCuenta);
			panelCuenta.setVisible(true);
		}else if(evento.equals(btnSignOut)) {
			desactivarPaneles();
			panelInicioSesion.setVisible(true);
		}else if(evento.equals(btnShop)) {
			desactivarPaneles();
			panel_3.setVisible(true);
			contentPane.revalidate();
		}else if(evento.equals(comboBox_Filtro)) {
			//aqui determinaremos el numero de articulos que tenemos y se lo pasaremos al panel filtros para hacer las columnas y filas
//			try {
//				numero_articulos=gdb.devolverArticulosDeCategoria(comboBox_Filtro.getSelectedItem().toString());
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			//remove(panel_articulos_filtros);
			
			if(comboBox_Filtro.getSelectedItem()==null) {
				panel_articulos_filtros=new panel_articulos_filtros(gdb, cnx, "", "");
			}else{
				panel_articulos_filtros=new panel_articulos_filtros(gdb, cnx, comboBox_Filtro.getSelectedItem().toString(), "");
			}

			scrollPane.setViewportView(panel_articulos_filtros);
			panel_articulos_filtros.setLayout(new GridLayout(1, 0, 0, 0));
			panel_2.revalidate();
			panel_2.repaint();
			//System.out.println("panel: "+panel_articulos_filtros.getHeight());

		}else if(evento.equals(btnOrders)) {
			desactivarPaneles();
			//panelCesta.setVisible(true);
		}else if(evento.equals(btnCesta)) {
			desactivarPaneles();
			panelCesta=new panelCesta(gdb, cnx);
			scrollPane_Cesta.setViewportView(panelCesta);
			panel_Cesta.setVisible(true);
			panel_Cesta.revalidate();
			panel_Cesta.repaint();
			//System.out.println("hola");
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
	protected JScrollPane getScrollPane() {
		return scrollPane;
	}
	protected JPanel getPanel_3() {
		return panel_3;
	}	
}