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
import java.awt.Cursor;
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
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	ComponentListener[] array_listeners = panelInicioSesion.getComponentListeners();
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String[7];
	private JButton btnSalir;
	private JButton btnPedidos;
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
	private panelCesta panelCesta_1;
	private JPanel panelOferta = new panelOferta();
	private JButton btnVaciar;
	private JLabel lblNewLabel_3 = new JLabel("");
	private JButton btnFinalizarComprar = new JButton("");
	private JPanel panel_Menu = new JPanel();
	private JPanel panelAdministrador = new panelAdministrador(gdb, cnx);
	JPanel panelMisPedidos = new panelMisPedidos(gdb);
	JPanel panelMisPedidos_Cliente = new panelMisPedidos(gdb);
	public VentanaPrincipal() throws Exception{
		gdb.devolverStock();
		//creacion tipo de fuentee
	    File f = new File("src/font_family/Quicksand-Bold.ttf");
	    FileInputStream in = new FileInputStream(f);
	    Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, in);
	    Font dynamicFont32Pt = dynamicFont.deriveFont(20f);
	    
	    //colores
		Color color_menu=Color.decode("#643a7e");
		Color color_sing=Color.decode("#cc0099");
		
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
		
		panelMisPedidos_Cliente.setBackground(Color.WHITE);
		panelMisPedidos_Cliente.setBounds(232, 11, 853, 544);
		panelMisPedidos_Cliente.setVisible(false);
		panelMisPedidos_Cliente.setLayout(null);
		contentPane.add(panelMisPedidos_Cliente);
				
				panel_Cesta.setBackground(Color.WHITE);
				panel_Cesta.setBounds(232, 11, 853, 544);
				contentPane.add(panel_Cesta);
				panel_Cesta.setVisible(false);
				panel_Cesta.setLayout(null);
				
				scrollPane_Cesta = new JScrollPane();
				scrollPane_Cesta.setBounds(0, 0, 853, 469);
				panel_Cesta.add(scrollPane_Cesta);
				scrollPane_Cesta.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane_Cesta.getVerticalScrollBar().setUnitIncrement(25);
				scrollPane_Cesta.setViewportView(panelCesta);
				
				btnFinalizarComprar.addActionListener(this);
				btnFinalizarComprar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/vaciar.png")));
				btnFinalizarComprar.setBounds(644, 491, 188, 53);
				btnFinalizarComprar.setBorderPainted(false);
				btnFinalizarComprar.setOpaque(false);
				btnFinalizarComprar.setContentAreaFilled(false);
				btnFinalizarComprar.setFocusPainted(false);
				btnFinalizarComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
				panel_Cesta.add(btnFinalizarComprar);
				
				btnVaciar = new JButton("");
				btnVaciar.addActionListener(this);
				btnVaciar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/finalizar_compra_2.png")));
				btnVaciar.setBounds(530, 491, 100, 53);
				btnVaciar.setBorderPainted(false);
				btnVaciar.setOpaque(false);
				btnVaciar.setContentAreaFilled(false);
				btnVaciar.setFocusPainted(false);
				btnVaciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
				panel_Cesta.add(btnVaciar);
				
				JLabel lblNewLabel_2 = new JLabel("Precio Total:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(544, 468, 86, 19);
				panel_Cesta.add(lblNewLabel_2);
				
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setBounds(634, 470, 94, 19);
				panel_Cesta.add(lblNewLabel_3);

				
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
		tabbedPane.setName("Tabbed");
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Component evento = (Component) e.getSource();
				if(tabbedPane.getSelectedIndex() == 2) {
					tabbedPane.repaint();
					tabbedPane.revalidate();
				}
			}
		});
		tabbedPane.setBackground(Color.WHITE);
		panel_3.add(tabbedPane);
		
		tabbedPane.addTab("Suministros", null, panelAdministrador, null);
		
		JPanel panelAsignarCategoria = new panelAsignarCategoria();
		tabbedPane.addTab("Categoria", null, panelAsignarCategoria, null);
		
		((Graficos.panelAsignarCategoria) panelAsignarCategoria).getBtnEliminar().addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				((Graficos.panelAsignarCategoria) panelAsignarCategoria).eliminarCategorias();
				((Graficos.panelAsignarCategoria) panelAsignarCategoria).insertarCategoria();				
				tabbedPane.remove(2);
				JPanel panelOferta = null;
				try {
					panelOferta = new panelOferta();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tabbedPane.addTab("Oferta", null, panelOferta, null);
				tabbedPane.repaint();
				tabbedPane.revalidate();
			}});
		
		((Graficos.panelAsignarCategoria) panelAsignarCategoria).getBtnAñadir().addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				((Graficos.panelAsignarCategoria) panelAsignarCategoria).añadirCategoria();			
				tabbedPane.remove(2);
				JPanel panelOferta = null;
				try {
					panelOferta = new panelOferta();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tabbedPane.addTab("Oferta", null, panelOferta, null);
				tabbedPane.repaint();
				tabbedPane.revalidate();
			}});
				
		panelOferta = new panelOferta();
		panelOferta.setName("panelOferta");
		tabbedPane.addTab("Oferta", null, panelOferta, null);
		
		resultado=gdb.recorrerCategorias();
		while(resultado.next()) {
			comboBox_Filtro.addItem(resultado.getString("nombre"));
		}
		panelInicioSesion.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				if(gdb.getSesionIniciada()) {
					if(gdb.getCliente()==true) {
						btnAccount.setVisible(true);
						btnPedidos.setVisible(true);
						panel_Menu.remove(btnShop);
						panel_Menu.add(btnAccount);
						panel_Menu.add(btnPedidos);
					}else {
						panel_Menu.remove(btnAccount);
						panel_Menu.remove(btnPedidos);
						panel_Menu.add(btnShop);
						btnShop.setText("");
						btnShop.setVisible(true);
						//Comprobar cuando no haya suministros de un articulo, si alguno tiene 0 insertamos el icono. Y si no borramos el icono y metemos setText("Suministros")
						if(gdb.devolverStock().contains("0")) {
							btnShop.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/avisobeta6.png")));
						}else {
							btnShop.setText("Suministros");
							btnShop.setIcon(null);
						}
						panelMisPedidos.setName("panelMisPedidos");
						((Graficos.panelMisPedidos) panelMisPedidos).insertarPedidos();
						tabbedPane.addTab("Pedidos", null, panelMisPedidos, null);
					}
					panel_2.setVisible(true);
					btnSignOut.setText("Cerrar Sesion");
					
					try {
						((Graficos.panelAdministrador) panelAdministrador).insertarDinero();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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

		btnHome = new JButton("Inicio");
		btnHome.addActionListener(this);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(dynamicFont32Pt);
		btnHome.setBounds(12, 164, 198, 25);
		btnHome.setBorderPainted(false);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		
		btnAccount = new JButton("Cuenta");
		btnAccount.setVisible(false);
		btnAccount.addActionListener(this);
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setFont(dynamicFont32Pt);
		btnAccount.setBounds(12, 278, 198, 25);
		btnAccount.setBorderPainted(false);
		btnAccount.setOpaque(false);
		btnAccount.setContentAreaFilled(false);
		btnAccount.setFocusPainted(false);

		btnShop = new JButton("Suministros");
		btnShop.addActionListener(this);
		btnShop.setForeground(Color.WHITE);
		btnShop.setFont(dynamicFont32Pt);
		btnShop.setBounds(12, 202, 198, 25);
		btnShop.setBorderPainted(false);
		btnShop.setOpaque(false);
		btnShop.setContentAreaFilled(false);
		btnShop.setFocusPainted(false);
		
		btnSignOut = new JButton("Iniciar Sesion");
		btnSignOut.addActionListener(this);
		btnSignOut.setBackground(color_sing);
		btnSignOut.setForeground(new Color(255, 255, 255));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignOut.setBounds(41, 566, 145, 25);
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
		
		btnCesta = new JButton("Cesta");
		btnCesta.addActionListener(this);
		btnCesta.setForeground(Color.WHITE);
		btnCesta.setFont(dynamicFont32Pt);
		btnCesta.setBounds(12, 240, 198, 25);
		btnCesta.setBorderPainted(false);
		btnCesta.setOpaque(false);
		btnCesta.setContentAreaFilled(false);
		btnCesta.setFocusPainted(false);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(this);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setFont(dynamicFont32Pt);
		btnPedidos.setBounds(12, 240, 198, 25);
		btnPedidos.setBorderPainted(false);
		btnPedidos.setOpaque(false);
		btnPedidos.setContentAreaFilled(false);
		btnPedidos.setFocusPainted(false);
		btnPedidos.setVisible(false);
		
		panel_Menu.setBackground(new Color(36,41,46));
		panel_Menu.setBounds(0, 149, 222, 146);
		panel.add(panel_Menu);
		panel_Menu.setLayout(new GridLayout(4, 0, 0, 0));
		panel_Menu.add(btnHome);
		panel_Menu.add(btnCesta);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/logolauraa.png")));
		lblNewLabel.setBounds(12, 13, 198, 123);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/decora.png")));
		lblNewLabel_1.setBounds(10, 297, 200, 245);
		panel.add(lblNewLabel_1);
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
			if(btnSignOut.getText()=="Iniciar Sesion") {
				desactivarPaneles();
				panelInicioSesion.setVisible(true);
			}else {
				btnAccount.setVisible(false);
				btnShop.setVisible(false);
				btnPedidos.setVisible(false);
				gdb.setSesionIniciada(false);
				panel_2.setVisible(true);
				btnSignOut.setText("Iniciar Sesion");
				panel_Menu.remove(btnAccount);
				panel_Menu.remove(btnShop);
				panel_Menu.remove(btnPedidos);
			}
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

		}else if(evento.equals(btnCesta)) {
			desactivarPaneles();
			crearPanelCesta();
		}else if(evento.equals(btnVaciar)) {
			gdb.vaciarArray_articulosCesta();
			desactivarPaneles();
			panelCesta=new panelCesta(gdb, cnx);
			scrollPane_Cesta.setViewportView(panelCesta);
			if(gdb.getArray_articulosCesta().size()==0) {
				scrollPane_Cesta.setBounds(0, 0, 853, 544);	
			}else {
				scrollPane_Cesta.setBounds(0, 0, 853, 469);
			}
			panel_Cesta.setVisible(true);
			panel_Cesta.revalidate();
			panel_Cesta.repaint();
		}else if(evento.equals(btnFinalizarComprar)) {
			//coger la cantigad el nombre y laa talla
			if( gdb.getCliente()==true) {
				if(gdb.finalizarCompra()) {
					JOptionPane.showMessageDialog(null, "COMPRA REALIZADA");
					gdb.vaciarArray_articulosCesta();
					crearPanelCesta();
				}
			}
		}else if(evento.equals(btnPedidos)){
			desactivarPaneles();
			panelMisPedidos_Cliente.setVisible(true);
			((Graficos.panelMisPedidos) panelMisPedidos_Cliente).insertarPedidos();
		}
	}
	
	protected JButton getBtnSalir() {
		return btnSalir;
	}
	public void crearPanelCesta() {
		panelCesta=new panelCesta(gdb, cnx);
		scrollPane_Cesta.setViewportView(panelCesta);
		if(gdb.getArray_articulosCesta().size()==0) {
			scrollPane_Cesta.setBounds(0, 0, 853, 544);	
		}else {
			scrollPane_Cesta.setBounds(0, 0, 853, 469);
		}
		lblNewLabel_3.setText(gdb.devolverPrecioCesta());
		panelCesta.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblNewLabel_3.setText(gdb.devolverPrecioCesta());
				if(gdb.getArray_articulosCesta().size()==0) {
					scrollPane_Cesta.setBounds(0, 0, 853, 544);
				}
			}
		});
		panel_Cesta.setVisible(true);
		panel_Cesta.revalidate();
		panel_Cesta.repaint();
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
	protected JPanel getPanelOferta() {
		return panelOferta;
	}
	public JButton getBtnVaciar() {
		return btnVaciar;
	}
}