package Graficos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class panel_Articulo extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_Articulo() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Imagen");
		lblNewLabel.setBounds(10, 84, 250, 150);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(270, 84, 250, 23);
		add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(270, 147, 259, 99);
		add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(270, 118, 141, 23);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.setBounds(171, 302, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cesta");
		btnNewButton_1.setBounds(270, 302, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(10, 302, 89, 23);
		add(btnNewButton_2);
		
	}
}
