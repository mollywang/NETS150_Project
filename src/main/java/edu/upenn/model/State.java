package edu.upenn.model;



/**
 * 
 * @author MollyWang
 * State object
 */
public class State {

	private final String name;
	private final Double longitude;
	private final Double latitude;

	public State(String name, double longitude, double latitude) {
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
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


	@Override
	public String toString() {
		return name;
	}

	public boolean equals(String t) {
		return (t.toString().equals(name));
	}

}

