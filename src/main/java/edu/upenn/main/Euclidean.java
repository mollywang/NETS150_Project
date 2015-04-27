package edu.upenn.main;

public class Euclidean {

	public static double calculateEuclidean(Double x1, Double y1, Double x2, Double y2) {

		double  xDiff = x1 - x2;
		double  xSqr = Math.pow(xDiff, 2);
		double yDiff = y1 - y2;
		double ySqr = Math.pow(yDiff, 2);

		double output = Math.sqrt(xSqr + ySqr);

		return output;
	}
}

