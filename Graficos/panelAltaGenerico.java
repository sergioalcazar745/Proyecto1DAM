package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Base_de_datos.Gestion;
import Base_de_datos.conexion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class panelAltaGenerico extends JPanel implements ActionListener{
	private JTextField textField_Nombre;
	private JButton btnSeleccionar;
	private JFileChooser fileChooser;
	private JTextField textField_precioCompra;
	private JTextField textField_precioVenta;
	private JButton crearGenerico;
	File selectedFile=null;
	conexion cnx=new conexion();
	Gestion gdb=new Gestion();
	private JLabel lblNewLabel_2;
	private JLabel lblDimensiones;
	public panelAltaGenerico(Gestion gdb, conexion cnx) {
		this.gdb=gdb;
		this.cnx=cnx;
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(78, 82, 163, 22);
		add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre del articulo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 53, 163, 16);
		add(lblNewLabel);
		
		btnSeleccionar = new JButton("Seleccionar arcchivo");
		btnSeleccionar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(434, 191, 197, 25);
		add(btnSeleccionar);
		
		textField_precioCompra = new JTextField();
		textField_precioCompra.setColumns(10);
		textField_precioCompra.setBounds(354, 82, 163, 22);
		add(textField_precioCompra);
		
		textField_precioVenta = new JTextField();
		textField_precioVenta.setColumns(10);
		textField_precioVenta.setBounds(618, 82, 163, 22);
		add(textField_precioVenta);
		
		JLabel lblPrecionDeCompra = new JLabel("Precion de compra");
		lblPrecionDeCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecionDeCompra.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecionDeCompra.setBounds(354, 54, 163, 16);
		add(lblPrecionDeCompra);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta");
		lblPrecioDeVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioDeVenta.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecioDeVenta.setBounds(618, 54, 163, 16);
		add(lblPrecioDeVenta);
		
		crearGenerico = new JButton("Crear articulo");
		crearGenerico.setFont(new Font("Arial", Font.PLAIN, 16));
		crearGenerico.setBounds(618, 413, 163, 37);
		add(crearGenerico);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la imagen del articulo (176x270.png)");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(72, 185, 344, 37);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(172, 233, 176, 270);
		add(lblNewLabel_2);
		
		lblDimensiones = new JLabel("");
		lblDimensiones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDimensiones.setHorizontalAlignment(SwingConstants.LEFT);
		lblDimensiones.setBounds(366, 233, 188, 25);
		add(lblDimensiones);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnSeleccionar)) {
			JFileChooser file = new JFileChooser();
			//file.setCurrentDirectory(System.getProperty("use.home"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg");
			file.addChoosableFileFilter(filter);
			int result = file.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION) {
				selectedFile = file.getSelectedFile();
				if(selectedFile!=null) {
					BufferedImage bimg=null;
					try {
						bimg = ImageIO.read(selectedFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(bimg!=null) {
						lblNewLabel_2.setIcon(new ImageIcon(bimg));
						lblDimensiones.setText("Tamaño: "+bimg.getWidth()+"x"+bimg.getHeight());
					}else {
						JOptionPane.showMessageDialog(null, "El formato de la imagen no es válido");
						lblDimensiones.setText("");
					}
				}
			}
		}			
	}
	 public String getFileExtension(File file) {
	        String fileName = file.getName();
	        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return fileName.substring(fileName.lastIndexOf(".")+1);
	        else return "";
	    }
	 public boolean comprobarDouble(){
		boolean correcto=false;
		String numero, numero2;
		 try {
			 numero=textField_precioCompra.getText().replace(',', '.');
			 numero2=textField_precioVenta.getText().replace(',', '.');
			 textField_precioCompra.setText(numero);
			 textField_precioVenta.setText(numero2);
			 Double.parseDouble(numero);
			 Double.parseDouble(numero2);
			 correcto=true;
		 }catch(Exception e) {
			// e.printStackTrace();
			 correcto=false;
		 }
		return correcto;
	 }
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	public boolean crearArticulo() {
		boolean creado=false;
		if(selectedFile!=null && textField_Nombre.getText()!=null && textField_precioCompra.getText()!=null && textField_precioVenta.getText()!=null) {
			//aqui haremos las comprobaciones antes de entrar de si el nombre ya existe en la base de datos
			if(!textField_Nombre.getText().equals("")) {
			if(getFileExtension(selectedFile).equalsIgnoreCase("png") || getFileExtension(selectedFile).equalsIgnoreCase("jpg")) {
				BufferedImage bimg;
				try {
					bimg = ImageIO.read(selectedFile);
					int width= bimg.getWidth();
					int height= bimg.getHeight();
					if(width==176 && height==270 ) {
						//insertamos el articulogenerico
						//System.out.println("hola");
						if(gdb.devolverNombreGenerico(textField_Nombre.getText())==false) {
							if(comprobarDouble()) {
						try {
							gdb.insertarArticuloGenerico(selectedFile, textField_Nombre.getText(),"descripion",  textField_precioCompra.getText(),textField_precioVenta.getText());
							if(gdb.getArray_articuloGenerico().size()!=0) {
								gdb.añadirImagenes(bimg, textField_Nombre.getText());	
							}
							JOptionPane.showMessageDialog(null, "Articulo Genérico Creado");
							creado=true;
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}else {
								JOptionPane.showMessageDialog(null, "Los precios no son validos");
							}
						}else {
							JOptionPane.showMessageDialog(null, "El nombre del articulo ya existe");
						}
					}else {
						//System.out.println("adios");
						JOptionPane.showMessageDialog(null, "La imagen deberá de tener un tamaño de 176x270 obligatoriamente");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "El formato de la imagen no es válido");
			}
			}else {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio");
			}
		}
		return creado;
	}
	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	public JButton getCrearGenerico() {
		return crearGenerico;
	}
	public JTextField getTextField_Nombre() {
		return textField_Nombre;
	}
	public JTextField getTextField_precioCompra() {
		return textField_precioCompra;
	}
	public File getSelectedFile() {
		return selectedFile;
	}
	public JTextField getTextField_precioVenta() {
		return textField_precioVenta;
	}
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}
	public JLabel getLblDimensiones() {
		return lblDimensiones;
	}
}
