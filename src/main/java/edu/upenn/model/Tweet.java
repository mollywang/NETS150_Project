package edu.upenn.model;

public final class Tweet {
	private final Double latitude;
	private final Double longitude;
	private final String text;
	private final State state;
	
	public Tweet(final Double longitude, final Double latitude, final String text) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.text = text;
		state = new State(longitude, latitude); //will find state of origination
	}
	public Double getLatitude() {
		return latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public String getText() {
		return text;
	}
	
	public State getState() {
		return state;
	}
	

}
