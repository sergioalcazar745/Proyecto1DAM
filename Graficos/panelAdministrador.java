package Graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class panelAdministrador extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	public panelAdministrador() {
		setBounds(232, 11, 853, 544);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Articulo:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(94, 57, 71, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Proveedor:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(665, 57, 88, 16);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Camiseta", "Pantalon", "Chaqueta", "Sudadera", "Zapatillas"}));
		comboBox.setBounds(32, 86, 211, 29);
		add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(593, 86, 211, 29);
		add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(94, 217, 75, 16);
		add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(true);
		spinner.setBounds(32, 246, 220, 29);
		add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Precio final:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(654, 217, 99, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(593, 246, 211, 47);
		add(textField);
		textField.setColumns(10);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setIcon(new ImageIcon(panelAdministrador.class.getResource("/Imagenes/shopping_bag.png")));
		btnComprar.setFont(new Font("Arial", Font.BOLD, 16));
		btnComprar.setBounds(183, 322, 154, 40);
		btnComprar.setBorderPainted(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		add(btnComprar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 413, 778, 2);
		add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("Dinero disponible:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(51, 460, 142, 16);
		add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setEnabled(false);
		textField_1.setBounds(222, 455, 567, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setIcon(new ImageIcon(panelAdministrador.class.getResource("/Imagenes/equis.png")));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setBounds(449, 322, 170, 40);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		add(btnCancelar);
		
		btnComprar.setBorderPainted(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setFocusPainted(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(32, 167, 211, 29);
		add(comboBox_1);
		
		JLabel lblCategoria = new JLabel("Pertenece a:");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategoria.setBounds(375, 56, 105, 19);
		add(lblCategoria);
		
		JLabel lblNewLabel_5 = new JLabel("Categorias disponibles");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setBounds(44, 138, 188, 16);
		add(lblNewLabel_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(315, 86, 211, 29);
		add(comboBox_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(panelAdministrador.class.getResource("/Imagenes/plus.png")));
		btnNewButton.setBounds(254, 167, 43, 29);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		add(btnNewButton);
	}
}
