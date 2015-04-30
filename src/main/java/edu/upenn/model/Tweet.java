package edu.upenn.model;

public final class Tweet {
	private final Double latitude;
	private final Double longitude;
	private final String text;
	private State state;

	public Tweet(final Double longitude, final Double latitude,
			final String text) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.text = text;
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

	public void setState(State state) {
		this.state = state;
	}

}
