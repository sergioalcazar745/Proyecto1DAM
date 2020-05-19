package Base_de_datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Clases.Articulos;



public class Gestion  {
	private Connection con;//objeto conexion
	private conexion cx= new conexion();
	private Statement st, st2, st3, st4, stid, st5;//realiza consulta
	private ResultSet resultado, resultado2, resultado3, resultado4, resultado5; //recibe consulta
	private String id, id_admin;
	ArrayList<String> array_datos=new ArrayList<String>();
	ArrayList<Articulos> array_articulosCesta=new ArrayList<Articulos>();
	boolean sesionIniciada=false;
	boolean cliente = false;
	String dinero_disponible;

	public String getDinero_disponible() {
		return dinero_disponible;
	}
	public void setDinero_disponible(String dinero_disponible) {
		this.dinero_disponible = dinero_disponible;
	}
	public boolean getCliente() {
		return cliente;
	}
	public void setCliente(boolean cliente) {
		this.cliente=cliente;
	}
	public String getId_admin() {
		return id_admin;
	}
	public void setId_admin(String id_admin) {
		this.id_admin = id_admin;
	}	
	public boolean getSesionIniciada() {
		return sesionIniciada;
	}
	public void setSesionIniciada(boolean sesion) {
		if(sesion==false) {
			array_articulosCesta.clear();
		}
		this.sesionIniciada=sesion;
	}
	public Gestion() {
		
	}
	public void vaciarArray_articulosCesta(){
		array_articulosCesta.clear();
	}
	public ResultSet comprobarSesion(String correo) throws SQLException {		
		int confirmar = 0;
		
		con = cx.getConexion();
		String sql = "SELECT * FROM persona WHERE correo='"+correo+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean comprobarTipoPersona (String id_persona) throws SQLException {
		con = cx.getConexion();
		String sql = "SELECT * FROM administrador WHERE id_persona_aux='"+id_persona+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(!resultado.next()) {
				setCliente(true);
			}else {
				setId_admin(resultado.getString("id_admin"));
				setCliente(false);
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		return cliente;
	}
	
	public void añadirCesta(String nombre, String talla, int cantidad, double precio) {
		boolean existe = false;
		for (Articulos articulos : array_articulosCesta) {
			if(nombre.equals(articulos.getNombre()) && articulos.getTalla().equals(talla)) {
				existe = true;
				articulos.setCantidad(cantidad);
				articulos.setPrecio(precio);
			}
		}

		if(existe == false) {
			array_articulosCesta.add(new Articulos(nombre, talla, cantidad, precio));
		}
	}
	public void eliminarCesta(String nombre_buscar, String talla) {
		Articulos nombre_eliminar;
		Iterator<Articulos> it = array_articulosCesta.iterator(); 
			while(it.hasNext()) {	
				 nombre_eliminar= it.next();
				if (nombre_buscar.equals(nombre_eliminar.getNombre()) && talla.equals(nombre_eliminar.getTalla())) {				 
					it.remove();
				}
			}
	}
	public ArrayList<Articulos> getArray_articulosCesta() {
		return array_articulosCesta;
	}
	public void setArray_articulosCesta(ArrayList<Articulos> array_articulosCesta) {
		this.array_articulosCesta = array_articulosCesta;
	}
	public void guardarDatos(String correo) throws SQLException {
		ArrayList<String> datos=new ArrayList<String>();
		String id = null;
		int confirmar = 0;
	
		con = cx.getConexion();
		//cogemos el id;
		if(getCliente() == true) {
		String sql = "SELECT * FROM persona WHERE correo='"+correo+"'";		
			try {
				st=(Statement) con.createStatement();
				resultado = st.executeQuery(sql);
				
				while(resultado.next()) {
					datos.add(resultado.getString("correo"));
					datos.add(resultado.getString("contraseña"));
					datos.add(resultado.getString("telefono"));
					id=(resultado.getString(1));
				}
				String sql2 = "SELECT * FROM cliente WHERE id_persona_aux='"+id+"'";
				
					try {
						st2=(Statement) con.createStatement();
						resultado2 = st2.executeQuery(sql2);
						while(resultado2.next()) {
							datos.add(resultado2.getString("nombre"));
							datos.add(resultado2.getString("apellidos"));
							datos.add(resultado2.getString("fecha_nacimiento"));
						}
						
					} catch (SQLException e) {
						System.out.println("Fallo al buscar");
						e.printStackTrace();
					}
				
			} catch (SQLException e) {
				System.out.println("Fallo al buscar");
				e.printStackTrace();
			}	
		}
				
		array_datos=datos;
	}
	public ArrayList getDatos() {
		return array_datos;
	}
	public ResultSet comprobarCliente(String id) throws SQLException {		
		int confirmar = 0;
		
		con = cx.getConexion();
		
		String sql = "SELECT * FROM cliente WHERE id_cliente='"+id+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	protected Gestion(ArrayList<String> array_datos) {
		super();
		this.array_datos = array_datos;
	}
	public ResultSet recorrerCategorias() throws SQLException {				
		
		String sql = "SELECT * FROM categoria";
		
		try {
			con = cx.getConexion();
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public void eliminarCategorias(String nombre) throws SQLException {				
		String id_categoria = null;
		
		String sql = "SELECT id_categoria FROM categoria WHERE nombre = '"+nombre+"'";
		
		try {
			con = cx.getConexion();
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_categoria = resultado.getString("id_categoria");
			}						
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		String sql2 = "DELETE FROM categoria WHERE id_categoria='"+id_categoria+"'";
		
		try {
			con = cx.getConexion();
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql2);
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		String sql3 = "DELETE FROM pertenece WHERE id_categoria_aux='"+id_categoria+"'";

		try {
			con = cx.getConexion();
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql3);
			if(confirmar > 0) {
				JOptionPane.showMessageDialog(null, "Categoria eliminada");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
	}
	
	public ResultSet recorrerArticuloGenerico() throws SQLException {		
		int confirmar = 0;
		
		con = cx.getConexion();
		String sql = "SELECT * FROM articulogenerico";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public ArrayList recorrerArticuloGenericoString() throws SQLException {		
		ArrayList<String> nombres=new ArrayList<String>();
		
		con = cx.getConexion();
		String sql = "SELECT * FROM articulogenerico";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);	
			while(resultado.next()) {
				nombres.add(resultado.getString("nombre"));
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return nombres;
	}
	public boolean insertarCategoria(String nombre) {
		boolean insertado = false;
		String sql="INSERT INTO categoria (nombre) VALUES ('"+nombre+"')";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			int confirmar=st.executeUpdate(sql);
			if(confirmar ==1) {
				insertado=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("no creado");
		}
		return insertado;
	}
	
	public ArrayList<String> asociacionCategoria(String name) {
		boolean insertado = false;
		String sql="SELECT id_generico FROM articulogenerico WHERE nombre = '"+name+"'";
		String id_generico = null, id_categoria = null;
		ArrayList <String> nombres = new ArrayList <String>();
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while(resultado.next()) {
				id_generico = resultado.getString("id_generico");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("no creado");
		}
		
		String sql2="SELECT id_categoria_aux FROM pertenece where id_articulogenerico_aux='"+id_generico+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			resultado = st.executeQuery(sql2);
			while(resultado.next()) {
				id_categoria = resultado.getString("id_categoria_aux");
				
				String sql3 = "SELECT nombre FROM categoria WHERE id_categoria = '"+id_categoria+"'";
				
				try {
					st2= (Statement) con.createStatement();
					resultado2 = st2.executeQuery(sql3);
					
					if(resultado2.next()) {
						nombres.add(resultado2.getString("nombre"));
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
					//System.out.println("no creado");
				}
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("no creado");
		}	
		return nombres;
	}

	public void asignarCategoriaArticulo(String nombre_articulo, String nombre_categoria) throws SQLException{		
		boolean insertado = false;
		String id_generico = null, id_categoria = null;
		
		String sql = "SELECT id_generico FROM articulogenerico WHERE nombre = '"+nombre_articulo+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_generico = resultado.getString("id_generico");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("No creado");
		}
		
		String sql2 = "SELECT id_categoria FROM categoria WHERE nombre = '"+nombre_categoria+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			resultado = st.executeQuery(sql2);
			if(resultado.next()) {
				id_categoria = resultado.getString("id_categoria");
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String buscar = "SELECT * FROM pertenece WHERE id_articulogenerico_aux='"+id_generico+"' and id_categoria_aux='"+id_categoria+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();			
			resultado2 = st.executeQuery(buscar);
			if(resultado2.next()) {
				JOptionPane.showMessageDialog(null, "Ya esta asignada");
			}else {
				
				String sql3 = "INSERT INTO pertenece (id_articulogenerico_aux, id_categoria_aux) values('"+id_generico+"', '"+id_categoria+"')";
				try {
					st2= (Statement) con.createStatement();
					st2.executeUpdate(sql3);
					JOptionPane.showMessageDialog(null, "Insertado");
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("no creado");
		}
	}
	
	public void eliminarArticuloCategoria(String nombre_articulo, String nombre_categoria) throws SQLException{		
		boolean insertado = true;
		String id_generico = null, id_categoria = null;
		String sql = "SELECT id_generico FROM articulogenerico WHERE nombre = '"+nombre_articulo+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_generico = resultado.getString("id_generico");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("No creado");
		}
		
		String sql2 = "SELECT id_categoria FROM categoria WHERE nombre = '"+nombre_categoria+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			resultado = st.executeQuery(sql2);
			if(resultado.next()) {
				id_categoria = resultado.getString("id_categoria");
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		String sql3 = "DELETE FROM pertenece WHERE id_articulogenerico_aux = '"+id_generico+"' and id_categoria_aux = '"+id_categoria+"'";
		try {
			st= (Statement) con.createStatement();
			st.executeUpdate(sql3);
			JOptionPane.showMessageDialog(null, "Eliminado");
		}catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public boolean actualizarCampos (String nombre, String apellidos, String fecha_nacimiento, String telefono, String correo, String contraseña) throws SQLException{
		boolean actualizado = false;
		String id = null;

		String sql = "SELECT id_persona FROM persona WHERE correo = '"+getDatos().get(0)+"'";
		
		try {
			con = cx.getConexion();
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id = resultado.getString("id_persona");
//				if(resultado.getString("correo").equals(correo) && resultado.getString("contraseña").equals(contraseña) && resultado.getString("telefono").equals(telefono)) {
//					
//				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "UPDATE persona SET correo = '"+correo+"', contraseña = '"+contraseña+"', telefono = '"+Integer.parseInt(telefono)+"' WHERE id_persona = '"+id+"'";
		
		try {
			con = cx.getConexion();
			st = (Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql2);
			if(confirmar == 1) {
				actualizado=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql3 = "UPDATE cliente SET nombre = '"+nombre+"', apellidos = '"+apellidos+"', fecha_nacimiento = '"+fecha_nacimiento+"' WHERE id_persona_aux = '"+id+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			st.executeUpdate(sql3);	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		guardarDatos(correo);
		return actualizado;
	}
	
	public ArrayList<String> devolverArticulosDeCategoria(String nombre) throws SQLException {
		ArrayList<String> nombres= new ArrayList<String>();
		String id_categoria = null;
		int numero = 0;
		
		con = cx.getConexion();
		String sql = "SELECT id_categoria FROM categoria WHERE nombre = '"+nombre+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_categoria = resultado.getString("id_categoria");
			}
		} catch (SQLException e) {
			//System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
	sql = "SELECT id_articulogenerico_aux FROM pertenece WHERE id_categoria_aux = '"+id_categoria+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while(resultado.next()) {
				String nombre_aux=resultado.getString("id_articulogenerico_aux");
				String sql2 = "SELECT nombre FROM articulogenerico WHERE id_generico= '"+nombre_aux+"'";
				
				try {
					st2=(Statement) con.createStatement();
					resultado2 = st2.executeQuery(sql2);
					while(resultado2.next()) {
						nombres.add(resultado2.getString("nombre"));
					}
				} catch (SQLException e) {
					System.out.println("Fallo al buscar");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}

		return nombres;
	}
	
	public String devolverPrecioVentaDeCategoria(String nombre) throws SQLException {
		String id_categoria = null, precio = null;
		int numero = 0;
		
		con = cx.getConexion();		
		String sql = "SELECT precio_venta FROM articulogenerico WHERE nombre = '"+nombre+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				precio = resultado.getString("precio_venta");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return precio;
	}
	
	public String devolverPrecioDeCategoria(String nombre) throws SQLException {
		String id_categoria = null, precio = null;
		int numero = 0;
		
		con = cx.getConexion();		
		String sql = "SELECT precio_compra FROM articulogenerico WHERE nombre = '"+nombre+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				precio = resultado.getString("precio_compra");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return precio;
	}
	
	public ArrayList<String> recorrerProveedores() throws SQLException {		
		ArrayList<String> nombres=new ArrayList<String>();
		
		con = cx.getConexion();
		String sql = "SELECT * FROM proveedor";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);	
			while(resultado.next()) {
				nombres.add(resultado.getString("nombre"));
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return nombres;
	}
	
	public String devolverDescripcion(String nombre) throws SQLException {
		String descripcion = null;
		
		String sql = "SELECT descripcion FROM articulogenerico WHERE nombre = '"+nombre+"'";
		
		con = cx.getConexion();
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);	
			if(resultado.next()) {
				descripcion = resultado.getString("descripcion");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		String descripcion_aux="";
		int salto_linea=0;
		for(int i=0; i<descripcion.length(); i++) {
			descripcion_aux+=descripcion.charAt(i);
			salto_linea++;
			if(salto_linea==42) {
				descripcion_aux+="\n";
				salto_linea=0;
			}
		}
		descripcion=descripcion_aux;
		return descripcion;
	}
	
	public int stock (String nombre, String talla) throws SQLException {
		int numero=0;
		String id_articulo = "";
		con = cx.getConexion();		
		String sql = "SELECT talla FROM articulos inner join articulogenerico on articulos.id_articulogenerico_aux=articulogenerico.id_generico WHERE nombre='"+nombre+"' and talla='"+talla+"' and Disponible=1";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.last()) {
				numero = resultado.getRow();
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		return numero;
	}
	
	public int devolverCantidadArticuloCesta(String nombre, String talla) {
		int cantidad=0;
			for (Articulos art : array_articulosCesta) {
				if(nombre.equals(art.getNombre()) && talla.equals(art.getTalla())) {
					cantidad=art.getCantidad();
				}
			}
		return cantidad;
	}
	
	public void comprarSuministros(String nombre, String talla, String proveedor, double precio_total, int cantidad) throws SQLException {
		//se debe buscar el id del articulo_generico con el nombre.
		String id_articulo = "", id_proveedor = "", sql ="";
		con = cx.getConexion();		

		sql = "SELECT id_generico FROM articulogenerico WHERE nombre='"+nombre+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_articulo = resultado.getString("id_generico");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		sql = "SELECT id_proveedor FROM proveedor WHERE nombre = '"+proveedor+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_proveedor = resultado.getString("id_proveedor");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		sql = "SELECT id_proveedor FROM proveedor WHERE nombre = '"+proveedor+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_proveedor = resultado.getString("id_proveedor");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		Calendar fecha = Calendar.getInstance();
		String mes,dia, año;
		mes=String.valueOf(fecha.get(Calendar.MONTH)+1);
		dia=String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		año=String.valueOf(fecha.get(Calendar.YEAR));
		String fecha_final=dia+"-"+mes+"-"+año;
		
		sql = "INSERT INTO suministra (id_articulo_aux, id_admin_aux, id_proveedor_aux, precio_total, cantidad, fecha) VALUES ('"+id_articulo+"',  '"+getId_admin()+"', '"+id_proveedor+"', '"+precio_total+"', '"+cantidad+"', '"+fecha_final+"')";

		try {
			st=(Statement) con.createStatement();
			st.executeUpdate(sql);
			crearArticulos(nombre, talla, cantidad);
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
	}
	
	public boolean crearOfertas (String articulo, String categoria, String valor) throws SQLException {
		boolean oferta = false, existe = false;
		int num = 0;
		String id_oferta = null, id_categoria = null, id_articulo = null;
		con = cx.getConexion();
		
		String sql = "SELECT * FROM oferta";		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while(resultado.next()) {
				if(Integer.parseInt(resultado.getString("descuento")) == Integer.parseInt(valor)) {
					id_oferta=resultado.getString("id_oferta");
					existe = true;
				}
			}
			
			if(existe == false) {
				String sql2 = "INSERT INTO oferta (descuento) values ('"+valor+"')";
				try {
					st2=(Statement) con.createStatement();
					st2.executeUpdate(sql2);
					resultado2 = st2.executeQuery(sql);
					while(resultado2.next()) {
						id_oferta = resultado2.getString("id_oferta");
						num ++;
					}
				} catch (SQLException e) {
					System.out.println("Fallo al buscar1");
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar2");
		}

		//Obtener id de los articulos
		if(articulo.equals("")) {
			//Tenemos que comprobar que el descuento existe y si es asi se reutiliza la id. Si es una categoria hay que sacar todo los id_articulo.			
			String sql4 = "SELECT id_categoria FROM categoria WHERE nombre = '"+categoria+"'";
			try {
				st=(Statement) con.createStatement();
				resultado = st.executeQuery(sql4);
				if(resultado.next()) {
					id_categoria = resultado.getString("id_categoria");
				}
			} catch (SQLException e) {
				System.out.println("Fallo al buscar3");
				e.printStackTrace();
			}
			
			String sql3 = "SELECT id_articulogenerico_aux FROM pertenece WHERE id_categoria_aux = '"+id_categoria+"'";
			try {
				st=(Statement) con.createStatement();
				 resultado = st.executeQuery(sql3);
				 while (resultado.next()) {
					id_articulo = resultado.getString("id_articulogenerico_aux");
					String sql2 = "UPDATE articulogenerico SET id_oferta_aux = '"+id_oferta+"' WHERE id_generico = '"+id_articulo+"'";
						try {
							st2=(Statement) con.createStatement();
							st2.executeUpdate(sql2);
						} catch (SQLException e) {
							System.out.println("Fallo al buscar4");
							e.printStackTrace();
						}									
				 }
			
			} catch (SQLException e) {
				System.out.println("Fallo al buscar5");
				e.printStackTrace();
			}
		}else {
			
			String sql3 = "UPDATE articulogenerico SET id_oferta_aux = '"+id_oferta+"' WHERE nombre = '"+articulo+"'";
			try {
				st=(Statement) con.createStatement();
				st.executeUpdate(sql3);
			} catch (SQLException e) {
				System.out.println("Fallo al buscar6");
				e.printStackTrace();
			}
		}
	
		return oferta;
	}
	
	public ArrayList<String> recorrerOferta() throws SQLException {
		String id_oferta;
		ArrayList<String> ofertas = new ArrayList<String>();
		
		con = cx.getConexion();
		String sql = "SELECT * FROM oferta";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while(resultado.next()) {
				id_oferta = resultado.getString("id_oferta");
				String sql2 = "SELECT nombre FROM articulogenerico WHERE id_oferta_aux = '"+id_oferta+"'";
				
				try {
					st2=(Statement) con.createStatement();
					resultado2 = st2.executeQuery(sql2);
					while(resultado2.next()) {
						if(!resultado.getString("descuento").equals("0.000")) {
							ofertas.add(resultado2.getString("nombre"));
							ofertas.add(resultado.getString("descuento"));
						}						
					}
				} catch (SQLException e) {
					System.out.println("Fallo al buscar");
				}
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
		}
		return ofertas;
	}
	
	public String buscarOfertaArticulo(String nombre) throws SQLException {
		String id_oferta = "", descuento = "";
		con = cx.getConexion();		
		String sql = "SELECT id_oferta_aux FROM articulogenerico WHERE nombre = '"+nombre+"'";
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_oferta = resultado.getString("id_oferta_aux");
			}
			String sql2 = "SELECT descuento FROM oferta WHERE id_oferta = '"+id_oferta+"'";
			try {
				st2=(Statement) con.createStatement();
				resultado2=st2.executeQuery(sql2);
				if(resultado2.next()) {
					if(!resultado2.getString("descuento").equals("0.000")) {
						descuento = resultado2.getString("descuento");
					}
				}
			} catch (SQLException e) {
				System.out.println("Fallo al buscar");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		return descuento;
	}
	
	public String buscarIdOfertaArticulo(String nombre) throws SQLException {
		String id_oferta = "";
		con = cx.getConexion();		
		String sql = "SELECT id_oferta_aux FROM articulogenerico WHERE nombre = '"+nombre+"'";
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id_oferta = resultado.getString("id_oferta_aux");
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		return id_oferta;
	}
	
	public void comprarArticulos(String nombre, String talla, int cantidad) throws SQLException {
		String id_oferta="";
		String id_cliente="", id_persona="", fecha_final;
		Calendar fecha = Calendar.getInstance();
		String mes,dia, año;
		String id_articulo = "", id_generico = null;
		String precio="";
		Double descuento=0.0;
		con = cx.getConexion();		

		mes=String.valueOf(fecha.get(Calendar.MONTH)+1);
		dia=String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		año=String.valueOf(fecha.get(Calendar.YEAR));
		fecha_final=dia+"-"+mes+"-"+año;
		
		String sql = "SELECT id_generico FROM articulogenerico WHERE nombre='"+nombre+"'";//sacamos el id generico y lo buscamos en la siguiente consulta con el id y talla;
		
		try {
			st=(Statement) con.createStatement();
			st4=(Statement) con.createStatement();
			st3=(Statement) con.createStatement();
			st2=(Statement) con.createStatement();
			st5=(Statement) con.createStatement();
			resultado=st.executeQuery(sql);
			if(resultado.next()) {
				id_generico=resultado.getString("id_generico");
			}
			
			sql = "SELECT id_cliente FROM cliente inner join persona on persona.id_persona=cliente.id_persona_aux WHERE correo='"+array_datos.get(0)+"'";
			st=(Statement) con.createStatement();
			resultado=st.executeQuery(sql);
			if(resultado.next()) {
				id_cliente=resultado.getString("id_cliente");
			}
			
			
//			sql = "SELECT precio_venta FROM articulogenerico WHERE id_generico='"+id_generico+"'";
//			st=(Statement) con.createStatement();
//			resultado=st.executeQuery(sql);
//			if(resultado.next()) {
//				precio=resultado.getString("precio_venta");
//			}
			
			sql = "SELECT id_oferta_aux FROM articulogenerico WHERE id_generico='"+id_generico+"'";
			st=(Statement) con.createStatement();
			resultado=st.executeQuery(sql);
			if(resultado.next()) {
				id_oferta=resultado.getString("id_oferta_aux");
			}
			
			
			sql = "SELECT * FROM oferta WHERE id_oferta='"+id_oferta+"'";
			//System.out.println("id_oferta: "+id_oferta);
			st3=(Statement) con.createStatement();
			resultado3=st.executeQuery(sql);
			if(resultado3.next()) {
				precio=devolverPrecioVentaDeCategoria(nombre);
				descuento=Double.parseDouble(resultado3.getString("descuento"));
				//System.out.println("descuento: "+descuento);
				//System.out.println("precio: "+precio);
				if(descuento!=0) {
					descuento=(100-descuento)/100;
					precio=String.valueOf( descuento*Double.parseDouble(precio) );
				}
			}
			
			
			
			
			sql = "SELECT id_articulo FROM articulos WHERE id_articulogenerico_aux='"+id_generico+"' and talla='"+talla+"' and Disponible=1";
			st=(Statement) con.createStatement();
			resultado=st.executeQuery(sql);
			//System.out.println("cantidad: "+cantidad);
			while(resultado.next() && cantidad>0){
				id_articulo=resultado.getString("id_articulo");
				sql = "UPDATE articulos SET Disponible=0 WHERE id_articulo='"+id_articulo+"'";
				st2.executeUpdate(sql);
				cantidad--;
				
				sql = "INSERT INTO `compra`(`id_articulo_aux`, `id_oferta_aux`, `id_cliente_aux`, `precio`, `fecha`) VALUES ('"+id_articulo+"','"+id_oferta+"','"+id_cliente+"','"+precio+"','"+fecha_final+"')";
				st3.executeUpdate(sql);
			}

		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}	
	}
	
	public boolean finalizarCompra() {
		boolean correcto=false;
		for (Articulos art : array_articulosCesta) {
			try {
				comprarArticulos(art.getNombre(), art.getTalla(), art.getCantidad());
				correcto=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return correcto;
	}
	public String devolverPrecioCesta() {
		double a=0;
		double precio=0;
		for (Articulos art : array_articulosCesta) {
			precio += art.getPrecio();
		}		
		return String.valueOf(precio);
	}
	public double dineroDisponible() throws SQLException {
		Double dinero=0.0;
		con = cx.getConexion();
		String sql2 = "SELECT cantidad FROM capital";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql2);
			if(resultado.next()) {
				dinero=Double.parseDouble(resultado.getString("cantidad"));
			}
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		return dinero;
	}
	
	public void crearArticulos(String nombre, String talla, int cantidad) throws SQLException {
		//se debe buscar el id del articulo_generico con el nombre.
        String id_articulo = "";
        con = cx.getConexion();

        String sql = "SELECT id_generico FROM articulogenerico WHERE nombre='"+nombre+"'";

        try {
            st=(Statement) con.createStatement();
            resultado = st.executeQuery(sql);
            if(resultado.next()) {
                id_articulo = resultado.getString("id_generico");
            }

            String insertar = "INSERT INTO articulos(talla, id_articulogenerico_aux) VALUES ('"+talla+"','"+id_articulo+"')";
            for(int i=0; i< cantidad; i++) {
                st.executeUpdate(insertar);
            }
        } catch (SQLException e) {
            System.out.println("Fallo al buscar");
            e.printStackTrace();
        }
	}
	
	public ArrayList <String> devolverCompra() {
		ArrayList<String> compra = new ArrayList<String>();
		String id_persona = null, id_cliente = null, id_articulo = null, nombre = null;
		
		String sql = "SELECT id_cliente FROM persona inner join cliente on persona.id_persona=cliente.id_persona_aux WHERE persona.correo='"+getDatos().get(0)+"';";

        try {
            st=(Statement) con.createStatement();
            resultado = st.executeQuery(sql);            
            if(resultado.next()) {
            	id_cliente = resultado.getString("id_cliente");
            }
        } catch (SQLException e) {
            System.out.println("Fallo al buscar");
            e.printStackTrace();
        }
         
        sql = "SELECT * FROM compra WHERE id_cliente_aux='"+id_cliente+"'";
        String sql2 = "SELECT articulogenerico.nombre, articulos.talla FROM articulogenerico INNER JOIN articulos on articulogenerico.id_generico=articulos.id_articulogenerico_aux inner join compra on articulos.id_articulo=id_articulo_aux WHERE id_cliente_aux=1"; 
        
        try {
            st=(Statement) con.createStatement();
            resultado = st.executeQuery(sql);   
            resultado2 = st2.executeQuery(sql2); 
            while(resultado.next()) {
                 try {
                     st2=(Statement) con.createStatement();           
                     if(resultado2.next()) {
                     	compra.add(resultado2.getString("nombre"));
                     	compra.add(resultado2.getString("talla"));
                     	compra.add(resultado.getString("fecha"));
                     	compra.add(resultado.getString("precio"));
                     }
                 } catch (SQLException e) {
                     System.out.println("Fallo al buscar");
                     e.printStackTrace();
                 }
            }            
        } catch (SQLException e) {
            System.out.println("Fallo al buscar");
            e.printStackTrace();
        }
		return compra;
 	}
	
	public ArrayList <String> devolverSuministro(){
		ArrayList<String> suministro = new ArrayList<String>();
		String id_persona = null, id_cliente = null, id_articulo = null, nombre = null, sql = null;

        sql = "SELECT * FROM suministra WHERE id_admin_aux='"+getId_admin()+"'";
        String sql2 = "SELECT articulogenerico.nombre, articulos.talla FROM articulogenerico INNER JOIN articulos on articulogenerico.id_generico=articulos.id_articulogenerico_aux inner join suministra on articulos.id_articulo=id_articulo_aux WHERE id_admin_aux='"+getId_admin()+"'"; 
        
        try {
            st=(Statement) con.createStatement();
            resultado = st.executeQuery(sql); 
            st2=(Statement) con.createStatement(); 
            resultado2 = st2.executeQuery(sql2); 
            while(resultado.next()) {
                 try {          
                     if(resultado2.next()) {
                    	 suministro.add(resultado2.getString("nombre"));
                    	 suministro.add(resultado2.getString("talla"));
                    	 suministro.add(resultado.getString("fecha"));
                    	 suministro.add(resultado.getString("cantidad"));
                    	 suministro.add(resultado.getString("precio_total"));
                     }
                 } catch (SQLException e) {
                     System.out.println("Fallo al buscar");
                     e.printStackTrace();
                 }
            }            
        } catch (SQLException e) {
            System.out.println("Fallo al buscar");
            e.printStackTrace();
        }
		return suministro;
	}
	
	public boolean devolverCorreo(String correo) {
		boolean resultadoFinal=true;
				
			String sql = "SELECT correo FROM persona";
	
	        try {
	            st=(Statement) con.createStatement();
	            resultado = st.executeQuery(sql);            
	            while(resultado.next()) {
	            	if(correo.equals(resultado.getString("correo"))) {
	            		resultadoFinal=false;
	            	}
	            }
	        } catch (SQLException e) {
	            System.out.println("Fallo al buscar");
	            e.printStackTrace();
	        }	        
		return resultadoFinal;
	}
	
	public ArrayList <String> devolverStock() {
		String nombre="";
		String cantidad="";
		ArrayList<String> tallas = new ArrayList<String>();
		tallas.add("S");
		tallas.add("M");
		tallas.add("L");
		tallas.add("XL");
		tallas.add("XXL");
		tallas.add("XXXL");
		ArrayList<String> datos_articulos = new ArrayList<String>();
		ArrayList<String> stock = new ArrayList<String>();
		
		String sql = "SELECT * from articulogenerico";

        try {
            st=(Statement) con.createStatement();
            resultado = st.executeQuery(sql);            
            while(resultado.next()) {
            	datos_articulos.add(resultado.getString("id_generico"));
            }
        } catch (SQLException e) {
            System.out.println("Fallo al buscar");
            e.printStackTrace();
        }
		
        
        for (String talla: tallas) {
        	for(String id: datos_articulos) {
	        	sql = "SELECT * from articulos WHERE id_articulogenerico_aux='"+id+"' and Disponible='"+1+"' and  talla='"+talla+"'";
	
	            try {
	                st=(Statement) con.createStatement();
	                resultado = st.executeQuery(sql);
	                resultado.last();
	                cantidad=String.valueOf(resultado.getRow());
	            } catch (SQLException e) {
	                System.out.println("Fallo al buscar");
	            }
	            
	            sql = "SELECT nombre from articulogenerico WHERE id_generico='"+id+"'";
	            try {
	                st=(Statement) con.createStatement();
	                resultado = st.executeQuery(sql);
	                resultado.next();
	                nombre=resultado.getString("nombre");
	            } catch (SQLException e) {
	                System.out.println("Fallo al buscar");
	            }
	            
	            stock.add(nombre);
	            stock.add(cantidad);
	            stock.add(talla);
        	}
              
		}
		return stock;
	}
	
	public void borrar() {
	ArrayList<String> tallas = new ArrayList<String>();
	tallas.add("S");
	tallas.add("M");
	tallas.add("L");
	tallas.add("XL");
	tallas.add("XXL");
	tallas.add("XXXL");
	ArrayList<String> ids = new ArrayList<String>();
	
       String sql = "SELECT id_generico FROM articulogenerico";
        try {
            st=(Statement) con.createStatement();
            resultado = st.executeQuery(sql);
            while(resultado.next()) {
            	ids.add(resultado.getString("id_generico"));
            }
        } catch (SQLException e) {
            System.out.println("Fallo al buscar1234");
        }
        
        for (String t : tallas) {
        	for (String n : ids) {
        		sql = "INSERT INTO articulos (talla, id_articulogenerico_aux, disponible) VALUES ('"+t+"', '"+n+"', '1')";
                try {
                    st=(Statement) con.createStatement();
                    st.executeUpdate(sql);
                } catch (SQLException e) {
                    System.out.println("Fallo al buscarStocks");
                }
			}        	
		}      
	}
}
