package presentation;

import java.sql.SQLException;

import business.Program;
import data.DataIO;

public class Lab5App {
	
	public static void main(String[] args) {
		try {
			
			// Create Program table
			DataIO dbIO = new DataIO();
			dbIO.createTable();
			System.out.println("\nProgram table has been created...");
			
			// Create and insert 5 records to the table
			Program program1 = new Program("ITC001", "Course 1", 3, 21);
			Program program2 = new Program("ITC002", "Course 2", 3, 22);
			Program program3 = new Program("ITC003", "Course 3", 3, 23);
			Program program4 = new Program("ITC004", "Course 4", 3, 24);
			Program program5 = new Program("ITC005", "Course 5", 3, 0);

			dbIO.insertProgram(program1);
			dbIO.insertProgram(program2);
			dbIO.insertProgram(program3);
			dbIO.insertProgram(program4);
			dbIO.insertProgram(program5);
			
			System.out.println("\n5 programs have been created and inserted into Programs table. Program list below...");
			
			// show programs
			for (Program p : dbIO.getPrograms()) {
				System.out.println(p);
			}
			
			// update a program
			program1.setName("Course 1 UPDATED");
			program1.setCrHrs(0);
			program1.setSeats(0);
			dbIO.updateProgram(program1);
			
			System.out.println("\nA program has been updated (i.e., ITC001). Program list below...");
			
			// show programs
			for (Program p : dbIO.getPrograms()) {
				System.out.println(p);
			}
			
			// delete records with 0 seats (should delete courses 1 and 5)
			dbIO.deleteNoSeats();
			
			System.out.println("\nPrograms with 0 seats have been deleted. Program list below...");
			
			// show programs
			for (Program p : dbIO.getPrograms()) {
				System.out.println(p);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
