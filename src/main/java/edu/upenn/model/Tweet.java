package edu.upenn.model;

public final class Tweet {
	private final Double latitude;
	private final Double longitude;
	private final String text;
	public Tweet(final Double latitude, final Double longitude, final String text) {
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

}
