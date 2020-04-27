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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class panelInicioSesion extends JPanel implements ActionListener{
	private JTextField tfCorreo;
	private JPasswordField tfContrase�a;
	private JButton btnEntrar;
	private JButton btnRegistrarse;
	private Gestion gt;
	private ResultSet resultado;
	private JTable table;
	private JLabel lblImagenError;
	private JLabel lblError;
	private JLabel lblInicio;
	private JLabel lblIncorrecto;
	conexion conx=new conexion();
	Gestion gdb=new Gestion();
	ArrayList<String> datos=new ArrayList<String>();
	String sesionIniciada = "";
	
	public String getSesionIniciada() {
		return sesionIniciada;
	}

	public panelInicioSesion(Gestion gdb_aux, conexion conx_aux) {
		this.gdb=gdb_aux;
		this.conx=conx_aux;
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 853, 115);
		add(panel);
		panel.setLayout(null);
		
		lblImagenError = new JLabel("");
		lblImagenError.setVisible(false);
		lblImagenError.setBounds(0, 0, 131, 115);
		panel.add(lblImagenError);
		lblImagenError.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/dialog_warning.png")));
		
		lblError = new JLabel("ERROR");
		lblError.setVisible(false);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Arial", Font.BOLD, 16));
		lblError.setBounds(101, 0, 90, 29);
		panel.add(lblError);
		
		lblInicio = new JLabel("Si todav\u00EDa no te has registrado pulsa en el boton de registrarse.");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Arial", Font.BOLD, 20));
		lblInicio.setBounds(0, 28, 853, 51);
		panel.add(lblInicio);
		
		lblIncorrecto = new JLabel("El correo o la contrase\u00F1a son incorrectos. Vuelva a intentarlo.");
		lblIncorrecto.setVisible(false);
		lblIncorrecto.setBounds(0, 28, 853, 51);
		panel.add(lblIncorrecto);
		lblIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrecto.setFont(new Font("Arial", Font.BOLD, 20));
		
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
		
		tfContrase�a = new JPasswordField();
		tfContrase�a.setBounds(299, 318, 326, 28);
		add(tfContrase�a);
		
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
		btnRegistrarse.setIcon(new ImageIcon(panelInicioSesion.class.getResource("/Imagenes/sign_up.png")));
		btnRegistrarse.addActionListener(this);
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
			
			try {				
				resultado = gt.comprobarSesion(tfCorreo.getText());
				while(resultado.next()) {
					
					if(resultado == null) {
						lblInicio.setVisible(false);
						lblImagenError.setVisible(true);
						lblError.setVisible(true);
						lblIncorrecto.setVisible(true);
						
						tfCorreo.setText("");
						tfContrase�a.setText("");
						System.out.println("Hola");
					}else if(tfCorreo.getText().equals(resultado.getString("correo")) && tfContrase�a.getText().equals(resultado.getString("contrase�a"))) {
						JOptionPane.showMessageDialog(null, "Correcto");
						sesionIniciada = tfCorreo.getText();
					}else {
						lblInicio.setVisible(false);
						lblImagenError.setVisible(true);
						lblError.setVisible(true);
						lblIncorrecto.setVisible(true);
						
						tfCorreo.setText("");
						tfContrase�a.setText("");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	protected JLabel getLblImagenError() {
		return lblImagenError;
	}
	public JLabel getLblError() {
		return lblError;
	}
	protected JLabel getLblInicio() {
		return lblInicio;
	}
	protected JLabel getLblIncorrecto() {
		return lblIncorrecto;
	}
	public void hola() {
		
	}
}
