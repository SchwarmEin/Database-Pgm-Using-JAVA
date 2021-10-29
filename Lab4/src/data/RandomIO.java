package data;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import business.Person;

public class RandomIO {
	
	private static File myFile = new File("personFile.dat");
	
	
	public static void writePerson (Person person) throws IOException {
	 	
		
		
		try(RandomAccessFile dOut = new RandomAccessFile(myFile,"rw")){
			
			dOut.seek(dOut.length());
			//dOut.seek(Person.REC_SIZE * (recordNumber-1));
			
			// not padding, because all the data I get here should be fixed size already

			dOut.writeChars(person.getFirstName()+person.getLastName()+person.getPhone());
			dOut.writeInt(person.getAge());
	
		}	
	}
	
	public static Person findRecordNumber(int recordNumber) throws IOException {
		
		try(RandomAccessFile dIn = new RandomAccessFile(myFile,"r")) {
			
			//Find number of records in a file
			int numRecs = (int)dIn.length()/Person.REC_SIZE;
			
			if (numRecs >= recordNumber){
				
				dIn.seek((recordNumber-1) * Person.REC_SIZE);
				
				// read the data
				String firstName = readChar(dIn, Person.FIRSTNAME_SIZE);
				String lastName = readChar(dIn, Person.LASTNAME_SIZE);
				String phone = readChar(dIn, Person.PHONE_SIZE);
				int age = dIn.readInt();
				
				// create and return a Person
				Person person = new Person();
				person.setFirstName(firstName);
				person.setLastName(lastName);
				person.setPhone(phone);
				person.setAge(age);
				
				return person;
			}
			else
				throw new IOException("Invalid record number");
		}
		
	}
	
	private static String readChar(RandomAccessFile dIn, int size) throws IOException {
		
		
		StringBuilder strb = new StringBuilder();
		
		for (int i=0; i < size; i++) {
			char ch = dIn.readChar();
			System.out.println(i + " " +  ch);
			strb.append(ch);
		}
		
		return strb.toString().trim();
		
		
	}

		
	

}
