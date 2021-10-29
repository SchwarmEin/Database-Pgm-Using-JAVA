package data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


import business.Student;


public class RandomIO {
	
	private static String file = "studentFile.dat";
	
	public static int getNumRecords() throws IOException {	
		int numRecs = 0;		
		try(RandomAccessFile dIn = new RandomAccessFile(file,"r")) {		
			//Find number of records in a file
			return (int)dIn.length()/Student.REC_SIZE;
		} catch (FileNotFoundException e) {	
			// no file
			return numRecs;
		}
	}
	
	private static String readChar(RandomAccessFile dIn, int size) throws IOException {		
		StringBuilder strb = new StringBuilder();
		for (int i=0; i < size; i++) {
			char ch = dIn.readChar();
			strb.append(ch);
		}	
		return strb.toString().trim();	
	}
	
	public static Student findFirst() throws IOException {
		try(RandomAccessFile dIn = new RandomAccessFile(file,"r")) {
			//Find number of records in a file
			int numRecs = (int)dIn.length()/Student.REC_SIZE;
			if (numRecs >= 1){
				//the beginning of file pointer
				dIn.seek(0);
				
				// read the data
				int stId = dIn.readInt();
				String program = readChar(dIn, Student.PRGM_SIZE);
				String courses = readChar(dIn, Student.COS_SIZE);
				int semester = dIn.readInt();
				
				// create and return a Person
				Student student = new Student(stId, program, courses, semester);
				return student;
			}
			else
				throw new IOException("There is no record in the data file.");
		}	
	}
	
	public static Student findLast() throws IOException {		
		try(RandomAccessFile dIn = new RandomAccessFile(file,"r")) {			
			//Find number of records in a file
			int numRecs = (int)dIn.length()/Student.REC_SIZE;
			if (numRecs >= 1){
				//find the last record
				dIn.seek((numRecs - 1) * Student.REC_SIZE);	
				// read the data
				int stId = dIn.readInt();
				String program = readChar(dIn, Student.PRGM_SIZE);
				String courses = readChar(dIn, Student.COS_SIZE);
				int semester = dIn.readInt();
				// create and return a Person
				Student student = new Student(stId, program, courses, semester);
				return student;
			}
			else
				throw new IOException("There is no record in the data file.");
		}
		
	}
	
	public static Student findPerviousRec(int recNum) throws IOException {
		try(RandomAccessFile dIn = new RandomAccessFile(file,"r")) {	
			int numRecs = (int) (dIn.length()/Student.REC_SIZE);
			if ((numRecs >= recNum)&&((recNum - 2) >= 0)){
					//find the previous record from the current one
					dIn.seek((recNum - 2) * Student.REC_SIZE);
					// read the data
					int stId = dIn.readInt();
					String program = readChar(dIn, Student.PRGM_SIZE);
					String courses = readChar(dIn, Student.COS_SIZE);
					int semester = dIn.readInt();
					// create and return a Person
					Student pre_rec = new Student(stId, program, courses, semester);
					return pre_rec;	
			}
			else {
				throw new IOException("There is no record in the data file.");
			}
		}
	}
	
	
	public static Student findNextRec(int recNum) throws IOException {
		try(RandomAccessFile dIn = new RandomAccessFile(file,"r")) {	
			int numRecs = (int) (dIn.length()/Student.REC_SIZE);
			if ((numRecs >= recNum)&&((recNum + 1) <= numRecs)){
					//find the previous record from the current one
					dIn.seek((recNum) * Student.REC_SIZE);
					// read the data
					int stId = dIn.readInt();
					String program = readChar(dIn, Student.PRGM_SIZE);
					String courses = readChar(dIn, Student.COS_SIZE);
					int semester = dIn.readInt();
					// create and return a Person
					Student follow_rec = new Student(stId, program, courses, semester);
					return follow_rec;	
			}
			else {
				throw new IOException("There is no record in the data file.");
			}
		}
	}
	
	public static void updateRec(Student student) throws IOException{
		
		int recNum = student.getStID();
		
		try(RandomAccessFile dOut = new RandomAccessFile(file,"rw")) {
			//Find number of records in a file
			int numRecs = (int)dOut.length()/Student.REC_SIZE;
			if (numRecs >= recNum){
				
				dOut.seek((recNum-1) * Student.REC_SIZE);
				
				// read the data
				dOut.writeInt(student.getStID()); 
				dOut.writeChars(student.getProgram());  
				dOut.writeChars(student.getCourse());
				dOut.writeInt(student.getSemester()); 
				
			}
			else
				throw new IOException("There is no record in the data file.");
		}
	}
	
}
