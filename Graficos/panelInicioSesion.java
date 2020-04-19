package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class panelInicioSesion extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	public panelInicioSesion() {
		setBackground(new Color(211, 211, 211));
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 853, 86);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 119, 86);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("INICIO DE SESION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 84, 853, 77);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electronico:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(102, 191, 161, 28);
		add(lblNewLabel_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContrasea.setBounds(148, 292, 98, 28);
		add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(299, 194, 326, 28);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(299, 296, 326, 28);
		add(passwordField);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setBounds(211, 405, 151, 52);
		add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(493, 405, 151, 52);
		add(btnVolver);
		
	}
}
