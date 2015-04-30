package edu.upenn.fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import edu.upenn.model.State;

/**
 * 
 * @author MollyWang
 * This reads in the states.csv file to parse and store data about the coordinates for each state
 */
public class CSVFileReader {
	private static final String file = "res/geo/states.csv";
	private static volatile CSVFileReader INSTANCE = null;
	private Set<State> states; 

	public static CSVFileReader getInstance() {
		if (INSTANCE == null) {
			synchronized (CSVFileReader.class) {
				if (INSTANCE == null) {
					INSTANCE = new CSVFileReader();
				}
			}
		}
		return INSTANCE;
	}
	private  CSVFileReader() {
		states = new HashSet<State>();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(file));
		} 
		catch (FileNotFoundException e) { }
		scanner.useDelimiter(",|\\n");

		while(scanner.hasNext()) {
			String name = scanner.next();
			Double longitude = Double.parseDouble(scanner.next());
			Double latitude = Double.parseDouble(scanner.next());
			State temp = new State(name, longitude, latitude);
			states.add(temp);
		}
		scanner.close();
	}
	
	public Set<State> getStates() {
		return states;
	}

}



