package edu.upenn.service;

import java.util.Set;

import edu.upenn.fileIO.CSVFileReader;
import edu.upenn.model.State;
import edu.upenn.model.Tweet;

/**
 * Find out which state a tweet originated from by calcuating Euclidean distance
 */
public class StateManager {
	private final Set<State> states;
	public StateManager() {
		this.states = CSVFileReader.getInstance().getStates();
	}
	public State findStateForTweet(Tweet t){
	
		Double dist = null;
		double minDist = 99999999999999999999.0;
		State stt = null;

		for (State s : states) { 
			dist = calculateEuclidean(t.getLongitude(), t.getLatitude(), s.getLongitude(), s.getLatitude());
			if (dist < minDist) {
				minDist = dist;
				stt = s; //keep overwriting stt until you find the state that the tweet belongs in
			}
		}
		return stt; 
	}
	
	private double calculateEuclidean(Double x1, Double y1, Double x2, Double y2) {

		double  xDiff = x1 - x2;
		double  xSqr = Math.pow(xDiff, 2);
		double yDiff = y1 - y2;
		double ySqr = Math.pow(yDiff, 2);

		double output = Math.sqrt(xSqr + ySqr);

		return output;
	}
	public Set<State> getStates() {
		return states;
	}
}
