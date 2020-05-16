package Graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Base_de_datos.Gestion;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Stock extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String [3];
	private JButton btnOk;
	private Connection con;
	private Gestion gdb=new Gestion();
	public Stock(Gestion gdb) {
		this.gdb=gdb;
		setVisible(true);
		setBounds(100, 100, 648, 466);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		table = new JTable() {;
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }
		};
		table.setBackground(Color.WHITE);
		modelo.addColumn("Articulo");
		modelo.addColumn("Talla");
		modelo.addColumn("Cantidad");
		table.setModel(modelo);	    
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 36, 536, 319);
		contentPanel.add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(this);
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
		}	         
	    
		insertarStock();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object evento = arg0.getSource();
		
		if(evento.equals(btnOk)) {
			dispose();
		}
		
	}
	
	public void insertarStock() {
		ArrayList<String> stock = new ArrayList<String>();
		stock=gdb.devolverStock();
		System.out.println("tamañooo: "+stock.size());
		int j = 0;
		for(int i = 0; i<stock.size(); i++) {
			Datos[j] = stock.get(i);
			j++;
			if(j==3) {
				j = 0;
				modelo.addRow(Datos);
			}			
		}
	}
	public JButton getBtnOk() {
		return btnOk;
	}
}
