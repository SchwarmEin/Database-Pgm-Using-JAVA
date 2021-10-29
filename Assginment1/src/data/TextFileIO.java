package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import business.CovidStats;

public class TextFileIO {
	private static File myFile = new File("covidData.txt");
	
	
	public static void writeData(CovidStats covid) throws IOException {	
		try (PrintWriter writer = new PrintWriter(new FileWriter(myFile, true))){
			String newRecordData = covid.getDate() + "," + covid.getCity() + "," + covid.getNumCase() + 
					"," + covid.getNumDeath() + "," + covid.getNumRec();
			writer.println(newRecordData);		
		}	
	}
	
	public static String[][] readDataAll(String searchData) throws IOException {
		
		Scanner scanner = new Scanner(myFile);
		ArrayList<String[]> records = new ArrayList<String[]>();
		
		// total for cases, 
		int cases = 0;
		int deaths = 0;
		int recovered = 0;
		
		while(scanner.hasNext()) {
			String[] recordData = scanner.nextLine().split(",");
			records.add(recordData);	
			
			cases += Integer.parseInt(recordData[2]);
			deaths += Integer.parseInt(recordData[3]);
			recovered += Integer.parseInt(recordData[4]);
		}
		records.add(new String[]{"Total", "", String.valueOf(cases), String.valueOf(deaths), String.valueOf(recovered)});
		scanner.close();
		return records.toArray(new String[0][0]);	
	}
	
	public static String[][] readDataByDate(String searchData) throws IOException {
		
		Scanner scanner = new Scanner(myFile);
		ArrayList<String[]> records = new ArrayList<String[]>();
		
		// total
		int cases = 0;
		
		int deaths = 0;
		int recovered = 0;

		while (scanner.hasNext()) {
			String[] recordData = scanner.nextLine().split(",");

			if(recordData[0].contains(searchData)) {
				records.add(recordData);
				
				cases += Integer.parseInt(recordData[2]);
				deaths += Integer.parseInt(recordData[3]);
				recovered += Integer.parseInt(recordData[4]);
			}
		}
		
		records.add(new String[]{"Total", "", String.valueOf(cases), String.valueOf(deaths), String.valueOf(recovered)});
		scanner.close();
		return records.toArray(new String[0][0]);	
	}
	
	public static String[][] readDataByCity(String searchData) throws IOException {
		
		Scanner scanner = new Scanner(myFile);
		ArrayList<String[]> records = new ArrayList<String[]>();
		
		// total
		int cases = 0;
		int deaths = 0;
		int recovered = 0;

		while (scanner.hasNext()) {
			String[] recordData = scanner.nextLine().split(",");

			if(recordData[1].contains(searchData)) {
				records.add(recordData);
				
				cases += Integer.parseInt(recordData[2]);
				deaths += Integer.parseInt(recordData[3]);
				recovered += Integer.parseInt(recordData[4]);
			}
		}
		
		records.add(new String[]{"Total", "", String.valueOf(cases), String.valueOf(deaths), String.valueOf(recovered)});
		scanner.close();
		return records.toArray(new String[0][0]);	
	}

}
