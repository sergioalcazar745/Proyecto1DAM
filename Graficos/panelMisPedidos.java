package Graficos;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class panelMisPedidos extends JPanel {
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String [1];
	
	public panelMisPedidos() {
		setBackground(Color.WHITE);
		setVisible(true);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		table = new JTable();
		modelo.addColumn("Articulo");
		modelo.addColumn("Fecha");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		table.setModel(modelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 132, 712, 372);
		add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Aqu\u00ED podr\u00E1s encontrar todos las compras que has realizado con tu cuenta.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 49, 853, 49);
		add(lblNewLabel);
	}
}
