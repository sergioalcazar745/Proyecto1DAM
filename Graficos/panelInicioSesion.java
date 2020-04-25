package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class panelInicioSesion extends JPanel implements ActionListener{
	private JTextField tfCorreo;
	private JPasswordField tfContraseña;
	private JButton btnEntrar;
	private JButton btnRegistrarse;
	private Gestion gt;
	private ResultSet resultado;

	public panelInicioSesion() {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 853, 115);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblImagenError = new JLabel("");
		lblImagenError.setVisible(false);
		lblImagenError.setBounds(0, 0, 131, 115);
		panel.add(lblImagenError);
		lblImagenError.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/dialog_warning.png")));
		
		JLabel lblError = new JLabel("ERROR");
		lblError.setVisible(false);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Arial", Font.BOLD, 16));
		lblError.setBounds(101, 0, 90, 29);
		panel.add(lblError);
		
		JLabel lblNewLabel_3 = new JLabel("Si todav\u00EDa no te has registrado pulsa en el boton de registrarse.");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 28, 853, 51);
		panel.add(lblNewLabel_3);
		
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
		
		tfCorreo = new JTextField();
		tfCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfCorreo.setBounds(299, 218, 326, 28);
		add(tfCorreo);
		tfCorreo.setColumns(10);
		
		tfContraseña = new JPasswordField();
		tfContraseña.setBounds(299, 318, 326, 28);
		add(tfContraseña);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/door.png")));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnEntrar.setBounds(211, 405, 151, 52);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setOpaque(false);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setFocusPainted(false);
		add(btnEntrar);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/sign_up.png")));
		btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrarse.setBounds(493, 405, 183, 52);
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setFocusPainted(false);
		add(btnRegistrarse);
		
	}
	protected JButton getBtnEntrar() {
		return btnEntrar;
	}
	protected JButton getBtnVolver() {
		return btnRegistrarse;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		
		if(boton.equals(btnRegistrarse)) {
			URL url=null;
			try {
			    url = new URL("http://www.google.es/");
			    try {
			        Desktop.getDesktop().browse(url.toURI());
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    } catch (URISyntaxException e1) {
			        e1.printStackTrace();
			    }
			} catch (MalformedURLException e1) {
			    e1.printStackTrace();
			}
			
		}else if (boton.equals(btnEntrar)) {
			gt = new Gestion();
			String pass = new String(tfContraseña.getPassword());
			
			try {				
				resultado = gt.comprobarCliente(tfCorreo.getText(), pass);
				while(resultado.next()) {
					System.out.println(resultado.getString("correo"));
					System.out.println(resultado.getString("contraseña"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
