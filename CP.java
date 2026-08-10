package Student.com.manage;

import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;


public class CP {
	
	static java.sql.Connection con;
	
	public static java.sql.Connection createC() {
		try{
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the connection
			String user = "root";
			String password = "shanu12345@@";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			
			con = DriverManager.getConnection(url, user, password);
			

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return con;
	}

}
