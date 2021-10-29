package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class TextFileIO {
	
	private static File myFile = new File("ProgramList.txt");
	

	/**
	 * 
	 * Reads the contents of ProgramList.txt
	 * 
	 * @return the read contents in a string list
	 * @throws IOException
	 */
	public static String[] readProgramList() throws IOException {
		Scanner scanner = new Scanner(myFile);
		
		ArrayList<String> programs = new ArrayList<String>();
		
		
		while(scanner.hasNext()) {
			String program = scanner.nextLine();
			
			programs.add(program);
		}
		
		scanner.close();
		return programs.toArray(new String[0]);
		
	}

}