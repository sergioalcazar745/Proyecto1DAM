package Graficos;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class panel_Articulo_Filtro extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public panel_Articulo_Filtro() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 853, 544);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 52, 853, 492);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(400, 1460));
		panel_1.setBackground(new Color(211, 211, 211));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 50, 50));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(33, 1, 181, 271);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("PUTOS AMOS 2020");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(56, 283, 141, 20);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Precio: 30000");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(128, 314, 86, 17);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_3);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(33, 1, 181, 271);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("PUTOS AMOS 2020");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(56, 283, 141, 20);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Precio: 30000");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(128, 314, 86, 17);
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_4);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(33, 1, 181, 271);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("PUTOS AMOS 2020");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(56, 283, 141, 20);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("Precio: 30000");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(128, 314, 86, 17);
		panel_4.add(label_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_5);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(33, 1, 181, 271);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("PUTOS AMOS 2020");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(56, 283, 141, 20);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Precio: 30000");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(128, 314, 86, 17);
		panel_5.add(label_11);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_6);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(33, 1, 181, 271);
		panel_6.add(label_12);
		
		JLabel label_13 = new JLabel("PUTOS AMOS 2020");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_13.setBounds(56, 283, 141, 20);
		panel_6.add(label_13);
		
		JLabel label_14 = new JLabel("Precio: 30000");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(128, 314, 86, 17);
		panel_6.add(label_14);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_7);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(33, 1, 181, 271);
		panel_7.add(label_15);
		
		JLabel label_16 = new JLabel("PUTOS AMOS 2020");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_16.setBounds(56, 283, 141, 20);
		panel_7.add(label_16);
		
		JLabel label_17 = new JLabel("Precio: 30000");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_17.setBounds(128, 314, 86, 17);
		panel_7.add(label_17);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_8);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(33, 1, 181, 271);
		panel_8.add(label_18);
		
		JLabel label_19 = new JLabel("PUTOS AMOS 2020");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_19.setBounds(56, 283, 141, 20);
		panel_8.add(label_19);
		
		JLabel label_20 = new JLabel("Precio: 30000");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_20.setBounds(128, 314, 86, 17);
		panel_8.add(label_20);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_9);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(33, 1, 181, 271);
		panel_9.add(label_21);
		
		JLabel label_22 = new JLabel("PUTOS AMOS 2020");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_22.setBounds(56, 283, 141, 20);
		panel_9.add(label_22);
		
		JLabel label_23 = new JLabel("Precio: 30000");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_23.setBounds(128, 314, 86, 17);
		panel_9.add(label_23);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(211, 211, 211));
		panel_1.add(panel_10);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(33, 1, 181, 271);
		panel_10.add(label_24);
		
		JLabel label_25 = new JLabel("PUTOS AMOS 2020");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_25.setBounds(56, 283, 141, 20);
		panel_10.add(label_25);
		
		JLabel label_26 = new JLabel("Precio: 30000");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_26.setBounds(128, 314, 86, 17);
		panel_10.add(label_26);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 11, 139, 30);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(243, 11, 493, 30);
		panel.add(textField);
		textField.setColumns(10);

	}
}
