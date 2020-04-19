package Graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;

public class panelCuenta extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JButton btnEditNombre;
	private JButton btnEditApellidos;
	private JButton btnEditFechaNacimiento;
	private JButton btnEditTelefono;
	private JButton btnEditCorreo;
	private JButton btnEditContraseña;

	public panelCuenta() {
		setBackground(new Color(211, 211, 211));
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(52, 45, 157, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(305, 46, 379, 34);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(52, 110, 157, 34);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_1);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 16));
		btnGuardar.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/save.png")));
		btnGuardar.setBounds(132, 446, 193, 45);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		add(btnGuardar);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(305, 111, 379, 34);
		add(textField_2);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(12, 175, 197, 34);
		add(lblFechaDeNacimiento);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(305, 176, 379, 34);
		add(textField_1);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(52, 239, 157, 34);
		add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(305, 240, 379, 34);
		add(textField_4);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setFont(new Font("Arial", Font.BOLD, 16));
		lblCorreoElectronico.setBounds(12, 302, 197, 34);
		add(lblCorreoElectronico);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(305, 303, 379, 34);
		add(textField_3);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 16));
		lblContrasea.setBounds(12, 368, 197, 34);
		add(lblContrasea);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/equis.png")));
		btnCancelar.setBounds(498, 446, 193, 45);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		add(btnCancelar);
		
		btnEditNombre = new JButton("");
		btnEditNombre.addActionListener(this);
		btnEditNombre.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditNombre.setBounds(714, 45, 43, 34);
		btnEditNombre.setBorderPainted(false);
		btnEditNombre.setOpaque(false);
		btnEditNombre.setContentAreaFilled(false);
		add(btnEditNombre);
		
		btnEditApellidos = new JButton("");
		btnEditApellidos.addActionListener(this);
		btnEditApellidos.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditApellidos.setBounds(714, 110, 43, 34);
		btnEditApellidos.setBorderPainted(false);
		btnEditApellidos.setOpaque(false);
		btnEditApellidos.setContentAreaFilled(false);
		add(btnEditApellidos);
		
		btnEditFechaNacimiento = new JButton("");
		btnEditFechaNacimiento.addActionListener(this);
		btnEditFechaNacimiento.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditFechaNacimiento.setBounds(714, 175, 43, 34);
		btnEditFechaNacimiento.setBorderPainted(false);
		btnEditFechaNacimiento.setOpaque(false);
		btnEditFechaNacimiento.setContentAreaFilled(false);
		add(btnEditFechaNacimiento);
		
		btnEditTelefono = new JButton("");
		btnEditTelefono.addActionListener(this);
		btnEditTelefono.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditTelefono.setBounds(714, 239, 43, 34);
		btnEditTelefono.setBorderPainted(false);
		btnEditTelefono.setOpaque(false);
		btnEditTelefono.setContentAreaFilled(false);
		add(btnEditTelefono);
		
		btnEditCorreo = new JButton("");
		btnEditCorreo.addActionListener(this);
		btnEditCorreo.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditCorreo.setBounds(714, 302, 43, 34);
		btnEditCorreo.setBorderPainted(false);
		btnEditCorreo.setOpaque(false);
		btnEditCorreo.setContentAreaFilled(false);
		add(btnEditCorreo);
		
		btnEditContraseña = new JButton("");
		btnEditContraseña.addActionListener(this);
		btnEditContraseña.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditContraseña.setBounds(714, 368, 43, 34);
		btnEditContraseña.setBorderPainted(false);
		btnEditContraseña.setOpaque(false);
		btnEditContraseña.setContentAreaFilled(false);
		add(btnEditContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 370, 379, 33);
		add(passwordField);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		
		if(boton.equals(btnEditNombre)) {
			JOptionPane.showInputDialog("Introduzca el nuevo nombre: ");
		}else if(boton.equals(btnEditApellidos)) {
			JOptionPane.showInputDialog("Introduzca los apellidos nuevos: ");
		}else if(boton.equals(btnEditFechaNacimiento)) {
			JOptionPane.showInputDialog("Introduzca la nueva fecha de nacimiento: ");
		}else if(boton.equals(btnEditTelefono)) {
			JOptionPane.showInputDialog("Introduzca el nuevo telefono: ");
		}else if(boton.equals(btnEditCorreo)) {
			JOptionPane.showInputDialog("Introduzca el nuevo correo: ");
		}else if(boton.equals(btnEditContraseña)) {
			JOptionPane.showInputDialog("Introduzca la nueva contraseña: ");
		}
	}
	protected JButton getBtnEditNombre() {
		return btnEditNombre;
	}
	protected JButton getBtnEditApellidos() {
		return btnEditApellidos;
	}
	protected JButton getBtnEditFechaNacimiento() {
		return btnEditFechaNacimiento;
	}
	protected JButton getBtnTelefono() {
		return btnEditTelefono;
	}
	protected JButton getBtnEditCorreo() {
		return btnEditCorreo;
	}
	protected JButton getBtnContraseña() {
		return btnEditContraseña;
	}
}
