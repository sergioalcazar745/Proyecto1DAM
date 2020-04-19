package Graficos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
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

public class ventanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel_Productos;
	private JPanel panel;
	private JButton btnProfits;
	private JButton btnHome;
	
	private JPanel panelAdministrador = new panelAdministrador();
	private JPanel panelCuenta = new panelCuenta();
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String[7];
	private JButton btnSalir;
	
	public ventanaPrincipal(){
		setResizable(false);
		setUndecorated(false);
		setSize(1095,640);
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setName("panelMenu");
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 222, 615);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(12, 149, 198, 2);
		panel.add(separator);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(this);
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBounds(12, 164, 198, 25);
		btnHome.setBorderPainted(false);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		panel.add(btnHome);
		
		btnProfits = new JButton("PROFITS");
		btnProfits.addActionListener(this);
		btnProfits.setForeground(new Color(255, 255, 255));
		btnProfits.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProfits.setBounds(12, 202, 198, 25);
		btnProfits.setBorderPainted(false);
		btnProfits.setOpaque(false);
		btnProfits.setContentAreaFilled(false);
		panel.add(btnProfits);
		
		JButton btnOrders = new JButton("ORDERS");
		btnOrders.setForeground(new Color(255, 255, 255));
		btnOrders.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOrders.setBounds(12, 240, 198, 25);
		btnOrders.setBorderPainted(false);
		btnOrders.setOpaque(false);
		btnOrders.setContentAreaFilled(false);
		panel.add(btnOrders);

		JButton btnCustomers = new JButton("CUSTOMERS");
		btnCustomers.setForeground(new Color(255, 255, 255));
		btnCustomers.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomers.setBounds(12, 278, 198, 25);
		btnCustomers.setBorderPainted(false);
		btnCustomers.setOpaque(false);
		btnCustomers.setContentAreaFilled(false);
		panel.add(btnCustomers);
		
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setForeground(new Color(255, 255, 255));
		btnSetting.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSetting.setBounds(12, 316, 198, 25);
		btnSetting.setBorderPainted(false);
		btnSetting.setOpaque(false);
		btnSetting.setContentAreaFilled(false);
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
		
		JScrollPane scrollPane_ventanaPrincipal = new JScrollPane();
		scrollPane_ventanaPrincipal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_ventanaPrincipal.setBounds(232, 11, 853, 544);
		contentPane.add(scrollPane_ventanaPrincipal);
		scrollPane_ventanaPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		panel_Productos = new JPanel();
		panel_Productos.setBackground(new Color(211, 211, 211));
		scrollPane_ventanaPrincipal.setViewportView(panel_Productos);
		panel_Productos.setPreferredSize(new Dimension(400, 900));
		panel_Productos.setLayout(new GridLayout(3, 3, 50, 100));
		scrollPane_ventanaPrincipal.setBorder(BorderFactory.createEmptyBorder());
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/imagenes/999738_big (1).jpg")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridheight = 5;
		gbc_lblNewLabel_1.gridwidth = 8;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PUTOS AMOS 2020");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridwidth = 8;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio: 30000");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 6;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel label = new JLabel("New label");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridheight = 5;
		gbc_label.gridwidth = 8;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("PUTOS AMOS 2020");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 8;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 5;
		panel_2.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("Precio: 30000");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridwidth = 3;
		gbc_label_2.gridx = 5;
		gbc_label_2.gridy = 6;
		panel_2.add(label_2, gbc_label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_3 = new JLabel("New label");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridheight = 5;
		gbc_label_3.gridwidth = 8;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		panel_3.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("PUTOS AMOS 2020");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridwidth = 8;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		panel_3.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("Precio: 30000");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridwidth = 3;
		gbc_label_5.gridx = 5;
		gbc_label_5.gridy = 6;
		panel_3.add(label_5, gbc_label_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel label_6 = new JLabel("New label");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.gridheight = 5;
		gbc_label_6.gridwidth = 8;
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 0;
		panel_4.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("PUTOS AMOS 2020");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.gridwidth = 8;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 5;
		panel_4.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("Precio: 30000");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridwidth = 3;
		gbc_label_8.gridx = 5;
		gbc_label_8.gridy = 6;
		panel_4.add(label_8, gbc_label_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel label_9 = new JLabel("New label");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.gridheight = 5;
		gbc_label_9.gridwidth = 8;
		gbc_label_9.insets = new Insets(0, 0, 5, 0);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 0;
		panel_5.add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("PUTOS AMOS 2020");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.gridwidth = 8;
		gbc_label_10.insets = new Insets(0, 0, 5, 0);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 5;
		panel_5.add(label_10, gbc_label_10);
		
		JLabel label_11 = new JLabel("Precio: 30000");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridwidth = 3;
		gbc_label_11.gridx = 5;
		gbc_label_11.gridy = 6;
		panel_5.add(label_11, gbc_label_11);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel label_12 = new JLabel("New label");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.gridheight = 5;
		gbc_label_12.gridwidth = 8;
		gbc_label_12.insets = new Insets(0, 0, 5, 0);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 0;
		panel_6.add(label_12, gbc_label_12);
		
		JLabel label_13 = new JLabel("PUTOS AMOS 2020");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.gridwidth = 8;
		gbc_label_13.insets = new Insets(0, 0, 5, 0);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 5;
		panel_6.add(label_13, gbc_label_13);
		
		JLabel label_14 = new JLabel("Precio: 30000");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 0, 5);
		gbc_label_14.gridwidth = 3;
		gbc_label_14.gridx = 5;
		gbc_label_14.gridy = 6;
		panel_6.add(label_14, gbc_label_14);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel label_15 = new JLabel("New label");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.gridheight = 5;
		gbc_label_15.gridwidth = 8;
		gbc_label_15.insets = new Insets(0, 0, 5, 0);
		gbc_label_15.gridx = 0;
		gbc_label_15.gridy = 0;
		panel_7.add(label_15, gbc_label_15);
		
		JLabel label_16 = new JLabel("PUTOS AMOS 2020");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.gridwidth = 8;
		gbc_label_16.insets = new Insets(0, 0, 5, 0);
		gbc_label_16.gridx = 0;
		gbc_label_16.gridy = 5;
		panel_7.add(label_16, gbc_label_16);
		
		JLabel label_17 = new JLabel("Precio: 30000");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 0, 5);
		gbc_label_17.gridwidth = 3;
		gbc_label_17.gridx = 5;
		gbc_label_17.gridy = 6;
		panel_7.add(label_17, gbc_label_17);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel label_18 = new JLabel("New label");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.gridheight = 5;
		gbc_label_18.gridwidth = 8;
		gbc_label_18.insets = new Insets(0, 0, 5, 0);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 0;
		panel_8.add(label_18, gbc_label_18);
		
		JLabel label_19 = new JLabel("PUTOS AMOS 2020");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.gridwidth = 8;
		gbc_label_19.insets = new Insets(0, 0, 5, 0);
		gbc_label_19.gridx = 0;
		gbc_label_19.gridy = 5;
		panel_8.add(label_19, gbc_label_19);
		
		JLabel label_20 = new JLabel("Precio: 30000");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.insets = new Insets(0, 0, 0, 5);
		gbc_label_20.gridwidth = 3;
		gbc_label_20.gridx = 5;
		gbc_label_20.gridy = 6;
		panel_8.add(label_20, gbc_label_20);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(211, 211, 211));
		panel_Productos.add(panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel label_21 = new JLabel("New label");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.gridheight = 5;
		gbc_label_21.gridwidth = 8;
		gbc_label_21.insets = new Insets(0, 0, 5, 0);
		gbc_label_21.gridx = 0;
		gbc_label_21.gridy = 0;
		panel_9.add(label_21, gbc_label_21);
		
		JLabel label_22 = new JLabel("PUTOS AMOS 2020");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.gridwidth = 8;
		gbc_label_22.insets = new Insets(0, 0, 5, 0);
		gbc_label_22.gridx = 0;
		gbc_label_22.gridy = 5;
		panel_9.add(label_22, gbc_label_22);
		
		JLabel label_23 = new JLabel("Precio: 30000");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.insets = new Insets(0, 0, 0, 5);
		gbc_label_23.gridwidth = 3;
		gbc_label_23.gridx = 5;
		gbc_label_23.gridy = 6;
		panel_9.add(label_23, gbc_label_23);
		

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
			contentPane.add(panelAdministrador);
			contentPane.revalidate();
		}else if(evento.equals(btnProfits)) {
			desactivarPaneles();
			contentPane.add(panelCuenta);
		}
	}
	
	protected JButton getBtnSalir() {
		return btnSalir;
	}
	protected JPanel getPanel_Productos() {
		return panel_Productos;
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
}
