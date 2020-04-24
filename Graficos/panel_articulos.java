package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class panel_articulos extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_articulos() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(825, 1300));
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(new GridLayout(3, 3, 50, 50));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/BERMUDA DENIM MOM FIT.jpg")));
		label.setBounds(35, 1, 175, 271);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Bermuda denim mom fit");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(0, 283, 246, 20);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Precio: 30000");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(128, 314, 86, 17);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/BERMUDA EFECTO BRILLO.jpg")));
		label_3.setBounds(35, 1, 175, 271);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Bermuda efecto brillo");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(0, 283, 241, 20);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Precio: 30000");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(128, 314, 86, 17);
		panel_2.add(label_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/BODY ENCAJE.jpg")));
		label_6.setBounds(35, 1, 175, 271);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Body encaje");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(0, 283, 246, 20);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("Precio: 30000");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(128, 314, 86, 17);
		panel_3.add(label_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/CAMISETA ESTAMPADA SMILEY.jpg")));
		label_9.setBounds(35, 1, 175, 271);
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("Camiseta estampada smiley");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(0, 283, 241, 20);
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("Precio: 30000");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(128, 314, 86, 17);
		panel_4.add(label_11);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel.add(panel_5);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/CAMISETA MARILYN MONROE TM.jpg")));
		label_12.setBounds(35, 1, 175, 271);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("Camiseta marilyn");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_13.setBounds(0, 283, 241, 20);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Precio: 30000");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(128, 314, 86, 17);
		panel_5.add(label_14);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel.add(panel_6);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/CAMISETA VOLANTES.jpg")));
		label_15.setBounds(35, 1, 175, 271);
		panel_6.add(label_15);
		
		JLabel label_16 = new JLabel("Camiseta Volantes");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_16.setBounds(0, 283, 241, 20);
		panel_6.add(label_16);
		
		JLabel label_17 = new JLabel("Precio: 30000");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(128, 314, 86, 17);
		panel_6.add(label_17);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel.add(panel_7);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/CAZADORA DENIM CROPPED.jpg")));
		label_18.setBounds(35, 1, 175, 271);
		panel_7.add(label_18);
		
		JLabel label_19 = new JLabel("Cazadora denim cropped");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_19.setBounds(0, 283, 246, 20);
		panel_7.add(label_19);
		
		JLabel label_20 = new JLabel("Precio: 30000");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_20.setBounds(128, 314, 86, 17);
		panel_7.add(label_20);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel.add(panel_8);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/DEPORTIVO RETRO SUELA VOLUMEN.jpg")));
		label_21.setBounds(35, 1, 175, 271);
		panel_8.add(label_21);
		
		JLabel label_22 = new JLabel("Deportivo retro");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_22.setBounds(0, 283, 247, 20);
		panel_8.add(label_22);
		
		JLabel label_23 = new JLabel("Precio: 30000");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_23.setBounds(128, 314, 86, 17);
		panel_8.add(label_23);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel.add(panel_9);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(panel_articulos.class.getResource("/fotos_articulos/DEPORTIVO VOLUMEN MULTIPIEZAS.jpg")));
		label_24.setBounds(35, 1, 175, 271);
		panel_9.add(label_24);
		
		JLabel label_25 = new JLabel("Deportivo volumen multipiezas");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_25.setBounds(0, 283, 247, 20);
		panel_9.add(label_25);
		
		JLabel label_26 = new JLabel("Precio: 30000");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_26.setBounds(128, 314, 86, 17);
		panel_9.add(label_26);

	}

}
