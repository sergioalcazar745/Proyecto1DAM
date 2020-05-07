package Base_de_datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class Gestion  {
	private Connection con;//objeto conexion
	private conexion cx= new conexion();
	private Statement st, st2;//realiza consulta
	private ResultSet resultado, resultado2; //recibe consulta
	private String id;
	ArrayList<String> array_datos=new ArrayList<String>();
	ArrayList<String> array_articulosCesta=new ArrayList<String>();
	boolean sesionIniciada=false;
	
	public boolean getSesionIniciada() {
		return sesionIniciada;
	}
	public void setSesionIniciada(boolean sesion) {
		this.sesionIniciada=sesion;
	}
	public Gestion() {
		
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
	public void aņadirCesta(String nombre) {
		array_articulosCesta.add(nombre);
		//System.out.println("articulo aņadido: "+array_articulosCesta.size());
	}
	public ArrayList<String> getArray_articulosCesta() {
		return array_articulosCesta;
	}
	public void setArray_articulosCesta(ArrayList<String> array_articulosCesta) {
		this.array_articulosCesta = array_articulosCesta;
	}
	public void guardarDatos(String correo) throws SQLException {	
		ArrayList<String> datos=new ArrayList<String>();
		String id = "";
		int confirmar = 0;
		
		con = cx.getConexion();
		//cogemos el id;
		String sql = "SELECT * FROM persona WHERE correo='"+correo+"'";
		
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			
			while(resultado.next()) {
				datos.add(resultado.getString("correo"));
				datos.add(resultado.getString("contraseņa"));
				datos.add(resultado.getString("telefono"));
				id=(resultado.getString(1));
			}

			String sql2 = "SELECT * FROM cliente WHERE id_persona_aux="+id+"";
			
				try {
					st2=(Statement) con.createStatement();
					resultado2 = st2.executeQuery(sql2);
					while(resultado2.next()) {
						datos.add(resultado2.getString("nombre"));
						datos.add(resultado2.getString("apellidos"));
						datos.add(resultado2.getString("fecha_nacimiento"));
					}

					for(String n: datos){
						System.out.println(n);
					}
					
				} catch (SQLException e) {
					System.out.println("Fallo al buscar1");
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar2");
			e.printStackTrace();
		}
		System.out.println("Hola");
	array_datos=datos;
	System.out.println(array_datos.size());
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
				System.out.println("creado");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no creado");
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
			System.out.println("no creado");
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
					System.out.println("no creado");
				}
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no creado");
		}	
		return nombres;
	}

	public void asignarCategoriaArticulo(String nombre_articulo, String nombre_categoria) throws SQLException{		
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
			System.out.println("No creado");
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
			System.out.println("no creado");
		}
	}
	
	public boolean actualizarCampos (String nombre, String apellidos, String fecha_nacimiento, String telefono, String correo, String contraseņa) throws SQLException{
		boolean actualizado = false;
		String id = null;
		
		String sql = "SELECT id_persona FROM persona WHERE correo = '"+correo+"' and contraseņa = '"+contraseņa+"'";
		
		try {
			con = cx.getConexion();
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id = resultado.getString("id_persona");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "UPDATE persona SET correo = '"+correo+"', contraseņa = '"+contraseņa+"', telefono = '"+telefono+"' WHERE correo = '"+correo+"' and contraseņa = '"+contraseņa+"'";
		
		try {
			con = cx.getConexion();
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				id = resultado.getString("id_persona");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql3 = "UPDATE cliente SET nombre = '"+nombre+"', apellidos = '"+apellidos+"', fecha_nacimiento = '"+fecha_nacimiento+"' WHERE id_persona_aux = '"+id+"'";
		
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			int confirmar=st.executeUpdate(sql3);
			if(confirmar ==1) {
				actualizado=true;
				st.close();
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
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
			System.out.println("Fallo al buscar");
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
		
		
		
//		for (String string : nombres) {
//			System.out.println("nombre: "+string);
//		}
		return nombres;
	}
	
	public String devolverPrecioDeCategoria(String nombre) throws SQLException {
		String id_categoria = null, precio = null;
		int numero = 0;
		
		con = cx.getConexion();		
		String sql = "SELECT precio FROM articulogenerico WHERE nombre = '"+nombre+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			if(resultado.next()) {
				precio = resultado.getString("precio");
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
		return descripcion;
	}
	
	public void comprar (String nombre, String talla, String proveedor) {
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------//	
	
	
	public ResultSet buscarAlumno(String correo, String pass) throws SQLException {		
		int confirmar = 0;
		
		con = cx.getConexion();
		String sql = "SELECT * FROM persona WHERE correo='"+correo+"' and contraseņa='"+pass+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean insertarAlumno(String usuario, String contraseņa) throws  SQLException {
		boolean insertado=false;
		String sql="insert into eclipse (usuario,contraseņa) values ('"+usuario+"','"+contraseņa+"')";
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			int confirmar=st.executeUpdate(sql);
			if(confirmar ==1) {
				insertado=true;
				st.close();
				con.close();
				System.out.println("creado");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no creado");
		}
		return insertado;
	}
	
	public boolean buscarAlumno(String usuario) throws  SQLException {
		boolean insertado=false;
		String sql="select usuario from eclipse where usuario='"+usuario+"'";
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			ResultSet numero= st.executeQuery(sql);
			if (!numero.next()) {
				System.out.println("Usuario no encontrado");
			}else {
				System.out.println("Usuario encontrado");
			}
				insertado=true;
				st.close();
				con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}

	public boolean borrarAlumno(String usuario) throws  SQLException {
		boolean insertado=false;
		String sql="delete from eclipse where usuario='"+usuario+"'";
		try {
			con=cx.getConexion();
			st= (Statement) con.createStatement();
			int confirmar=st.executeUpdate(sql);
			if (confirmar==1) {
				System.out.println("Usuario borrado");
			}else {
				System.out.println("Usuario no encontrado");
			}
				insertado=true;
				st.close();
				con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
}
