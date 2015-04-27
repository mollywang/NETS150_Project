package edu.upenn.model;


import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import edu.upenn.fileIO.CSVFileReader;
import edu.upenn.main.Euclidean;

/**
 * 
 * @author MollyWang
 * State object
 */
public class State {

	private String name;
	private Double longitude;
	private Double latitude;
	private Set<Tweet> tweets; //Every state has a set of tweets that originated from the state

	public State(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
		String name = findStateName(longitude, latitude);
		this.name = name;
	}

	public State(String name, double longitude, double latitude) {
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public State(String name, double longitude, double latitude, Set<Tweet> tweets) {
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.tweets = tweets;
	}

	public String getName() {
		return name;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setTweets(Set<Tweet> t) {
		this.tweets = t;
	}

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public Integer numTweetsInState() {
		return tweets.size();
	}

	private String findStateName(double longitude, double latitude) {

		Double dist = null;
		double minDist = 99999999999999999999.0;
		String state = "";
		State stt = null;
		Tweet tweet = null;

		for (State s : CSVFileReader.states) { //traverse through every single state 
			//initialize the HashMap
			dist = Euclidean.calculateEuclidean(longitude, latitude, s.getLongitude(), s.getLatitude());
			if (dist < minDist) {
				minDist = dist;
				state = s.getName();
				stt = s; //keep overwriting stt until you find the state that the tweet belongs in
			}
		}
		return stt.name; 
	}

	@Override
	// used for easier testing
	public String toString() {
		return name;
	}

	public boolean equals(String t) {
		return (t.toString().equals(name));
	}

}

