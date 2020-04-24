package Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class panel_articulos extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField textField;
	public panel_articulos() {
		JPanel panel_Articulos = new JPanel();
		panel_Articulos.setBackground(Color.WHITE);
		panel_Articulos.setBounds(232, 11, 900, 1746);
		panel_Articulos.setLayout(null);	
		
		JScrollPane scrollPane_Articulos = new JScrollPane();
		scrollPane_Articulos.setBounds(0, 50, 903, 1700);
		panel_Articulos.add(scrollPane_Articulos);
		
		textField = new JTextField();
		textField.setBounds(299, 11, 453, 28);
		panel_Articulos.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(400, 1460));
		panel_2.setBackground(Color.WHITE);
		scrollPane_Articulos.setViewportView(panel_2);
		scrollPane_Articulos.getVerticalScrollBar().setUnitIncrement(20);
		panel_2.setLayout(new GridLayout(3, 3, 50, 50));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/BERMUDA DENIM MOM FIT.jpg")));
		label.setBounds(33, 1, 181, 271);
		panel_3.add(label);
		
		JLabel lblBermudaDenimMom = new JLabel("Bermuda denim mom fit");
		lblBermudaDenimMom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBermudaDenimMom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBermudaDenimMom.setBounds(10, 283, 224, 20);
		panel_3.add(lblBermudaDenimMom);
		
		JLabel label_2 = new JLabel("Precio: 30000");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(128, 314, 86, 17);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/BERMUDA EFECTO BRILLO.jpg")));
		label_3.setBounds(33, 1, 181, 271);
		panel_4.add(label_3);
		
		JLabel lblBermudaEfectoBrillo = new JLabel("Bermuda efecto brillo");
		lblBermudaEfectoBrillo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBermudaEfectoBrillo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBermudaEfectoBrillo.setBounds(10, 283, 224, 20);
		panel_4.add(lblBermudaEfectoBrillo);
		
		JLabel label_5 = new JLabel("Precio: 30000");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(128, 314, 86, 17);
		panel_4.add(label_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/BODY ENCAJE.jpg")));
		label_6.setBounds(33, 1, 181, 271);
		panel_5.add(label_6);
		
		JLabel lblBodyEncaje = new JLabel("Body encaje");
		lblBodyEncaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblBodyEncaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBodyEncaje.setBounds(56, 283, 141, 20);
		panel_5.add(lblBodyEncaje);
		
		JLabel label_8 = new JLabel("Precio: 30000");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(128, 314, 86, 17);
		panel_5.add(label_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_6);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/CAMISETA ESTAMPADA SMILEY.jpg")));
		label_9.setBounds(33, 1, 181, 271);
		panel_6.add(label_9);
		
		JLabel lblCamisetaEstampadaSmiley = new JLabel("Camiseta estampada smiley");
		lblCamisetaEstampadaSmiley.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamisetaEstampadaSmiley.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCamisetaEstampadaSmiley.setBounds(10, 283, 247, 20);
		panel_6.add(lblCamisetaEstampadaSmiley);
		
		JLabel label_11 = new JLabel("Precio: 30000");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(128, 314, 86, 17);
		panel_6.add(label_11);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_7);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/CAMISETA MARILYN MONROE TM.jpg")));
		label_12.setBounds(33, 1, 181, 271);
		panel_7.add(label_12);
		
		JLabel lblCamisetaMarilynMonroe = new JLabel("Camiseta marilyn");
		lblCamisetaMarilynMonroe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamisetaMarilynMonroe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCamisetaMarilynMonroe.setBounds(10, 283, 247, 20);
		panel_7.add(lblCamisetaMarilynMonroe);
		
		JLabel label_14 = new JLabel("Precio: 30000");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(128, 314, 86, 17);
		panel_7.add(label_14);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_8);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/CAMISETA VOLANTES.jpg")));
		label_15.setBounds(33, 1, 181, 271);
		panel_8.add(label_15);
		
		JLabel lblCamisetaVolantes = new JLabel("Camiseta Volantes");
		lblCamisetaVolantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamisetaVolantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCamisetaVolantes.setBounds(10, 283, 247, 20);
		panel_8.add(lblCamisetaVolantes);
		
		JLabel label_17 = new JLabel("Precio: 30000");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(128, 314, 86, 17);
		panel_8.add(label_17);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_9);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/CAZADORA DENIM CROPPED.jpg")));
		label_18.setBounds(33, 1, 181, 271);
		panel_9.add(label_18);
		
		JLabel lblCazadoraDenimCropped = new JLabel("Cazadora denim cropped");
		lblCazadoraDenimCropped.setHorizontalAlignment(SwingConstants.CENTER);
		lblCazadoraDenimCropped.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCazadoraDenimCropped.setBounds(56, 283, 247, 20);
		panel_9.add(lblCazadoraDenimCropped);
		
		JLabel label_20 = new JLabel("Precio: 30000");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_20.setBounds(128, 314, 86, 17);
		panel_9.add(label_20);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_10);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/DEPORTIVO RETRO SUELA VOLUMEN.jpg")));
		label_21.setBounds(33, 1, 181, 271);
		panel_10.add(label_21);
		
		JLabel lblDeportivoRetro = new JLabel("Deportivo retro");
		lblDeportivoRetro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeportivoRetro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeportivoRetro.setBounds(56, 283, 247, 20);
		panel_10.add(lblDeportivoRetro);
		
		JLabel label_23 = new JLabel("Precio: 30000");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_23.setBounds(128, 314, 86, 17);
		panel_10.add(label_23);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(211, 211, 211));
		panel_2.add(panel_11);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fotos_articulos/DEPORTIVO VOLUMEN MULTIPIEZAS.jpg")));
		label_24.setBounds(33, 1, 181, 271);
		panel_11.add(label_24);
		
		JLabel lblDeportivoVolumenMultipiezas = new JLabel("Deportivo volumen multipiezas");
		lblDeportivoVolumenMultipiezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeportivoVolumenMultipiezas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeportivoVolumenMultipiezas.setBounds(56, 283, 247, 20);
		panel_11.add(lblDeportivoVolumenMultipiezas);
		
		JLabel label_26 = new JLabel("Precio: 30000");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_26.setBounds(128, 314, 86, 17);
		panel_11.add(label_26);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(172, 11, 127, 28);
		panel_Articulos.add(comboBox);
	}
}
