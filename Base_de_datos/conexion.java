package Base_de_datos;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class conexion {
	private Connection conn;
	public  Connection getConexion() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mundial";
			String usuario="jorge";
			String contraseña="Smr";
			conn = (Connection) DriverManager.getConnection(url, usuario,contraseña);
		}catch (ClassNotFoundException e){
			System.out.println("no encuentra el controlador");
			e.getStackTrace();
		}catch (SQLException e) {
			e.getStackTrace();
		}
		return conn;
	}
}
