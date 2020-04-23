package Base_de_datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class GestionBD {
	private Conexion conexion=new Conexion();
	private Connection con;
	private Statement st;
	private ResultSet resultado;
}