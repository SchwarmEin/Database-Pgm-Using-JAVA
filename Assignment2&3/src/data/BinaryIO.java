package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import business.Student;


public class BinaryIO {
	
	private static String file = "studentFile.dat";
	
	public static void writeStudent (Student student) throws IOException {
	 	
		try ( DataOutputStream output = new DataOutputStream(new FileOutputStream(file, true)); ) { 

			// Write student test scores to the file 
			output.writeInt(student.getStID()); 
		    output.writeChars(student.getProgram());  
		    output.writeChars(student.getCourse());
		    output.writeInt(student.getSemester()); 
		    
		} 

	}
	
	/**
	 * 
	 * Reads and returns students that matched the user's selected program
	 * 
	 * @param inputPrgm
	 * @return list of students that matched
	 * @throws IOException
	 */
	
	public static ArrayList<Student> readStudents(String inputPrgm) throws IOException {
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try ( DataInputStream dIn = new DataInputStream(new FileInputStream(file)); ) {	
			while(dIn.available() != 0) {
				int stId = dIn.readInt();
				String program = readChar(dIn, Student.PRGM_SIZE);
				String courses = readChar(dIn, Student.COS_SIZE);
				int semester = dIn.readInt();
				
				if (inputPrgm.equals(program)) {
					Student student = new Student(stId, program, courses, semester);
					studentList.add(student);
				}

			}
		} 
		return studentList;	
	}

	/**
	 * 
	 * Reads and returns students that matched the user's selected program
	 * 
	 * @param inputPrgm
	 * @return list of students that matched
	 * @throws IOException
	 */
	
	public static ArrayList<Student> readALLStudents() throws IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		try ( DataInputStream dIn = new DataInputStream(new FileInputStream(file)); ) {	
			while(dIn.available() != 0) {
				int stId = dIn.readInt();
				String program = readChar(dIn, Student.PRGM_SIZE);
				String courses = readChar(dIn, Student.COS_SIZE);
				int semester = dIn.readInt();
				
				Student student = new Student(stId, program, courses, semester);
				studentList.add(student);
			}
		} 
		return studentList;	
	}
	
	/**
	 * 
	 * Read size characters from dIn
	 * 
	 * @param dIn
	 * @param size
	 * @return string read from dIn
	 * @throws IOException
	 */
	private static String readChar(DataInputStream dIn, int size) throws IOException {
		
		StringBuilder strb = new StringBuilder();
		for (int i=0; i < size; i++) {
			char ch = dIn.readChar();
			strb.append(ch);
		}	
		return strb.toString().trim();	
	}
	
}
