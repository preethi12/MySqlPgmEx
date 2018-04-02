package mysql.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "12345");
		} catch (Exception e) {
			System.out.println(e);
		}

		
	}
	public static Connection getCon() {
		return con;
	}
	public static void setCon(Connection con) {
		DatabaseConnection.con = con;
	}
	
}