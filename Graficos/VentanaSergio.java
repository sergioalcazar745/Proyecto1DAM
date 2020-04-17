package Graficos;

import java.awt.BorderLayout;
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
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSergio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSergio frame = new VentanaSergio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String[7];
	private JButton btnHome;
	
	public VentanaSergio() {
		setResizable(false);
		setUndecorated(false);
		setSize(1095,640);
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 222, 626);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 149, 198, 2);
		panel.add(separator);
		
		btnHome = new JButton("HOME");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBounds(12, 164, 198, 25);
		btnHome.setBorderPainted(false);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		panel.add(btnHome);
		
		JButton btnProfits = new JButton("PROFITS");
		btnProfits.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProfits.setBounds(12, 202, 198, 25);
		btnProfits.setBorderPainted(false);
		btnProfits.setOpaque(false);
		btnProfits.setContentAreaFilled(false);
		panel.add(btnProfits);
		
		JButton btnOrders = new JButton("ORDERS");
		btnOrders.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOrders.setBounds(12, 240, 198, 25);
		btnOrders.setBorderPainted(false);
		btnOrders.setOpaque(false);
		btnOrders.setContentAreaFilled(false);
		panel.add(btnOrders);
		

		
		JButton btnCustomers = new JButton("CUSTOMERS");
		btnCustomers.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomers.setBounds(12, 278, 198, 25);
		btnCustomers.setBorderPainted(false);
		btnCustomers.setOpaque(false);
		btnCustomers.setContentAreaFilled(false);
		panel.add(btnCustomers);
		
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSetting.setBounds(12, 316, 198, 25);
		btnSetting.setBorderPainted(false);
		btnSetting.setOpaque(false);
		btnSetting.setContentAreaFilled(false);
		panel.add(btnSetting);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignOut.setBounds(57, 467, 125, 25);
		btnSignOut.setBorderPainted(false);
		btnSignOut.setOpaque(false);
		btnSignOut.setContentAreaFilled(false);
		panel.add(btnSignOut);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(VentanaSergio.class.getResource("/Imagenes/logo.PNG")));
		lblNewLabel.setBounds(24, 13, 198, 126);
		panel.add(lblNewLabel);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setBounds(972, 579, 113, 25);
		btnSalir.setBorderPainted(false);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		contentPane.add(btnSalir);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(232, 566, 625, 9);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane_ventanaPrincipal = new JScrollPane();
		scrollPane_ventanaPrincipal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_ventanaPrincipal.setBounds(232, 11, 853, 544);
		contentPane.add(scrollPane_ventanaPrincipal);
		scrollPane_ventanaPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		JPanel panel_Productos = new JPanel();
		scrollPane_ventanaPrincipal.setViewportView(panel_Productos);
		panel_Productos.setPreferredSize(new Dimension(400, 900));
		panel_Productos.setLayout(new GridLayout(3, 3, 50, 100));
		scrollPane_ventanaPrincipal.setBorder(BorderFactory.createEmptyBorder());
		JPanel panel_1 = new JPanel();
		panel_Productos.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaSergio.class.getResource("/imagenes/999738_big (1).jpg")));
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
		panel_Productos.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_Productos.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_3.add(btnNewButton_2);
		
		JPanel panel_4 = new JPanel();
		panel_Productos.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_4.add(btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_Productos.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_5.add(btnNewButton_4);
		
		JPanel panel_6 = new JPanel();
		panel_Productos.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_6.add(btnNewButton_5);
		
		JPanel panel_7 = new JPanel();
		panel_Productos.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_7.add(btnNewButton_6);
		
		JPanel panel_8 = new JPanel();
		panel_Productos.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_8.add(btnNewButton_7);
		
		JPanel panel_9 = new JPanel();
		panel_Productos.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_9.add(btnNewButton_8);
	}
	protected JButton getBtnHome() {
		return btnHome;
	}
}
