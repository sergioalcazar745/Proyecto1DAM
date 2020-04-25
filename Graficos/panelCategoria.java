package Graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class panelCategoria extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String [1];
	private JTextField tfAñadir;
	private JButton btnAñadir;
	private JButton cancelButton;

	public panelCategoria() {
		setVisible(true);
		setBounds(100, 100, 545, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			table = new JTable();
			modelo.addColumn("Categoria");
			table.setModel(modelo);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(49, 67, 419, 217);
			contentPanel.add(scrollPane);
			scrollPane.setColumnHeaderView(table);
			scrollPane.setViewportView(table);
		}
		
		tfAñadir = new JTextField();
		tfAñadir.setFont(new Font("Arial", Font.PLAIN, 12));
		tfAñadir.setBounds(71, 34, 264, 25);
		contentPanel.add(tfAñadir);
		tfAñadir.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAñadir.addActionListener(this);
		btnAñadir.setBounds(359, 36, 97, 25);
		contentPanel.add(btnAñadir);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	public JTextField getTfAñadir() {
		return tfAñadir;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnAñadir)) {
			Datos [0] = tfAñadir.getText();
			modelo.addRow(Datos);
		}else if(evento.equals(cancelButton)) {
			 dispose();
		}
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}
