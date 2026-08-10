package Student.com.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean InsertStudentToDb(Student st) {
		
		boolean f = false;
		try {
			
			//jdbc code..
			Connection con = CP.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			//Prepared Statement 
			  PreparedStatement pstpmt= con.prepareStatement(q);
			//set the values of parameters
			  pstpmt.setString(1, st.getStudentName());
			  pstpmt.setString(2, st.getStudentPhone());
			  pstpmt.setString(3, st.getStudentCity());
			  
			//execute
			  pstpmt.executeUpdate();
			  f = true;
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
		
	}

	public static boolean deleteStudent(int userId) {
		
		boolean f = false;
		try {
			
			//jdbc code..
			Connection con = CP.createC();
			String q = "delete from students where sid = ?";
			//Prepared Statement 
			  PreparedStatement pstpmt= con.prepareStatement(q);
			//set the values of parameters
			  pstpmt.setInt(1, userId);
			  
			//execute
			  pstpmt.executeUpdate();
			  f = true;
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudents() {
		
		boolean f = false;
		try {
			
			//jdbc code..
			Connection con = CP.createC();
			String q = "select * from students;";
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID : "+ id);
				System.out.println("Name : "+ name);
				System.out.println("Phone : "+ phone);
				System.out.println("City : "+ city);
				
				System.out.println("____________________________");

			}
			
			
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
