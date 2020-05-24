package Graficos;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import Base_de_datos.Gestion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class panel_Articulo extends JPanel  implements ActionListener{

	/**
	 * Create the panel.
	 */
	Gestion gdb;
	JButton btnCesta = new JButton("");
	JLabel lblNewLabel_1 = new JLabel();
	private JButton btnVolver;
	JComboBox comboBox_Tallas = new JComboBox();
	JLabel lblNumeroStock = new JLabel("0");
	private JLabel lblTalla;
	private JSpinner spinner;
	JLabel lblNewLabel_2 = new JLabel("");
	JButton btnComprar = new JButton("");
	String nombre_articulo;
	JLabel lblValorDescuento = new JLabel("");
	JLabel lblValorPrecio = new JLabel("-");
	Double entero_descuento;
	JLabel lblTalla_comprada = new JLabel("New label");
	private JLabel lblEliminar;
	public panel_Articulo(String nombre_articulo, Gestion gdb){
		Color color_realizada=Color.decode("#0000cc");
		this.nombre_articulo=nombre_articulo;
		this.gdb=gdb;
		setName("laura callate");
		setBackground(Color.WHITE);
		String descripcion="";
		setBounds(0, 48, 853, 496);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");//imagen
		lblNewLabel.setIcon(new ImageIcon(gdb.insertarImagen(nombre_articulo)));
		lblNewLabel.setBounds(185, 111, 175, 271);
		add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		
		lblNewLabel_1.setText(nombre_articulo);
		lblNewLabel_1.setBounds(372, 111, 302, 23);
		add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		//Obtenemos la descripcion del articulo
		try {
			descripcion=gdb.devolverDescripcion(nombre_articulo);
		} catch (SQLException e) {
			System.out.println("Fallo al devolver descripcion");
			e.printStackTrace();
		}
		textArea.setText(descripcion);
		textArea.setBounds(372, 154, 284, 80);
		add(textArea);		
		
		btnComprar.addActionListener(this);
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setIcon(new ImageIcon(panel_Articulo.class.getResource("/Imagenes/btnComprar.png")));
		btnComprar.setBounds(424, 423, 169, 49);
		btnComprar.setBorderPainted(false);
		btnComprar.setOpaque(false);
		btnComprar.setContentAreaFilled(false);
		btnComprar.setFocusPainted(false);
		add(btnComprar);
		btnComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		

		btnCesta.setBackground(Color.WHITE);
		btnCesta.setIcon(new ImageIcon(panel_Articulo.class.getResource("/Imagenes/btnCesta.png")));
		btnCesta.setBounds(603, 423, 189, 49);
		btnCesta.setBorderPainted(false);
		btnCesta.setOpaque(false);
		btnCesta.setContentAreaFilled(false);
		btnCesta.setFocusPainted(false);
		btnCesta.addActionListener(this);
		add(btnCesta);
		btnCesta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnVolver = new JButton("");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setIcon(new ImageIcon(panel_Articulo.class.getResource("/Imagenes/flechanegra.png")));
		btnVolver.setBounds(109, 423, 55, 49);
		btnVolver.setBorderPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.addActionListener(this);
		add(btnVolver);
		
		spinner = new JSpinner();
		spinner.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblNewLabel_2.setText("");
				//si el numero de stock es mayor que 0 y el spinner tambien calculamos el precio
				if(!lblNumeroStock.equals("0") && Integer.parseInt(spinner.getValue().toString())>0) {
					 calcularPrecio();
				}
			}
		});
		
		spinner.setBounds(470, 254, 80, 22);
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		add(spinner);
		
		
		comboBox_Tallas.setModel(new DefaultComboBoxModel(new String[] {"", "S", "M", "L", "XL", "XXL", "XXXL"}));
		comboBox_Tallas.setBounds(470, 283, 80, 22);
		add(comboBox_Tallas);
		comboBox_Tallas.addActionListener(this);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(370, 256, 74, 16);
		add(lblNewLabel_3);
		
		lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTalla.setBounds(370, 283, 74, 16);
		add(lblTalla);
		
		JLabel lblStock = new JLabel("En Stock:");
		lblStock.setName("lblStock");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStock.setBounds(370, 334, 75, 23);
		add(lblStock);
		
		lblNumeroStock.setName("lblNumeroStock");
		lblNumeroStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroStock.setBounds(470, 334, 80, 23);
		add(lblNumeroStock);
		
		lblEliminar = new JLabel("");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gdb.eliminarCesta(nombre_articulo, lblTalla_comprada.getText());
				setVisible(false);
			}
		});
		lblEliminar.setIcon(new ImageIcon(panel_Articulo.class.getResource("/Imagenes/eliminar.png")));
		lblEliminar.setBounds(694, 105, 32, 29);
		lblEliminar.setName("lblEliminar");
		lblEliminar.setVisible(false);
		add(lblEliminar);
		
		JLabel lblCantidad = new JLabel("New label");
		lblCantidad.setName("lblCantidad");
		lblCantidad.setBounds(470, 254, 80, 22);
		add(lblCantidad);
		lblCantidad.setVisible(false);
		
		
		lblTalla_comprada.setName("lblTalla_comprada");
		lblTalla_comprada.setBounds(471, 283, 79, 22);
		add(lblTalla_comprada);
		
		
		lblNewLabel_2.setForeground(new Color (204, 0, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(372, 403, 189, 16);
		add(lblNewLabel_2);
		
		JLabel lblPrecio = new JLabel("Precio Total:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(370, 308, 104, 23);/*setBounds(370, 283, 74, 23);*/
		add(lblPrecio);
		
		lblValorPrecio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorPrecio.setBounds(470, 308, 80, 23);/*setBounds(370, 283, 74, 23);*/
		lblValorPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorPrecio.setName("lblValorPrecio");
		add(lblValorPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setVisible(false);
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescuento.setBounds(370, 362, 75, 16);
		add(lblDescuento);
		
		lblValorDescuento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorDescuento.setBounds(470, 359, 80, 23);
		add(lblValorDescuento);
		lblValorDescuento.setVisible(false);
		//Buscamos la oferta del articulo clickado
		try {
			if(!gdb.buscarOfertaArticulo(nombre_articulo).equals("")) {
				lblDescuento.setVisible(true);
				lblValorDescuento.setVisible(true);
				lblValorDescuento.setText(gdb.buscarOfertaArticulo(nombre_articulo)+"%");
			}
		} catch (SQLException e1) {
			System.out.println("Fallo al devolver oferta");
			//e1.printStackTrace();
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object evento=e.getSource();
		//en funcion del boton que seleccione el usuarios se ejecutara una opcion distina
		if(evento.equals(btnCesta)) {
			if(comboBox_Tallas.getSelectedItem().equals("") || (int) spinner.getValue()==0){
				if(comboBox_Tallas.getSelectedItem().equals("")) {
					lblNewLabel_2.setText("*Seleccione una talla");
					lblNewLabel_2.setForeground(new Color (204, 0, 153));
				}else {
					lblNewLabel_2.setText("*Seleccione minimo una unidad");
				}
			}else if((int) spinner.getValue()>Integer.parseInt(lblNumeroStock.getText())) {
				lblNewLabel_2.setText("*No hay suficientes articulos en Stock");
				lblNewLabel_2.setForeground(new Color (204, 0, 153));
			}else {
				lblNewLabel_2.setForeground(new Color(0, 0, 204));
				//comprobar el numero de articulos que lleva en la cesta y del numero de stock.
				int numero_stock=0;
				try {
					numero_stock=gdb.stock(nombre_articulo, comboBox_Tallas.getSelectedItem().toString());
				} catch (SQLException e1) {
					System.out.println("Fallo al devolver stock");
					//e1.printStackTrace();
				}
				if((gdb.devolverCantidadArticuloCesta(lblNewLabel_1.getText(), comboBox_Tallas.getSelectedItem().toString())+(int)spinner.getValue()) > numero_stock) {
					lblNewLabel_2.setText("*No hay suficientes articulos");
				}else {
					lblNewLabel_2.setText("*Añadido a la cesta");
					String price1 = lblValorPrecio.getText().replace(",", ".");
					double price2 = Double.parseDouble(price1);
					gdb.añadirCesta(lblNewLabel_1.getText(), comboBox_Tallas.getSelectedItem().toString(), (int) spinner.getValue(), price2);
				}
				actualizarTallas();
			}
			//Buscamos si ya existe el objeto con los mismos valores y si lo encuentra que llame al setCantidad.
		}else if(evento.equals(btnVolver)) {
			setVisible(false);
		}else if(evento.equals(comboBox_Tallas)) {
			lblNewLabel_2.setText("");
			actualizarTallas();
			if(Integer.parseInt(spinner.getValue().toString())>0) {
				calcularPrecio();
			}
		}else if(evento.equals(btnComprar)) {
			//quitar los objetos y comprobar que has iniciado sesion
			if(gdb.getSesionIniciada()==false) {
				lblNewLabel_2.setText("*Debes iniciar sesión para esta acción");
			}else if(gdb.getCliente()==true){
				try {
					if(comboBox_Tallas.getSelectedItem().equals("") || (int) spinner.getValue()==0){
						if(comboBox_Tallas.getSelectedItem().equals("")) {
							lblNewLabel_2.setText("*Seleccione una talla");
							lblNewLabel_2.setForeground(new Color (204, 0, 153));
						}else {
							lblNewLabel_2.setText("*Seleccione minimo una unidad");
						}
					}else if((int) spinner.getValue()>Integer.parseInt(lblNumeroStock.getText())) {
						lblNewLabel_2.setText("*No hay suficientes articulos en Stock");
						lblNewLabel_2.setForeground(new Color (204, 0, 153));
					}else {
						String price1 = lblValorPrecio.getText().replace(",", ".");
						double price2 = Double.parseDouble(price1);
						//gdb.añadirCesta(lblNewLabel_1.getText(), comboBox_Tallas.getSelectedItem().toString(), (int) spinner.getValue(), price2);
						lblNewLabel_2.setText("*Compra realizada");
						lblNewLabel_2.setForeground(new Color(0, 0, 204));
						gdb.comprarArticulos(lblNewLabel_1.getText(), comboBox_Tallas.getSelectedItem().toString(), (int) spinner.getValue());
						actualizarTallas();
					}
				} catch (SQLException e1) {
					System.out.println("Fallo con las propiedades del articulo");
					//e1.printStackTrace();
				}
			}else {
				lblNewLabel_2.setText("*Solo los clientes pueden comprar");
			}
		}
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public void actualizarTallas() {
		//Aqui que recoger el numero de tallas.
		//restarlos de la cesta.
		int numero_cesta=0;
		numero_cesta=gdb.devolverCantidadArticuloCesta(lblNewLabel_1.getText(), comboBox_Tallas.getSelectedItem().toString());
		if(!comboBox_Tallas.getSelectedItem().equals("")) {
			try {
				numero_cesta=gdb.stock(nombre_articulo, comboBox_Tallas.getSelectedItem().toString())-numero_cesta;
				if(numero_cesta<0) {
					numero_cesta=0;
				}
				lblNumeroStock.setText(String.valueOf(numero_cesta));
			} catch (SQLException e) {
				System.out.println("Fallo con el numero de articulos en cesta");
				e.printStackTrace();
			}
		}
	}
	protected JLabel getLblTalla() {
		return lblTalla;
	}
	public void calcularPrecio() {
		try {
			entero_descuento = Double.parseDouble(gdb.buscarOfertaArticulo(nombre_articulo));
		}catch (SQLException e1) {
			System.out.println("Fallo al devolver descuento");
			//e1.printStackTrace();
		}
		Double precio_articulo=0.0;
		try {
			precio_articulo = Double.parseDouble(gdb.devolverPrecioVentaDeCategoria(nombre_articulo));
		} catch (SQLException e) {
			System.out.println("Fallo al devolver precio");
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("#.00");
		Double precio=0.0;
		if(!lblValorDescuento.getText().equals("")) {
			precio=( ((100-entero_descuento)/100)*precio_articulo*Double.parseDouble(spinner.getValue().toString()));

		}else {
			precio=precio_articulo*Double.parseDouble(spinner.getValue().toString());
		}
		lblValorPrecio.setText(String.valueOf(df.format(precio)));
	//hacer las cueentas
		
	}
	protected JSpinner getSpinner() {
		return spinner;
	}
	public JLabel getLblEliminar() {
		return lblEliminar;
	}
	public JButton getBtnComprar() {
		return btnComprar;
	}
}
