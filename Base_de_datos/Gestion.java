package Base_de_datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class Gestion {
	private Connection con;//objeto conexion
	private conexion conn= new conexion();
	private Statement st;//realiza consulta
	private ResultSet resultado; //recibe consulta
	
	public boolean insertarAlumno(String usuario, String contraseña) throws  SQLException {
		boolean insertado=false;
		String sql="insert into eclipse (usuario,contraseña) values ('"+usuario+"','"+contraseña+"')";
		try {
			con=conn.getConexion();
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
			con=conn.getConexion();
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
			con=conn.getConexion();
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
