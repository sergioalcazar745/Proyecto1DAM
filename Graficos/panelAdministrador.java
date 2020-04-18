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

public class panelAdministrador extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	public panelAdministrador() {
		setBounds(232, 11, 853, 544);
		setBackground(new Color(211, 211, 211));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Articulo:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(107, 44, 71, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Proveedor:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(402, 44, 88, 16);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Camiseta", "Pantalon", "Chaqueta", "Sudadera", "Zapatillas"}));
		comboBox.setBounds(48, 70, 211, 29);
		add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(355, 70, 211, 29);
		add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(103, 145, 75, 16);
		add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(48, 174, 220, 29);
		add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Precio final:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(401, 145, 99, 16);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(355, 174, 211, 47);
		add(textField);
		textField.setColumns(10);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setBounds(142, 242, 117, 40);
		add(btnComprar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(316, 242, 117, 40);
		add(btnCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 304, 557, 2);
		add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("Dinero disponible:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(54, 335, 142, 16);
		add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 333, 358, 22);
		add(textField_1);
		textField_1.setColumns(10);

	}
}
