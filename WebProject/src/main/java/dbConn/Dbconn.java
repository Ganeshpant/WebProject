package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconn {
	public static Connection getconn() {

		Connection con = null;
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb","root","");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return con;

	}

}
