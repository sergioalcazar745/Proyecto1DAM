package Graficos;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Base_de_datos.Gestion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelMisPedidos extends JPanel {
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] Datos = new String [5];
	private String [] Datos2 = new String [4];
	private Gestion gdb;
	
	public panelMisPedidos(Gestion gdb) {
		this.gdb=gdb;
		setBackground(Color.WHITE);
		setVisible(true);
		setBounds(232, 11, 853, 544);
		setLayout(null);
		
		if(gdb.getCliente()) {
			table = new JTable() {;
				//esto desactiva que podamos editar la tabla
		        public boolean editCellAt(int row, int column, java.util.EventObject e) {
		            return false;
		        }
			};
	      	table.setShowGrid(false);
			table.setFont(new Font("Tahoma", Font.PLAIN, 13));
			modelo.addColumn("Articulo");
			modelo.addColumn("Talla");
			modelo.addColumn("Fecha");
			modelo.addColumn("Cantidad");
			modelo.addColumn("Precio");
			table.setModel(modelo);
			table.setRowHeight(25);
			
			TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(125);
		}else {
			table = new JTable() {;
			//esto desactiva que podamos editar la tabla
	        public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
	      };
	      	table.setShowGrid(false);
			table.setFont(new Font("Tahoma", Font.PLAIN, 13));
			modelo.addColumn("Articulo");
			modelo.addColumn("Talla");
			modelo.addColumn("Fecha");
			modelo.addColumn("Precio");
			table.setModel(modelo);
			table.setRowHeight(25);
			
			TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(125);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 111, 712, 372);
		add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Aqu\u00ED podr\u00E1s encontrar todos las compras que has realizado con tu cuenta.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 38, 853, 49);
		add(lblNewLabel);
		
		JButton btnHome = new JButton("Refrescar");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPedidos();
			}
		});
		btnHome.setBounds(10, 80, 79, 25);
		add(btnHome);
		
		insertarPedidos();
		//System.out.println("HOla");
	}
	
	public void insertarPedidos() {
		modelo.setRowCount(0);		
		if(gdb.getSesionIniciada() && gdb.getCliente()) {
			ArrayList<String> compra = new ArrayList<String>();
			compra = gdb.devolverCompra();
			int j = 0;
			for(int i = 0; i<compra.size(); i++) {
				Datos2[j] = compra.get(i);
				j++;
				if(j==4) {
					j = 0;
					modelo.addRow(Datos2);
				}
			}
		}else if(gdb.getSesionIniciada() && gdb.getCliente()==false){
			ArrayList<String> suministro = new ArrayList<String>();
			suministro = gdb.devolverSuministro();
			int j = 0;
			for(int i = 0; i<suministro.size(); i++) {
//System.out.println("suministro.get(i): "+suministro.get(i));
				Datos[j] = suministro.get(i);
				j++;
				if(j==5) {
					j = 0;
					modelo.addRow(Datos);
				}
			}
		}
	}
}
