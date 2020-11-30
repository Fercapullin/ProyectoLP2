package utils;
import java.sql.*;
public class Mysqlconexion {

	public static Connection getConexion(){
		Connection cn=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost/colegio",
		 "root","root");
		} catch (Exception e) {
		e.printStackTrace();
		}
		return cn;
		}

	
	
}
