package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class panelInicioSesion extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	private JButton btnVolver;

	public panelInicioSesion() {
		setBackground(new Color(211, 211, 211));
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 853, 115);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblImagenError = new JLabel("New label");
		lblImagenError.setVisible(false);
		lblImagenError.setBounds(0, 0, 131, 122);
		panel.add(lblImagenError);
		lblImagenError.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/dialog_warning.png")));
		
		JLabel lblError = new JLabel("ERROR");
		lblError.setVisible(false);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Arial", Font.BOLD, 16));
		lblError.setBounds(101, 0, 90, 29);
		panel.add(lblError);
		
		JLabel lblNewLabel_3 = new JLabel("Si todav\u00EDa no te has registrado pulsa");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 28, 853, 51);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("aqu\u00ED.");
		lblNewLabel_4.setForeground(new Color(0, 191, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(608, 28, 65, 51);
		panel.add(lblNewLabel_4);
		
		JLabel lblElCorreoO = new JLabel("El correo o la contrase\u00F1a son incorrectos. Vuelva a intentarlo.");
		lblElCorreoO.setVisible(false);
		lblElCorreoO.setBounds(0, 28, 853, 51);
		panel.add(lblElCorreoO);
		lblElCorreoO.setHorizontalAlignment(SwingConstants.CENTER);
		lblElCorreoO.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("INICIO DE SESI\u00D3N");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 126, 853, 64);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electronico:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(109, 217, 161, 28);
		add(lblNewLabel_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContrasea.setBounds(148, 317, 98, 28);
		add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(299, 218, 326, 28);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(299, 318, 326, 28);
		add(passwordField);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/door.png")));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEntrar.setBounds(211, 405, 151, 52);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setOpaque(false);
		btnEntrar.setContentAreaFilled(false);
		add(btnEntrar);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/return.png")));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
		btnVolver.setBounds(493, 405, 151, 52);
		btnVolver.setBorderPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		add(btnVolver);
		
	}
	protected JButton getBtnEntrar() {
		return btnEntrar;
	}
	protected JButton getBtnVolver() {
		return btnVolver;
	}
}
