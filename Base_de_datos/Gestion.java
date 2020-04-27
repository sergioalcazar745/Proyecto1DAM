package Base_de_datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class Gestion  {
	private Connection con;//objeto conexion
	private conexion cx= new conexion();
	private Statement st, st2;//realiza consulta
	private ResultSet resultado, resultado2; //recibe consulta
	private String id;
	ArrayList<String> array_datos=new ArrayList<String>();
	
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
	
	
	public void devolverDatos(String correo) throws SQLException {	
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
				datos.add(resultado.getString("contraseña"));
				datos.add(resultado.getString("telefono"));
				id=(resultado.getString(1));
			}

			String sql2 = "SELECT * FROM cliente WHERE id_persona_aux="+id+"";
			
				try {
					st2=(Statement) con.createStatement();
					resultado2 = st2.executeQuery(sql2);
					//System.out.println("Hola");
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
		
		datos=array_datos;
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
		int confirmar = 0;
		
		con = cx.getConexion();
		String sql = "SELECT * FROM categoria";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
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
	
	public ResultSet buscarAlumno(String correo, String pass) throws SQLException {		
		int confirmar = 0;
		
		con = cx.getConexion();
		String sql = "SELECT * FROM persona WHERE correo='"+correo+"' and contraseña='"+pass+"'";
		
		try {
			st=(Statement) con.createStatement();
			resultado = st.executeQuery(sql);			
		} catch (SQLException e) {
			System.out.println("Fallo al buscar");
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean insertarAlumno(String usuario, String contraseña) throws  SQLException {
		boolean insertado=false;
		String sql="insert into eclipse (usuario,contraseña) values ('"+usuario+"','"+contraseña+"')";
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
