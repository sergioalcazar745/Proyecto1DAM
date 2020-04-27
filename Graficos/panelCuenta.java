package Graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import Base_de_datos.Gestion;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;

public class panelCuenta extends JPanel implements ActionListener{
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfFecha_Nacimiento;
	private JTextField tfTelefono;
	private JTextField tfCorreo;
	private JPasswordField tfContraseña;
	private JButton btnEditNombre;
	private JButton btnEditApellidos;
	private JButton btnEditFechaNacimiento;
	private JButton btnEditTelefono;
	private JButton btnEditCorreo;
	private JButton btnEditContraseña;
	private ResultSet resultado2;
	private Gestion gdb;

	public panelCuenta() {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(52, 45, 157, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfNombre.setBounds(305, 46, 379, 34);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(52, 110, 157, 34);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_1);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/save.png")));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 16));
		btnGuardar.setBounds(132, 446, 193, 45);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setFocusPainted(false);
		add(btnGuardar);
		
		tfApellidos = new JTextField();
		tfApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(305, 111, 379, 34);
		add(tfApellidos);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(12, 175, 197, 34);
		add(lblFechaDeNacimiento);
		
		tfFecha_Nacimiento = new JTextField();
		tfFecha_Nacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfFecha_Nacimiento.setColumns(10);
		tfFecha_Nacimiento.setBounds(305, 176, 379, 34);
		add(tfFecha_Nacimiento);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(52, 239, 157, 34);
		add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(305, 240, 379, 34);
		add(tfTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setFont(new Font("Arial", Font.BOLD, 16));
		lblCorreoElectronico.setBounds(12, 302, 197, 34);
		add(lblCorreoElectronico);
		
		tfCorreo = new JTextField();
		tfCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfCorreo.setColumns(10);
		tfCorreo.setBounds(305, 303, 379, 34);
		add(tfCorreo);
		
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
		btnCancelar.setFocusPainted(false);
		add(btnCancelar);
		
		btnEditNombre = new JButton("");
		btnEditNombre.addActionListener(this);
		btnEditNombre.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditNombre.setBounds(714, 45, 43, 34);
		btnEditNombre.setBorderPainted(false);
		btnEditNombre.setOpaque(false);
		btnEditNombre.setContentAreaFilled(false);
		btnEditNombre.setFocusPainted(false);
		add(btnEditNombre);
		
		btnEditApellidos = new JButton("");
		btnEditApellidos.addActionListener(this);
		btnEditApellidos.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditApellidos.setBounds(714, 110, 43, 34);
		btnEditApellidos.setBorderPainted(false);
		btnEditApellidos.setOpaque(false);
		btnEditApellidos.setContentAreaFilled(false);
		btnEditApellidos.setFocusPainted(false);
		add(btnEditApellidos);
		
		btnEditFechaNacimiento = new JButton("");
		btnEditFechaNacimiento.addActionListener(this);
		btnEditFechaNacimiento.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditFechaNacimiento.setBounds(714, 175, 43, 34);
		btnEditFechaNacimiento.setBorderPainted(false);
		btnEditFechaNacimiento.setOpaque(false);
		btnEditFechaNacimiento.setContentAreaFilled(false);
		btnEditFechaNacimiento.setFocusPainted(false);
		add(btnEditFechaNacimiento);
		
		btnEditTelefono = new JButton("");
		btnEditTelefono.addActionListener(this);
		btnEditTelefono.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditTelefono.setBounds(714, 239, 43, 34);
		btnEditTelefono.setBorderPainted(false);
		btnEditTelefono.setOpaque(false);
		btnEditTelefono.setContentAreaFilled(false);
		btnEditTelefono.setFocusPainted(false);
		add(btnEditTelefono);
		
		btnEditCorreo = new JButton("");
		btnEditCorreo.addActionListener(this);
		btnEditCorreo.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditCorreo.setBounds(714, 302, 43, 34);
		btnEditCorreo.setBorderPainted(false);
		btnEditCorreo.setOpaque(false);
		btnEditCorreo.setContentAreaFilled(false);
		btnEditCorreo.setFocusPainted(false);
		add(btnEditCorreo);
		
		btnEditContraseña = new JButton("");
		btnEditContraseña.addActionListener(this);
		btnEditContraseña.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/edit.png")));
		btnEditContraseña.setBounds(714, 368, 43, 34);
		btnEditContraseña.setBorderPainted(false);
		btnEditContraseña.setOpaque(false);
		btnEditContraseña.setContentAreaFilled(false);
		btnEditContraseña.setFocusPainted(false);
		add(btnEditContraseña);
		
		tfContraseña = new JPasswordField();
		tfContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfContraseña.setBounds(305, 370, 379, 33);
		add(tfContraseña);
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
			JPasswordField pf = new JPasswordField();
			
			int uno = JOptionPane.showConfirmDialog(null, pf, "Introduce la contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			String contraseña1 = new String (pf.getText());
			
			pf.setText("");
			
			int dos = JOptionPane.showConfirmDialog(null, pf, "Introduce la contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			String contraseña2 = new String (pf.getText());
			
			if(contraseña1.equals(contraseña2)) {
				tfContraseña.setText(contraseña2);
			}else {
				JOptionPane.showMessageDialog(null, "No coinciden las contraseñas. Vuelva a intentarlo");
			}			
		}
	}
	
	public void introducirDatos(ResultSet resultado) {
		gdb = new Gestion();
		try {
			resultado2 = gdb.comprobarCliente(resultado.getString("id_persona"));
			while(resultado2.next()) {
				tfNombre.setText(resultado2.getString("nombre"));
				tfApellidos.setText(resultado2.getString("apellidos"));
				tfFecha_Nacimiento.setText(resultado2.getString("fecha_nacimiento"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			tfCorreo.setText(resultado.getString("correo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			tfContraseña.setText(resultado.getString("contraseña"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			tfTelefono.setText(resultado.getString("telefono"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	protected JTextField getTfNombre() {
		return tfNombre;
	}
	protected JTextField getTfApellidos() {
		return tfApellidos;
	}
	protected JTextField getTfFecha_Nacimiento() {
		return tfFecha_Nacimiento;
	}
	protected JTextField getTfTelefono() {
		return tfTelefono;
	}
	protected JTextField getTfCorreo() {
		return tfCorreo;
	}
	protected JPasswordField getTfContraseña() {
		return tfContraseña;
	}
}
