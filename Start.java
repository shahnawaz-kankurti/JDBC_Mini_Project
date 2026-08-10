package Student;

import java.util.Scanner;

import Student.com.manage.Student;
import Student.com.manage.StudentDao;

public class Start {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Student Management App");
		
		while (true) 
		{
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to EXIT APP");
			
			int choice = sc.nextInt();
			sc.nextLine();			
			if(choice == 1) {
				System.out.println("Enter User name:");
				String name = sc.nextLine();
								
				System.out.println("Enter User StudentPhone:");
				String phone = sc.nextLine();
				
				System.out.println("Enter User City:");
				String city = sc.nextLine();
				
				//create student object to tore student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.InsertStudentToDb(st);
				if(answer) {
					System.out.println("Student Added successfully!!!");
				}else
					System.out.println("Something went Wrong!!!");
				System.out.println(st);



			}
			else if(choice == 2) {
				//delete Student
				System.out.println("Enter Student Id to Delete : ");
				int userId = sc.nextInt();
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Deleted Successfully!!!");
				}else {
					System.out.println("Something went wrong!!!");
				}
			}
			else if(choice == 3) {
				//Display Student
				StudentDao.showAllStudents();
			}
			else if(choice == 4) {
				break;
			}else {
				
			}
		}
		System.out.println("Thank you for using my Application.");
	}
}
