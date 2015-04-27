package edu.upenn.fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public static Set<State> states; 
	public static Set<State> CSVFR(String file) {

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
		return states;

		/*
		 * PRINT TEST
		 * 
		for (State s : states) {
			System.out.println(s.getName() + " " + s.getLongitude() + " " + s.getLatitude());
		}
		 */

	}

}



