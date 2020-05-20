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
import Base_de_datos.conexion;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelCuenta extends JPanel implements ActionListener{
	
	JTextField tfCorreo = new JTextField();
	JTextField tfNombre = new JTextField();
	JTextField tfFecha_Nacimiento = new JTextField();
	JTextField tfTelefono = new JTextField();
	JTextField tfApellidos = new JTextField();
	JPasswordField tfContraseña = new JPasswordField();
	private JButton btnEditNombre;
	private JButton btnEditApellidos;
	private JButton btnEditFechaNacimiento;
	private JButton btnEditTelefono;
	private JButton btnEditCorreo;
	private JButton btnEditContraseña;
	private ResultSet resultado2;
	Gestion gdb=new Gestion();
	conexion conx=new conexion();
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public panelCuenta(Gestion gdb_aux, conexion conx_aux) {
		this.gdb=gdb_aux;
		this.conx=conx_aux;
		if(gdb.getSesionIniciada()==true) {
			actualizarTextFields();
		}

		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(52, 45, 157, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel);
		tfNombre.setEditable(false);
		
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfNombre.setBounds(305, 46, 379, 34);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(52, 110, 157, 34);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblNewLabel_1);
		
		btnGuardar = new JButton("  GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/nube.png")));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 14));
		btnGuardar.setBounds(160, 446, 193, 45);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setFocusPainted(false);
		add(btnGuardar);
		tfApellidos.setEditable(false);
		
		
		tfApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(305, 111, 379, 34);
		add(tfApellidos);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(12, 175, 197, 34);
		add(lblFechaDeNacimiento);
		tfFecha_Nacimiento.setEditable(false);
		
		
		tfFecha_Nacimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfFecha_Nacimiento.setColumns(10);
		tfFecha_Nacimiento.setBounds(305, 176, 379, 34);
		add(tfFecha_Nacimiento);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(52, 239, 157, 34);
		add(lblTelefono);
		tfTelefono.setEditable(false);
		
		
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(305, 240, 379, 34);
		add(tfTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setFont(new Font("Arial", Font.BOLD, 16));
		lblCorreoElectronico.setBounds(12, 302, 197, 34);
		add(lblCorreoElectronico);
		tfCorreo.setEditable(false);
		
		
		tfCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfCorreo.setColumns(10);
		tfCorreo.setBounds(305, 303, 379, 34);
		add(tfCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 16));
		lblContrasea.setBounds(12, 368, 197, 34);
		add(lblContrasea);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/CANCELAR.PNG")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(506, 446, 193, 45);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		add(btnCancelar);
		
		btnEditNombre = new JButton("");
		btnEditNombre.addActionListener(this);
		btnEditNombre.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/editar.PNG")));
		btnEditNombre.setBounds(714, 45, 43, 34);
		btnEditNombre.setBorderPainted(false);
		btnEditNombre.setOpaque(false);
		btnEditNombre.setContentAreaFilled(false);
		btnEditNombre.setFocusPainted(false);
		add(btnEditNombre);
		
		btnEditApellidos = new JButton("");
		btnEditApellidos.addActionListener(this);
		btnEditApellidos.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/editar.PNG")));
		btnEditApellidos.setBounds(714, 110, 43, 34);
		btnEditApellidos.setBorderPainted(false);
		btnEditApellidos.setOpaque(false);
		btnEditApellidos.setContentAreaFilled(false);
		btnEditApellidos.setFocusPainted(false);
		add(btnEditApellidos);
		
		btnEditFechaNacimiento = new JButton("");
		btnEditFechaNacimiento.addActionListener(this);
		btnEditFechaNacimiento.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/editar.PNG")));
		btnEditFechaNacimiento.setBounds(714, 175, 43, 34);
		btnEditFechaNacimiento.setBorderPainted(false);
		btnEditFechaNacimiento.setOpaque(false);
		btnEditFechaNacimiento.setContentAreaFilled(false);
		btnEditFechaNacimiento.setFocusPainted(false);
		add(btnEditFechaNacimiento);
		
		btnEditTelefono = new JButton("");
		btnEditTelefono.addActionListener(this);
		btnEditTelefono.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/editar.PNG")));
		btnEditTelefono.setBounds(714, 239, 43, 34);
		btnEditTelefono.setBorderPainted(false);
		btnEditTelefono.setOpaque(false);
		btnEditTelefono.setContentAreaFilled(false);
		btnEditTelefono.setFocusPainted(false);
		add(btnEditTelefono);
		
		btnEditCorreo = new JButton("");
		btnEditCorreo.addActionListener(this);
		btnEditCorreo.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/editar.PNG")));
		btnEditCorreo.setBounds(714, 302, 43, 34);
		btnEditCorreo.setBorderPainted(false);
		btnEditCorreo.setOpaque(false);
		btnEditCorreo.setContentAreaFilled(false);
		btnEditCorreo.setFocusPainted(false);
		add(btnEditCorreo);
		
		btnEditContraseña = new JButton("");
		btnEditContraseña.addActionListener(this);
		btnEditContraseña.setIcon(new ImageIcon(panelCuenta.class.getResource("/Imagenes/editar.PNG")));
		btnEditContraseña.setBounds(714, 368, 43, 34);
		btnEditContraseña.setBorderPainted(false);
		btnEditContraseña.setOpaque(false);
		btnEditContraseña.setContentAreaFilled(false);
		btnEditContraseña.setFocusPainted(false);
		add(btnEditContraseña);
		tfContraseña.setEditable(false);
		
		tfContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfContraseña.setBounds(305, 370, 379, 33);
		add(tfContraseña);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		
		if(boton.equals(btnEditNombre)) {
			String nombre = JOptionPane.showInputDialog("Introduzca el nuevo nombre: ");
			if(nombre != null) {
			
				StringTokenizer tokens=new StringTokenizer(nombre);
				boolean control=true;
				
				while(tokens.hasMoreTokens() && control){
					
					String cadena=tokens.nextToken();
					
					if (comprobarCaracter(cadena)==true) {
						control=true;
			
					}else {					
						control=false;
					}
			    }
				
				if(control == false) {
					JOptionPane.showMessageDialog(null, "El nombre debe ser una cadena de caracteres");
				}else {
					tfNombre.setText(nombre);
				}
			}
			
		}else if(boton.equals(btnEditApellidos)) {
			String apellidos = JOptionPane.showInputDialog("Introduzca los apellidos nuevos: ");
			
			if(apellidos != null) {
				StringTokenizer tokens=new StringTokenizer(apellidos);
				boolean control=true;
				
				while(tokens.hasMoreTokens() && control){
					
					String cadena=tokens.nextToken();
					
					if (comprobarCaracter(cadena)==true) {
						control=true;
			
					}else {					
						control=false;
					}
			    }
				
				if(control == false) {
					JOptionPane.showMessageDialog(null, "Los apellidos debe ser una cadena de caracteres");
				}else{
					tfApellidos.setText(apellidos);
				}
			}
			
		}else if(boton.equals(btnEditFechaNacimiento)) {
			String fecha = JOptionPane.showInputDialog("Introduzca la nueva fecha de nacimiento: (dd-mm-yyyy)");
			
			if(fecha !=null) {
				if(validarFecha(fecha)) {
					if(mayoriaEdad(fecha)>=18) {
						tfFecha_Nacimiento.setText(fecha);
					}else {
						JOptionPane.showMessageDialog(null, "Debe ser mayor de edad");
					}
				}else {
					JOptionPane.showMessageDialog(null, "El formato es incorrecto");
				}
			}
		}else if(boton.equals(btnEditTelefono)) {
			String telefono = (JOptionPane.showInputDialog("Introduzca el nuevo telefono: "));
			
			if(telefono != null) {
				
				if(comprobarTelefono(telefono)) {
					tfTelefono.setText(telefono);
				}else {
					JOptionPane.showMessageDialog(null, "El numero introducido es incorrecto");
				}
			}
			
		}else if(boton.equals(btnEditCorreo)) {
			String correo = "";
			correo = JOptionPane.showInputDialog("Introduzca el nuevo correo: ");
			
			if(correo != null) {
			
				if(gdb.devolverCorreo(correo) == false) {
					JOptionPane.showMessageDialog(null, "El correo introducido ya existe");
				}else {
					if(comprobarEmail(correo)) {
						tfCorreo.setText(correo);
					}else {
						JOptionPane.showMessageDialog(null, "El correo introducido es incorrecto");
					}
				}
			}
			
		}else if(boton.equals(btnEditContraseña)) {
			JPasswordField pf = new JPasswordField();
			
			int uno = JOptionPane.showConfirmDialog(null, pf, "Introduce la contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			String contraseña1 = new String (pf.getText());
			
			pf.setText("");
			
			int dos = JOptionPane.showConfirmDialog(null, pf, "Introduce de nueva la contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			String contraseña2 = new String (pf.getText());
			
			if(!contraseña1.equals("") && !contraseña2.equals("")) {
			
				if(contraseña1.equals(contraseña2)) {
					tfContraseña.setText(contraseña2);
				}else {
					JOptionPane.showMessageDialog(null, "No coinciden las contraseñas. Vuelva a intentarlo");
				}			
			}
		}else if(boton.equals(btnGuardar)) {
			try {
				if(gdb.actualizarCampos(tfNombre.getText(), tfApellidos.getText(), tfFecha_Nacimiento.getText(), tfTelefono.getText(),tfCorreo.getText(), tfContraseña.getText())) {
					JOptionPane.showMessageDialog(null, "Los campos han sido actualizados");
				}else {
					JOptionPane.showMessageDialog(null, "Alguno de los valores nuevos son incorrectos");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(boton.equals(btnCancelar)) {
			setVisible(false);
		}
	}
	
	public void actualizarTextFields() {
		ArrayList<String> datos=gdb.getDatos();
		tfNombre.setText(datos.get(3));
		tfApellidos.setText(datos.get(4));
		tfFecha_Nacimiento.setText(datos.get(5));
		tfCorreo.setText(datos.get(0));
		tfContraseña.setText(datos.get(1));
		tfContraseña.setEchoChar((char)'*');
		tfTelefono.setText(datos.get(2));
	}
	
	public static boolean validarFecha(String fecha) {
		boolean correcto = true;
        try {
        	if(fecha.length()>10) {
        		correcto = false;
        	}else {
	            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	            formatoFecha.setLenient(false);
	            formatoFecha.parse(fecha);
        	}
        } catch (ParseException e) {
            correcto = false;
        }
        return correcto;
    }
	
	public int mayoriaEdad(String fecha) {
		StringTokenizer st = new StringTokenizer(fecha,"-");
		
		int dia = Integer.parseInt(st.nextToken());
		int mes = Integer.parseInt(st.nextToken());
		int anio = Integer.parseInt(st.nextToken());
		
		LocalDate start = LocalDate.of(anio, mes, dia);
		LocalDate end = LocalDate.now();
		
		Period period = Period.between(start, end);
		
		System.out.println("Edad : "+ period.getYears());
		return period.getYears();
	}
	
	protected boolean comprobarTelefono(String telefono) {		
		boolean valido=true, letras=true;
		int miNumero;
		
		if(telefono.matches("[0-9]+")) {
			letras=true;
		}else {
			letras=false;
		}
		
		if(letras==true) {
			
			miNumero = Integer.parseInt(telefono.substring(0,1));
			
			if (telefono.length()==9 && (miNumero==6 || miNumero==7)) {
				valido=true;
			}else {
				valido=false;
			}		
			
		}else if(letras==false) {
			valido=false;
		}		
		return valido;
	}
	
	public boolean comprobarCaracter(String n) {
		boolean valido=true;
		
		if (n.matches("[a-zA-Z]+")) {
			valido=true;
		}else {
			valido=false;
		}
		
		return valido;
	}
	
	public boolean comprobarEmail(String correo) {         
		boolean correcto = false;        
		String formato = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "(hotmail|gmail)*(.com|.es)$";
		if (correo.matches(formato) == false) {
			//JOptionPane.showMessageDialog(null,"Formato de email incorrecto");
		}
		return correo.matches(formato);   
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public void setTfApellidos(JTextField tfApellidos) {
		this.tfApellidos = tfApellidos;
	}

	public void setTfFecha_Nacimiento(JTextField tfFecha_Nacimiento) {
		this.tfFecha_Nacimiento = tfFecha_Nacimiento;
	}

	public void setTfTelefono(JTextField tfTelefono) {
		this.tfTelefono = tfTelefono;
	}

	public void setTfCorreo(JTextField tfCorreo) {
		this.tfCorreo = tfCorreo;
	}

	public void setTfContraseña(JPasswordField tfContraseña) {
		this.tfContraseña = tfContraseña;
	}

	public void setBtnEditNombre(JButton btnEditNombre) {
		this.btnEditNombre = btnEditNombre;
	}

	public void setBtnEditApellidos(JButton btnEditApellidos) {
		this.btnEditApellidos = btnEditApellidos;
	}

	public void setBtnEditFechaNacimiento(JButton btnEditFechaNacimiento) {
		this.btnEditFechaNacimiento = btnEditFechaNacimiento;
	}

	public void setBtnEditTelefono(JButton btnEditTelefono) {
		this.btnEditTelefono = btnEditTelefono;
	}

	public void setBtnEditCorreo(JButton btnEditCorreo) {
		this.btnEditCorreo = btnEditCorreo;
	}

	public void setBtnEditContraseña(JButton btnEditContraseña) {
		this.btnEditContraseña = btnEditContraseña;
	}

	public void setResultado2(ResultSet resultado2) {
		this.resultado2 = resultado2;
	}

	public void setGdb(Gestion gdb) {
		this.gdb = gdb;
	}

	public void setConx(conexion conx) {
		this.conx = conx;
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
		return tfTelefono;//
	}
	protected JTextField getTfCorreo() {
		return tfCorreo;
	}
	protected JPasswordField getTfContraseña() {
		return tfContraseña;
	}
	protected JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
