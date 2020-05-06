package Graficos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class panel_Articulo extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_Articulo(String nombre_articulo) {
		System.out.println("nombre: "+nombre_articulo);
		setBounds(0, 48, 853, 496);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");//imagen
		lblNewLabel.setIcon(new ImageIcon(panel_articulos_filtros.class.getResource("/fotos_articulos/"+nombre_articulo+".jpg")));
		lblNewLabel.setBounds(185, 111, 175, 271);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(nombre_articulo);
		lblNewLabel_1.setBounds(397, 161, 250, 23);
		add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(397, 228, 259, 99);
		add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(397, 194, 141, 23);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.setBounds(532, 423, 124, 49);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cesta");
		btnNewButton_1.setBounds(693, 423, 106, 49);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(358, 423, 147, 49);
		add(btnNewButton_2);
		
	}
}
