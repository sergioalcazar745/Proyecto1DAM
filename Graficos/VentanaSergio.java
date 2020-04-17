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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JScrollBar;

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
		setUndecorated(true);
		setSize(870,505);
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
		panel.setBounds(0, 0, 222, 505);
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
		lblNewLabel.setIcon(new ImageIcon(VentanaSergio.class.getResource("/Imagenes/logo.PNG")));
		lblNewLabel.setBounds(24, 13, 198, 126);
		panel.add(lblNewLabel);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSalir.setBounds(745, 467, 113, 25);
		btnSalir.setBorderPainted(false);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		contentPane.add(btnSalir);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(234, 455, 625, 9);
		contentPane.add(separator_1);
	}
	protected JButton getBtnHome() {
		return btnHome;
	}
}
