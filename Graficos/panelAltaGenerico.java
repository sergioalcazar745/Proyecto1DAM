package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class panelAltaGenerico extends JPanel implements ActionListener{
	private JTextField textField;
	private JButton btnSeleccionar;
	private JFileChooser fileChooser;
	private JTextField textField_1;
	private JTextField textField_2;

	public panelAltaGenerico() {
		setBackground(Color.WHITE);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(78, 82, 163, 22);
		add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(354, 82, 163, 22);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(618, 82, 163, 22);
		add(textField_2);
		
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
		
		JButton btnNewButton = new JButton("Crear articulo");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(618, 413, 163, 37);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la imagen del articulo (176x270.png)");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(72, 185, 344, 37);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(190, 250, 176, 270);
		add(lblNewLabel_2);
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
				File selectedFile = file.getSelectedFile();
			}
		}				
	}
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	public JFileChooser getFileChooser() {
		return fileChooser;
	}
}
